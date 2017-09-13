import java.util.*;

public class Application {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		loadFiles(args);
		long endTime = System.currentTimeMillis();
		long totalTime = (endTime - startTime) / 1000;
		View.showTime(totalTime);
	}

	public static void loadFiles(String[] args) {

		for (int i = 0; i < args.length; i++) {

			FileContent content = new FileContent(args[i]);
			Iterator<String> wordIterator = content.wordIterator();
			Iterator<String> charIterator = content.charIterator();

			StatisticalAnalysis wordSA = new StatisticalAnalysis(wordIterator);
			StatisticalAnalysis charSA = new StatisticalAnalysis(charIterator);

			View.printCharCount(charSA.size());
			View.printWordCount(wordSA.size());
			View.printDictSize(wordSA.dictionarySize());

			View.printMostUsedWord(wordSA.occurMoreThan(calculatePercentage(wordSA,1)));

			View.printOccuredWord("love", wordSA.countOf("love"));
			View.printOccuredWord("hate", wordSA.countOf("hate"));
			View.printOccuredWord("music", wordSA.countOf("music"));
			
			View.printVowels(getAllVowels(charSA));
			View.printRatio(getCountRatio(charSA,"a","e"));
			View.printCharactersRatio(ratioOfCharacters(charSA));
		}
	}

	public static float getAllVowels(StatisticalAnalysis sa) {

	    float vovelsCount = sa.countOf("a", "e", "i", "u", "o");
        float charSum = sa.size();
	
        float vovelsPercent = vovelsCount / charSum * 100;
        return vovelsPercent;
        }

    public static Integer calculatePercentage(StatisticalAnalysis sa, Integer percent){

        Integer number = (sa.size()*percent)/100;
        return number;
	}

    public static float getCountRatio(StatisticalAnalysis sa, String char1, String char2) {

        float countOfChar1 = sa.countOf(char1);
        float countOfChar2 = sa.countOf(char2);
        
        float ratio = countOfChar2 / countOfChar1;

        return ratio;
    }

    public static ArrayList<String> ratioOfCharacters(StatisticalAnalysis sa) {

        ArrayList<String> charsRatio = new ArrayList<String>();
        float allCharCount = sa.size();

        for (String ch : sa.getAllCharsForRatio()) {
            float countOfChar = sa.countOf(ch);
            float ratio = countOfChar / allCharCount * 100;
            String charWithCharRatio = ch + "->" + ratio;
            charsRatio.add(charWithCharRatio);
        }
        return charsRatio;
    }
}