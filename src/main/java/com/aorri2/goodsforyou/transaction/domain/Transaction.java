package com.aorri2.goodsforyou.transaction.domain;

import java.time.LocalDateTime;

public class Transaction {

	private Long id;
	private Long buyerId;
	private Long sellerId;
	private Long productId;
	private LocalDateTime transactionDate;
	private TransactionStatus transactionStatus;
	private int transactionProductQuantity;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	protected Transaction() {
	}

	public Transaction(Long buyerId, Long sellerId, Long productId, LocalDateTime transactionDate,
		int transactionProductQuantity) {
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.productId = productId;
		this.transactionDate = transactionDate;
		this.transactionStatus = TransactionStatus.BEFORE_TRANSACTION;
		this.transactionProductQuantity = transactionProductQuantity;
	}

	public Long getProductId() {
		return productId;
	}
}
