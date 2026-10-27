package net.hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.utility_class.BaseClass;

public class HooksClass extends BaseClass {
	
	@Before
	public static void start() {
		BaseClass.browserLaunch();
		driver.manage().window().maximize();	
	}
	
	@After
	public void tear(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			String screenShotpath = screenShot(driver, scenario.getName());
		    byte[] screenShot = Files.readAllBytes(new File(screenShotpath).toPath());
			scenario.attach(screenShot, "image/png", scenario.getName());
		}
		if(driver != null) {
			driver.quit();
			}
	}

}
