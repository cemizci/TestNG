package pages;

import org.apache.poi.ooxml.util.PackageHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//span[text()='Allow all cookies'])[2]")
    public WebElement cookiesAcceptBtn;

    @FindBy(id = "email")
    public WebElement loginEmailBox;

    @FindBy(id = "password")
    public WebElement loginPasswordBox;

    @FindBy(name = "login")
    public WebElement loginPageLoginBtn;
}
