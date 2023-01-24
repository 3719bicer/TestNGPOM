package tests.day15_pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_DriverKullanimi {

    //Bir tert methodu oluşturun.
    //1- amazon'a gidin, başlıginin amzon içerdiğini doğrulayin.
    //2- nutella için arama yapin ve sonuclarin nutella icerdigini dogrulayin.
    //3- wisequater sayfasina gidip, url' in wisequarter icerdiğini dogrulayin.

    @Test
    public void Test01(){
        //1- amazon'a gidin, başlıginin amzon içerdiğini doğrulayin.
        Driver.getDriver().get("https://www.amazon.com");
        String expKelime="Amazon";
        String actKelime=Driver.getDriver().getTitle();

        SoftAssert softAssert= new SoftAssert();
        softAssert.assertTrue(actKelime.contains(expKelime), "baslik amazon icermiyor");

        //2- nutella için arama yapin ve sonuclarin nutella icerdigini dogrulayin.
        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        WebElement aramaSonucElementi = Driver.getDriver()
                .findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
        String arananKelime="Nutella";
        String actualAramaSonucu=aramaSonucElementi.getText();
        softAssert.assertTrue(arananKelime.contains(actualAramaSonucu));

        //3- wisequater sayfasina gidip, url in wisequarter icerdiğini dogrulayin.
        Driver.getDriver().get("https://www.wisequarter.com");
        String arananUrlKelime="wisequarter";
        String actUrlKelime=Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(arananUrlKelime.contains(actUrlKelime), "URL wisequarter içermiyor");
        softAssert.assertAll();

        ReusableMethods.waitFor(5);
        Driver.closeDriver();
    }
}
