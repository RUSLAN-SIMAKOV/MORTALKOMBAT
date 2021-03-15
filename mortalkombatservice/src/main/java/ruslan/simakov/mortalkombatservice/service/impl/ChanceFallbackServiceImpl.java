package ruslan.simakov.mortalkombatservice.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ruslan.simakov.mortalkombatservice.model.ChanceVO;
import ruslan.simakov.mortalkombatservice.service.ChanceFallbackService;

@Service
public class ChanceFallbackServiceImpl implements ChanceFallbackService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url-kombat-chances-service}")
    private String urlKombatChancesService;

    @HystrixCommand(defaultFallback = "getFallbackChance",
            threadPoolKey = "chancePool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            }
    )
    public ChanceVO getChance() {
        return restTemplate.getForObject(
                urlKombatChancesService,
                ChanceVO.class);
    }

    private ChanceVO getFallbackChance() {
        return new ChanceVO(0,0.0);
    }
}
