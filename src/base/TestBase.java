package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestBase {
	public static Properties configprop;
	public static Properties objrepoprop;
	public static WebDriver driver;
	public static Boolean isloggedin;
	public static Xls_Reader xlsread;
	
	public  static void doInitilization() throws IOException{
		if(driver==null){
		FileInputStream config=new FileInputStream("/Users/pujakumari/Documents/workspace/HandlingDataDriven_NEO/src/configuration/Config.properties");
		configprop=new Properties();
		configprop.load(config);
		FileInputStream objrepo=new FileInputStream("/Users/pujakumari/Documents/workspace/HandlingDataDriven_NEO/src/configuration/ObjectRepositories.properties");
		objrepoprop=new Properties();
		objrepoprop.load(objrepo);
		String browserName=configprop.getProperty("browser");
		if(browserName.equals("chrome")){
			 driver=new ChromeDriver();
		}
		else if(browserName.equals("IE")){
			 driver=new InternetExplorerDriver();
		}
		else if(browserName.equals("FireFox")){
			 driver=new FirefoxDriver();
		}
		else if(browserName.equals("Safari")){
		 driver=new SafariDriver();
		}
		 xlsread=new Xls_Reader("/Users/pujakumari/Documents/workspace/HandlingDataDriven_NEO/src/inputs/TestSuiteNeo.xlsx");
	}
	}
	public static WebElement getObject(String objValue ){
		return 	driver.findElement(By.xpath(objrepoprop.getProperty(objValue)));
		
	}
	
}
