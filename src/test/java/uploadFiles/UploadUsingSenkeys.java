package uploadFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UploadUsingSenkeys {
	WebDriver driver;
	
	@Test
	public void upload() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://blueimp.github.io/jQuery-File-Upload/index.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\rajat\\Downloads\\download.jpg");

driver.findElement(By.xpath("//button[@type='submit']")).click();

}
}