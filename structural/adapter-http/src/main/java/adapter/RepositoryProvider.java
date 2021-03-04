package adapter;

import java.io.IOException;
import java.util.List;

public interface RepositoryProvider {
    List<String> searchRepository(String q) throws IOException;
}
