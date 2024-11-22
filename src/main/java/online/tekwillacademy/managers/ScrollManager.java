package online.tekwillacademy.managers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollManager {

    public static void scrollToElement(WebElement element){
        WebDriver driver = DriverManager.getInstance().getDriver();
        //WebElement privacyToggleBar = driver.findElement(By.name("agree"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
