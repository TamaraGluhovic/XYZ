import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Withdrawal extends BasePage {


    private By withdrawalBtn = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]");
    private By amountWithdrawn = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By withdrawalButton = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");
    private By message = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span");

    public Withdrawal(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void withdrawalclick (){
        getDriver().findElement(withdrawalBtn).click();
    }

    public void amount(String number){
        getDriver().findElement(this.amountWithdrawn).sendKeys(number);
    }

    public void buttonWithdravalClick(){
        getDriver().findElement(withdrawalButton).click();
    }

    public boolean messageSuccessful(){
        return getDriver().findElement(message).isDisplayed();

    }

}
