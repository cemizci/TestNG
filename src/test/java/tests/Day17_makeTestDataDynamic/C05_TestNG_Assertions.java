package tests.Day17_makeTestDataDynamic;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.ObjectInputFilter;

public class C05_TestNG_Assertions {
      /*
        Bazi test method'larinda 1'den fazla assertion olabilir

        Eger var olan assertion'lardan birden fazlasi failed oluyorsa
        Ilk FAILED olan assertion'da
        kodun calismasi durur ve geriye kalan assertion'lar calismamis olur

        Bulunan ilk hatayi duzeltmemiz
        geriye kalan assertion'larin PASSED olacagini garanti etmez

        failed olan her bir assertion icin yeniden testin calistirilip
        duzeldiginden emin olmamiz gerekir
        Bu da ozellikle toplu calistirmalarda
        tekrar tekrar tum testlerin calistirilmasi sebebiyle
        ciddi zaman kayiplarina neden olabilir.

     */

    @Test
    public void searchTest(){
        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));

        // Url'in testotomasyonu icerdigini test edin
        String expectedContent = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedContent));

        // belirlenmis arama kelimesi icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toSearchWord") + Keys.ENTER);

        // urun bulunabildigini test edin
        int actualFindProductCount = testOtomasyonuPage.bulunanUrunElList.size();

        Assert.assertTrue(actualFindProductCount > 0);

        // ilk urunu tiklayin
        testOtomasyonuPage.bulunanUrunElList.get(0).click();

        // acilan sayfada urun isminde case sensitive olmadan
        // belirlenmis aranacakKelime'nin bulundugunu test edin

        String expectedProductNameContent = ConfigReader.getProperty("toSearchWord");
        String actualProductName = testOtomasyonuPage.urunSayfasındakiIsimEl.getText().toLowerCase();

        Assert.assertTrue(actualProductName.contains(expectedProductNameContent));

        Driver.quitDriver();
    }
}
