package tests.day13_testNGFramework;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_TestNGIlkTest extends TestBase {
    /*
    TestNG test method'larini isim sirasına gire calistirir
    eger siralamayı degistirmek isterseniz
    priority kullnabiliriz.

    priority yazan method'lar kücükten büyüge göre siralanir.
    eger priority belirtilmeyen method varsa priority=0 kabul edilir.

    Ayni priority degerine sahip birden fazla method varsa
    bunlar harf sirasina göre calisir.
     */

    @Test(priority = 10)
    public void ilkTest(){
        driver.get("https://www.amazon.com");
    }

    @Test
    public void ikinciTest(){
        driver.get("https://www.youtube.com");
    }

    @Test
    public void ucuncuTest(){
        driver.get("https://www.wisequarter.com");
    }
}
