package tests.Day15_TestNG_FrameworkCreate;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusibleMethods;

public class C06_DriverClassKullanımı {

    public void testotomasyonuTest(){

        Driver.getDriver().get("https://www.testotomasyonu.com");
        String expectedUrl = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        ReusibleMethods.wait(1);

        Driver.quitDriver();
    }

    @Test(priority = 2)
    public void wisequaerterTest(){
        Driver.getDriver().get("https://www.wisequarter.com");
        String expectedUrlIcerik = "wisequarter";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusibleMethods.wait(1);

        Driver.quitDriver();
    }

    @Test (priority = 3)
    public void bestbuyTest(){
        Driver.getDriver().get("https://www.bestbuy.com");
        String expectedUrlIcerik = "bestbuy";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusibleMethods.wait(1);

        Driver.quitDriver();
    }

}
