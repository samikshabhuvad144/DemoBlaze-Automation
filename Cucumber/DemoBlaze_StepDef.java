package BDD;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoBlaze_StepDef 
{
	    WebDriver driver;
	    WebDriverWait wait;
	    Actions actions;

	    @Given("User launches the DemoBlaze website")
	    public void user_launches_the_website() 
	    {
	    	driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        actions = new Actions(driver);
	        driver.get("https://www.demoblaze.com/");
	        System.out.println(" Website launched successfully");
	    }

	    @When("User logs into the website")
	    public void user_logs_into_the_website() throws InterruptedException {
	        driver.findElement(By.id("login2")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.id("loginusername")).sendKeys("wrong");
	        driver.findElement(By.id("loginpassword")).sendKeys("wrong");
	        driver.findElement(By.xpath("//button[text()='Log in']")).click();
	        Thread.sleep(3000);
	        System.out.println(" User logged in");
	    }

	    @Then("User adds products from all categories to the cart")
	    public void add_products_from_all_categories() throws InterruptedException {
	        // Phones
	        driver.findElement(By.linkText("Phones")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//a[text()='Samsung galaxy s6']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.linkText("Add to cart")).click();
	        wait.until(ExpectedConditions.alertIsPresent());
	        driver.switchTo().alert().accept();
	        driver.navigate().back();
	        driver.navigate().back();

	        // Laptops
	        driver.findElement(By.linkText("Laptops")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//a[text()='Sony vaio i5']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.linkText("Add to cart")).click();
	        wait.until(ExpectedConditions.alertIsPresent());
	        driver.switchTo().alert().accept();
	        driver.navigate().back();
	        driver.navigate().back();

	        // Monitors
	        driver.findElement(By.linkText("Monitors")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//a[text()='Apple monitor 24']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.linkText("Add to cart")).click();
	        wait.until(ExpectedConditions.alertIsPresent());
	        driver.switchTo().alert().accept();
	        driver.navigate().back();
	        driver.navigate().back();

	        System.out.println(" Products added to cart successfully");
	    }

	    @And("User deletes one product and places the order")
	    public void user_deletes_one_product_and_places_order() throws InterruptedException {
	        driver.findElement(By.id("cartur")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("(//a[text()='Delete'])[1]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	        Thread.sleep(2000);
	        System.out.println(" Product deleted and placing order...");
	    }

	    @And("User fills order details and purchases")
	    public void user_fills_order_details_and_purchases() throws InterruptedException {
	        driver.findElement(By.id("name")).sendKeys("Samiksha");
	        driver.findElement(By.id("country")).sendKeys("India");
	        driver.findElement(By.id("city")).sendKeys("Pusne");
	        driver.findElement(By.id("card")).sendKeys("123456789");
	        driver.findElement(By.id("month")).sendKeys("10");
	        driver.findElement(By.id("year")).sendKeys("2025");
	        driver.findElement(By.xpath("//button[text()='Purchase']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//button[text()='OK']")).click();
	        System.out.println(" Order placed successfully");
	    }

	    @Then("User opens contact form and sends a message")
	    public void user_opens_contact_form_and_sends_message() throws InterruptedException {
	        driver.findElement(By.xpath("//a[text()='Contact']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.id("recipient-email")).sendKeys("samu@gmail.com");
	        driver.findElement(By.id("recipient-name")).sendKeys("Samiksha");
	        driver.findElement(By.id("message-text")).sendKeys("Automation message from Cucumber Test");
	        driver.findElement(By.xpath("//button[text()='Send message']")).click();
	        wait.until(ExpectedConditions.alertIsPresent());
	        driver.switchTo().alert().accept();
	        System.out.println(" Contact form submitted");
	    }

	    @And("User plays and closes the About Us video")
	    public void user_plays_and_closes_about_us_video() throws InterruptedException 
	    {
	        WebElement aboutUs = driver.findElement(By.xpath("//a[text()='About us']"));
	        actions.moveToElement(aboutUs).click().perform();

	        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("videoModal")));
	        WebElement playButton = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//div[@id='videoModal']//button[@title='Play Video']")));
	        actions.moveToElement(playButton).click().perform();
	        System.out.println(" Video started playing...");
	        Thread.sleep(5000);
	        WebElement closeButton = driver.findElement(By.xpath("//div[@id='videoModal']//button[text()='Close']"));
	        actions.moveToElement(closeButton).click().perform();
	        System.out.println(" Video closed successfully");
	    }

	    @Then("User navigates through the carousel and logs out")
	    public void user_navigates_and_logs_out() throws InterruptedException {
	        driver.findElement(By.xpath("//a[text()='Home ']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//span[@class='carousel-control-prev-icon']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//span[@class='carousel-control-next-icon']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.id("logout2")).click();
	        System.out.println(" User logged out successfully");
	    }

	    @And("User closes the browser")
	    public void user_closes_the_browser() 
	    {
	        driver.quit();
	        System.out.println(" Browser closed. Test completed.");
	    }

}
