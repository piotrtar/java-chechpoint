
import java.util.*;

public class StatisticalAnalysis {

    private Iterator<String> myIterator;
    private HashMap<String, Integer> map;

    public StatisticalAnalysis(Iterator<String> iterator) {

        this.myIterator = iterator;
        this.map = new HashMap<String, Integer>();
        this.loadDataToMap();
    }

    public int countOf(String... elems) {
        
        int count = 0;
        for (String arg : elems) {
            if (map.containsKey(arg)){
                count += this.map.get(arg); 
            }
        }
        return count;
    }

    public int dictionarySize() { // returns the number of unique elements in file
        int uniqueElements = this.map.keySet().size();

        return uniqueElements;
    }
 
    public int size() {
        
        int size = 0;
 
        for (int value : this.map.values()) {
            size += value;
        }
        return size;
    }
 
    public Set<String> occurMoreThan(Integer i) {
 
        Set<String> setOfElements = new HashSet<String>();
 
        for (String key : this.map.keySet()) {
            if (this.map.get(key) > i) {
                setOfElements.add(key);
            }
        }
        return setOfElements;
    }

    public void loadDataToMap() {

        while (myIterator.hasNext()) {

            String element = myIterator.next().toLowerCase();

            if(this.map.containsKey(element)) {
                this.map.put(element, this.map.get(element) + 1);
            } else {
                this.map.put(element, 1);
            }
        }
    }

    public ArrayList<String> getAllCharsForRatio() {

        ArrayList<String> chars = new ArrayList<String>();
        for (String key : this.map.keySet()) {
            chars.add(key);
        }
        return chars;
    }
}