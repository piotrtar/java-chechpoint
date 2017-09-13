import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;

public class CharIterator implements Iterator {
   private int index;
   private String filename;
   private char[] chars;
   private ArrayList<String> charList;
   private FileContent fileContent;

   public CharIterator(FileContent fileContent) {
       this.index = 0;
       this.fileContent = fileContent;
       this.chars = fileContent.loadFileToString().replaceAll("[^a-zA-Z]", "").toCharArray();
       this.charList = new ArrayList();
       loadCharList();
       }

   @Override
   public boolean hasNext() {
       
        if (index < this.charList.size()) {
          return true;
        }
          return false;
   }

   @Override
   public String next() {

       if (hasNext()) {
           return this.charList.get(index++).toString();
       }
           return null;
   }

   public void loadCharList () {
       for (char letter : chars) {
           this.charList.add(((String.valueOf(letter))));
       }
   }
}