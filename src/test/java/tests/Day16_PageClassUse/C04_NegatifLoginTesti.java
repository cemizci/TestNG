package tests.Day16_PageClassUse;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;

public class C04_NegatifLoginTesti {
  //  1- https://www.testotomasyonu.com/ anasayfasina gidin
  //  2- account linkine basin
  //  3- 3 farkli test method’u olusturun.
  //   - gecerli email, gecersiz password
  //   - gecersiz email, gecerli password
  //   - gecersiz email, gecersiz password.
  //  4- Login butonuna basarak login olmayi deneyin
  //  5- Basarili olarak giris yapilamadigini test edin

    @Test
    public void gecersizPasswordTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin

        Driver.getDriver().get("https://www.testotomasyonu.com/");

        //2- account linkine basin

        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();

        //3- bir test method’u olusturun.
           //	- gecerli email, gecersiz password

        testOtomasyonuPage.loginPageEmailBox.sendKeys("wise@gmail.com");
        testOtomasyonuPage.loginPagePasswordInput.sendKeys("123");


        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginPageSubmitBtn.click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.loginPageEmailBox.isDisplayed());
    }



    @Test
    public void gecersizEmailTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com/");

        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();

        //3- bir test method’u olusturun.
       testOtomasyonuPage.loginPageEmailBox.sendKeys("abc@gmail.com");
       testOtomasyonuPage.loginPagePasswordInput.sendKeys("12345");
        //	- gecersiz email, gecerli password


        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginPageSubmitBtn.click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.loginPageEmailBox.isDisplayed());
    }

    @Test
    public void gecersizEmailGecersizPasswordTesti(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com/");

        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLink.click();

        //3- bir test method’u olusturun.
        testOtomasyonuPage.loginPageEmailBox.sendKeys("abc@gmail.com");
        testOtomasyonuPage.loginPagePasswordInput.sendKeys("123");
        // gecersiz email, gecersiz password.


        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginPageSubmitBtn.click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testOtomasyonuPage.loginPageEmailBox.isDisplayed());
    }
}
