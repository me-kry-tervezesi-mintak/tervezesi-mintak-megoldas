package adapter.http;

import java.net.MalformedURLException;
import java.net.URL;

public class URLBuilderImpl implements URLBuilder {
    @Override
    public URL build(String requestUrl) throws MalformedURLException {
        return new URL(requestUrl);
    }
}
