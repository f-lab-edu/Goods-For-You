package com.aorri2.goodsforyou.transaction.domain;

import java.time.LocalDateTime;

public class Transaction {

	private Long id;
	private Long buyer_id;
	private Long seller_id;
	private Long product_id;
	private LocalDateTime transaction_date;
	private TransactionStatus transaction_status;
	private int transaction_product_quantity;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;

	protected Transaction() {
	}

	public Transaction(Long buyer_id, Long seller_id, Long product_id, LocalDateTime transaction_date,
		int transaction_product_quantity) {
		this.buyer_id = buyer_id;
		this.seller_id = seller_id;
		this.product_id = product_id;
		this.transaction_date = transaction_date;
		this.transaction_status = TransactionStatus.BEFORE_TRANSACTION;
		this.transaction_product_quantity = transaction_product_quantity;
	}
}
