package adapter.github;

import adapter.RepositoryProvider;
import adapter.http.HttpAdapter;
import adapter.github.dto.Root;
import com.fasterxml.jackson.databind.DeserializationFeature;
import lombok.RequiredArgsConstructor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GithubAdapter implements RepositoryProvider {
    private final HttpAdapter httpAdapter;

    private final String gitHubSearchRepositoryBaseUrl = "https://api.github.com/search/repositories";

    @Override
    public List<String> searchRepository(String q) throws IOException {

        InputStream responseStream = httpAdapter.get(
                String.format("%s?q=%s", gitHubSearchRepositoryBaseUrl, q),
                "");

        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Root response = mapper.readValue(responseStream, Root.class);

        return response.items.stream().map( item -> item.name).collect(Collectors.toList());
    }
}
