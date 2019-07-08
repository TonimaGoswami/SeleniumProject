package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import basic.Login;

@RunWith(Suite.class)
@SuiteClasses({ BasicSuite.class, Login.class })
public class SweetSuite {

}
