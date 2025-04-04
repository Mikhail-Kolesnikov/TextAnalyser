import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {

    private List<String> blackList = List.of("был", "котор", "мен", "сво", "тольк", "одн", "больш");
    private List<String> blackListOfSymbols = List.of(" ", "", ".", ";", ",", "!", "?");

    public Map<String, Integer> countWord(File file) throws IOException {

        StemmerPorterRU stemmerPorterRU = new StemmerPorterRU();

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Map<String, Integer> allWords = new HashMap<>();


        while (true) {

            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            String[] words = line.split(" ");


            for (String word : words) {

                word = replaceSymbols(word, stemmerPorterRU);


                if (blackList.contains(word) || word.length() < 4) {
                    continue;
                }


                if (allWords.containsKey(word)) {
                    int count = allWords.get(word);
                    allWords.put(word, count + 1);


                } else {
                    allWords.put(word, 1);

                }

            }
        }
        return allWords;


    }

    private String replaceSymbols(String word, StemmerPorterRU stemmerPorterRU) {
        word = word.replace(",", "")
                .replace(".", "")
                .replace(":", "")
                .replace("!", "")
                .replace(";", "")
                .toLowerCase();


        word = stemmerPorterRU.stemming(word);
        return word;
    }

    public Map<String, Integer> countOfLetters(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Map<String, Integer> allLetters = new HashMap<>();

        while (true) {

            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            String[] letters = line.split("");

            for (String letter : letters) {

                if (blackListOfSymbols.contains(letter)) {
                    continue;
                }


                if (allLetters.containsKey(letter)) {
                    int count = allLetters.get(letter);
                    allLetters.put(letter, count + 1);


                } else {
                    allLetters.put(letter, 1);

                }

            }
        }
        return allLetters;


    }
}
