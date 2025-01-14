package tests.Day17_makeTestDataDynamic;

import utilities.Driver;
import utilities.ReusibleMethods;

public class C04_SingletonPattern {

    // testotomasyonu sayfasina gidin
    // Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        /*
            TestNG POM framework
            WebDriver icin Driver class'indaki getDriver()'unu kullanmamizi ister

            Framework'u hazirlayanlar
            farkli kullanimlarin da onune gecmek icin
            Driver class'inda Singleton Pattern kullanmayi tercih etmislerdir

            Singleton Pattern
            Constructor'i gorunur hale getirip
            access modifier'ini PRIVATE yaparak
            constructor'in kullanilmasini engellemis ve
            kullandigimiz class'dan obje olusturulmasinin onune gecmistir.

         */

    //Driver driver = new Driver();
    //driver.getDriver().get(ConfigReader.getProperty("toUrl"));


    //driver.driver.get(ConfigReader.getProperty("toUrl")); // NullPointerException


    // Driver.driver.get(ConfigReader.getProperty("toUrl"));



}
