package ruslan.simakov.mortalkombatservice.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ruslan.simakov.mortalkombatservice.model.FighterInfoVO;
import ruslan.simakov.mortalkombatservice.service.FighterInfoFallbackService;

@Service
public class FighterInfoFallbackServiceImpl implements FighterInfoFallbackService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url-mortal-komabat-info-service}")
    private String urlMortalKombatInfoService;

    @HystrixCommand(
            defaultFallback = "getFallbackFighterInfo",
            threadPoolKey = "fighterInfoPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            }
    )
    public FighterInfoVO getFighterInfo() {
        return restTemplate.getForObject(
                urlMortalKombatInfoService,
                FighterInfoVO.class);
    }

    private FighterInfoVO getFallbackFighterInfo() {
        return new FighterInfoVO(1, "NONAME");
    }
}
