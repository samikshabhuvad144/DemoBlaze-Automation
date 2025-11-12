package Project;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class datadriven_DemoBlaze
{
	public static void main(String[] args) throws Exception {

        //  Browser Setup 
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions action = new Actions(driver);

        //Open Website
        driver.get("https://www.demoblaze.com/");

        // Read Excel Data 
        File f = new File("InputData.xls");  // Ensure file path is correct
        FileInputStream fis = new FileInputStream(f);
        HSSFWorkbook book = new HSSFWorkbook(fis);
        HSSFSheet sh = book.getSheet("TestData");

        String Username = sh.getRow(1).getCell(0).toString();
        String Password = sh.getRow(1).getCell(1).toString();
        String name = sh.getRow(1).getCell(2).toString();
        String country = sh.getRow(1).getCell(3).toString();
        String city = sh.getRow(1).getCell(4).toString();
        String card = sh.getRow(1).getCell(5).toString();
        String month = sh.getRow(1).getCell(6).toString();
        String year = sh.getRow(1).getCell(7).toString();

        // Login
        driver.findElement(By.id("login2")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        driver.findElement(By.id("loginusername")).sendKeys(Username);
        driver.findElement(By.id("loginpassword")).sendKeys(Password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(2500);

        //Add Products 
        String[] categories = { "Phones", "Laptops", "Monitors" };
        String[] products = { "Samsung galaxy s6", "Sony vaio i5", "Apple monitor 24" };

        for (int i = 0; i < categories.length; i++) 
        {
            driver.findElement(By.linkText(categories[i])).click();
            Thread.sleep(1500);
            driver.findElement(By.linkText(products[i])).click();
            Thread.sleep(1500);
            driver.findElement(By.linkText("Add to cart")).click();
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            Thread.sleep(1500);
            driver.navigate().back();
            driver.navigate().back();
        }

        //  Cart & Order 
        driver.findElement(By.id("cartur")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[text()='Delete'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));

        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("country")).sendKeys(country);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("card")).sendKeys(card);
        driver.findElement(By.id("month")).sendKeys(month);
        driver.findElement(By.id("year")).sendKeys(year);
        driver.findElement(By.xpath("//button[text()='Purchase']")).click();
        Thread.sleep(2000);

        //   Confirm Purchase
        driver.findElement(By.xpath("//button[text()='OK']")).click();
        Thread.sleep(2000);
        System.out.println("order confirm ");


        // Contact
        driver.findElement(By.xpath("//a[text()='Contact']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("recipient-email")));
        driver.findElement(By.id("recipient-email")).sendKeys("samu@gmail.com");
        driver.findElement(By.id("recipient-name")).sendKeys("Samiksha");
        driver.findElement(By.id("message-text")).sendKeys("Hiiii!!.");
        driver.findElement(By.xpath("//button[text()='Send message']")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        //  About Us
        driver.findElement(By.xpath("//a[text()='About us']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("videoModal")));
        WebElement closeBtn = driver.findElement(By.xpath("//div[@id='videoModal']//button[text()='Close']"));
        closeBtn.click();

        
        driver.findElement(By.id("logout2")).click();
        Thread.sleep(2000);
        System.out.println("logout successfully ");
        driver.close();

        System.out.println(" DemoBlaze Data-Driven Automation Completed Successfully!");
    }

	

}
