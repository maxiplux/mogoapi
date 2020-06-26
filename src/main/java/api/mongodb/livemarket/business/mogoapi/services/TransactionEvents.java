package api.mongodb.livemarket.business.mogoapi.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface TransactionEvents {

    void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException;
}
