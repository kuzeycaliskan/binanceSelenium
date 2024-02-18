package org.binance.login;

import org.binance.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage implements LoginLocators {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterNotValidMail(){
        findElement(By.xpath(usernameInput)).sendKeys(getProjectProps().getPropertyValue("not_valid_mail"));
        clickElement(By.xpath(nextButton));
        return this;
    }
}
