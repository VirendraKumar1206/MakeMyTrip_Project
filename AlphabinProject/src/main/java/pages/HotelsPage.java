package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelsPage {
    WebDriver driver;

    By locationInput = By.xpath("//span[text()='City, Property name or Location']");
    By locationInputField = By.xpath("//input[@placeholder='Where do you want to stay?']");
    By locationSelection = By.xpath("//p[text()='City in Kerala']");
    By checkInDate = By.xpath("(//div[@aria-label='Sun Jul 28 2024'])[1]");
    By checkOutDate = By.xpath("(//div[@aria-label='Wed Jul 31 2024'])[1]");
    By applyButton = By.xpath("(//button[text()='Apply'])[1]");
    By priceDropdown = By.xpath("(//span[text()='Price per Night'])[1]");
    By priceSelection = By.xpath("(//li[text()='₹5000+'])[1]");
    By searchButton = By.xpath("//button[text()='Search']");

    public HotelsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterLocation(String location) throws InterruptedException {
        driver.findElement(locationInput).click();
        Thread.sleep(2000);
        driver.findElement(locationInputField).sendKeys(location);
        Thread.sleep(2000);
        driver.findElement(locationSelection).click();
        Thread.sleep(2000);
    }

    public void selectDates() throws InterruptedException {
        driver.findElement(checkInDate).click();
        Thread.sleep(2000);
        driver.findElement(checkOutDate).click();
    }

    public void clickApplyButton() {
        driver.findElement(applyButton).click();
    }

    public void selectPrice() throws InterruptedException {
        driver.findElement(priceDropdown).click();
        Thread.sleep(2000);
        driver.findElement(priceSelection).click();
        Thread.sleep(2000);
    }

    public void clickSearchButton() throws InterruptedException {
        driver.findElement(searchButton).click();
        Thread.sleep(2000);
    }
}
