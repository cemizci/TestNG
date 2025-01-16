package tests.Day19_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_PozitifLoginTestWithReport extends TestBaseRapor {

    @Test
    public void pozitifLoginTestWithReport(){
        extentTest = extentReports.createTest("Pozitif Login Test",
                "kullanıcı gecerli email ve sifre ile sisteme giriş yapabilmeli");

        //  1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));
        extentTest.info("Kullanıcı https://www.testotomasyonu.com/ anasayfasina gider");

        //  2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();
        extentTest.info("Kullanıcı account linkine tıklayabilmeli");

        //  3- Kullanici email'i olarak gecerli email girin
        testOtomasyonuPage.loginPageEmailBox.sendKeys(ConfigReader.getProperty("toValidEmail"));
        extentTest.info("Kullanıcı email olarak gecerli emaili girebilmeli");

        //  4- Kullanici sifresi olarak gecerli password girin
        testOtomasyonuPage.loginPagePasswordInput.sendKeys(ConfigReader.getProperty("toValidPassword"));
        extentTest.info("Kullanici sifresi olarak gecerli password girebilmeli");

        //  5- Login butonuna basarak login olun
        testOtomasyonuPage.loginPageSubmitBtn.click();
        extentTest.info("Kullanıcı login butonuna basarak login olabilmeli");

        //  6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testOtomasyonuPage.logoutBtn.isDisplayed());
        extentTest.info("Basarılı olarak giriş yapılabildiğini test eder");

        // 7-Logout olun
        testOtomasyonuPage.logoutBtn.click();
        extentTest.info("Kullanıcı logout olur");

        // 8- sayfayi kapatin
        extentTest.info("sayfayi kapatir");
    }
}
