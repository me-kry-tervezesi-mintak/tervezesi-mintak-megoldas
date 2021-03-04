package adapter.http;

import java.net.MalformedURLException;
import java.net.URL;

public interface URLBuilder {
    URL build(String requestUrl) throws MalformedURLException;
}
