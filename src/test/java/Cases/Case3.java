package Cases;

import org.testng.annotations.Test;
import utils.BaseTest;
import utils.SetupRemoteWebDriver;

public class Case3 extends SetupRemoteWebDriver {

    @Test(description = "Anasayfanin acilmasini bekle ve Al-Sat'a tikla", priority = 1)
    public void checkIfHomePageAndMarketsPageOpened() throws InterruptedException {
        homePage.closeCookiesPopUpIfExist();
    }

    @Test(description = "Hakkimizda kismindan rastgele 5 linki sec", priority = 2)
    public void getRandomFiveItemFromAbout() throws InterruptedException {
        homePage.getRandomFiveAboutLinks();
    }


}
