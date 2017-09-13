import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileContent implements IterableText {

    private String filename;

    public FileContent(String filename) {
        this.filename = filename;
    }

    @Override
    public Iterator<String> charIterator() {

        return new CharIterator(this);
    }

    @Override
    public Iterator<String> wordIterator() {

        return new WordIterator(this);
    }

    public String getFilename() {
        return this.filename;
    }

    public String loadFileToString() {

        StringBuffer builder = new StringBuffer();
        String finalString = null;

        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(this.filename)))){

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                builder.append(line);
                builder.append("\n");
            }
            finalString = builder.toString();

        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }
            return finalString;
    }
}