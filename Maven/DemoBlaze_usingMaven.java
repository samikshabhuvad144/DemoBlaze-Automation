package Project;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DemoBlaze 
{
	public static void main(String[] args) throws InterruptedException 
	{

        // Setup WebDriver
        //System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //  Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Actions Object
        Actions actions = new Actions(driver);

        // 1 Open Website
        driver.get("https://www.demoblaze.com/");
        System.out.println("successfully open site");
        Thread.sleep(2000);

        // 2Login
        driver.findElement(By.id("login2")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logInModal")));
        driver.findElement(By.id("loginusername")).sendKeys("wrong");
        driver.findElement(By.id("loginpassword")).sendKeys("wrong");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        System.out.println("login successfully");

        Thread.sleep(3000);

        // 3Hover using Actions (example)
        WebElement phoneCategory = driver.findElement(By.linkText("Phones"));
        actions.moveToElement(phoneCategory).perform();
        Thread.sleep(1000);
        phoneCategory.click();


        // 4 Add one phone
        driver.findElement(By.xpath("//a[text()='Samsung galaxy s6']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add to cart"))).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.navigate().back();
        driver.navigate().back();
        Thread.sleep(2000);
        System.out.println("phone category added successfully ");

        // 5 Laptops Category
        WebElement laptopCategory = driver.findElement(By.linkText("Laptops"));
        actions.moveToElement(laptopCategory).perform();
        Thread.sleep(1000);
        laptopCategory.click();

        driver.findElement(By.xpath("//a[text()='Sony vaio i5']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add to cart"))).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.navigate().back();
        driver.navigate().back();
        Thread.sleep(2000);
        System.out.println("laptop category added successfully ");

        // 6 Monitors Category
        WebElement monitorCategory = driver.findElement(By.linkText("Monitors"));
        actions.moveToElement(monitorCategory).perform();
        Thread.sleep(1000);
        monitorCategory.click();

        driver.findElement(By.xpath("//a[text()='Apple monitor 24']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add to cart"))).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.navigate().back();
        driver.navigate().back();
        Thread.sleep(2000);
        System.out.println("monitor category added successfully ");

        // 7 Go to Cart
        driver.findElement(By.id("cartur")).click();
        Thread.sleep(2000);
        System.out.println("navigate to the add to cart ");

        // 8 Delete a Product
        WebElement deleteButton = driver.findElement(By.xpath("(//a[text()='Delete'])[1]"));
        actions.moveToElement(deleteButton).click().perform();
        Thread.sleep(2000);
        System.out.println("delete the product ");

        //9place Order
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
        Thread.sleep(2000);
        System.out.println("orderd placed successfully ");

        //  Fill Form
        driver.findElement(By.id("name")).sendKeys("John Doe");
        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("city")).sendKeys("Pune");
        driver.findElement(By.id("card")).sendKeys("123456789");
        driver.findElement(By.id("month")).sendKeys("12");
        driver.findElement(By.id("year")).sendKeys("2025");
        driver.findElement(By.xpath("//button[text()='Purchase']")).click();
        Thread.sleep(2000);

        //   Confirm Purchase
        driver.findElement(By.xpath("//button[text()='OK']")).click();
        Thread.sleep(2000);
        System.out.println("order confirm ");

        //  Navigate to Contact Form
        driver.findElement(By.linkText("Contact")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exampleModal")));
        driver.findElement(By.id("recipient-email")).sendKeys("samu@example.com");
        driver.findElement(By.id("recipient-name")).sendKeys("samiksha");
        driver.findElement(By.id("message-text")).sendKeys("Hello!");
        driver.findElement(By.xpath("//button[text()='Send message']")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        System.out.println("fill the contact form");

        //  About Us
        WebElement aboutUs = driver.findElement(By.xpath("//a[text()='About us']"));
        actions.moveToElement(aboutUs).click().perform();

        // Wait for modal
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("videoModal")));
        Assert.assertTrue(modal.isDisplayed(), "About Us Modal not displayed");

        // Play Video
        WebElement playButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='videoModal']//button[@title='Play Video']")));
        actions.moveToElement(playButton).click().perform();
        System.out.println(" About Us Video Playing");
        Thread.sleep(5000);

        // Close modal
        WebElement closeBtn = driver.findElement(By.xpath("//div[@id='videoModal']//button[text()='Close']"));
        actions.moveToElement(closeBtn).click().perform();
        System.out.println(" Video Closed");
      

        //  Home Navigation using Next/Previous Buttons
        WebElement nextButton = driver.findElement(By.id("next2"));
        WebElement prevButton = driver.findElement(By.id("prev2"));
        actions.moveToElement(nextButton).click().perform();
        Thread.sleep(2000);
        actions.moveToElement(prevButton).click().perform();
        Thread.sleep(2000);
        System.out.println("home navigationusing next/previous successfully ");


        //  Logout
        driver.findElement(By.id("logout2")).click();
        Thread.sleep(2000);
        System.out.println("logout successfully ");

        // Close Browser
        driver.quit();
    }
}