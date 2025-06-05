package ru.practicum.tests;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.practicum.utill.EnvConfig;

import java.time.Duration;

public class DriverFactory extends ExternalResource {

    public WebDriver getDriver() {
        return driver;
    }
    private WebDriver driver;

    public void initDriver(){
        if("chrome".equals(System.getProperty("browser"))) {
            startChrome();

        }else{
            startFirefox();

        }
    }

    private void startChrome() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        driver.manage().window().maximize();
    }

    private void startFirefox() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(EnvConfig.IMLICITY_TIMOUT));
        driver.manage().window().maximize();

    }

    @Override
    protected void before() throws Throwable {
        initDriver();
    }

   @Override
    protected void after() {
      driver.quit();
    }
}
