package api.mongodb.livemarket.business.mogoapi.repository;

import api.mongodb.livemarket.business.mogoapi.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TransactionDao extends MongoRepository<Transaction, String> {

}
