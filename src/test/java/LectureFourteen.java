import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LectureFourteen {
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Необходимо написать автотесты для сайта mts.by . Суть тестов заключается в проверке блока «Онлайн пополнение без комиссии»:
     * 1. Проверить название указанного блока;
     * 2. Проверить наличие логотипов платёжных систем;
     * 3. Проверить работу ссылки «Подробнее о сервисе»;
     * 4. Заполнить поля и проверить работу кнопки «Продолжить» (проверяем только вариант «Услуги связи», номер для теста 297777777)
     */

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);

        // Переход на страницу
        driver.get("https://www.mts.by/");

        // Проверим, есть ли окно с куки
        WebElement cookiePopup = wait.until(driver -> driver.findElement(By.className("cookie__wrapper")));
        if (cookiePopup.isDisplayed()) {
            WebElement acceptCookiesButton = cookiePopup.findElement(By.id("cookie-agree"));
            // Нажимаем "Принять" для принятия cookies
            acceptCookiesButton.click();
            System.out.println("Cookies приняты.");
        } else {
            System.out.println("Окно с куки не появилось.");
        }
    }

    @Test
    void testBlockTitle() {
        try {
            // Поиск элемента pay__wrapper, затем аголовка h2 внутри него
            WebElement blockTitle = wait.until(driver -> driver.findElement(By.className("pay__wrapper")));
            WebElement h2 = blockTitle.findElement(By.tagName("h2"));

            String expectedPattern = "Онлайн пополнение\\s*без комиссии"; // Регулярное выражение для поиска нужного заголовка

            // Получаем весь текст заголовка
            String actualText = h2.getText();
            System.out.println("Заголовок: " + actualText);
            if (actualText.matches(expectedPattern)) {
                System.out.println("Заголовок верный.");
            } else {
                System.out.println("Заголовок не соответствует.");
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка во время теста: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    void testPaymentSystemLogos() {
        try {
            String[] expectedLogos = {
                    "Visa",
                    "Verified By Visa",
                    "MasterCard",
                    "MasterCard Secure Code",
                    "Белкарт"
            };
            for (String altText : expectedLogos) {
                try {
                    WebElement logo = wait.until(driver -> driver.findElement(By.xpath("//img[@alt='" + altText + "']")));
                    System.out.println("Логотип найден: " + altText);
                } catch (TimeoutException e) {
                    System.out.println("Ошибка: логотип не найден - " + altText);
                }
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка во время теста: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    void testMoreInfoLink() {
        try {
            // Ожидание появления ссылки "Подробнее о сервисе"
            WebElement moreInfoLink = wait.until(driver -> driver.findElement(By.linkText("Подробнее о сервисе")));

            // Переход по ссылке
            moreInfoLink.click();
            System.out.println("Переход по ссылке");

            String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals(expectedUrl)) {
                System.out.println("Ссылка на 'Подробнее о сервисе' верна и ведёт на " + currentUrl);
            } else {
                System.out.println("Ссылка на 'Подробнее о сервисе' не ведёт на нужный ресурс.");
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка во время теста: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    void testPaymentForm() {
        try {
            // Ожидание появления выпадающего списка
            WebElement selectDropdown = wait.until(driver -> driver.findElement(By.className("select__wrapper")));
            selectDropdown.click(); // Открываем список

            // Выбор "Услуги связи"
            WebElement option = wait.until(driver -> driver.findElement(By.xpath("//option[@value='Услуги связи']")));
            option.click();

            // Ожидание загрузки формы
            WebElement phoneInput = wait.until(driver -> driver.findElement(By.id("connection-phone")));
            WebElement sumInput = driver.findElement(By.id("connection-sum"));
            WebElement emailInput = driver.findElement(By.id("connection-email"));
            WebElement submitButton = driver.findElement(By.xpath("//form[@id='pay-connection']//button[@type='submit']"));

            // Ввод данных
            phoneInput.sendKeys("297777777");
            sumInput.sendKeys("10");
            emailInput.sendKeys("test@example.com");

            // Проверка доступности кнопки
            if (submitButton.isEnabled()) {
                System.out.println("Кнопка 'Продолжить' активна.");
                submitButton.click();
            } else {
                System.out.println("Ошибка: кнопка 'Продолжить' неактивна.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка во время выполнения теста: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}