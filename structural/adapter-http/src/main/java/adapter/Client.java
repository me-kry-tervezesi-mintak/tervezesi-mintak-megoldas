package adapter;

import adapter.github.GithubAdapter;
import adapter.http.HttpAdapterUrlConnection;
import adapter.http.URLBuilder;
import adapter.http.URLBuilderImpl;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class Client {
    private final RepositoryProvider repositoryProvider;

    public static void main(String[] args) {

        URLBuilder urlBuilder = new URLBuilderImpl();
        HttpAdapterUrlConnection httpAdapterUrlConnection = new HttpAdapterUrlConnection(urlBuilder);

        RepositoryProvider repositoryProvider = new GithubAdapter(httpAdapterUrlConnection);

        Client client = new Client(repositoryProvider);

        try {
            client.printOutGithubRepos("dejo");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void printOutGithubRepos(String repoNameLike) throws IOException {

        List<String> strings = repositoryProvider.searchRepository(repoNameLike);

        for (String repoName: strings) {
            System.out.println(repoName);
        }
    }


}
