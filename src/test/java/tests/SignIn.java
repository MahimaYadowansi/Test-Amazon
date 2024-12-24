package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class SignIn extends BaseTest {
	@Test
	public void signin()
	{
		WebElement account=driver.findElement(By.xpath(or.getProperty("accounts")));
		account.click();
		logger.info("Clicked on accounts");
		WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("email"))));
		email.click();
		email.sendKeys("mahimayadowansi@gmail.com");
		logger.info("Email is entered");

		logger.info("Email is entered");
		WebElement continuebtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("continue_btn")));
		continuebtn.click();
		logger.info("Clicked on continuebtn");
		WebElement password=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("password")));
		password.sendKeys("Mahima2708@");
		logger.info("Password is enetered");
		WebElement signinbtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("signin_btn")));
		signinbtn.click();
		logger.info("SignIn btn is clicked");
		WebElement accountname=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("accountname")));
		
		Assert.assertEquals(accountname.getText(),"Hello, Mahima");
		
		
	}

}
