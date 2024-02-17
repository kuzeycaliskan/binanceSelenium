package org.binance.utils;

import org.binance.home.HomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public  void getURL(String url){
        driver.get(url);
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public void goToURL(String url){
        driver.navigate().to(url);
    }

    public WebElement findElement(By by){
        untilElementVisible(by);
        return driver.findElement(by);
    }

    public void clearTextField(By elementBy){
        untilElementVisible(elementBy);
        highlightElement(driver.findElement(elementBy));
        driver.findElement(elementBy).clear();
    }

    public void fillInputTextBox(By elementBy, String text){
        untilElementVisible(elementBy);
        highlightElement(driver.findElement(elementBy));
        driver.findElement(elementBy).sendKeys(text);
    }

    public void clickElement (By elementBy){
        untilElementVisible(elementBy);
        highlightElement(driver.findElement(elementBy));
        driver.findElement(elementBy).click();
    }

    public void hoverElement (By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public String getText(By by){
        untilElementVisible(by);
        return findElement(by).getText();
    }

    protected void driverWait(int millisecond){
        try {
            Thread.sleep(millisecond);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void scrollPageUp(int pixel){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixel + ")");
    }

    public void scrollPageDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,0)");
    }

    protected void untilElementVisible(By elementBy) {
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
            highlightElement(element);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void highlightElement(WebElement element) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
                " border: 3px solid red;");
    }

}
