package com.aorri2.goodsforyou.productimage.application.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.aorri2.goodsforyou.product.application.ProductManagement;
import com.aorri2.goodsforyou.product.domain.Product;
import com.aorri2.goodsforyou.productimage.application.ProductImageFileUploadManagement;
import com.aorri2.goodsforyou.productimage.domain.ProductImage;
import com.aorri2.goodsforyou.productimage.domain.ProductImageCreator;
import com.aorri2.goodsforyou.productimage.infrastructure.storage.StorageService;
import com.aorri2.goodsforyou.productimage.util.FileUtils;

@Service
public class ProductImageFileUploadManagementFacade implements ProductImageFileUploadManagement {

	private final StorageService storageService;
	private final ProductManagement productManagement;
	private final ProductImageCreator imageCreator;

	public ProductImageFileUploadManagementFacade(StorageService storageService, ProductManagement productManagement,
		ProductImageCreator imageCreator) {
		this.storageService = storageService;
		this.productManagement = productManagement;
		this.imageCreator = imageCreator;
	}

	@Override
	@Transactional
	public void upload(Long postId, List<MultipartFile> files) {
		Product foundProduct = productManagement.retriveProduct(postId);
		uploadDelegator(foundProduct.getId(), files);
	}

	private void uploadDelegator(Long postId, List<MultipartFile> files) {
		List<ProductImage> images = uploadImagesToObjectStorageServer(postId, files);
		imageCreator.saveAll(images);
	}

	private List<ProductImage> uploadImagesToObjectStorageServer(Long postId, List<MultipartFile> files) {
		List<ProductImage> images = new ArrayList<>();

		for (MultipartFile file : files) {
			String storedFileName = FileUtils.getRandomFileName();
			String filePath = storageService.upload(file, storedFileName);
			images.add(ProductImage.builder()
				.productId(postId)
				.name(storedFileName)
				.url(filePath)
				.build());
		}
		return images;
	}
}
