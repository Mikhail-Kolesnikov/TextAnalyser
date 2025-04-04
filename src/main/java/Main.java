import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String nameOfBook = scanner.nextLine();

        WordCounter wordCounter = new WordCounter();
        File file = new File(nameOfBook);

        Map<String, Integer> fileOfWords = wordCounter.countWord(file);
        Map<String, Integer> countOfLetters = wordCounter.countOfLetters(file);
        ResultPrinter resultPrinter = new ResultPrinter();
        resultPrinter.printWords(fileOfWords);
        resultPrinter.printLetters(countOfLetters);

        }

    }

