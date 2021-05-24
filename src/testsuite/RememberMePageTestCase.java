package testsuite;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebElement;

import base.TestBase;
import junit.framework.Assert;
import utils.TestUtils;
@RunWith(Parameterized.class)
public class RememberMePageTestCase extends TestBase{
	
		String usernamedata;
		String passwordata;
		String typeofdata;
		public RememberMePageTestCase(String uname,String pwd,String typedata){
			usernamedata=uname;
			passwordata=pwd;
			typeofdata=typedata;
		}
	@Before
	public void setup() throws IOException{
		doInitilization();
		boolean executablecondition= TestUtils.isSkip("RememberMePageTestCase");
		if(executablecondition==false){
			Assert.assertTrue(false);
		}
	}
	@Test
	public void verifyRememberMeTest() throws IOException{
		driver.get(configprop.getProperty("url"));
		TestUtils.doLoginRememberme(usernamedata, passwordata);
			TestUtils.takescreenshot("LoginRememberMeFailure");
}
	
	@Parameters
	public static Collection<String[]> getdata()

	{
		String testdata[][] = TestUtils.getdata("Remember");


		return Arrays.asList(testdata);
}
}