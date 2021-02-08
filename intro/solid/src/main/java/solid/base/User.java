package solid.base;


public class User {
	private final String loginName;

	public User(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginName() {
		return loginName;
	}
}
