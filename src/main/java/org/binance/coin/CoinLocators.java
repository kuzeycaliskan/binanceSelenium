package org.binance.coin;

public interface CoinLocators {
    String desktopApp = "//div[@id='__APP']";
    String chartLabel = "//div/div[@name='chart']";
    String orderFormLabel = "//div/div[@name='orderform']";
    String orderBookLabel = "//div/div[@name='orderbook']";
    String userinfoLabel = "//div/div[@name='userinfo']";
    String tradesLabel = "//div/div[@name='trades']";
    String stableConnectionText = "//div/div[text()='Bağlantı istikrarlı']";
}
