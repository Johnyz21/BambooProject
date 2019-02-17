package project.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.entity.Transaction;
import project.entity.User;
import project.repository.TransactionRepository;
import project.repository.UserRepository;
import project.service.TransactionService;

@Repository
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void transaction(User from, User to, BigDecimal bambeuros) {
		// TODO Auto-generated method stub
		if( !from.equals(to)) {
			Transaction transaction = new Transaction();
			transaction.setFrom(from.getAccount());
			transaction.setTo(to.getAccount());
			transaction.setBambeuros(bambeuros);
			
			BigDecimal sendersNewBalance = from.getAccount().getBambeuros().subtract(bambeuros) ;
			BigDecimal recieversNewBalance = to.getAccount().getBambeuros().add(bambeuros)  ;
			
			from.getAccount().setBambeuros(sendersNewBalance);
			to.getAccount().setBambeuros(recieversNewBalance);
			
			from.addTransaction(transaction);
			
			transactionRepository.save(transaction);
			userRepository.save(from);
//			userRepository.save(to);
		}
	}
	


}
