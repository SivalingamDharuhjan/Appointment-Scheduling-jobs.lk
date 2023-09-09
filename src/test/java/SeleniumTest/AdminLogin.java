import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminLogin {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        
        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();
        
        // Open the website
        driver.get("https://example.com/login");
        
        // Find the username and password input fields and login button by their IDs or other locators
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        
        // Enter your admin credentials
        usernameField.sendKeys("admin_username");
        passwordField.sendKeys("admin_password");
        
        // Click the login button
        loginButton.click();
        
        // Wait for some time to see the result (You should use WebDriverWait for real tests)
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
        }
        
        // Close the browser
        driver.quit();
    }
}
