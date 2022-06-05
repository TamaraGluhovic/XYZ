import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerLogin extends BasePage{

    private By loginCustomer = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button");
    private By login = By.xpath("/html/body/div/div/div[2]/div/form/button");
    private By home = By.xpath("/html/body/div/div/div[1]/button[1]");





    public CustomerLogin(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }



    public void logCustomer(){
        getDriver().findElement(loginCustomer).click();
    }


    public void selectName(){

        getDriver().findElement(By.id("userSelect"));

        WebElement n =  getDriver().findElement(By.id("userSelect"));
        Select sl = new Select(n);
        //option by value
        sl.selectByIndex(6);
        //sl.selectByValue("Tamara Gluhovic");

        String s = sl.getFirstSelectedOption().getText();
        System.out.println("Value selected: : " + s);

    }

    public void login(){

        getDriver().findElement(this.login).click();
    }

    public void homeBtn(){

        getDriver().findElement(this.home).click();
    }
}
