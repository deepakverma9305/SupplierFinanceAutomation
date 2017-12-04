package testCases;

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
import java.awt.event.KeyEvent;
import generalFunctions.Functions;

public class ProcessRAO {

	static ChromeOptions chromeOptions = new ChromeOptions();
	//static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");
	public static String driverPath = "C:\\Users\\abdv220\\Documents\\workplace\\";	
	public static WebDriver driver;
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
	
	public static void ProcessRAOFile(String TestName) throws Exception {
	    
		try{ 	
			
			//Clean DB
		      Functions.CleanDB();
		      Functions.DeleteDBWF();
		      //DB Cleaned
		      
		      //Put RAO File
		      Functions.Wait(10000);
		      Functions.PutRAOFilesInserver();
		      
		      //File Put in SERVER
		      

			  //Check File Import Exception
		      
		
			  
			  //End Import Exception Test
		      
		      
		}
	    catch (Exception e) {e.printStackTrace();}
		
		
		String s="";
		
		s= Functions.CheckFileExportException();
		
		if(s.equals(""))
		{
		
		
		      
		      
		      
		   // System.out.println("launching chrome browser");
			  System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			  chromeOptions.addArguments("--start-maximized");
			  driver = new ChromeDriver(chromeOptions); 
			
		  //Test Start
			  
		  
	      driver.get(Functions.AppUrl);
	      Functions.Wait(3000);	
	      
	      Functions.ReportStepName[Stepno]= "Login In SF Application";	      
	      driver.findElement(By.id("username")).clear();
	      driver.findElement(By.id("username")).sendKeys(Functions.userName);
	      driver.findElement(By.id("password")).clear();
	      driver.findElement(By.id("password")).sendKeys(Functions.Password);      
	      driver.findElement(By.id("kc-login")).click();	             
	      Functions.Wait(3000);	      
	      Functions.Strtype("abdv220");
	      Functions.Inttype(KeyEvent.VK_TAB);	    
	      Functions.UPStrtype("P");
	      Functions.Strtype("ower");
	      Functions.ATtype();	   
	      Functions.Strtype("123");	           
	      Functions.Inttype(KeyEvent.VK_ENTER);  
	      Functions.Wait(5000);	      
	  
	      //Report Creation
	      
	    	 WebDriverWait wait = new WebDriverWait(driver, 10); 	    	 
	    	 	     
	    	 Functions.ReportStepName[Stepno]= "Task Created";
		     WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/nav/div/div[2]/ul/li[3]/a")));
		     element1.click();
		     Functions.Wait(5000);
		     Functions.Inttype(KeyEvent.VK_ENTER);		   	
		     Functions.Wait(5000);			     
		     WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div/div/div[1]/div/div[1]/label/input")));
		     element2.click();
		     element2.sendKeys("Confirm");
		     Functions.Wait(2000);	
		      Functions.robo(Stepno);	
		      Functions.ReportStepResult[Stepno]="PASS";
		      Stepno=Stepno+1;
		      
		      Functions.ReportStepName[Stepno]= "Trade Loan Created";		      
		      
		      WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/nav/div/div[2]/ul/li[5]/a")));
			  element3.click();
			  
			  WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div[1]/ul/li[1]/a")));
			  element4.click();
			  Functions.Wait(2000);	
			  Functions.robo(Stepno);	
		      Functions.ReportStepResult[Stepno]="PASS";	    
		      Stepno=Stepno+1;
		      
              Functions.ReportStepName[Stepno]= "Supplier Payment Created";
		      
		      WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div[1]/ul/li[2]/a")));
			  element5.click();
			  Functions.Wait(2000);	
			  Functions.robo(Stepno);	
		      Functions.ReportStepResult[Stepno]="PASS";	    
		      Stepno=Stepno+1;
		      
              Functions.ReportStepName[Stepno]= "Propel Payment Created";
		      
		      WebElement element6 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div[1]/ul/li[3]/a")));
			  element6.click();
			  Functions.Wait(2000);	
			  Functions.robo(Stepno);	
		      Functions.ReportStepResult[Stepno]="PASS";	    
		      Stepno=Stepno+1;
		      
		
	       
		      Stepno=Stepno-1;	
		      Functions.createTestDoc(Stepno, TestName, "PASS");
		 
	}else{System.out.println(s);}


	}


}
