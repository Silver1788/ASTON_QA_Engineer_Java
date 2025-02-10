package test;

import org.testng.annotations.*;

import static org.testng.Assert.*;

public class FactorialTestNGTest {

    @BeforeClass
    public void beforeAllTests() {
        System.out.println("Начало тестирования LectureTwelve (TestNG)");
    }

    @AfterClass
    public void afterAllTests() {
        System.out.println("Окончание тестирования LectureTwelve (TestNG)");
    }

    @BeforeMethod
    public void beforeEachTest() {
        System.out.println("Начало нового теста");
    }

    @AfterMethod
    public void afterEachTest() {
        System.out.println("Тест завершен");
    }

    @Test
    public void testCalculateFactorial() {
        assertEquals(main.LectureTwelve.calculateFactorial(5), 120, "Факториал 5 должен быть 120");
        assertEquals(main.LectureTwelve.calculateFactorial(0), 1, "Факториал 0 должен быть 1");
        assertEquals(main.LectureTwelve.calculateFactorial(1), 1, "Факториал 1 должен быть 1");
        assertEquals(main.LectureTwelve.calculateFactorial(7), 5040, "Факториал 7 должен быть 5040");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateFactorialNegativeNumber() {
        main.LectureTwelve.calculateFactorial(-1); // Должно выбросить исключение
    }

    @Test(enabled = false)
    public void disabledTest() {
        fail("Этот тест отключен и не должен выполняться");
    }

    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][] {
                {3, 6},
                {4, 24},
                {6, 720}
        };
    }

    @Test(dataProvider = "factorialData")
    public void testFactorialWithDataProvider(int number, int expected) {
        assertEquals(main.LectureTwelve.calculateFactorial(number), expected, "Ошибка в расчёте факториала");
    }
}
