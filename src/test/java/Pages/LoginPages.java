package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPages {
    WebDriver driver;
    WebDriverWait wait;

    By websiteLogoLocator = By.xpath("//img[@class='login-website-logo']");
    By headingTextLocator = By.xpath("//h1[@class='sign-in-heading']");
    By usernameLabelLocator = By.xpath("//label[@for='usernameInput']");
    By passwordLabelLocator = By.xpath("//label[@for='passwordInput']");
    By LoginButtonLocator = By.xpath("//button[@class='login-button']");
    By ErrorMessageLocator = By.className("error-message");
    By passwordInputLocator = By.cssSelector("input#passwordInput");
    By usernameInputLocator = By.cssSelector("input#usernameInput");


    public LoginPages(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void checkingWebsiteLogoDisplayedOrNot(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(websiteLogoLocator));
        WebElement websiteLogo = driver.findElement(websiteLogoLocator);
        Assert.assertTrue(websiteLogo.isDisplayed(),"Website logo not displayed");
        return;
    }

    public void checkingHeadingText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingTextLocator));
        WebElement headingText = driver.findElement(headingTextLocator);
        String text = headingText.getText();
        Assert.assertEquals(text, "Login", "Not matched");
        return;
    }

    public void checkingTheUsernameLabelText(){
        WebElement userNameLabelLocator = driver.findElement(usernameLabelLocator);
        String text = userNameLabelLocator.getText();
        Assert.assertEquals(text,"USERNAME","Not Matched");
        return;
    }

    public void checkingThepasswordLabelText(){
        WebElement PasswordLabelLocator = driver.findElement(passwordLabelLocator);
        String text = PasswordLabelLocator.getText();
        Assert.assertEquals(text,"PASSWORD","Not Matched");
        return;
    }

    public void clickOnLoginButton(){
        WebElement loginButton = driver.findElement(LoginButtonLocator);
        loginButton.click();
        return;
    }

    public void LoginErrorMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageLocator));
        WebElement expectedErrorMessageLocator = driver.findElement(ErrorMessageLocator);
        String expectedMessage = expectedErrorMessageLocator.getText();
        Assert.assertEquals(expectedMessage,"*Username or password is invalid","Both Error messsages didn't match");
        return;
    }

    public void passwordInputKeys(String password){
        driver.findElement(passwordInputLocator).sendKeys(password);
    }

    public void emptyUsernameErrorMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageLocator));
        WebElement expectedErrorMessageLocator = driver.findElement(ErrorMessageLocator);
        String expectedMessage = expectedErrorMessageLocator.getText();
        Assert.assertEquals(expectedMessage,"*Username or password is invalid","Both Error messsages didn't match");
        return;
    }

    public void usernameInputKeys(String username){
        driver.findElement(usernameInputLocator).sendKeys(username);
    }

    public void loginFunctionality(String username, String password){
        usernameInputKeys(username);
        passwordInputKeys(password);
        clickOnLoginButton();
    }

    public void credentialsError(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageLocator));
        WebElement expectedErrorMessageLocator = driver.findElement(ErrorMessageLocator);
        String expectedMessage = expectedErrorMessageLocator.getText();
        Assert.assertEquals(expectedMessage,"*username and password didn't match","Both Error messsages didn't match");
        return;
    }

    public void homePageChecking(){
        String expectedHomePageUrl = "https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedHomePageUrl));
        String currentHomePageUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedHomePageUrl,currentHomePageUrl,"URL's didn't match");
        return;
    }
}
