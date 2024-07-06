package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.HotelsPage;
import pages.HotelDetailsPage;

public class BookingSteps {
    WebDriver driver;
    HomePage homePage;
    HotelsPage hotelsPage;
    HotelDetailsPage hotelDetailsPage;

    @Given("Open browser")
    public void open_browser() {
    	  System.setProperty("webdriver.gecko.driver", "D:\\Download\\geckodriver\\geckodriver.exe");       
    	driver = new FirefoxDriver();
        homePage = new HomePage(driver);
        hotelsPage = new HotelsPage(driver);
        hotelDetailsPage = new HotelDetailsPage(driver);
    }

    @Given("Enter url")
    public void enter_url() {
        driver.get("https://www.makemytrip.com/");
    }

    @When("Click on hotels")
    public void click_on_hotels() {
        homePage.clickOnHotels();
    }

    @When("Click on location")
    public void click_on_location() throws InterruptedException {
        hotelsPage.enterLocation("Munnar");
    }

    @When("Fetch dates")
    public void fetch_dates() throws InterruptedException {
        hotelsPage.selectDates();
    }

    @When("Click on apply button")
    public void click_on_apply_button() {
        hotelsPage.clickApplyButton();
    }

    @When("Select price from dropdown")
    public void select_price_from_dropdown() throws InterruptedException {
        hotelsPage.selectPrice();
    }

    @When("Click on search button")
    public void click_on_search_button() throws InterruptedException {
        hotelsPage.clickSearchButton();
    }

    @Then("Search result should be display")
    public void search_result_should_be_display() {
        System.out.println("Search result is displaying");
    }

    @Then("List of hotels should be display")
    public void list_of_hotels_should_be_display() throws InterruptedException {
        System.out.println("Lots of numbers of hotels are visible");
        Thread.sleep(3000);
    }

    @When("Click on breakfast include checkbox")
    public void click_on_breakfast_include_checkbox() throws InterruptedException {
        hotelDetailsPage.applyFilters();
    }

    @When("Click on ratings checkbox")
    public void click_on_ratings_checkbox() throws InterruptedException {
        hotelDetailsPage.applyFilters();
    }

    @When("Click on mountain view checkbox")
    public void click_on_mountain_view_checkbox() throws InterruptedException {
        hotelDetailsPage.applyFilters();
    }

    @When("Select Hotel Blanket Hotel & Spa Munnar")
    public void select_Hotel_Blanket_Hotel_Spa_Munnar() throws InterruptedException {
        hotelDetailsPage.selectHotel();
    }

    @When("Click on Bookthisnow button")
    public void click_on_Bookthisnow_button() throws InterruptedException {
        hotelDetailsPage.switchToHotelDetailsWindow();
        hotelDetailsPage.clickBookNowButton();
    }

    @When("Add guest details")
    public void add_guest_details() throws InterruptedException {
        hotelDetailsPage.addGuestDetails("Virendra", "Kumar", "chakravartivirendra45@gmail.com", "8448037120");

    }

    @When("Click on paynow button")
    public void click_on_paynow_button() {
        hotelDetailsPage.clickPayNowButton();
    }

    @Then("Booking should be confirmed")
    public void booking_should_be_confirmed() {
        System.out.println("Booking confirmed!");
        driver.quit();
    }
}
