package tests.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P04 extends TestBase {
    /*
     * Navigate to https://www.saucedemo.com/
     * Enter the username as standard_user
     * Enter the password as secret_sauce
     * Click on login button
     *    Test1 : Choose price low to high
     *    Test2 : Verify item prices are sorted from low to high with soft Assert
     */
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void saucedemoTest1() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement dropDown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Price (low to high)");
        String exp = "PRICE (LOW TO HIGH)";
        String act = driver.findElement(By.className("active_option")).getText();
        softAssert.assertEquals(act, exp, "Aktif secenekteki yazi expected datadan farkli.");
        softAssert.assertAll();
    }

    @Test
    public void saucedemoTest2() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebElement dropDown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Price (low to high)");
        List<WebElement> fiyatlar = driver.findElements(By.className("inventory_item_price"));
        ArrayList<Double> fiyatlarDouble = new ArrayList<>();
        for (WebElement fiyat : fiyatlar) {
            // String fiyatStr = fiyat.getText().replaceAll("$","");
            String fiyatStr = fiyat.getText().replaceAll("^\\D", "");
            fiyatlarDouble.add(Double.parseDouble(fiyatStr));
        }
        ArrayList<Double> kontrolList = new ArrayList<>(fiyatlarDouble);
        Collections.sort(kontrolList);
        System.out.println(kontrolList + "\n" + fiyatlarDouble);
        softAssert.assertEquals(kontrolList, fiyatlarDouble);
        softAssert.assertAll();
    }
}
       /*
        \n : Starts from a new line : Metni bir alt satirdan itibaren yazdirir.
        \t  : Horizontal tab: Metni yatayda 1 tab miktar kaydirir.
        \\  : Prints a back slash    : \  Ters slash yazdirir
        \'  : Prints single quote    : '  Tek tirnak yazdirir.
        \"  : Prints double quote    : "  Cift tirnak yazdirir.
        str=str.replaceAll("\\D",""); dijit olmayan hersey
        str=str.replaceAll("\\S",""); space olmayan hersey
        str=str.replaceAll("\\W",""); harf veya rakam olmayan hersey
        str=str.replaceAll("\\d",""); dijit
        str=str.replaceAll("\\s",""); space
        str=str.replaceAll("\\w",""); harf veya rakam
        str=str.replaceAll("\\s+",""); yan yana birden fazla space
        str=str.replaceAll("\\b","");
        str=str.replace("3","c"); bir tane degistirir. 3=c olur.
        str=str.replaceAll("3","c"); tüm 3 leri c yapar.
        */
