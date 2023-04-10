package com.aorri2.goodsforyou.trade.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aorri2.goodsforyou.trade.application.TradeManagement;
import com.aorri2.goodsforyou.trade.presentation.request.CreateTradeRequest;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class TradeController {

	private final TradeManagement tradeManagement;

	public TradeController(TradeManagement tradeManagement) {
		this.tradeManagement = tradeManagement;
	}

	@PostMapping("/trade")
	@ResponseStatus(HttpStatus.CREATED)
	public void createTrade(@RequestBody @Valid CreateTradeRequest request) {
		log.info("Request : Create Trade - {}", request);
		tradeManagement.registerTrade(request.toCommand());
	}
}
