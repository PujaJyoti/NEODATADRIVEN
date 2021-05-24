package testsuite;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import utils.TestUtils;

public class ForgotPageTestCase extends TestBase {

	@Before
	public void setup() throws IOException{
		doInitilization();
		boolean executablecondition= TestUtils.isSkip("ForgotPageTestCase");
		if(executablecondition==false){
			Assert.assertTrue(false);
		}
	}
	@Test
	public void verifyForgotLinkTest() throws IOException{
		driver.get(configprop.getProperty("url"));
		WebElement forgot=getObject("forgot");
		forgot.click();
		String actualtitle=driver.getTitle();
		String expectedtitle="Forgot your password? - Neo Intel Managment System";
		Assert.assertEquals(expectedtitle, actualtitle);
		TestUtils.takescreenshot("ForgotLinkFailure");
	}
	@Test
	public void verifyForgotEmailTextBoxTest() throws IOException{
		driver.get(configprop.getProperty("url"));
		WebElement forgot=getObject("forgot");
		forgot.click();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Email']")));
		WebElement forgotemailtextbox=getObject("forgotemailtextbox");
		forgotemailtextbox.sendKeys("puja.singh@neointelligence.com.au");
		WebElement forgotsendemail=getObject("forgotsendemail");
		forgotsendemail.click();
		String actualtitle=driver.getTitle();
		System.out.println(actualtitle);
		String expectedtitle="Forgot Password Confirmation - Neo Intel Managment System";
		Assert.assertEquals(expectedtitle, actualtitle);
		TestUtils.takescreenshot("ForgotEmailTextBoxTestFailure");
	}
	@Test
	public void verifyEmptyForgotEmailTextBoxTest() throws IOException{
		driver.get(configprop.getProperty("url"));
		WebElement forgot=getObject("forgot");
		forgot.click();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));
		WebElement forgotsendemail=getObject("forgotsendemail");
		forgotsendemail.click();
		if(getObject("forgotemailtexterr").isDisplayed()){
			System.out.println(getObject("forgotemailtexterr").getText());
		}
		else{
			System.out.println("EmailID  is entered");
		}
		TestUtils.takescreenshot("EmptyForgotEmailTextBoxTestFailure");
	}
	@Test
	public void verifyInvalidForgotEmailTextBoxTest() throws IOException{
		driver.get(configprop.getProperty("url"));
		WebElement forgot=getObject("forgot");
		forgot.click();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Email']")));
		WebElement forgotemailtextbox=getObject("forgotemailtextbox");
		forgotemailtextbox.sendKeys("puja.singh@neo.com.au");
		WebElement forgotsendemail=getObject("forgotsendemail");
		forgotsendemail.click();
		if(getObject("forgotemailinvalid").isDisplayed()){
			System.out.println(getObject("forgotemailinvalid").getText());
		}
		else{
			System.out.println("EmailID entered is valid");
		}
		TestUtils.takescreenshot("InvalidForgotEmailTextBoxTestFailure");
	}
}
