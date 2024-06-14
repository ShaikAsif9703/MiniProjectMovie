package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class HomePages {
    WebDriver driver;
    WebDriverWait wait;

    By usernameInputLocator = By.cssSelector("input#usernameInput");
    By passwordInputLocator = By.cssSelector("input#passwordInput");
    By loginButtonLocator = By.className("login-button");
    By movieSectionHeadings = By.cssSelector("h1.movies-list-heading");
    By playButtonLocator = By.xpath("//button[@class='home-movie-play-button']");
    By trendingNowMoviesLocator = By.xpath("//div[@class='home-bottom-container']/child::div[1]/child::div/child::div/child::div/child::div/descendant::img");
    By contactUsIconsLocator = By.xpath("//div[@class='footer-icons-container']/child::*");
    By contactUsLocator = By.className("contact-us-paragraph");

    public HomePages(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void userInput(String username){
        driver.findElement(usernameInputLocator).sendKeys(username);
    }

    public void passwordInput(String password){
        driver.findElement(passwordInputLocator).sendKeys(password);
    }

    public void loginButton(){
        driver.findElement(loginButtonLocator).click();
    }

    public void loginIntoApplication(String username, String password){
        userInput(username);
        passwordInput(password);
        loginButton();
    }

    public void checkingHeadingsOfEachSection(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieSectionHeadings));
        List<WebElement> currentMovieHeadingsList = driver.findElements(movieSectionHeadings);
        String[] expectedMovieHeadings = {"Trending Now", "Originals"};
        for(int i = 0; i < currentMovieHeadingsList.size(); i++){
            WebElement currentMovieHeading = currentMovieHeadingsList.get(i);
            String currentMovieHeadingText = currentMovieHeading.getText();
            String expectedMovieHeadingText = expectedMovieHeadings[i];
            Assert.assertEquals(currentMovieHeadingText,expectedMovieHeadingText,"Headings didn't match");
        }
        return;
    }

    public void checkingPlayButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(playButtonLocator));
        WebElement playButton = driver.findElement(playButtonLocator);
        Assert.assertTrue(playButton.isDisplayed(),"Play button is not displayed");
        return;
    }

    public void countingTrendingNowMoviesSection(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(trendingNowMoviesLocator));
        List<WebElement> trendingSectionList = driver.findElements(trendingNowMoviesLocator);
        for(int i = 0; i < trendingSectionList.size(); i++){
            WebElement trendingAndOriginalMovie = trendingSectionList.get(i);
            if(trendingAndOriginalMovie.isDisplayed()){
                continue;
            }else{
                break;
            }
        }
        return;
    }

    public void footerContactUsSection(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsIconsLocator));
        List<WebElement> icons = driver.findElements(contactUsIconsLocator);
        for(int i = 0; i < icons.size(); i++){
            WebElement icon = icons.get(i);
            Assert.assertTrue(icon.isDisplayed(),"Not Displayed");
        }
        WebElement contactUsText = driver.findElement(contactUsLocator);
        Assert.assertTrue(contactUsText.isDisplayed(),"Not Displayed");
        return;
    }
}
