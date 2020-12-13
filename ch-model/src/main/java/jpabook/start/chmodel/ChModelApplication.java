package jpabook.start.chmodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ChModelApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChModelApplication.class, args);
    }

}
