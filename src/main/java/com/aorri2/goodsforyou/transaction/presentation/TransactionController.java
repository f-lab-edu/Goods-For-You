package com.aorri2.goodsforyou.transaction.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aorri2.goodsforyou.transaction.application.TransactionManagement;
import com.aorri2.goodsforyou.transaction.presentation.request.CreateTransactionRequest;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {

	private final TransactionManagement transactionManagement;

	public TransactionController(TransactionManagement transactionManagement) {
		this.transactionManagement = transactionManagement;
	}

	@PostMapping("/transaction")
	@ResponseStatus(HttpStatus.CREATED)
	public void createTransaction(@RequestBody CreateTransactionRequest request) {
		transactionManagement.registerTransaction(request.toCommand());
	}
}
