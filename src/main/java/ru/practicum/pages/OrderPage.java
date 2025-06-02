package ru.practicum.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practicum.utill.EnvConfig;

import java.time.Duration;
import java.util.List;

public class OrderPage {
    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    private By userName = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Имя']");
    private By userSurname = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Фамилия']");
    private By orderAddress = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Адрес: куда привезти заказ']");
    private By stationMetroSelect = By.cssSelector(".select-search__input");
    private By teleNumber = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[contains(@class,'Button_Button__ra12g Button_Middle__1CSJM') and normalize-space(text())='Далее']");
    private By dateOrder = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Когда привезти самокат']");
    private By dropdownControl = By.cssSelector(".Dropdown-placeholder");
    private By selectTwoDay = By.xpath(".//div[@class='Dropdown-option' and contains(text(), 'двое суток')]");
    private By selectFiveDay = By.xpath(".//div[@class='Dropdown-option' and contains(text(), 'пятеро суток')]");
    private By selectBlackColor = By.cssSelector("#black[class='Checkbox_Input__14A2w']");
    private By selectGrayColor = By.cssSelector("#grey[class='Checkbox_Input__14A2w']");
    private By commentOrder = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='Комментарий для курьера']");
    private By finalOrderButton = By.xpath(".//button[contains(@class,'Button_Button__ra12g Button_Middle__1CSJM') and normalize-space(text())='Заказать']");
    private By yesButton = By.xpath(".//button[contains(@class,'Button_Button__ra12g Button_Middle__1CSJM') and normalize-space(text())='Да']");
    private By dropDownList = By.xpath("//div[@class='select-search__select']//div");
    private By popUpSearch = By.cssSelector(".Order_Text__2broi");

    public void addUserName(String nameField) {
        driver.findElement(userName).sendKeys(nameField);
    }
    public void addSurname(String surnemeField){
        driver.findElement(userSurname).sendKeys(surnemeField);
    }
    public void addOrderAddress(String addressField){
        driver.findElement(orderAddress).sendKeys(addressField);
    }
    public void addStationMetro(String stationName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        WebElement dropdownField = wait
                .until(ExpectedConditions.elementToBeClickable(stationMetroSelect));
        dropdownField
                .click();
            wait
                .until(ExpectedConditions.visibilityOfElementLocated(dropDownList));
        List<WebElement> options = driver.findElements(dropDownList);
        for (WebElement option : options) {
            if (option
                    .getText().equals(stationName)) {
                option
                        .click();
                break;
            }
        }
    }
    public void addTeleNumber(String number){
        driver.findElement(teleNumber)
                .sendKeys(number);
    }
    public void clickNextButton(){
        driver.findElement(nextButton)
                .click();
    }
    public void addDateOrder(String date){
        driver.findElement(dateOrder)
                .sendKeys(date);
    }
    public void clickDropdown(){
        driver.findElement(dropdownControl)
                .click();
    }
    public void clickSelectTwoDay(){
        driver.findElement(selectTwoDay)
                .click();
    }
    public void clickSelectFiveDay(){
        driver.findElement(selectFiveDay)
                .click();
    }
    public void clickBlackColor(){
        driver.findElement(selectBlackColor)
                .click();
    }
    public void clickGreyColor(){
        driver.findElement(selectGrayColor)
                .click();
    }
    public void addComment(String comment){
        driver.findElement(commentOrder)
                .sendKeys(comment);
    }
    public void orderScooter(){
        driver.findElement(finalOrderButton)
                .click();
    }
    public void clickYesButton(){
        driver.findElement(yesButton)
                .click();
    }
    public void checkOrder() {

        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPICITY_TIMOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(popUpSearch));
        Assert.assertTrue("Окно ошибки не отображается", driver.findElement(popUpSearch).isDisplayed());
    }

}

