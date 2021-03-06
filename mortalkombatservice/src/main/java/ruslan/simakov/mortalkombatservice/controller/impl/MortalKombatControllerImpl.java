package ruslan.simakov.mortalkombatservice.controller.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ruslan.simakov.mortalkombatservice.model.ChanceVO;
import ruslan.simakov.mortalkombatservice.model.FighterInfoVO;
import ruslan.simakov.mortalkombatservice.model.Path;
import ruslan.simakov.mortalkombatservice.service.ChanceFallbackService;
import ruslan.simakov.mortalkombatservice.service.FighterInfoFallbackService;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/")
public class MortalKombatControllerImpl {

    @Autowired
    private ChanceFallbackService chanceFallbackService;
    @Autowired
    private FighterInfoFallbackService fighterInfoFallbackService;
    @Autowired
    private Environment environment;

    @GetMapping("chooseyourdestiny")
    public List<Path> getFightingPaths() {
        ChanceVO chance = chanceFallbackService.getChance();
        FighterInfoVO fighterInfo = fighterInfoFallbackService.getFighterInfo();
        return Collections.singletonList(new Path(fighterInfo.getId(), fighterInfo.getName(), chance.getWinChance()));
    }

    @GetMapping("environment")
    public String getEnvironment() {
        return environment.toString();
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
