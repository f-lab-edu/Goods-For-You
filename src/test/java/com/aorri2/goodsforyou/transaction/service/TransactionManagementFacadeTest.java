package com.aorri2.goodsforyou.transaction.service;

import static org.assertj.core.api.Assertions.*;
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
import com.aorri2.goodsforyou.transaction.domain.exception.AlreadySoldProductException;

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
				then(transactionValidator).should(inOrder, times(1)).checkRegisterValidity(transaction);
				then(transactionCreator).should(inOrder, times(1)).save(transaction);
			}

		}

		@Nested
		@DisplayName("유효하지 않은 거래 정보가 주어지면")
		class Context_with_invalid_transaction_request_information {
			@Test
			@DisplayName("AlreadySoldProductException을 던지며, save메서드가 호출되지 않는다.")
			void it_throws_UnAvailableProductException_and_not_execute_save_method() {

				CreateTransactionCommand createTransactionCommand = mock(CreateTransactionCommand.class);
				Transaction transaction = createTransactionCommand.toEntity();

				willThrow(AlreadySoldProductException.class).given(transactionValidator)
					.checkRegisterValidity(transaction);
				willDoNothing().given(transactionCreator).save(transaction);

				assertThatThrownBy(
					() -> transactionManagementFacade.registerTransaction(createTransactionCommand)
				).isInstanceOf(AlreadySoldProductException.class);

				InOrder inOrder = inOrder(transactionValidator, transactionCreator);
				then(transactionValidator).should(inOrder, times(1)).checkRegisterValidity(transaction);
				then(Describe_registerTransaction.this.transactionCreator).should(inOrder, never()).save(transaction);
			}

		}

	}
}
