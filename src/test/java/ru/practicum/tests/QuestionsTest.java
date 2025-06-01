package ru.practicum.tests;
import java.lang.InterruptedException;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.practicum.pages.MainPage;
import ru.practicum.utill.EnvConfig;

public class QuestionsTest {
    @Rule
    public DriverFactory driverFactory = new DriverFactory();
    @Test
    public void questRunTest() throws InterruptedException {
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickQuestOne();
        mainPage.waitTextQuestOne(EnvConfig.ONE_TEXT);
        mainPage.clickQuestTwo();
        mainPage.waitTextQuestTwo(EnvConfig.TWO_TEXT);
        mainPage.clickQuestThree();
        mainPage.waitTextQuestThree(EnvConfig.THREE_TEXT);
        mainPage.clickQuestFour();
        mainPage.waitTextQuestFour(EnvConfig.FOUR_TEXT);
        mainPage.clickQuestFive();
        mainPage.waitTextQuestFive(EnvConfig.FIVE_TEXT);
        mainPage.clickQuestSix();
        mainPage.waitTextQuestSix(EnvConfig.SIX_TEXT);
        mainPage.clickQuestSeven();
        mainPage.waitTextQuestSeven(EnvConfig.SEVEN_TEXT);
        mainPage.clickQuestEight();
        mainPage.waitTextQuestEight(EnvConfig.EIGHT_TEXT);









    }



}

