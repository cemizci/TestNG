package tests.Day17_makeTestDataDynamic;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DynamicNegatifLoginTest {

    @Test
    public void inValidPasswordTest(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));

        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();

        //3-  3 farkli test method’u olusturun.
            // - gecerli email, gecersiz password girin
        testOtomasyonuPage.loginPageEmailBox.sendKeys(ConfigReader.getProperty("toValidEmail"));
        testOtomasyonuPage.loginPagePasswordInput.sendKeys(ConfigReader.getProperty("toInvalidPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginPageSubmitBtn.click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.loginPageEmailBox.isDisplayed());

        //6-sayfayi kapatin
        Driver.quitDriver();
    }

    @Test
    public void invalidEmailTest(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));

        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();

        //3-  3 farkli test method’u olusturun.
            // - gecersiz email, gecerli password girin
        testOtomasyonuPage.loginPageEmailBox.sendKeys(ConfigReader.getProperty("toInvalidEmail"));
        testOtomasyonuPage.loginPagePasswordInput.sendKeys(ConfigReader.getProperty("toValidPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginPageSubmitBtn.click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.loginPageEmailBox.isDisplayed());

        //6-sayfayi kapatin
        Driver.quitDriver();
    }

    @Test
    public void invalidValuesTest(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));

        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();

        //3-  3 farkli test method’u olusturun.
            // - gecersiz email, gecersiz password girin

        testOtomasyonuPage.loginPageEmailBox.sendKeys(ConfigReader.getProperty("toInvalidEmail"));
        testOtomasyonuPage.loginPagePasswordInput.sendKeys(ConfigReader.getProperty("toInvalidPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginPageSubmitBtn.click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.loginPageEmailBox.isDisplayed());

        //6-sayfayi kapatin
        Driver.quitDriver();
    }
}
