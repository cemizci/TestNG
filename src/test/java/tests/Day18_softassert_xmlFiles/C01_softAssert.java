package tests.Day18_softassert_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_softAssert {

      /*
        SoftAssert'un tek negatif tarafi
        tum raporlamayi assertAll() kullandigimiz satir icin yapmasidir

        verilen hata raporundan
        kac assertion'in failed oldugunu anlayabiliriz
        ama hangi assertion'larin failed oldugunu anlayamayiz

        Bu negatif durumu gidermek icin
        softAsset kullandigimizda
        hatanin hangi assertion'dan kaynaklandigini anlayabilecegimiz
        bir mesaj ekleyebiliriz
     */


    @Test
    public void searchTest(){
        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));

        // Url'in testotomasyonu icerdigini test edin
        SoftAssert softAssert = new SoftAssert();

        String expectedContent = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualUrl.contains(expectedContent),
                "url istenen icerigi barindirmiyor,satir39");

        // belirlenmis arama kelimesi icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toSearchWord") + Keys.ENTER);

        // urun bulunabildigini test edin
        int actualFindProductCount = testOtomasyonuPage.bulunanUrunElList.size();

        softAssert.assertTrue(actualFindProductCount > 0,
                "aranan urun sayfada bulunamadi, satir52");

        // ilk urunu tiklayin
        testOtomasyonuPage.bulunanUrunElList.get(0).click();

        // acilan sayfada urun isminde case sensitive olmadan
        // belirlenmis aranacakKelime'nin bulundugunu test edin

        String expectedProductNameContent = ConfigReader.getProperty("toSearchWord");
        String actualProductName = testOtomasyonuPage.urunSayfasındakiIsimEl.getText().toLowerCase();

        softAssert.assertTrue(actualProductName.contains(expectedProductNameContent),
                "urun ismi belirlenen kelimeyi icermiyor,satir 68");

        softAssert.assertAll();

        Driver.quitDriver();
    }
}
