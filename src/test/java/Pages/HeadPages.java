package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

public class HeadPages {
    WebDriver driver;
    WebDriverWait wait;

    By usernameLocator = By.id("usernameInput");
    By passwordLocator = By.id("passwordInput");
    By loginButtonLocator = By.className("login-button");
    By websiteLogoLocator = By.className("website-logo");
    By navbarItemsLocator = By.xpath("//nav[@class='nav-header ']/child::div/ *");
    By homePageIconLocator = By.xpath("//a[@class='nav-link active-nav-link']");
    By popularPageIconLocator = By.xpath("//a[@class='nav-link']");
    By searchLogoIconLocator = By.cssSelector("button[class='search-empty-button']");
    By accountIconLocator = By.className("avatar-img");


    public HeadPages(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterUsername(String username){
        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void clickOnLogin(){
        driver.findElement(loginButtonLocator).click();
    }

    public void LoginApplication(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickOnLogin();
    }

    public void displayOfWebsiteLogo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(websiteLogoLocator));
        WebElement websiteLogo = driver.findElement(websiteLogoLocator);
        Assert.assertTrue(websiteLogo.isDisplayed(),"Logo not displayed");
        return;
    }

    public void elementsOfNavbar(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(navbarItemsLocator));
        List<WebElement> navItems = driver.findElements(navbarItemsLocator);
        // System.out.println(navItems.size());
        for(int i = 0; i < navItems.size(); i++){
            WebElement a = navItems.get(i);
            Assert.assertTrue(a.isDisplayed(),"Not Displayed");
        }
        return;
    }

    public void homeMovieNavigation(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageIconLocator));
        WebElement homeNavElement = driver.findElement(homePageIconLocator);
        homeNavElement.click();
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,expectedUrl,"URL's do not match");
        return;
    }

    public void popularNavigation(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(popularPageIconLocator));
        WebElement popularButton = driver.findElement(popularPageIconLocator);
        popularButton.click();
        String popularExpectedUrl = "https://qamoviesapp.ccbp.tech/popular";
        wait.until(ExpectedConditions.urlToBe(popularExpectedUrl));
        String currentPopularPage = driver.getCurrentUrl();
        Assert.assertEquals(popularExpectedUrl,currentPopularPage,"URL's do not match");
        return;
    }

    public void searchNavigation(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchLogoIconLocator));
        WebElement searchLogo = driver.findElement(searchLogoIconLocator);
        searchLogo.click();
        String expectedSearchPageUrl = "https://qamoviesapp.ccbp.tech/search";
        wait.until(ExpectedConditions.urlToBe(expectedSearchPageUrl));
        String currentSearchPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedSearchPageUrl,currentSearchPageUrl,"URL's do not match");
        return;
    }

    public void accountNavigation(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountIconLocator));
        WebElement accountImage = driver.findElement(accountIconLocator);
        accountImage.click();
        String expectedAccountUrl = "https://qamoviesapp.ccbp.tech/account";
        wait.until(ExpectedConditions.urlToBe(expectedAccountUrl));
        String currentAccountUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedAccountUrl,currentAccountUrl,"URl's do not match");
        return;
    }
}
