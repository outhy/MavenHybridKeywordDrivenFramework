package config;


import java.util.concurrent.TimeUnit;

import static executionEngine.DriverScript.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import executionEngine.DriverScript;
import utility.Log;



public class ActionKeywords {
	
		public static WebDriver driver;
		static WebElement mainElement;
		public static void openBrowser(String object,String data){		
			Log.info("Opening Browser");
			try{				
				if(data.equals("Chrome")){
					
					
//					FirefoxOptions options = new FirefoxOptions();
//		           options.setBinary("C:\\Program Files\\Firefox Developer Edition\\firefox.exe"); 
//		           DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//		           capabilities.setCapability("moz:firefoxOptions", options);
		           //set more capabilities as per your requirements
		
					//String baseUrl = "http://demo.guru99.com/selenium/guru99home/";
				    String driverPath = "C:\\Users\\omahraz\\Desktop\\SOGETI\\chromedriver_win32/";
				   
				        System.out.println("launching browser"); 
				        System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
				        
				        //driver.get(baseUrl);

				    driver = new ChromeDriver();
					Log.info("Chrome browser started");				
					}
				else if(data.equals("IE")){
					//Dummy Code, Implement you own code
					driver=new InternetExplorerDriver();
					Log.info("IE browser started");
					}
				else if(data.equals("Mozilla")){
					//Dummy Code, Implement you own code
					driver=new ChromeDriver();
					Log.info("Mozilla browser started");
					}
				
				int implicitWaitTime=(10);
				driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
			}catch (Exception e){
				Log.info("Not able to open the Browser --- " + e.getMessage());
				DriverScript.bResult = false;
			}
		}
	
	public static void navigate(String object, String data){
		try{
			Log.info("Navigating to URL");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Constants.URL);
		}catch(Exception e){
			Log.info("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
			}
		}
	
	public static void click(String object, String data){
		try{
			Log.info("Clicking on Webelement "+ object);
			driver.findElement(By.xpath(OR.getProperty(object))).click();
		 }catch(Exception e){
 			Log.error("Not able to click --- " + e.getMessage());
 			DriverScript.bResult = false;
         	}
		}
	
	public static void input(String object, String data){
		try{
			Log.info("Entering the text in " + object);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
		 }catch(Exception e){
			 Log.error("Not able to Enter UserName --- " + e.getMessage());
			 DriverScript.bResult = false;
		 	}
		}
	

	public static void waitFor(String object, String data) throws Exception{
		try{
			Log.info("Wait for 5 seconds");
			Thread.sleep(5000);
		 }catch(Exception e){
			 Log.error("Not able to Wait --- " + e.getMessage());
			 DriverScript.bResult = false;
         	}
		}
	
	public static void Product_Type(String object, String data) {
		
		//mainElement = driver.findElement(By.linkText("Product Category"));
		try{
//			Actions actions = new Actions(driver);
//			Log.info("Searching for Product Category Link ");
//			mainElement = driver.findElement(By.linkText("Product Category"));
//			actions.moveToElement(mainElement);
//			WebElement subMenu = driver.findElement(By.linkText("Accessories"));
//			actions.moveToElement(subMenu);
//			actions.click().build().perform();
			WebElement element = driver.findElement(By.linkText("Product Category"));
			 
	        Actions action = new Actions(driver);
	 
	action.moveToElement(element).moveToElement(driver.findElement(By.linkText("iPads"))).build().perform();
	Log.info("link found with success");
		 }catch(Exception e){
			 Log.error("Not able to found the link");
			 DriverScript.bResult = false;
		 	}
		
			    			
	}
    
	


	public static void closeBrowser(String object, String data){
		try{
			Log.info("Closing the browser");
			driver.close();;
		 }catch(Exception e){
			 Log.error("Not able to Close the Browser --- " + e.getMessage());
			 DriverScript.bResult = false;
         	}
		}

	}