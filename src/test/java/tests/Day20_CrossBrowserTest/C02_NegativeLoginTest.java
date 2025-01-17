package tests.Day20_CrossBrowserTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusibleMethods;
import utilities.TestBaseCross;

import java.io.ObjectInputFilter;

public class C02_NegativeLoginTest extends TestBaseCross {

    @Test
    public void inValidPasswordTest(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toURL"));
        ReusibleMethods.wait(1);

        //2- account linkine basin
        WebElement accountLink = driver.findElement(By.xpath("(//span[.='Account'])[1]"));
        accountLink.click();
        ReusibleMethods.wait(1);

        //3-  3 farkli test method’u olusturun.
           // - gecerli email, gecersiz password girin
        driver.findElement(By.id("email")).sendKeys(ConfigReader.getProperty("toValidEmail"));
        driver.findElement(By.id("password")).sendKeys(ConfigReader.getProperty("toInValidPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        driver.findElement(By.id("submitlogin")).click();
        ReusibleMethods.wait(1);

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());

        //6-sayfayi kapatin
        driver.quit();
    }


    @Test
    public void gecersizEmailTest(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toURL"));
        ReusibleMethods.wait(1);

        //2- account linkine basin
        WebElement accountLink = driver.findElement(By.xpath("(//span[.='Account'])[1]"));
        accountLink.click();
        ReusibleMethods.wait(1);

        //3-  3 farkli test method’u olusturun.
            // - gecersiz email, gecerli password girin
        driver.findElement(By.id("email")).sendKeys(ConfigReader.getProperty("toInvalidEmail"));
        driver.findElement(By.id("password")).sendKeys(ConfigReader.getProperty("toValidPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        driver.findElement(By.id("submitlogin")).click();
        ReusibleMethods.wait(1);

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());

        //6-sayfayi kapatin
        driver.quit();

    }


    @Test
    public void inValidPasswordinValidEmailTest(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toURL"));
        ReusibleMethods.wait(1);

        //2- account linkine basin
        WebElement accountLink = driver.findElement(By.xpath("(//span[.='Account'])[1]"));
        accountLink.click();
        ReusibleMethods.wait(1);

        //3-  3 farkli test method’u olusturun.
            // - gecersiz email, gecersiz password girin
        driver.findElement(By.id("email")).sendKeys(ConfigReader.getProperty("toInvalidEmail"));
        driver.findElement(By.id("password")).sendKeys(ConfigReader.getProperty("toinValidPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        driver.findElement(By.id("submitlogin")).click();
        ReusibleMethods.wait(1);

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());

        // 6- Sayfayı kapatın
        driver.quit();

    }
}
