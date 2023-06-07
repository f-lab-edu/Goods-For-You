package com.aorri2.goodsforyou.productimage.presentation;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.FileInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import com.aorri2.goodsforyou.productimage.application.ProductImageFileUploadManagement;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest({ProductImageController.class})
class ProductImageControllerTest {
	@MockBean
	ProductImageFileUploadManagement imageFileUploadManagement;

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@DisplayName("사용자는 이미지를 업로드할 수 있다.")
	@Test
	void user_can_upload_images() throws Exception {
		final String fileName = "testImage1";
		final String contentType = "jpg";
		final String filePath = "src/test/resources/testImage/" + fileName + "." + contentType;
		FileInputStream fis = new FileInputStream(filePath);
		MockMultipartFile image1 = new MockMultipartFile("file", fileName, MediaType.IMAGE_JPEG_VALUE,
			fis);

		mockMvc.perform(multipart("/api/v1/products/1/images")
				.file(image1)
				.contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
			)
			.andExpect(status().isNoContent())
			.andDo(print());
	}
}