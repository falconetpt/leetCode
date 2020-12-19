package exercises.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class ReadFile {
    public static Stream<String> readFile(final String path) {
        try {
            return Files.lines(Paths.get(path))
                    .filter(Objects::nonNull)
                    .map(String::trim);
        } catch (IOException e) {
            return Stream.empty();
        }
    }
}
