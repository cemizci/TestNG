package tests.Day20_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusibleMethods;
import utilities.TestBaseRapor;

public class C03_RaporluDataProvider extends TestBaseRapor {
    // testotomasyonu anasayfaya gidip
    // bir liste olarak verilen urunleri
    // tek tek aratin ve her urunun sayfada bulunabildigini test edin
    // phone, dress, java, samsung, nutella, apple, cokoprens

    @DataProvider
    public static Object[][] productNameDataProvider(){
        String[][] productToSearchArray = {{"phone"}, {"dress"}, {"java"}, {"samsung"}, {"nutella"}, {"apple"}, {"cokoprens"}};

        return productToSearchArray;
    }

    @Test(dataProvider = "productNameDataProvider")
    public void cokluAramaTesti(String toSearchWord){
        extentTest = extentReports.createTest(toSearchWord + "arama testi",
                "Kullanici testotomasyonu sayfasinda " + toSearchWord + " arattiginda sonuc bulabilmeli");


        Driver.getDriver().get(ConfigReader.getProperty("toURL"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");

        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

        testOtomasyonuPage.aramaKutusu.sendKeys(toSearchWord + Keys.ENTER);
        extentTest.info("Arama kutusuna " + toSearchWord + " yazip aratir");

        String unExpectedAramaSonucu = ConfigReader.getProperty("toBulunamadıYazısı");
        String actualAramaSonucu = testOtomasyonuPage.aramaSonucYazıElementi.getText();

        ReusibleMethods.wait(1);

        Assert.assertNotEquals(unExpectedAramaSonucu,actualAramaSonucu);
        extentTest.pass("Arama sonucunda " + toSearchWord + " bulunabildigini test eder");
    }
}
