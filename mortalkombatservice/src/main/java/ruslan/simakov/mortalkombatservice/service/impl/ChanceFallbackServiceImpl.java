package ruslan.simakov.mortalkombatservice.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ruslan.simakov.mortalkombatservice.model.ChanceVO;
import ruslan.simakov.mortalkombatservice.service.ChanceFallbackService;

@Service
public class ChanceFallbackServiceImpl implements ChanceFallbackService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(defaultFallback = "getFallbackChance")
    public ChanceVO getChance() {
        return restTemplate.getForObject(
                "https://kombat-chances-service/getchance",
                ChanceVO.class);
    }

    private ChanceVO getFallbackChance() {
        return new ChanceVO(0,0.0);
    }
}
