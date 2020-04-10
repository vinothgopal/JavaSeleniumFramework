package pom;

import org.openqa.selenium.By;

public class RegistrationObj {

	public static By firstName = By.xpath("//input[@name='firstName']");
	public static By value = By.xpath("//select[@name='country']");
	public static By lastName = By.name("lastName");
	public static By phone = By.xpath("//input[@name='phone']");
	public static By userName = By.xpath("//input[@name='userName']");
	public static By address = By.xpath("//input[@name='address1']");
	public static By city = By.xpath("//input[@name='city']");
	public static By state = By.xpath("//input[@name='state']");
	public static By postalCode = By.xpath("//input[@name='postalCode']");
	public static By email = By.xpath("//input[@name='email']");
	public static By password = By.xpath("//input[@name='password']");
	public static By confirmPass = By.xpath("//input[@name='confirmPassword']");
	public static By sumbit_Btn = By.xpath("//input[@name='submit']");
	public static By dropDown=By.xpath("//select[@name='country']");
	public static By registerLink=By.xpath("//a[text()='REGISTER']");

}
