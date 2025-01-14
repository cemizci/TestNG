package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebUniversity {

    public WebUniversity(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



}
