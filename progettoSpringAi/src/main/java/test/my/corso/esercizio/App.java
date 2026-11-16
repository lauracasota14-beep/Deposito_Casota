package test.my.corso.esercizio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "controller", "service"
})
@EntityScan("model")
@EnableJpaRepositories("repository")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}