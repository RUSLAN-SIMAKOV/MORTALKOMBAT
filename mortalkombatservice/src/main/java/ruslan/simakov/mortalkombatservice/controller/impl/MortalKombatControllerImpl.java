package ruslan.simakov.mortalkombatservice.controller.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
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

    @GetMapping("chooseyourdestiny")
    @HystrixCommand(defaultFallback = "getFallbackPath")
    public List<Path> getFightingPaths() {

        ChanceVO chance = getChance();

        FighterInfoVO fighterInfo = getFighterInfo();

        return Collections.singletonList(new Path(fighterInfo.getId(), fighterInfo.getName(), chance.getWinChance()));
    }

    @HystrixCommand(defaultFallback = "getFallbackFighterInfo")
    private FighterInfoVO getFighterInfo() {
        return restTemplate.getForObject(
                "https://mortal-komabat-info-service/getFighterInfo/1",
                FighterInfoVO.class);
    }

    @HystrixCommand(defaultFallback = "getFallbackChance")
    private ChanceVO getChance() {
        return restTemplate.getForObject(
                "https://kombat-chances-service/getchance",
                ChanceVO.class);
    }

    private FighterInfoVO getFallbackFighterInfo() {
        return new FighterInfoVO(1, "NONAME");
    }

    private ChanceVO getFallbackChance() {
        return new ChanceVO(0,0.0);
    }
}

/*
    @Autowired
    private WebClient.Builder webClientBuilder;

    ChanceVO chance = webClientBuilder.build()
                .get()
                .uri("http://kombat-chances-service/getchance")
                .retrieve()
                .bodyToMono(ChanceVO.class)
                .block(); 
*/
