package org.binance.home;

import org.binance.utils.BasePage;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class HomePage extends BasePage implements HomeLocators{

    public HomePage(WebDriver driver){
        super(driver);
    }

    public HomePage goToURLFromHomePage(String url){
        goToURL(url);
        return this;
    }

    public HomePage closeCookiesPopUpIfExist(){
        clickElement(By.xpath(cookiesReject));
        return this;
    }

    public HomePage clickMarkets(){
        clickElement(By.xpath(marketsText));
        return this;
    }
    public HomePage clickTrade(){
        clickElement(By.xpath(tradeText));
        return this;
    }

    public HomePage clickSpot(){
        clickElement(By.xpath(spotText));
        return this;
    }

    public HomePage getRandomFiveAboutLinks() throws InterruptedException {
        String elementURL = null;
        List<WebElement> aboutLinksList = findElements(By.xpath(aboutLinks));

        List<WebElement> selectedItems = new Random().ints(0, aboutLinksList.size())
                .distinct()
                .limit(5)
                .mapToObj(aboutLinksList::get)
                .collect(Collectors.toList());

        List<String> selectedItemText = new ArrayList<>();

        for (WebElement element : selectedItems) {
            System.out.println(element.getText());
            selectedItemText.add(element.getText());
        }

        for (String s: selectedItemText){
            System.out.println("Searching: " + s);
            elementURL = findElementByText(s).getAttribute("href");
            clickElementByText(s);
            Assert.assertEquals(elementURL, getCurrentURL(), "Navigated URL is not correct");
            Thread.sleep(3000);
        }

        return this;
    }

}
