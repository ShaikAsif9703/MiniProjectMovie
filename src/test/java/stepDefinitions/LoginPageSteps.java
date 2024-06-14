package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Pages.LoginPages;
import java.time.Duration;
public class LoginPageSteps {
    WebDriver driver;
    WebDriverWait wait;
    LoginPages loginDriver;
    @Before
    public void setUp(){
        System.setProperty("webddriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        loginDriver = new LoginPages(driver);
    }

    @Given("I am in the login page url")
    public void loginPageUrl(){
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @When("I click on the login button")
    public void clickingOnLoginButton(){
        loginDriver.clickOnLoginButton();
    }

    @When("I gave only password without username")
    public void loginWithEmptyUsername(){
        loginDriver.passwordInputKeys("rahul@2021");
    }

    @When("I gave only username without password")
    public void loginWithEmptyPassword(){
        loginDriver.usernameInputKeys("rahul");
    }

    @When("I gave the wrong credentials")
    public void invalidCredentials(){
        loginDriver.loginFunctionality("rahul","rahul2021");
    }

    @When("I gave the correct credentials")
    public void validCredentials(){
        loginDriver.loginFunctionality("rahul", "rahul@2021");
    }
    @Then("I check whether the logo is diaplayed or not")
    public void websiteLogo(){
        loginDriver.checkingWebsiteLogoDisplayedOrNot();
    }

    @Then("I check the heading text is Login")
    public void HeadingTextLogin(){
        loginDriver.checkingHeadingText();
    }

    @Then("I can check the username label is USERNAME")
    public void checkingTheUsernameLabel(){
        loginDriver.checkingTheUsernameLabelText();
    }

    @Then("I can check the password label is PASSWORD")
    public void checkingThePasswordLabel(){
        loginDriver.checkingThepasswordLabelText();
    }

    @Then("Error login message will be displayed")
    public void LoginFailureMessage(){
        loginDriver.LoginErrorMessage();
    }

    @Then("Error message will be displayed about credential")
    public void usernameErrorMessage(){
        loginDriver.emptyUsernameErrorMessage();
    }

    @Then("Error message will be displayed about wrong credential")
    public void InvalidCredentialErrorMessage(){
        loginDriver.credentialsError();
    }

    @Then("navigate to home page")
    public void homePage(){
        loginDriver.homePageChecking();
    }

    @After
    public void quit(){
        driver.quit();
    }

}
