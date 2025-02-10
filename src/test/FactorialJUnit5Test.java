package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class FactorialJUnit5Test {

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("Начало тестирования LectureTwelve");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("Окончание тестирования LectureTwelve");
    }

    @BeforeEach
    void beforeEachTest() {
        System.out.println("Начало нового теста");
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("Тест завершен");
    }

    @Test
    @DisplayName("Проверка расчёта факториала")
    void testCalculateFactorial() {
        assertEquals(120, main.LectureTwelve.calculateFactorial(5)); // 5! = 120
        assertEquals(1, main.LectureTwelve.calculateFactorial(0));  // 0! = 1
        assertEquals(1, main.LectureTwelve.calculateFactorial(1));  // 1! = 1
        assertEquals(5040, main.LectureTwelve.calculateFactorial(7)); // 7! = 5040
    }

    @Test
    @DisplayName("Проверка исключения при отрицательном числе")
    void testCalculateFactorialNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            main.LectureTwelve.calculateFactorial(-1); // Должен выбросить исключение
        });
    }

    @Disabled("Отключенный тест")
    @Test
    void disabledTest() {
        fail("Этот тест отключен и не должен выполняться");
    }
}