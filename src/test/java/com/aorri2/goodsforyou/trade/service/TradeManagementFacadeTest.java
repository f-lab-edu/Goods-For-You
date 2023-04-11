package com.aorri2.goodsforyou.trade.service;

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

import com.aorri2.goodsforyou.trade.application.TradeManagementFacade;
import com.aorri2.goodsforyou.trade.application.command.CreateTradeCommand;
import com.aorri2.goodsforyou.trade.domain.Trade;
import com.aorri2.goodsforyou.trade.domain.TradeCreator;
import com.aorri2.goodsforyou.trade.domain.TradeValidator;
import com.aorri2.goodsforyou.trade.domain.exception.AlreadySoldProductException;

@DisplayName("TradeManagementFacade클래스")
public class TradeManagementFacadeTest {
	@Nested
	@DisplayName("registerTrade 메서드는")
	class Describe_registerTrade {

		@InjectMocks
		TradeManagementFacade tradeManagementFacade;

		@Mock
		TradeValidator tradeValidator;

		@Mock
		TradeCreator tradeCreator;

		@BeforeEach
		void setUp() {
			MockitoAnnotations.openMocks(this);
		}

		@Nested
		@DisplayName("유효한 거래 정보가 주어지면")
		class Context_with_valid_transaction_request_information {
			@Test
			@DisplayName("거래 정보 유효성 검증을 먼저 진행한 뒤, 거래 정보를 저장한다")
			void it_perform_After_validating_trade_then_trade_information_is_saved() {

				CreateTradeCommand createTradeCommand = mock(CreateTradeCommand.class);
				Trade trade = createTradeCommand.toEntity();

				willDoNothing().given(tradeValidator).checkRegisterValidity(trade);
				willDoNothing().given(tradeCreator).save(trade);

				tradeManagementFacade.registerTrade(createTradeCommand);

				InOrder inOrder = inOrder(tradeValidator, tradeCreator);
				then(tradeValidator).should(inOrder, times(1)).checkRegisterValidity(trade);
				then(tradeCreator).should(inOrder, times(1)).save(trade);
			}

		}

		@Nested
		@DisplayName("유효하지 않은 거래 정보가 주어지면")
		class Context_with_invalid_trade_request_information {
			@Test
			@DisplayName("AlreadySoldProductException을 던지며, save메서드가 호출되지 않는다.")
			void it_throws_UnAvailableProductException_and_not_execute_save_method() {

				CreateTradeCommand createTradeCommand = mock(CreateTradeCommand.class);
				Trade trade = createTradeCommand.toEntity();

				willThrow(AlreadySoldProductException.class).given(tradeValidator)
					.checkRegisterValidity(trade);
				willDoNothing().given(tradeCreator).save(trade);

				assertThatThrownBy(
					() -> tradeManagementFacade.registerTrade(createTradeCommand)
				).isInstanceOf(AlreadySoldProductException.class);

				InOrder inOrder = inOrder(tradeValidator, tradeCreator);
				then(tradeValidator).should(inOrder, times(1)).checkRegisterValidity(trade);
				then(Describe_registerTrade.this.tradeCreator).should(inOrder, never()).save(trade);
			}

		}

	}
}
