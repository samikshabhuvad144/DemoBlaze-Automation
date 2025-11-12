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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoBlaze_TestNg
{
	WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeClass
    public void setup() 
    {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        driver.get("https://www.demoblaze.com/");
    }

    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
        driver.findElement(By.id("login2")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("loginusername")).sendKeys("wrong"); 
        driver.findElement(By.id("loginpassword")).sendKeys("wrong");  
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.id("logout2")).isDisplayed(), "Login Failed!");
        System.out.println("Login Successful");
    }

    @Test(priority = 2)
    public void addPhonesToCart() throws InterruptedException
    {
        driver.findElement(By.linkText("Phones")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Samsung galaxy s6']")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Add to cart")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().back();
        System.out.println("Phone Added to Cart");
    }

    @Test(priority = 3)
    public void addLaptopsToCart() throws InterruptedException 
    {
        driver.findElement(By.linkText("Laptops")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Sony vaio i5']")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Add to cart")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().back();
        System.out.println(" Laptop Added to Cart");
    }

    @Test(priority = 4)
    public void addMonitorsToCart() throws InterruptedException {
        driver.findElement(By.linkText("Monitors")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Apple monitor 24']")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Add to cart")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().back();
        System.out.println(" Monitor Added to Cart");
    }

    @Test(priority = 5)
    public void placeOrder() throws InterruptedException {
        driver.findElement(By.id("cartur")).click();
        Thread.sleep(2000);

        // delete first item
        driver.findElement(By.xpath("(//a[text()='Delete'])[1]")).click();
        Thread.sleep(2000);

        // Place Order
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("name")).sendKeys("Samiksha");
        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("city")).sendKeys("Mumbai");
        driver.findElement(By.id("card")).sendKeys("123456789");
        driver.findElement(By.id("month")).sendKeys("10");
        driver.findElement(By.id("year")).sendKeys("2025");
        driver.findElement(By.xpath("//button[text()='Purchase']")).click();
        Thread.sleep(2000);

        // OK confirmation
        driver.findElement(By.xpath("//button[text()='OK']")).click();
        System.out.println(" Order Placed Successfully");
    }

    @Test(priority = 6)
    public void contactForm() throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='Contact']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("recipient-email")).sendKeys("samu@mail.com");
        driver.findElement(By.id("recipient-name")).sendKeys("Samiksha");
        driver.findElement(By.id("message-text")).sendKeys("This is an automation test message.");
        driver.findElement(By.xpath("//button[text()='Send message']")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        System.out.println(" Contact Form Submitted");
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void aboutUsVideo() throws InterruptedException 
    {
        WebElement aboutUs = driver.findElement(By.xpath("//a[text()='About us']"));
        actions.moveToElement(aboutUs).click().perform();

        // Wait for modal
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("videoModal")));
        Assert.assertTrue(modal.isDisplayed(), "About Us Modal not displayed");

        // Play Video
        WebElement playButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@id='videoModal']//button[@title='Play Video']")));
        actions.moveToElement(playButton).click().perform();
        System.out.println(" About Us Video Playing");
        Thread.sleep(5000);

        // Close modal
        WebElement closeBtn = driver.findElement(By.xpath("//div[@id='videoModal']//button[text()='Close']"));
        actions.moveToElement(closeBtn).click().perform();
        System.out.println(" Video Closed");
    }

    @Test(priority = 8)
    public void navigateCarouselAndLogout() throws InterruptedException 
    {
        // Home navigation
        driver.findElement(By.xpath("//a[text()='Home ']")).click();
        Thread.sleep(2000);

        // Carousel navigation
        driver.findElement(By.xpath("//span[@class='carousel-control-prev-icon']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='carousel-control-next-icon']")).click();
        Thread.sleep(2000);

        // Logout
        driver.findElement(By.id("logout2")).click();
        Thread.sleep(2000);
        System.out.println(" Logged Out Successfully");
    }

    @AfterClass
    public void tearDown() 
    {
        driver.quit();
        System.out.println(" Browser Closed");
    }
}
