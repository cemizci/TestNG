package tests.Day15_TestNG_FrameworkCreate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ReusibleMethods;

import java.time.Duration;

public class C02_Priority {

    // 3 test method'u olusturup, asagidaki gorevleri yapin
    // 1- testotomasyonu sayfasina gidip url'in testotomasyonu icerdigini test edin
    // 2- wisequarter sayfasina gidip url'in wisequarter icerdigini test edin
    // 3- bestbuy sayfasina gidip url'in bestbuy icerdigini test edin


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

    @Test (priority = 1)
    public void testotomasyonuTest(){

        driver.get("https://www.testotomasyonu.com");
        String expectedUrl = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        ReusibleMethods.wait(1);
    }

    @Test (priority = 2)
    public void wisequaerterTest(){
        driver.get("https://www.wisequarter.com");
        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusibleMethods.wait(1);
    }

    @Test (priority = 3)
    public void bestbuyTest(){
        driver.get("https://www.bestbuy.com");
        String expectedUrlIcerik = "bestbuy";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusibleMethods.wait(1);
    }
}
