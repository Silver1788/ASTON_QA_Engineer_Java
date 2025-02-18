import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CookiePage;
import pages.HomePage;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

// Перевести ранее написанный тест на использование паттерна PageObject
public class LectureFifteenTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.get("https://www.mts.by/");

        // Создание объектов страницы
        CookiePage cookiePage = new CookiePage(driver);

        // Принятие куки, если окно появляется
        if (cookiePage.isCookieBannerVisible()) {
            cookiePage.acceptCookies();
            System.out.println("Cookies приняты.");
        } else {
            System.out.println("Окно с куки не появилось.");
        }

        homePage = new HomePage(driver); // Инициализация объекта страницы
    }

    @Test
    void testBlockTitle() {
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        String actualTitle = homePage.getBlockTitle();
        Assertions.assertTrue(actualTitle.matches(expectedTitle), "Заголовок не соответствует.");
    }

    @Test
    void testPaymentSystemLogos() {
        String[] expectedLogos = {
                "Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"
        };
        for (String logo : expectedLogos) {
            Assertions.assertTrue(homePage.isPaymentSystemLogoVisible(logo), "Логотип " + logo + " не найден.");
        }
    }

    @Test
    void testMoreInfoLink() {
        homePage.clickMoreInfoLink();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, currentUrl, "Ссылка на 'Подробнее о сервисе' неверна.");
    }

    @Test
    void testPaymentForm() {
        homePage.fillPaymentForm("297777777", "10", "test@example.com");
    }

     // 1. Проверить надписи в незаполненных полях каждого варианта оплаты услуг: услуги связи, домашний интернет, рассрочка, задолженность;
    @Test
    void testDropdownOptions() {
        // Ожидаемые значения: id → placeholder
        Map<String, String> expectedFields = new HashMap<>();
        expectedFields.put("connection-phone", "Номер телефона");
        expectedFields.put("connection-sum", "Сумма");
        expectedFields.put("connection-email", "E-mail для отправки чека");

        expectedFields.put("internet-phone", "Номер абонента");
        expectedFields.put("internet-sum", "Сумма");
        expectedFields.put("internet-email", "E-mail для отправки чека");

        expectedFields.put("score-instalment", "Номер счета на 44");
        expectedFields.put("instalment-sum", "Сумма");
        expectedFields.put("instalment-email", "E-mail для отправки чека");

        expectedFields.put("score-arrears", "Номер счета на 2073");
        expectedFields.put("arrears-sum", "Сумма");
        expectedFields.put("arrears-email", "E-mail для отправки чека");

        for (String option : Arrays.asList("Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность")) {
            // Получаем реальные поля
            Map<String, String> actualFields = homePage.openDropdown(option);

            // Проверяем каждую найденную пару id → placeholder
            for (Map.Entry<String, String> entry : actualFields.entrySet()) {
                String expectedPlaceholder = expectedFields.get(entry.getKey());
                Assertions.assertEquals(expectedPlaceholder, entry.getValue(),
                        "Несовпадение плейсхолдера для id: " + entry.getKey());
            }
        }
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}