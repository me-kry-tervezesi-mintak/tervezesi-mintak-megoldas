package solid.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by zoltankrizsan on 2017. 01. 30..
 */
public class UserControllerTest {
	@Test
	public void testCreateUserWithValidUserName() {

		final String VALID_USERNAME = "123456";
		List<Validator> validators = new ArrayList<>();
		Validator dummyTrueValidator = mock(Validator.class);
		when(dummyTrueValidator.isValid(VALID_USERNAME)).thenReturn(true);
		validators.add(dummyTrueValidator);

		UserService userService = mock(UserService.class);

		UserController userController = new UserController(userService, validators);
		userController.createUser(VALID_USERNAME);

		verify(userService, times(1)).save(any());
	}


	@Test
	public void testCreateUserWithInvalidUserName() {

		final String INVALID_USERNAME = "123 456";
		List<Validator> validators = new ArrayList<>();
		Validator dummyTrueValidator = mock(Validator.class);
		when(dummyTrueValidator.isValid(INVALID_USERNAME)).thenReturn(false);
		validators.add(dummyTrueValidator);

		UserService userService = mock(UserService.class);

		UserController userController = new UserController(userService, validators);
		userController.createUser(INVALID_USERNAME);

		verify(userService, never()).save(any());
	}

	@Test
	public void testCreateUserWithInvalidUserNameMultipleValidators() {

		final String INPUT = "asdasd";
		List<Validator> validators = new ArrayList<>();
		Validator dummyTrueValidator = mock(Validator.class);
		when(dummyTrueValidator.isValid(INPUT)).thenReturn(true);
		validators.add(dummyTrueValidator);

		Validator dummyFalseValidator = mock(Validator.class);
		when(dummyFalseValidator.isValid(INPUT)).thenReturn(false);
		validators.add(dummyFalseValidator);

		UserService userService = mock(UserService.class);

		UserController userController = new UserController(userService, validators);
		userController.createUser(INPUT);

		verify(userService, never()).save(any());
	}
}