package tests.Day16_PageClassUse;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;

public class C01_PageClassUse {

    @Test
    public void aramaTesti(){
        // testotomasyonu sayfasına gidin

        Driver.getDriver().get("https://www.testotomasyonu.com");

        // phone icin arama yapın
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("phone", Keys.ENTER);

        // urun bulunabildigini test edin
        int actualBulunanUrunSayısı = testOtomasyonuPage.bulunanUrunElList.size();

        Assert.assertTrue(actualBulunanUrunSayısı > 0);

        //ilk urunu tıklayın
        testOtomasyonuPage.bulunanUrunElList.get(0).click();

        // acılan sayfada urun isminde case sensitive olmadan phone bulundugunu test edin
        String expectedUrunIsimIcerik = "phone";
        String actualUrunIsmi = testOtomasyonuPage.urunSayfasındakiIsimEl.getText().toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(expectedUrunIsimIcerik));

        Driver.quitDriver();
    }
}
