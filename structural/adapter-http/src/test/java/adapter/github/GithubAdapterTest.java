package adapter.github;

import adapter.http.HttpAdapter;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.Matchers.*;
public class GithubAdapterTest {

    private GithubAdapter githubAdapter;
    private HttpAdapter httpAdapter;

    @Before
    public void before() {
        httpAdapter = Mockito.mock(HttpAdapter.class);
        githubAdapter = new GithubAdapter(httpAdapter);
    }

    @Test(expected = MismatchedInputException.class)
    public void searchRepositoryNoResponse() throws IOException {
        // given
        String q = "searchPattern";
        InputStream inputStream =  new ByteArrayInputStream("".getBytes());
        Mockito.when(httpAdapter.get(any(), any())).thenReturn(inputStream);

        // when
        githubAdapter.searchRepository(q);

        //then
    }

    @Test
    public void searchRepositoryValidResponse() throws IOException {
        // given
        String q = "searchPattern";
        String foundItemName = "MyDiary";
        String response = new StringBuilder()
                .append("{\n")
                .append("   \"total_count\":2,\n")
                .append("   \"incomplete_results\":false,\n")
                .append("   \"items\":[\n")
                .append("      {\n")
                .append("         \"id\":72805051,\n")
                .append("         \"node_id\":\"MDEwOlJlcG9zaXRvcnk3MjgwNTA1MQ==\",\n")
                .append("         \"name\":\"").append(foundItemName).append("\",\n")
                .append("         \"owner\": {}\n")
                .append("      }\n")
                .append("   ]\n")
                .append("}").toString();
        InputStream inputStream =  new ByteArrayInputStream(response.getBytes());
        Mockito.when(httpAdapter.get(any(), any())).thenReturn(inputStream);

        // when
        List<String> stringList = githubAdapter.searchRepository(q);

        //then
        Mockito.verify(httpAdapter, Mockito.times(1))
                .get("https://api.github.com/search/repositories?q=searchPattern", "");
        Assert.assertThat(stringList, contains(foundItemName));
    }

}