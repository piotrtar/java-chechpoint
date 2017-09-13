
import java.util.*;

public class View {

    public static void printCharCount(Number myNumber) {
        System.out.println("\nChar count: " + myNumber);
    }

    public static void printWordCount(Number myNumber) {
        System.out.println("Word count: " + myNumber);

    }

    public static void printDictSize(Number myNumber){
        System.out.println("Dict size: " + myNumber);
    }

    public static void showTime(long time){

        String timeResult = String.format("Benchmark time: %s secs\n", time);
        System.out.println(timeResult);
    }

    public static void printOccuredWord(String word, Number myNumber){

        System.out.println("'" + word + "'" + "count: " + myNumber);
    }

    public static void printMostUsedWord(Set<String> mySet){
        System.out.println("Most used words (>1%): " + mySet);
    }

    public static void printVowels(float myNumber){
        System.out.println("vowels %: " + myNumber);
    }

    public static void printRatio(float ratio){
        System.out.println("'a:e count ratio': " + ratio);
    }

    public static void printCharactersRatio(ArrayList<String> chars){
        System.out.println(chars);
    }
}