package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import javax.swing.text.Element;

public class SaucedemoPage {

    public SaucedemoPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id="user-name")
    public Element userName;

    @FindBy (xpath = "//input[@id='password']")
    public Element password;

    @FindBy (id="login-button")
    public Element loginButton;

}
