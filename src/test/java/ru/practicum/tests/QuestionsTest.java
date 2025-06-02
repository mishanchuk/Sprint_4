package ru.practicum.tests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.practicum.pages.MainPage;
import ru.practicum.utill.EnvConfig;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class QuestionsTest {
    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    private String questionMethod;
    private String expectedText;

    public QuestionsTest(String questionMethod, String expectedText) {
        this.questionMethod = questionMethod;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters(name = "Проверка: {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"clickQuestPay", EnvConfig.ONE_TEXT},
                {"clickQuestManyScooter", EnvConfig.TWO_TEXT},
                {"clickQuestTime", EnvConfig.THREE_TEXT},
                {"clickQuestTodayOrder", EnvConfig.FOUR_TEXT},
                {"clickQuestProlongScooter", EnvConfig.FIVE_TEXT},
                {"clickQuestChargingScooter", EnvConfig.SIX_TEXT},
                {"clickQuestCancelOrder", EnvConfig.SEVEN_TEXT},
                {"clickQuestDeliveryScooter", EnvConfig.EIGHT_TEXT}
        });
    }

    @Test
    public void questCheck() throws InterruptedException {
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();

        switch (questionMethod) {
            case "clickQuestPay":
                mainPage.clickQuestPay();
                mainPage.waitTextQuestPay(expectedText);
                break;
            case "clickQuestManyScooter":
                mainPage.clickQuestManyScooter();
                mainPage.waitTextQuestManyScooter(expectedText);
                break;
            case "clickQuestTime":
                mainPage.clickQuestTime();
                mainPage.waitTextQuestTime(expectedText);
                break;
            case "clickQuestTodayOrder":
                mainPage.clickQuestTodayOrder();
                mainPage.waitTextQuesTodayOrder(expectedText);
                break;
            case "clickQuestProlongScooter":
                mainPage.clickQuestProlongScooter();
                mainPage.waitTextQuestProlongScooter(expectedText);
                break;
            case "clickQuestChargingScooter":
                mainPage.clickQuestChargingScooter();
                mainPage.waitTextQuestChargingScooter(expectedText);
                break;
            case "clickQuestCancelOrder":
                mainPage.clickQuestCancelOrder();
                mainPage.waitTextQuestCancelOrder(expectedText);
                break;
            case "clickQuestDeliveryScooter":
                mainPage.clickQuestDeliveryScooter();
                mainPage.waitTextQuestDeliveryScooter(expectedText);
                break;
        }
    }
}





