package adapter;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ClientTest {
	@Test
	public void writeAllSuccess() {
		final String filename = "filename1";
		final String content = "content1";
		FileManager fileManager = mock(FileManager.class);
		when(fileManager.open(filename)).thenReturn(Status.SUCCESS);
		when(fileManager.write(0, content.length(), content.getBytes())).thenReturn(Status.SUCCESS);
		when(fileManager.close()).thenReturn(Status.SUCCESS);

		Client client = new Client(fileManager);

		assertThat(client.write(filename, content), is(true));

		verify(fileManager).open(filename);
		verify(fileManager).write(0, content.length(), content.getBytes());
		verify(fileManager).close();
	}

	@Test
	public void writeOpenFailed() {
		final String filename = "filename1";
		final String content = "content1";
		FileManager fileManager = mock(FileManager.class);
		when(fileManager.open(filename)).thenReturn(Status.FAILED);
		when(fileManager.write(0, content.length(), content.getBytes())).thenReturn(Status.SUCCESS);
		when(fileManager.close()).thenReturn(Status.SUCCESS);

		Client client = new Client(fileManager);

		assertThat(client.write(filename, content), is(false));

		verify(fileManager).open(filename);
		verify(fileManager, never()).write(0, content.length(), content.getBytes());
		verify(fileManager, never()).close();
	}

	@Test
	public void writeWiteFailed() {
		final String filename = "filename1";
		final String content = "content1";
		FileManager fileManager = mock(FileManager.class);
		when(fileManager.open(filename)).thenReturn(Status.SUCCESS);
		when(fileManager.write(0, content.length(), content.getBytes())).thenReturn(Status.FAILED);
		when(fileManager.close()).thenReturn(Status.SUCCESS);

		Client client = new Client(fileManager);

		assertThat(client.write(filename, content), is(false));

		verify(fileManager).open(filename);
		verify(fileManager).write(0, content.length(), content.getBytes());
		verify(fileManager).close();
	}

	@Test
	public void writeCloseFailed() {
		final String filename = "filename1";
		final String content = "content1";
		FileManager fileManager = mock(FileManager.class);
		when(fileManager.open(filename)).thenReturn(Status.SUCCESS);
		when(fileManager.write(0, content.length(), content.getBytes())).thenReturn(Status.SUCCESS);
		when(fileManager.close()).thenReturn(Status.FAILED);

		Client client = new Client(fileManager);

		assertThat(client.write(filename, content), is(false));

		verify(fileManager).open(filename);
		verify(fileManager).write(0, content.length(), content.getBytes());
		verify(fileManager).close();
	}



	@Test
	public void readAllSuccess() {
		final String filename = "filename1";
		final String content = "content1";
		FileManager fileManager = mock(FileManager.class);
		byte[] response = new byte[content.length()];

		when(fileManager.open(filename)).thenReturn(Status.SUCCESS);
		when(fileManager.read(0, content.length(), response)).thenReturn(Status.SUCCESS);
		when(fileManager.close()).thenReturn(Status.SUCCESS);

		Client client = new Client(fileManager);

	 	assertThat(client.read(filename, content.length()).length, is(content.length()));

		verify(fileManager).open(filename);
		verify(fileManager).read(0, content.length(), response);
		verify(fileManager).close();
	}

	@Test
	public void readOpenFailed() {
		final String filename = "filename1";
		final String content = "content1";
		FileManager fileManager = mock(FileManager.class);
		when(fileManager.open(filename)).thenReturn(Status.FAILED);
		byte[] response = new byte[content.length()];
		when(fileManager.read(0, content.length(), response)).thenReturn(Status.SUCCESS);
		when(fileManager.close()).thenReturn(Status.SUCCESS);

		Client client = new Client(fileManager);

		assertThat(client.read(filename, content.length()), is((byte[])null));

		verify(fileManager).open(filename);
		verify(fileManager, never()).read(0, content.length(), response);
		verify(fileManager, never()).close();
	}

	@Test
	public void readReadFailed() {
		final String filename = "filename1";
		final String content = "content1";
		byte[] response = new byte[content.length()];

		FileManager fileManager = mock(FileManager.class);
		when(fileManager.open(filename)).thenReturn(Status.SUCCESS);
		when(fileManager.read(0, content.length(), response)).thenReturn(Status.FAILED);
		when(fileManager.close()).thenReturn(Status.SUCCESS);

		Client client = new Client(fileManager);

		assertThat(client.read(filename, content.length()).length, is(content.length()));

		verify(fileManager).open(filename);
		verify(fileManager).read(0, content.length(), response);
		verify(fileManager).close();
	}

	@Test
	public void readCloseFailed() {
		final String filename = "filename1";
		final String content = "content1";
		byte[] response = new byte[content.length()];

		FileManager fileManager = mock(FileManager.class);
		when(fileManager.open(filename)).thenReturn(Status.SUCCESS);
		when(fileManager.read(0, content.length(), response)).thenReturn(Status.SUCCESS);
		when(fileManager.close()).thenReturn(Status.FAILED);

		Client client = new Client(fileManager);

		assertThat(client.read(filename, content.length()).length, is(content.length()));

		verify(fileManager).open(filename);
		verify(fileManager).read(0, content.length(), response);
		verify(fileManager).close();
	}

}