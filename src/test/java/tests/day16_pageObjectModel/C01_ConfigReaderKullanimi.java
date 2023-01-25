package tests.day16_pageObjectModel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_ConfigReaderKullanimi {
    //Amazon sayfasına gidin.
    //1 Test method' u oluşturun.
    //Nutella icin arama yapın.
    //sonuclarin arama yapriginiz kelimeleri icerdigini yazınız.

    @Test
    public void method01(){
        // Amazon anasayfaya gidin
        // driver.get(https://www.amazon.com)
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // 1 test method'u olusturun
        // Nutella icin arama yapip,
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys
                (ConfigReader.getProperty("amazonAramaKelimesi")+ Keys.ENTER);

        // sonuclarin arama yaptigimiz kelimeyi icerdigini test edin
        String expectedKelime= ConfigReader.getProperty("amazonAramaKelimesi");
        String actualAramaSonucu=amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));

        ReusableMethods.waitFor(5);
        Driver.closeDriver();
    }
}
