package ru.practicum.pages;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practicum.utill.EnvConfig;


import java.time.Duration;

import static org.junit.Assert.assertEquals;


public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    private By oneQuest = By.cssSelector("#accordion__heading-0");
    private By oneRespons = By.cssSelector("#accordion__panel-0");
    private By twoQuest = By.cssSelector("#accordion__heading-1");
    private By twoRespons = By.cssSelector("#accordion__panel-1");
    private By threeQuest = By.cssSelector("#accordion__heading-2");
    private By threeRespons = By.cssSelector("#accordion__panel-2");
    private By fourQuest = By.cssSelector("#accordion__heading-3");
    private By fourRespons = By.cssSelector("#accordion__panel-3");
    private By fiveQuest = By.cssSelector("#accordion__heading-4");
    private By fiveRespons = By.cssSelector("#accordion__panel-4");
    private By sixQuest = By.cssSelector("#accordion__heading-5");
    private By sixRespons = By.cssSelector("#accordion__panel-5");
    private By sevenQuest = By.cssSelector("#accordion__heading-6");
    private By sevenRespons = By.cssSelector("#accordion__panel-6");
    private By eightQuest = By.cssSelector("#accordion__heading-7");
    private By eightRespons = By.cssSelector("#accordion__panel-7");
    private By buttonUp = By.cssSelector(".Button_Button__ra12g");
    private By buttonDown = By.cssSelector(".Button_Button__ra12g.Button_UltraBig__UU3Lp");
    // Не знаю как поправить но в Яндекс браузере элемент немного по другому называется
    public void openMainPage() {
        driver.get(EnvConfig.BASE_URL);
    }
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void clickQuestOne(){
        WebElement element = driver.findElement(oneQuest);
        scrollToElement(element);
        element.click();
    }
    public void waitTextQuestOne(String expectedText){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(oneRespons, expectedText));
    }
    public void clickQuestTwo(){
        driver.findElement(twoQuest).click();
    }
    public void waitTextQuestTwo(String expectedText){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(twoRespons, expectedText));
    }
    public void clickQuestThree(){
        driver.findElement(threeQuest).click();
    }
    public void waitTextQuestThree(String expectedText){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(threeRespons, expectedText));
    }
    public void clickQuestFour(){
        driver.findElement(fourQuest).click();
    }
    public void waitTextQuestFour(String expectedText){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(fourRespons, expectedText));
    }
    public void clickQuestFive(){
        driver.findElement(fiveQuest).click();
    }
    public void waitTextQuestFive(String expectedText){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(fiveRespons, expectedText));
    }
    public void clickQuestSix(){
        WebElement element = driver.findElement(sixQuest);
        scrollToElement(element);
        element.click();
    }
    public void waitTextQuestSix(String expectedText){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(sixRespons, expectedText));
    }
    public void clickQuestSeven(){
        driver.findElement(sevenQuest).click();
    }
    public void waitTextQuestSeven(String expectedText){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(sevenRespons, expectedText));
    }
    public void clickQuestEight(){
        driver.findElement(eightQuest).click();
    }
    public void waitTextQuestEight(String expectedText){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(eightRespons, expectedText));
    }
    public OrderPage activityButtonUp(){
        driver.findElement(buttonUp).click();
        return new OrderPage(driver);
    }
    public void activityButtonDown(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        wait.until(ExpectedConditions.presenceOfElementLocated(buttonDown));
        WebElement element = driver.findElement(buttonDown);
        scrollToElement(element);
        element.click();
    }
    public void activityButtonDowno(){
        driver.findElement(buttonDown).click();
    }

}
