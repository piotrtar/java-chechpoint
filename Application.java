import java.util.Iterator;

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

			View.printMostUsedWord(wordSA.showOccuredMoreThan(1));

			View.printOccuredWord("love", wordSA.countOcurredWord("love"));
			View.printOccuredWord("hate", wordSA.countOcurredWord("hate"));
			View.printOccuredWord("music", wordSA.countOcurredWord("music"));
			
			View.printVowels(charSA.getAllVowels());
		}
	}	
}