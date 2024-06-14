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
import Pages.MovieDetailsPages;
import java.time.Duration;
public class MovieDetailsPageSteps {
    WebDriver driver;
    WebDriverWait wait;
    MovieDetailsPages movieDriver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        movieDriver = new MovieDetailsPages(driver);
    }

    @Given("I'm in the login page")
    public void url(){
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @When("I enter into my account with credentials")
    public void myAccount(){
        movieDriver.enterUsername("rahul");
        movieDriver.enterPassword("rahul@2021");
        movieDriver.loginButton();
    }

    @And("I click on the home section movie")
    public void homeButton(){
        movieDriver.homePageMovie();
    }

    @And("I click on the popular section movie")
    public void popularButton(){
        movieDriver.popularPageMovie();
    }

    @Then("I check all UI elements in home section")
    public void uiElementsOfHome(){
        movieDriver.homeUiElements();
    }

    @Then("I check all UI elements in popular section")
    public void uiElementsOfPopular(){
        movieDriver.popularUiElements();
    }

    @After
    public void tear(){
        driver.quit();
    }
}
