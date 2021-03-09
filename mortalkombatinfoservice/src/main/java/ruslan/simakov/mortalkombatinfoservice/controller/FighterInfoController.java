package ruslan.simakov.mortalkombatinfoservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ruslan.simakov.mortalkombatinfoservice.model.FighterInfo;

@RestController
@RequestMapping("/")
public class FighterInfoController {

    @GetMapping("getFighterInfo/{figtherid}")
    public FighterInfo getFighterInfo(@PathVariable String figtherid) {
        return new FighterInfo(1, "Sonya");
    }
}
