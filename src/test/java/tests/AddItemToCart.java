package tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.BaseTest;

public class AddItemToCart extends BaseTest {
	@Test(groups = {"smoke", "sanity", "regression"})
	public void searchItem()
	{
		WebElement search=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("search_btn"))));
		search.sendKeys("Apple 16 pro");
		
	}
	@Test(groups = {"sanity", "regression"})
	public void applyFilter()
	{
		WebElement memory=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(or.getProperty("memory_storage"))));
		memory.click();
		WebElement category=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(or.getProperty("category"))));
		category.click();
		
		WebElement Cellular_Technology=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(or.getProperty("category"))));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", Cellular_Technology);
		 Cellular_Technology.click();
		 
		 WebElement Battery_Capacity =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(or.getProperty("Battery_Capacity "))));
			
			 js.executeScript("arguments[0].scrollIntoView(true);", Battery_Capacity );
			 Battery_Capacity .click();
		 
		
	}
	
	@Test(groups = {"regression"})
	public void addItem()
	{
		String mainPage = driver.getWindowHandle(); System.out.println("main page" + mainPage);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement mobile=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(or.getProperty("mobile"))));
		js.executeScript("arguments[0].scrollIntoView(true);", mobile );
		mobile .click();
		Set<String> allPages = driver.getWindowHandles();
		 for (String handle : allPages) {
	            if (!handle.equals(mainPage)) {
	                driver.switchTo().window(handle);
	                break;
	            }
	        }
		 
	        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("add_to_cart_btn"))));
	        js.executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
	        addToCartBtn.click();
	        System.out.println("Item added to cart in the new tab.");

	        // Close the new tab and switch back to the main page
	        driver.close();
	        driver.switchTo().window(mainPage);

		 
	}
	

}
