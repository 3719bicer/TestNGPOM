package tests.practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.time.Duration;

public class RollCall_Yoklama_A001 {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void Test1() throws InterruptedException {
        /*
       1-yoklama sitesine gidelim.
       2-bizden istenen bilgilerden ilk olarak ad soyad girisi yapalim.
       3-Mail(kayit olurken verdiginiz mail) kismina bilgilerimizi girelim.
       4-Derse Katildim kisminda uygun olan isaretlemeyi yapalim.
       5-tum bilgileri tamamladiktan sonra gonder butonuna tiklayalim.
       6-Sayfayi Kapatalim.
         */

        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSd5_I3e-wir0s68TFyY3Cj3Th4vjusJ4xv1aUET0Y4i-sY9cQ/viewform");
        Thread.sleep(1000);
        WebElement adSoyad=driver.findElement(By.xpath("//input[@type=\"text\"][1]"));
        adSoyad.sendKeys("Veli Biçer");
        ReusableMethods.waitFor(1);

        WebElement mail= driver.findElement(By.xpath("//input[@aria-labelledby='i5']"));
        mail.sendKeys("vvelibicerr@gmail.com");
        ReusableMethods.waitFor(1);

        WebElement derseKatildim=driver.findElement(By.xpath("//div[@class='AB7Lab Id5V1'][1]"));
        derseKatildim.click();
        ReusableMethods.waitFor(1);

        WebElement gonder= driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[3]/div[1]/div[1]/div/span/span"));
        gonder.click();
        ReusableMethods.waitFor(1);

        WebElement yoklamaSonuc= driver.findElement(
                By.xpath("//div[@class='vHW8K']"));
        System.out.println("Yoklama durumu : " + yoklamaSonuc.getText());
        ReusableMethods.waitFor(1);
    }

    @AfterClass
    public void TearDown(){
        driver.quit();
    }
}
