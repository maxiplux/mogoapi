package api.mongodb.livemarket.business.mogoapi.services;

import api.mongodb.livemarket.business.mogoapi.models.Transaction;



public interface ITransactionService {

	public Transaction findById(String id);
	public Transaction save(Transaction transaction);
	


}
