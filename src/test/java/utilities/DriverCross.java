package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverCross {

     /*
        DriverCross'un bizim kullandigim Driver Class'indan farki :

        Driver Class  : calisacak browser bilgisini ConfigReader araciligi ile
                        configuration.properties'den alir
        DriverCross     ise kullanilacakBrowser'i
                        configuration.properties'den DEGIL
                        parametre olarak TestBaseCross'dan alir
     */

    private static WebDriver driver;
    private DriverCross(){

    }

    public static WebDriver getDriver(String kullanılacakBrowser){

        kullanılacakBrowser = kullanılacakBrowser == null
                                ?
                                ConfigReader.getProperty("browser")
                                :
                                kullanılacakBrowser;

        // bu satir bizim emniyet subabimiz
        // eger parametre olarak null gonderilirse
        // configuration.properties'deki browser degerini alacak

        if (driver==null){
            switch(kullanılacakBrowser){
                case "firefox" :
                    driver = new FirefoxDriver();
                    break;

                case "safari" :
                    driver = new SafariDriver();
                    break;

                case "edge" :
                    driver = new EdgeDriver();
                    break;

                default :
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;
    }

    public static void closeDriver(){
        if (driver != null){
            driver.close();
            driver=null;
        }
    }

    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver=null;
        }
    }
}
