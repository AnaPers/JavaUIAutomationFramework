package online.tekwillacademy.pageobjects;

import online.tekwillacademy.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.XMLFormatter;

public class LoginPage extends Page{
    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "#input-email")
    private WebElement emailInput;

    @FindBy(css = "#input-password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement loginBtn;

    public void completeLoginForm(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);

    }

    public void clickTheLoginBtn(){
        loginBtn.click();
    }


}
