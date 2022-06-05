import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerAcc extends BasePage {


    private By openAccountBtn = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]");
    private By butoonProcess = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");



    public CustomerAcc(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }



    public void openBtn() {
        getDriver().findElement(this.openAccountBtn).click();
    }

    public void selectUser(){

        getDriver().findElement(By.id("userSelect"));

        WebElement n =  getDriver().findElement(By.id("userSelect"));
        Select sl = new Select(n);
        //option by value
        sl.selectByIndex(6);
        //sl.selectByValue("Tamara Gluhovic");

        String s = sl.getFirstSelectedOption().getText();
        System.out.println("Value selected: : " + s);

    }

    public void selectCurrency(){

        getDriver().findElement(By.id("currency"));

        WebElement n =  getDriver().findElement(By.id("currency"));
        Select sl = new Select(n);
        //option by value
        sl.selectByIndex(1);

        String s = sl.getFirstSelectedOption().getText();
        System.out.println("Value selected: : " + s);

    }


    public void process(){
        getDriver().findElement(butoonProcess).click();
    }

    public void closeMessage(){
        getDriver().switchTo().alert().accept();
    }

    public boolean getMessage(){
        String message =  getDriver().switchTo().alert().getText();

        if(message.contains("Account created successfully"))
            return true;
        else return false;

    }


}