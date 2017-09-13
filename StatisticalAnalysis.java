
import java.util.*;

public class StatisticalAnalysis {

    private Iterator<String> myIterator;
    private HashMap<String, Integer> map;

    public StatisticalAnalysis(Iterator iterator) {

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
 
    public Set<String> occurMoreThen(Integer i) {
 
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

            String element = myIterator.next();

            if(this.map.containsKey(element)) {
                this.map.put(element, this.map.get(element) + 1);
            } else {
                this.map.put(element, 1);
            }
        }
    }

    public Set<String> showOccuredMoreThan(int percent){

        int number = (this.size()*percent)/100;
        Set<String> occuredWords = this.occurMoreThen(number);
        return occuredWords;
	}

    public float getAllVowels() {
        int counter = 0;
	    String[] allVowels = {"a", "e", "i", "o", "u", "y"};

	    for (String key : this.map.keySet()) {
            if(Arrays.asList(allVowels).contains(key)){
                counter += this.map.get(key);
            }
        }
        float vovelPercent = ( counter * 100 ) / this.size();
        return vovelPercent;
        }

    public int countOcurredWord(String word) {
        int searchedWord = this.countOf(word);
        return searchedWord;
    }
}