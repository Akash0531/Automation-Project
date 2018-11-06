package com.dikshatech.tst.objectrepository;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.dataprovider.ExcelReadData;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;



 public class SalaryReconciliationObjects extends TestBase {
	
	GetterSetter sal= new GetterSetter();
	String reportID= "";
	boolean bTrue = true;
	boolean bFalse = false;
	
	@Test
	public SalaryReconciliationObjects(WebDriver driver)
	{
		this.driver=driver;
	}

	//Salary_Reconciliation page elements repository
	
	@FindBy(xpath = "//lI[@id='salaryRecon']/span") WebElement salaryReconSubmodule;
    @FindBy(xpath="//div[@id='toaster']/span[2]")   WebElement genericToastMsg;
    @FindBy(xpath="//div[@id='main_Content']/div/div[1]/div[1]/div[2]/button")   WebElement backButton;
    @FindBy(xpath="//button[@id='refresh']")   WebElement hardRefresh;

	//Initiate Salary Reconciliation repository
	
	@FindBy(xpath = "//button[@id='initiate_Salary']") WebElement initiateSalary;
	@FindBy(xpath = "//button[@id='salaryyes1']") WebElement initiateSalConfirmmsgYes;
	@FindBy(xpath = "//button[@id='no']") WebElement initiateSalConfirmmsgNo;
	@FindBy(xpath = "//button[@id='salaryyes2']") WebElement reInitiateSalConfirmmsgYes;
	@FindBy(xpath = "//button[@id='no']") WebElement reInitiateSalConfirmmsgNo;
	@FindBy(xpath = "//button[@id='ok']") WebElement salInitiateSuccessMsgOk;
	
	@FindBy(xpath = "//button[@id='downloadReportSal']") WebElement internalReport;
	@FindBy(xpath = "//button[@id='esic']") WebElement ESICStatus;
	@FindBy(xpath = "//button[@id='fbp_status']") WebElement FBPStatus;
	@FindBy(xpath = "//button[@id='rmg_recon']") WebElement RMGReconUpload;
	@FindBy(xpath = "//button[@id='account_recon']") WebElement accountReconUpload;
	@FindBy(xpath = "//button[@id='hdfc_salary']") WebElement HDFCBankReport;
	@FindBy(xpath = "//button[@id='other_salary']") WebElement OtherBankReport;
	
	//Different Salary Tabs
	@FindBy(xpath = "//a[text()='Generated']") WebElement generatedTable;
	@FindBy(xpath = "//a[@id='sal_modified']") WebElement modifiedTable;
	@FindBy(xpath = "//a[@id='sal_hold']") WebElement onHoldTable;
	@FindBy(xpath = "//a[@id='sal_reject']") WebElement rejectedTable;
	
	//Different Salary Landing Page table section	
	@FindBy(xpath = "//span[@id='sal_totalAmount']") WebElement salTotalAmount;
	@FindBy(xpath = "//button[@class='btn btn-primary back-btn']") WebElement backbutton;
	@FindBy(xpath = "//div[@id='salary_home_filter']/label/input") WebElement salaryreportSearchInput;
	@FindBy(xpath = "//div[@id='salaryGeneratedview_filter']/label/input") WebElement generatedSearchInput;
	@FindBy(xpath = "//div[@id='salarymodifiedview_filter']/label/input") WebElement modifiedSearchInput;
	@FindBy(xpath = "//div[@id='salaryholdview_filter']/label/input") WebElement holdSearchInput;
	@FindBy(xpath = "//div[@id='salaryrejectedview_filter']/label/input") WebElement rejectedSearchInput;
	@FindBy(xpath = "//select[@name='salaryGeneratedview_length']") WebElement salaryTableDropdown;
	
	@FindBy(xpath = "//a[@id='salaryGeneratedview_next']") WebElement nextTableButton;
	@FindBy(xpath = "//a[@id='salaryGeneratedview_previous']") WebElement previousTableButton;
   
	@FindBy(xpath = "//button[@id='editSalary']") WebElement editSalaryIcon;
	@FindBy(xpath = "//button[@id='holdperSalary']") WebElement holdSalaryIcon;
	
	//Salary Edit Page
	@FindBy(xpath = "//span[@id='sal_details_of']/h4") WebElement employeeName;
	@FindBy(xpath = "//div[@id='edit_Salary_id']") WebElement netSalary;
	@FindBy(xpath = "//input[@id='salaryPayabledays']") WebElement paybleDays;
	@FindBy(xpath = "//div[@id='lwp_id']") WebElement LWP;
	@FindBy(xpath = "//div[@id='earningsTotal']") WebElement totalEarnAmount;
	@FindBy(xpath = "//div[@id='salarydeductionsTotal']") WebElement totalDeductionAmount;
	@FindBy(xpath = "//textarea[@id='comments']") WebElement salaryComments;
	@FindBy(xpath = "//a[@id='salaryGeneratedview_previous']") WebElement salaryCycleDD;
	@FindBy(xpath = "//button[@onclick='saveEditedSalaryData()']") WebElement salarySaveButton;
	
	//Salary View Page
	@FindBy(xpath = "//div[@id='info_header']/h4") WebElement ViewEmployee_name;
	@FindBy(xpath = "//span[@id='info_Salary_id']") WebElement ViewNet_Salary;
	@FindBy(xpath = "//span[@id='info_pay_days']") WebElement ViewPayble_Days;
	@FindBy(xpath = "//span[@id='info_earningsTotal']") WebElement ViewTotalEarnings_Amount;
	@FindBy(xpath = "//span[@id='Salarycomment']") WebElement ViewSalary_Comments;
	@FindBy(xpath = "//div[@id='genericModal-buttons']/button") WebElement ViewSalary_Close_Button;
			
	//Hold employee salary
	@FindBy(xpath = "//button[@id='hold_salary']") WebElement Hold_Button;
	@FindBy(xpath = "//textarea[@id='sh_comment']") WebElement HoldComment_Box;
	@FindBy(xpath = "//div[@id='genericModal-buttons']/button[2]") WebElement Holdpopup_CloseButton;
	
	//Release employee salary
	@FindBy(xpath = "//button[@id='releseempsalry']") WebElement ReleaseSalary_Icon;
	@FindBy(xpath = "//button[@id='releseempsalry']") WebElement ReleaseComment_Box;
	@FindBy(xpath = "//button[@id='release_emp_salry']") WebElement Release_Button;
	@FindBy(xpath = "//div[@id='genericModal-buttons']/button[2]") WebElement CloseButton;
	
	//Reject employee salary
	@FindBy(xpath = "//button[@id='rejectperSalary']") WebElement RejectSalary_Icon;
	@FindBy(xpath = "//textarea[@id='rejectsal_comment']") WebElement RejectComment_Box;
	@FindBy(xpath = "//button[@id='reject1_salary']") WebElement Reject_Button;
	
	//Lead RMG
	@FindBy(xpath = "//button[@id='sal_approve']") WebElement SalaryApprove_Button;
	@FindBy(xpath = "//button[@id='sal_submit']") WebElement Salarysubmit_Button;
	@FindBy(xpath = "//button[@id='sal_rejected']") WebElement SalaryReject_Button;

	@FindBy(xpath = "//button[@id='sal_complete']") WebElement Complete_Salary;
	@FindBy(xpath = "//textarea[@id='s_comment']") WebElement Complete_SalaryComments;
	@FindBy(xpath = "//button[@id='complete_salary']") WebElement Complete_Submit_Button;
	@FindBy(xpath = "//div[@id='genericModal-buttons']/button[2]") WebElement Complete_Close_Button;
	
	//HDFC Bank Reports
	
	@FindBy(xpath = "//button[@id='hdfc_salary']") WebElement DownloadHDFC_Icon;
	@FindBy(xpath = "//select[@id='hdfcCompany']") WebElement HDFC_Company;
	@FindBy(xpath = "//select[@id='hdfcregion']") WebElement HDFC_Region;
	@FindBy(xpath = "//select[@id='hdfcDep']") WebElement HDFC_Department;
	@FindBy(xpath = "//button[@id='hdfcsalaryDownloadId']") WebElement DownldHDFCReport_Button;
	@FindBy(xpath = "//button[@id='hdfcsalaryPayId']") WebElement DownloadHDFC_PayButton;
	@FindBy(xpath = "//button[@id='hdfcsalaryUploadId']") WebElement DownloadHDFC_UploadButton;
	@FindBy(xpath = "//div[@id='genericModal-buttons']/button[4]") WebElement DownloadHDFC_Close_Button;
	@FindBy(xpath = "//input[@id='uploadfileName']") WebElement UploadHDFC_BrowseButton;
	@FindBy(xpath = "//textarea[@id='upload_comment']") WebElement UploadHDFC_Filedescription;
	@FindBy(xpath = "//button[@id='hdfcsalaryUploadId1']") WebElement UploadHDFC_uploadbutton;
	@FindBy(xpath = "//div[@id='genericModal-buttons']/button[2]") WebElement UploadHDFC_Closebutton;
	@FindBy(xpath = "//textarea[@id='upload_comment']") WebElement DownloadHDFC_Comments;
	@FindBy(xpath = "//button[@id='salAction']") WebElement DownloadHDFC_Submit_Button;
	@FindBy(xpath = "//button[@id='salAction']") WebElement UploadHDFC_uploadstatus;
	@FindBy(xpath = "//div[@id='salary_hdfc_report_filter']/label/input") WebElement HDFC_SearchBox;
	@FindBy(xpath = "//input[@id='sal_select_all']") WebElement HDFC_SelectAll;
	@FindBy(xpath = "//input[@id='sal_reason']") WebElement HDFC_NonPayReason;
	@FindBy(xpath = "//input[@id='sal_Date']") WebElement HDFC_NonPaymentDate;	
	@FindBy(xpath = "//button[@id='salaryunpaidid']") WebElement HDFC_NonPaySaveButton;	
	@FindBy(xpath = "//div[@id='genericModal-buttons']/button[2]") WebElement HDFC_NonPayCloseButton;	

	// Other Bank Reports
	
	@FindBy(xpath = "//button[@id='other_salary']") WebElement OtherBank_Icon;
	@FindBy(xpath = "//select[@id='hdfcCompany']") WebElement OtherBank_Company;
	@FindBy(xpath = "//select[@id='hdfcregion']") WebElement OtherBank_Region;
	@FindBy(xpath = "//select[@id='hdfcDep']") WebElement OtherBank_Department;
	@FindBy(xpath = "//button[@id='otherBanksalaryDownloadId']") WebElement DownldOther_ReportButton;
	@FindBy(xpath = "//button[@id='otherBanksalaryPayId']") WebElement OtherBank_PayButton;
	@FindBy(xpath = "//button[@id='otherBanksalaryUploadId']") WebElement OtherBank_UploadButton;
	@FindBy(xpath = "//div[@id='genericModal-buttons']/button[4]") WebElement OtherBank_Close_Button;
	@FindBy(xpath = "//input[@id='uploadfileName']") WebElement OtherBankupload_BrowseButton;
	@FindBy(xpath = "//textarea[@id='upload_comment']") WebElement OtherBankupload_comments;
	@FindBy(xpath = "//button[@id='otherBanksalaryUploadId1']") WebElement OtherBankupload_uploadbutton;
	@FindBy(xpath = "//div[@id='genericModal-buttons']/button[2]") WebElement OtherBankupload_closebutton;
	@FindBy(xpath = "//div[@id='salary_othr_report_filter']/label/input") WebElement Other_SearchBox;
	@FindBy(xpath = "//input[@id='sal_select_all']") WebElement Other_SelectAll;

	/**
	 * Salary Reconciliation Module
	 **/
	public void salaryReconsubmodule() {
		salaryReconSubmodule.click();
		Waitfor(2);
	}

	/**
	 * Salary Initiation button validation
	 **/
	public void initiatesalary() {
		boolean initbutton = initiateSalary.isDisplayed();
		if (initbutton == bTrue) {
			boolean initiatebutton = initiateSalary.isEnabled();
			if (initiatebutton == bTrue) {
				initiateSalary.click();
				Waitfor(1);
			} else {
				logger.info("The Initiate Salary button is not enabled");
			}
		} else {
			logger.info("The Initiate Salary button is not displayed");
		}
	}

	/**
	 * Salary Initiation Yes button validation
	 **/
	public void initiatesalary_MsgYes() {
		boolean yesstatus = initiateSalConfirmmsgYes.isDisplayed();
		if (yesstatus == bTrue) {
			boolean yesbutton = initiateSalConfirmmsgYes.isEnabled();
			if (yesbutton == bTrue) {
				initiateSalConfirmmsgYes.click();
				Waitfor(1);
			} else {
				logger.info("The Yes button is not enabled");
			}
		} else {
			logger.info("The Yes button is not displayed");
		}
	}

	/**
	 * Salary Initiation No button validation
	 **/
	public void initiatesalary_MsgNo() {
		boolean nostatus = initiateSalConfirmmsgNo.isDisplayed();
		if (nostatus == bTrue) {
			boolean nobutton = initiateSalConfirmmsgNo.isEnabled();
			if (nobutton == bTrue) {
				initiateSalConfirmmsgNo.click();
				Waitfor(1);
			} else {
				logger.info("The NO button is not enabled");
			}
		} else {
			logger.info("The No button is not displayed");
		}
	}

	/**
	 * Salary Re-initiation Yes button validation
	 **/
	public void re_initiatesalaryMsgYes() {
		boolean reyesstatus = reInitiateSalConfirmmsgYes.isDisplayed();
		if (reyesstatus == bTrue) {
			boolean reyesbutton = reInitiateSalConfirmmsgYes.isEnabled();
			if (reyesbutton == bTrue) {
				reInitiateSalConfirmmsgYes.click();
				Waitfor(1);
			} else {
				logger.info("The Re-Yes button is not enabled");
			}
		} else {
			logger.info("The Re-Yes button is not displayed");
		}
	}

	/**
	 * Salary Re-initiation No button validation
	 **/
	public void re_initiatesalary_MsgNo() {
		boolean renostatus = reInitiateSalConfirmmsgNo.isDisplayed();
		if (renostatus == bTrue) {
			boolean renobutton = reInitiateSalConfirmmsgNo.isEnabled();
			if (renobutton == bTrue) {
				reInitiateSalConfirmmsgNo.click();
				Waitfor(1);
			} else {
				logger.info("The Re-NO button is not enabled");
			}
		} else {
			logger.info("The Re-No button is not displayed");
		}
	}

	/**
	 * Salary module HDFC Bank report
	 **/
	public void hdfcbankreportbutton() {
		HDFCBankReport.click();
		Waitfor(1);
	}

	/**
	 * Salary module Other Bank report
	 **/
	public void otherbankreport_button() {
		OtherBankReport.click();
		Waitfor(1);
	}
	
	/**
	 * Salary Approve button validation
	 **/
	public void salary_Approve() {
		Waitfor(3);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)", "");
		boolean approvestatus = SalaryApprove_Button.isDisplayed();
		if (approvestatus == bTrue) {
			Waitfor(1);
			boolean approvebutton = SalaryApprove_Button.isEnabled();
			if (approvebutton == bTrue) {
				SalaryApprove_Button.click();
				Waitfor(3);
				String approvetoastmsg = genericToastMsg.getText();
				if (approvetoastmsg.equalsIgnoreCase("Salary Approved Succesfully")) {
					logger.info("Approve button has proper validation along with the toast message");
				} else {
					logger.info("Approve button toast meesage is either not proper or not displayed");
				}
			} else {
				logger.info("The Approve button is not enabled");
			}
		} else {
			logger.info("The Approve button is not displayed");
		}

	}

	/**
	 * Salary Reject button validation
	 **/
	public void salary_Reject() {
		boolean rejectstatus = SalaryReject_Button.isDisplayed();
		if (rejectstatus == bTrue) {
			boolean rejectbutton = SalaryReject_Button.isEnabled();
			if (rejectbutton == bTrue) {
				SalaryReject_Button.click();
				Waitfor(2);
			} else {
				logger.info("The Reject button is not enabled");
			}
		} else {
			logger.info("The Reject button is not displayed");
		}
	}

	/**
	 * Salary Reject icon button validation
	 **/ 
	public void rejecticon() {
		boolean rejectstatus = RejectSalary_Icon.isDisplayed();
		if (rejectstatus == bTrue) {
			boolean rejectbutton = RejectSalary_Icon.isEnabled();
			if (rejectbutton == bTrue) {
				RejectSalary_Icon.click();
				Waitfor(2);
			} else {
				logger.info("The Reject button is not enabled");
			}
		} else {
			logger.info("The Reject button is not displayed");
		}

	}

	/**
	 * Salary Rejection for any specific resource comments field validation
	 **/ 
	public void reject_comments(String comments) {
		String rejToastmsg=rejectbutton();
		if(rejToastmsg.equalsIgnoreCase("")) {
			logger.info("Reject Comment field is perfectly validated");
		}else {
			logger.info("Reject Comment field is not properly validated");
		}
		boolean rejectcommnt = RejectComment_Box.isEnabled();
		if (rejectcommnt == bTrue) {
			RejectComment_Box.sendKeys(Keys.chord(Keys.CONTROL, "a"), comments);
			Waitfor(1);
		} else {
			logger.info("The Reject comment box is not enabled");
		}
	}

	/**
	 * Salary Rejection for any specific resource Reject button validation
	 **/ 
	public void rejectbuttonvalidation() {
		boolean rejectstatus = Reject_Button.isDisplayed();
		if (rejectstatus == bTrue) {
			boolean rejectbutton = Reject_Button.isEnabled();
			if (rejectbutton == bTrue) {
				Reject_Button.click();
				Waitfor(4);
				String rejecttoastmsg = genericToastMsg.getText();
				boolean rejectionsts = RejectSalary_Icon.isEnabled();
				if (rejecttoastmsg.equalsIgnoreCase("Salary Rejected Succesfully") && rejectionsts == bFalse) {
					logger.info("Reject functionality has been perfectly validated with proper toast message");
				} else {
					logger.info("Reject functionality has not been validated properly");
				}
			} else {
				logger.info("The Reject Button is not enabled");
			}
		} else {
			logger.info("The Reject Button is not displayed");
		}
	}

	/**
	 * Salary Rejection for any specific resource Reject button toast message validation
	 **/ 
	public String rejectbutton() {
		Reject_Button.click();
		String rejecttoastmsg = genericToastMsg.getText();
		return rejecttoastmsg;
	}

	/**
	 * Salary report landing page Next pagination
	 **/
	public void next_Table() {
		boolean status = nextTableButton.isEnabled();
		if (status == bTrue) {
			nextTableButton.click();
		} else {
			logger.info("Next button is not enabled");
		}
	}

	/**
	 * Salary report landing page Previous pagination
	 **/
	
	public void previous_Table() {
		boolean status = previousTableButton.isEnabled();
		if (status == bTrue) {
			previousTableButton.click();
		} else {
			logger.info("Previous button is not enabled");
		}
	}

	/**
	 * Salary Edit/Modify for any specific resource edit button validation
	 **/ 
	public void salaryedit_button() {
		boolean editstatus = editSalaryIcon.isDisplayed();
		if (editstatus == bTrue) {
			boolean editbutton = editSalaryIcon.isEnabled();
			if (editbutton == bTrue) {
				editSalaryIcon.click();
				Waitfor(2);
			} else {
				logger.info("The Edit button is not enabled");
			}
		} else {
			logger.info("The Edit button is not displayed");
		}
	}

	/**
	 *  Modification comments in Edit/Modify popup for any specific resource.
	 **/
	public void edit_Salarycomments(String comments) {
		salaryComments.sendKeys(Keys.chord(Keys.CONTROL, "a"), comments);
	}

	/**
	 * Salary Edit/Modify for any specific resource Save button validation
	 **/ 
	public void salaryedit_Save() {
		boolean savestatus = salarySaveButton.isDisplayed();
		if (savestatus == bTrue) {
			boolean savebutton = salarySaveButton.isEnabled();
			if (savebutton == bTrue) {
				salarySaveButton.click();
				Waitfor(2);
			} else {
				logger.info("The Save button is not enabled");
			}
		} else {
			logger.info("The Save button is not displayed");
		}
	}
	
	/**
	 * Salary Edit/Modify for any specific resource Close button
	 **/ 
	public void salaryedit_close() {
		ViewSalary_Close_Button.click();
		Waitfor(2);
	}

	
	/**
	 * Salary Hold icon validation for any specific resource 
	 **/ 
	public void salary_hold() {
		boolean holdstatus = holdSalaryIcon.isDisplayed();
		if (holdstatus == bTrue) {
			boolean holdicon = holdSalaryIcon.isEnabled();
			if (holdicon == bTrue) {
				holdSalaryIcon.click();
				Waitfor(2);
			} else {
				logger.info("The Hold Icon is not enabled");
			}
		} else {
			logger.info("The Hold Icon is not displayed");
		}

	}

	/**
	 *  Hold comments in Hold popup for any specific resource.
	 **/
	public void hold_comments(String comments) {
		String holdToastmsg=holdbutton();
		if(holdToastmsg.equalsIgnoreCase("")) {
			logger.info("Hold Comment field is perfectly validated");
		}else {
			logger.info("Hold Comment field is not properly validated");
		}
		boolean holdcommnt = HoldComment_Box.isEnabled();
		if (holdcommnt == bTrue) {
			HoldComment_Box.sendKeys(Keys.chord(Keys.CONTROL, "a"), comments);
			Waitfor(1);
		} else {
			logger.info("The Hold comment box is not enabled");
		}
	}

	/**
	 * Salary Hold successfully validation in Hold popup for any specific resource.
	 **/
	public void holdbuttonvalidation() {
		boolean holdstatus = Hold_Button.isDisplayed();
		if (holdstatus == bTrue) {
			boolean holdbutton = Hold_Button.isEnabled();
			if (holdbutton == bTrue) {
				Hold_Button.click();
				Waitfor(4);
				String holdtoastmsg = genericToastMsg.getText();
				boolean holdiconstatus = holdSalaryIcon.isEnabled();
				if (holdtoastmsg.equalsIgnoreCase("Salary Hold Succesfully") && holdiconstatus == bFalse) {
					logger.info("Hold functionality has been perfectly validated with proper toast message");
				} else {
					logger.info("Hold functionality has not been validated properly");
				}
			} else {
				logger.info("The Hold Button is not enabled");
			}
		} else {
			logger.info("The Hold Button is not displayed");
		}
	}

	/**
	 * Salary Hold button in hold popup validation.
	 **/
	public String holdbutton() {
		Hold_Button.click();
		String holdtoastmsg = genericToastMsg.getText();
		return holdtoastmsg;
	}

	/**
	 * Salary Hold-- Cancel button in hold popup
	 **/
	public void hold_cancel() {
		Holdpopup_CloseButton.click();
	}
	
	/**
	 *  Salary Reconciliation view page Validations
	 */
	public void viewsalcalculationvalidation() {
		String empname = employeeName.getText();
		String salaryvalue = netSalary.getText();
		String paydays = paybleDays.getText();
		String lwp = LWP.getText();
		/**
		 * setting the basic salary details
		 */
		sal.setEmp_name(empname);
		sal.setSalary_value(salaryvalue);
		sal.setPay_days(paydays);
		sal.setLwp(lwp);
	}

	/**
	 *  Salary Reconciliation generated report Validations in the Generated Tab. 
	 */
	public String salary_generatedtable(String empname) {
		generatedTable.click();
		Waitfor(1);
		generatedSearchInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), empname);
		Waitfor(1);

		String fail = "";
		Actions action = new Actions(driver);
		int count = 0;
		String coltext = "Emp Name";
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='salaryGeneratedview_paginate']/span/a"));
		if (page.size() > 0) {
			for (int i = 1; i <= page.size(); i++) {
				if (i > 1) {
					driver.findElement(By.xpath("//div[@id='salaryGeneratedview_paginate']/span/a[" + (i) + "]"))
							.click();
					Waitfor(1);
				}
				WebElement table = driver.findElement(By.xpath("//table[@id='salaryGeneratedview']/thead/tr"));
				List<WebElement> heading = table.findElements(By.tagName("th"));
				for (int h = 0; h < heading.size(); h++) {
					String text = heading.get(h).getText();
					if (coltext.equalsIgnoreCase(text)) {
						int col = h;
						WebElement rowtable = driver.findElement(By.xpath("//table[@id='salaryGeneratedview']/tbody"));
						List<WebElement> rows = rowtable.findElements(By.tagName("tr"));
						for (int c = 1; c <= rows.size(); c++) {

							String cellValue = driver.findElement(By.xpath(
									"//table[@id='salaryGeneratedview']/tbody/tr[" + c + "]/td[" + (col + 1) + "]"))
									.getText();
							Waitfor(1);

							if (cellValue.equalsIgnoreCase(empname)) {

								WebElement employee = driver.findElement(
										By.xpath("//table[@id='salaryGeneratedview']/tbody/tr[" + c + "]/td[2]"));
								action.click(employee).build().perform();
								logger.info(empname + " record found in Generated Table");
								count++;
								break;
							} else {
								fail = "Not found";
							}
							if (count > 0) {
								break;
							}
						}

					}
					if (count > 0) {
						break;
					}
				}

			}

		} else {
			logger.info(empname + " record not found in Generated Table");
			fail = "Not found";
		}
		return fail;
	}

	/**
	 *  Salary Reconciliation generated report Validations in the Modified tab.
	 */
	public String salary_modifiedtable(String empname) {
		modifiedTable.click();
		Waitfor(1);
		modifiedSearchInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), empname);
		Waitfor(1);

		String fail = "";
		Actions action = new Actions(driver);
		int count = 0;
		String coltext = "Emp Name";
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='salarymodifiedview_paginate']/span/a"));
		if (page.size() > 0) {
			for (int i = 1; i <= page.size(); i++) {
				if (i > 1) {
					driver.findElement(By.xpath("//div[@id='salarymodifiedview_paginate']/span/a[" + (i) + "]"))
							.click();
					Waitfor(1);
				}
				WebElement table = driver.findElement(By.xpath("//table[@id='salarymodifiedview']/thead/tr"));
				List<WebElement> heading = table.findElements(By.tagName("th"));
				for (int h = 0; h < heading.size(); h++) {
					String text = heading.get(h).getText();
					if (coltext.equalsIgnoreCase(text)) {
						int col = h;
						WebElement rowtable = driver.findElement(By.xpath("//table[@id='salarymodifiedview']/tbody"));
						List<WebElement> rows = rowtable.findElements(By.tagName("tr"));
						logger.info(rows.size());
						for (int c = 1; c <= rows.size(); c++) {

							String cellValue = driver.findElement(By.xpath(
									"//table[@id='salarymodifiedview']/tbody/tr[" + c + "]/td[" + (col + 1) + "]"))
									.getText();
							Waitfor(1);

							if (cellValue.equalsIgnoreCase(empname)) {

								WebElement employee = driver.findElement(
										By.xpath("//table[@id='salarymodifiedview']/tbody/tr[" + c + "]/td[2]"));
								action.click(employee).build().perform();
								logger.info(empname + " record found in Modified Table");
								count++;

								break;
							} else {
								logger.info(empname + " record not found in Modified Table");
								fail = "Not found";
							}
						}
						if (count > 0) {
							break;
						}
					}
				}
				if (count > 0) {
					break;
				}
			}
		} else {
			fail = "Not found";
		}
		return fail;
	}

	/**
	 *  Salary Reconciliation generated report Validations in the Hold tab.
	 */
	public String salary_holdtable(String empname) {
		onHoldTable.click();
		Waitfor(1);
		holdSearchInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), empname);
		Waitfor(1);

		String fail = "";
		Actions action = new Actions(driver);
		int count = 0;
		String coltext = "Emp Name";
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='salaryholdview_paginate']/span/a"));
		if (page.size() > 0) {
			for (int i = 1; i <= page.size(); i++) {
				if (i > 1) {
					driver.findElement(By.xpath("//div[@id='salaryholdview_paginate']/span/a[" + (i) + "]")).click();
					Waitfor(1);
				}
				WebElement table = driver.findElement(By.xpath("//table[@id='salaryholdview']/thead/tr"));
				List<WebElement> heading = table.findElements(By.tagName("th"));
				for (int h = 0; h < heading.size(); h++) {
					String text = heading.get(h).getText();
					if (coltext.equalsIgnoreCase(text)) {
						int col = h;
						WebElement rowtable = driver.findElement(By.xpath("//table[@id='salaryholdview']/tbody"));
						List<WebElement> rows = rowtable.findElements(By.tagName("tr"));
						logger.info(rows.size());
						for (int c = 1; c <= rows.size(); c++) {

							String cellValue = driver
									.findElement(By.xpath(
											"//table[@id='salaryholdview']/tbody/tr[" + c + "]/td[" + (col + 1) + "]"))
									.getText();
							Waitfor(1);

							if (cellValue.equalsIgnoreCase(empname)) {

								WebElement employee = driver.findElement(
										By.xpath("//table[@id='salaryholdview']/tbody/tr[" + c + "]/td[2]"));
								action.click(employee).build().perform();
								logger.info(empname + " record found in HOLD Table");
								count++;

								break;
							} else {
								logger.info(empname + " record not found in HOLD Table");
								fail = "Not found";
							}
						}
						if (count > 0) {
							break;
						}
					}
				}
				if (count > 0) {
					break;
				}
			}

		} else {
			fail = "Not found";
		}
		return fail;
	}

	/**
	 *  Salary Reconciliation generated report Validations in the Rejected tab.
	 */
	public String salary_rejectedtable(String empname) {
		rejectedTable.click();
		Waitfor(1);
		rejectedSearchInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), empname);
		Waitfor(1);

		String fail = "";
		Actions action = new Actions(driver);
		int count = 0;
		String coltext = "Emp Name";
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='salaryrejectedview_paginate']/span/a"));
		if (page.size() > 0) {
			for (int i = 1; i <= page.size(); i++) {
				if (i > 1) {
					driver.findElement(By.xpath("//div[@id='salaryrejectedview_paginate']/span/a[" + (i) + "]"))
							.click();
					Waitfor(1);
				}
				WebElement table = driver.findElement(By.xpath("//table[@id='salaryrejectedview']/thead/tr"));
				List<WebElement> heading = table.findElements(By.tagName("th"));
				for (int h = 0; h <= heading.size(); h++) {
					String text = heading.get(h).getText();
					if (coltext.equalsIgnoreCase(text)) {
						int col = h;
						WebElement rowtable = driver.findElement(By.xpath("//table[@id='salaryrejectedview']/tbody"));
						List<WebElement> rows = rowtable.findElements(By.tagName("tr"));
						logger.info(rows.size());
						for (int c = 1; c <= rows.size(); c++) {

							String cellValue = driver.findElement(By.xpath(
									"//table[@id='salaryrejectedview']/tbody/tr[" + c + "]/td[" + (col + 1) + "]"))
									.getText();
							Waitfor(1);

							if (cellValue.equalsIgnoreCase(empname)) {

								WebElement employee = driver.findElement(
										By.xpath("//table[@id='salaryrejectedview']/tbody/tr[" + c + "]/td[2]"));
								action.click(employee).build().perform();
								logger.info(empname + " record found in Rejected Table");
								count++;

								break;
							} else {
								logger.info(empname + " record not found in Rejected Table");
								fail = "Not found";
							}
						}
						if (count > 0) {
							break;
						}
					}
				}
				if (count > 0) {
					break;
				}
			}

		} else {
			fail = "Not found";
		}
		return fail;
	}

	/**
	 *  Salary Reconciliation total earning calculation with Validations in the edit page.
	 */
	public float totalearnings_calculation(int rownum) {
		int monthdays = 31;
		String employee = excelreaddata().getData("SalaryRecon_Sheet", rownum, 0);
		String empname = employeeName.getText();
		String[] ename = empname.trim().split("\\s+");
		String employeename = ename[3] + " " + ename[4];
		if (employee.equalsIgnoreCase(employeename)) {
			logger.info("The Employee name is matching with the excel data");
		} else {
			logger.info("The Employee name is not matching with the excel");
		}

		String excellWP = excelreaddata().getData("SalaryRecon_Sheet", rownum, 1);
		float l = (Float.valueOf(excellWP)).floatValue();

		String excelctc = excelreaddata().getData("SalaryRecon_Sheet", rownum, 3);
		float ctc = (Float.valueOf(excelctc)).floatValue();

		/**
		 * Per day basic salary calculation
		 */
		double basicAmount = ctc * (.3) / 12;
		double perdaybasic = basicAmount / monthdays;

		String paydays = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.getElementById('salaryPayabledays').value");
		float paiddays = (Float.valueOf(paydays)).floatValue();

		float lwp = (Float.valueOf(LWP.getText())).floatValue();

		/**
		 * LWP, Payable days with Basic Salary validation
		 */
		double actbasicsalary = 0;
		if (l == lwp) {
			float payabledays = monthdays - lwp;

			if (payabledays == paiddays) {
				logger.info("The payable days is correct");
				actbasicsalary = perdaybasic * paiddays;
				String bsalary = driver
						.findElement(By.xpath("//table[@id='edit_salary_earnings']/tbody/tr[1]/td[3]/input"))
						.getAttribute("value");
				double basicsalary = (Float.valueOf(bsalary)).floatValue();
				if (actbasicsalary == basicsalary) {
					logger.info("Basic salary is calculated perfectly");
				} else {
					logger.info("Basic salary has some worng calculation");
				}
			} else {
				logger.info("The payable days is incorrect");
			}
		} else {
			logger.info("The LWP value is wrong please verify it");
		}

		float tearning = (Float.valueOf(totalEarnAmount.getText())).floatValue();

		String[] value = new String[12];
		String[] array = { "Basic", "Conveyance", "HRA", "Addt allowances", "Addt allowances", "Leave Travel Allow",
				"Telephone Allowance", "Medical Allowance", "Child Care Allowance", "Meal Allowance",
				"Transport Allowance", "Other Allowance" };
		WebElement rowtable = driver.findElement(By.xpath("//table[@id='edit_salary_earnings']/tbody"));
		List<WebElement> rows = rowtable.findElements(By.tagName("tr"));
		logger.info(rows.size());
		/**
		 *  Traversing the Total salary earning table in the Edit page
		 */
		for (int c = 1; c <= rows.size(); c++) {
			/**
			 *  Fetching dynamic salary components individually from Edit page.
			 */
			String cellValue = driver
					.findElement(By.xpath("//table[@id='edit_salary_earnings']/tbody/tr[" + c + "]/td[1]/input"))
					.getAttribute("value");
			/**
			 *  All static & dynamic salary components value validation 
			 */
			if (cellValue.equalsIgnoreCase(array[0])) {
				value[0] = driver
						.findElement(By.xpath("//table[@id='edit_salary_earnings']/tbody/tr[" + c + "]/td[3]/input"))
						.getAttribute("value");
				float basic = (Float.valueOf(value[0])).floatValue();
				if (basic == actbasicsalary) {
					logger.info("The monthly basic salary is correct and verified");
				} else {
					logger.info("The monthly basic salary is not correct and could impact the salary calucation");
				}

			} else if (cellValue.equalsIgnoreCase(array[1])) {
				value[1] = driver
						.findElement(By.xpath("//table[@id='edit_salary_earnings']/tbody/tr[" + c + "]/td[3]/input"))
						.getAttribute("value");
			} else if (cellValue.equalsIgnoreCase(array[2])) {
				value[2] = driver
						.findElement(By.xpath("//table[@id='edit_salary_earnings']/tbody/tr[" + c + "]/td[3]/input"))
						.getAttribute("value");
			} else if (cellValue.equalsIgnoreCase(array[3])) {
				value[3] = driver
						.findElement(By.xpath("//table[@id='edit_salary_earnings']/tbody/tr[" + c + "]/td[3]/input"))
						.getAttribute("value");
			} else if (cellValue.equalsIgnoreCase(array[4])) {
				value[4] = driver
						.findElement(By.xpath("//table[@id='edit_salary_earnings']/tbody/tr[" + c + "]/td[3]/input"))
						.getAttribute("value");
			} else if (cellValue.equalsIgnoreCase(array[5])) {
				value[5] = driver
						.findElement(By.xpath("//table[@id='edit_salary_earnings']/tbody/tr[" + c + "]/td[3]/input"))
						.getAttribute("value");
			} else if (cellValue.equalsIgnoreCase(array[6])) {
				value[6] = driver
						.findElement(By.xpath("//table[@id='edit_salary_earnings']/tbody/tr[" + c + "]/td[3]/input"))
						.getAttribute("value");
			} else if (cellValue.equalsIgnoreCase(array[7])) {
				value[7] = driver
						.findElement(By.xpath("//table[@id='edit_salary_earnings']/tbody/tr[" + c + "]/td[3]/input"))
						.getAttribute("value");
			} else if (cellValue.equalsIgnoreCase(array[8])) {
				value[8] = driver
						.findElement(By.xpath("//table[@id='edit_salary_earnings']/tbody/tr[" + c + "]/td[3]/input"))
						.getAttribute("value");
			} else if (cellValue.equalsIgnoreCase(array[9])) {
				value[9] = driver
						.findElement(By.xpath("//table[@id='edit_salary_earnings']/tbody/tr[" + c + "]/td[3]/input"))
						.getAttribute("value");
			} else if (cellValue.equalsIgnoreCase(array[10])) {
				value[10] = driver
						.findElement(By.xpath("//table[@id='edit_salary_earnings']/tbody/tr[" + c + "]/td[3]/input"))
						.getAttribute("value");
			} else if (cellValue.equalsIgnoreCase(array[11])) {
				value[11] = driver
						.findElement(By.xpath("//table[@id='edit_salary_earnings']/tbody/tr[" + c + "]/td[3]/input"))
						.getAttribute("value");
			} else {
				logger.info("");
			}

		}
		
		/**
		 * Total earned salary based on dynamic components
		 */
		float totalearned_amount = 0;
		for (int i = 0; i < value.length; i++) {
			if ((value[i] != null)) {
				totalearned_amount = ((Float.valueOf(totalearned_amount)).floatValue())
						+ ((Float.valueOf(value[i])).floatValue());
			}
		}

		/**
		 * Total earned salary validation based on dynamic components
		 */
		if (totalearned_amount == tearning) {
			logger.info("The Total earning calculation is based on the provided components is correct");
		} else {
			logger.info(
					"The Total earning calculation is based on the provided components is not correct, please verify it manually once");
		}

		return totalearned_amount;
	}

	/**
	 *  Salary Reconciliation total deductions calculation with Validations in the edit page.
	 */
	public float totaldeductions_calculation(int rownum) {
		int monthdays = 31;
		String ESIC = excelreaddata().getData("SalaryRecon_Sheet", rownum, 4);
		String employee = excelreaddata().getData("SalaryRecon_Sheet", rownum, 0);
		String empname = employeeName.getText();
		String[] ename = empname.trim().split("\\s+");
		String employeename = ename[3] + " " + ename[4];
		if (employee.equalsIgnoreCase(employeename)) {
			logger.info("The Employee name is matching with the excel data");

		} else {
			logger.info("The Employee name is not matching with the excel");
		}
		String l_W_P = excelreaddata().getData("SalaryRecon_Sheet", rownum, 1);
		float l = (Float.valueOf(l_W_P)).floatValue();

		String excelctc = excelreaddata().getData("SalaryRecon_Sheet", rownum, 3);
		float ctc = (Float.valueOf(excelctc)).floatValue();

		/**
		 * Per day basic salary calculation
		 */
		double basicAmount = ctc * (.3) / 12;
		double perdaybasic = basicAmount / monthdays;

		String paydays = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.getElementById('salaryPayabledays').value");
		float paiddays = (Float.valueOf(paydays)).floatValue();

		float lwp = (Float.valueOf(LWP.getText())).floatValue();

		/**
		 * LWP, Payable days with Basic Salary validation
		 */
		double actbasicsalary = 0;
		if (l == lwp) {
			float payabledays = monthdays - lwp;

			if (payabledays == paiddays) {
				logger.info("The payable days is correct");
				actbasicsalary = perdaybasic * paiddays;
				String bsalary = driver
						.findElement(By.xpath("//table[@id='edit_salary_earnings']/tbody/tr[1]/td[3]/input"))
						.getAttribute("value");
				double basicsalary = (Float.valueOf(bsalary)).floatValue();
				if (actbasicsalary == basicsalary) {
					logger.info("Basic salary is calculated perfectly");
				} else {
					logger.info("Basic salary has some worng calculation");
				}
			} else {
				logger.info("The payable days is incorrect");
			}
		} else {
			logger.info("The LWP value is wrong please verify it");
		}

		float tearning = (Float.valueOf(totalEarnAmount.getText())).floatValue();
		float tdeduction = (Float.valueOf(totalDeductionAmount.getText())).floatValue();

		String[] value = new String[9];
		String[] array = { "ESIC", "Professional Tax", "TDS", "Sodexo", "Provident Fund", "VPF", "Salary In Advance",
				"Travel In Advance", "Perdiem In Advance" };
		WebElement rowtable = driver.findElement(By.xpath("//table[@id='edit_salary_deductions']/tbody"));
		List<WebElement> rows = rowtable.findElements(By.tagName("tr"));
		logger.info(rows.size());
		 /**
		 *  Traversing the Total Deduction table in the Edit page
		 */
		for (int c = 1; c <= rows.size(); c++) {
			/**
			 *  Fetching dynamic salary deduction components individually from Edit page.
			 */
			String cellValue = driver
					.findElement(By.xpath("//table[@id='edit_salary_deductions']/tbody/tr[" + c + "]/td[1]/input"))
					.getAttribute("value");
			/**
			 *  All static & dynamic salary deduction components value validation 
			 */
			if (cellValue.equalsIgnoreCase(array[0])) {
				value[0] = driver
						.findElement(By.xpath("//table[@id='edit_salary_deductions']/tbody/tr[" + c + "]/td[3]/input"))
						.getAttribute("value");
				float basic = (Float.valueOf(value[0])).floatValue();
				if (ESIC.equalsIgnoreCase("Yes")) {
					double esicamnt = (((1.75) * tearning) / 100);
					String esicamount = String.valueOf(esicamnt);
					String[] split = esicamount.split("\\.");
					String esic = split[0] + ".00";
					if (value[0].equalsIgnoreCase(esic)) {
						logger.info("ESIC is properly calculated and verified");
					} else {
						logger.info("ESIC calculation is wrong");
					}
				}
			} else if (cellValue.equalsIgnoreCase(array[1])) {
				value[1] = driver
						.findElement(By.xpath("//table[@id='edit_salary_deductions']/tbody/tr[" + c + "]/td[3]/input"))
						.getAttribute("value");
				if (value[1].equalsIgnoreCase("200.00")) {
					logger.info("Professional tax is fixed with Rs.200");
				} else {
					logger.info("Professional tax has some wrong value");
				}
			} else if (cellValue.equalsIgnoreCase(array[2])) {
				value[2] = driver
						.findElement(By.xpath("//table[@id='edit_salary_deductions']/tbody/tr[" + c + "]/td[3]/input"))
						.getAttribute("value");
			} else if (cellValue.equalsIgnoreCase(array[3])) {
				value[3] = driver
						.findElement(By.xpath("//table[@id='edit_salary_deductions']/tbody/tr[" + c + "]/td[3]/input"))
						.getAttribute("value");
			} else if (cellValue.equalsIgnoreCase(array[4])) {
				value[4] = driver
						.findElement(By.xpath("//table[@id='edit_salary_deductions']/tbody/tr[" + c + "]/td[3]/input"))
						.getAttribute("value");
				double pfamnt = ((12 * actbasicsalary) / 100);
				String pf = String.valueOf(pfamnt);
				String pfamount = pf + "0";
				if (value[4].equalsIgnoreCase(pfamount)) {
					logger.info("Provident Fund is properly calculated and verified");
				} else {
					logger.info("The Provident Fund calculation is wrong");
				}
			} else if (cellValue.equalsIgnoreCase(array[5])) {
				value[5] = driver
						.findElement(By.xpath("//table[@id='edit_salary_deductions']/tbody/tr[" + c + "]/td[3]/input"))
						.getAttribute("value");
				double vpfamnt = ((12 * actbasicsalary) / 100);
				String vpf = String.valueOf(vpfamnt);
				String vpfamount = vpf + "0";
				if (value[4].equalsIgnoreCase(vpfamount)) {
					logger.info("VPF is properly calculated and verified");
				} else {
					logger.info("VPF calculation is wrong");
				}
			} else if (cellValue.equalsIgnoreCase(array[6])) {
				value[6] = driver
						.findElement(By.xpath("//table[@id='edit_salary_deductions']/tbody/tr[" + c + "]/td[3]/input"))
						.getAttribute("value");
			} else if (cellValue.equalsIgnoreCase(array[7])) {
				value[7] = driver
						.findElement(By.xpath("//table[@id='edit_salary_deductions']/tbody/tr[" + c + "]/td[3]/input"))
						.getAttribute("value");
			} else if (cellValue.equalsIgnoreCase(array[8])) {
				value[8] = driver
						.findElement(By.xpath("//table[@id='edit_salary_deductions']/tbody/tr[" + c + "]/td[3]/input"))
						.getAttribute("value");
			} else {
				logger.info("***********");
			}

		}
		/**
		 * Total deducted salary based on dynamic components
		 */
		float totaldeductedamount = 0;
		for (int i = 0; i < value.length; i++) {
			if ((value[i] != null)) {
				totaldeductedamount = ((Float.valueOf(totaldeductedamount)).floatValue())
						+ ((Float.valueOf(value[i])).floatValue());
			}
		}
		
		/**
		 * Total deducted salary validation based on dynamic components
		 */
		if (totaldeductedamount == tdeduction) {
			logger.info("The Total deductions calculation is based on the provided components is correct");
		} else {
			logger.info(
					"The Total deductions calculation is based on the provided components is not correct, please verify it manually once");
		}
		return totaldeductedamount;
	}

	/**
	 * Net salary validation based on Total earning & deduction components
	 */
	public void net_salaryearnings(int rownum) {
		String salary_value = netSalary.getText();
		float netsalary = (Float.valueOf(salary_value)).floatValue();

		float additionamount = totalearnings_calculation(rownum);
		float deductionamount = totaldeductions_calculation(rownum);

		float netincome = additionamount - deductionamount;

		if (netincome == netsalary) {
			logger.info("Net Salary is correct");
		} else {
			logger.info("Net Salary is not correct");
		}

	}

	/**
	 * Completing the salary process with comment validation
	 */
	public void complete_Salary(String comments) {
		Waitfor(3);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)", "");
		Waitfor(1);
		boolean completebutton = Complete_Salary.isDisplayed();
		if (completebutton == bTrue) {
			Complete_Salary.click();
			Waitfor(1);
			boolean comp_submit = Complete_Submit_Button.isEnabled();
			if (comp_submit == bTrue) {
				Complete_SalaryComments.sendKeys(Keys.chord(Keys.CONTROL, "a"), comments);
				Waitfor(1);
				Complete_Submit_Button.click();
				String compsubmittoastmsg = genericToastMsg.getText();
				if (compsubmittoastmsg.equalsIgnoreCase("Salary Completed Succesfully")) {
					logger.info("Salary process is completed successfully with proper toast message");
				} else {
					logger.info("Salary process toast message is not displayed");
				}
			} else {
				logger.info("Complete Submit button is not enabled/Visible");
			}
		} else {
			logger.info("Complete button is not present");
		}
	}

	/**
	 * Complete popup-Close button
	 */
	public void complete_closesalary() {
		Complete_Close_Button.click();
		Waitfor(1);
	}

	/**
	 * Generated salary Report status
	 */
	public String salary_reportstatus(String statusname) {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dateFormat1 = new SimpleDateFormat("MMMM");

		String y_m_d = dateFormat.format(date);
		String month = dateFormat1.format(date);
		String monthname = month + " " + y_m_d;

		salaryreportSearchInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), monthname);
		Waitfor(1);

		Actions action = new Actions(driver);
		int count = 0;
		String col_text = "Status";
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='salary_home_paginate']/span/a"));
		if (page.size() > 0) {
			for (int i = 1; i <= page.size(); i++) {
				if (i > 1) {
					driver.findElement(By.xpath("//div[@id='salary_home_paginate']/span/a[" + (i) + "]")).click();
					Waitfor(1);
				}
				WebElement table = driver.findElement(By.xpath("//table[@id='salary_home']/thead/tr"));
				List<WebElement> heading = table.findElements(By.tagName("th"));
				for (int h = 0; h <= heading.size(); h++) {
					String text = heading.get(h).getText();
					if (col_text.equalsIgnoreCase(text)) {
						int col = h;
						WebElement row_table = driver.findElement(By.xpath("//table[@id='salary_home']/tbody"));
						List<WebElement> rows = row_table.findElements(By.tagName("tr"));
						logger.info(rows.size());
						for (int c = 1; c <= rows.size(); c++) {

							String cell_Value = driver
									.findElement(By.xpath(
											"//table[@id='salary_home']/tbody/tr[" + c + "]/th[" + (col + 1) + "]"))
									.getText();
							Waitfor(2);
							String array[] = { "Candidate Created", "Approved", "Rejected", "Completed", "Submitted" };
							if (cell_Value.equalsIgnoreCase(statusname)) {

								WebElement report = driver
										.findElement(By.xpath("//table[@id='salary_home']/tbody/tr[" + c + "]/th[5]"));
								Waitfor(1);
								action.click(report).build().perform();
								logger.info("Salary Report record found with " + statusname + " status");
								reportID = driver
										.findElement(By.xpath("//table[@id='salary_home']/tbody/tr[" + c + "]/th[1]"))
										.getText();
								logger.info("The newly created Report ID is: " + reportID);
								Waitfor(1);
								action.doubleClick(report).build().perform();
								Waitfor(2);
								count++;
								break;
							} else {
								logger.info("No Salary Report record found with " + statusname + " status");
							}
							if (count > 0) {
								break;
							}
						}
					}
					if (count > 0) {
						break;
					}
				}
			}
		}
		return reportID;
	}

	/**
	 * Generated salary-HDFC bank Report validation
	 */
	public void hdfcbankreport(String company, String Region, String Department, String emp_name, String paystatus) {
		// Company dropdown selection
		Select dcomp = new Select(HDFC_Company);
		dcomp.selectByVisibleText(company);
		Waitfor(1);
		// Region dropdown selection
		Select dregion = new Select(HDFC_Region);
		dregion.selectByVisibleText(Region);
		Waitfor(1);

		int count = 0;
		// Traversing in the webtable to select paid/unpaid employees
		HDFC_SearchBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), emp_name);
		String coltext1 = "Emp Name";
		WebElement table1 = driver.findElement(By.xpath("//table[@id='salary_hdfc_report']/thead/tr"));
		List<WebElement> heading1 = table1.findElements(By.tagName("th"));
		for (int h1 = 0; h1 < heading1.size(); h1++) {
			String text1 = heading1.get(h1).getText();
			if (coltext1.equalsIgnoreCase(text1)) {
				int col = h1;
				WebElement rowtable1 = driver.findElement(By.xpath("//table[@id='salary_hdfc_report']/tbody"));
				List<WebElement> rows1 = rowtable1.findElements(By.tagName("tr"));
				for (int c = 1; c <= rows1.size(); c++) {
					String cellValue1 = driver
							.findElement(By.xpath(
									"//table[@id='salary_hdfc_report']/tbody/tr[" + c + "]/td[" + (col + 1) + "]"))
							.getText();
					Waitfor(2);
					if (cellValue1.equalsIgnoreCase(emp_name)) {
						count++;
						String s = driver
								.findElement(By.xpath("//table[@id='salary_hdfc_report']/tbody/tr[" + c + "]/td[10]"))
								.getText();
						if (s.equalsIgnoreCase(paystatus)) {
							logger.info("Status is matching with the passed status & Status is " + s);
							driver.findElement(
									By.xpath("//table[@id='salary_hdfc_report']/tbody/tr[" + c + "]/td[13]/input"))
									.click();
							Waitfor(2);
							HDFC_SearchBox.clear();
							count++;
						}
					}
					if (count > 0) {
						break;
					}
				}
			}
			if (count > 0) {
				break;
			}
		}
	}

	/**
	 * HDFC bank Report, download report button.
	 */
	public void downloadHDFCreport() {
		DownldHDFCReport_Button.click();
		Waitfor(1);
	}

	/**
	 * HDFC bank Report, Pay button.
	 */
	public void payHDFCreport() {
		DownloadHDFC_PayButton.click();
		Waitfor(1);
	}

	/**
	 * Uploading -downloaded HDFC bank Report document with validation
	 */
	public void uploadHDFCreport(String filedescription) {
		DownloadHDFC_UploadButton.click();
		Waitfor(1);
		boolean status = UploadHDFC_uploadbutton.isEnabled();
		if (status == bTrue) {
			UploadHDFC_uploadbutton.click();
			Waitfor(2);
			String filetoastmsg = genericToastMsg.getText();
			if (filetoastmsg.equalsIgnoreCase("Choose valid xls file !!!!"))
				UploadHDFC_BrowseButton
						.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadxls")).getAbsolutePath());
		} else {
			logger.info("Upload Button is not enabled, It's a bug");
		}
		UploadHDFC_Filedescription.sendKeys(Keys.chord(Keys.CONTROL, "a"), filedescription);
		String filedescr = UploadHDFC_Filedescription.getAttribute("value");
		if (filedescr.equalsIgnoreCase(filedescription)) {
			logger.info("Comment Field is editable");
		} else {
			logger.info("Field is non editable" + filedescr);
		}
		Waitfor(2);
		boolean status1 = UploadHDFC_uploadbutton.isEnabled();
		if (status1 == bTrue) {
			UploadHDFC_uploadbutton.click();
			Waitfor(2);
		} else {
			logger.info("Upload Button is disable");
		}
	}

	/**
	 * HDFC bank Report- Cancel button.
	 */
	public void upload_Cancelbutton() {
		UploadHDFC_Closebutton.click();
		Waitfor(1);
	}

	/**
	 * HDFC bank Report- Close button.
	 */
	public void downloadhdfc_Closebutton() {
		DownloadHDFC_Close_Button.click();
		Waitfor(1);
	}

	/**
	 * HDFC bank Report- Select All checkbox.
	 */
	public void hdfcselectAll() {
		HDFC_SelectAll.click();
		Waitfor(1);
	}
	
	/**
	 * HDFC bank icon button.
	 */
	public void hdfcbankicon() {
		DownloadHDFC_Icon.click();
		Waitfor(1);
	}

	/**
	 * Generated salary-Other bank Report validation
	 */
	public void other_Bankreport(String company, String Region, String Department, String emp_name, String paystatus) {
		// Company dropdown selection
		Select dcomp = new Select(OtherBank_Company);
		dcomp.selectByVisibleText(company);
		Waitfor(1);
		// Region dropdown selection
		Select dregion = new Select(OtherBank_Region);
		dregion.selectByVisibleText(Region);
		Waitfor(1);

		int count = 0;
		// Traversing in the webtable to select paid/unpaid employees
		Other_SearchBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), emp_name);
		String col_text1 = "Emp Name";
		WebElement table1 = driver.findElement(By.xpath("//table[@id='salary_othr_report']/thead/tr"));
		List<WebElement> heading1 = table1.findElements(By.tagName("th"));
		for (int h1 = 0; h1 < heading1.size(); h1++) {
			String text1 = heading1.get(h1).getText();
			if (col_text1.equalsIgnoreCase(text1)) {
				int col = h1;
				WebElement row_table1 = driver.findElement(By.xpath("//table[@id='salary_othr_report']/tbody"));
				List<WebElement> rows1 = row_table1.findElements(By.tagName("tr"));
				for (int c = 1; c <= rows1.size(); c++) {
					String cell_Value1 = driver
							.findElement(By.xpath(
									"//table[@id='salary_othr_report']/tbody/tr[" + c + "]/td[" + (col + 1) + "]"))
							.getText();
					Waitfor(2);
					if (cell_Value1.equalsIgnoreCase(emp_name)) {
						count++;
						String s = driver
								.findElement(By.xpath("//table[@id='salary_othr_report']/tbody/tr[" + c + "]/td[10]"))
								.getText();
						if (s.equalsIgnoreCase(paystatus)) {
							logger.info("Status is matching with the passed status & Status is " + s);
							driver.findElement(
									By.xpath("//table[@id='salary_othr_report']/tbody/tr[" + c + "]/td[13]/input"))
									.click();
							Waitfor(2);
							count++;
						}
					}
					if (count > 0) {
						break;
					}
				}
			}
			if (count > 0) {
				break;
			}
		}
	}

	/**
	 * Other bank icon button.
	 */
	public void otherbankicon() {
		OtherBank_Icon.click();
		Waitfor(1);
	}

	/**
	 * Other bank Report- download report button.
	 */
	public void downloadother_Bankreport() {
		DownldOther_ReportButton.click();
		Waitfor(1);
	}

	/**
	 * Other bank Report- Pay button.
	 */
	public void payother_Bankreport() {
		OtherBank_PayButton.click();
		Waitfor(1);
	}

	/**
	 * Other bank Report- Select All checkbox.
	 */
	public void otherbankselectAll() {
		Other_SelectAll.click();
		Waitfor(1);
	}

	/**
	 * Uploading -downloaded Other bank Report document with validation
	 */
	public void uploadother_Bankreport(String file_description) {
		OtherBank_UploadButton.click();
		Waitfor(1);
		boolean status = OtherBankupload_uploadbutton.isEnabled();
		if (status == bTrue) {
			OtherBankupload_uploadbutton.click();
			Waitfor(1);
			String file_toastmsg = genericToastMsg.getText();
			if (file_toastmsg.equalsIgnoreCase("Choose valid xls file !!!!"))
				OtherBankupload_BrowseButton
						.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadxls1")).getAbsolutePath());
		} else {
			logger.info("Upload Button is enabled, It's a bug");
		}

		OtherBankupload_comments.sendKeys(Keys.chord(Keys.CONTROL, "a"), file_description);
		String filedescription = OtherBankupload_comments.getAttribute("value");
		if (filedescription.equalsIgnoreCase(file_description)) {
			logger.info("Comment Field is editable");
		} else {
			logger.info("Field is non editable" + filedescription);
		}
		Waitfor(1);
		boolean status1 = OtherBankupload_uploadbutton.isEnabled();
		if (status1 == bTrue) {
			OtherBankupload_uploadbutton.click();
			Waitfor(1);
		} else {
			logger.info("Upload Button is disable");
		}
	}

	/**
	 * Other bank Report- Close button.
	 */
	public void downloadother_Bank_Closebutton() {
		OtherBank_Close_Button.click();
	}

	/**
	 * Initiating the Salary manually by specialist RMG
	 */
	public void salaryInitiate() {
		ObjectInitClass.HP.My_Lynx();
		salaryReconsubmodule();

		initiatesalary();
		initiatesalary_MsgYes();
		re_initiatesalaryMsgYes();
		Waitfor(500);
	}

	/**
	 *  Salary process chain for initiation and approval/rejection
	 */
	public void salaryprocesslogin(int row) {
		// Read Excel object creation to pass the sheet parameter.
		String username = excelreaddata().getData("Login_Credentials", row, 0); // Reading Username from excel
		Waitfor(1);
		String password = excelreaddata().getData("Login_Credentials", row, 1); // Reading Password from excel
		Waitfor(1);

		// Login with Lead RMG for initiating the Salary.
		ObjectInitClass.LP.signIn(username, password);
		Waitfor(2);
		ObjectInitClass.HP.My_Lynx();
		salaryReconsubmodule();
		Waitfor(2);
	}

	/**
	Salary report back button
	**/
	public void backbutton() {
		backButton.click();
		Waitfor(3);
	}

	
	/**
	Salary report approve functionality validation
	**/
	public void salary_Approve_rmg() {
		Waitfor(3);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)", "");
		boolean approve_status = Salarysubmit_Button.isDisplayed();
		if (approve_status == bTrue) {
			Waitfor(1);
			boolean approve_button = Salarysubmit_Button.isEnabled();
			if (approve_button == bTrue) {
				Salarysubmit_Button.click();
				Waitfor(3);
				String approvetoastmsg = genericToastMsg.getText();
				if (approvetoastmsg.equalsIgnoreCase("Salary Submitted Succesfully")) {
					logger.info("Approve button has proper validation along with the toast message");
				} else {
					logger.info("Approve button toast meesage is either not proper or not displayed");
				}
			} else {
				logger.info("The Approve button is not enabled");
			}
		} else {
			logger.info("The Approve button is not displayed");
		}

	}

	/**
	 *  Validation for Completed salary report in the landing page.
	 */
	public String salary_completesalary(String statusname) {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dateFormat1 = new SimpleDateFormat("MMMM");

		String y_m_d = dateFormat.format(date);
		String month = dateFormat1.format(date);
		String monthname = month + " " + y_m_d;

		salaryreportSearchInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), monthname);
		Waitfor(1);

		Actions action = new Actions(driver);
		int count = 0;
		String col_text = "Status";
		List<WebElement> page = driver.findElements(By.xpath("//div[@id='salary_home_paginate']/span/a"));
		if (page.size() > 0) {
			for (int i = 1; i <= page.size(); i++) {
				if (i > 1) {
					driver.findElement(By.xpath("//div[@id='salary_home_paginate']/span/a[" + (i) + "]")).click();
					Waitfor(1);
				}
				WebElement table = driver.findElement(By.xpath("//table[@id='salary_home']/thead/tr"));
				List<WebElement> heading = table.findElements(By.tagName("th"));
				for (int h = 0; h <= heading.size(); h++) {
					String text = heading.get(h).getText();
					if (col_text.equalsIgnoreCase(text)) {
						int col = h;
						WebElement row_table = driver.findElement(By.xpath("//table[@id='salary_home']/tbody"));
						List<WebElement> rows = row_table.findElements(By.tagName("tr"));
						logger.info(rows.size());
						for (int c = 1; c <= rows.size(); c++) {

							String cell_Value = driver
									.findElement(By.xpath(
											"//table[@id='salary_home']/tbody/tr[" + c + "]/th[" + (col + 1) + "]"))
									.getText();
							Waitfor(2);
							String array[] = { "Candidate Created", "Approved", "Rejected", "Completed", "Submitted" };
							if (cell_Value.equalsIgnoreCase(statusname)) {

								WebElement report = driver
										.findElement(By.xpath("//table[@id='salary_home']/tbody/tr[" + c + "]/th[5]"));
								Waitfor(1);
								action.click(report).build().perform();
								logger.info("Salary Report record found with " + statusname + " status");
								reportID = driver
										.findElement(By.xpath("//table[@id='salary_home']/tbody/tr[" + c + "]/th[1]"))
										.getText();
								logger.info("The newly created Report ID is: " + reportID);
								Waitfor(1);
								action.click(report).build().perform();
								Waitfor(2);
								count++;

								break;
							} else {
								logger.info("No Salary Report record found with " + statusname + " status");
							}
							if (count > 0) {
								break;
							}
						}

					}
					if (count > 0) {
						break;
					}
				}
			}

		}
		return reportID;
	}
}












					
					
				

			
		
