import java.util.List;
import java.util.Map;

public class ResultPrinter {

    private static final int NUMBER_OF_TOP_WORDS = 20;
    private static final double ONE_HUNDRED_PERCENT = 100;


    public void printWords(Map<String, Integer> wordCounter) {


        int counter = 0;

        List<Map.Entry<String, Integer>> list = wordCounter.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(NUMBER_OF_TOP_WORDS)
                .toList();
        System.out.println("\n=========== ТОП 20 САМЫХ ЧАСТЫХ СЛОВ ===========");
        System.out.printf("%-5s | %-20s | %s\n", "№", "Слово", "Количество");
        System.out.println("-----------------------------------------------");
        for (Map.Entry<String, Integer> entry : list) {
            counter++;
            System.out.printf("%-5d | %-20s | %d раз\n", counter, entry.getKey(), entry.getValue());

        }

    }

    public void printLetters(Map<String, Integer> lettersCounter) {


        List<Map.Entry<String, Integer>> listOfLetters = lettersCounter.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .toList();
        int allLetters = listOfLetters.stream()
                .map(Map.Entry::getValue)
                .reduce(Integer::sum)
                .get();
        System.out.println("============= СТАТИСТИКА ПО БУКВАМ =============");
        System.out.printf("%-5s | %-10s | %s\n", "Буква", "Кол-во", "Доля (%)");
        System.out.println("-----------------------------------------------");
        for (Map.Entry<String, Integer> entry : listOfLetters) {
            System.out.printf("%-5s | %-10d | %.2f %%\n", entry.getKey(), entry.getValue(), entry.getValue() * ONE_HUNDRED_PERCENT / allLetters);
        }
        System.out.println("===============================================\n");
    }

}
