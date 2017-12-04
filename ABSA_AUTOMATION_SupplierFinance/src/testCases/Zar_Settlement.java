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

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import generalFunctions.Functions;


public class Zar_Settlement

{

static ChromeOptions chromeOptions = new ChromeOptions();
//static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");
public static String driverPath = "C:\\Users\\abdv220\\workspace\\all External jars\\";	
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



	
	
	public static void ZAR_Settle(String TestName) throws Exception
	
	{
		
		
		
		
		try{ 	
			//Clean DB
		      Functions.CleanDB();
		      Functions.DeleteDBWF();
		      //DB Cleaned
		      
		      //Put RAO File
		      Functions.Wait(10000);
		      Functions.PutRAOFilesInserver();
		      
		      //File Put in SERVER
		 }
	    catch (Exception e) {e.printStackTrace();}
		      
			 
		try{
		
		
		
        String Exc="";
		
		Exc= Functions.CheckFileExportException();
		
		if(Exc.equals(""))
		{
		
		
		     System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			  chromeOptions.addArguments("--start-maximized");
			  driver = new ChromeDriver(chromeOptions); 
			
		  //Test Start
			  Functions.ReportStepName[Stepno]= "Get Url";
	      driver.get(Functions.AppUrl);
	    
	      Functions.robo(Stepno);	
	      Functions.ReportStepResult[Stepno]="PASS";	    
	      Stepno=Stepno+1;	     
	      Functions.ReportStepName[Stepno]= "Login In SF Application";	      
	      driver.findElement(By.id("username")).clear();
	      driver.findElement(By.id("username")).sendKeys("abdv220");
	      driver.findElement(By.id("password")).clear();
	      driver.findElement(By.id("password")).sendKeys("Deepak@123");	      
	      driver.findElement(By.id("kc-login")).click();	      
	      Functions.robo(Stepno);
	      Functions.ReportStepResult[Stepno]="PASS";
	      Stepno=Stepno+1;	     
	      Functions.ReportStepName[Stepno]= "Login Into DashBoard";	          
	      Functions.Wait(3000);	      
	      Functions.Strtype("abdv220");
	      Functions.Inttype(KeyEvent.VK_TAB);	    
	      Functions.UPStrtype("P");
	      Functions.Strtype("ower");
	   //   Functions.Strtype("1");
	      Functions.ATtype();	   
	      Functions.Strtype("123");	           
	      Functions.Inttype(KeyEvent.VK_ENTER);  
	      Functions.Wait(5000);	      
	      Functions.robo(Stepno);
	      Functions.ReportStepResult[Stepno]="PASS";	
	      Stepno=Stepno+1;	
	      //Report Creation
	       
	     int i = Functions.GetTradeLoanCountAndRefNum();
	     
	     for(int j=1;j<=i;j++)
	     
	     {
	    	 
	    	 WebDriverWait wait = new WebDriverWait(driver, 60); 	    	 
	    	 int TradeLoanRefNo= Functions.RecNo[j];		     
		     String s= String.valueOf(TradeLoanRefNo);
		    
		     WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/nav/div/div[2]/ul/li[3]/a")));
		     element1.click();
		     Functions.Wait(5000);
		     Functions.Inttype(KeyEvent.VK_ENTER);
		   	
		     Functions.Wait(5000);		     
		     WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div/div/div[1]/div/div[1]/label/input")));
		     element2.click();
		     Functions.Strtype(s);
		     WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div/div/div[1]/div/table/tbody/tr/td[6]/a")));
		     element3.click();
		     WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/form/div[4]/div[2]/button")));
		     element4.click();
		     WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/form/div[3]/button[1]")));
		     element.click();
		     //Buyer
		     String buyer=Functions.GetBuyer(TradeLoanRefNo);
		     driver.findElement(By.xpath("/html/body/div/div[3]/div/form/div[2]/div[3]/div/select")).sendKeys(buyer);
		     //Loan Amount
		     String LoanAmt=Functions.GetLoanAmount(TradeLoanRefNo);		     
		     driver.findElement(By.xpath("/html/body/div/div[3]/div/form/div[2]/div[4]/div/input")).sendKeys(LoanAmt);
		   
		     //Maturity Date
		     String MaturityDate=Functions.GetMaturityDate(TradeLoanRefNo);
		     driver.findElement(By.xpath("/html/body/div/div[3]/div/form/div[2]/div[5]/div[1]/input")).sendKeys(MaturityDate);		     
		     //TradeLoan Ref
		     Date date = new Date();  
		 	 SimpleDateFormat formatter1 = new SimpleDateFormat("dd hh:mm:ss");  
		 	 String strDate= formatter1.format(date);  
		     driver.findElement(By.xpath("/html/body/div/div[3]/div/form/div[2]/div[6]/div/input")).sendKeys("TR"+strDate);		     
		     //Bank Account
		     String Product= Functions.GetProduct(TradeLoanRefNo);
		     
		     //String SRF=null;
		     if(Product.equals("SRF")){
		     
		     BankAccount=Functions.SRFAccount;
		     
		     }else if(Product.equals("SF"))
		        
		     {
		    	 
		    	 String Currency= Functions.GetCurrency(TradeLoanRefNo);
		    	 
		    	 if(Currency.equals("ZAR"))
		    	 
		    	 {
		    		 BankAccount= Functions.SfZarAccount;
		    		 
		    	 }else{BankAccount= Functions.SfNonZarAccount;}
		    	 
		    	 
		     }
		     
		     
		     driver.findElement(By.xpath("/html/body/div/div[3]/div/form/div[2]/div[7]/div/select")).sendKeys(BankAccount);		      
		      Functions.ReportStepName[Stepno]= "ConfirmTradeLoan"+m;
		      Functions.robo(Stepno);	
		      Functions.ReportStepResult[Stepno]="PASS";	    
		      Stepno=Stepno+1;
		      m=m+1;
		     
		     
		     WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/form/div[3]/button[3]")));
		     element5.click();
		
	     }
	    	 
	    
	        Functions.Wait(5000);
	        driver.navigate().refresh();
	        int s= Functions.GetTradeLoanReconcileTask(); 
	        
	        if(s<1)
	        	
	        {
	        	
	        	Functions.Wait(15000);
	        	
	        	driver.navigate().refresh();
	        	
	        	
	        }
	    	
	        
	        int s1= Functions.GetTradeLoanReconcileTask(); 
	        
	    	for(int z=1;z<=s1;z++)
	    		
	    	{
	    		
	    		   WebDriverWait wait = new WebDriverWait(driver, 60); 
	   	    	// System.out.println(Functions.TrReconTask[z]);	    	
	   	         WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/nav/div/div[2]/ul/li[3]/a")));
	   		     element1.click();
	   		     Functions.Wait(5000);
	   		     Functions.Inttype(KeyEvent.VK_ENTER);
	   		   	
	   		     Functions.Wait(5000);		     
	   		     WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div/div/div[1]/div/div[1]/label/input")));
	   		     element2.click();
	   		     try {
	   					Functions.Strtype(Functions.TrReconTask[z]);
	   				} catch (AWTException e) {
	   					// TODO Auto-generated catch block
	   					e.printStackTrace();
	   				}
	   		    
	   		     WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div/div/div[1]/div/table/tbody/tr/td[6]/a")));
	   		     element3.click();		     
	   		     
	   		     WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div[5]/button[2]")));
	   		     element4.click();		     
	   		     
	   		     WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div[4]/button[2]")));
	   		     element5.click();
	   		     
	 	     
	    	
	    	}
	     
	     
	       
		      Stepno=Stepno-1;	
		      Functions.createTestDoc(Stepno, TestName, "PASS");
		      

	}else
	
	
	
	{
		
		
		   System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			  chromeOptions.addArguments("--start-maximized");
			  driver = new ChromeDriver(chromeOptions); 
			
		  //Test Start
			  Functions.ReportStepName[Stepno]= "Get Url";
	      driver.get(Functions.AppUrl);
	    
	      Functions.robo(Stepno);	
	      Functions.ReportStepResult[Stepno]="PASS";	    
	      Stepno=Stepno+1;	     
	      Functions.ReportStepName[Stepno]= "Login In SF Application";	      
	      driver.findElement(By.id("username")).clear();
	      driver.findElement(By.id("username")).sendKeys("abdv220");
	      driver.findElement(By.id("password")).clear();
	      driver.findElement(By.id("password")).sendKeys("Deepak@123");	      
	      driver.findElement(By.id("kc-login")).click();	      
	      Functions.robo(Stepno);
	      Functions.ReportStepResult[Stepno]="PASS";
	      Stepno=Stepno+1;	     
	      Functions.ReportStepName[Stepno]= "Login Into DashBoard";	          
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
	      Functions.robo(Stepno);
	      Functions.ReportStepResult[Stepno]="PASS";	
	      Stepno=Stepno+1;	     
	      WebDriverWait wait = new WebDriverWait(driver, 10); 	    	 
	 	     
	    	    	 
	    	 WebElement element0 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/nav/div/div[2]/ul/li[3]/a")));
		     element0.click();
		     Functions.Wait(5000);	
		     Functions.Inttype(KeyEvent.VK_ENTER);  
		      Functions.Wait(5000);	
		     
		     WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/nav/div/div[2]/ul/li[3]/a")));
		     element1.click();
		     Functions.Wait(2000);		     
		     WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div/div/div[1]/div/div[1]/label/input")));
		     element2.click();
		     element2.sendKeys(Functions.CheckFileExportException());				     
		     WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div/div/div[1]/div/table/tbody/tr/td[6]/a")));
		     element3.click();
		     Functions.robo(Stepno);
		     Functions.ReportStepName[Stepno]= "Exception Task";
		     Functions.ReportStepResult[Stepno]="FAIL";	
		      Stepno=Stepno+1;
		
		System.out.println("RAO EXception Exist");
		
		Stepno=Stepno-1;	
	      Functions.createTestDoc(Stepno, TestName, "FAIL");
	
	
	
	
	}

		}catch (Exception e)
		
		
		{
			
			e.printStackTrace();
			String s= e.toString();
			
			     Functions.robo(Stepno);
			     Functions.ReportStepName[Stepno]= "Exception Task";
			     Functions.ReportStepResult[Stepno]="Fail: Reason-"+s;	
			      Stepno=Stepno+1;
			      
			      Stepno=Stepno-1;	
			      Functions.createTestDoc(Stepno, TestName, "Fail");
		
		}


		
		
	}
	
	

	
		
}

	