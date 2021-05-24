package testsuite;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import base.TestBase;
import junit.framework.Assert;
import utils.TestUtils;

public class StaffPageTestCase extends TestBase{
	@Before
	public void setup() throws IOException{
		doInitilization();
		boolean executablecondition= TestUtils.isSkip("StaffPageTestCase");
		if(executablecondition==false){
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void checktest() throws IOException{
		driver.get(configprop.getProperty("url"));
		TestUtils.doLogin("puja.singh@neointelligence.com.au", "Pass@1234$");
		TestUtils.takescreenshot("InvalidForgotEmailTextBoxTestFailure");
	}
}
