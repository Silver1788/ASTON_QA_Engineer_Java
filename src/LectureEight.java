public class LectureEight {
    /**
     * 1. Напишите метод, на вход которого подаётся двумерный строковый
     * массив размером 4х4. При подаче массива другого размера
     * необходимо бросить исключение MyArraySizeException
     *
     * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение
     * MyArrayDataException с детализацией, в какой именно ячейке лежат
     * неверные данные.
     *
     * 3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException и вывести результат расчета.
     * @param args
     */
    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "X", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Тест с корректным массивом
        try {
            System.out.println("Сумма элементов: " + ArrayProcessor.processArray(validArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Тест с массивом неправильного размера
        try {
            System.out.println("Сумма элементов: " + ArrayProcessor.processArray(invalidSizeArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Тест с массивом, содержащим некорректные данные
        try {
            System.out.println("Сумма элементов: " + ArrayProcessor.processArray(invalidDataArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
