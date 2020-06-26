package api.mongodb.livemarket.business.mogoapi.services.impl;

import api.mongodb.livemarket.business.mogoapi.models.Transaction;
import api.mongodb.livemarket.business.mogoapi.services.TransactionEvents;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TransactionEventsImpl implements TransactionEvents {

	@Autowired
    ObjectMapper objectMapper ;
	private Logger log =LoggerFactory.getLogger(TransactionEventsImpl.class);

	@Override
	public void processTransactionEvent(ConsumerRecord<Integer,String> consumerRecord) throws JsonMappingException, JsonProcessingException {
		
		double newmonto=0;

		Transaction transactionEvent= objectMapper.readValue(consumerRecord.value(), Transaction.class);
		log.info("transactionEvent:{}",transactionEvent.getAccountId());

		
//		switch(transactionEvent.getType()) {
//		case "deposito":
//			newmonto=objAccount.getTotalAmount() + transactionEvent.getAmount();
//			break;
//		case "retiro":
//			newmonto=objAccount.getTotalAmount() - transactionEvent.getAmount();
//			break ;
//		}
		

		
		
		
	}
	
	
}
