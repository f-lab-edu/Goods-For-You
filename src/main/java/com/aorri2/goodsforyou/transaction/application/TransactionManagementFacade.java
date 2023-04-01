package com.aorri2.goodsforyou.transaction.application;

import org.springframework.stereotype.Service;

import com.aorri2.goodsforyou.transaction.application.command.CreateTransactionCommand;
import com.aorri2.goodsforyou.transaction.domain.TransactionCreator;
import com.aorri2.goodsforyou.transaction.domain.TransactionValidator;

@Service
public class TransactionManagementFacade implements TransactionManagement {

	private final TransactionValidator transactionValidator;
	private final TransactionCreator transactionCreator;

	public TransactionManagementFacade(TransactionValidator transactionValidator,
		TransactionCreator transactionCreator) {
		this.transactionValidator = transactionValidator;
		this.transactionCreator = transactionCreator;
	}

	@Override
	public void registerTransaction(CreateTransactionCommand createTransactionCommand) {
		transactionValidator.checkRegisterValidity(createTransactionCommand.toEntity());
		transactionCreator.save(createTransactionCommand.toEntity());
	}
}
