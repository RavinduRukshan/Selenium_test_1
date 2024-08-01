package automationTestScript01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginTestScript {

    public static void main(String[] args) {
        // Chrome Driver path
        System.setProperty("webdriver.chrome.driver", "D:\\Chrome\\chromedriver-win64\\chromedriver.exe");
        
        // Instantiate a ChromeDriver class
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize Window
        
        // Direct to the Login Page
        driver.get("http://localhost/eCommerce/index.php");
        
        // Provide Correct Email
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.isDisplayed();
        emailField.isEnabled(); 
        emailField.sendKeys("ravindurukshan1015@gmail.com");
        
        // Provide Correct Password
        WebElement passwordField = driver.findElement(By.id("pw"));
        passwordField.isDisplayed();
        passwordField.isEnabled(); 
        passwordField.sendKeys("Ravindu1234");
        
        // Click Login Button
        WebElement loginButton = driver.findElement(By.id("userSignUpButton"));
        loginButton.isDisplayed();
        loginButton.isEnabled(); 
        loginButton.click();
        
        // Wait for the home page to load and check for the greeting message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement greetingMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p/span[contains(@class, 'text-primary')]/following-sibling::span")));
            String expectedGreeting = "Ravindu Rukshan";
            if (greetingMessage.getText().contains(expectedGreeting)) {
                System.out.println("Login successful. Greeting message displayed correctly.");
            } else {
                System.out.println("Login failed. Greeting message not displayed as expected.");
            }
        } catch (Exception e) {
            System.out.println("Login failed. Greeting message not found.");
        }

        // Close the browser
//        driver.quit();
    }
}