package tests.Day20_CrossBrowserTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusibleMethods;
import utilities.TestBaseCross;

public class C01_PozitifLoginTest extends TestBaseCross {

    @Test
    public void dynamicPositiveLoginTest(){
        // 1- https://www.testotomasyonu.com/ anasayfasina gidin

        // Driver.getDriver().get("configuration.properties dosyasina git bana toUrl degerini getir");
        driver.get(ConfigReader.getProperty("toURL"));
        ReusibleMethods.wait(1);

        // 2- account linkine basin
        WebElement accounLink = driver.findElement(By.xpath("(//span[.='Account'])[1]"));
        accounLink.click();
        ReusibleMethods.wait(1);

        // 3- Kullanici email'i olarak gecerli email girin
        driver.findElement(By.id("email")).sendKeys(ConfigReader.getProperty("toValidEmail"));

        // 4- Kullanici sifresi olarak gecerli password girin
        driver.findElement(By.id("password")).sendKeys(ConfigReader.getProperty("toValidPassword"));

        // 5- Login butonuna basarak login olun
        driver.findElement(By.id("submitlogin")).click();
        ReusibleMethods.wait(1);

        // 6- Basarili olarak giris yapilabildigini test edin
        WebElement logoutBtn = driver.findElement(By.xpath("//span[.='Logout']"));

        Assert.assertTrue(logoutBtn.isDisplayed());

        // 7- logout olun
        logoutBtn.click();

        // 8- sayfayi kapatin
        driver.quit();

    }
}
