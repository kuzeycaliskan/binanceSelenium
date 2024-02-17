package org.binance.home;

import org.binance.utils.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    public HomePage goToURLFromHomePage(String url){
        goToURL(url);
        return this;
    }

}
