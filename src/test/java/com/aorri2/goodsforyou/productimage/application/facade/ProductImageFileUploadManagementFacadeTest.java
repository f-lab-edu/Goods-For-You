package com.aorri2.goodsforyou.productimage.application.facade;

import static org.mockito.BDDMockito.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.aorri2.goodsforyou.product.application.ProductManagement;
import com.aorri2.goodsforyou.product.domain.Product;
import com.aorri2.goodsforyou.productimage.domain.ProductImageCreator;
import com.aorri2.goodsforyou.productimage.infrastructure.storage.StorageService;

class ProductImageFileUploadManagementFacadeTest {

	@Mock
	private StorageService storageService;
	@Mock
	private ProductManagement productManagement;
	@Mock
	private ProductImageCreator imageCreator;
	@InjectMocks
	ProductImageFileUploadManagementFacade sut;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		sut = new ProductImageFileUploadManagementFacade(storageService, productManagement, imageCreator);
	}

	@Test
	@DisplayName("upload메서드는 정상적인 파일을 받으면, 정상 실행된다")
	public void upload_executed_normally_when_correct_file_received() {
		Long productId = 1L;
		List<MultipartFile> files = Collections.singletonList(
			new MockMultipartFile("file", "image1.jpg", "image/jpeg", "image1".getBytes()));
		Product foundProduct = new Product(1, "상품1", 1000);

		given(productManagement.retriveProduct(productId)).willReturn(foundProduct);

		sut.upload(productId, files);

		verify(productManagement, times(1)).retriveProduct(productId);
		verify(storageService, times(1)).upload(any(MultipartFile.class), anyString());
		verify(imageCreator, times(1)).saveAll(anyList());
	}
}