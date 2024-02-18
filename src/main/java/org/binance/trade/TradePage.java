package org.binance.trade;

import org.binance.home.HomeLocators;
import org.binance.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TradePage extends BasePage implements TradeLocators {

    public TradePage(WebDriver driver) {
        super(driver);
    }

    public TradePage clickLogin(){
        clickElement(By.xpath(loginButton));
        return this;
    }
}
