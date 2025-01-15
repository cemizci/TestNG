package tests.Day18_softassert_xmlFiles;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusibleMethods;

import java.util.List;

public class C02_softAssert {

    @Test
    public void zeroAppTest(){
        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroURL"));

        // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin
        SoftAssert softAssert = new SoftAssert();

        String expectedUrl = ConfigReader.getProperty("zeroURL");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,"ZeroApp anasayfa testi failed");

        // 3. Sign in butonuna basin
        ZeroWebPage zeroWebPage = new ZeroWebPage();
        zeroWebPage.mainPageSignBtn.click();

        // 4. Login kutusuna “username” yazin
        zeroWebPage.loginBox.sendKeys(ConfigReader.getProperty("zeroValidUsername"));

        // 5. Password kutusuna “password” yazin
        zeroWebPage.passwordBox.sendKeys(ConfigReader.getProperty("zeroValidPassword"));

        // 6. Sign in tusuna basin
        zeroWebPage.signInButton.click();

        // 7. Back tusuna basin
        Driver.getDriver().navigate().back();

        // 8. Giris yapilabildigini dogrulayin
        softAssert.assertTrue(zeroWebPage.onlineBankingMenuEl.isDisplayed());

        // 9. Online banking menusunu tiklayin
        zeroWebPage.onlineBankingMenuEl.click();

        //10. Pay Bills sayfasina gidin
        zeroWebPage.payBillsMenuEl.click();

        //11. “Purchase Foreign Currency” tusuna basin
        zeroWebPage.purchaseForeignCurrency.click();

        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(zeroWebPage.currencyDdm.isEnabled(),
                "Currency dropdown menusu erisilebilir degil" );

        //13. “Currency” dropdown menusunden Eurozone’u secin
        Select select = new Select(zeroWebPage.currencyDdm);
        select.selectByValue("EUR");

        //14. "Eurozone (euro)" secildigini dogrulayin

        String expectedSelectedOption = "Eurozone (euro)";
        String actualSelectedOption = select.getFirstSelectedOption().getText();

        softAssert.assertEquals(actualSelectedOption,expectedSelectedOption,
                "currency dropdown menuden istenen option secilemedi" );

        //15. Dropdown menude 16 option bulundugunu dogrulayin.
        int expectedOptionCount = 16;
        int actualOptionCount = select.getOptions().size();

        softAssert.assertEquals(actualOptionCount,expectedOptionCount,
                "Dropdown menude 16 option bulunmuyor" );

        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin
        String expectedDropdownContent = "Canada (dollar)";
        List<String> ddmOptionList = ReusibleMethods.stringListeDonustur(select.getOptions());

        softAssert.assertTrue(ddmOptionList.contains(expectedDropdownContent),
                "Dropdown menude Canada (dollar) bulunmuyor" );

        //17. Sayfayi kapatin

        ReusibleMethods.wait(3);

        softAssert.assertAll();

        Driver.quitDriver();
    }
}
