package api.mongodb.livemarket.business.mogoapi.services;

import api.mongodb.livemarket.business.mogoapi.models.Transaction;
import api.mongodb.livemarket.business.mogoapi.repository.TransactionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	private TransactionDao transactionDao;

	
	@Override
	@Transactional(readOnly=true)
	public Transaction findById(String id) {
	    return transactionDao.findById(id).orElse(null);
		
	}

	@Override
	@Transactional
	public Transaction save(Transaction transaction) {
		// TODO Auto-generated method stub
		 return transactionDao.save(transaction);
	}





}
