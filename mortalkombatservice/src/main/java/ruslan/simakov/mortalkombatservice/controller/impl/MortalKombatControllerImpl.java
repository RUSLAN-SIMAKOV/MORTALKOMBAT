package ruslan.simakov.mortalkombatservice.controller.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ruslan.simakov.mortalkombatservice.model.Path;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/")
public class MortalKombatControllerImpl {

    @GetMapping("chooseyourdestiny/")
    public List<Path> getFightingPaths() {
        return Collections.singletonList(new Path(1, "Sonia"));
    }
}
