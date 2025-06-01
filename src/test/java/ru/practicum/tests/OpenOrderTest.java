package ru.practicum.tests;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.practicum.pages.MainPage;
import ru.practicum.utill.EnvConfig;
import java.lang.InterruptedException;

public class OpenOrderTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();
    @Test
    public void clickOrderTest() throws InterruptedException {
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.activityButtonUp();
        mainPage.openMainPage();
        mainPage.activityButtonDown();









    }

}
