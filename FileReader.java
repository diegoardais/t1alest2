import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.charset.Charset;

public final class FileReader {

    static public ArrayList<String[]> readFromFileTXT(String fileName) {
        ArrayList<String[]> lines = new ArrayList<String[]>();
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(fileName), Charset.defaultCharset());
            String line = null;
            while ((line = reader.readLine()) != null) {
                String v[] = line.split(" ");
                lines.add(v);
            }
            reader.close();

        } catch (IOException e) {
            System.err.format("Error reading file: ", e);
        }
        return lines;
    }
}