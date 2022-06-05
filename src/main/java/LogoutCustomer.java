import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutCustomer extends BasePage{

    private By logout = By.xpath("/html/body/div/div/div[1]/button[2]");
    private By label = By.xpath("/html/body/div/div/div[2]/div/form/div/label");

    public LogoutCustomer(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void logoutBtn(){
        getDriver().findElement(logout).click();
    }
    public boolean pageYourNameDisplayed(){
        return getDriver().findElement(label).isDisplayed();
    }




}
