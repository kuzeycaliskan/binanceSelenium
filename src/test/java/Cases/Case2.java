package Cases;

import org.testng.annotations.Test;
import utils.SetupRemoteWebDriver;

public class Case2 extends SetupRemoteWebDriver {

    @Test(description = "Anasayfanin acilmasini bekle ve Al-Sat'a tikla", priority = 1)
    public void checkIfHomePageAndMarketsPageOpened() throws InterruptedException {
        homePage.closeCookiesPopUpIfExist();
    }

    @Test(description = "Al-Sat'a ve sonrasindan Spot'a tikla", priority = 2)
    public void clickTradeThenSpot(){
        homePage.clickTrade()
                .clickSpot();
    }

    @Test(description = "Giris yap butonuna tikla ve yanlis bilgiler ile giris yapmayi dene", priority = 3)
    public void clickLoginAndTryToLoginWithNotValidAccount(){
        tradePage.clickLogin();
        loginPage.enterNotValidMail();
        //the case cannot be continued because of captcha verification
    }
}
