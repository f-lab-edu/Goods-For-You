package com.aorri2.goodsforyou.productimage.unit;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.aorri2.goodsforyou.productimage.util.FileType;

@DisplayName("FileType 클래스")
class FileTypeTest {

	public static final String UNSUPPORTED_TYPE = "jpge";

	@Nested
	@DisplayName("isNotSupportedType 메서드는")
	class Describe_isNotSupportedType {

		@Nested
		@DisplayName("지원하지 않는 타입이 주어진다면")
		class Context_with_UnSupportedType {
			@Test
			@DisplayName("true를 반환한다")
			void it_return_true() {
				boolean actual = FileType.isNotSupportedType(UNSUPPORTED_TYPE);
				boolean expected = true;

				assertThat(actual).isEqualTo(expected);
			}
		}
	}

}