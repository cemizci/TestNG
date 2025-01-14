package tests.Day15_TestNG_FrameworkCreate;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_AramaTesti {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    @Test
    public void aramaTesti(){
        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        // phone için arama yapın

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone", Keys.ENTER);

        // arama sonucunda urun bulunabildiğini test edin
        WebElement aramaSonucEl =driver.findElement(By.xpath("//*[@*='product-count-text']"));

        String unExpectedAramaSonucu ="0 Products Found";
        String actualAramaSonucu = aramaSonucEl.getText();

        Assert.assertNotEquals(actualAramaSonucu,unExpectedAramaSonucu);
    }
}
