package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import Pages.SearchPages;
public class SearchPageSteps {
    WebDriver driver;
    WebDriverWait wait;
    SearchPages searchDriver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        searchDriver = new SearchPages(driver);
    }

    @Given("I am in the application login page")
    public void credentialsPage(){
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @When("I enter into my account")
    public void loginIntoAccount(){
        searchDriver.loginIntoApplication("rahul","rahul@2021");
    }

    @And("I click search and enter a movie name")
    public void searchLogo(){
        searchDriver.enteringMovieNameInSearchInput();
    }

    @And("I click search and enter a movie")
    public void search(){
        searchDriver.enterMovieInput();
    }

    @Then("I can get the list of entered movie results")
    public void displayOfMovies(){
        searchDriver.displayedList();
    }

    @Then("I can get the error message of entered movie results")
    public void nonDisplayMovies(){
        searchDriver.nonDisplayedList();
    }

    @After
    public void driverClose(){
        driver.quit();
    }
}
