package ru.practicum.tests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.practicum.pages.MainPage;
import ru.practicum.pages.OrderPage;
import ru.practicum.utill.EnvConfig;

@RunWith(Parameterized.class)
public class OrderTest {
    private final String nameField;
    private final String surnameField;
    private final String addressField;
    private final String stationName;
    private final String number;
    private final String date;
    private final String comment;

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    private WebDriver driver;
    private MainPage mainPage;
    private OrderPage orderPage;

    public OrderTest(String nameField, String surnameField, String addressField, String stationName, String number, String date, String comment) {
        this.nameField = nameField;
        this.surnameField = surnameField;
        this.addressField = addressField;
        this.stationName = stationName;
        this.number = number;
        this.date = date;
        this.comment = comment;
    }

    // Вспомогательный метод для заполнения данных и открытия страницы
    private void initPage() {
        driver = driverFactory.getDriver();
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
        orderPage = mainPage.activityButtonUp();
    }

    // Вспомогательный метод для заполнения формы
    private void fillOrderForm() {
        orderPage.addUserName(nameField);
        orderPage.addSurname(surnameField);
        orderPage.addOrderAddress(addressField);
        orderPage.addStationMetro(stationName);
        orderPage.addTeleNumber(number);
        orderPage.clickNextButton();
        orderPage.addDateOrder(date);
    }


    private void selectColorAndDate() {
        if (nameField.equals("Михаил")) {
            orderPage.clickBlackColor();
        } else if (nameField.equals("Олег")) {
            orderPage.clickGreyColor();
        }
        orderPage.clickDropdown();

        if (nameField.equals("Михаил")) {
            orderPage.clickSelectTwoDay();
        } else if (nameField.equals("Олег")) {
            orderPage.clickSelectFiveDay();
        }
    }
    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] dataField() {
        return new Object[][]{
                {"Михаил", "Пурируев", "Октябрьская улица", "Бульвар Рокоссовского", "89293212312", "20.04.2025", "Турируми"},
                {"Олег", "Алиев", "Пенза", "Черкизовская", "892536437812", "12.06.2025", "Пурирури"}
        };
    }

    @Test
    public void executeOrderTest() throws InterruptedException {
        initPage();
        fillOrderForm();
        selectColorAndDate();
        orderPage.addComment(comment);
        orderPage.orderScooter();
        orderPage.clickYesButton();
        orderPage.checkOrder();
    }


}

