package tests.Day17_makeTestDataDynamic;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_ShoppingCartTest {

    @Test
    public void shppingTest(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));

        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toSearchWord") + Keys.ENTER);

        //3- Listelenen sonuclardan ilkini tiklayin
        testOtomasyonuPage.bulunanUrunElList.get(0).click();

        //4- urun ismini kaydedin
        String firstProductName = testOtomasyonuPage.urunSayfasındakiIsimEl.getText();

        // ve urunu sepete ekleyin
        testOtomasyonuPage.urunSayfasindakiSepeteEkleButonu.click();

        //5- your cart linkine tiklayin
        testOtomasyonuPage.urunSayfasindakiYourCartButonu.click();

        //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin

        String productNameInbox = testOtomasyonuPage.yourCartSayfasindakiUrunIsmi.getText();
        Assert.assertEquals(firstProductName,productNameInbox);

        //7- sayfayi kapatin
        Driver.quitDriver();
    }
}
