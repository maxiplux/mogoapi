package api.mongodb.livemarket.business.mogoapi.config;

import api.mongodb.livemarket.business.mogoapi.models.AuditModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;


@EnableMongoAuditing(auditorAwareRef="auditorProvider")
@Configuration
public class MongoHelperAudit   {
    @Bean
    AuditorAware<String> auditorProvider() {
        return new AuditModel();
    }


}
