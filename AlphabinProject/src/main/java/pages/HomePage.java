package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By hotelsLink = By.xpath("(//span[text()='Hotels'])[1]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnHotels() {
        driver.findElement(hotelsLink).click();
    }
}
