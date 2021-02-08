package solid.security;

import org.junit.Test;
import solid.security.JsInjectionValidator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by zoltankrizsan on 2017. 01. 30..
 */
public class JsInjectionValidatorTest {
	@Test
	public void testIsValidWithNull() {
		JsInjectionValidator jsInjectionValidator = new JsInjectionValidator();

		assertThat(jsInjectionValidator.isValid(null), is(true));
	}

	@Test
	public void testIsValidWithEmptyString() {
		JsInjectionValidator jsInjectionValidator = new JsInjectionValidator();

		assertThat(jsInjectionValidator.isValid(""), is(true));
	}
	@Test
	public void testIsValidWithEvilInput() {
		JsInjectionValidator jsInjectionValidator = new JsInjectionValidator();

		assertThat(jsInjectionValidator.isValid("sdfasdf<script>"), is(false));
	}
	@Test
	public void testIsValidWithValidInput() {
		JsInjectionValidator jsInjectionValidator = new JsInjectionValidator();

		assertThat(jsInjectionValidator.isValid("asdfasdf<adfg>sdfasdf"), is(true));
	}
}