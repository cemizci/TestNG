package tests.Day17_makeTestDataDynamic;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.lang.module.Configuration;

public class C01_configurationFileUse {

    @Test
    public void pozitifLoginTest() {

        //  1- https://www.testotomasyonu.com/ anasayfasina gidin

        // Driver.getDriver().get("configuration.properties dosyasina git bana toUrl degerini getir");
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));

        //  2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();

        //  3- Kullanici email'i olarak gecerli email girin
        testOtomasyonuPage.loginPageEmailBox.sendKeys(ConfigReader.getProperty("toValidEmail"));

        //  4- Kullanici sifresi olarak gecerli password girin
        testOtomasyonuPage.loginPagePasswordInput.sendKeys(ConfigReader.getProperty("toValidPassword"));

        //  5- Login butonuna basarak login olun
        testOtomasyonuPage.loginPageSubmitBtn.click();

        //  6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testOtomasyonuPage.logoutBtn.isDisplayed());

        // 7-Logout olun
        testOtomasyonuPage.logoutBtn.click();

        // 8- Sayfayı kapatın
        Driver.quitDriver();
    }
}
