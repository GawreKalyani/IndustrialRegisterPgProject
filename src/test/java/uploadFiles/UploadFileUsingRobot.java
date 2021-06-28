package uploadFiles;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UploadFileUsingRobot {
	WebDriver driver;
@Test 
public void test() throws Exception {
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	 driver=new ChromeDriver();
	driver.get("http://demo.automationtesting.in/Register.html");
	Thread.sleep(3000);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	
	   //choose a File button
	driver.findElement(By.xpath("//div[2][@class='col-xs-6 col-xs-offset-6']")).click();

	Robot robot=new Robot();
	
	Thread.sleep(3000);
	
	//below 2 line s perform copy action (Clt+c)(file--properties--path)
	StringSelection s=new StringSelection("C:\\Users\\rajat\\Desktop\\userstory.txt");
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
	
	Thread.sleep(3000);
	
	//below 2 lines for paste(Clt+v)
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);
	
	robot.keyRelease(KeyEvent.VK_CONTROL);
	robot.keyRelease(KeyEvent.VK_V);
	Thread.sleep(3000);
	//Enter button to click and then release
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	
	
}
}
