package online.tekwillacademy.stepdefinitions;

import io.cucumber.java.en.Then;
import online.tekwillacademy.managers.DriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class GenericSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();

    @Then("the URL contains the following keyword {string}")
    public void theURLContainsTheFollowingKeyword(String collectKeyword) throws InterruptedException {
        Thread.sleep(5000);
        boolean containsKeyword = driver.getCurrentUrl().contains(collectKeyword);
        Assertions.assertTrue(containsKeyword, "The url contains : " + collectKeyword);
    }
}
