package com.aorri2.goodsforyou.productimage.unit;

import static org.assertj.core.api.Assertions.*;

import java.io.FileInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.aorri2.goodsforyou.productimage.domain.exception.UnSupportedFileTypeException;
import com.aorri2.goodsforyou.productimage.util.FileUtils;

@DisplayName("FileUtil 클래스")
public class FileUtilsTest {
	@Nested
	@DisplayName("getFilePath 메소드는")
	class Describe_getFilePath {

		@Nested
		@DisplayName("지원하지 않는 파일 타입이 주어진다면")
		class Context_with_NotSupportedFileType {
			@Test
			@DisplayName("UnSupportedFileTypeException을 던진다")
			void it_throws_UnSupportedFileTypeException() {
				String fileName = "file1";
				MultipartFile unSupportedFile = new MockMultipartFile(fileName,
					"filename.txt",
					"text/plain",
					"file content".getBytes());

				assertThatThrownBy(() -> FileUtils.getFilePath(unSupportedFile, fileName)).isInstanceOf(
					UnSupportedFileTypeException.class);
			}
		}

		@Nested
		@DisplayName("지원하는 파일 타입이 주어진다면")
		class Context_with_SupportedFileType {
			@Test
			@DisplayName("파일 이름을 리턴한다")
			void it_returns_fileName() throws Exception {
				String imageFileName = "testImage1";
				MultipartFile unSupportedFile = new MockMultipartFile(imageFileName, "testImage1.jpg", "image/jpg",
					new FileInputStream(getClass().getResource("/testImage/testImage1.jpg").getFile()));

				String fileName = FileUtils.getFilePath(unSupportedFile, imageFileName);

				assertThat(fileName).contains(imageFileName);
			}
		}
	}
}
