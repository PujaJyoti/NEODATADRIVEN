package testsuite;



import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import base.TestBase;
import junit.framework.Assert;
import utils.TestUtils;
@RunWith(Parameterized.class)
public class LoginTestCase extends TestBase{
	String usernamedata;
	String passwordata;
	String typeofdata;
	public LoginTestCase(String uname,String pwd,String typedata){
		usernamedata=uname;
		passwordata=pwd;
		typeofdata=typedata;
	}

	@Before
	public void setup() throws IOException{
		doInitilization();
		boolean executablecondition= TestUtils.isSkip("LoginTestCase");
		if(executablecondition==false){
			Assert.assertTrue(false);
		}
	}
	@Test
	public void verifyLoginTest() throws IOException{
		driver.get(configprop.getProperty("url"));
		TestUtils.doLogin(usernamedata, passwordata);
		if(isloggedin==false && typeofdata.equals("P")){
			TestUtils.takescreenshot("LoginFailure1");
			System.out.println("Login is not Success for Valid Data hence Test Case is Failed ");
		}
		else if(isloggedin==true && typeofdata.equals("N")){
			TestUtils.takescreenshot("LoginFailurewith2");
			System.out.println("Login is Success for Invalid Data hence Testcase is Failed ");
		}
		else if(isloggedin==true && typeofdata.equals("P")){
			TestUtils.takescreenshot("LoginFailure3s");
			System.out.println("Login is Success for valid Data hence Testcase is Passed ");
		}
		else if(isloggedin==false && typeofdata.equals("N")){
			TestUtils.takescreenshot("LoginFailure4");
			System.out.println("Login is not Success for Invalid Data hence Testcase is Passed ");
		}
	}


	@Parameters
	public static Collection<String[]> getdata()

	{
		String testdata[][] = TestUtils.getdata("Logins");


		return Arrays.asList(testdata);
}
}
