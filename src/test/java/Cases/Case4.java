package Cases;

import org.testng.annotations.Test;
import utils.BaseTest;
import utils.SetupRemoteWebDriver;

public class Case4 extends SetupRemoteWebDriver {

    @Test(description = "Anasayfanin acilmasini bekle ve Al-Sat'a tikla", priority = 1)
    public void checkIfHomePageAndMarketsPageOpened() throws InterruptedException {
        homePage.closeCookiesPopUpIfExist();
    }

    @Test(description = "Spot->Marjin Piyasalar->USDT listesine tikla", priority = 2)
    public void getRandomFiveItemFromAbout() throws InterruptedException {
        homePage.clickMarkets();
        marketPage.clickMarketsOverview()
                .clickSpotMarginMarket()
                .clickAvaxCoin();
    }

    @Test(description = "Kripto sayfasini kontrol et", priority = 3)
    public void checkCryptoPage() {
        coinPage.checkCoinPage();
    }


}
