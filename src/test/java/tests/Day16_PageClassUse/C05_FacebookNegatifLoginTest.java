package tests.Day16_PageClassUse;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C05_FacebookNegatifLoginTest {

    @Test
    public void facebookNegatifLoginTest(){
       // 1 - https://www.facebook.com/ adresine gidin

        Driver.getDriver().get("https://www.facebook.com/ ");


       // 2- Cookies cikiyorsa kabul edin
        FacebookPage facebookPage = new FacebookPage();
        //facebookPage.cookiesAcceptBtn.click();

       // 3- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin


       // 4- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
            Faker faker = new Faker();

            facebookPage.loginEmailBox.sendKeys(faker.internet().emailAddress());
            facebookPage.loginPasswordBox.sendKeys(faker.internet().password());
            facebookPage.loginPageLoginBtn.click();

       // 5- Basarili giris yapilamadigini test edin
    }
}
