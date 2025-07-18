package caaiobomfim.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "caaiobomfim")
public class ObserverApplication {
    public static void main(String[] args) {
        SpringApplication.run(ObserverApplication.class, args);
    }
}