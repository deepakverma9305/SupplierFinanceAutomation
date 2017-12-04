package guiRun;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;

import generalFunctions.Functions;
import org.eclipse.swt.widgets.Combo;

public class GUI {

	protected Shell shell;
	private Text txtAbdv;
	private Text txtDeepak;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GUI window = new GUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(887, 560);
		shell.setText("SWT Application");
		
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setItems(new String[] {"SIT", "UAT", "Maintenance"});
		combo.setBounds(347, 50, 125, 23);
		combo.setText("SIT");
		
		
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(82, 32, 88, 15);
		lblNewLabel.setText("Available Test");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(513, 32, 75, 15);
		lblNewLabel_1.setText("Selected Test");
		
		List list = new List(shell, SWT.BORDER);
		list.setItems(new String[] {});
		list.setBounds(23, 79, 225, 316);
		
		int Str= list.getItemCount();
		 if(Str < 1)
			 
		 {
			 
			 list.add("Login Test", 0);
			 list.add("ConfrimTradeLoans", 1);
			 list.add("ProcessRAOFile", 2);
			 list.add("ReconcilePayments", 3);
			 list.add("ProcessSRFDeposits", 4);
			 list.add("ZAR Settlement", 5);			 
			 list.add("BAPS Auto Settlement", 6);
			 list.add("H2H-ZAR Payments", 7);
			 list.add("BAPS AUTO Payments", 8);
			 list.add("BAPS Manual Payments", 9);
			 list.add("BAPS Manual Settlement", 10);
			 			 
		 }
		
		List list_1 = new List(shell, SWT.BORDER);
		list_1.setItems(new String[] {});
		list_1.setBounds(431, 79, 254, 316);
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			
			
				try{
					int s2 = list_1.getFocusIndex();
				    String s3= list_1.getItem(s2);
				    
				   int Index=list.getItemCount();
				    
					list.add(s3,Index);				
					
					list_1.remove(s3);	}catch(Exception e1)   
					
					{
						
						e1.printStackTrace();
					
						
					
					} 
			
			
			}
		});
		btnNewButton_1.setBounds(301, 264, 75, 25);
		btnNewButton_1.setText("Remove Test");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				try{
				int s2 = list.getFocusIndex();
			    String s3= list.getItem(s2);
			    
			    int Index=list_1.getItemCount();
				list_1.add(s3, Index);
				list.remove(s3);	}catch(Exception e1)   
				
				{
					
					e1.printStackTrace();
				
					
				
				} 
				
				
			}
		});
		btnNewButton_2.setBounds(301, 143, 75, 25);
		btnNewButton_2.setText("Select Test");
		ProgressBar progressBar = new ProgressBar(shell, SWT.NONE);
		progressBar.setBounds(82, 452, 533, 17);
		//progressBar.setSelection(40);
		
		Label lblProgress = new Label(shell, SWT.NONE);
		lblProgress.setBounds(20, 454, 55, 15);
		lblProgress.setText("Progress");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		
		
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(txtAbdv.getText().isEmpty())
				
				{
					
					
				Functions.infoBox("Username or Password is missing", "Login Details error");
				
				}
				
				else
				
				{
					
					if(txtDeepak.getText().isEmpty())
						
				{
					
						Functions.infoBox("Username or Password is missing", "Login Details error");
					
				}
				
				else
					
					if(list_1.getItemCount()==0)
					
					{
						
						Functions.infoBox("No Test selected", "Test case selection error");
						
					}
					
					else
					
						if(combo.getText().isEmpty())
						
					{
						
						Functions.infoBox("No Environment Seected", "Environment selection error");
						
					}
					
					else
				
				{
				
					
					
				Functions.userName= txtAbdv.getText();
				Functions.Password=txtDeepak.getText();
				
				
				
				
			
				try {
					
					int Index=list_1.getItemCount();
					
					for(int i=0 ;i<=Index-1;i++)
						
						
					{
						
						String env= combo.getText().toString().trim();
						
						if(env.equals("SIT"))
							
						{
							Functions.Environment=0;
							
							
						}else if(env.equals("UAT"))
							
						{
							
							Functions.Environment=1;
							
						}else{Functions.Environment=2;}
						
						
						Functions.RaoDestionationLocation=Functions.ReadFromExcel(Functions.Environment, 3, 1).trim();
						Functions.MainDBString=Functions.ReadFromExcel(Functions.Environment, 2, 1).trim();
						Functions.WFDBString=Functions.ReadFromExcel(Functions.Environment, 1, 1).trim();
						Functions.AppUrl= Functions.ReadFromExcel(Functions.Environment, 0, 1);
						
						
						
						
						
						
						String TestName= list_1.getItem(i);
						
						
						
						if(TestName.equals("Login Test"))
						
						{
							
							testCases.Login_Test.Test_Login("Test_Login");
							
							
						}
						
						
						if(TestName.equals("ConfrimTradeLoans"))
						{
							
							
							
							testCases.ConfrimTradeLoans.ConfrimTradeLoan("ConfrimTradeLoans");
							
							
						}
						
						
						if(TestName.equals("ProcessRAOFile"))
						{
							
							
							
							testCases.ProcessRAO.ProcessRAOFile("Process RAO File");
							
							
						}
						
						if(TestName.equals("ReconcilePayments"))
						{
							
							
							
							testCases.ReconcilePayements.ReconcilePayments("Reconcile Supplier Payments");
							
							
						}
						if(TestName.equals("ProcessSRFDeposits"))
						{
							
							
							
							testCases.SRF_depositProcess.ProcessDeosits("ProcessSRFDeposits");
							
							
						}
					
						if(TestName.equals("ZAR Settlement"))
						{
							
							
							
							testCases.Zar_Settlement.ZAR_Settle("ZAR Settlement");
							
							
						}
						
					}
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}}});
		btnNewButton.setBounds(732, 444, 75, 25);
		btnNewButton.setText("Run Test");
		
		txtAbdv = new Text(shell, SWT.BORDER);
		txtAbdv.setText("abdv220");
		txtAbdv.setBounds(765, 192, 96, 21);
		
		
		
		txtDeepak = new Text(shell, SWT.BORDER);
		txtDeepak.setText("Deepak@123");
		txtDeepak.setBounds(765, 232, 96, 21);
		
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setBounds(691, 195, 55, 15);
		lblNewLabel_4.setText("UserName");
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setBounds(691, 235, 55, 15);
		lblNewLabel_5.setText("Password");
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBounds(224, 53, 107, 15);
		lblNewLabel_3.setText("Select Environment");
		
	
		
		
		
		
	
	}
}
