import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Testing {


    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginManager loginManager;
    private Manager manager;
    private CustomerAcc customerAcc;
    private CustomerLogin customerLogin;
    private Deposit deposit;
    private Withdrawal withdrawal;
    private LogoutCustomer logoutCustomer;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tamara\\IdeaProjects\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        loginManager = new LoginManager(driver, driverWait);
        manager = new Manager(driver, driverWait);
        customerAcc = new CustomerAcc(driver, driverWait);
        customerLogin = new CustomerLogin(driver, driverWait);
        deposit = new Deposit(driver,driverWait);
        logoutCustomer = new LogoutCustomer(driver, driverWait);
        withdrawal = new Withdrawal(driver,driverWait);
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }


 @BeforeMethod
    public void beforeMethod(){

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }

    @Test (priority = 1)
    public void loginTest() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button")));
        loginManager.clickBtnBankManager();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]")));
        Assert.assertTrue(loginManager.isDisplayedAdd());
    }

    @Test (priority = 2)
    public void createCustomer(){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]")));
        manager.AddCustomer();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input")));
        manager.enterFirstName("Tamara");
        manager.enterLastName("Gluhovic");
        manager.enterPostCode("23000");
        manager.add();
        Assert.assertTrue(manager.getMessage());
        manager.closeMessage();
    }

    @Test (priority = 3)
    public void createAccount(){
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/openAccount");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("  //*[@id=\"userSelect\"]")));
        customerAcc.selectUser();
        customerAcc.selectCurrency();
        customerAcc.process();
        Assert.assertTrue(customerAcc.getMessage());
        customerAcc.closeMessage();

    }

    @Test (priority = 4)
    public void customerLogin(){
        customerLogin.homeBtn();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button")));
        customerLogin.logCustomer();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"userSelect\"]")));
        customerLogin.selectName();
        customerLogin.login();
    }


    @Test (priority = 5)
    public void depositAmount(){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]")));
        deposit.depositBtnClick();
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")));
        deposit.amount("1000");
        deposit.depositClick();
        Assert.assertTrue(deposit.messageSuccessful());
    }

    @Test (priority = 6)
    public void WithrawalTest(){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]")));
        withdrawal.withdrawalclick();
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")));
        withdrawal.amount("500");
        withdrawal.buttonWithdravalClick();
        Assert.assertTrue(withdrawal.messageSuccessful());
    }


    @Test (priority = 7)
    public void logout(){
       driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[1]/button[2]")));
       logoutCustomer.logoutBtn();
        Assert.assertTrue(logoutCustomer.pageYourNameDisplayed());

    }


    @AfterClass
    public void affterclass(){
        driver.close();
    }
}