package tests.Day19_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_NegatifLoginTestWithReport extends TestBaseRapor {


    @Test
    public void gecersizPasswordTesti(){

        extentTest = extentReports.createTest("Invalid Password Test",
                "Kullanici gecerli email ve gecersiz password ile giris yapamamali");

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));
        extentTest.info("Kullanıcı https://www.testotomasyonu.com/ anasayfasina gider");

        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();
        extentTest.info("Kullanıcı account linkine tıkalayabilmeli");

        //3- bir test method’u olusturun.
           //	- gecerli email, gecersiz password
        testOtomasyonuPage.loginPageEmailBox.sendKeys(ConfigReader.getProperty("toValidEmail"));
       extentTest.info("Kullanıcı email kutusuna gecerli email degerini girebilmeli");

       testOtomasyonuPage.loginPagePasswordInput.sendKeys(ConfigReader.getProperty("toInvalidPassword"));
       extentTest.info("Kullanıcı password kutusuna gecersiz password degerini girebilmeli");


        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginPageSubmitBtn.click();
        extentTest.info("Login butonuna basarak login olmayi dener");

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.loginPageEmailBox.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilamadigini test eder");

        //6-sayfayi kapatin
        extentTest.info("sayfayi kapatir");
    }


    @Test
    public void gecersizEmailTesti(){

        extentTest = extentReports.createTest("Invalid Email Test",
                "Kullanici gecersiz email ve gecerli password ile giris yapamamali");

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));
        extentTest.info("Kullanıcı https://www.testotomasyonu.com/ anasayfasina gider");

        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();
        extentTest.info("account linkine basar");


        //3- bir test method’u olusturun.
        testOtomasyonuPage.loginPageEmailBox.sendKeys(ConfigReader.getProperty("toInvalidEmail"));
        extentTest.info("Kullanıcı email kutusuna gecersiz email degerini girer");

        testOtomasyonuPage.loginPagePasswordInput.sendKeys(ConfigReader.getProperty("toValidPassword"));
        extentTest.info("Kullanıcı password kutusuna gecerli password degerini girer");


        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginPageSubmitBtn.click();
        extentTest.info("Kullanıcı login butonuna basarak login olmayı dener");

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.loginPageEmailBox.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilamadigini test eder");

        //6-sayfayi kapatin
        extentTest.info("sayfayi kapatir");
    }

    @Test
    public void gecersizEmailGecersizPasswordTesti(){

        extentTest = extentReports.createTest("Invalid Password and Email Test",
                "Kullanici gecersiz email ve gecersiz password ile giris yapamamali");

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));
        extentTest.info("Kullanıcı https://www.testotomasyonu.com/ anasayfasina gider");

        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();
        extentTest.info("Kullanıcı account linkine tıklayabilmeli");

        //3- bir test method’u olusturun.
       testOtomasyonuPage.loginPageEmailBox.sendKeys(ConfigReader.getProperty("toInvalidEmail"));
       extentTest.info("Email kutusuna gecersiz email degerini girer");

       testOtomasyonuPage.loginPagePasswordInput.sendKeys(ConfigReader.getProperty("toInvalidPassword"));
       extentTest.info("Password kutusuna gecersiz password degerini girer");


        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginPageSubmitBtn.click();
        extentTest.info("Login butonuna basarak login olmayi dener");

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.loginPageEmailBox.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilamadigini test eder");

        //6-sayfayi kapatin
        extentTest.info("sayfayi kapatir");
    }
}
