package solid.security;

import solid.base.Validator;

public class JsInjectionValidator implements Validator {
	@Override
	public boolean isValid(String userName) {
		if (userName == null) {
			return true;
		} else {
			return !userName.contains("<script>");
		}
	}
}
