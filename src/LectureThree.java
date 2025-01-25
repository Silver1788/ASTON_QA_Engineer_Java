import java.util.Random;
import static java.lang.System.out;

public class LectureThree {
    public static Random random = new Random();

    /**
     * 1. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple.
     */
    public static void printWords() {
        out.println("_______________________________________\nЗадание 1");
        out.println("Orange\nBanana\nApple");
    }

    /**
     * 2. Создайте метод checkSumSign(), в теле которого объявите две int переменные а и b, и инициализируйте их любыми значениями, которыми захотите.
     * Далее метод должен просуммировать эти переменные, и если их сумма больше или равна О, то вывести в консоль сообщение "Сумма положительная",
     * в противном случае - "Сумма отрицательная";
     */
    public static void checkSumSign() {
        out.println("_______________________________________\nЗадание 2");

        int a = random.nextInt(100) -50;
        int b = random.nextInt(100) -50;
        out.println(String.format("Значения a и b: %d, %d", a, b));

        if (a + b >= 0) {
            out.println("Сумма положительная");
        } else {
            out.println("Сумма отрицательная");
        }
    }

    /**
     * 3. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением.
     * Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение "Красный",
     * если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то "Желтый",
     * если больше 100 (100 исключительно) - "Зеленый";
     */
    public static void printColor() {
        out.println("_______________________________________\nЗадание 3");

        int value = random.nextInt(200) - 50;
        out.println(String.format("Значениe value: %d", value));

        if (value <= 0) {
            out.println("Красный");
        } else if (value > 0 && value <= 100) {
            out.println("Жётлый");
        } else {
            out.println("Зелёный");
        }
    }

    /**
     * 4. Создайте метод compareNumbers(), в теле которого объявите две int переменные а и b, и инициализируйте их любыми значениями, которыми захотите.
     * Если а больше или равно b, то необходимо вывести в консоль собщение "а >= b", в противном случае "а < b";
     */
    public static void compareNumbers() {
        out.println("_______________________________________\nЗадание 4");

        int a = random.nextInt(100) - 50; // Можно задать любое значение
        int b = random.nextInt(100) - 50; // Можно задать любое значение
        out.println(String.format("Значения a и b: %d, %d", a, b));
        out.println(String.format("a %s b", a >= b ? ">=" : "<"));
    }

    /**
     * 5. Напишите метод, принимающий на вход два целых числа и проверяющий,
     * что их сумма лежит в пределах от 10 до 20 (включительно), если да - вернуть true, в противном случае - false.
     * @param a Первое целое число
     * @param b Второе целое число
     * @return Лежит ли сумма в пределах от 10 до 20 (включительно) - true/false
     */
    public static boolean isSumInRange(int a, int b) {
        out.println("_______________________________________\nЗадание 5");
        out.println(String.format("Значения a и b: %d, %d", a, b));

        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    /**
     * 6. Напишите метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное ли число передали или отрицательное.
     * Замечание: ноль считаем положительным числом.
     * @param number Целое число
     */
    public static void checkNumberSign(int number) {
        out.println("_______________________________________\nЗадание 6");
        out.println(String.format("Значение: %d", number));

        if (number >= 0) {
            out.println("Число положительное");
        } else {
            out.println("Число отрицатальное");
        }
    }

    /**
     * 7. Напишите метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
     * Замечание: ноль считаем положительным числом.
     * @param number Целое число
     * @return true, если число отрицательное, false если положительное
     */
    public static boolean isNegative(int number) {
        out.println("_______________________________________\nЗадание 7");
        out.println(String.format("Значение: %d", number));

        return number < 0;
    }

    /**
     * 8. Напишите метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль указанную строку, указанное количество раз;
     * @param str Строка
     * @param times Количество
     */
    public static void printStringNTime(String str, int times) {
        out.println("_______________________________________\nЗадание 8");
        out.println(String.format("Слово %s и количество %d", str, times));

        for (int i = 0; i < times; i++) {
            out.println(str);
        }
    }

    /**
     * 9. Напишите метод который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false).
     * Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й - високосный.
     * @return Год високосный - true, не високосный - false
     */
    public static boolean isLeapYear() {

        int year = random.nextInt(200) + 1900;
        out.println("_______________________________________\nЗадание 9");
        out.println(String.format("Год: %d", year));

        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * 10. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    public static void invertArray() {
        out.println("_______________________________________\nЗадание 10");

        int[] array  = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
        for (int i : array) {
            out.print(i + " ");
        }
        out.println(); // Перенос строки после вывода массива
    }

    /**
     * 11. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
     */
    public static void fillArray() {
        out.println("_______________________________________\nЗадание 11");

        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        for (int i : array) {
            out.print(i + " ");
        }
        out.println();
    }


    /**
     * 12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
     */
    public static void modifyArray() {
        out.println("_______________________________________\nЗадание 12");

        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        for (int i : array) {
            out.print(i + " ");
        }
        out.println();
    }


    /**
     * 13. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
     * и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
     * Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
     */
    public static void fillDiagonal() {
        out.println("_______________________________________\nЗадание 13");

        int[][] array = new int[5][5];
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[i][array.length - 1 - i] = 1;
        }
        for (int[] row : array) {
            for (int elem : row) {
                out.print(elem + " ");
            }
            out.println();
        }
    }

    /**
     * 14. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue.
     * @param len Длина
     * @param initialValue Значение ячеек
     */
    public static void createArray(int len, int initialValue) {
        out.println("_______________________________________\nЗадание 14");
        out.println(String.format("Значения len и initialValue: %d, %d", len, initialValue));

        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        for (int i : array) {
            out.print(i + " ");
        }
        out.println();
    }

    public static void main(String[] args) {
        printWords();
        checkSumSign();
        printColor();
        compareNumbers();
        out.println(isSumInRange(random.nextInt(10) + 0, random.nextInt(10) + 0));
        checkNumberSign(random.nextInt(100) - 50);
        out.println(isNegative(random.nextInt(100) - 50));
        printStringNTime("Hello!", 3);
        out.println(isLeapYear());
        invertArray();
        fillArray();
        modifyArray();
        fillDiagonal();
        createArray(5,10);
    }
}
