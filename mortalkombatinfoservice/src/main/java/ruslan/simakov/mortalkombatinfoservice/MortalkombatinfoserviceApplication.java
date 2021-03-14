package ruslan.simakov.mortalkombatinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MortalkombatinfoserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MortalkombatinfoserviceApplication.class, args);
    }

}
