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
import Pages.HomePages;
public class HomePageSteps {
    WebDriver driver;
    WebDriverWait wait;
    HomePages homeDriver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homeDriver = new HomePages(driver);
    }

    @Given("I am in the movie page url")
    public void urlPage(){
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @When("I gave credentials of username and password")
    public void loginIntoAccount(){
        homeDriver.userInput("rahul");
        homeDriver.passwordInput("rahul@2021");
    }

    @And("I click on login button")
    public void loginButtonClick(){
        homeDriver.loginButton();
    }

    @Then("navigate to home page and check the headings of each section")
    public void headingsOfEachSection(){
        homeDriver.checkingHeadingsOfEachSection();
    }

    @Then("Navigated to the home page and check the play button")
    public void plauButtonDisplay(){
        homeDriver.checkingPlayButton();
    }

    @Then("I check the trending now and Original movies and count")
    public void trendingMoviesCount(){
        homeDriver.countingTrendingNowMoviesSection();
    }

    @Then("I check icons of footer section and contact us")
    public void checkingContactUsSection(){
        homeDriver.footerContactUsSection();
    }

    @After
    public void close(){
        driver.quit();
    }
}
