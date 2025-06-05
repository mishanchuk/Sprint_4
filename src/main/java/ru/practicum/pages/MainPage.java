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
    private final By lastLocate = By.tagName("script");
    private final By userName = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Имя']");
    private final By openMain = By.cssSelector(".Home_Header__iJKdX");
    private final By buttonUp = By.cssSelector(".Button_Button__ra12g");
    private final By buttonDown = By.cssSelector(".Button_Button__ra12g.Button_UltraBig__UU3Lp");

    private String locatorQuestTemplate = "#accordion__heading-%d";
    private String locatorAnswerTemplate = "#accordion__panel-%d";

    public void openMainPage() {
        driver.get(EnvConfig.BASE_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        wait.until(ExpectedConditions.presenceOfElementLocated(lastLocate));
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Универсальный метод для клика по вопросу
    public void clickQuestionByIndex(int index) {
        By locator = By.cssSelector(String.format(locatorQuestTemplate, index));
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator));
        scrollToElement(element);
        element.click();
    }

    // Универсальный метод для получения ответа по индексу
    public String getAnswerTextByIndex(int index) {
        By locator = By.cssSelector(String.format(locatorAnswerTemplate, index));
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
        return element.getText();
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