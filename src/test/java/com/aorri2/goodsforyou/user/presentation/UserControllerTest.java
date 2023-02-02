package com.aorri2.goodsforyou.user.presentation;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.aorri2.goodsforyou.user.application.UserManagement;
import com.aorri2.goodsforyou.user.application.command.CreateUserCommand;
import com.aorri2.goodsforyou.user.presentation.request.NewUserRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @WebMvcTest 어노테이션을 붙임으로써, 프로젝트 전체 Layer의 Bean들을 불러오는게 아닌 Presentation Layer의 빈들만 스캔합니다.
 * @Service 나, @Repository가 붙은 객체들은 테스트 대상이 아닌 것으로 처리됩니다.
 * @Controller, 또는 @RestController 어노테이션이 설정 된 클래스들을 찾아 메모리에 생성합니다.
 * controller에 대한 slice test를 위해, 해당 어노테이션을 사용했습니다.
 */
@WebMvcTest(UserController.class)
class UserControllerTest {

	@Autowired
	MockMvc mockMvc;

	/**
	 * 기존에 사용되던 스프링 Bean이 아닌 MockBean(가짜 객체)를 주입합니다.
	 */
	@MockBean
	private UserManagement userManagement;

	@Autowired
	private ObjectMapper objectMapper;

	@Nested
	@DisplayName("register 메서드는")
	class Describe_register {

		@Nested
		@DisplayName("유저정보가 주어진다면")
		class Context_with_userInformation {

			@Test
			@DisplayName("정상적으로 회원가입 동작을 수행한다.")
			void it_execute_that_register() throws Exception {
				doNothing().when(userManagement)
					.joinUser(createNewUserCommandBy(createNewUserRequest("testuser@test.com", "testUser",
						"test123@@")));

				mockMvc.perform(post("/api/v1/users")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(
							createNewUserRequest("testUser@test.com", "testUser", "test123@@"))))
					.andDo(print())
					.andExpect(status().isCreated());
			}

		}

		@Nested
		@DisplayName("유저 이메일 정보가 주어지지 않는다면")
		class Context_withOut_userEmailInformation {

			@ParameterizedTest
			@MethodSource("invalidUserEmailParameter")
			@DisplayName("BadRequest를 status code로 리턴시킨다.")
			void it_return_badRequest(NewUserRequest newUserRequest) throws Exception {

				doNothing().when(userManagement).joinUser(createNewUserCommandBy(newUserRequest));

				mockMvc.perform(post("/api/v1/users")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(newUserRequest)))
					.andDo(print())
					.andExpect(status().isBadRequest());
			}

			private static Stream<Arguments> invalidUserEmailParameter() {

				return Stream.of(
					Arguments.of(new NewUserRequest("", "test", "testtesttest")),
					Arguments.of(new NewUserRequest(" ", "test", "testtesttest")),
					Arguments.of(new NewUserRequest(null, "test", "testtesttest"))
				);
			}

		}

		@Nested
		@DisplayName("유저 이메일 형식이 일치하지 않는다면")
		class Context_with_userEmailFormat_Invalid {

			/**
			 * ParameterizedTest 애노테이션을 붙이면 해당 테스트는 동일한 테스트 케이스에 대해 파라미터를 다르게 실행할 수 있게 됩니다.
			 * 또한 @MethodSource로 ParameterizedTest에서 사용할 파라미터를 생성하기 위해 작성한 메서드 이름을 적어주면 해당 메서드의 코드를
			 * 실행시켜, 파라미터를 만들어 줍니다.
			 */
			@ParameterizedTest
			@MethodSource("invalidUserEmailFormatParameter")
			@DisplayName("BadRequest를 status code로 리턴시킨다.")
			void it_return_badRequest(NewUserRequest newUserRequest) throws Exception {

				doNothing().when(userManagement).joinUser(createNewUserCommandBy(newUserRequest));

				mockMvc.perform(post("/api/v1/users")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(newUserRequest)))
					.andDo(print())
					.andExpect(status().isBadRequest());
			}

			/**
			 * Parameterized 테스트 에서 사용할 값들을 생성하는 메서드
			 * @return 유저 이메일 형식에 일치하지 않는 NewUserRequest 객체를 리턴합니다.
			 */
			private static Stream<Arguments> invalidUserEmailFormatParameter() {

				return Stream.of(
					Arguments.of(new NewUserRequest("!asd@naa.com", "test", "testtesttest")),
					Arguments.of(new NewUserRequest("asd.naa.com", "test", "testtesttest")),
					Arguments.of(new NewUserRequest("asdnaa@.com", "test", "testtesttest"))
				);
			}

		}

		@Nested
		@DisplayName("유저 닉네임 정보가 빈칸이라면")
		class Context_with_userNickname_information_is_blank {

			@Test
			@DisplayName("BadRequest를 status code로 리턴시킨다.")
			void it_return_badRequest() throws Exception {
				NewUserRequest testUser = createNewUserRequest("testUser@naver.com", "", "test123@@");

				doNothing().when(userManagement).joinUser(createNewUserCommandBy(testUser));

				mockMvc.perform(post("/api/v1/users")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(testUser)))
					.andDo(print())
					.andExpect(status().isBadRequest());
			}

		}

		@Nested
		@DisplayName("유저 비밀번호 정보가 빈칸이라면")
		class Context_with_userPassword_information_is_blank {

			@Test
			@DisplayName("BadRequest를 status code로 리턴시킨다.")
			void it_return_badRequest() throws Exception {
				NewUserRequest testUser = createNewUserRequest("testUser@naver.com", "testUser", "");

				doNothing().when(userManagement).joinUser(createNewUserCommandBy(testUser));

				mockMvc.perform(post("/api/v1/users")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(testUser)))
					.andDo(print())
					.andExpect(status().isBadRequest());
			}

		}

		@Nested
		@DisplayName("유저 비밀번호의 길이가 8 이하 라면")
		class Context_with_userPassword_length_is_lower_than_8 {
			@Test
			@DisplayName("BadRequest를 status code로 리턴시킨다.")
			void it_return_badRequest() throws Exception {
				NewUserRequest testUser = createNewUserRequest("testUser@naver.com", "testUser", "1234567");

				doNothing().when(userManagement).joinUser(createNewUserCommandBy(testUser));

				mockMvc.perform(post("/api/v1/users")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(testUser)))
					.andDo(print())
					.andExpect(status().isBadRequest());
			}
		}

		private CreateUserCommand createNewUserCommandBy(NewUserRequest request) {
			return request.toCommand();
		}

		private NewUserRequest createNewUserRequest(String email, String name, String password) {
			return new NewUserRequest(email, name, password);
		}
	}
}