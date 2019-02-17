package project.service;

import java.math.BigDecimal;

import project.entity.User;

public interface TransactionService {

	public void transaction(User from, User to,BigDecimal bambeuros);
}
