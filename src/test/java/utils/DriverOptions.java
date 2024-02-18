package utils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverOptions extends SetupRemoteWebDriver {

    protected static FirefoxOptions createFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = createFirefoxProfile();
        options.setProfile(profile);
        options.addArguments("--start-maximized");
        return options;
    }

    protected static FirefoxOptions createFirefoxHeadlessOptions() {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = createFirefoxProfile();
        options.setProfile(profile);
        options.addArguments("-headless");
        options.addArguments("--start-maximized");
        return options;
    }

    protected static ChromeOptions createChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
        options.setExperimentalOption("prefs", createChromePreferences());
        return options;
    }

    protected static ChromeOptions createChromeHeadlessOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--start-maximized");
        options.setExperimentalOption("prefs", createChromePreferences());
        options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
        return options;
    }

    protected static EdgeOptions createEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
        options.setExperimentalOption("prefs", createEdgePreferences());
        return options;
    }

    private static FirefoxProfile createFirefoxProfile() {
        FirefoxProfile profile = new FirefoxProfile();
        // Set additional Firefox profile settings if needed
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", FILE_DOWNLOAD_DIRECTORY);
        profile.setPreference("pdfjs.disabled", true);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "text/csv,application/pdf,application/csv,application/vnd.ms-excel");
        return profile;
    }

    private static Map<String, Object> createChromePreferences() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", FILE_DOWNLOAD_DIRECTORY);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.open_pdf_in_system_reader", false);
        prefs.put("plugins.always_open_pdf_externally", true);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        return prefs;
    }

    private static Map<String, Object> createEdgePreferences() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", FILE_DOWNLOAD_DIRECTORY);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.open_pdf_in_system_reader", false);
        prefs.put("plugins.always_open_pdf_externally", true);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        return prefs;
    }

}
