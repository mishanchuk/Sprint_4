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
    private By lastLocate = By.tagName("script");
    private By userName = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Имя']");
    private By payQuest = By.cssSelector("#accordion__heading-0");
    private By payRespons = By.cssSelector("#accordion__panel-0");
    private By manyScooterQuest = By.cssSelector("#accordion__heading-1");
    private By manyScooterRespons = By.cssSelector("#accordion__panel-1");
    private By timeQuest = By.cssSelector("#accordion__heading-2");
    private By timeRespons = By.cssSelector("#accordion__panel-2");
    private By orderTodayQuest = By.cssSelector("#accordion__heading-3");
    private By orderTodayRespons = By.cssSelector("#accordion__panel-3");
    private By prolongScooterQuest = By.cssSelector("#accordion__heading-4");
    private By prolongScooterRespons = By.cssSelector("#accordion__panel-4");
    private By chargingScooterQuest = By.cssSelector("#accordion__heading-5");
    private By chargingScooterRespons = By.cssSelector("#accordion__panel-5");
    private By cancelOrderQuest = By.cssSelector("#accordion__heading-6");
    private By cancelOrderRespons = By.cssSelector("#accordion__panel-6");
    private By deliveryScooterQuest = By.cssSelector("#accordion__heading-7");
    private By deliveryScooterRespons = By.cssSelector("#accordion__panel-7");
    private By openMain = By.cssSelector(".Home_Header__iJKdX");
    private By buttonUp = By.cssSelector(".Button_Button__ra12g");
    private By buttonDown = By.cssSelector(".Button_Button__ra12g.Button_UltraBig__UU3Lp");

    public void openMainPage() {
        driver.get(EnvConfig.BASE_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        wait.until(ExpectedConditions.presenceOfElementLocated(lastLocate));
    }
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void clickQuestPay(){
        WebElement element = driver.findElement(payQuest);
        scrollToElement(element);
        element.click();
    }
    public void waitTextQuestPay(String expectedText){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(payRespons, expectedText));
    }
    public void clickQuestManyScooter(){
        WebElement element = driver.findElement(manyScooterQuest);
        scrollToElement(element);
        element.click();
    }
    public void waitTextQuestManyScooter(String expectedText){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(manyScooterRespons, expectedText));
    }
    public void clickQuestTime(){
        WebElement element = driver.findElement(timeQuest);
        scrollToElement(element);
        element.click();
    }
    public void waitTextQuestTime(String expectedText){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(timeRespons, expectedText));
    }
    public void clickQuestTodayOrder(){
        WebElement element = driver.findElement(orderTodayQuest);
        scrollToElement(element);
        element.click();
    }
    public void waitTextQuesTodayOrder(String expectedText){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(orderTodayRespons, expectedText));
    }
    public void clickQuestProlongScooter(){
        WebElement element = driver.findElement(prolongScooterQuest);
        scrollToElement(element);
        element.click();
    }
    public void waitTextQuestProlongScooter(String expectedText){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(prolongScooterRespons, expectedText));
    }
    public void clickQuestChargingScooter(){
        WebElement element = driver.findElement(chargingScooterQuest);
        scrollToElement(element);
        element.click();
    }
    public void waitTextQuestChargingScooter(String expectedText){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(chargingScooterRespons, expectedText));
    }
    public void clickQuestCancelOrder(){
        WebElement element =driver.findElement(cancelOrderQuest);
        scrollToElement(element);
        element.click();

    }
    public void waitTextQuestCancelOrder(String expectedText){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(cancelOrderRespons, expectedText));
    }
    public void clickQuestDeliveryScooter(){
        WebElement element = driver.findElement(deliveryScooterQuest);
        scrollToElement(element);
        element.click();
    }
    public void waitTextQuestDeliveryScooter(String expectedText){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(deliveryScooterRespons, expectedText));
    }
    public OrderPage activityButtonUp(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        wait.until(ExpectedConditions.presenceOfElementLocated(lastLocate));
        driver.findElement(buttonUp).click();
        return new OrderPage(driver);
    }
    public void activityButtonDown(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        wait.until(ExpectedConditions.presenceOfElementLocated(lastLocate));
        WebElement element = driver.findElement(buttonDown);
        scrollToElement(element);
        element.click();
    }

    public boolean isPageLoaded() {
        return driver.findElement(openMain).isDisplayed();
    }

    public boolean isActivityButtonUpVisible() {
        return driver.findElement(userName).isDisplayed();
    }

    public boolean isActivityButtonDownVisible() {
        return driver.findElement(userName).isDisplayed();
    }

}
