package com.aorri2.goodsforyou.product.presentation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aorri2.goodsforyou.common.annotation.LoginCheck;
import com.aorri2.goodsforyou.common.response.CommonApiResponse;
import com.aorri2.goodsforyou.product.application.ProductManagement;
import com.aorri2.goodsforyou.product.domain.Product;
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

	@LoginCheck
	@PostMapping("/products")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody @Valid ProductRequest request) {

		log.info("Request : Create Product - {}", request);
		productManagement.addProduct(request.toCommand());
	}

	@LoginCheck
	@GetMapping("/products")
	@ResponseStatus(HttpStatus.OK)
	public CommonApiResponse<List<Product>> retrieveProduct() { //TODO : noOffset쿼리로 조회 시, request값 필요할 수도 있음
		//TODO : List<Product> -> List<ProductResponse>같은 객체 받도록 변환

		List<Product> products = productManagement.retrieveProducts();

		return CommonApiResponse.success(products);
	}
}
