package com.aorri2.goodsforyou.transaction.application;

import com.aorri2.goodsforyou.transaction.application.command.CreateTransactionCommand;

public interface TransactionManagement {
	void registerTransaction(CreateTransactionCommand createTransactionCommand);
}
