import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public static List<String> readWords(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    private static List<String> parseContent(List<String> fileContent) {
        ArrayList<String> words = new ArrayList<>();
        for (String line: fileContent) {
            words.add(line);
        }
        return words;
    }
}
