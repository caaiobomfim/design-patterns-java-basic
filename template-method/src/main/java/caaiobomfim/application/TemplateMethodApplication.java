package caaiobomfim.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "caaiobomfim")
public class TemplateMethodApplication {
    public static void main(String[] args) {
        SpringApplication.run(TemplateMethodApplication.class, args);
    }
}