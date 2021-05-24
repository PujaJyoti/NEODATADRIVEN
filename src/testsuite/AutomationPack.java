package testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ForgotPageTestCase.class, LoginTestCase.class, RememberMePageTestCase.class,StaffPageTestCase.class })
public class AutomationPack {

}
