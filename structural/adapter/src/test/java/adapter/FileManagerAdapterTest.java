package adapter;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FileManagerAdapterTest {

	@Test
	public void open() {
		final String fileName = "asdasd";
		FileManagerUtil fileManagerUtil = mock(FileManagerUtil.class);
		when(fileManagerUtil.openFile(anyString())).thenReturn(true);
		FileManagerAdapter fileManagerAdapter = new FileManagerAdapter(fileManagerUtil);

		assertThat(fileManagerAdapter.open(fileName), is(Status.SUCCESS));

		verify(fileManagerUtil).openFile(fileName);
	}



	@Test
	public void close() {
		FileManagerUtil fileManagerUtil = mock(FileManagerUtil.class);
		when(fileManagerUtil.closeFile()).thenReturn(true);
		FileManagerAdapter fileManagerAdapter = new FileManagerAdapter(fileManagerUtil);

		assertThat(fileManagerAdapter.close(), is(Status.SUCCESS));

		verify(fileManagerUtil).closeFile();
	}

	@Test
	public void read() {
		final int from = 0;
		final int to = 5;
		final String fileName = "asdasd";
		final String dummyResponseString = "hello";

		FileManagerUtil fileManagerUtil = mock(FileManagerUtil.class);
		when(fileManagerUtil.readFromFile(from, to)).thenReturn(dummyResponseString);
		FileManagerAdapter fileManagerAdapter = new FileManagerAdapter(fileManagerUtil);

		byte[] reponse = new byte[5];
		assertThat(fileManagerAdapter.read(from, to, reponse), is(Status.SUCCESS));
		String responseString = new String(reponse);
		assertThat(dummyResponseString, is(responseString));
		verify(fileManagerUtil).readFromFile(from, to);
	}

	@Test
	public void write() {
		final int from = 0;
		final int to = 5;
		final String fileName = "asdasd";
		final String dummyString = "hello";

		FileManagerUtil fileManagerUtil = mock(FileManagerUtil.class);
		when(fileManagerUtil.writeToFile(dummyString, from, to)).thenReturn(true);
		FileManagerAdapter fileManagerAdapter = new FileManagerAdapter(fileManagerUtil);

		assertThat(fileManagerAdapter.write(from, to, dummyString.getBytes()), is(Status.SUCCESS));

		verify(fileManagerUtil).writeToFile(dummyString, from, to);
	}

}