package tests.Day20_CrossBrowserTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusibleMethods;
import utilities.TestBaseCross;

public class C03_SohppingTest extends TestBaseCross {
    @Test
    public void shoppingTest(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toURL"));
        ReusibleMethods.wait(1);

        //2- belirlenmis arama kelimesi icin arama yapin
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys(ConfigReader.getProperty("toSearchWord") + Keys.ENTER);
        ReusibleMethods.wait(1);

        //3- Listelenen sonuclardan ilkini tiklayin
        driver.findElements(By.className("prod-img")).get(0).click();
        ReusibleMethods.wait(1);

        //4- urun ismini kaydedin
        String firstProductName =
                driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']")).getText();

        // ve urunu sepete ekleyin
        driver.findElement(By.className("add-to-cart")).click();
        ReusibleMethods.wait(1);

        //5- your cart linkine tiklayin
        driver.findElement(By.xpath("(//*[@class='e-cart'])[2]")).click();
        ReusibleMethods.wait(1);

        //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin
        String productNameInBox =
                driver.findElement(By.xpath("//*[@class='product-title text-center']")).getText();

        Assert.assertEquals(firstProductName,productNameInBox);

        //7- sayfayi kapatin
        driver.quit();


    }
}
