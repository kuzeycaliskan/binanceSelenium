package org.binance.market;

import org.binance.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;

public class MarketPage extends BasePage implements MarketLocators {

    Workbook workbook;
    Sheet sheet;

    ArrayList<ArrayList<String>> coinList = new ArrayList<>();

    public MarketPage(WebDriver driver) throws IOException {
        super(driver);
        workbook = WorkbookFactory.create(true);
        sheet = workbook.createSheet("Veri");
    }

    public MarketPage clickAllCryptosThanAll(){
        clickElementIfExist(By.xpath(allCryptosText));
        clickElementIfExist(By.xpath(allText));
        return this;
    }

    public MarketPage sortFor24hVolumeDesc(){
        String sort24hVolumeCurrentUrl;

        clickElement(By.xpath(sort24hVolume));
        sort24hVolumeCurrentUrl = getElementSrc(By.xpath(sort24hVolumeSortStatus));

        while (!sort24hVolumeSortDescUrl.equals(sort24hVolumeCurrentUrl)){
            clickElement(By.xpath(sort24hVolumeSortStatus));
            sort24hVolumeCurrentUrl = getElementSrc(By.xpath(sort24hVolumeSortStatus));
            System.out.println("Element SRC: " + sort24hVolumeCurrentUrl);
        }
        return this;
    }

    public MarketPage getAllCryptosOnPage() throws IOException {
        int itemSize = findElements(By.xpath(coinSubNameText)).size() - 1;
        int columnSize = 5;
        List<Integer> numbers = IntStream.rangeClosed(0, itemSize).boxed().collect(Collectors.toList());

        List<WebElement> cryptoNames = findElements(By.xpath(coinSubNameText));
        List<WebElement> cryptoFullNames = findElements(By.xpath(coinFullNameText));
        List<WebElement> cryptoPrices = findElements(By.xpath(coinPriceText));
        List<WebElement> cryptoChangeValue = findElements(By.xpath(coinChangeValueText));
        List<WebElement> cryptoVolume = findElements(By.xpath(coinVolumeText));

        for(int s: numbers){
            ArrayList<String> row = new ArrayList<>();

            row.add(cryptoNames.get(s).getText());
            row.add(cryptoFullNames.get(s).getText());
            row.add(cryptoPrices.get(s).getText());
            row.add(cryptoChangeValue.get(s).getText());
            row.add(cryptoVolume.get(s).getText());

            coinList.add(row);
        }

        for (ArrayList<String> row : coinList) {
            for (String value : row) {
                System.out.print(value + " - ");
            }
            System.out.println(); // Her satırın sonunda bir satır atlama
        }

        return this;
    }

    public void writeArrayListToExcel(){
        // İki boyutlu listeyi Excel'e yaz
        for (int i = 0; i < coinList.size(); i++) {
            ArrayList<String> rowList = coinList.get(i);
            Row row = sheet.createRow(i);
            for (int j = 0; j < rowList.size(); j++) {
                row.createCell(j).setCellValue(rowList.get(j));
            }
        }

        // Excel dosyasını oluştur
        try (FileOutputStream outputStream = new FileOutputStream("./downloads/coinlist.xlsx")) {
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MarketPage clickSecondPage(){
        scrollPageDown();
        scrollPageDown();
        clickElement(By.xpath(pageTwoButton));
        return this;
    }

    public MarketPage clickThirdPage(){
        scrollPageDown();
        scrollPageDown();
        clickElement(By.xpath(pageThreeButton));
        return this;
    }

    public MarketPage clickMarketsOverview(){
        clickElementIfExist(By.xpath(marketsOverviewText));
        return this;
    }

    public MarketPage clickSpotMarginMarket(){
        clickElementIfExist(By.xpath(spotMarginMarketText));
        return this;
    }

    public MarketPage clickAvaxCoin() throws InterruptedException {
        clickElement(By.xpath(avaxButton));
        Thread.sleep(3000);
        return this;
    }

}
