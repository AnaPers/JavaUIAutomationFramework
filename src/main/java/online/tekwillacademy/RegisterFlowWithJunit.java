package online.tekwillacademy;

import online.tekwillacademy.managers.DriverManager;
import online.tekwillacademy.managers.RandomDataManager;
import online.tekwillacademy.pageobjects.AccountPage;
import online.tekwillacademy.pageobjects.HomePage;
import online.tekwillacademy.pageobjects.LoginPage;
import online.tekwillacademy.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class RegisterFlowWithJunit {

    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;


    @BeforeAll
    public static void beforeAllTheTests(){
        System.out.println("This method is run before all tests from this class");
    }

    @BeforeEach
    public void beforeEachTest(){
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online/");

        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
        registerPage = new RegisterPage(driver);

    }

    @Test
    @DisplayName("User is redirected to Account page when registering with valid data")

    public void registerFlowWithValidDataRedirectsTheUserToAccountPage() throws InterruptedException {

        RegisterPage registerPage = new RegisterPage(driver);

        String firstName = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String password = RandomDataManager.getRandomPassword();

        //Actions on the Register page
        registerPage.completeTheRegisterForm(firstName, lastName, email, password);
        registerPage.enableTheToggleBar();
        registerPage.clickOnTheContinueBtn();

        Thread.sleep(2000);

        boolean urlContainsSuccessKeyword = driver.getCurrentUrl().contains("success");
        Assertions.assertTrue(urlContainsSuccessKeyword, "The URL of the page contains Success keyword");

        /*Account related actions
        AccountPage accountPage = new AccountPage(driver);
        accountPage.logOutFromTheAccount();
        homePage.navigateToLoginPage();
        Thread.sleep(5000);
        //Login page related actions
        LoginPage loginPage = new LoginPage(driver);
        loginPage.completeLoginForm(email, password);
        loginPage.clickTheLoginBtn();
        Thread.sleep(5000);*/
        //DriverManager.getInstance().quiteTheDriver();

    }

    @Test
    @DisplayName("The user remains on the register page when registering without accepting the terms and conditions")
    public void userRemainsOnRegisterPageWhenRegisteringWithoutAcceptingPrivacyRules() throws InterruptedException {
       /* WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online/");
        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();*/

        RegisterPage registerPage = new RegisterPage(driver);

        String firstName = RandomDataManager.getRandomFirstName();
        String lastName = RandomDataManager.getRandomLastName();
        String email = RandomDataManager.getRandomEmail();
        String password = RandomDataManager.getRandomPassword();

        //Actions on the Register page
        registerPage.completeTheRegisterForm(firstName, lastName, email, password);
        //registerPage.enableTheToggleBar();
        registerPage.clickOnTheContinueBtn();

       Assertions.assertTrue(driver.getCurrentUrl().contains("register"),"The page URL has the keyword register");

        //DriverManager.getInstance().quiteTheDriver();
    }

    @Test
    @DisplayName("Navigate to Login page from Register Page")
    public void navigateToLoginPageFromRegister(){
        registerPage.navigateToLoginPage();
        Assertions.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @AfterEach
    public void afterEachTest(){
        DriverManager.getInstance().quiteTheDriver();

    }
    @AfterAll
    public static void afterAllTheTests(){
        System.out.println("This method is executed after all the tests");
    }
}
