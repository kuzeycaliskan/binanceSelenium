package utils;


import org.binance.home.HomePage;
import org.binance.utils.ProjectProps;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.Properties;

public class BaseTest {
    public static ProjectProps projectProps;
    public static Properties envProps;

    public static WebDriver driver;
    public HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception{
        projectProps = new ProjectProps();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-notifications");
        options.addArguments("disable-popup-blocking");
        setWebDriver(new ChromeDriver(options));
        homePage = new HomePage(getWebDriver());
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static void setWebDriver(ChromeDriver chromeDriver) {
        BaseTest.driver = chromeDriver;
    }

}
