package dberkovics.Model;

import java.io.IOException;

public interface PersistenzStrategy {
    void save(WortTrainer w) throws IOException;
    WortTrainer load() throws IOException;
}
