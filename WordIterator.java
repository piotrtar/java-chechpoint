import java.util.Iterator;
import java.util.ArrayList;

public class WordIterator implements Iterator {

   private int index;
   private String filename;
   private ArrayList<String> words;
   private FileContent fileContent;

   public WordIterator(FileContent fileContent) {
       this.index = 0;
       this.fileContent = fileContent;
       this.words = fileContent.getWords();
       }

   @Override
   public boolean hasNext() {
       
        if (index < this.words.size()) {
          return true;
        }
          return false;
   }

   @Override
   public String next() {

       if (hasNext()) {
           return this.words.get(index++);
       }
           return null;
   }
}