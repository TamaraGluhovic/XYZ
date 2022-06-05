import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginManager extends BasePage{


   private By bankManagerLogin = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button");
   private By isThereAddButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]");

   private By customerLogin = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button");

   private By label = By.xpath("//*[contains(text(), 'Your Name :')]");




    public LoginManager(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void clickBtnBankManager(){

        getDriver().findElement(bankManagerLogin).click();
    }

    public boolean isDisplayedAdd(){
        return getDriver().findElement(isThereAddButton).isDisplayed();
    }


}
