package Pages;

import Utils.pageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPage extends pageBase {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using="/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/div/div/a")
    WebElement ProceedToCheckOutBtn;

    @FindBy(how = How.XPATH, using="/html/body/div[1]/div[2]/div/div/div/div/div[1]/form/table/tbody/tr[1]/td[3]/a")
    WebElement ProductTitle;

    @FindBy(how = How.XPATH, using="/html/body/div[1]/div[2]/div/div/div/div/div[1]/form/table/tbody/tr[1]/td[4]/span")
    WebElement ProductPrice;

    public String getProductTitle (){
        String result= ProductTitle.getText();
        return  result;
    }

    public String getProductPrice (){
        try {
            Thread.sleep(2000); // 2000 milliseconds = 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result= ProductPrice.getText();
        return  result;
    }

    public void ClickProceedToCheckout (){

        ProceedToCheckOutBtn.click();

    }

}
