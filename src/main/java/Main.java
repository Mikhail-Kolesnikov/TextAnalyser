import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        WordCounter wordCounter = new WordCounter();
        File file = new File("Books");
        Map<String, Integer> fileOfWords = wordCounter.countWord(file);
        Map<String, Integer> countOfLetters = wordCounter.countOfLetters(file);
        //System.out.println(fileOfWords);
        List<Map.Entry<String, Integer>> list = fileOfWords.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(20)
                .toList();
        //System.out.println(list);
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ", " + entry.getValue() + " раз ");

        }


        List<Map.Entry<String, Integer>> listOfLetters = countOfLetters.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .toList();
        Integer allLetters = listOfLetters.stream()
                .map(a -> a.getValue())
                .reduce((x, y) -> x + y)
                .get();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        for (Map.Entry<String, Integer> entry : listOfLetters) {
            System.out.println(entry.getKey() + ", " + entry.getValue() * 100.0 / allLetters  + " % ");


//кол буквы/общее кол букв*100
        }

    }
}
