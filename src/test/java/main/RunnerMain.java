package main;

import java.util.List;

import org.testng.TestNG;
import org.testng.collections.Lists;

import demo_Base.PageBase;
import demo_Utilfirm.Demo_Utils;


public class RunnerMain  extends PageBase{
	static TestNG testng;

	public static void main(String args[]) throws InterruptedException {

		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add("run/testng.xml");
		testng.setTestSuites(suites);
		testng.run();
		Thread.sleep(5000);
		String emailEnabled = config.getProperty("emailEnabled");
		if (emailEnabled.equalsIgnoreCase("yes")) {
			Demo_Utils.zip_Filed();
			Demo_Utils.email_Report();
			System.out.println("test has been executed");
		}
		else {
			System.out.println("email is not enabled");
		}

}

}
