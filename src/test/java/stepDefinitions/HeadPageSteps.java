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
import Pages.HeadPages;
public class HeadPageSteps {
    WebDriver driver;
    WebDriverWait wait;
    HeadPages headDriver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        headDriver = new HeadPages(driver);
    }

    @Given("I am in the movie login page url")
    public void loginPageUrl(){
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @When("I enter my username and password")
    public void enteringCredentials(){
        headDriver.enterUsername("rahul");
        headDriver.enterPassword("rahul@2021");
    }

    @And("I click login button")
    public void loginButton(){
        headDriver.clickOnLogin();
    }

    @Then("I can check the home page logo is displayed or not")
    public void websiteLogoDisplayed(){
        headDriver.displayOfWebsiteLogo();
    }

    @Then("I can check the navbar elements in header section")
    public void navbarElements(){
        headDriver.elementsOfNavbar();
    }

    @Then("I can navigate to home section")
    public void homeSection(){
        headDriver.homeMovieNavigation();
    }

    @Then("I can navigate to popular section")
    public void popularSection(){
        headDriver.popularNavigation();
    }

    @Then("I can navigate to search section")
    public void searchSection(){
        headDriver.searchNavigation();
    }

    @Then("I can navigate to account section")
    public void accountSection(){
        headDriver.accountNavigation();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
