package org.binance.home;

public interface HomeLocators {
    String marketsText = "//*[text()='Piyasalar']";
    String cookiesReject = "//*[@id=\"onetrust-reject-all-handler\"]";
    String tradeText = "//span[text()='Al-Sat']";
    String spotText = "//div[text()='Spot']";
    String aboutLinks = "//h3[text()='Hakkımızda']/following-sibling::ul/li/a";
}
