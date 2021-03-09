package ruslan.simakov.mortalkombatservice.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ruslan.simakov.mortalkombatservice.model.ChanceVO;
import ruslan.simakov.mortalkombatservice.model.FighterInfoVO;
import ruslan.simakov.mortalkombatservice.model.Path;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/")
public class MortalKombatControllerImpl {

    @Autowired
    private  RestTemplate restTemplate;

    @GetMapping("chooseyourdestiny")
    public List<Path> getFightingPaths() {

        FighterInfoVO fighterInfo = restTemplate.getForObject("http://localhost:8082/getFighterInfo/1", FighterInfoVO.class);
        ChanceVO chance = restTemplate.getForObject("http://localhost:8083/getchance", ChanceVO.class);

        return Collections.singletonList(new Path(fighterInfo.getId(), fighterInfo.getName(), chance.getWinChance()));
    }
}
