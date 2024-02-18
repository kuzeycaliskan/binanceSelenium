package org.binance.coin;

import org.binance.utils.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

public class CoinPage extends BasePage implements CoinLocators {
    public CoinPage(WebDriver driver) {
        super(driver);
    }

    public CoinPage driverSwitchToNewTab(){
        String mainWindowHandle = driver.getWindowHandle();

        String newTabHandle = driver.getWindowHandles().stream()
                .filter(handle -> !handle.equals(mainWindowHandle)) // Ana sekmenin tanımlayıcısını hariç tut
                .findFirst() // İlk yeni sekmenin tanımlayıcısını al
                .orElseThrow(() -> new RuntimeException("Yeni sekme bulunamadı"));

        // Yeni sekmenin içeriğine geç
        driver.switchTo().window(newTabHandle);
        return this;
    }

    public CoinPage checkCoinPage(){
        driverSwitchToNewTab();
        Assert.assertTrue(getElementVisibility(By.xpath(chartLabel)), "chartLabel not displayed well");
        Assert.assertTrue(getElementVisibility(By.xpath(orderFormLabel)), "orderFormLabel not displayed well");
        Assert.assertTrue(getElementVisibility(By.xpath(orderBookLabel)), "orderBookLabel not displayed well");
        Assert.assertTrue(getElementVisibility(By.xpath(userinfoLabel)), "userinfoLabel not displayed well");
        Assert.assertTrue(getElementVisibility(By.xpath(tradesLabel)), "tradesLabel not displayed well");
        Assert.assertTrue(getElementVisibility(By.xpath(desktopApp)), "stableConnectionText not displayed well");
        Assert.assertTrue(getElementVisibility(By.xpath(stableConnectionText)), "stableConnectionText not displayed well");

        return this;
    }
}
