package online.tekwillacademy;

import online.tekwillacademy.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.google.com/");

        String theNameOfTheFirstTab = driver.getWindowHandle();

        //Open a new window and navigate to the DIEZ page
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://diez.md/");
        Thread.sleep(2000);
        //Close the current tab
        driver.close();

        driver.switchTo().window(theNameOfTheFirstTab);
        driver.get("https://www.bbc.co.uk/");
        Thread.sleep(2000);
        driver.quit();

       /* DriverManager.getInstance().getDriver().get("https://www.google.com/");
        Thread.sleep(5000);
        DriverManager.getInstance().getDriver().quit(); */

    }
}