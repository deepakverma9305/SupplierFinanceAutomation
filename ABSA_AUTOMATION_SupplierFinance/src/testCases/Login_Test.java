package testCases;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sikuli.script.Screen;
import java.awt.event.KeyEvent;
import generalFunctions.Functions;
public class Login_Test {

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
	public static String SRFAccount= "SRF Suspense Account - ABSAZAJJ, 4082761030";
	public static String SfZarAccount="SF Suspense Account - ABSAZAJJ, 4082761030";
	public static String SfNonZarAccount="USD Nostro - CITIUS33, 010686";
	public static String BankAccount=null;	
	public static Date date = new Date();  
	public static  SimpleDateFormat formatter1 = new SimpleDateFormat("dd hh:mm:ss");  
	public static  String strDate1= formatter1.format(date);   
	public static int Stepno=1;//Important value
	public static int m=1;
	public static void Test_Login(String TestName) throws Exception {
	    
		try{ 	
			
			
		  System.out.println("launching chrome browser");
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
	      driver.findElement(By.id("username")).sendKeys(Functions.userName);
	      driver.findElement(By.id("password")).clear();
	      driver.findElement(By.id("password")).sendKeys(Functions.Password);	      
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
	      //Report Creation
	      Stepno=Stepno-1;	
	      Functions.createTestDoc(Stepno, TestName, "PASS");
	      
	      
		    }
		    catch (Exception e) {e.printStackTrace();}
	       
		     

	}





}
