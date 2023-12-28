package Pages;

import Utils.pageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BillingDetailsPage extends pageBase {

    public BillingDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using="billing_first_name")
    WebElement FirstName;

    @FindBy(how = How.ID, using="billing_last_name")
    WebElement LastName;

    @FindBy(how = How.ID, using="billing_email")
    WebElement Email;

    @FindBy(how = How.ID, using="billing_phone")
    WebElement Phone;

    @FindBy(how = How.ID, using="billing_address_1")
    WebElement Address;

    @FindBy(how = How.ID, using="billing_city")
    WebElement City;

    @FindBy(how = How.ID, using="billing_postcode")
    WebElement Postcode;

    @FindBy(how = How.ID, using="place_order")
    WebElement placeorderBtn;

    @FindBy(how = How.ID, using="payment_method_cheque")
    WebElement CheckPayment;

    @FindBy(how = How.ID, using="payment_method_cod")
    WebElement CashonDelivery;

    @FindBy(how = How.ID, using="payment_method_ppec_paypal")
    WebElement PayPalExpressCheckout;




    public  void fillAllBillingDetails(String firstname, String lastname, String email, String phone, String address, String city, String postcode)
    {
        FirstName.sendKeys(firstname);
        LastName.sendKeys(lastname);
        Email.sendKeys(email);
        Phone.sendKeys(phone);
        Address.sendKeys(address);
        City.sendKeys(city);
        Postcode.sendKeys(postcode);

    }

    public void payByCOD (){
        CashonDelivery.click();
    }

    public void payByCheque (){
        CheckPayment.click();
    }

    public void payByPaypal (){
        PayPalExpressCheckout.click();
    }

    public void clickPlaceOrder(){
        placeorderBtn.click();
    }
}
