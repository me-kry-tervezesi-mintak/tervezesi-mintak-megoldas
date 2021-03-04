package adapter.http;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

// not the best solution!!!!
// in case of more parallel tests the instance variables will be the problem
public class HttpAdapterUrlConnectionTest {
    private URLBuilder urlBuilder;
    private HttpAdapterUrlConnection httpAdapterUrlConnection;
    private InputStream inputStream;
    private HttpURLConnection mockConnection;

    final URLStreamHandler handler = new URLStreamHandler() {

        @Override
        protected URLConnection openConnection(final URL arg0)
                throws IOException {
            mockConnection = mock(HttpURLConnection.class);
            inputStream =  new ByteArrayInputStream("".getBytes());
            when(mockConnection.getInputStream()).thenReturn(inputStream);
            return mockConnection;
        }
    };

    @Before
    public void before() {
        urlBuilder = mock(URLBuilder.class);
        httpAdapterUrlConnection = new HttpAdapterUrlConnection(urlBuilder);
    }

    @Test
    public void get() throws IOException {
        // given
        String request = "request";
        String body = "body";
        URL mockUrl = new URL("http://foo.bar", "foo.bar", 80, "", handler);
        when(urlBuilder.build(request)).thenReturn(mockUrl);

        // when
        InputStream responseStream = httpAdapterUrlConnection.get(request, body);

        // then
        assertThat(responseStream, sameInstance(inputStream));
        verify(mockConnection, times(1))
                .setRequestProperty("accept",
                        "application/json");
        verify(mockConnection, times(1)).getInputStream();

    }

    @Test
    public void getThenException() throws IOException {
        // given
        String request = "request";
        String body = "body";

        when(urlBuilder.build(request)).thenThrow(new MalformedURLException());

        // when
        InputStream responseStream = httpAdapterUrlConnection.get(request, body);

        // then
        assertThat(responseStream, is(nullValue()));


    }
}