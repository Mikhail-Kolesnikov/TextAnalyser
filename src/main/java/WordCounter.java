import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {

    private List<String> blackList = List.of("когда", "чтобы", "если", "этого", "себя", "который", "этом", "которые", "него");
    private List<String> blackListOfSymbols= List.of(" ", "", ".", ";", ",", "!", "?");

    public Map<String, Integer> countWord(File file) throws IOException {
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

                word = word.replace(",", "")
                        .replace(".", "")
                        .replace(":", "")
                        .replace("!", "")
                        .replace(";", "")
                        .toLowerCase();

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

                if(blackListOfSymbols.contains(letter)){
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
