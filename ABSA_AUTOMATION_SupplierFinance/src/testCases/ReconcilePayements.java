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

public class ReconcilePayements {

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
	
	public static void ReconcilePayments(String TestName) throws Exception {
	    
		try{ 	
			
			//Clean DB
		      Functions.CleanDB();
		      Functions.DeleteDBWF();
		      //DB Cleaned
		      
		      //Put RAO File
		      Functions.Wait(10000);
		      Functions.PutRAOFilesInserver();	
		      
		     
		      //File Put in SERVER
		} catch (Exception e) {e.printStackTrace();}
		      
		     String Exc="";
			
			Exc= Functions.CheckFileExportException();
			
			if(Exc.equals(""))
			{
		
				
				try{
					
					  Functions.Wait(10000);
				      Functions.PutPAYIFilesInserver();
				
				}catch(Exception e){e.printStackTrace();}
				
		
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
	      Functions.UPStrtype("T");
	      Functions.Strtype("he");
	      Functions.Strtype("1");
	      Functions.ATtype();	   
	      Functions.Strtype("123");	           
	      Functions.Inttype(KeyEvent.VK_ENTER);  
	      Functions.Wait(5000);      
	  
	      //Report Creation
	      
	    	 WebDriverWait wait = new WebDriverWait(driver, 10); 	    	 
	    	 	     
	    	 Functions.ReportStepName[Stepno]= "Task Created";	    	 
	    	 WebElement element0 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/nav/div/div[2]/ul/li[3]/a")));
		     element0.click();		  
		     Functions.Wait(5000);
		     Functions.Inttype(KeyEvent.VK_ENTER);				   	
		     Functions.Wait(5000);
		     int i= Functions.GetBuyerException();
		    
		      if(i>0)
		    	  
		      {
		    	  
		    	  for(int j=1;j<=i;j++)
		    		  
		    	  {
		    	     WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/nav/div/div[2]/ul/li[3]/a")));
				     element1.click();
				     Functions.Wait(5000);
				     Functions.Inttype(KeyEvent.VK_ENTER);				   	
				     Functions.Wait(5000);			     
				     WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div/div/div[1]/div/div[1]/label/input")));
				     element2.click();
				     element2.sendKeys(Functions.BuyerEx[j]);				     
				     WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div/div/div[1]/div/table/tbody/tr/td[6]/a")));
				     element3.click();				     
				     WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/form/div[2]/div[3]/div/button[2]")));
				     element4.click();				     
				     Functions.Wait(5000);				     
				     String s=  driver.findElement(By.xpath("/html/body/div/div[3]/div/form/ng-include/div[2]/div[1]/div/span")).getText();	
				     s.trim();				     
				     String s1=  driver.findElement(By.xpath("/html/body/div/div[3]/div/form/ng-include/div[2]/div[3]/div/span")).getText();
				     s1.trim();
				     System.out.println(s);	
				     
				    if(s1.equals("Saldanha Steel Pty Ltd"))
				    	
				    {
				    	
				    	Functions.SetCifNumber("Saldanha Steel (Pty) Ltd", s);
				    	Functions.Wait(5000);
				    	WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/form/div[2]/div[1]/div[3]/div/select")));
					    element5.sendKeys("Saldanha Steel (Pty) Ltd");				    	 
				        WebElement element6 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/form/div[2]/div[2]/div/button[3]")));
					    element6.click();
				    	
				    }
				     
                   if(s1.equals("Arcelormittal South Africa Limited"))
				    	
				    {
				    	
				    	
                	   Functions.SetCifNumber("ArcelorMittal South Africa Limited", s);
                	   Functions.Wait(5000);                	   
				       WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/form/div[2]/div[1]/div[3]/div/select")));
					   element5.sendKeys("Arcelormittal South Africa Limited");
				       WebElement element6 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/form/div[2]/div[2]/div/button[3]")));
					   element6.click();
				    	
				    }
				    
			
		    	  }
		    	  
		    	  
		      }
		   
		      
		      
		      Functions.Wait(5000);		
              
              int k= Functions.GetBenifecieryException();
              
              if(k>0)
           	   
           	   
              {
            	  for(int j=1;j<=k;j++)
            		  
            	  {
           	   
            	  
            		  
            		 WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/nav/div/div[2]/ul/li[3]/a")));
 				     element1.click();
 				     Functions.Wait(5000);
				     Functions.Inttype(KeyEvent.VK_ENTER);				   	
				     Functions.Wait(5000);	     
 				     WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div/div/div[1]/div/div[1]/label/input")));
 				     element2.click();
 				     element2.sendKeys(Functions.BenfEx[j]); 				     
 				     WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div/div/div[1]/div/table/tbody/tr/td[6]/a")));
 				     element3.click(); 				     
 				     WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/form/div[2]/div[4]/div/button[2]")));
				     element4.click();				     
				     Functions.Wait(3000);
				     String s=  driver.findElement(By.xpath("/html/body/div/div[3]/div/form/ng-include/div[3]/div[1]/div/span")).getText();					     	     
				     s.trim();				     
				     WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/form/div[2]/div[2]/div/div/select")));
				     element5.sendKeys(s);				     
				     WebElement element6 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/form/div[2]/div[3]/div/button[3]")));
				     element6.click();				     
				     Functions.Wait(3000);
 			
           	   
            	  }
           	   
              }
		      
		     
              Functions.Wait(5000);		
              
              int t= Functions.BenifecieryExceptionApp();
              
              if(t>0)
            	  
              {
            	  
            	  
            	  
                for(int j=1;j<=k;j++)
            		  
            	  {
           	   
            	  

 				     Functions.Wait(2000);		     
 				     WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div/div/div[1]/div/div[1]/label/input")));
 				     element2.click();
 				     element2.sendKeys(Functions.BenfExApp[j]); 				     
 				     WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div/div/div[1]/div/table/tbody/tr/td[6]/a")));
 				     element3.click(); 				     
 				     WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/form/div[2]/div[6]/div/button[2]")));
				     element4.click(); 				     
				     WebElement element5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/form/div[2]/div[5]/div/button[3]")));
				     element5.click();
 				     
 				     
            	  }
           	   
    
              }
              
              Functions.Wait(5000);	
		      
              int l = Functions.GetTradeLoanCountAndRefNum();
     	     
     	     for(int j=1;j<=l;j++)
     	     
     	     {
     	    	 
     	    		    	 
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
	}


}
