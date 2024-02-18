package Cases;

import org.testng.annotations.Test;
import utils.BaseTest;
import utils.SetupRemoteWebDriver;

import java.io.IOException;

public class Case1 extends SetupRemoteWebDriver {

    @Test(description = "Anasayfanin acilmasini bekle ve Piyasa ozetine tikla", priority = 1)
    public void checkIfHomePageAndMarketsPageOpened() throws InterruptedException {
        homePage.closeCookiesPopUpIfExist()
                .clickMarkets();
    }

    @Test(description = "Piyasalar sayfasinda tum kriptolar -> tumu butonlarina tikla", priority = 2)
    public void checkIfAllCryptosAreListed() throws InterruptedException, IOException {
        marketPage.clickAllCryptosThanAll()
                .sortFor24hVolumeDesc()
                .getAllCryptosOnPage()
                .clickSecondPage()
                .getAllCryptosOnPage()
                .clickThirdPage()
                .getAllCryptosOnPage()
                .writeArrayListToExcel();
        Thread.sleep(3000);
    }
}
