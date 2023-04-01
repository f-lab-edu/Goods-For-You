package com.aorri2.goodsforyou.transaction.service;

import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.aorri2.goodsforyou.transaction.application.TransactionManagementFacade;
import com.aorri2.goodsforyou.transaction.application.command.CreateTransactionCommand;
import com.aorri2.goodsforyou.transaction.domain.Transaction;
import com.aorri2.goodsforyou.transaction.domain.TransactionCreator;
import com.aorri2.goodsforyou.transaction.domain.TransactionValidator;

@DisplayName("TransactionManagementFacade클래스")
public class TransactionManagementFacadeTest {
	@Nested
	@DisplayName("registerTransaction 메서드는")
	class Describe_registerTransaction {

		@InjectMocks
		TransactionManagementFacade transactionManagementFacade;

		@Mock
		TransactionValidator transactionValidator;

		@Mock
		TransactionCreator transactionCreator;

		@BeforeEach
		void setUp() {
			MockitoAnnotations.openMocks(this);
		}

		@Nested
		@DisplayName("유효한 거래 정보가 주어지면")
		class Context_with_valid_transaction_request_information {
			@Test
			@DisplayName("거래 정보 유효성 검증을 먼저 진행한 뒤, 거래 정보를 저장한다")
			void it_perform_After_validating_transaction_then_transaction_information_is_saved() {

				CreateTransactionCommand createTransactionCommand = mock(CreateTransactionCommand.class);
				Transaction transaction = createTransactionCommand.toEntity();

				willDoNothing().given(transactionValidator).checkRegisterValidity(transaction);
				willDoNothing().given(transactionCreator).save(transaction);

				transactionManagementFacade.registerTransaction(createTransactionCommand);

				InOrder inOrder = inOrder(transactionValidator, transactionCreator);

				inOrder.verify(transactionValidator, times(1)).checkRegisterValidity(transaction);
				inOrder.verify(transactionCreator, times(1)).save(transaction);
			}

		}
	}
}
