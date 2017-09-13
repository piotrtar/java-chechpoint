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

    public ArrayList<String> getChars() {

        ArrayList<String> allChars = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(this.filename)));

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String nospacesline = line.replaceAll("\\s+", "");
                for (int i = 0; i < nospacesline.length(); i++) {
                    char ch = nospacesline.charAt(i);
                    String strCh = String.valueOf(ch);
                    allChars.add(strCh);
                }
            }
            return allChars;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getWords() {

        int lineLenght;
        ArrayList<String> allWords = new ArrayList<String>();

        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(this.filename)));

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String[] wordsline = line.split("\\s+");
                lineLenght = wordsline.length;

                for (int i = 0; i < lineLenght; i++) {
                    String word = wordsline[i];
                    allWords.add(word);
                }
            }
            return allWords;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}