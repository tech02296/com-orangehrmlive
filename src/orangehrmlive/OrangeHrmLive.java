package orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class OrangeHrmLive {
    static String browser = "Firefox";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        //1.Opening URL
        driver.get(baseUrl);
        //2.Maximize the window
        driver.manage().window().maximize();
        //3.Timeout for hold the 10 second page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //4.Print the title of the page.
        System.out.println(driver.getTitle());
        //5.Print the current url.
        System.out.println(driver.getCurrentUrl());
        //6.Print the page source
        System.out.println(driver.getPageSource());
        //7.Click on ‘Forgot your password?’ link.
        WebElement pass = driver.findElement(By.className("orangehrm-login-forgot-header"));
        pass.click();
        //8.Print current URL
        System.out.println(driver.getCurrentUrl());
        //9.Navigate back to the login page.
        driver.navigate().to(baseUrl);
        //10.Refresh the page
        driver.navigate().refresh();
        //11.Enter the email to email field
        driver.findElement(By.name("username")).sendKeys("Tester");
        //12.Enter the password field
        driver.findElement(By.name("password")).sendKeys("tester123");
        //13.Click on login button
        WebElement login = driver.findElement(By.className("orangehrm-login-button"));
        login.click();
        //15.close the browser
        driver.quit();

    }

}
