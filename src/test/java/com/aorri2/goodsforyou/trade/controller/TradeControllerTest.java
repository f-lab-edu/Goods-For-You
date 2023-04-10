package com.aorri2.goodsforyou.trade.controller;

import static org.junit.jupiter.api.Named.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.aorri2.goodsforyou.trade.application.TradeManagement;
import com.aorri2.goodsforyou.trade.application.command.CreateTradeCommand;
import com.aorri2.goodsforyou.trade.domain.exception.AlreadySoldProductException;
import com.aorri2.goodsforyou.trade.presentation.TradeController;
import com.aorri2.goodsforyou.trade.presentation.advice.TradeControllerAdvice;
import com.aorri2.goodsforyou.trade.presentation.request.CreateTradeRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@DisplayName("TradeController 클래스")
@WebMvcTest({TradeController.class, TradeControllerAdvice.class})
public class TradeControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	TradeManagement tradeManagement;

	@Autowired
	ObjectMapper objectMapper;

	@MockBean
	private TradeController tradeController;

	@Nested
	@DisplayName("createTrade 메서드는")
	class Describe_createTrade {

		@Nested
		@DisplayName("유효한 거래 요청정보가 주어진다면")
		class Context_with_valid_tradeRequest {
			@Test
			@DisplayName("정상적으로 거래를 등록하고 상태코드200을 반환한다")
			void it_register_trade_and_return_status_code_200() throws Exception {
				willDoNothing().given(tradeManagement).registerTrade(mock(CreateTradeCommand.class));

				CreateTradeRequest createTradeRequest = new CreateTradeRequest(1L, 2L, 1L,
					LocalDateTime.now().plusDays(1L),
					10);
				String requestBody = objectMapper.writeValueAsString(createTradeRequest);

				mockMvc.perform(post("/api/v1/trade")
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestBody))
					.andDo(print())
					.andExpect(status().isCreated());
			}
		}

		@Nested
		@DisplayName("유효하지 않은 거래 요청정보가 주어진다면")
		class Context_with_inValid_tradeRequest {
			@ParameterizedTest(name = "잘못된 거래 요청 정보 : {0} ")
			@MethodSource("invalidTradeRequestParameter")
			@DisplayName("거래 등록에 실패하고 상태코드 400을 반환한다")
			void it_register_trade_and_return_status_code_400(CreateTradeRequest createTradeRequest) throws Exception {
				willDoNothing().given(tradeManagement).registerTrade(mock(CreateTradeCommand.class));

				String requestBody = objectMapper.writeValueAsString(createTradeRequest);

				mockMvc.perform(post("/api/v1/trade")
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestBody))
					.andDo(print())
					.andExpect(status().isBadRequest());
			}

			private static Stream<Arguments> invalidTradeRequestParameter() {

				return Stream.of(
					Arguments.of(named("구매자 아이디가 0인 경우", new CreateTradeRequest(0L, 2L, 1L,
						LocalDateTime.now().plusDays(1L),
						10))),
					Arguments.of(named("구매자 아이디가 null인 경우", new CreateTradeRequest(null, 2L, 1L,
						LocalDateTime.now().plusDays(1L),
						10))),
					Arguments.of(named("판매자 아이디가 0인 경우", new CreateTradeRequest(1L, 0L, 1L,
						LocalDateTime.now().plusDays(1L),
						10))),
					Arguments.of(named("판매자 아이디가 null인 경우", new CreateTradeRequest(1L, null, 1L,
						LocalDateTime.now().plusDays(1L),
						10))),
					Arguments.of(named("상품 아이디가 0인 경우", new CreateTradeRequest(1L, 2L, 0L,
						LocalDateTime.now().plusDays(1L),
						10))),
					Arguments.of(named("상품 아이디가 null인 경우", new CreateTradeRequest(1L, 2L, null,
						LocalDateTime.now().plusDays(1L),
						10))),
					Arguments.of(named("거래 일자가 현재보다 과거인 경우", new CreateTradeRequest(1L, 2L, 1L,
						LocalDateTime.now().minusNanos(1L), 10))),
					Arguments.of(named("거래 일자가 null인 경우", new CreateTradeRequest(1L, 2L, 1L,
						null, 10))),
					Arguments.of(named("상품 수량이 0인 경우", new CreateTradeRequest(1L, 2L, 1L,
						LocalDateTime.now().plusDays(1L), 0)))

				);
			}
		}

		@Nested
		@DisplayName("거래 불가능한 상품을 거래 요청하려 한다면")
		class Context_with_cannot_purchase_productStatus_in_tradeRequest {

			@BeforeEach
			void setUp() {
				mockMvc = MockMvcBuilders.standaloneSetup(tradeController)
					.setControllerAdvice(new TradeControllerAdvice())
					.build();
			}

			@Test
			@DisplayName("AlreadySoldProductException을 던지고, 상태코드 400과 에러 코드 'TRADE-001'을 반환한다.")
			void it_register_trade_and_return_status_code_200() throws Exception {

				CreateTradeRequest createTradeRequest = CreateTradeRequest.builder()
					.buyerId(1L)
					.sellerId(2L)
					.productId(1L)
					.tradeDate(LocalDateTime.now().plusDays(1L))
					.tradeProductQuantity(10)
					.build();
				willThrow(AlreadySoldProductException.class).given(tradeController).createTrade(any());
				String requestBody = objectMapper.writeValueAsString(createTradeRequest);

				mockMvc.perform(post("/api/v1/trade")
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestBody))
					.andDo(print())
					.andExpect(status().isBadRequest())
					.andExpect(jsonPath("$.code").value("TRADE-001"));
			}
		}

	}
}
