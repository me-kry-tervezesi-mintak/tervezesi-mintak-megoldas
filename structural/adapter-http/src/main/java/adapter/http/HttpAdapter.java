package adapter.http;

import java.io.InputStream;

public interface HttpAdapter {
    InputStream get(String url, String body);
}
