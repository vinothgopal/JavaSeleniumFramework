package TestNGTestCases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import FrameWorkFunctions.BaseClass;
import FrameWorkFunctions.ExcelReading;
import FrameWorkFunctions.Log;
import functionLibrary.ReusableFunctions;
import pom.RegistrationObj;

public class SampleTC extends BaseClass {
	public WebDriver driver;
	public ReusableFunctions re;
	public ExcelReading ex;
	public String testCaseName;
	String filepath;
	public Log log;
	@BeforeTest
	public void setUp() throws IOException {
		
		driver = initialiseDriver();
		re = new ReusableFunctions(driver);
		filepath = prop.getProperty("filepath");
		log=new Log();
		driver.get(prop.getProperty("url"));
		log.ingo(prop.getProperty("url"));
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		testCaseName = method.getName();
		log.debug(testCaseName);
		ex = new ExcelReading(filepath, testCaseName);
		log.fatal(filepath);
	}

	@Test
	public void TestCase1() throws Exception {
		// ex.getData("Data", "UID");
		//loggerClass.debug("Sree");
		log.error("Sample");
		re.clickElement(RegistrationObj.registerLink, 10);
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='country']")));
		// driver.findElement(RegistrationObj.userName).sendKeys("vinoth");
		re.enterValue(RegistrationObj.firstName, ex.getData("Data", "firstName"), 10);

		re.enterValue(RegistrationObj.lastName, ex.getData("Data", "lastName"), 10);

		re.enterValue(RegistrationObj.phone, ex.getData("Data", "phone"), 10);

		re.enterValue(RegistrationObj.userName, ex.getData("Data", "userName"), 10);

		re.enterValue(RegistrationObj.address, ex.getData("Data", "address"), 10);

		re.enterValue(RegistrationObj.city, ex.getData("Data", "city"), 10);

		re.enterValue(RegistrationObj.state, ex.getData("Data", "state"), 10);

		re.enterValue(RegistrationObj.postalCode, ex.getData("Data", "postalCode"), 10);

		re.dropDownSelectValue(RegistrationObj.dropDown, ex.getData("Data", "dropDown"), 10);

		re.enterValue(RegistrationObj.email, ex.getData("Data", "email"), 10);

		re.enterValue(RegistrationObj.password, ex.getData("Data", "password"), 10);

		re.enterValue(RegistrationObj.confirmPass, ex.getData("Data", "confirmPass"), 10);
		// submit button click
		re.clickElement(RegistrationObj.sumbit_Btn, 10);

	}

	/**
	 * 
	 */
	@AfterTest
	public void tearDown() {
		log.warn("Close");
		driver.close();
	}
}
