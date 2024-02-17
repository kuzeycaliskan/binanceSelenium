package home;

import org.testng.annotations.Test;
import utils.BaseTest;

public class HomeTest extends BaseTest {

    @Test(description = "Demo test", priority = 1)
    public void goToURL() throws InterruptedException {
        System.out.println(projectProps.getPropertyValue("url"));
        homePage.goToURLFromHomePage(projectProps.getPropertyValue("url"));
        Thread.sleep(10000);
    }
}
