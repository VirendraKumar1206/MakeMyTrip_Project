package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelDetailsPage {
    WebDriver driver;

    By breakfastCheckbox = By.xpath("(//span[text()='Breakfast Included'])[1]");
    By ratingsCheckbox = By.xpath("(//span[text()='Very Good: 3.5+'])[1]");
    By mountainViewCheckbox = By.xpath("(//span[text()='Mountain View'])[1]");
    By hotelSelection = By.xpath("(//span[text()='Blanket Hotel & Spa Munnar'])[1]");
    By bookNowButton = By.xpath("(//button[text()='BOOK THIS NOW'])[1]");
    By firstNameField = By.id("fName");
    By lastNameField = By.id("lName");
    By emailField = By.id("email");
    By contactNumberField = By.id("mNo");
    By confirmCheckbox = By.xpath("//p[text()='Confirm and save billing details to your profile']");
    By payNowButton = By.xpath("//a[text()='Pay Now']");
    By loginmenu = By.xpath("//p[text()='Login to prefill traveller details and get access to secret deals']");

    public HotelDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void applyFilters() throws InterruptedException {
        driver.findElement(breakfastCheckbox).click();
        Thread.sleep(3000);
        driver.findElement(ratingsCheckbox).click();
        Thread.sleep(3000);
        driver.findElement(mountainViewCheckbox).click();
        Thread.sleep(3000);
    }

    public void selectHotel() throws InterruptedException {
        driver.findElement(hotelSelection).click();
        Thread.sleep(5000);
    }

    public void switchToHotelDetailsWindow() {
        String childUrl = "https://www.makemytrip.com/hotels/hotel-details/?hotelId=201708281306414073&_uCurrency=INR&checkin=07282024&checkout=07312024&city=CTXMN&country=IN&filterData=HOTEL_PRICE_BUCKET%7C5000-2147483647%5EFREE_BREAKFAST_AVAIL%7CBREAKFAST_AVAIL%5EUSER_RATING_MMT_BRAND%7C3.5%5EROOM_VIEWS%7CMountain%20View&lat=10.04956&lng=77.05663&locusId=CTXMN&locusType=city&rank=1&regionNearByExp=3&roomStayQualifier=2e0e&rsc=1e2e0e&searchText=Munnar&viewType=PREMIUM&mtkeys=-2488288746843397781";
        String parentWindow = driver.getWindowHandle();
        Set<String> childIds = driver.getWindowHandles();
        for (String string : childIds) {
            driver.switchTo().window(string);
            if (driver.getCurrentUrl().contains(childUrl)) {
                break;
            }
        }
    }

    public void clickBookNowButton() throws InterruptedException {
        driver.findElement(bookNowButton).click();
        Thread.sleep(3000);
    }

    public void reviewYourBooking() {
        String childUrl2 = "https://www.makemytrip.com/hotels/hotel-review?_uCurrency=INR&checkin=07282024&checkout=07312024&city=CTXMN&country=IN&filterData=HOTEL_PRICE_BUCKET%7C5000-2147483647%5EFREE_BREAKFAST_AVAIL%7CBREAKFAST_AVAIL%5EUSER_RATING_MMT_BRAND%7C3.5%5EROOM_VIEWS%7CMountain%20View&hotelId=201708281306414073&lat=10.04956&lng=77.05663&locusId=CTXMN&locusType=city&mtKey=-2488288746843397781&mtkeys=-2488288746843397781&payMode=PAS&rank=3&regionNearByExp=3&roomCriteria=1028924~%7C~-2488288746843397781~%7C~2e0e&roomStayQualifier=2e0e&rsc=1e2e0e&searchText=Munnar&searchType=E&suppDetail=&viewType=PREMIUM";
        String parentWindow1 = driver.getWindowHandle();
        Set<String> childIds = driver.getWindowHandles();
        for (String child : childIds) {
            driver.switchTo().window(child);
            if (driver.getCurrentUrl().contains(childUrl2)) {
                break;
            }
        }
    }

    public void addGuestDetails(String firstName, String lastName, String email, String contactNumber) throws InterruptedException {
        WebElement guestDetailsSectionElement = driver.findElement(loginmenu);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", guestDetailsSectionElement);
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(firstNameField));
        
        driver.findElement(firstNameField).sendKeys(firstName);
        Thread.sleep(3000);
        driver.findElement(lastNameField).sendKeys(lastName);
        Thread.sleep(3000);
        driver.findElement(emailField).sendKeys(email);
        Thread.sleep(3000);
        driver.findElement(contactNumberField).sendKeys(contactNumber);
        Thread.sleep(3000);
        WebElement playbutton = driver.findElement(payNowButton);
        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("arguments[0].scrollIntoView()", playbutton);
        
        driver.findElement(confirmCheckbox).click();
        Thread.sleep(2000); // Optional: Add a small wait if necessary
    }

    public void clickPayNowButton() {
        driver.findElement(payNowButton).click();
    }
}
