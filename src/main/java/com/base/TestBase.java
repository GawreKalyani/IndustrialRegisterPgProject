package com.base;

import java.io.FileInputStream;
import java.util.Properties;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
public static WebDriver driver;
Properties prop;

public static Logger log = Logger.getLogger(TestBase.class);
public WebDriver initialization() throws Exception {
	
	prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
	//System.getProperty("user.dir") + "/src/main/resources/config.properties");
			
	prop.load(fis);
	// String browserName=System.getProperty("browser");
	String browserName = prop.getProperty("browser");
	System.out.println(browserName);

	if (browserName.equals("chrome")) {
		
		log.info("initializing browser");
	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		
		log.info("chrome browser opened");
		driver = new ChromeDriver();
	} 
	else if (browserName.equals("firefox")) {
		log.info("initializing browser");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\geckodriver.exe");
		
		log.info("mozilla firefox browser opened");
		driver = new FirefoxDriver();
	} 
	else if (browserName.equals("IE")) {
		log.info("initializing browser");
		System.setProperty("webdriver.ie.driver", "C:\\Program Files\\IEDriverServer.exe");
		
		log.info("Internet explorer browser opened");
		driver = new InternetExplorerDriver();
	}
	
	log.info("Automation testing application is launched");
	driver.get(prop.getProperty("url"));

	
	log.info("maximizing browser window");
	driver.manage().window().maximize();
	return driver;
}
}
