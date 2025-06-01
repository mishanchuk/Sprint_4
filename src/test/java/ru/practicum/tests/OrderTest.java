package ru.practicum.tests;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.practicum.pages.MainPage;
import ru.practicum.pages.OrderPage;
import ru.practicum.utill.EnvConfig;
import java.util.Arrays;
import java.util.List;

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

    public OrderTest(String nameField, String surnameField, String addressField, String stationName, String number, String date,String comment) {
        this.nameField = nameField;
        this.surnameField = surnameField;
        this.addressField = addressField;
        this.stationName = stationName;
        this.number = number;
        this.date = date;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] dataField() {
        return new Object[][]{
        {"Михаил", "Пурируев", "Октябарьская улица", "Бульвар Рокоссовского", "89293212312", "20.04.2025", "Турирури"},
        {"Олег", "Алиев", "Пенза", "Черкизовская", "892536437812", "12.06.2025", "Пурирури"}
    };
    }

    @Test
    public void executOrderTest() throws InterruptedException {
        driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        OrderPage orderPage = mainPage.activityButtonUp();
        orderPage.addUserName(nameField);
        orderPage.addSurname(surnameField);
        orderPage.addOrderAddress(addressField);
        orderPage.addStationMetro(stationName);
        orderPage.addTeleNumber(number);
        orderPage.clickNextButton();
        orderPage.addDateOrder(date);

        if ( nameField.equals("Михаил")) {
            orderPage.clickBlackColor();
        } else if (nameField.equals("Олег")){
            orderPage.clickGreyColor();
        }
        orderPage.clickDropdown();
        if ( nameField.equals("Михаил")) {
            orderPage.clickSelectTwoDay();
        } else if (nameField.equals("Олег")){
            orderPage.clickSelectFiveDay();
        }
       orderPage.addComment(comment);
       orderPage.orderScooter();
       orderPage.clickYesButton();
       orderPage.checkOrder();


    }
}

