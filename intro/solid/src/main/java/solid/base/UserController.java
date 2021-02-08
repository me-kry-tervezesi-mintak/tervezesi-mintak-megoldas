package solid.base;

import java.util.ArrayList;
import java.util.List;

public class UserController {
	private final List<Validator> validators = new ArrayList<>();
	private final UserService userService;

	public UserController(UserService userService, List<Validator> validators) {
		this.userService = userService;
		this.validators.addAll(validators);

	}

	private boolean validUserName(String userName) {
		for (Validator validator : validators) {
			if (!validator.isValid(userName)) {
				return false;
			}
		}

		return true;
	}

	public void createUser(String username) {
		if (validUserName(username)) {
			userService.save(new User(username));
		}
	}

}
