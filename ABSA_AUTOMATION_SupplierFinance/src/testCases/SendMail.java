package testCases;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

import generalFunctions.Functions;

public class SendMail {

	public static WebDriver driver;
	static ChromeOptions chromeOptions = new ChromeOptions();
	//static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");
	public static String driverPath = "C:\\Users\\abdv220\\workspace\\all External jars\\";	
	//public static WebDriver driver;
	static Screen s= new Screen();	
	public static String sikulImages="C:\\Users\\abdv220\\git\\ABSA_FrameWork_Selinium\\ABSA_AutomationFrameWork_CIB\\SikuliImages";
	public static String Header = "ABSA-CIB CORPORATE: SUPPLIER FINANCE";
	public static String Footer = "ABSA BANK";
	public static String TemlatePath= "C:\\Users\\abdv220\\Deepak_ABSA_Autamation_Framework\\Test_data\\Template\\TestResultTemplate.docx";
	public static String TesDocPath= "C:\\Users\\abdv220\\Deepak_ABSA_Autamation_Framework\\Test_Results\\";
	public static String ImgLocation= "C:\\Users\\abdv220\\Deepak_ABSA_Autamation_Framework\\Test_Results\\temp\\";
	public static String excelFilePath ="C:\\Users\\abdv220\\Deepak_ABSA_Autamation_Framework\\Test_Results\\tempData.xlsx";
	public static String BankAccount=null;
	public static Date date = new Date();  
	public static  SimpleDateFormat formatter1 = new SimpleDateFormat("dd hh:mm:ss");  
	public static  String strDate1= formatter1.format(date);   
	public static int Stepno=1;//Important value
	public static int m=1;
	
    public static void main(String[]args) throws Exception {

    
    	Functions.AppUrl= Functions.ReadFromExcel(Functions.Environment, 0, 1);
    	
    	System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		  chromeOptions.addArguments("--start-maximized");
		  driver = new ChromeDriver(chromeOptions); 
		
	  //Test Start
		  Functions.ReportStepName[Stepno]= "Get Url";
          driver.get(Functions.AppUrl);
     
	        
	      driver.findElement(By.id("username")).clear();
	      driver.findElement(By.id("username")).sendKeys("abdv220");
	      driver.findElement(By.id("password")).clear();
	      driver.findElement(By.id("password")).sendKeys("Deepak@123");	      
	      driver.findElement(By.id("kc-login")).click();	      
	      Functions.robo(Stepno);
	      Functions.ReportStepResult[Stepno]="PASS";
	             
	      Functions.Wait(3000);	      
	      Functions.Strtype("abdv220");
	      Functions.Inttype(KeyEvent.VK_TAB);	    
	      Functions.UPStrtype("T");
	      Functions.Strtype("he");
	      Functions.Strtype("1");
	      Functions.ATtype();	   
	      Functions.Strtype("123");	           
	      Functions.Inttype(KeyEvent.VK_ENTER);  
	      Functions.Wait(5000);	      
	  
    	
    	
//    	   int s= Functions.GetTradeLoanReconcileTask();
//	    	
//	    	
//	    	for(int z=1;z<=s;z++)
//	    		
//	    	{
	    		
	         WebDriverWait wait = new WebDriverWait(driver, 60); 
	    	// System.out.println(Functions.TrReconTask[z]);	    	
	         WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/nav/div/div[2]/ul/li[3]/a")));
		     element1.click();
		     Functions.Wait(5000);
		     
		    
		     Functions.Inttype(KeyEvent.VK_ENTER);
		   	
		     Functions.Wait(5000);		
		     driver.navigate().refresh();
		     
//		     WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div/div/div[1]/div/div[1]/label/input")));
//		     element2.click();
		     
		     
		     
//		     try {
//					Functions.Strtype(Functions.TrReconTask[z]);
//				} catch (AWTException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		    
//		     WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div/div/div[1]/div/table/tbody/tr/td[6]/a")));
//		     element3.click();		     
//		     
//		     WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div[5]/button[2]")));
//		     element4.click();		     
//		     
//		     WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div[4]/button[2]")));
//		     element5.click();
//		     
		 
		     
	 	     
	    	}
	     
    }
