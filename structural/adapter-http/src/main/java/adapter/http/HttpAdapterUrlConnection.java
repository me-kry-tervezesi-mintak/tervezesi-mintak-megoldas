package adapter.http;

import lombok.RequiredArgsConstructor;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@RequiredArgsConstructor
public class HttpAdapterUrlConnection implements HttpAdapter {
    private final URLBuilder urlBuilder;

    @Override
    public InputStream get(String requestUrl, String body) {
        URL url;
        try {
            url = urlBuilder.build(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            return connection.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
