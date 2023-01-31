package tests.day18_testNGReports_paralelTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C02_ReusableMethodsWindowshandle {
    // amazon anasayfaya gidin
    // arama kutusunun yanindaki dropdown menuyu locate edin
    // dropdown menudeki tum options listesini olusturup
    // menude Electronics basligi oldugunu test edin

    @Test
    public void test01(){
        // amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // arama kutusunun yanindaki dropdown menuyu locate edin.
        // dropdown menudeki tum options listesini olusturup
        AmazonPage amazonPage=new AmazonPage();
        Select select=new Select(amazonPage.dropdownMenu);
        List<WebElement> optionsElement=select.getOptions();
        System.out.println("optionsElement = " + optionsElement);
        ReusableMethods.waitFor(3);

        // menude Electronics basligi oldugunu test edin
        //Assert.assertTrue(optionsElement.contains("Electronics"));

        //optionsElements webElement'lerden olusuyor.
        //Electronics String'inin listede olup olmadıgini test etmek icin
        //öncelikle String'lerden olusan bir liste olmali

        List<String> optionsStringListsi= ReusableMethods.getElementsText(optionsElement);
        System.out.println("optionsStringListsi = " + optionsStringListsi);
        Assert.assertTrue(optionsStringListsi.contains
                (ConfigReader.getProperty("dropdownArananOption")));

        ReusableMethods.waitFor(15);
        Driver.closeDriver();

    }
}
