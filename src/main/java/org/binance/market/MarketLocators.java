package org.binance.market;

public interface MarketLocators {
    String allCryptosText = "//div/div[text()='Tüm Kriptolar']";
    String allText = "//div/div[text()='All']";

    String sort24hVolume = "//div/div[text()='24s Hacim']";
    String sort24hVolumeSortStatus = "//div[text()='24s Hacim']/following-sibling::img";
    String sort24hVolumeSortDescUrl = "https://bin.bnbstatic.com/static/images/main-exchange-ui/sort-down-f.svg";
    String coinSubNameText = "//div[@class='subtitle3 text-t-primary css-vurnku']";
    String coinFullNameText = "//div[@class='body3 line-clamp-1 truncate text-t-third css-vurnku']";
    String coinPriceText = "//div[@class='css-1ydqfmf']/div[1]";
    String coinChangeValueText = "//div[@class='css-1ydqfmf']/div[2]";
    String coinVolumeText = "//div[@class='css-1ydqfmf']/div[3]";
    String pageTwoButton = "//*[@id='page-2']";
    String pageThreeButton = "//*[@id='page-3']";
    String marketsOverviewText = "//div/a[text()='Piyasaların Özeti']";
    String spotMarginMarketText = "//div/div[text()='Spot/Marjin Piyasası']";
    String avaxButton = "//div/div[text()='AVAX']";

}
