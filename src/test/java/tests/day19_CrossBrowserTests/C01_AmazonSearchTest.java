package tests.day19_CrossBrowserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestBaseCross;

public class C01_AmazonSearchTest extends TestBaseCross {
    // Amazon anasayfaya gidin
    // Nutella, Java, Apple, Samsung, TV icin arama yapin
    // Arama sonuclarinin aranan kelime icerdigini test edin.

    @Test
    public void test01(){
        // Amazon anasayfaya gidin.
        driver.get(ConfigReader.getProperty("amazonUrl"));

        // Nutella, Java, Apple, Samsung, TV icin arama yapin.
        driver.findElement(By.id("twotabsearchtextbox")).
                sendKeys("Nutella"+ Keys.ENTER);

        // Arama sonuclarinin aranan kelime icerdigini test edin.
        String actualSonucyazisi=
                driver.findElement(By.xpath
                        ("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String expectedKElime="Nutella";

        Assert.assertTrue(actualSonucyazisi.contains(expectedKElime));
    }
}
