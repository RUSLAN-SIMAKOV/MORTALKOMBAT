package ruslan.simakov.mortalkombatservice.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import ruslan.simakov.mortalkombatservice.model.ChanceVO;
import ruslan.simakov.mortalkombatservice.model.FighterInfoVO;
import ruslan.simakov.mortalkombatservice.model.Path;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/")
public class MortalKombatControllerImpl {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("chooseyourdestiny")
    public List<Path> getFightingPaths() {

        ChanceVO chance = webClientBuilder.build()
                .get()
                .uri("http://localhost:8083/getchance")
                .retrieve()
                .bodyToMono(ChanceVO.class)
                .block();

        FighterInfoVO fighterInfo = restTemplate.getForObject(
                "http://localhost:8082/getFighterInfo/1",
                FighterInfoVO.class);

        return Collections.singletonList(new Path(fighterInfo.getId(), fighterInfo.getName(), chance.getWinChance()));
    }
}
