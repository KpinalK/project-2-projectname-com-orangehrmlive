package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * BaseUrl = https://opensource-demo.orangehrmlive.com/
 * 1. Set up Multi browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current URL.
 * 5. Print the page source.
 * 6. Click on the ‘Forgot your password?’ link.
 * 7. Print the current URL.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email in the email field.
 * 11. Enter the password in the password field.
 * 12. Click on the Login Button.
 * 13. Close the browser.
 */

public class MultiBrowserTest {
    static String browser = "Edge";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        //1.Set up Multi Browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        //2.Open URL
        driver.get(baseUrl);
        //Maximise the browser window
        driver.manage().window().maximize();
        //We give Implicit wait to the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3.Print the title of page
        String title = driver.getTitle();
        System.out.println(title);

        //4.Print the Current URL
        String currentUrl = driver.getCurrentUrl();
        System.out.println("The Current URL " + currentUrl);

        //5.Print the page source
        System.out.println("The page source : " + driver.getPageSource());

        //6.Click on the 'Forgot your password?' link
        WebElement forgotYourPassword = driver.findElement(By.className("orangehrm-login-forgot-header"));
        forgotYourPassword.click();

        //7.Print the current URL
        System.out.println("The Current URL " + currentUrl);

        //8.Navigate back to the login page
        driver.navigate().back();
        System.out.println("The Current URL " + currentUrl);

        //9.Refresh the page
        driver.navigate().refresh();

        //10.Enter the email in the email field
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Pinal");


        //11.Enter the password in the password field
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("12345");

        //12.Click on the Login Button
        WebElement loginButton = driver.findElement(By.className("orangehrm-login-button"));
        loginButton.click();

        //13.Close the browser
        driver.quit();
    }
}
