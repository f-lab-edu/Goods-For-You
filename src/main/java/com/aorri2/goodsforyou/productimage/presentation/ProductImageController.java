package com.aorri2.goodsforyou.productimage.presentation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aorri2.goodsforyou.productimage.application.ProductImageFileUploadManagement;

@RestController
@RequestMapping("/api/v1/products")
public class ProductImageController {

	private final ProductImageFileUploadManagement imageFileUploadManagement;

	public ProductImageController(ProductImageFileUploadManagement imageFileUploadManagement) {
		this.imageFileUploadManagement = imageFileUploadManagement;
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PostMapping("/{productId}/images")
	public void uploadImages(@PathVariable Long productId, @RequestParam("file") List<MultipartFile> files) {
		imageFileUploadManagement.upload(productId, files);
	}
}
