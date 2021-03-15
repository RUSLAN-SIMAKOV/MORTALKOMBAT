package ruslan.simakov.mortalkombatservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("url")
public class UrlService {

    private String kombatChancesService;
    private String mortalKomabatInfoService;

    public String getKombatChancesService() {
        return kombatChancesService;
    }

    public void setKombatChancesService(String kombatChancesService) {
        this.kombatChancesService = kombatChancesService;
    }

    public String getMortalKomabatInfoService() {
        return mortalKomabatInfoService;
    }

    public void setMortalKomabatInfoService(String mortalKomabatInfoService) {
        this.mortalKomabatInfoService = mortalKomabatInfoService;
    }
}
