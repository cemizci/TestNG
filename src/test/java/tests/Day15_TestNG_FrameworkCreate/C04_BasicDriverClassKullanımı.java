package tests.Day15_TestNG_FrameworkCreate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusibleMethods;

public class C04_BasicDriverClassKullanımı {


    @Test
    public void test01(){
        Driver.getDriver().get("https://www.testotomasyonu.com");

        // wisequarter anasayfaya gidin
        Driver.getDriver().get("https://www.wisequarter.com");


        Driver.getDriver().get("https://www.testotomasyonu.com");
        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));



        ReusibleMethods.wait(2);
        Driver.quitDriver();
    }
}
