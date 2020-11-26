package finalProjectPkg;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({FinalProj_Test.class})
@SelectPackages("finalProjectPkg")
public class JunitSuiteRunnerClass 
{}
