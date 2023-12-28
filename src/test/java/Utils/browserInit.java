package Utils;

import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


public class browserInit {
    static WebDriver driver;


    public static WebDriver startbrowser(String url , String browsername) {


        if (browsername.toLowerCase().contains("chr")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.setExperimentalOption("useAutomationExtension", false);
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");

            //options.setCapability("resolution", "1024x768"); // special request fl task
            driver = new ChromeDriver(options);
        } else if (browsername.toLowerCase().contains("fire")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("start-maximized");
            System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
            //options.setCapability("resolution", "1024x768");
            driver = new FirefoxDriver(options);

        } else if (browsername.toLowerCase().contains("internet")) {
            InternetExplorerOptions  options = new InternetExplorerOptions ();
            System.setProperty("webdriver.ie.driver", "Drivers\\IEDriverServer.exe");
            //options.setCapability("resolution", "1024x768");
            driver = new InternetExplorerDriver(options);




        } else if (browsername.toLowerCase().contains("edge")) {
            EdgeOptions  options = new EdgeOptions ();
            System.setProperty("webdriver.edge.driver", "Drivers\\msedgedriver.exe");
            //options.setCapability("resolution", "1024x768");
            driver = new EdgeDriver(options);




        }
        driver.navigate().to(url);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        return driver;
    }
}
