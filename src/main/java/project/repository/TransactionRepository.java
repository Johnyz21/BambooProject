package project.repository;

import org.springframework.data.repository.CrudRepository;

import project.entity.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
	
}
