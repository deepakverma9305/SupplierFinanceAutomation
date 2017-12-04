package generalFunctions;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.Units;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sikuli.script.Screen;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import generalFunctions.Functions;
import javax.swing.JOptionPane;

public class Functions {

	static ChromeOptions chromeOptions = new ChromeOptions();
	public static String userName;
	public static String Password;
	public static int Environment;
	static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");
	public static String driverPath = "C:\\Users\\abdv220\\workspace\\all External jars\\";	
	public static WebDriver driver;
	static Screen s= new Screen();
	public static String sikulImages="C:\\Users\\abdv220\\git\\ABSA_FrameWork_Selinium\\ABSA_AutomationFrameWork_CIB\\SikuliImages";
	public static String Header = "ABSA-CIB CORPORATE: SUPPLIER FINANCE";
	public static String Footer = "ABSA BANK";
	public static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	public static Date date = new Date();
	public static String strDate= formatter.format(date);  
	public static String TemlatePath= "C:\\Users\\abdv220\\Deepak_ABSA_Autamation_Framework\\Test_data\\Template\\TestResultTemplate.docx";
	public static String TesDocPath= "C:\\Users\\abdv220\\Deepak_ABSA_Autamation_Framework\\Test_Results\\";
	public static String ImgLocation= "C:\\Users\\abdv220\\Deepak_ABSA_Autamation_Framework\\Test_Results\\temp\\";
	public static int[] RecNo= new int[100];
	public static String[] FileName= new String[100];	
	public static String RaoSourceLocation= "C:\\Users\\abdv220\\Deepak_ABSA_Autamation_Framework\\Test_data\\RAO_Files\\";
	public static String DepositSourceLocation= "C:\\Users\\abdv220\\Deepak_ABSA_Autamation_Framework\\Test_data\\SRF_DepositFiles\\";
	public static String RaoDestionationLocation;
	public static String MainDBString;		
	public static String WFDBString;	
	public static String AppUrl;	
	public static int[] ReportStepNumber= new int[100];
	public static String[] ReportStepName = new String[100];
	public static String[] ReportStepResult = new String[100];
	public static String PayiSourceLocation= "C:\\Users\\abdv220\\Deepak_ABSA_Autamation_Framework\\Test_data\\Payment_Files\\";
	public static String[] PAYIFileName= new String[100];
	public static String[] BuyerEx= new String[100];
	public static String[] BenfEx= new String[100];
	public static String[] BenfExApp= new String[100];
	public static String[] DepDirName= new String[100];
	public static String[] DepFileName= new String[100];
	public static String SRFAccount= "SRF Suspense Account - ABSAZAJJ, 4082761030";
	public static String SfZarAccount="SF Suspense Account - ABSAZAJJ, 4082761030";
	public static String SfNonZarAccount="USD Nostro - CITIUS33, 010686";
	public static String[] TrReconTask= new String[100];
	
public static void DeleteDBWF()

{
    try {
    	
    	Class.forName("org.postgresql.Driver");
    	Connection connection = null;    	
    	connection = DriverManager.getConnection(WFDBString,"postgres", "postgres");
   
        Statement stmt = connection.createStatement();    
        stmt.executeUpdate("truncate act_ru_execution,act_hi_procinst,act_ru_task,act_hi_actinst,act_hi_taskinst,act_ru_job cascade;");
        connection.close();
        
    } catch (Exception e){e.printStackTrace();}}

public static void Wait(int time)



{
	try {
	    Thread.sleep(time);                 //1000 milliseconds is one second.
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	
	
}
public static void CleanDB(){
	
	try {
    	
    	Class.forName("org.postgresql.Driver");
    	Connection connection = null;
    	//connection = DriverManager.getConnection(Str);
    	connection = DriverManager.getConnection(MainDBString,"postgres", "postgres");
    	Statement stmt = connection.createStatement();
       // ResultSet rs;

        //rs = stmt.executeQuery("truncate batch_run cascade;");
        stmt.executeUpdate("truncate detail_recon_report,recon_summary_report,trade_loan_batch_link,trade_loan_batch,batch_run,trade_loan_batch_link,trade_loan_batch,payment_transmission,exception_payment_request,exception_task_detail,file_import,payment_request,payment_request_exception_task_detail,payment_request_file_import,primary_transaction,propell_payment,rao_file_import,supplier_payment,trade_loan cascade;");
        connection.close();
       
        
        
        
    } catch (Exception e){e.printStackTrace();}
	
	
	
}


public static String getSfExecutionDate()

{
	
	
    Calendar c = Calendar.getInstance();    
   // c.add(Calendar.DATE, 60);
   
	int month = c.get(Calendar.MONTH);
    int day=c.get(Calendar.DAY_OF_MONTH);
    int year=c.get(Calendar.YEAR);
    
    String Month1="";
    
    if(month==0)
    {
    	
    	Month1="Jan";
    	
    	
    }else
    	
    	  if(month==1)
          {
          	
          	Month1="Feb";
          	
          	
          }else
        	  if(month==2)
              {
              	
              	Month1="Mar";
              	
              	
              }else
            	  if(month==3)
                  {
                  	
                  	Month1="Apr";
                  	
                  	
                  }else
                	  if(month==4)
                      {
                      	
                      	Month1="May";
                      	
                      	
                      }else
                    	  if(month==5)
                          {
                          	
                          	Month1="Jun";
                          	
                          	
                          }else
                        	  if(month==6)
                              {
                              	
                              	Month1="Jul";
                              	
                              	
                              }else
                            	  if(month==7)
                                  {
                                  	
                                  	Month1="Aug";
                                  	
                                  	
                                  }else
                                	  if(month==8)
                                      {
                                      	
                                      	Month1="Sep";
                                      	
                                      	
                                      }else
                                    	  if(month==9)
                                          {
                                          	
                                          	Month1="Oct";
                                          	
                                          	
                                          }else
                                        	  if(month==10)
                                              {
                                              	
                                              	Month1="Nov";
                                              	
                                              	
                                              }else
                                            	  if(month==11)
                                                  {
                                                  	
                                                  	Month1="Dec";
                                                  	
                                                  	
                                                  }
            	  
            	  
            	  
    //System.out.println(day+"-"+Month1+"-"+year);
    
   String Date1= day+"-"+Month1+"-"+year;
	
	//System.out.println(Date1);
	
	
	return Date1;
	











}

public static String getSfMaturityDate()

{
	
	
    Calendar c = Calendar.getInstance();    
    c.add(Calendar.DATE, 60);
   
	int month = c.get(Calendar.MONTH);
    int day=c.get(Calendar.DAY_OF_MONTH);
    int year=c.get(Calendar.YEAR);
    
    String Month1="";
    
    if(month==0)
    {
    	
    	Month1="Jan";
    	
    	
    }else
    	
    	  if(month==1)
          {
          	
          	Month1="Feb";
          	
          	
          }else
        	  if(month==2)
              {
              	
              	Month1="Mar";
              	
              	
              }else
            	  if(month==3)
                  {
                  	
                  	Month1="Apr";
                  	
                  	
                  }else
                	  if(month==4)
                      {
                      	
                      	Month1="May";
                      	
                      	
                      }else
                    	  if(month==5)
                          {
                          	
                          	Month1="Jun";
                          	
                          	
                          }else
                        	  if(month==6)
                              {
                              	
                              	Month1="Jul";
                              	
                              	
                              }else
                            	  if(month==7)
                                  {
                                  	
                                  	Month1="Aug";
                                  	
                                  	
                                  }else
                                	  if(month==8)
                                      {
                                      	
                                      	Month1="Sep";
                                      	
                                      	
                                      }else
                                    	  if(month==9)
                                          {
                                          	
                                          	Month1="Oct";
                                          	
                                          	
                                          }else
                                        	  if(month==10)
                                              {
                                              	
                                              	Month1="Nov";
                                              	
                                              	
                                              }else
                                            	  if(month==11)
                                                  {
                                                  	
                                                  	Month1="Dec";
                                                  	
                                                  	
                                                  }
            	  
            	  
            	  
    //System.out.println(day+"-"+Month1+"-"+year);
    
   String Date1= day+"-"+Month1+"-"+year;
	
	//System.out.println(Date1);
	
	
	return Date1;
	











}


public static void CreateFile_SRF(String path) throws FileNotFoundException

{
	
	PrintWriter pw = new PrintWriter(new File(path));
    StringBuilder sb = new StringBuilder();
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date = new Date();
    Calendar c = Calendar.getInstance();    
    c.add(Calendar.DATE, 60);
   
    //SRF File  //        
  
    sb.append("EXPORT_DATE,,,,,,,,,,,,,,,,,");        
    sb.append('\n');
    sb.append("22-Aug-2017 14:15 (SAST),,,,,,,,,,,,,,,,,");        
    sb.append('\n');               
    
    //sb.append('"');
    sb.append("Offer Acceptance Date");
    //sb.append('"');        
    sb.append(',');
    //sb.append('"');
    sb.append("Advanced Value");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Obligor External ID");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Program Name");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Obligor");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Currency");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("FI Payment");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Invoice Reference");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Repayment Date");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("SP Rate Amount");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("FI Rate and Base Amount");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Seller External ID");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Seller");
    //sb.append('"');        
    sb.append(',');
    //sb.append('"');
    sb.append("Supplier Receipt");
    //sb.append('"');        
    sb.append(',');
    //sb.append('"');
    sb.append("Trade Payment Date");
    //sb.append('"');        
    sb.append(',');
    //sb.append('"');
    sb.append("Offer Reference");
    //sb.append('"');        
    sb.append(',');
    //sb.append('"');
    sb.append("Tenor Days (Trade payment to Repayment)");
    //sb.append('"');        
    sb.append(',');
    //sb.append('"');
    sb.append("Invoice Value");
    //sb.append('"');        
    sb.append('\n');
    
    

    //sb.append('"');
    sb.append(dateFormat.format(date));
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append(3341.16);
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append(79044);
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Farmwise on ABSA: Woolworths (79044)");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Woolworths (Pty) Ltd");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("ZAR");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append(3281.66);
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("INV21484");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');     
    sb.append(dateFormat.format(c.getTime()));
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append(2.14);
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append(59.5);
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Farmwise");
    //sb.append('"');
    sb.append(',');
    //sb.append('"');
    sb.append("Farmwise Marketing (Pty) Ltd");
    //sb.append('"');        
    sb.append(',');
    //sb.append('"');
    sb.append(3279.52);
    //sb.append('"');        
    sb.append(',');
    //sb.append('"');
    sb.append(dateFormat.format(date));
    //sb.append('"');        
    sb.append(',');
    //sb.append('"');
    sb.append("SCQCGOSQITKNDCY");
    //sb.append('"');        
    sb.append(',');
    //sb.append('"');
    sb.append(60);
    //sb.append('"');       
    sb.append(',');
    //sb.append('"');
    sb.append(3712.4);
    //sb.append('"');        
    sb.append('\n');

    pw.write(sb.toString());
    pw.close();
    System.out.println("done!");




}

public static void CreateFile_SFFile(String path) throws FileNotFoundException

{
	
	PrintWriter pw = new PrintWriter(new File(path));
    StringBuilder sb = new StringBuilder();
   // DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
   // Date date = new Date();
   // Calendar c = Calendar.getInstance();    
    //c.add(Calendar.DATE, 60);
    
   
    //SRF File  //        
  
//    sb.append("EXPORT_DATE,,,,,,,,,,,,,,,,,");        
//    sb.append('\n');
//    sb.append("22-Aug-2017 14:15 (SAST),,,,,,,,,,,,,,,,,");        
//    sb.append('\n');               
    
  sb.append('"');
    sb.append("Buyer");
  sb.append('"');        
    sb.append(',');
  sb.append('"');
    sb.append("Buyer Program");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("Supplier");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("Buy Offer");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("Payment Obligation");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("Transaction Date");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("Effective Date");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("Maturity Date");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("Certified Value");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("FI Margin");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("Community Margin");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("Supplier Funds Received");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("Currency");
  sb.append('"');        
    sb.append(',');
  sb.append('"');
    sb.append("Supplier ID");
  sb.append('"');        
    sb.append(',');
  sb.append('"');
    sb.append("Trade Cost");
  sb.append('"');        
    sb.append(',');
  sb.append('"');
    sb.append("Buyer Id");
  sb.append('"');        
    sb.append(',');
  sb.append('"');
    sb.append("Supplier Days Used");
  sb.append('"');        
    sb.append(',');
  sb.append('"');
    sb.append("Buyer Days Used");
  sb.append('"');
  sb.append(',');
  sb.append('"');
    sb.append("Asset Originator");
  sb.append('"');
    sb.append('\n');
    
    

  sb.append('"');
    sb.append("ArcelorMittal South Africa Limited");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("AMSA-Newcastle Steel-SL01-ZAR-ABSA-DOM-M");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("GfE-MIR Alloys and Minerals (Pty) Ltd");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("5377A90613A0");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("INV26304");
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append(Functions.getSfExecutionDate());
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append(Functions.getSfExecutionDate());
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append(Functions.getSfMaturityDate());
  sb.append('"');
    sb.append(',');
  sb.append('"');     
    sb.append(1226062.28);
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append(17187.71);
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append(2450.78);
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append(1206423.79);
  sb.append('"');
    sb.append(',');
  sb.append('"');
    sb.append("ZAR");
  sb.append('"');        
    sb.append(',');
  sb.append('"');
    sb.append("420150717100549");
  sb.append('"');        
    sb.append(',');
  sb.append('"');
    sb.append(1208874.57);
  sb.append('"');        
    sb.append(',');
  sb.append('"');
    sb.append("520150617094646");
  sb.append('"');        
    sb.append(',');
  sb.append('"');
    sb.append(64);
  sb.append('"');       
    sb.append(',');
  sb.append('"');
    sb.append(0);
  sb.append('"'); 
  sb.append(',');
  sb.append('"');
    sb.append("MSSOUTH004");
  sb.append('"'); 
    sb.append('\n');

    pw.write(sb.toString());
    pw.close();
    System.out.println("done!");




}
public static void CreateStepInReport(String TestName, String StepName, String StepResult, String TestResult ,String ImgLocation, String TestDocLoacation) throws IOException, InvalidFormatException


{
	 String imgFile = ImgLocation+StepName+".jpg";	
	 @SuppressWarnings("resource")
     XWPFDocument document = new XWPFDocument(OPCPackage.open(TesDocPath+TestName+".docx"));	
        
     XWPFParagraph paragraph = document.createParagraph();     
     XWPFRun paragraph1 = paragraph.createRun();
     paragraph1.addBreak(); 
     paragraph1.setText("Step Name: "+StepName);
     paragraph1.addTab();
     paragraph1.setText("Step Result: "+StepResult);     
     FileInputStream is = new FileInputStream(imgFile);
     paragraph1.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, imgFile, Units.toEMU(471), Units.toEMU(400));
     is.close();
     FileOutputStream out = new FileOutputStream(new File(TesDocPath+TestName+".docx")); 
     document.write(out);
     out.close();
     System.out.println("Document written successully");
  }

public static void robo(int StepNumber) throws Exception
{
    
	
	Calendar now = Calendar.getInstance();
    Robot robot = new Robot();
    try {
	    Thread.sleep(2000);                 //1000 milliseconds is one second.
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
    BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
   // ImageIO.write(screenShot, "JPG", new File(str+formatter.format(now.getTime())+".jpg"));
    
    ImageIO.write(screenShot, "JPG", new File(ImgLocation+"Step"+StepNumber+".jpg"));
    //StepNumber++;
    
    
    
    System.out.println(formatter.format(now.getTime()));
}

public static void createTestDoc(int StepNumber, String TestName,String TestResult) throws InvalidFormatException, IOException


{
	//int[] SteNumber = new int[100];
	
	//XWPFDocument document = new XWPFDocument();
	
	@SuppressWarnings("resource")
	XWPFDocument document = new XWPFDocument(OPCPackage.open(TemlatePath));
	
	XWPFParagraph paragraph = document.createParagraph();
    
    //Set Bold an Italic
    XWPFRun paragraph0 = paragraph.createRun();
    paragraph0.setBold(true);    
    paragraph0.setText("Test case Name: "+TestName);
    paragraph0.setFontSize(12);
    paragraph0.setTextPosition(10);
    paragraph.setBorderRight(org.apache.poi.xwpf.usermodel.Borders.BASIC_BLACK_DASHES);
    paragraph.setBorderBottom(org.apache.poi.xwpf.usermodel.Borders.BASIC_BLACK_DASHES);
    paragraph.setBorderLeft(org.apache.poi.xwpf.usermodel.Borders.BASIC_BLACK_DASHES);
    paragraph.setBorderTop(org.apache.poi.xwpf.usermodel.Borders.BASIC_BLACK_DASHES);     
    paragraph0.addBreak();     
    paragraph0.setText("Date: "+dateFormat.format(date));
    paragraph0.addTab();
    paragraph0.setText("Test Analyst: Automation Test ");
    paragraph0.addTab();
    paragraph0.setText("Result: "+TestResult);   
    paragraph0.addBreak();  
    
    for (int i=1;i<=StepNumber;i++)
    	
    {
    
    XWPFParagraph paragraph2 = document.createParagraph();
    XWPFRun paragraph3 = paragraph2.createRun();
    paragraph3.setText("StepName: "+ReportStepName[i]);
    paragraph3.addTab();
    paragraph3.setText("Step Result:");
    paragraph3.addTab();
    paragraph3.setText(ReportStepResult[i]);
    paragraph3.addBreak(); 
    FileInputStream is = new FileInputStream(ImgLocation+"Step"+i+".jpg");
    paragraph3.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, ImgLocation+"Step"+i+".jpg", Units.toEMU(471), Units.toEMU(400));
    is.close();
    paragraph3.addBreak();
    
    }
    
    
	FileOutputStream out = new FileOutputStream(new File(TesDocPath+TestName+".docx"));
	
	 document.write(out);
	 
     out.close();
     
     ReportStepName=null;
     ReportStepResult=null;
     generalFunctions.Functions.FlushOldResults();
     
}

public static void FlushOldResults()

{
	try{
	  String path= ImgLocation; 
        File file = new File(path);
        File[] files = file.listFiles(); 
        
        for (File f:files) {
       
           f.delete();
        }
	} catch(Exception e){e.printStackTrace();}
	
}

public static void WriteToExcel(int SheetNumber, int RowNumber, int ColNumber, String StepResult) throws IOException
{
    //Blank workbook
	
	FileInputStream file = new FileInputStream(new File("C:\\Users\\abdv220\\Deepak_ABSA_Autamation_Framework\\Test_Results\\Test.xlsx"));
    @SuppressWarnings("resource")
    XSSFWorkbook workbook = new XSSFWorkbook(file);
//	XSSFWorkbook workbook = new XSSFWorkbook();
     
    //Create a blank sheet
    Sheet sheet = workbook.getSheetAt(SheetNumber);
   // XSSFSheet sheet = workbook.createSheet("TestSteps");
    
    for(int i=1;i<=RowNumber;i++){
    Row row = sheet.createRow(i);
    Cell cell = row.createCell(ColNumber);           
    cell.setCellValue(generalFunctions.Functions.ReportStepName[i]);
    
    Cell cell2 = row.createCell(ColNumber+1);           
    cell2.setCellValue(StepResult);
    }
            
    
    try
    {
        //Write the workbook in file system
        FileOutputStream out = new FileOutputStream(new File("C:\\Users\\abdv220\\Deepak_ABSA_Autamation_Framework\\Test_Results\\Test.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}

public static void leftClick() throws AWTException
{
  Robot robot = new Robot();
  robot.mousePress(InputEvent.BUTTON1_MASK);
  robot.delay(200);
  robot.mouseRelease(InputEvent.BUTTON1_MASK);
  robot.delay(200);
}

public static void Inttype(int i) throws AWTException
{
  Robot robot = new Robot();
  robot.delay(40);
  robot.keyPress(i);
  robot.keyRelease(i);
}

public static void Strtype(String s) throws AWTException
{
	
  Robot robot = new Robot();
  byte[] bytes = s.getBytes();
  for (byte b : bytes)
  {
    int code = b;
    // keycode only handles [A-Z] (which is ASCII decimal [65-90])
    if (code > 96 && code < 123) code = code - 32;
    robot.delay(40);
    robot.keyPress(code);
    robot.keyRelease(code);
  }
}

public static void ATtype() throws AWTException
{
  Robot robot = new Robot();
  robot.keyPress(KeyEvent.VK_SHIFT);
  robot.keyPress(KeyEvent.VK_2);
  robot.keyRelease(KeyEvent.VK_2);
  robot.keyRelease(KeyEvent.VK_SHIFT);
}

public static void UPStrtype(String s) throws AWTException
{
	
  Robot robot = new Robot();
  byte[] bytes = s.getBytes();
  for (byte b : bytes)
  {
    int code = b;
    // keycode only handles [A-Z] (which is ASCII decimal [65-90])
    if (code > 96 && code < 123) code = code - 32;
    robot.delay(40);
    robot.keyPress(KeyEvent.VK_CAPS_LOCK);
    robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
    robot.keyPress(code);
    robot.keyRelease(code);
    robot.keyPress(KeyEvent.VK_CAPS_LOCK);
    robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
  }
}

public static int GetTradeLoanCountAndRefNum()


{
	int i =1;
	
	try {
		
		
		
		int numberRow1 = 0;
    	Class.forName("org.postgresql.Driver");
    	Connection connection = null;
    	//connection = DriverManager.getConnection(Str);
    	connection = DriverManager.getConnection("jdbc:postgresql://22.149.62.84:5432/SIT2_supplierfinance","postgres", "postgres");
    	
        Statement stmt = connection.createStatement();
      
        
       ResultSet rs =   stmt.executeQuery("SELECT Count(*) FROM public.trade_loan;");
        
        while(rs.next()){
            
        }
        
       // System.out.println(numberRow);
        
        
        ResultSet rs1 =   stmt.executeQuery("SELECT * from public.trade_loan;");
        
        while(rs1.next()){
            numberRow1 = rs1.getInt("id");
            RecNo[i]=numberRow1;
            i=i+1;
            
        }
        
       // System.out.println(RecNo[2]);
       
        
        connection.close();
       
        
        
        
    } catch (Exception e){e.printStackTrace();}
	return i-1;
	
	
	







}

public static String  GetLoanAmount(int m) throws ClassNotFoundException


{
	
	String  LA= null;
	
	try {
		
		Class.forName("org.postgresql.Driver");
    	Connection connection = null;
    	//connection = DriverManager.getConnection(Str);
    	connection = DriverManager.getConnection("jdbc:postgresql://22.149.62.84:5432/SIT2_supplierfinance","postgres", "postgres");
    	
        Statement stmt = connection.createStatement();
       // int i = generalFunctions.Functions.GetTradeLoanRefNum();
	     
	     //int TradeLoanRefNo= generalFunctions.Functions.RecNo[i-2];     
        
        ResultSet rs = stmt.executeQuery("SELECT * FROM public.trade_loan where id= "+m+";");      
       
        while(rs.next()){
        	
        	
        	String  numberRow1 = rs.getString("discount_amount");
    	       	   
        	//float  numberRow1 = rs.getInt("discount_amount");
            LA=numberRow1;
           
           //System.out.println(LA);
        }
      
        connection.close();       
        
    } catch (Exception e){e.printStackTrace();}
	
	return LA ;
	
	
	
	

	
}

public static String GetBuyer(int m)

{

	String  numberRow1 = null;
	String numberRow2 = null;


try {
	
	
	
	Class.forName("org.postgresql.Driver");
	Connection connection = null;
	//connection = DriverManager.getConnection(Str);
	connection = DriverManager.getConnection("jdbc:postgresql://22.149.62.84:5432/SIT2_supplierfinance","postgres", "postgres");
	
    Statement stmt = connection.createStatement();
    //int i = generalFunctions.Functions.GetTradeLoanRefNum();
     
     //int TradeLoanRefNo= generalFunctions.Functions.RecNo[i];     
    
    ResultSet rs = stmt.executeQuery("SELECT * FROM public.trade_loan where id= "+m+";");      
   
    while(rs.next()){
    	
    	
    	numberRow1 = rs.getString("buyer_id");
	       	   
    	//float  numberRow1 = rs.getInt("discount_amount");
        String LA=numberRow1;
       
       System.out.println(LA);
    }
  
    
    ResultSet rs1 = stmt.executeQuery("SELECT * FROM public.trading_entity where id= "+numberRow1+";");      
       
    while(rs1.next()){
    	
    	
    	numberRow2 = rs1.getString("trading_entity_name");
	       	   
    	//float  numberRow1 = rs.getInt("discount_amount");
        String LA=numberRow2;
       
       System.out.println(LA);
    }
    connection.close();       
    
} catch (Exception e){e.printStackTrace();}
return numberRow2;




}

public static String  GetMaturityDate(int m) throws ClassNotFoundException


{
	
	String  LA= null;
	
	try {
		
		Class.forName("org.postgresql.Driver");
    	Connection connection = null;
    	//connection = DriverManager.getConnection(Str);
    	connection = DriverManager.getConnection("jdbc:postgresql://22.149.62.84:5432/SIT2_supplierfinance","postgres", "postgres");
    	
        Statement stmt = connection.createStatement();
       // int i = generalFunctions.Functions.GetTradeLoanRefNum();
	     
	     //int TradeLoanRefNo= generalFunctions.Functions.RecNo[i-2];     
        
        ResultSet rs = stmt.executeQuery("SELECT * FROM public.trade_loan where id= "+m+";");      
       
        while(rs.next()){
        	
        	
        	String  numberRow1 = rs.getString("maturity_date");
    	       	   
        	//float  numberRow1 = rs.getInt("discount_amount");
            LA=numberRow1;
           
           //System.out.println(LA);
        }
      
        connection.close();       
        
    } catch (Exception e){e.printStackTrace();}
	
	return LA ;
	
	
	
	

	
}

public static String  GetProduct(int m) throws ClassNotFoundException


{
	
	String  LA= null;
	
	try {
		
		Class.forName("org.postgresql.Driver");
    	Connection connection = null;
    	//connection = DriverManager.getConnection(Str);
    	connection = DriverManager.getConnection("jdbc:postgresql://22.149.62.84:5432/SIT2_supplierfinance","postgres", "postgres");
    	
        Statement stmt = connection.createStatement();
       // int i = generalFunctions.Functions.GetTradeLoanRefNum();
	     
	     //int TradeLoanRefNo= generalFunctions.Functions.RecNo[i-2];     
        
        ResultSet rs = stmt.executeQuery("SELECT * FROM public.trade_loan where id= "+m+";");      
       
        while(rs.next()){
        	
        	
        	String  numberRow1 = rs.getString("product_code");
    	       	   
        	//float  numberRow1 = rs.getInt("discount_amount");
            LA=numberRow1;
           
           //System.out.println(LA);
        }
      
        connection.close();       
        
    } catch (Exception e){e.printStackTrace();}
	
	return LA ;
	
	
	
	

	
}

public static String  GetCurrency(int m) throws ClassNotFoundException


{
	
	String  LA= null;
	
	try {
		
		Class.forName("org.postgresql.Driver");
    	Connection connection = null;
    	//connection = DriverManager.getConnection(Str);
    	connection = DriverManager.getConnection("jdbc:postgresql://22.149.62.84:5432/SIT2_supplierfinance","postgres", "postgres");
    	
        Statement stmt = connection.createStatement();
       // int i = generalFunctions.Functions.GetTradeLoanRefNum();
	     
	     //int TradeLoanRefNo= generalFunctions.Functions.RecNo[i-2];     
        
        ResultSet rs = stmt.executeQuery("SELECT * FROM public.trade_loan where id= "+m+";");      
       
        while(rs.next()){
        	
        	
        	String  numberRow1 = rs.getString("currency");
    	       	   
        	//float  numberRow1 = rs.getInt("discount_amount");
            LA=numberRow1;
           
           //System.out.println(LA);
        }
      
        connection.close();       
        
    } catch (Exception e){e.printStackTrace();}
	
	return LA ;
	
	
	
	

	
}

public static int  GetRAOFiles()


{

	File folder = new File(RaoSourceLocation);
	File[] listOfFiles = folder.listFiles();
	

	    for (int i = 0; i < listOfFiles.length; i++) {
	      if (listOfFiles[i].isFile()) {
	        //System.out.println("File " + listOfFiles[i].getName());
	        FileName[i]=listOfFiles[i].getName();
	      
	      
	      } else if (listOfFiles[i].isDirectory()) {
	        System.out.println("Directory " + listOfFiles[i].getName());
	      }
	    }
		return listOfFiles.length;
	

}

public static void PutRAOFilesInserver() throws IOException



{
	
	
	int s= generalFunctions.Functions.GetRAOFiles();
	
    for (int i = 0; i < s; i++)
    
    
    {
    	
    	String filename= generalFunctions.Functions.FileName[i];
    	
    	generalFunctions.Functions.copyRAOFileUsingStream(filename);
    	generalFunctions.Functions.Wait(5000);
    	


    }

   // FileName=null;

}

public static void copyRAOFileUsingStream(String FileName) throws IOException 



{
	
	File source1 = new File(RaoSourceLocation+FileName);
	File dest1 = new File(RaoDestionationLocation+FileName);
	
    InputStream is = null;
    OutputStream os = null;
    try {
        is = new FileInputStream(source1);
        os = new FileOutputStream(dest1);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
    } finally {
        is.close();
        os.close();
    }
}


public static void Login() throws Exception {
    
	try{ 	
		
		
	  System.out.println("launching chrome browser");
	  System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
	  chromeOptions.addArguments("--start-maximized");
	  driver = new ChromeDriver(chromeOptions);   
	 
      driver.get("http://22.149.62.84:8088/auth/realms/supplierfinance/protocol/openid-connect/auth?client_id=supplierfinance-app&redirect_uri=http%3A%2F%2F22.149.62.84%3A9085%2F%3Fredirect_fragment%3D%252F&state=f8901771-49fd-445e-a680-7367ae52a347&nonce=8a2b393a-996b-4484-8634-a316317442e1&response_mode=fragment&response_type=code");
      generalFunctions.Functions.Wait(3000);
      driver.findElement(By.id("username")).clear();
      driver.findElement(By.id("username")).sendKeys("abdv220");
      driver.findElement(By.id("password")).clear();
      driver.findElement(By.id("password")).sendKeys("Deepak@123");	      
      driver.findElement(By.id("kc-login")).click();        
      generalFunctions.Functions.Wait(3000);	      
      generalFunctions.Functions.Strtype("abdv220");
      generalFunctions.Functions.Inttype(KeyEvent.VK_TAB);	    
      generalFunctions.Functions.UPStrtype("T");
      generalFunctions.Functions.Strtype("he");
      generalFunctions.Functions.Strtype("1");
      generalFunctions.Functions.ATtype();	   
      generalFunctions.Functions.Strtype("123");	           
      generalFunctions.Functions.Inttype(KeyEvent.VK_ENTER);  
            

	    }
	    catch (Exception e) {e.printStackTrace();}
       




}

public static void CopyPayiFileUsingStream(String FileName) throws IOException 



{
	
	File source1 = new File(PayiSourceLocation+FileName);
	File dest1 = new File(RaoDestionationLocation+FileName);
	
    InputStream is = null;
    OutputStream os = null;
    try {
        is = new FileInputStream(source1);
        os = new FileOutputStream(dest1);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
    } finally {
        is.close();
        os.close();
    }
}


public static int  GetPAYIFiles()


{

	File folder = new File(PayiSourceLocation);
	File[] listOfFiles = folder.listFiles();

	    for (int i = 0; i < listOfFiles.length; i++) {
	      if (listOfFiles[i].isFile()) {
	        //System.out.println("File " + listOfFiles[i].getName());
	    	  PAYIFileName[i]=listOfFiles[i].getName();
	      
	      
	      } else if (listOfFiles[i].isDirectory()) {
	        System.out.println("Directory " + listOfFiles[i].getName());
	      }
	    }
		return listOfFiles.length;
	

}

public static void PutPAYIFilesInserver() throws IOException



{
	
	
	int s= generalFunctions.Functions.GetPAYIFiles();
	
    for (int i = 0; i < s; i++)
    
    
    {
    	
    	String filename= generalFunctions.Functions.PAYIFileName[i];
    	
    	generalFunctions.Functions.CopyPayiFileUsingStream(filename);
    	generalFunctions.Functions.Wait(5000);
    	
    }

    PAYIFileName=null;
    
}


public static int  GetBuyerException() 


{
	
	{
		
	//	String  LA= null;
		int i=1;
		try {
			
			Class.forName("org.postgresql.Driver");
	    	Connection connection = null;
	    	//connection = DriverManager.getConnection(Str);
	    	connection = DriverManager.getConnection("jdbc:postgresql://22.149.62.84:5432/SIT_supplierfinance_workflow","postgres", "postgres");
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM public.act_ru_task where name_= 'Resolve Buyer Exception';");  
	        if (!rs.next() ) {
	        	
	        	i=0;
	        	
		       // System.out.println("no data");
		    } else {

		    	 do {
		        	
			        String  numberRow1 = rs.getString("id_");	    	       	   
		            BuyerEx[i]=numberRow1;	           
		            i=i+1;
		        	           
		        }while(rs.next());
		    	
		    	
		        
		    }
	      
	        connection.close();       
	        
	    } catch (Exception e){e.printStackTrace();}
		
		
		return i-1;
		
		
	}


	
}


public final static String GenerateAccountNumber(long len) {
    if (len > 18)
        throw new IllegalStateException("To many digits");
    long tLen = (long) Math.pow(10, len - 1) * 9;

    long number = (long) (Math.random() * tLen) + (long) Math.pow(10, len - 1) * 1;

    String tVal = number + "";
    if (tVal.length() != len) {
        throw new IllegalStateException("The random number '" + tVal + "' is not '" + len + "' digits");
    }
    return tVal;
}


public static void  SetCifNumber(String Buyer, String BuyerCif) throws ClassNotFoundException


{
	
	
	
	try {
		
		Class.forName("org.postgresql.Driver");
    	Connection connection = null;
    	
    	connection = DriverManager.getConnection("jdbc:postgresql://22.149.62.84:5432/SIT2_supplierfinance","postgres", "postgres");
    	
        Statement stmt = connection.createStatement();
       
        
        stmt.executeUpdate("update public.trading_entity set cif_number='"+BuyerCif+"' where trading_entity_name='"+Buyer+"';");      
       
        connection.close();       
        
    } catch (Exception e){e.printStackTrace();}
	

	
	
	
	

	
}

public static int  GetBenifecieryException() 


{
	
	{
		
	//	String  LA= null;
		int i=1;
		try {
			
			Class.forName("org.postgresql.Driver");
	    	Connection connection = null;
	    	//connection = DriverManager.getConnection(Str);
	    	connection = DriverManager.getConnection("jdbc:postgresql://22.149.62.84:5432/SIT_supplierfinance_workflow","postgres", "postgres");
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM public.act_ru_task where name_= 'Resolve Beneficiary Exception';");  
	        if (!rs.next() ) {
	        	
	        	i=0;
	        	
		       // System.out.println("no data");
		    } else {

		    	 do {
		        	
			        String  numberRow1 = rs.getString("id_");	    	       	   
			        BenfEx[i]=numberRow1;	           
		            i=i+1;
		        	           
		        }while(rs.next());
		    	
		    	
		        
		    }
	      
	        connection.close();       
	        
	    } catch (Exception e){e.printStackTrace();}
		
		
		return i-1;
		
		
	}


	
}


public static int  BenifecieryExceptionApp() 


{
	
	{
		
	//	String  LA= null;
		int i=1;
		try {
			
			Class.forName("org.postgresql.Driver");
	    	Connection connection = null;
	    	//connection = DriverManager.getConnection(Str);
	    	connection = DriverManager.getConnection("jdbc:postgresql://22.149.62.84:5432/SIT_supplierfinance_workflow","postgres", "postgres");
	        Statement stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM public.act_ru_task where name_= 'Approve Beneficiary Exception Resolution';");  
	        if (!rs.next() ) {
	        	
	        	i=0;
	        	
		       // System.out.println("no data");
		    } else {

		    	 do {
		        	
			        String  numberRow1 = rs.getString("id_");	    	       	   
			        BenfExApp[i]=numberRow1;	           
		            i=i+1;
		        	           
		        }while(rs.next());
		    	
		    	
		        
		    }
	      
	        connection.close();       
	        
	    } catch (Exception e){e.printStackTrace();}
		
		
		return i-1;
		
		
	}


	
}


public static int  GetDepositdir()


{

	File folder = new File(DepositSourceLocation);
	File[] listOfFiles = folder.listFiles();
	

	    for (int i = 0; i < listOfFiles.length; i++) {
	      if (listOfFiles[i].isFile()) {
	        //System.out.println("File " + listOfFiles[i].getName());
	        FileName[i]=listOfFiles[i].getName();
	      
	      
	      } else if (listOfFiles[i].isDirectory()) {
	    	  DepDirName[i]=listOfFiles[i].getName();
	        
	    	 //System.out.println("Directory " + listOfFiles[i].getName());
	        
	      }
	    }
		
		return listOfFiles.length;
	

}


public static void CopylDepositFileUsingStream(String DirName, String fileName) throws IOException 



{
	
	
	File source1 = new File(DepositSourceLocation+DirName+"\\"+fileName);
	Functions.Wait(5000);
	File dest1 = new File(RaoDestionationLocation+fileName);
	
    InputStream is = null;
    OutputStream os = null;
    try {
        is = new FileInputStream(source1);
        os = new FileOutputStream(dest1);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
    } finally {
        is.close();
        os.close();
    }
}


public static void PutDepositFilesInServer() throws IOException 



{
	
	

	int ik= Functions.GetDepositdir();
	
for(int k=0;k<ik;k++) {
		File folder = new File(DepositSourceLocation+Functions.DepDirName[k]);
		File[] listOfFiles = folder.listFiles();
		

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		       System.out.println("File " + listOfFiles[i].getName());
		        DepFileName[i]=listOfFiles[i].getName();
		        if( DepFileName[i].startsWith("srf_detail_recon"))
		        {
		        	
		        	
		        	Functions.CopylDepositFileUsingStream(DepDirName[k], DepFileName[i]);
		        	Functions.Wait(5000);
		        	
		        }else if(DepFileName[i].startsWith("srf_recon_summary"))
		        	
		        {
		        	
		        	Functions.CopylDepositFileUsingStream(DepDirName[k], DepFileName[i]);
		        	Functions.Wait(5000);
		        	
		        	
		        }
		        
		      } else if (listOfFiles[i].isDirectory()) {
		    	  DepDirName[i]=listOfFiles[i].getName();
		        
		    	System.out.println("Directory " + listOfFiles[i].getName());
		        
		      }
		    }
	
}
	
	
	
}



public static void SRF_FixSupplierValidation() throws IOException 

{
	



	{
		
		try {
			
			Class.forName("org.postgresql.Driver");
	    	Connection connection = null;
	    	//connection = DriverManager.getConnection(Str);
	    	connection = DriverManager.getConnection("jdbc:postgresql://22.149.62.84:5432/SIT2_supplierfinance","postgres", "postgres");
	    	
	        Statement stmt = connection.createStatement();	        
	        
	        ResultSet rs = stmt.executeQuery("SELECT * FROM public.trading_entity;");      
	
	        while(rs.next()){
	        	
	        	
	        	String  account_name = rs.getString("external_trading_entity_id").trim();	        	
	        	String trading_entity_id= rs.getString("id").trim();
	        	String account_number= Functions.GenerateAccountNumber(10).trim();
	        	String bank_name= "ABSA";
	        	String branch="632005";
	        	String currency= "ZAR";
	        	String product= "SRF";
	        	String id = Functions.GenerateAccountNumber(4).trim();
	        	
	        	Statement stmt1 = connection.createStatement();
	        	ResultSet rs1 = stmt1.executeQuery("SELECT * FROM public.trading_entity_bank_account where trading_entity_id='"+trading_entity_id+"';");  
	        	
	        	 if (!rs1.next() ) 
	        	 
	        	 {
	        		 Statement stmt2 = connection.createStatement();
	        		 stmt2.executeUpdate("INSERT INTO public.trading_entity_bank_account(id,account_name, account_number, bank_name, branch_name,currency_code,trading_entity_id, product_code)"+"VALUES('"+id+"','"+account_name+"','"+account_number+"','"+bank_name+"','"+branch+"','"+currency+"','"+trading_entity_id+"','"+product+"');");
	 	        
	 		    }
      		        	
	           
	          
	        }
	      
	        connection.close();       
	        
	    } catch (Exception e){e.printStackTrace();}
		
		
		
		}










}



public static int SRF_GetSupplierException()


{
	

	int i=0;


	try {
		
		Class.forName("org.postgresql.Driver");
    	Connection connection = null;
    	//connection = DriverManager.getConnection(Str);
    	connection = DriverManager.getConnection("jdbc:postgresql://22.149.62.84:5432/SIT_supplierfinance_workflow","postgres", "postgres");
    	
        Statement stmt = connection.createStatement();	        
        
        ResultSet rs = stmt.executeQuery("SELECT * FROM public.act_ru_task where name_='Supplier Payment Validation Exception';");      

        
        	 if (rs.next() ) 
        	 
        	 {
        		
        		 i=1;
        		 
 		    }
 		    

        connection.close();       
        
    } catch (Exception e){e.printStackTrace();}
	return i;
	

}



public static void infoBox(String infoMessage, String titleBar)
{
    JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
}



public static String ReadFromExcel(int sheetno,int rowno,int colno )

{
	
	String cell = null;

	
	try{
	       
	String excelFilePath = "C:\\Users\\abdv220\\Deepak_ABSA_Autamation_Framework\\Test_data\\Url File\\urls.xlsx";
	
	FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	Workbook workbook = new XSSFWorkbook(inputStream);
	Sheet firstSheet = workbook.getSheetAt(sheetno);
	 Row row= firstSheet.getRow(rowno);
	 cell= row.getCell(colno).toString();
	    		
	  workbook.close();
	 
	 System.out.println(cell);
	
	
	}
	
	catch (Exception e){e.printStackTrace();}
	
	
	
	
	return cell;
	




















}


public static String CheckFileExportException()


{
	String Excep="";
	

	{
		
		try {
			
			Class.forName("org.postgresql.Driver");
	    	Connection connection = null;
	    	//connection = DriverManager.getConnection(Str);
	    	connection = DriverManager.getConnection("jdbc:postgresql://22.149.62.84:5432/SIT_supplierfinance_workflow","postgres", "postgres");
	    	
	        Statement stmt = connection.createStatement();	        
	        
	        ResultSet rs = stmt.executeQuery("select id_ from public.act_ru_task where name_= 'Resolve RAO File Import Exception';");      
	
	        
	        	
	        	 if (rs.next() ) 
	        	 
	        	 {
	        		
	        		Excep= rs.getString("id_").trim();
	 	        
	 		    }
      		        	
	           
	        
	      
	        connection.close();       
	        
	    } catch (Exception e){e.printStackTrace();}
		
		
		
		}


	
	
	
	
	
	
	
	
	
	return Excep;
	





}



public static  int GetTradeLoanReconcileTask()


{
	
	int i =1;

	{
		
		try {
			
			Class.forName("org.postgresql.Driver");
	    	Connection connection = null;
	    	//connection = DriverManager.getConnection(Str);
	    	connection = DriverManager.getConnection("jdbc:postgresql://22.149.62.84:5432/SIT_supplierfinance_workflow","postgres", "postgres");
	    	
	        Statement stmt = connection.createStatement();	        
	        
	        ResultSet rs = stmt.executeQuery("select id_ from public.act_ru_task where name_= 'Reconcile Trade Loans';");      
	
	        
	        	
	        	while (rs.next() ) 
	        	 
	        	 {
	        		
	        		 TrReconTask[i]= rs.getString("id_").trim();
	 	        
	        		 i=i+1;
	 		    }
      		        	
	           
	        
	      
	        connection.close();       
	        
	    } catch (Exception e){e.printStackTrace();}
		
		return i-1;
		
		}


	


}











































}


