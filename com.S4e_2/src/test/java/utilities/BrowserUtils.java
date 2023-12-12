package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BrowserUtils {
    static Pages pages = new Pages();

    /**
     * This method enables us to wait until given Webelement is visibile.
     * @param element
     */
    public static void waitForVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This method refreshes the page.
     */
    public static void refreshPage(){
        Driver.getDriver().navigate().refresh();
    }

    /**
     * This method provides us to sleep the code during the given time.
     * @param seconds
     */
    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds*500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void wait(int second){
        Driver.getDriver().manage().timeouts().implicitlyWait(second, java.util.concurrent.TimeUnit.SECONDS);
    }

    public static void logIn(String userName,String password){

    }

    public static void logInAutomatically(){

    }

    public static void switchToFrame(WebElement frameElement) {
        Driver.getDriver().switchTo().frame(frameElement);
    }

    public static void switchToDefaultContent() {
        Driver.getDriver().switchTo().defaultContent();
    }


    public static void scrollToElement(WebElement element) {
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(element);
    }


    public static void clickWithJS (WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    public static void clickElementByJS (WebElement element){
        // javascript executor click
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("arguments[0].click();", element);
    }




    public static void switchToNewTab() {
        String currentWindowHandle = Driver.getDriver().getWindowHandle();
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                Driver.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static void switchToOriginalTab() {
        String currentWindowHandle = Driver.getDriver().getWindowHandle();
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();

        Driver.getDriver().close();

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                Driver.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }


    public static void SignOut(){

    }

/*    public static void showElementWithFrame(String locate){
        WebElement element = Driver.getDriver().findElement(By.xpath("" + locate + ""));
        String script = "argument[0].style.border='3px solid red';";
        //String script = "argument[0].style.border='3px solid yellow';";
        //String script = "argument[0].style.border='3px solid green';";
        (JavascriptExecutor) Driver.getDriver().executeScript(script,element);
    }*/

}
