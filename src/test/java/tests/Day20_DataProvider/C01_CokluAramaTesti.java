package tests.Day20_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01_CokluAramaTesti {

    // testotomasyonu anasayfaya gidip
    // bir liste olarak verilen urunleri
    // tek tek aratin ve her urunun sayfada bulunabildigini test edin
    // phone, dress, java, samsung, nutella, apple, cokoprens

    @Test
    public void cokluAramaTesti(){
        List<String> aranacakUrunList = new ArrayList<>(Arrays.asList("phone", "dress", "java", "samsung", "nutella", "apple", "cokoprens"));
        System.out.println(aranacakUrunList);

        Driver.getDriver().get(ConfigReader.getProperty("toURL"));
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        SoftAssert softAssert = new SoftAssert();

        for (String eachUrun : aranacakUrunList){
            testOtomasyonuPage.aramaKutusu.sendKeys(eachUrun + Keys.ENTER);

            softAssert.assertTrue(testOtomasyonuPage.bulunanUrunElList.size()>0,
                    eachUrun + "icin sonuc bulunamadı");
        }

        softAssert.assertAll();
        Driver.quitDriver();
    }
}
