package com.aorri2.goodsforyou.transaction.application.command;

import java.time.LocalDateTime;

import com.aorri2.goodsforyou.transaction.domain.Transaction;

public class CreateTransactionCommand {
	private Long buyerId;
	private Long sellerId;
	private Long productId;
	private LocalDateTime transactionDate;
	private int transactionProductQuantity;

	public CreateTransactionCommand(Long buyerId, Long sellerId, Long productId, LocalDateTime transactionDate,
		int transactionProductQuantity) {
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.productId = productId;
		this.transactionDate = transactionDate;
		this.transactionProductQuantity = transactionProductQuantity;
	}

	public Transaction toEntity() {
		return new Transaction(
			this.buyerId,
			this.sellerId,
			this.productId,
			this.transactionDate,
			this.transactionProductQuantity
		);
	}
}
