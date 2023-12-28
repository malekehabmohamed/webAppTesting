package TestCases;

import Pages.BillingDetailsPage;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import Utils.browserInit;
import Utils.pageBase;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class AutomationTests extends browserInit {

    private WebDriver driver;
    private pageBase pagebase;
    private HomePage homePage;
    private ProductPage productPage;
    private CartPage cartPage;
    private BillingDetailsPage billingDetailsPage;

    private static final String URL = "https://practice.automationtesting.in/";
    private static final String PriceBeforeSale = "₹450.00";
    private static final String PriceAfterSale = "₹400.00";
    private static final String BookTitle = "Thinking in HTML";
    private static final String FirstName = "First Name";
    private static final String LastName = "Last Name";
    private static final String Email = "test@test.com";
    private static final String Phone = "00201221985552";
    private static final String Address = "Address";
    private static final String City = "City";
    private static final String Postcode = "Postcode";
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass
    public void classInit() {

        // Set up ExtentReports
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");


    }

    @BeforeMethod
    public void setUp() {
        // Set up ExtentReports
        driver = browserInit.startbrowser(URL, "edge");
        pagebase = new pageBase(driver);


        // Set up ExtentReports
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);





        // Initialize page objects
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        billingDetailsPage = new BillingDetailsPage(driver);
    }

    @AfterMethod
    public void tearDown() {

        // Close the Edge browser after each test method
        if (driver != null) {
            driver.quit();
        }
        extent.flush();
    }

    @Test()
    public void PurchaseThinkingInHTMLBook_DirectlyGotoCart_HappyScenario() throws Exception {
        // Create a test in the Extent report
        test = extent.createTest("PurchaseThinkingInHTMLBook_DirectlyGotoCart_HappyScenario");

        // Check if the home page is displayed successfully
        Boolean result = homePage.checkISDisplayed();
        Assert.assertTrue(result);

        // Verify the first title on the home page contains the expected book title
        String title = homePage.getThnkTitle_1();
        Assert.assertTrue(title.contains(BookTitle));

        // Verify the second title on the home page matches the expected book title
        String title2 = homePage.getThinkTitle_2();
        Assert.assertEquals(title2, BookTitle);

        // Verify the price before sale on the home page matches the expected value
        String beforeSale = homePage.getPriceBeforeSale();
        Assert.assertEquals(beforeSale, PriceBeforeSale);

        // Verify the price after sale on the home page matches the expected value
        String afterSale = homePage.getPriceAfterSale();
        Assert.assertEquals(afterSale, PriceAfterSale);

        // Click on the "Add to Cart" button on the home page
        homePage.clickOnAddToCart();

        // Verify the product price in the cart matches the expected value
        String productCartPrice = cartPage.getProductPrice();
        Assert.assertEquals(afterSale, productCartPrice);

        // Verify the product title in the cart matches the expected book title
        String CartProductTitle = cartPage.getProductTitle();
        Assert.assertEquals(BookTitle, CartProductTitle);

        // Click on the "Proceed to Checkout" button on the cart page
        cartPage.ClickProceedToCheckout();

        // Fill in billing details and click on the "Place Order" button on the billing details page
        billingDetailsPage.fillAllBillingDetails(FirstName, LastName, Email, Phone, Address, City, Postcode);
        billingDetailsPage.clickPlaceOrder();

        test.log(Status.PASS, "Test Passed");
    }

    @Test()
    public void PurchaseThinkingInHTMLBook_GoToProductFirst_DirectBankTransfer() throws Exception {
        // Create a test in the Extent report
        test = extent.createTest("PurchaseThinkingInHTMLBook_GoToProductFirst_DirectBankTransfer");
        // Set up ExtentReports
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Check if the home page is displayed successfully
        Boolean result = homePage.checkISDisplayed();
        Assert.assertTrue(result);

        // Verify the first title on the home page contains the expected book title
        String title = homePage.getThnkTitle_1();
        Assert.assertTrue(title.contains(BookTitle));

        // Verify the second title on the home page matches the expected book title
        String title2 = homePage.getThinkTitle_2();
        Assert.assertEquals(title2, BookTitle);

        // Verify the price before sale on the home page matches the expected value
        String beforeSale = homePage.getPriceBeforeSale();
        Assert.assertEquals(beforeSale, PriceBeforeSale);

        // Verify the price after sale on the home page matches the expected value
        String afterSale = homePage.getPriceAfterSale();
        Assert.assertEquals(afterSale, PriceAfterSale);

        // Click on the "Book"  on the home page
        homePage.clickOnBook();

        // Verify various elements on the product page
        Assert.assertTrue(productPage.checkBookImage());
        Assert.assertTrue(productPage.checkBookTitle());
        Assert.assertEquals(productPage.getBookTitle(), BookTitle);

        // Verify the product price before sale on the product page matches the expected value
        String productbeforeSale = productPage.getProductPriceBeforeSale();
        Assert.assertEquals(beforeSale, productbeforeSale);

        // Verify the product price after sale on the product page matches the expected value
        String productafterSale = productPage.getProductPriceAfterSale();
        Assert.assertEquals(afterSale, productafterSale);

        // Click on the "Add to Basket" button on the product page
        productPage.clickProductAddToBasketBtn();

        // Click on the "View Cart" button on the product page
        productPage.clickProductViewCartBtn();

        // Verify the product price in the cart matches the expected value
        String productCartPrice = cartPage.getProductPrice();
        Assert.assertEquals(afterSale, productCartPrice);

        // Verify the product title in the cart matches the expected book title
        String CartProductTitle = cartPage.getProductTitle();
        Assert.assertEquals(BookTitle, CartProductTitle);

        // Click on the "Proceed to Checkout" button on the cart page
        cartPage.ClickProceedToCheckout();

        // Fill in billing details and click on the "Place Order" button on the billing details page
        billingDetailsPage.fillAllBillingDetails(FirstName, LastName, Email, Phone, Address, City, Postcode);
        billingDetailsPage.clickPlaceOrder();

        test.log(Status.PASS, "Test Passed");

    }

    @Test()
    public void PurchaseThinkingInHTMLBook_GoToProductFirst_CheckPayments() throws Exception {
        test = extent.createTest("PurchaseThinkingInHTMLBook_GoToProductFirst_CheckPayments");

        // Set up ExtentReports
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Check if the home page is displayed successfully
        Boolean result = homePage.checkISDisplayed();
        Assert.assertTrue(result);

        // Verify the first title on the home page contains the expected book title
        String title = homePage.getThnkTitle_1();
        Assert.assertTrue(title.contains(BookTitle));

        // Verify the second title on the home page matches the expected book title
        String title2 = homePage.getThinkTitle_2();
        Assert.assertEquals(title2, BookTitle);

        // Verify the price before sale on the home page matches the expected value
        String beforeSale = homePage.getPriceBeforeSale();
        Assert.assertEquals(beforeSale, PriceBeforeSale);

        // Verify the price after sale on the home page matches the expected value
        String afterSale = homePage.getPriceAfterSale();
        Assert.assertEquals(afterSale, PriceAfterSale);

        // Click on the "Book" button on the home page
        homePage.clickOnBook();

        // Verify various elements on the product page
        Assert.assertTrue(productPage.checkBookImage());
        Assert.assertTrue(productPage.checkBookTitle());
        Assert.assertEquals(productPage.getBookTitle(), BookTitle);

        // Verify the product price before sale on the product page matches the expected value
        String productbeforeSale = productPage.getProductPriceBeforeSale();
        Assert.assertEquals(beforeSale, productbeforeSale);

        // Verify the product price after sale on the product page matches the expected value
        String productafterSale = productPage.getProductPriceAfterSale();
        Assert.assertEquals(afterSale, productafterSale);

        // Click on the "Add to Basket" button on the product page
        productPage.clickProductAddToBasketBtn();

        // Click on the "View Cart" button on the product page
        productPage.clickProductViewCartBtn();

        // Verify the product price in the cart matches the expected value
        String productCartPrice = cartPage.getProductPrice();
        Assert.assertEquals(afterSale, productCartPrice);

        // Verify the product title in the cart matches the expected book title
        String CartProductTitle = cartPage.getProductTitle();
        Assert.assertEquals(BookTitle, CartProductTitle);

        // Click on the "Proceed to Checkout" button on the cart page
        cartPage.ClickProceedToCheckout();

        // Fill in billing details and click on the "Place Order" button on the billing details page
        billingDetailsPage.fillAllBillingDetails(FirstName, LastName, Email, Phone, Address, City, Postcode);
        billingDetailsPage.payByCheque();
        billingDetailsPage.clickPlaceOrder();

        test.log(Status.PASS, "Test Passed");

    }

    @Test()
    public void PurchaseThinkingInHTMLBook_GoToProductFirst_CashOnDelivery() throws Exception {

        test = extent.createTest("PurchaseThinkingInHTMLBook_GoToProductFirst_CashOnDelivery");

        // Set up ExtentReports
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Check if the home page is displayed successfully
        Boolean result = homePage.checkISDisplayed();
        Assert.assertTrue(result);

        // Verify the first title on the home page contains the expected book title
        String title = homePage.getThnkTitle_1();
        Assert.assertTrue(title.contains(BookTitle));

        // Verify the second title on the home page matches the expected book title
        String title2 = homePage.getThinkTitle_2();
        Assert.assertEquals(title2, BookTitle);

        // Verify the price before sale on the home page matches the expected value
        String beforeSale = homePage.getPriceBeforeSale();
        Assert.assertEquals(beforeSale, PriceBeforeSale);

        // Verify the price after sale on the home page matches the expected value
        String afterSale = homePage.getPriceAfterSale();
        Assert.assertEquals(afterSale, PriceAfterSale);

        // Click on the "Book" button on the home page
        homePage.clickOnBook();

        // Verify various elements on the product page
        Assert.assertTrue(productPage.checkBookImage());
        Assert.assertTrue(productPage.checkBookTitle());
        Assert.assertEquals(productPage.getBookTitle(), BookTitle);

        // Verify the product price before sale on the product page matches the expected value
        String productbeforeSale = productPage.getProductPriceBeforeSale();
        Assert.assertEquals(beforeSale, productbeforeSale);

        // Verify the product price after sale on the product page matches the expected value
        String productafterSale = productPage.getProductPriceAfterSale();
        Assert.assertEquals(afterSale, productafterSale);

        // Click on the "Add to Basket" button on the product page
        productPage.clickProductAddToBasketBtn();

        // Click on the "View Cart" button on the product page
        productPage.clickProductViewCartBtn();

        // Verify the product price in the cart matches the expected value
        String productCartPrice = cartPage.getProductPrice();
        Assert.assertEquals(afterSale, productCartPrice);

        // Verify the product title in the cart matches the expected book title
        String CartProductTitle = cartPage.getProductTitle();
        Assert.assertEquals(BookTitle, CartProductTitle);

        // Click on the "Proceed to Checkout" button on the cart page
        cartPage.ClickProceedToCheckout();

        // Fill in billing details and click on the "Place Order" button on the billing details page
        billingDetailsPage.fillAllBillingDetails(FirstName, LastName, Email, Phone, Address, City, Postcode);
        billingDetailsPage.payByCOD();
        billingDetailsPage.clickPlaceOrder();

        test.log(Status.PASS, "Test Passed");

    }

    @Test()
    public void PurchaseThinkingInHTMLBook_GoToProductFirst_PaypalExpressCheckout() throws Exception {
        test = extent.createTest("PurchaseThinkingInHTMLBook_GoToProductFirst_PaypalExpressCheckout");

        // Set up ExtentReports
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Instantiate page objects for various pages
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        billingDetailsPage = new BillingDetailsPage(driver);

        // Check if the home page is displayed successfully
        Boolean result = homePage.checkISDisplayed();
        Assert.assertTrue(result);

        // Verify the first title on the home page contains the expected book title
        String title = homePage.getThnkTitle_1();
        Assert.assertTrue(title.contains(BookTitle));

        // Verify the second title on the home page matches the expected book title
        String title2 = homePage.getThinkTitle_2();
        Assert.assertEquals(title2, BookTitle);

        // Verify the price before sale on the home page matches the expected value
        String beforeSale = homePage.getPriceBeforeSale();
        Assert.assertEquals(beforeSale, PriceBeforeSale);

        // Verify the price after sale on the home page matches the expected value
        String afterSale = homePage.getPriceAfterSale();
        Assert.assertEquals(afterSale, PriceAfterSale);

        // Click on the "Book" button on the home page
        homePage.clickOnBook();

        // Verify various elements on the product page
        Assert.assertTrue(productPage.checkBookImage());
        Assert.assertTrue(productPage.checkBookTitle());
        Assert.assertEquals(productPage.getBookTitle(), BookTitle);

        // Verify the product price before sale on the product page matches the expected value
        String productbeforeSale = productPage.getProductPriceBeforeSale();
        Assert.assertEquals(beforeSale, productbeforeSale);

        // Verify the product price after sale on the product page matches the expected value
        String productafterSale = productPage.getProductPriceAfterSale();
        Assert.assertEquals(afterSale, productafterSale);

        // Click on the "Add to Basket" button on the product page
        productPage.clickProductAddToBasketBtn();

        // Click on the "View Cart" button on the product page
        productPage.clickProductViewCartBtn();

        // Verify the product price in the cart matches the expected value
        String productCartPrice = cartPage.getProductPrice();
        Assert.assertEquals(afterSale, productCartPrice);

        // Verify the product title in the cart matches the expected book title
        String CartProductTitle = cartPage.getProductTitle();
        Assert.assertEquals(BookTitle, CartProductTitle);

        // Click on the "Proceed to Checkout" button on the cart page
        cartPage.ClickProceedToCheckout();

        // Fill in billing details and click on the "Place Order" button on the billing details page
        billingDetailsPage.fillAllBillingDetails(FirstName, LastName, Email, Phone, Address, City, Postcode);
        billingDetailsPage.payByPaypal();
        billingDetailsPage.clickPlaceOrder();

        test.log(Status.PASS, "Test Passed");

    }

}
