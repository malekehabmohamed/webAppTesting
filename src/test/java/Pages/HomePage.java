package Pages;


import Utils.pageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends pageBase {


    @FindBy(how = How.XPATH, using="/html/body/div[1]/div[2]/div[1]/div/div/div/div/div[2]/div/div/div/div/div[2]/div[2]/div/div/ul/li/a[1]/h3")
    WebElement ThinkinginHTMLTitle;

    @FindBy(how = How.XPATH, using="/html/body/div[1]/div[2]/div[1]/div/div/div/div/div[2]/div/div/div/div/div[2]/div[2]/div/div/ul/li/a[1]/img")
    WebElement ThinkinginHTMLImage;

    @FindBy(how = How.XPATH, using="/html/body/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div[2]/div[2]/div/div/ul/li/a[2]")
    WebElement ThinkinginHTMLAddToBasketBtn;

    @FindBy(how = How.XPATH, using="/html/body/div[1]/div[1]/header/div[2]/nav/ul/li[6]/a/span[1]")
    WebElement CartContents;

    @FindBy(how = How.CLASS_NAME, using="amount")
    WebElement spanElement;

    @FindBy(xpath = "//a[@href='https://practice.automationtesting.in/product/thinking-in-html/']")
    WebElement thinkingUrl ;

    @FindBy(xpath = "//*[@id=\"text-22-sub_row_1-0-2-1-0\"]/div/ul/li/a[1]/h3")
    WebElement thinkingText ;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div[2]/div[2]/div/div/ul/li/a[1]/span[2]/del/span")
    WebElement priceBeforeSale ;


    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div[2]/div[2]/div/div/ul/li/a[1]/span[2]/ins/span")
    WebElement pricAftereSale ;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div[2]/div[2]/div/div/ul/li/a[3]")
    WebElement ViewBasket ;



    public HomePage(WebDriver driver) {
        super(driver);
    }

    public Boolean checkISDisplayed(){
        Boolean result = thinkingUrl.isDisplayed();
        return result ;
    }

    public void clickOnAddToCart(){
        ThinkinginHTMLAddToBasketBtn.click();
        try {
            Thread.sleep(2000); // 2000 milliseconds = 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }        ViewBasket.click();
    }

    public void clickOnBook(){
        ThinkinginHTMLTitle.click();
    }

    public String getThnkTitle_1(){
        String title = thinkingUrl.getText();
        return title ;
    }

    public String getThinkTitle_2(){
        String title = thinkingText.getText();
        return title ;
    }

    public String getPriceBeforeSale(){
        String BeforeSale = priceBeforeSale.getText();
        return BeforeSale ;
    }

    public String getPriceAfterSale(){
        String AftereSale = pricAftereSale.getText();
        return AftereSale ;
    }

    public void clickOnViewBasket(){
        ViewBasket.click();
    }

}
