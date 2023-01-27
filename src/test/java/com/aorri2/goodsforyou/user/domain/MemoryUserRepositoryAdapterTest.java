package com.aorri2.goodsforyou.user.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.aorri2.goodsforyou.user.infrastructure.inmemory.MemoryUserRepositoryAdapter;

@DisplayName("MemoryUserRepositoryAdapter 클래스")
class MemoryUserRepositoryAdapterTest {

	private MemoryUserRepositoryAdapter memoryUserRepositoryAdapter;
	private User user1;
	private User user2;
	private User user3;

	@BeforeEach
	void setUp() {
		memoryUserRepositoryAdapter = new MemoryUserRepositoryAdapter();
		user1 = new NewUser("wook2@naver.com", "wook", "121211");
		user2 = new NewUser("jong@naver.com", "jong", "12345667");
		user3 = new NewUser("hwang@naver.com", "hwang", "13209848s!");
	}

	@Nested
	@DisplayName("save 메소드는")
	class Describe_save {

		@Nested
		@DisplayName("user 객체가 주어진다면")
		class Context_with_real {

			@Test
			@DisplayName("사용자가 입력한 user 객체의 정보를 저장한다.")
			void it_return_savedUserValue() {

				memoryUserRepositoryAdapter.save(user1);
				memoryUserRepositoryAdapter.save(user2);
				memoryUserRepositoryAdapter.save(user3);

				User foundUser1 = memoryUserRepositoryAdapter.findByName("wook");
				User foundUser2 = memoryUserRepositoryAdapter.findByName("jong");
				User foundUser3 = memoryUserRepositoryAdapter.findByName("hwang");

				assertThat(foundUser1.name()).isEqualTo(user1.name());
				assertThat(foundUser2.name()).isEqualTo(user2.name());
				assertThat(foundUser3.name()).isEqualTo(user3.name());
			}
		}

	}

	@Nested
	@DisplayName("findByName 메소드는")
	class Describe_findByName {
		@Nested
		@DisplayName("찾고자 하는 사용자의 이름이 주어진다면")
		class Context_with_userName {

			@Test
			@DisplayName("이름에 해당하는 유저를 리턴한다.")
			void it_returns_a_correct_user() {

				memoryUserRepositoryAdapter.save(user1);
				memoryUserRepositoryAdapter.save(user2);
				memoryUserRepositoryAdapter.save(user3);

				User foundUser1 = memoryUserRepositoryAdapter.findByName("wook");
				User foundUser2 = memoryUserRepositoryAdapter.findByName("jong");
				User foundUser3 = memoryUserRepositoryAdapter.findByName("hwang");

				checkSameUser(user1, foundUser1);
				checkSameUser(user2, foundUser2);
				checkSameUser(user3, foundUser3);
			}
		}

	}

	@Nested
	@DisplayName("findByEmail 메소드는")
	class Describe_findByEmail {
		@Nested
		@DisplayName("찾고자 하는 사용자의 이름이 주어진다면")
		class Context_with_userEmail {
			@Test
			@DisplayName("이메일에 해당하는 유저를 리턴한다")
			void it_returns_a_correctUser() {

				memoryUserRepositoryAdapter.save(user1);
				memoryUserRepositoryAdapter.save(user2);
				memoryUserRepositoryAdapter.save(user3);

				User foundByEmail1 = memoryUserRepositoryAdapter.findByEmail("wook2@naver.com");
				User foundByEmail2 = memoryUserRepositoryAdapter.findByEmail("jong@naver.com");
				User foundByEmail3 = memoryUserRepositoryAdapter.findByEmail("hwang@naver.com");

				checkSameUser(user1, foundByEmail1);
				checkSameUser(user2, foundByEmail2);
				checkSameUser(user3, foundByEmail3);
			}
		}
	}

	private void checkSameUser(User user, User foundUser) {
		assertThat(foundUser.name()).isEqualTo(user.name());
		assertThat(foundUser.id()).isEqualTo(user.id());
		assertThat(foundUser.email()).isEqualTo(user.email());
		assertThat(foundUser.password()).isEqualTo(user.password());
	}
}