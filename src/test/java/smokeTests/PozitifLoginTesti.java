package smokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyCourseDemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class PozitifLoginTesti {
    // Mycoursedemy anasayfasina gidin
    // login linkine basin
    // Kullanici email'i olarak valid email girin
    // Kullanici sifresi olarak valid sifre girin
    // Login butonuna basarak login olun
    // Basarili olarak giris yapilabildigini test edin

    //276	Test	User	user_1106157@login.com	923081199	1

    @Test
    public void pozitifLoginTesti(){
        // Mycoursedemy anasayfasina gidin.
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));

        // login linkine basin.
        MyCourseDemyPage myCourseDemyPage= new MyCourseDemyPage();
        myCourseDemyPage.loginButonu.click();

        // Kullanici email'i olarak valid email girin.
        myCourseDemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("myGecerliEmail"));

        // Kullanici sifresi olarak valid sifre girin.
        myCourseDemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("myGecerliPassword"));
        myCourseDemyPage.acceptCookies.click();
        ReusableMethods.waitFor(2);


        // Login butonuna basarak login olun.
        myCourseDemyPage.loginButonu.click();

        // Basarili olarak giris yapilabildigini test edin.
        Assert.assertTrue(myCourseDemyPage.coursesLinki.isDisplayed());
        //SoftAssert softAssert=new SoftAssert();
        //softAssert.assertTrue(myCourseDemyPage.coursesLinki.isDisplayed(),"basarili bir şekilde giriş yapildi");
        //softAssert.assertAll();

        ReusableMethods.waitFor(5);
        Driver.closeDriver();
    }
}
