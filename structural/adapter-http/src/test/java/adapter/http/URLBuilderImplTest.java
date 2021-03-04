package adapter.http;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class URLBuilderImplTest {

    @Test
    public void build() throws MalformedURLException {
        // given
        String urlString = "https://java.com/en/";

        // when
        URL url = new URLBuilderImpl().build(urlString);

        // then
        assertThat(url, instanceOf(URL.class));
    }
}