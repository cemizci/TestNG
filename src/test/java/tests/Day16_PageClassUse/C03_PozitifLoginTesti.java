package tests.Day16_PageClassUse;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;

public class C03_PozitifLoginTesti {

    @Test
    public void pozitifLoginTest(){

        //  1- https://www.testotomasyonu.com/ anasayfasina gidin

        Driver.getDriver().get("https://www.testotomasyonu.com/");

        //  2- account linkine basin

        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();

        //  3- Kullanici email'i olarak gecerli email girin
        testOtomasyonuPage.loginPageEmailBox.sendKeys("wise@gmail.com");

        //  4- Kullanici sifresi olarak gecerli password girin
        testOtomasyonuPage.loginPagePasswordInput.sendKeys("12345");

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
