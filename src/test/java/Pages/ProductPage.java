package Pages;
import Utils.pageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPage extends pageBase{


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div/div/div/div[1]/a/img")
    WebElement bookImage;


    @FindBy(how = How.XPATH, using="/html/body/div[1]/div[2]/div/div/div/div[2]/h1")
    WebElement productBookTitle;


    @FindBy(how = How.XPATH, using="/html/body/div[1]/div[2]/div/div/div/div[2]/form/button")
    WebElement productAddBtn;

    @FindBy(how = How.XPATH, using="/html/body/div[1]/div[2]/div/div/div/div[2]/div[1]/p/del/span")
    WebElement ProductPriceBeforeSale;

    @FindBy(how = How.XPATH, using="/html/body/div[1]/div[2]/div/div/div/div[2]/div[1]/p/ins/span")
    WebElement ProductPriceAfterSale;


    @FindBy(how = How.XPATH, using="/html/body/div[1]/div[2]/div[1]/div/div[1]/a")
    WebElement ViewCartBtn;




    public boolean checkBookImage (){
        Boolean result = bookImage.isDisplayed();
        return result ;
    }

    public boolean checkBookTitle (){
        Boolean result = productBookTitle.isDisplayed();
        return result ;
    }

    public String getBookTitle (){
        String result = productBookTitle.getText();
        return result ;
    }

    public String getProductPriceBeforeSale (){
        String result = ProductPriceBeforeSale.getText();
        return result ;
    }

    public String getProductPriceAfterSale (){
        String result =ProductPriceAfterSale.getText();
        return result ;
    }

    public  void clickProductAddToBasketBtn(){
        productAddBtn.click();
    }

    public  void clickProductViewCartBtn(){
        ViewCartBtn.click();
    }


}
