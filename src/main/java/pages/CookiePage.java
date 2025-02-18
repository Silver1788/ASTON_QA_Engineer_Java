package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CookiePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Конструктор
    public CookiePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    // Метод для проверки наличия окна с куки и принятия
    public void acceptCookies() {
        // Проверка на наличие окна с куки
        try {
            WebElement cookieWrapper = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cookie__wrapper")));
            if (cookieWrapper.isDisplayed()) {
                // Нажатие кнопки "Принять"
                WebElement acceptButton = cookieWrapper.findElement(By.id("cookie-agree"));
                acceptButton.click();
            }
        } catch (Exception e) {
            System.out.println("Cookie banner not found or already accepted.");
        }
    }

    // Метод для проверки наличия настроек файлов cookie
    public boolean isCookieBannerVisible() {
        try {
            WebElement cookieWrapper = driver.findElement(By.className("cookie__wrapper"));
            return cookieWrapper.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
