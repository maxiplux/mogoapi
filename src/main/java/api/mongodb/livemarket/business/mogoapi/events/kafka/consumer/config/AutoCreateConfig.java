package api.mongodb.livemarket.business.mogoapi.events.kafka.consumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@EnableKafka
public class AutoCreateConfig {

	@Bean
	public NewTopic depositEvents() {
		return TopicBuilder.name("transaction-events")
				.partitions(3)
				.replicas(1)
				.build();
	}
	
}
