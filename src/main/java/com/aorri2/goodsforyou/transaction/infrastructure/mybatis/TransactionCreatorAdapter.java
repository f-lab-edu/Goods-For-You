package com.aorri2.goodsforyou.transaction.infrastructure.mybatis;

import org.springframework.stereotype.Repository;

import com.aorri2.goodsforyou.transaction.domain.Transaction;
import com.aorri2.goodsforyou.transaction.domain.TransactionCreator;

@Repository
public class TransactionCreatorAdapter implements TransactionCreator {

	private final MybatisTransactionMapper mapper;

	public TransactionCreatorAdapter(MybatisTransactionMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public void save(Transaction transaction) {
		mapper.save(transaction);
	}
}
