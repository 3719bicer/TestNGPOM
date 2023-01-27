package tests.day17_smokeTests;

import org.testng.annotations.Test;

public class C01_SingleTonPattern {
    /*
    Singleton pattern bir class'dan obje oluşturulmasını engelleyen
    veya sinirlasndiran bir konseptir
     */

    @Test
    public void test01(){
        //amazon anasayfasına gidin.

        //Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        /*
         Tüm class'lardan yapabildiğimiz gibi Driver class'indan da
         obje oluşturulabilir ve oradaki class üyelerini kullanabiliriz
         Böyle bir kullanimda Driver class'inda yaptigimiz tercihler
         bypass edilmiş olur.

         Bu tür kullanimin önüne gecebilmek icin Java'dan
         singleton pattern konsepti uygulanir.

         Driver class'indan obje olusturulmasini engellemek icin
         Driver construcor'ina ihtiyac vardir.
         Eger bu construcor'a erisilemez yaparsak
         kimse construcor'a erisemez ve dolayisiyla
         kimse Driver class'inden obje olusturamaz.

         Bunu icin gorunur parametresiz bir constructer olusturup
         bunu private yapariz.

         Bu yönteme SINGLETON PATTERN denir
         */

        //Driver driver= new Driver();


    }
}
