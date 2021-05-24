package utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import base.TestBase;
import base.Xls_Reader;

public class TestUtils extends TestBase {

	public static void doLogin(String usernamedata, String passwordata) {
		WebElement username = getObject("username");
		username.sendKeys(usernamedata);
		WebElement password = getObject("password");
		password.sendKeys(passwordata);
		WebElement login = getObject("login");
		login.click();
		List<WebElement> home=driver.findElements(By.xpath(objrepoprop.getProperty("home")));
	     if(home.size()!=0){
	    	 isloggedin=true;
	     }
	     else{
			   isloggedin=false;
		   }
	}

	public static void doLoginRememberme(String usernamedata, String passwordata) {
		WebElement username = getObject("username");
		username.sendKeys(usernamedata);
		WebElement password = getObject("password");
		password.sendKeys(passwordata);
		WebElement rememberme = getObject("rememeber");
		rememberme.click();
		WebElement login = getObject("login");
		login.click();
	}
	public static boolean isSkip(String inputtestcase){
		//System.out.println(xlsread.getRowCount("suites"));
		//System.out.println(xlsread.getColumnCount("suites"));
		//System.out.println(xlsread.getCellData("suites", 1, 3));
		//String inputtestcase="LoginTestCase";
		for(int rownum=2;rownum<=xlsread.getRowCount("suites");rownum++){
			if(inputtestcase.equals(xlsread.getCellData("suites",0,rownum))){
				if(xlsread.getCellData("suites",2,rownum).equals("Y")){
					//System.out.println("Run the test case");
					return true;
				}
				else{
					//System.out.println("Skip the test case");
					return false;
				}
			}	
			}
		return false;
		}
	
	public static String[][] getdata(String inputsheetname){
		xlsread=new Xls_Reader("/Users/pujakumari/Documents/workspace/HandlingDataDriven_NEO/src/inputs/TestSuiteNeo.xlsx");
		System.out.println("Sheet name is" + inputsheetname);
		int rowcount=xlsread.getRowCount(inputsheetname);
		System.out.println("No.of rows is" + rowcount);
		int columncount=xlsread.getColumnCount(inputsheetname);
		System.out.println("No.of coloumn is" + columncount);
		String[][]data=new String[rowcount-1][columncount];
		for(int rownumber=2;rownumber<=rowcount;rownumber++){
			for(int coloumnnumber=0;coloumnnumber<columncount;coloumnnumber++){
			data[rownumber-2][coloumnnumber]=xlsread.getCellData(inputsheetname, coloumnnumber, rownumber);
			}
		}
		return data;
	}
	public static void takescreenshot(String Filename) throws IOException{
		File screenshoot=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshoot, new File("/Users/pujakumari/Documents/workspace/HandlingDataDriven_NEO/src/outputs/"+Filename+".png"));
		
		}
}