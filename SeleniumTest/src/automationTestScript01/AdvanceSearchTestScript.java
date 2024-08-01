package automationTestScript01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class AdvanceSearchTestScript {

    public static void main(String[] args) {
        // Chrome Driver path
        System.setProperty("webdriver.chrome.driver", "D:\\Chrome\\chromedriver-win64\\chromedriver.exe");
        
        // Instantiate a ChromeDriver class
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Direct to the Home Page
        driver.get("http://localhost/eCommerce/shop-home.php");

        // Open Advance Search Modal
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement advanceSearchLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/header[1]/nav[1]/div[1]/div[1]/div[2]/ul[1]/li[4]/a[1]")));
        advanceSearchLink.click();
        
        // Wait for the modal to be visible
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("advanceSearchModel")));
        
        // Fill out the advance search form
        WebElement titleField = driver.findElement(By.id("title"));
        titleField.sendKeys("Harry Potter and the Cursed Child");
        
        // Select an author
        Select authorSelect = new Select(driver.findElement(By.id("auther")));
        authorSelect.selectByVisibleText("J. K. Rowling"); 

        // Select a publication
        Select pubSelect = new Select(driver.findElement(By.id("pub")));
        pubSelect.selectByVisibleText("Bloomsbury (UK)"); 
        
        // Select a category
        Select catSelect = new Select(driver.findElement(By.id("cat")));
        catSelect.selectByVisibleText("Fantasy");

        // Set min and max price
        WebElement minPriceField = driver.findElement(By.id("min"));
        minPriceField.sendKeys("1000");

        WebElement maxPriceField = driver.findElement(By.id("max"));
        maxPriceField.sendKeys("7000");

        // Select a language
        Select langSelect = new Select(driver.findElement(By.id("lan")));
        langSelect.selectByVisibleText("English");

        // Select book condition
        WebElement conditionNewRadio = driver.findElement(By.id("new"));
        conditionNewRadio.click();

        // Select book type
        Select typeSelect = new Select(driver.findElement(By.id("type")));
        typeSelect.selectByVisibleText("Book");

        // Click the Search button
        WebElement searchButton = driver.findElement(By.xpath("//button[contains(text(), 'Search')]"));
        searchButton.click();
        
        // Wait for search results
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("advanceSeachResults")));
        
        // Verify search results
        WebElement expectedResult = driver.findElement(By.xpath("(//a[@href='single-product.html'][normalize-space()='Harry Potter and the Cursed Child'])[3]"));
        if (expectedResult.isDisplayed()) {
            System.out.println("Advance search executed successfully and the expected result is displayed.");
        } else {
            System.out.println("Advance search did not return the expected result.");
        }
        
        
        // Close the browser
        driver.quit();
        
    }
}