package ru.practicum.tests;

import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import ru.practicum.pages.MainPage;
import ru.practicum.utill.EnvConfig;

public class OpenOrderTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void openMainTest() throws InterruptedException {
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        assertTrue("Главная страница не загрузилась", mainPage.isPageLoaded());
    }

@Test
public void clickOrderUpTest() throws InterruptedException {
    WebDriver driver = driverFactory.getDriver();
    MainPage mainPage = new MainPage(driver);
    mainPage.openMainPage();
    mainPage.activityButtonUp();
    assertTrue("Кнопка вверх не сработала", mainPage.isActivityButtonUpVisible());
}

@Test
public void clickOrderDownTest() throws InterruptedException {
    WebDriver driver = driverFactory.getDriver();
    MainPage mainPage = new MainPage(driver);
    mainPage.openMainPage();
    mainPage.activityButtonDown();
    assertTrue("Кнопка вниз не сработала", mainPage.isActivityButtonDownVisible());
}
}
