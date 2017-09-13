import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;

public class WordIterator implements Iterator {

   private int index;
   private String filename;
   private ArrayList<String> wordsList;
   private String[] word;
   private FileContent fileContent;

   public WordIterator(FileContent fileContent) {
       this.index = 0;
       this.fileContent = fileContent;
       this.word = fileContent.loadFileToString().split("\\s+");
       this.wordsList = new ArrayList<>(Arrays.asList(word));
       }

   @Override
   public boolean hasNext() {
       
        if (index < this.wordsList.size()) {
          return true;
        }
          return false;
   }

   @Override
   public String next() {

       if (hasNext()) {
           return this.wordsList.get(index++);
       }
           return null;
   }
}