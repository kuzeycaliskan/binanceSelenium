package utils;


import org.binance.coin.CoinPage;
import org.binance.home.HomePage;
import org.binance.login.LoginPage;
import org.binance.market.MarketPage;
import org.binance.trade.TradePage;
import org.binance.utils.ProjectProps;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.URL;

public class BaseTest {
    public static ProjectProps projectProps;

    public static WebDriver driver;
    public HomePage homePage;
    public MarketPage marketPage;
    public TradePage tradePage;
    public LoginPage loginPage;
    public CoinPage coinPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception{
        projectProps = new ProjectProps();

        // Selenium Hub'a bağlanmak için URL oluşturma
        URL hubUrl = new URL("http://localhost:4444/wd/hub");

        // Tarayıcıları yapılandırmak için DesiredCapabilities oluşturma
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WINDOWS);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-notifications");
        options.addArguments("disable-popup-blocking");
        options.addArguments("--incognito");

        setWebDriver(new RemoteWebDriver(hubUrl, options));

        homePage = new HomePage(getDriver());
        marketPage = new MarketPage(getDriver());
        tradePage = new TradePage(getDriver());
        loginPage = new LoginPage(getDriver());
        coinPage = new CoinPage(getDriver());
        homePage.goToURLFromHomePage(projectProps.getPropertyValue("base_url"));
        Thread.sleep(5000);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setWebDriver(WebDriver chromeDriver) {
        BaseTest.driver = chromeDriver;
    }

    @AfterClass(alwaysRun = true)
    public void teardown(){
        driver.quit();
        //TODO -> "Teardown Steps can be written here..."
    }

}
