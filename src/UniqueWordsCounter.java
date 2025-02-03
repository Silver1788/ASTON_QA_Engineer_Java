import java.util.*;

public class UniqueWordsCounter {
    private final String[] words; // Массив слов

    public UniqueWordsCounter(String[] words) {
        this.words = words;
    }

    /**
     * Метод подсчитывает количество вхождений каждого слова в массиве.
     * @return Map, где ключ - слово, значение - количество повторений.
     */

    public Map<String, Integer> countWords() {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }
}
