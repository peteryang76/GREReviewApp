import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Writer {
    private PrintWriter writer;

    public Writer(File file) throws FileNotFoundException, UnsupportedEncodingException {
        writer = new PrintWriter(file, "UTF-8");
    }

    public void write(String word) {
        writer.println(word);
    }

    public void close() {
        writer.close();
    }
}
