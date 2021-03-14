package ruslan.simakov.kombatchances.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ruslan.simakov.kombatchances.model.Chance;

import java.util.Random;

@RestController
@RequestMapping("/")
public class KombatChanceController {

    @GetMapping("getchance")
    public Chance getChance() throws InterruptedException {
        long randomSleepService = new Random().nextInt(5000);
        Thread.sleep(randomSleepService);
        return new Chance(1, new Random().nextDouble());
    }
}
