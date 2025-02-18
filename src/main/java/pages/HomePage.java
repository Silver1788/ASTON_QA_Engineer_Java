package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import org.junit.jupiter.api.Assertions;


public class HomePage {
    private WebDriver driver;

    // Конструктор
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Элемент блока «Онлайн пополнение без комиссии»
    private By blockTitle = By.className("pay__wrapper");

    // Элементы выпадающего списка
    private By selectButton = By.className("select__header");
    private By selectOption = By.className("select__option");
    private By selectedOptionText = By.className("select__now");

    // Метод для получения заголовка блока
    public String getBlockTitle() {
        WebElement block = driver.findElement(blockTitle);
        WebElement title = block.findElement(By.tagName("h2"));
        return title.getText();
    }

    // Метод для получения логотипов платёжных систем
    public boolean isPaymentSystemLogoVisible(String altText) {
        try {
            WebElement logo = driver.findElement(By.xpath("//img[@alt='" + altText + "']"));
            return logo.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Метод для перехода по ссылке «Подробнее о сервисе»
    public void clickMoreInfoLink() {
        WebElement moreInfoLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        moreInfoLink.click();
    }

    // Метод для заполнения формы «Услуги связи»
    public void fillPaymentForm(String phone, String sum, String email) {
        WebElement selectDropdown = driver.findElement(By.className("select__wrapper"));
        selectDropdown.click();

        WebElement option = driver.findElement(By.xpath("//option[@value='Услуги связи']"));
        option.click();

        WebElement phoneInput = driver.findElement(By.id("connection-phone"));
        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        WebElement emailInput = driver.findElement(By.id("connection-email"));
        WebElement submitButton = driver.findElement(By.xpath("//form[@id='pay-connection']//button[@type='submit']"));

        phoneInput.sendKeys(phone);
        sumInput.sendKeys(sum);
        emailInput.sendKeys(email);

        if (submitButton.isEnabled()) {
            submitButton.click();
        }
    }

    // Открытие выпадающего меню и выбор опции
    public Map<String, String> openDropdown(String optionText) {
        // Открываем выпадающее меню
        WebElement button = driver.findElement(selectButton);
        button.click();

        // Ожидаем появления выпадающего списка
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Ищем нужную опцию и кликаем по ней
        WebElement option = driver.findElement(By.xpath("//p[text()='" + optionText + "']"));
        option.click();

        // Получаем все доступные поля в открытой форме
        List<WebElement> inputFields = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//form[@class='pay-form opened']//input[not(@disabled) and not(@type='hidden') and not(contains(@style, 'display: none'))]")));

        // Храним id и placeholder
        Map<String, String> fieldsMap = new HashMap<>();
        System.out.println("\nДля опции '" + optionText + "' найдены следующие поля:");

        for (WebElement field : inputFields) {
            String fieldId = field.getAttribute("id");
            String placeholder = field.getAttribute("placeholder");
            System.out.println(fieldId + " - " + placeholder);
            fieldsMap.put(fieldId, placeholder);
        }

        return fieldsMap; // Возвращаем map id → placeholder
    }
}
