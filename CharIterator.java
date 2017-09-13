import java.util.Iterator;
import java.util.ArrayList;

public class CharIterator implements Iterator {
   private int index;
   private String filename;
   private ArrayList<String> chars;
   private FileContent fileContent;

   public CharIterator(FileContent fileContent) {
       this.index = 0;
       this.fileContent = fileContent;
       this.chars = fileContent.getChars();
       }

   @Override
   public boolean hasNext() {
       
        if (index < this.chars.size()) {
          return true;
        }
          return false;
   }

   @Override
   public String next() {

       if (hasNext()) {
           this.chars.get(index++).toString();
       }
           return null;
   }
}