package solid.base;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class UserTest {
	@Test
	public void testCreation() {
		final String EXPECTED_LOGIN_NAME = "noname";

		User user = new User(EXPECTED_LOGIN_NAME);

		assertThat(user.getLoginName(), is(EXPECTED_LOGIN_NAME));
	}
}