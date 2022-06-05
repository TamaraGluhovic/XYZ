import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Manager extends BasePage{

    private By addCustomer = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]");
    private By firstName = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input");
    private By lastName = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input");
    private By postCode = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input");

    private By addCustomerBtn = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]");
    private By clickAdd = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");

    private By message;

    public Manager(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void enterFirstName(String firstName){
        getDriver().findElement(this.firstName).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        getDriver().findElement(this.lastName).sendKeys(lastName);
    }

    public void enterPostCode(String postCode){
        getDriver().findElement(this.postCode).sendKeys(postCode);
    }


    public void closeMessage(){
        getDriver().switchTo().alert().accept();
    }

    public boolean getMessage(){
        String message =  getDriver().switchTo().alert().getText();

        if(message.contains("Customer added successfully"))
            return true;
            else return false;

    }

    public void AddCustomer(){
    getDriver().findElement(this.addCustomer).click();

}
    public void add (){
        getDriver().findElement(clickAdd).click();
    }



}
