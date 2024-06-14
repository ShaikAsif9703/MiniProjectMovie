package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.AccountPages;
public class AccountPageSteps {
    WebDriver driver;
    AccountPages accountDriver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        accountDriver = new AccountPages(driver);
    }

    @Given("I'm in the movie login page url")
    public void urlMovie(){
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @When("I login into my account with requirements")
    public void myAccountLogin(){
       accountDriver.enterUsername("rahul");
       accountDriver.enterPassword("rahul@2021");
    }

    @And("I press the login button")
    public void button(){
        accountDriver.loginButton();
    }

    @Then("I can be able to check all the ui elements")
    public void accountPage(){
        accountDriver.accountUiElements();
    }

    @Then("I can be go to account and logout successfully")
    public void logout(){
        accountDriver.logoutButton();
    }

    @After
    public void driverCloseAll(){
        driver.quit();
    }
}
