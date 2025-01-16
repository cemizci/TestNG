package tests.Day19_HtmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_ShoppingTestWithReport extends TestBaseRapor {

     /*
        Bir test method'unun raporlu olmasini istiyorsaniz
        1- extends TestBaseRapor ile class'i TestBaseRapor'a child yapariz
        2- Page Object Model'e uygun olarak test adimlari icin
           gerekli kodlari yazariz
        3- HER TEST METHOD'u icin extentTest objesi olusturup
           o test method'una raporda gorunecek bir isim
           ve bir aciklama yaziyoruz
        4- Raporda gorunmesini istedigimiz her adimi
           extentTest objesi yardimiyla olusturun

     */

    @Test
    public void shoppingTest(){
        extentTest = extentReports.createTest("Alışveriş Testi",
                "Kullanıcı istediği ürünün sepete eklendiğini test edebilmeli");

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toURL"));
        extentTest.info("Kullanıcı https://www.testotomasyonu.com/ anasayfasına gider");

        //2- belirlenmis arama kelimesi icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

        testOtomasyonuPage.aramaKutusu
                .sendKeys(ConfigReader.getProperty("toSearchWord") + Keys.ENTER);
        extentTest.info("belirlenmiş arama kelimesi için arama yapar");

        //3- Listelenen sonuclardan ilkini tiklayin
        testOtomasyonuPage.bulunanUrunElList.get(0).click();
        extentTest.info("Listelenen sonuclardan ilkini tıklar");

        //4- urun ismini kaydedin
        String firstProductName = testOtomasyonuPage.urunSayfasındakiIsimEl.getText();
        extentTest.info("Tıkladıgı ürünün ismini kaydeder");

        // ve urunu sepete ekleyin
        testOtomasyonuPage.urunSayfasindakiSepeteEkleButonu.click();
        extentTest.info("Urunu sepeye ekler");


        //5- your cart linkine tiklayin
        testOtomasyonuPage.urunSayfasindakiYourCartButonu.click();
        extentTest.info("your cart linkine tıklar");

        //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin
        String sepettekiUrunIsmi = testOtomasyonuPage.yourCartSayfasindakiUrunIsmi.getText();

        Assert.assertEquals(firstProductName , sepettekiUrunIsmi);
        extentTest.pass("kaydettiği urun ismi ile sepetteki urun isminin aynı oldugunu test eder");

        //7- sayfayi kapatin

        extentTest.info("sayfayi kapatir");

    }
}
