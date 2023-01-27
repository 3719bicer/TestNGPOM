package smokeTests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MyCourseDemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class NegatifLoginTesti {

    // Mycoursedemy anasayfasina gidin.
    // login linkine basin..
    // uc farkli test method'u ile yanlis bilgilerle giris yapilamadigini test edin.
    // 1- yanlis kullanici adi, gecerli password.
    // 2- gecerli kullanici adi, yanlis password.
    // 3- yanlis kullanici adi, yanlis password.
    // Login butonuna basarak login olmaya calisin.
    // Basarili olarak giris yapilamadigini test edin.

    MyCourseDemyPage myCourseDemyPage= new MyCourseDemyPage();

    @BeforeClass
    public void setup(){
        // Mycoursedemy anasayfasina gidin.
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));

        // login linkine basin..
        myCourseDemyPage.loginLinki.click();
    }

    // uc farkli test method'u ile yanlis bilgilerle giris yapilamadigini test edin.

    // 1- yanlis kullanici adi, gecerli password.
    @Test
    public void yanlisKullaniciTesit(){
        myCourseDemyPage=new MyCourseDemyPage();
        // 1- yanlis kullanici adi, gecerli password.
        myCourseDemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("myYanlisEmail"));
        myCourseDemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("myGecerliPassword"));

        // Login butonuna basarak login olmaya calisin.
        myCourseDemyPage.loginButonu.click();

        // Basarili olarak giris yapilamadigini test edin.
        // Bunu icin hala login linkinin gorunur oldugunu test edelim.
        Assert.assertTrue(myCourseDemyPage.loginLinki.isEnabled());

    }

    // 2- gecerli kullanici adi, yanlis password.
    @Test
    public void yanlisPasswordTesit(){
        myCourseDemyPage=new MyCourseDemyPage();
        // 2- gecerli kullanici adi, yanlis password.
        myCourseDemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("myGecerliEmail"));
        myCourseDemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("myYanlisEmail"));

        // Login butonuna basarak login olmaya calisin.
        myCourseDemyPage.loginButonu.click();

        // Basarili olarak giris yapilamadigini test edin.
        // Bunu icin hala login linkinin gorunur oldugunu test edelim.
        Assert.assertTrue(myCourseDemyPage.loginLinki.isEnabled());
    }

    // 3- yanlis kullanici adi, yanlis password.
    @Test
    public void yanlisEmailSifreTesit(){
        myCourseDemyPage=new MyCourseDemyPage();
        // 3- yanlis kullanici adi, yanlis password.
        myCourseDemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("myYanlisEmail"));
        myCourseDemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("myYanlisEmail"));

        // Login butonuna basarak login olmaya calisin.
        myCourseDemyPage.loginButonu.click();

        // Basarili olarak giris yapilamadigini test edin.
        // Bunu icin hala login linkinin gorunur oldugunu test edelim.
        Assert.assertTrue(myCourseDemyPage.loginLinki.isEnabled());
    }


    @AfterClass
    public void tearDown(){
        ReusableMethods.waitFor(5);
        Driver.closeDriver();
    }
}
