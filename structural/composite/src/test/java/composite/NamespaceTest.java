package composite;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by zoltankrizsan on 2017. 02. 13..
 */
public class NamespaceTest {
	@Test
	public void addChild() {
		Namespace namespace = new Namespace();

		namespace.addChild(new Namespace());
		namespace.addChild(new Namespace());

		assertThat(namespace.getChildCount(), is(2));
	}

	@Test
	public void removeChildNull() {
		Namespace namespace = new Namespace();
		namespace.removeChild(null);
	}

	@Test
	public void removeChild() {
		Namespace namespace = new Namespace();

		Namespace namespace1 = new Namespace();
		namespace.addChild(namespace1);
		namespace.removeChild(namespace1);
		assertThat(namespace.getChildCount(), is(0));
	}

	@Test
	public void getComplexity() {
		Namespace namespace = new Namespace();
		AbstractComponent component = mock(AbstractComponent.class);
		when(component.getComplexity()).thenReturn(100);

		namespace.addChild(component);

		assertThat(namespace.getComplexity(), is(100));

		verify(component).getComplexity();
	}

	@Test
	public void getCount() {
		Namespace namespace = new Namespace();
		AbstractComponent component = mock(AbstractComponent.class);
		when(component.getCount()).thenReturn(1);

		namespace.addChild(component);

		assertThat(namespace.getCount(), is(2));

		verify(component).getCount();
	}

	@Test
	public void getRobotPartCount() {
		Namespace namespace = new Namespace();
		AbstractComponent component = mock(AbstractComponent.class);
		when(component.getRobotPartCount()).thenReturn(1);

		namespace.addChild(component);

		assertThat(namespace.getRobotPartCount(), is(1));

		verify(component).getRobotPartCount();
	}

	@Test
	public void getNamespaceCount() {
		Namespace namespace = new Namespace();
		AbstractComponent component = mock(AbstractComponent.class);
		when(component.getNamespaceCount()).thenReturn(1);

		namespace.addChild(component);

		assertThat(namespace.getNamespaceCount(), is(2));

		verify(component).getNamespaceCount();
	}

}