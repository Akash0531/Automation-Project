package   com.dikshatech.tst.objectrepository;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.dataprovider.ExcelReadData;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class FBPObjects extends TestBase
{
	@Test
	public FBPObjects(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@FindBy(xpath="//*[@id='myfinancials-link']/a") 			WebElement MyFinancialInfo_Tab;
	@FindBy(xpath="//*[@id='flexibenefit-menu']") 				WebElement FBPTab;
	
	//Create and Submit FBP From Employee
	@FindBy(xpath="//*[@id='fbpNew']") 						WebElement NewFBP;
	@FindBy(xpath="//*[@id='fbpMonthYearHeader']") 			WebElement FBPMMYYYY;
	@FindBy(xpath="//*[@id='unutilized_save']") 			WebElement UnUtilizedAmt;
	@FindBy(xpath="//*[@id='MA']") 							WebElement MedicalAllowance;
	@FindBy(xpath="//*[@id='MV']") 							WebElement MealVocher;
	@FindBy(xpath="//*[@id='referee_comments']") 			WebElement Comments;
	@FindBy(xpath="//*[@id='btnFbpSubmit']") 				WebElement FBPSubmitEmp;
	
	//To Cancel FBP
	@FindBy(xpath="//*[@id='vol_cancel']") 					WebElement FBPCancelButton;
	@FindBy(xpath="//*[@id='fbpCancelComment']") 			WebElement FBPCancelComments;
	@FindBy(xpath="//*[@id='cancelConfirmFbp']") 			WebElement FBPCancelSubmit;
	
	//Finacial Level
	@FindBy(xpath="//*[@id='fbpToHandle']") 				WebElement ToHandle;
	@FindBy(xpath="//*[@id='action_flexi']/i") 				WebElement ActionButton;
	@FindBy(xpath="//*[@id='fbpTohandleEmpName']") 			WebElement EmployeeName;
	@FindBy(xpath="//*[@id='fbpToHandleAssignTo']")		    WebElement AssignToName;
	@FindBy(xpath="//*[@id='cmbFbpToHandleAction']") 		WebElement FBPToHandleAction;
	@FindBy(xpath="//*[@id='fbpToHAndleRemarks']") 			WebElement FBPToHandleRemarks;
	@FindBy(xpath="//*[@onclick='onFbpToHandleSubmit()']") 	WebElement FBPSubmit;
	@FindBy(xpath="//*[@id='flexii_benefit_added']/tbody/tr[1]/td[5]") WebElement statusFinaceLevel;
	
	//For L4 AND L5 Employees 
	@FindBy(xpath="//*[@id='LTA']") 								WebElement LeaveTravelAllowance;
	@FindBy(xpath="//*[@id='TPA']") 								WebElement TelephoneAllowance;
	@FindBy(xpath="//*[@id='CEA']") 								WebElement ChildrenEduAllowance;
	@FindBy(xpath="//*[@id='TRA']") 								WebElement TransSportAllowance;
	
	@FindBy(xpath="//*[@id='flexi_benefit_home']/tbody/tr[1]")		 WebElement selectFBPEmp;
	@FindBy(xpath="//*[@id='flexii_benefit_added']/tbody/tr[1]")	 WebElement selectFBPToHandle;
	@FindBy(xpath="//*[@id='flexi_benefit_home']/tbody/tr[1]/th[4]") WebElement status;
	@FindBy(xpath="//*[@id='main_Content']/div/div[1]/div[2]/button") WebElement backButton;

	
	
	
	

    public void myFinacialTab()
    {
    	MyFinancialInfo_Tab.click(); 
    	Waitfor(1);
    	
    }

    public void flexiBenefitsPlan()
    {
    	FBPTab.click();
    	Waitfor(2);
    }

    public void selectRequestEMP()
    {
    	selectFBPEmp.click();
    	Waitfor(1);
    	
    }
    
    public void clickNewFBP()
    {
    	Waitfor(1);
    	NewFBP.click();
    	Waitfor(2);
    	
    }
    public void selectFBPToHandle()
    {
    	Waitfor(1);
    	selectFBPToHandle.click();
    	Waitfor(1);
    }
    
    
    
    
    // Create  Flexi Benifits Plan From Employee
    
    public void createFBPLevel2Emp(String MA, String MVA,String Commentss)
    {
    	
        String FBPplan=FBPMMYYYY.getText();
        logger.info("The Flexi Benefits Plan For:"+FBPplan);
        Waitfor(2);
        
        String UnUtilizedAmount=UnUtilizedAmt.getText();
        logger.info("The UnUtilized Amount before:"+UnUtilizedAmount);
        Waitfor(2);
        
       // MedicalAllowance.sendKeys(MA);
        Waitfor(2);
        MealVocher.sendKeys(MVA);
        Waitfor(2);
        
        Comments.sendKeys(Commentss);
        Waitfor(2);
        String RemainAmt=UnUtilizedAmt.getText();
        logger.info("The Remaining UnUtilized Amount is:"+RemainAmt);
        
        
    }
    
    public void createFBPLevel4Emp(String LTA,String TPA, String MA, String CEA,String MVA, String TRA, String Commentss )
    {
    	
    try {
    	
    	String FBPplan=FBPMMYYYY.getText();
        logger.info("The Flexi Benefits Plan For:"+FBPplan);
        Waitfor(2);
        
        String UnUtilizedAmount=UnUtilizedAmt.getText();
        logger.info("The UnUtilized Amount before:"+UnUtilizedAmount);
        Waitfor(2);
       // LeaveTravelAllowance.sendKeys(LTA);
        Waitfor(2);
        TelephoneAllowance.sendKeys(TPA);
        Waitfor(2);
       // MedicalAllowance.sendKeys(MA);
        Waitfor(2);
        ChildrenEduAllowance.sendKeys(CEA);
        Waitfor(2);
        MealVocher.sendKeys(MVA);
        Waitfor(2);
        TransSportAllowance.sendKeys(TRA);
        Waitfor(2);
        Comments.sendKeys(Commentss);
        Waitfor(2);
        String RemainAmt=UnUtilizedAmt.getText();
        logger.info("The Remaining UnUtilized Amount is:"+RemainAmt);
		
	} catch (Exception e) {
		logger.info("Failed to fill data");
	}
     
     
    }
    
    public void status()
    {
      String strstatus=status.getText();
      logger.info("The Status once after Take Action is :"+strstatus);
    	
    }
    public void viewFunctionEmp()
    {
    	Waitfor(1);
    	Actions oactions=new Actions(driver);
		oactions.doubleClick(selectFBPEmp).build().perform();
		Waitfor(3);
		backButton.click();
    	
    }
    
    
    // FBP Cancel Functionality
    public void cancelFBP(String CancelComments)
    {
    	FBPCancelButton.click();
    	Waitfor(2);
    	FBPCancelComments.sendKeys("This is the cancel FBP Functionality");
    	Waitfor(1);
    	FBPCancelSubmit.click();
    	Waitfor(2);
    	logger.info("The Flexi Benefits Plan is Cancelled Successfully");
    	
    }
    
    public void clickSubmitEmp()
    {
    	
    	FBPSubmitEmp.click();
    	Waitfor(2);
    	logger.info("FBP is submitted Successfully......!!!!");
    	
    }
    
    
    
    //Ananda assigned level
    
    public void toHandle()
    {
    	ToHandle.click();
    	Waitfor(1);
    }
    
    public void clickAssign()
    {
    	
    	ActionButton.click();
    	Waitfor(1);
    	
    }
    
    public void assigenFunctionality(String RemarkAtAssign)
    {
    	
    	String GetEmpName=EmployeeName.getText();
    	logger.info("The Flexi Benefits Plan for The Employee of:"+GetEmpName);
    	Waitfor(1);
    	Select select=new Select(FBPToHandleAction);
    	select.selectByVisibleText("Assigned");
    	Waitfor(1);
    	FBPToHandleRemarks.sendKeys(RemarkAtAssign);
    	Waitfor(1);
    }
    
   
    public void viewFunctionFinaceLevel()
    {
    	Waitfor(1);
    	selectFBPToHandle.click();
    	Waitfor(1);
    	Actions oactions=new Actions(driver);
		oactions.doubleClick(selectFBPToHandle).build().perform();
		Waitfor(3);
		backButton.click();
    	
    }
    
    
    public void submitClick()
    {
    	Waitfor(2);
    	FBPSubmit.click();
    	Waitfor(2);
    }
    
    public void statusFinaceLevel()
    {
    	String sts=statusFinaceLevel.getText();
    	logger.info("The Status Once after Take Action is : "+sts);
    }
    
    public void inProgressFunctionality(String RemarkAtInProgress)
    {
    	
    	String GetEmpName=EmployeeName.getText();
    	logger.info("The Flexi Benefits Plan for The Employee of:"+GetEmpName);
    	Waitfor(1);
    	Select select=new Select(FBPToHandleAction);
    	select.selectByVisibleText("In-progress");
    	Waitfor(1);
    	FBPToHandleRemarks.sendKeys(RemarkAtInProgress);
    	Waitfor(1);
    }
    
    
    
    // Ananda Processed Level
    
    public void processed(String RemarkatProcess)
    {
    	
    	Waitfor(1);
    	String GetEmpName=EmployeeName.getText();
    	logger.info("The Flexi Benefits Plan for The Employee of:"+GetEmpName);
 
    	Waitfor(1);
    	Select select=new Select(FBPToHandleAction);
    	select.selectByVisibleText("Processed");
    	Waitfor(1);
    	FBPToHandleRemarks.sendKeys(RemarkatProcess);
    	Waitfor(3);
    	
    }
    
}
