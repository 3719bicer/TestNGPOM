package tests.practise;

import org.testng.annotations.Test;
import utilities.TestBaseClass;

public class P02 extends TestBaseClass{

    /*
    - Birbirine bagimli testler olusturun.
    - beforeClass olusturup setUp ayarlarini yapin.
    - Birbirine bagimli testlr olusturarak ;
        =>ilk once facebook'a gidin
        =>sonra facebook'a bagimli olarak google'a gidin
        =>daha sonra google'a bagimli olarak amazon'a gidin
    -driver'i kapatin.
     */

    @Test (dependsOnMethods = "facebook" )
    public void google(){
        driver.get("http://google.com");
    }
    @Test (enabled = false)
    public void facebook(){
        driver.get("http://facebook.com");
    }
    @Test (dependsOnMethods = "google" )
    public void amazon(){
        driver.get("http://amazon.com");
    }
}
