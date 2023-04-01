package com.aorri2.goodsforyou.transaction.application;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aorri2.goodsforyou.transaction.domain.RegisterTransactionPolicy;
import com.aorri2.goodsforyou.transaction.domain.Transaction;
import com.aorri2.goodsforyou.transaction.domain.TransactionValidator;

@Component
public class RegisterTransactionValidator implements TransactionValidator {

	private final List<RegisterTransactionPolicy> registerTransactionPolicyList;

	public RegisterTransactionValidator(List<RegisterTransactionPolicy> registerTransactionPolicyList) {
		this.registerTransactionPolicyList = registerTransactionPolicyList;
	}

	@Override
	public void checkRegisterValidity(Transaction transaction) {
		registerTransactionPolicyList.forEach(policy -> policy.apply(transaction));
	}
}
