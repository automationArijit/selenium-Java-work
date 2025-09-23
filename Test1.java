package product;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		
		String key="webdriver.chrome.driver";
		String value="./software/chromedriver.exe";
		
		System.setProperty(key, value);
		
		//=============Login process===========
		WebDriver driver= new ChromeDriver();
		driver.get("https://sandbox.era.raileurope.com/sign-in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement cookies = driver.findElement(By.xpath("//button[text()='Accept All Cookies']"));
				
		try {
		
			cookies.click();
			System.out.println("cookies accepted!!");
			
		} catch (Exception e) {
			
			System.out.println("cookies rejected!!");
		}
		
				
		try {
			
			WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
			WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
			WebElement signin = driver.findElement(By.xpath("//button[text()=' Sign in ' and @class='signIn-button']"));
			
			username.sendKeys("etroadec");
			password.sendKeys("P@ssword01");
			signin.click();
			System.out.println("Login sucessfull by etroadec user!! ");
			
		} catch (Exception e) {
			System.out.println("Login failed!! ");
		}
		
		//=============Login process==========
		
		//===Search====
		Thread.sleep(12000);
		WebElement form = driver.findElement(By.xpath("(//div[@class='era-formTextInput']/input)[1]"));
		form.sendKeys("paris");
		Thread.sleep(2000);
		form.sendKeys(Keys.ENTER,Keys.TAB,Keys.TAB);
		Thread.sleep(1000);
		WebElement to = driver.findElement(By.xpath("(//div[@class='era-formTextInput']/input)[2]"));
		to.sendKeys("lille");
		Thread.sleep(1000);
		to.sendKeys(Keys.ENTER,Keys.TAB);
		
		//WebElement calender = driver.findElement(By.xpath("//*[@id=\"tabContent-tickets\"]/era-point-to-point-search-form/section/form/div[1]/era-date-selector-input-rf/div/button/era-icon"));
		//calender.click();
			
				
	}

}
