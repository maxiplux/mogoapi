package api.mongodb.livemarket.business.mogoapi.events.kafka.producer;

import api.mongodb.livemarket.business.mogoapi.models.Transaction;
import api.mongodb.livemarket.business.mogoapi.services.ITransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Component
public class DepositEventProducer {

	String topic ="transaction-events";
	private Logger log= LoggerFactory.getLogger(DepositEventProducer.class);

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	ObjectMapper objectMapper ;
	@Autowired
	private ITransactionService transactionService;
	
	
	public ListenableFuture<SendResult<String,String>> sendDepositEvent(Transaction transaction) throws JsonProcessingException
	{

		String key = transaction.getId();
        String value = objectMapper.writeValueAsString(transaction);

        ProducerRecord<String,String> producerRecord = buildProducerRecord(key, value, topic);

        ListenableFuture<SendResult<String,String>> listenableFuture =  kafkaTemplate.send(producerRecord);

        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {


			@Override
            public void onFailure(Throwable ex) {
                handleFailure(key, value, ex);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                try {
					System.out.println( "Que paso"+key+ value+ result);
				} catch (Exception e)
				{
					// TODO Auto-generated catch block
					System.out.println( e.getLocalizedMessage() );
				}
            }
        });
        

        return listenableFuture;
    }

	
	
	private ProducerRecord<String, String> buildProducerRecord(String key, String value, String topic) {


		List<Header> recordHeaders = List.of(new RecordHeader("deposit-event-source", "scanner".getBytes()));

		return new ProducerRecord<>(topic, null, key, value, recordHeaders);
	}

	
	
	public SendResult<String, String> sendDepositEventSynchronous(Transaction depositEvent)
			throws JsonProcessingException, ExecutionException, InterruptedException, TimeoutException {

		String key = depositEvent.getId();
		String value = objectMapper.writeValueAsString(depositEvent);
		SendResult<String, String> sendResult = null;
		try {
			sendResult = kafkaTemplate.sendDefault(key, value).get(1, TimeUnit.SECONDS);
		} catch (ExecutionException | InterruptedException e) {
			log.error("ExecutionException/InterruptedException Sending the Message and the exception is {}",
					e.getMessage());
			throw e;
		} catch (Exception e) {
			log.error("Exception Sending the Message and the exception is {}", e.getMessage());
			throw e;
		}

		return sendResult;

	}
	
	
	private void handleFailure(String key, String value, Throwable ex) {
		log.error("Error Sending the Message and the exception is {}", ex.getMessage());
		try {
			throw ex;
		} catch (Throwable throwable) {
			log.error("Error in OnFailure: {}", throwable.getMessage());
		}

	}

	private void handleSuccess(Integer key, String value, SendResult<Integer, String> result) throws JsonMappingException, JsonProcessingException {

		Transaction transactionRedis= objectMapper.readValue(value, Transaction.class);
		//transactionService.save(transactionRedis);
		log.info("Message Sent SuccessFully for the key : {} and the value is {} , partition is {}", key, value,
				result.getRecordMetadata().partition());
	}	
}
