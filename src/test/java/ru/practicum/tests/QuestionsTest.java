package ru.practicum.tests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.practicum.pages.MainPage;
import ru.practicum.utill.EnvConfig;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class QuestionsTest {
    private final int questionIndex; // номер вопроса
    private final String expectedAnswer; // ожидаемый ответ

    public QuestionsTest(int questionIndex, String expectedAnswer) {
        this.questionIndex = questionIndex;
        this.expectedAnswer = expectedAnswer;
    }
    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Parameterized.Parameters(name = "Тестовые данные: индекс={0}, ожидаемый ответ={1}")
    public static Collection<Object[]> questions() {
        return Arrays.asList(new Object[][] {
                {0, EnvConfig.PAY_TEXT},
                {1, EnvConfig.MANY_SCOOTER_TEXT},
                {2, EnvConfig.TIME_TEXT},
                {3, EnvConfig.TODAY_ORDER_TEXT},
                {4, EnvConfig.PROLONG_SCOOTER_TEXT},
                {5, EnvConfig.CHARGING_SCOOTER_TEXT},
                {6, EnvConfig.CANCEL_ORDER_TEXT},
                {7, EnvConfig.DELIVERY_SCOOTER_TEXT}

        });
    }


    @Test
    public void testQuestionAnswer() {
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        // Кликаем по вопросу
        mainPage.clickQuestionByIndex(questionIndex);
        // Получаем ответ
        String actualAnswer = mainPage.getAnswerTextByIndex(questionIndex);
        // Ассерт
        assert actualAnswer.contains(expectedAnswer);
    }
}