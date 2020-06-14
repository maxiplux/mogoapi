package api.mongodb.livemarket.business.mogoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class MogoapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MogoapiApplication.class, args);
    }

}
