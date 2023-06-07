package com.aorri2.goodsforyou.productimage.infrastructure.mybatis;

import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.aorri2.goodsforyou.productimage.domain.ProductImage;

class ProductImageCreatorAdapterTest {

	@Mock
	private ProductImageMapper mapper;

	private ProductImageCreatorAdapter sut;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		sut = new ProductImageCreatorAdapter(mapper);
	}

	@Test
	void testSaveAll() {
		ProductImage image1 = new ProductImage(1L, "image1.jpg", "http://somepath1");
		ProductImage image2 = new ProductImage(2L, "image2.jpg", "http://somepath2");
		List<ProductImage> images = List.of(image1, image2);

		sut.saveAll(images);

		verify(mapper, times(1)).saveAll(images);
	}
}