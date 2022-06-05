import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Deposit extends BasePage {

    private By depositBtn = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]");
    private By amountField = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By clickDeposit = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");
    private By message = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span");



    public Deposit(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void depositBtnClick (){
        getDriver().findElement(depositBtn).click();
    }

    public void amount(String number){
        getDriver().findElement(this.amountField).sendKeys(number);
    }

    public void depositClick(){
        getDriver().findElement(clickDeposit).click();
    }

    public boolean messageSuccessful(){
            return getDriver().findElement(message).isDisplayed();

    }


}