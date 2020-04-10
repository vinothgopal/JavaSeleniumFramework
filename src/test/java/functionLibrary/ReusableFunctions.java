package functionLibrary;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import FrameWorkFunctions.Log;


public class ReusableFunctions {
	public WebDriver driver;
	Log log=new Log();
	public ReusableFunctions(WebDriver driver){
		this.driver=driver;
	}
	/**
	 * @param value
	 * @param values
	 * @param timeout
	 */
	public void enterValue(By value,String values,long timeout){
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement a=wait.until(ExpectedConditions.visibilityOfElementLocated(value));
		a.sendKeys(values);
		log.ingo("Elements : "+value);
		log.ingo("Value : "+values);
	}
	
	public void clickElement(By value,long timeout){
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement a=wait.until(ExpectedConditions.visibilityOfElementLocated(value));
		a.click();
		log.ingo("Click : "+value);
	}
	/**
	 * @param value
	 * @param values
	 * @param timeout
	 */
	public void dropDownSelectValue(By value,String values,long timeout){
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement a=wait.until(ExpectedConditions.visibilityOfElementLocated(value));
		Select sct = new Select(a);
		sct.selectByVisibleText(values);
		
		
	}
	public void dropDownSelectValue(WebElement ele,String values,long timeout){
		Select sct = new Select(ele);
		sct.selectByVisibleText(values);
		
		
	}
	public void moveToElement(By ele){
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(ele));
		
		
	}
	public String getText(By ele){
		return driver.findElement(ele).getText();
		
	}

}
