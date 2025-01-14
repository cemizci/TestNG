package tests.Day16_PageClassUse;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;

public class C02_TestOtomasyonuFiyatTesti {

    @Test
    public void fiyatTesti(){

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");

        // dress icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("dress", Keys.ENTER);

        // cikan urunlerden 3. urunu tiklayin
        testOtomasyonuPage.bulunanUrunElList.get(2).click();

        // acilan sayfada urun fiyatinin 59$ oldugunu test edin

        double expectedFiyat = 59;

        String actualFiyatStr = testOtomasyonuPage.getUrunSayfasındakifiyatEl.getText();
        actualFiyatStr = actualFiyatStr.replaceAll("\\D", "");

        Double actualFiyat = Double.parseDouble(actualFiyatStr) / 100;

        Assert.assertEquals(actualFiyat,expectedFiyat);

        Driver.quitDriver();
    }
}
