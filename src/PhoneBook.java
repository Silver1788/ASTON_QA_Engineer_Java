import java.util.*;

public class PhoneBook {
    private final Map<String, List<String>> phoneBook = new HashMap<>(); // Словарь фамилия -> список телефонов

    /**
     * Добавляет номер телефона для указанной фамилии.
     * @param lastName Фамилия
     * @param phoneNumber Номер телефона
     */
    public void add(String lastName, String phoneNumber) {
        phoneBook.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phoneNumber);
    }

    /**
     * Ищет номера телефонов по фамилии.
     * @param lastName Фамилия
     * @return Список номеров телефонов (если фамилия отсутствует, возвращает пустой список)
     */
    public List<String> get(String lastName) {
        return phoneBook.getOrDefault(lastName, Collections.emptyList());
    }
}