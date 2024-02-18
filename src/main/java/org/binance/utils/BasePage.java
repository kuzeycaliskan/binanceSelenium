package org.binance.utils;

import org.binance.home.HomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    ProjectProps projectProps;
    public WebDriver driver;
    public WebDriverWait wait;
    public WebElement element;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        projectProps = new ProjectProps();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public ProjectProps getProjectProps() {
        return projectProps;
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

    public boolean getElementVisibility(By by){
        return driver.findElement(by).isDisplayed();
    }

    public WebElement findElementByText(String text){
        String xpath = "//*[text()='" + text + "']";
        untilElementVisible(By.xpath(xpath));
        return driver.findElement(By.xpath(xpath));
    }

    public List<WebElement> findElements(By by){
        untilElementVisible(by);
        return driver.findElements(by);
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

    public BasePage scrollPageDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,0)");
        return this;
    }

    protected void untilElementVisible(By elementBy) {
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
            highlightElement(element);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void clickElementIfExist(By elementBy){
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
            highlightElement(element);
        }catch (Exception e){
            System.out.println("Element could not be found and skipped.");
        }
    }

    public void clickElementByText(String text){
        String xpath = "//*[text()='" + text + "']";
        clickElement(By.xpath(xpath));
    }

    public String getElementSrc(By elementBy){
        WebElement element = driver.findElement(elementBy);
        return element.getAttribute("src");
    }

    private void highlightElement(WebElement element) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
                " border: 3px solid red;");
    }

}
