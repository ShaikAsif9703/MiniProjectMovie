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
import Pages.PopularPages;
public class PopularPageSteps {
    WebDriver driver;
    WebDriverWait wait;
    PopularPages popularDriver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        popularDriver = new PopularPages(driver);
    }

    @Given("I am in the movie application login page")
    public void movieApplicationLoginPage(){
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @When("I enter the credentials of my account")
    public void usernameAndPassword(){
        popularDriver.enterUsername("rahul");
        popularDriver.enterPassword("rahul@2021");
    }

    @And("I login by clicking the login button")
    public void buttonLogin(){
        popularDriver.loginButton();
    }

    @Then("I can check the movies are displayed or not")
    public void popularMoviesSection(){
        popularDriver.popularMoviesList();
    }

    @After
    public void driverClose(){
        driver.quit();
    }
}
