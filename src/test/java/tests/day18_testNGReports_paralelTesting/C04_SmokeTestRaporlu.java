package tests.day18_testNGReports_paralelTesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyCourseDemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C04_SmokeTestRaporlu extends TestBaseRapor {
    MyCourseDemyPage myCoursedemyPage=new MyCourseDemyPage();

    // uc farkli test method'u ile yanlis bilgilerle giris yapilamadigini test edin
    @Test
    public void yanlisKullaniciTesti(){
        // Mycoursedemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));

        // login linkine basin
        myCoursedemyPage.loginLinki.click();
        extentTest=extentReports.createTest("yanlis kullanici adi","yanlis kullanici adi ile giris yapilamaz");

        // 1- yanlis kullanici adi, gecerli password
        myCoursedemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("myYanlisEmail"));
        extentTest.info("kullanici adi olarak yanlis email yazildi");
        myCoursedemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("myGecerliPassword"));
        extentTest.info("Password olarak gecerli password yazildi");

        // Login butonuna basarak login olmaya calisin
        myCoursedemyPage.loginButonu.click();
        extentTest.info("Login butonuna basildi");

        // Basarili olarak giris yapilamadigini test edin
        // bunun icin hala login linklinin gorunur oldugunu test edelim
        Assert.assertTrue(myCoursedemyPage.loginLinki.isEnabled());
        extentTest.pass("Giris yapilamadigi test edildi");
    }

    @Test
    public void yanlisPasswordTesti(){
        // Mycoursedemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));

        // login linkine basin
        myCoursedemyPage=new MyCourseDemyPage();
        myCoursedemyPage.loginLinki.click();
        extentTest=extentReports.createTest("yanlis password","yanlis password ile giris yapilamaz");

        // 2- gecerli kullanici adi, yanlis password
        myCoursedemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("myGecerliEmail"));
        extentTest.info("kullanici adi olarak gecerli email yazildi");
        myCoursedemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("myYanlisPassword"));
        extentTest.info("Password olarak yanlis password yazildi");

        // Login butonuna basarak login olmaya calisin
        myCoursedemyPage.loginButonu.click();
        extentTest.info("Login butonuna basildi");

        // Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(myCoursedemyPage.loginLinki.isEnabled());
        extentTest.pass("Giris yapilamadigi test edildi");
    }

    @Test
    public void yanlisEmailSifreTesti(){
        // Mycoursedemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));

        // login linkine basin
        myCoursedemyPage=new MyCourseDemyPage();
        myCoursedemyPage.loginLinki.click();
        extentTest=extentReports.createTest("yanlis kullanici adi ve password","yanlis kullanici adi ve yanlis password ile giris yapilamaz");

        // 3- yanlis kullanici adi, yanlis password
        myCoursedemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("myYanlisEmail"));
        extentTest.info("kullanici adi olarak yanlis email yazildi");
        myCoursedemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("myYanlisPassword"));
        extentTest.info("Password olarak yanlis password yazildi");

        // Login butonuna basarak login olmaya calisin
        myCoursedemyPage.loginButonu.click();
        extentTest.info("Login butonuna basildi");

        // Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(myCoursedemyPage.loginLinki.isEnabled());
        extentTest.pass("Giris yapilamadigi test edildi");
    }

}