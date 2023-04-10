package com.aorri2.goodsforyou.product.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aorri2.goodsforyou.product.application.ProductManagement;
import com.aorri2.goodsforyou.product.presentation.request.ProductRequest;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ProductController {

	private final ProductManagement productManagement;

	public ProductController(ProductManagement productManagement) {
		this.productManagement = productManagement;
	}

	@PostMapping("/products")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody @Valid ProductRequest request) {

		log.info("Request : Create Product - {}", request);
		productManagement.addProduct(request.toCommand());
	}
}
