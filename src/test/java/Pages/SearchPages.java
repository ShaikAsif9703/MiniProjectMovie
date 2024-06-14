package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SearchPages {
    WebDriver driver;
    WebDriverWait wait;

    By usernameLocator = By.id("usernameInput");
    By passwordLocator = By.id("passwordInput");
    By loginButtonLocator = By.className("login-button");
    By searchLogoIconLocator = By.cssSelector("button[class='search-empty-button']");
    By searchInputLocator = By.id("search");
    By searchButtonLocator = By.className("search-button");
    By listOfMoviesDisplayed = By.xpath("//ul[@class='search-movies-container']/child::*");
    By emptyMoviesListLocator = By.xpath("//p[@class='not-found-search-paragraph']");


    public SearchPages(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterUsername(String username){
        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginButtonLocator).click();
    }

    public void loginIntoApplication(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public void enteringMovieNameInSearchInput(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchLogoIconLocator));
        WebElement searchButtonLocate = driver.findElement(searchLogoIconLocator);
        searchButtonLocate.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInputLocator));
        WebElement searchInput = driver.findElement(searchInputLocator);
        searchInput.sendKeys("venom");
        WebElement searchButton = driver.findElement(searchButtonLocator);
        searchButton.click();
        return;
    }

    public void displayedList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(listOfMoviesDisplayed));
        List<WebElement> movies = driver.findElements(listOfMoviesDisplayed);
        // System.out.println(movies.size());
        int count = 0;
        for(int i = 0; i < movies.size(); i++){
            WebElement a = movies.get(i);
            Assert.assertTrue(a.isDisplayed(),"Not Displayed");
            count++;
        }
        Assert.assertEquals(count,2,"Count not matched");
        WebElement oneMovie = movies.get(0);
        oneMovie.click();
        System.out.println(driver.getCurrentUrl());
        String expectedUrl = "https://qamoviesapp.ccbp.tech/movies/51b4602f-b0f2-4c81-98e0-a2a409b13926";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,currentUrl,"URL's do not match");
        return;
    }

    public void enterMovieInput(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchLogoIconLocator));
        WebElement searchButtonLocate = driver.findElement(searchLogoIconLocator);
        searchButtonLocate.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInputLocator));
        WebElement searchInput = driver.findElement(searchInputLocator);
        searchInput.sendKeys("spiderman");
        WebElement searchButton = driver.findElement(searchButtonLocator);
        searchButton.click();
        return;
    }

    public void nonDisplayedList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyMoviesListLocator));
        WebElement NotFoundMovieLocator = driver.findElement(emptyMoviesListLocator);
        // System.out.println(NotFoundMovieLocator.getText());
        String expectedNotMovieFound = "Your search for spiderman did not find any matches.";
        String currentNotMovieFound = NotFoundMovieLocator.getText();
        Assert.assertEquals(expectedNotMovieFound,currentNotMovieFound,"Error doesn't match");
        return;
    }

}
