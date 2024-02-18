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
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static utils.DriverOptions.*;

public class SetupRemoteWebDriver {

    public enum BrowserType {
        CHROME,
        CHROME_HEADLESS,
        FIREFOX,
        FIREFOX_HEADLESS,
        EDGE
    }

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static final String FILE_DOWNLOAD_DIRECTORY = System.getProperty("user.dir") + "\\downloads";
    private static final String REMOTE_URL = "http://localhost:4444";
    public static ProjectProps projectProps;

    public HomePage homePage;
    public MarketPage marketPage;
    public TradePage tradePage;
    public LoginPage loginPage;
    public CoinPage coinPage;

    @BeforeTest
    public void setup() throws IOException, InterruptedException {
        projectProps = new ProjectProps();

        BrowserType browserType = BrowserType.CHROME;
        driver.set(new RemoteWebDriver(new URL(REMOTE_URL), getDesiredCapabilities(browserType)));
        getDriver().navigate().to(projectProps.getPropertyValue("base_url"));

        homePage = new HomePage(getDriver());
        marketPage = new MarketPage(getDriver());
        tradePage = new TradePage(getDriver());
        loginPage = new LoginPage(getDriver());
        coinPage = new CoinPage(getDriver());

        Thread.sleep(5000); // wait for file download
    }

    private static DesiredCapabilities getDesiredCapabilities(BrowserType browserType) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.ANY);

        switch (browserType) {
            case FIREFOX:
                capabilities.setBrowserName("firefox");
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, createFirefoxOptions());
                break;
            case FIREFOX_HEADLESS:
                capabilities.setBrowserName("firefox");
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, createFirefoxHeadlessOptions());
                break;
            case CHROME:
                capabilities.setBrowserName("chrome");
                capabilities.setCapability(ChromeOptions.CAPABILITY, createChromeOptions());
                break;
            case CHROME_HEADLESS:
                capabilities.setBrowserName("chrome");
                capabilities.setCapability(ChromeOptions.CAPABILITY, createChromeHeadlessOptions());
                break;
            case EDGE:
                capabilities.setBrowserName("MicrosoftEdge");
                capabilities.setCapability(EdgeOptions.CAPABILITY, createEdgeOptions());
                break;
            default:
                throw new IllegalArgumentException(String.format("Invalid BROWSER TYPE = %s specified", browserType));
        }
        return capabilities;
    }

    private static WebDriver getDriver() {
        return driver.get();
    }

    @AfterTest
    public void teardown() {
        getDriver().quit();
        driver.remove();
    }

}
