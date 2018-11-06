package com.dikshatech.tst.objectrepository;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.dataprovider.ExcelReadData;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;

public class EmployeeOnboardingObjects extends TestBase
{
	
    JavascriptExecutor jse= (JavascriptExecutor)driver;
    String selected_reportingdate="";
    String selected_dateofissue="";
    String star="∗";
    String usnLynx= "release.test";
    String pwdLynx="Lynx";
    String EMPID="2023";
    
    String rmclientcompanyname="";
    String rmclientregion="";
    String rmclientdepartment="";
    String rmclientproject="";
    String rmclientrepo_Date="";
    String rmclienttiming="";
    String rmvenue_address="";
    String rmrm_name="";
    String rmcontact_person="";
    String rmcontact_number="";
	@Test
	public EmployeeOnboardingObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//RMG Menu and Employees Submenu
	
	@FindBy(xpath="//span[text()='My Lynx']")        			   		 WebElement MYLynx_Module;
	@FindBy(xpath="//li[@id='rmg-menu']/a/span[1]")        			     WebElement Rmg_Module;	
	//Candidate General Info Details
	// Clicking on Candidates sub tab	
	@FindBy(xpath="//span[contains(.,'Candidates')]")        	         WebElement Candidate_Submodule;
	@FindBy(xpath="//li[@id='employee-menu']/span")        	             WebElement Employees_Submodule;


	                						
	@FindBy(xpath="//button[contains(@data-original-title,'New')]")    WebElement NewCandidate_Button;
	@FindBy(xpath="//button[@data-original-title='Edit']")             WebElement EditCandidate_Button;
	@FindBy(xpath="//button[@data-original-title='Mark As Employee']") WebElement MarkasEmployee_Button;
		
	//New Candidate Title text
	@FindBy(xpath="//h4[contains(.,'Candidate')]")			           WebElement Candidates_LandingpageTitletext;
	
	//New Candidate Title text
	@FindBy(xpath="//h4[@id='candidate_heading']")				       WebElement NewCandidatepage_Title;
	//Department Details tab text
	@FindBy(xpath=".//*[@id='candGeneralInfoViewAll']/div/div[1]/div[1]/h5")  WebElement DepartmentDetails_Sectiontext;
		
	//Department Details Objects
	@FindBy(xpath="//a[contains(.,'General Info')]")            	   WebElement 	Candidate_Generalinfotab;
	@FindBy(xpath="//select[@id='cand_gen_company']") 		           WebElement Company_Dropdown;
	@FindBy(xpath="//select[@id='cand_gen_region']")    			   WebElement Region_Dropdown;
	@FindBy(xpath="//select[@id='cand_gen_location']") 				   WebElement Location_Dropdown;
	@FindBy(xpath="//select[@id='cand_gen_dept']") 				       WebElement Department_Dropdown;
	@FindBy(xpath="//select[@id='cand_gen_category']") 				   WebElement Category_Dropdwon;
	@FindBy(xpath="//select[@id='cand_gen_level']") 				   WebElement Level_Dropdown;
	@FindBy(xpath="//select[@id='cand_gen_designation']") 			   WebElement Designation_Dropdown;
	@FindBy(xpath="//select[@id='cand_gen_rm']") 					   WebElement Reportingmanager_Dropdown;
	@FindBy(xpath="//select[@id='cand_gen_spoc']") 					   WebElement SPOC_Dropdown;
	@FindBy(xpath="//select[@id='cand_gen_projects']") 				   WebElement Project_Dropdown;

	//Department mandatory fields

	@FindBy(xpath=".//*[@id='new_candgen']/div[1]/div/div[1]/div[2]/div[1]") 					    WebElement Company_Mandatory;
	@FindBy(xpath=".//*[@id='candGeneralInfoViewAll']/div/div[1]/div[5]/div[1]") 					WebElement Region_Mandatory;
	@FindBy(xpath=".//*[@id='candGeneralInfoViewAll']/div/div[1]/div[6]/div[1]") 					WebElement Location_Mandatory;
	@FindBy(xpath=".//*[@id='candGeneralInfoViewAll']/div/div[1]/div[7]/div[1]") 					WebElement Department_Mandatory;
	@FindBy(xpath=".//*[@id='candGeneralInfoViewAll']/div/div[1]/div[8]/div[1]") 					WebElement Category_Mandatory;
	@FindBy(xpath=".//*[@id='candGeneralInfoViewAll']/div/div[1]/div[9]/div[1]") 					WebElement Level_Mandatory;
	@FindBy(xpath=".//*[@id='candGeneralInfoViewAll']/div/div[1]/div[10]/div[1]") 					WebElement Designation_Mandatory;
	@FindBy(xpath=".//*[@id='candGeneralInfoViewAll']/div/div[1]/div[11]/div[1]") 					WebElement ReportingManager_Mandatory;
	@FindBy(xpath=".//*[@id='cand_gen_projects_div']/div[1]") 					                    WebElement Project_Mandatory;
	@FindBy(xpath=".//*[@id='candGeneralInfoViewCandidate']/div[1]/div[2]/div[2]/button") 	        WebElement photo_uplaod;
		
	// Employee Details Mandatory Fields web elements	
		
	@FindBy(xpath=".//*[@id='new_candgen']/div[1]/div/div[2]/div[2]/div[1]") 					WebElement FirstName_Mandatory;
	@FindBy(xpath=".//*[@id='new_candgen']/div[1]/div/div[2]/div[4]/div[1]") 					WebElement LastName_Mandatory;
	@FindBy(xpath=".//*[@id='new_candgen']/div[1]/div/div[2]/div[6]/div[1]") 					WebElement Nationality_Mandatory;
	@FindBy(xpath=".//*[@id='new_candgen']/div[1]/div/div[2]/div[7]/div[1]") 					WebElement Gender_Mandatory;
	@FindBy(xpath=".//*[@id='new_candgen']/div[1]/div/div[2]/div[8]/div[1]") 					WebElement DateofBirth_Mandatory;
	@FindBy(xpath=".//*[@id='new_candgen']/div[1]/div/div[2]/div[10]/div[1]") 					WebElement CandidateEmailID_Mandatory;
	@FindBy(xpath=".//*[@id='new_candgen']/div[1]/div/div[2]/div[11]/div[1]") 					WebElement DateOfJoining_Mandatory;
	@FindBy(xpath=".//*[@id='new_candgen']/div[1]/div/div[2]/div[12]/div[1]") 					WebElement Noticeperiod_Mandatory;
	@FindBy(xpath=".//*[@id='new_candgen']/div[1]/div/div[2]/div[13]/div[1]") 					WebElement EmployeeType_Mandatory;
	@FindBy(xpath=".//*[@id='new_candgen']/div[1]/div/div[2]/div[14]/div[2]/div/div[1]") 		WebElement Role_Mandatory;
	@FindBy(xpath="//*[@id='candSubmitCandidate']") 											WebElement Candidate_Submit_Button;
	

		@FindBy(xpath="//button[@id='generalInfoSavenSubmit']") 					WebElement Generalinfo_Savebutton;
		@FindBy(xpath="//button[@id='personalInfoSavenSubmit']") 					WebElement Personalinfo_Savebutton;
		@FindBy(xpath="//button[@id='declarationSavenSubmit']") 					WebElement Nomineeinfo_Savebutton;
		@FindBy(xpath="//button[@id='financial_InfoSavenSubmit']") 					WebElement Financeinfo_Savebutton;
		@FindBy(xpath="//button[@id='passport_InfoSavenSubmit']") 					WebElement Passportinfo_Savebutton;
		@FindBy(xpath="//button[@id='education_InfoSavenSubmit']") 					WebElement Educationinfo_Savebutton;
		@FindBy(xpath="//button[@id='experience_InfoSavenSubmit']") 				WebElement Experienceinfo_Savebutton;
		@FindBy(xpath="//button[@id='skillsSavenSubmit']") 								WebElement Skillsinfo_Savebutton;
		@FindBy(xpath="//button[@id='candSubmitRMG']") 								WebElement RMGCandidate_submitbutton;
		@FindBy(xpath="//button[@onclick='candAcceptRMGClick()']") 								WebElement RMGAccept_Button;
		
		
		//Save confirmation messages
		@FindBy(xpath="//span[contains(.,'General Info Saved/Updated Successfully')]") 	WebElement Candsave_Confirmationmsg;
		@FindBy(xpath="//span[contains(.,'Details Submitted Successfully')]") 			WebElement Candsubmit_Confirmationmsg;

		
	//Update Candidate profile button
			
	@FindBy(xpath="//button[contains(@id,'cand_gen_save')]") 			WebElement CandUpdatebutton;
		
	//Employee Details tab text
	@FindBy(xpath="//select[@id='gen_company']") 		     			WebElement EmployeeDetails_Sectiontext;
		
	//Employee Details Objects
	
	@FindBy(xpath="//input[@id='cand_gen_firstname']") 					WebElement Employee_FirstName;
	@FindBy(xpath="//input[@id='cand_gen_middlename']") 				WebElement Employee_MiddileName;
	@FindBy(xpath="//input[@id='cand_gen_lastname']") 					WebElement Employee_LastName;
	@FindBy(xpath="//input[@id='cand_gen_maidenname']") 				WebElement Employee_MaidenName; 
	@FindBy(xpath="//input[@id='cand_gen_nationality']") 				WebElement Nationality;
	@FindBy(xpath="//span[@class='genericradiocheckmark']") 			WebElement Gender_Male_Radio_button;
	@FindBy(xpath="//span[contains(@class,'genericradiocheckmark')]") 	WebElement Gender_FeMale_Radio_button;
	@FindBy(xpath="//input[@id='cand_gen_dob']") 						WebElement DateofBirth;
	@FindBy(xpath="//input[@id='cand_gen_email']") 						WebElement CandidatePersonal_Emailid;
	@FindBy(xpath="//input[@id='cand_gen_doj']") 						WebElement Dateof_Joining;
	@FindBy(xpath="//input[@id='cand_gen_notice']") 					WebElement Notice_Period;
	@FindBy(xpath="//select[@id='cand_gen_employmenttype']") 			WebElement Employmenttype_Dropdown;
	@FindBy(xpath="//select[@id='cand_gen_role']") 						WebElement Role_Dropdown;
	@FindBy(xpath="//button[@id='cand_gen_save']") 						WebElement Save_Candidate;
	@FindBy(xpath="//button[@id='candSubmitRMG']") 						WebElement Submit_Candidate;
	@FindBy(xpath="//select[@id='gen_projects']") 				     	WebElement Edit_Candidate;
	@FindBy(xpath="//button[@class='btn btn-primary back-btn']") 		WebElement Cand_Backbutton;
	
	
	//RMG-Candidate Financial info Objects
	
	@FindBy(xpath="//a[contains(.,'Financial Info')]") 						WebElement Financialinfo_Tab;
	@FindBy(id="//input[@id='cand_fin_oldSU']") 							WebElement Salary_Old_Radio_button;
	@FindBy(xpath="//span[@class='genericradiocheckmark']") 		     	WebElement Salary_New_Radio_button;
	@FindBy(xpath="//input[@id='cand_fin_ctcAmount']") 					    WebElement Current_CTC;
	@FindBy(xpath="//input[@id='cand_fin_effectiveFrom']") 					WebElement CandCTC_Efffrom;
	@FindBy(xpath="//input[@id='cand_fin_plb']") 			      			WebElement Candidate_QPLB;
	@FindBy(xpath="//input[@id='cand_fin_plb']") 			      			WebElement Rententionbonus_checkbox;
	@FindBy(xpath="//input[@id='cand_fin_qplbEffectiveFromDate']")		 	WebElement QPLB_EffDateFrom;
	@FindBy(xpath="//input[@id='cand_fin_qplbper']") 			  			WebElement QPLB_Perc;
	@FindBy(xpath="//input[@id='cand_fin_aplbper']") 					    WebElement APLB_Perc;
	@FindBy(xpath="//input[@id='cand_fin_pf']") 					   		WebElement CandPF_Number;
	@FindBy(xpath="//input[@id='cand_fin_aadhar']") 					    WebElement CandAadhar_Number;
	@FindBy(xpath="//button[@id='candAadhaarUpload']") 					    WebElement CandAadhar_uploadicon;
	@FindBy(xpath="//input[@id='cand_fin_pan']") 					 		WebElement CandPAN_Number;
	@FindBy(xpath="//button[@id='candPanUpload']") 					  		WebElement CandPAN_uploadicon;
	@FindBy(xpath="//input[@id='cand_fin_uan']") 					  	  	WebElement CandUAN_Number;
	@FindBy(xpath="//button[@id='candUanUpload']") 					    	WebElement CandUAN_uploadicon;
	@FindBy(xpath="//input[@id='cand_fin_primaryBank']") 					WebElement CandPrimary_BankName;
	@FindBy(xpath="//input[@id='cand_fin_primaryAccNo']") 					WebElement CandPrimary_Acno;
	@FindBy(xpath="//input[@id='cand_fin_primaryIfsc']") 					WebElement CandPrimary_IFSCcode;
	@FindBy(xpath=".//*[@id='44840']/tr[4]/td[5]/button") 				WebElement RejectBankDetails_Button;
	@FindBy(xpath=".//*[@id='candFinanceCandidateHide']/div[24]/div[2]/label[1]/span[2]") 						WebElement Employee_Active_radiobutton;
	//CAndidate Finance details
	@FindBy(xpath="//input[@id='cand_fin_pf']") 			 		 	   	WebElement Cand_PF;
	@FindBy(xpath="//input[@id='cand_fin_aadhar']") 			 		    WebElement Cand_Aadhar;
	@FindBy(xpath="//input[@id='cand_fin_pan']") 			 		    	WebElement Cand_PAN;
	@FindBy(xpath="//input[@id='cand_fin_uan']") 			 		   	    WebElement Cand_UAN;
		
	@FindBy(xpath="//button[@id='candAadhaarUpload']") 			WebElement Cand_Aadhar_upload;
	@FindBy(xpath="//input[@id='uploadfileName']") 				WebElement Cand_Aadhar_browse;
	@FindBy(xpath="//textarea[@id='upload_comment']") 			WebElement Cand_Aadhar_comments;
	@FindBy(xpath=".//*[@id='cand_AadharUpload']") 				WebElement Cand_Aadhar_uploadingbutton;	
	
	@FindBy(xpath="//button[@id='candPanUpload']") 				WebElement Cand_PAN_upload;
	@FindBy(xpath="//input[@id='uploadfileName']") 				WebElement Cand_PAN_browse;
	@FindBy(xpath="//textarea[@id='upload_comment']") 			WebElement Cand_PAN_comments;
	@FindBy(xpath="//button[@id='cand_AadharUpload']") 			WebElement Cand_PAN_uploadingbutton;
	
	@FindBy(xpath="//button[@id='candUanUpload']") 				WebElement Cand_UAN_upload;
	@FindBy(xpath="//input[@id='uploadfileName']") 				WebElement Cand_UAN_browse;
	@FindBy(xpath="//textarea[@id='upload_comment']") 			WebElement Cand_UAN_comments;
	@FindBy(xpath="//button[@id='cand_AadharUpload']") 			WebElement Cand_UAN_uploadingbutton;

	
	
	@FindBy(xpath="//button[@id='financial_InfoSavenSubmit']") 			WebElement Candidate_Finan_Save;
	@FindBy(xpath="//input[@id='fin_aplbper']") 			 		    WebElement Aadhar_Downloadlink;
	@FindBy(xpath="//input[@id='fin_aplbper']") 			 		    WebElement Aadhar_Rejectbutton;
	@FindBy(xpath="//input[@id='fin_aplbper']") 			 		    WebElement Aadhar_Rejectcomments;
	@FindBy(xpath="//input[@id='fin_aplbper']") 			 		    WebElement Aadhar_Rejecting_Button;
	@FindBy(xpath="//input[@id='fin_aplbper']") 			 		    WebElement PAN_Downloadlink;
	@FindBy(xpath="//input[@id='fin_aplbper']") 			 		    WebElement PAN_Rejectbutton;
	@FindBy(xpath="//input[@id='fin_aplbper']") 			 		    WebElement PAN_Rejectcomments;
	@FindBy(xpath="//input[@id='fin_aplbper']") 			 		    WebElement PAN_Rejecting_Button;
	@FindBy(xpath="//input[@id='fin_aplbper']") 			 		    WebElement UAN_Downloadlink;
	@FindBy(xpath="//input[@id='fin_aplbper']") 			 		    WebElement UAN_Rejectbutton;
	@FindBy(xpath="//input[@id='fin_aplbper']") 			 		    WebElement UAN_Rejectcomments;
	@FindBy(xpath="//input[@id='fin_aplbper']") 			 		    WebElement UAN_Rejecting_Button;
	

	//Candidate General Info Objects(References of Personal and Proffessioanl)
	
	@FindBy(xpath="//input[@id='cand_gen_personalcontact']") 						WebElement Per_ContactName;
	@FindBy(xpath="//input[@id='cand_gen_personalrel']") 							WebElement Per_Relationship;
	@FindBy(xpath="//input[@id='cand_gen_personalphonenum']") 						WebElement Per_Phonenumber;
	@FindBy(xpath="//input[@id='cand_gen_personalemailId']") 					    WebElement Per_EmailId;
	@FindBy(xpath="//input[@id='cand_gen_professionalcontact']") 			      	WebElement Prof_ContactName;
	@FindBy(xpath="//input[@id='cand_gen_professionalDesignation']") 			    WebElement Prof_Designation;
	@FindBy(xpath="//input[@id='cand_gen_professionalphonenum']") 			  		WebElement Prof_Phonenumber;
	@FindBy(xpath="//input[@id='cand_gen_professionalEmailId']") 			    	WebElement Prof_EmailId;

	//Candidate Personal Information-Permanent Address
	
	@FindBy(xpath="//a[@onclick='loadPersonalInfoTabCand()']") 			WebElement Personalinfo_Tab;
	@FindBy(xpath="//textarea[@id='cand_per_permanentaddr']") 			WebElement Permanant_Address;
	@FindBy(xpath="//input[@id='cand_per_percity']") 					WebElement Permanant_City;
	@FindBy(xpath="//input[@id='cand_per_perpincode']") 				WebElement Permanant_Pincode;
	@FindBy(xpath="//select[@id='cand_per_perstate']") 					WebElement Permanant_State;
	@FindBy(xpath="//select[@id='cand_per_percountry']") 				WebElement Permanant_Country_Dropdown;
	
	//Candidate Personal Information-Current Address
	
	@FindBy(xpath="//span[contains(@class,'genericcheckmark')]") 		WebElement Sameaspermanantaddress_checkbox;
	@FindBy(xpath="//textarea[@id='cand_per_currentaddr']") 			WebElement Current_Address;
	@FindBy(xpath="//input[@id='cand_per_curcity']") 					WebElement Current_City;
	@FindBy(xpath="//input[@id='cand_per_curpincode']") 				WebElement Current_Pincode;
	@FindBy(xpath="//input[@id='cand_per_curstate']") 					WebElement Current_State;
	@FindBy(xpath="//select[@id='cand_per_curcountry']") 				WebElement Current_Country_Dropdown;
	
	//Candidate Contact Numbers
	

	@FindBy(xpath="//input[@id='cand_per_priphonenum']") 				WebElement Primary_Contactnumber;
	@FindBy(xpath="//input[@id='cand_per_secphonenum']") 				WebElement Secondary_Contactnumber;
	@FindBy(xpath="//input[@id='cand_per_personalemail']") 				WebElement Personal_EmailID;
	@FindBy(xpath="//input[@id='cand_per_alternateemail']") 			WebElement Alternative_EmailId;

	@FindBy(xpath="//input[@id='cand_per_personalcontact']") 			WebElement Emerg_ContanctName;
	@FindBy(xpath="//input[@id='cand_per_personalrel']") 				WebElement Emerg_Relationship;
	@FindBy(xpath="//input[@id='cand_per_personalphonenum']") 			WebElement Emerg_Phonenumber;
	@FindBy(xpath="//input[@id='cand_gen_bloodgroup']") 				WebElement Cand_BloodGroup;
	
	@FindBy(xpath="//input[@id='cand_per_mothername']") 				WebElement MothersName;
	@FindBy(xpath="//input[@id='cand_per_motherDOB']") 					WebElement Mothers_DOB;
	@FindBy(xpath="//input[@id='cand_per_fathername']") 				WebElement FathersName;
	@FindBy(xpath="//input[@id='cand_per_fatherDOB']") 					WebElement Fathers_DOB;
	@FindBy(xpath=".//*[@id='new_candper']/div[1]/div/div[2]/div[12]/div[2]/label[1]/span")	WebElement Martial_Status_Single_Radiobutton;
	@FindBy(xpath=".//*[@id='new_candper']/div[1]/div/div[2]/div[12]/div[2]/label[2]/span") WebElement Martial_Status_Married_Radiobutton;
	@FindBy(xpath="//input[@id='cand_per_spousename']") 				WebElement SpouseName;
	@FindBy(xpath="//input[@id='cand_per_spouseDOB']") 					WebElement SpouseDOB;
	@FindBy(xpath="//input[@id='cand_per_daughtersonname']") 			WebElement DaughterorSon_Name;
	@FindBy(xpath="//input[@id='cand_per_daughtersondob']") 			WebElement DaughterorSon_DOB;
	
	// EMployee Nominee Info Objects Repository
	@FindBy(xpath="//a[@href='#new_candnom']") 		 					WebElement Cand_Nominee_InfoTab;
	@FindBy(xpath="//input[@id='cand_nomineename']") 					WebElement Cand_Nominee_Name;
	@FindBy(xpath="//input[@id='cand_nomineerelationship']") 			WebElement Cand_Nominee_Relationship;
	@FindBy(xpath="//input[@id='cand_nomineecontact']") 				WebElement Cand_Nominee_Contactno;
	@FindBy(xpath="//input[@name='depnamecand']") 					    WebElement Cand_Dependent_Name;
	@FindBy(xpath="//input[@name='deprelationcand']") 				    WebElement Cand_Dependent_Relationship;
	@FindBy(xpath="//button[@onclick='addDependentsRowCand()']")	 	WebElement Add_Dependants_button;
	@FindBy(xpath="//button[contains(.,' Remove ')]") 					WebElement Remove_DependantsIcon;
	@FindBy(xpath="//button[@id='cand_savenomineeinfo']") 				WebElement Save_Nominee;
	@FindBy(xpath="//a[@href='../data/Form_2.png']") 					WebElement cand_declaration_Form2_dwd;
	@FindBy(xpath="//a[@href='../data/Form_11.png']") 					WebElement cand_declaration_Form11_dwd;
	@FindBy(xpath="//a[@href='../data/UAN.png']") 				        WebElement cand_UANForm_dwd;
	
	@FindBy(xpath="//button[@id='candDeclarationForm2']") 			WebElement Cand_Form2_upload;
	@FindBy(xpath="//input[@id='uploadfileName']") 					WebElement Cand_Form2_browse;
	@FindBy(xpath="//textarea[@id='upload_comment']") 				WebElement Cand_Form2_comments;
	@FindBy(xpath="//button[@id='cand_AadharUpload']") 				WebElement Cand_Form2_uploadingbutton;
	
	@FindBy(xpath="//button[@id='candDeclarationForm11']") 		    WebElement Cand_Form11_upload;
	@FindBy(xpath="//input[@id='uploadfileName']") 				    WebElement Cand_Form11_browse;
	@FindBy(xpath="//textarea[@id='upload_comment']") 			    WebElement Cand_Form11_comments;
	@FindBy(xpath="//button[@id='cand_AadharUpload']") 			WebElement Cand_Form11_uploadingbutton;
	
	@FindBy(xpath="//button[@id='candDeclarationUAN']") 		WebElement Cand_UAN_Form_upload;
	@FindBy(xpath="//input[@id='uploadfileName']") 				WebElement Cand_UAN_Form_browse;
	@FindBy(xpath="//textarea[@id='upload_comment']") 			WebElement Cand_UAN_Form_comments;
	@FindBy(xpath="//button[@id='cand_AadharUpload']") 			WebElement Cand_UAN_Form_uploadingbutton;
	
		
	//Candidate Passport/VISA Details
	
	@FindBy(xpath=".//*[@id='cand_passport']/a")						WebElement PassportInfo_Tab;
	@FindBy(xpath="//input[@id='cand_passport_pasname']")				WebElement Emp_Given_Name;
	@FindBy(xpath="//input[@id='cand_passport_surname']") 				WebElement Emp_Surname;
	@FindBy(xpath="//input[@id='cand_passport_pasnum']") 	   			WebElement Emp_Passport_Number;
	@FindBy(xpath="//input[@id='cand_passport_doi']") 					WebElement Passport_DateofIssue_Datepicker;
	@FindBy(xpath="//input[@id='cand_passport_doe']") 					WebElement Passport_DateofExpiry_Datepicker;
	@FindBy(xpath="//input[@id='cand_passport_poi']") 					WebElement Passport_PlaceofIssue;
	@FindBy(xpath="//input[@id='cand_passport_pob']") 					WebElement Emp_Placeofbirth;
	@FindBy(xpath="//button[@onclick='uploadPassportDocumentCand()']") 	WebElement Cand_passport_upload;
	@FindBy(xpath="//input[@id='uploadfileName']") 						WebElement Cand_passport_browse;
	@FindBy(xpath="//textarea[@id='upload_comment']") 					WebElement Cand_passport_comments;
	@FindBy(xpath="//button[@id='candidate_uploadPassportDoc']") 		WebElement Cand_passport_uploadingbutton;
	
	//Candidate VISA Details
	@FindBy(xpath=".//*[@id='new_candpas']/div[1]/div[9]/div[2]/button") WebElement Visa_Addrows_Button;
	@FindBy(xpath="//input[@id='cand_passport_visaType']") 			     WebElement Emp_Visa_Type;
	@FindBy(xpath="//input[@id='cand_passport_visaCountry']") 			 WebElement Emp_Visa_Country;

	@FindBy(xpath=".//*[@id='cand_passport_add_visaDetails']/tbody/tr/td[7]") 	WebElement Emp_Visa_StartDate;
	@FindBy(xpath=".//*[@id='cand_passport_add_visaDetails']/tbody/tr/td[11]") 	WebElement Emp_Visa_EndDate;

	@FindBy(xpath="//button[@class='btn btn-danger remove_field']") 	WebElement RemoveVisa_Details;
	
	// Candidate Educational Info details
	
	@FindBy(xpath="//a[@href='#new_candedu']") 			                WebElement EducationInfo_Tab;
	@FindBy(xpath=".//*[@id='new_candedu']/div[1]/div/div/button")      WebElement Educationinfo_Add_Button;
	@FindBy(xpath=".//*[@id='123456']/tr[1]/td[4]/select") 				WebElement Cand_DegreeName;
	@FindBy(xpath=".//*[@id='123456']/tr[1]/td[9]/input") 				WebElement Cand_SubjectMajor;
	@FindBy(xpath="//input[@placeholder='Enter Year of Passing']") 		WebElement Cand_YearofPassing;
	@FindBy(xpath="//input[@placeholder='Enter Student ID']")			WebElement Cand_StudentID;
	@FindBy(xpath="//textarea[@placeholder='Enter College Name']") 		WebElement Cand_CollegeName;
	@FindBy(xpath="//input[@id='cand_educationGraduationDate']") 		WebElement Cand_Graduationdatepicker;
	@FindBy(xpath="//input[@id='cand_educationStartDate']")				WebElement Cand_Startdate;
	@FindBy(xpath="//input[@placeholder='Enter Grade']") 				WebElement Cand_Grade;
	@FindBy(xpath=".//*[@id='123456']/tr[3]/td[13]/button")				WebElement Upload_Education_Documents_Button;
	@FindBy(xpath="//input[@placeholder='Enter Grade']") 				WebElement Cand_DegreetypeDD;
	@FindBy(xpath="//input[@placeholder='Enter Grade']") 				WebElement Cand_eduReject_button;
	@FindBy(xpath="//button[@onclick='addEduGapRowCand()']") 			WebElement Cand_AddEduGap_Button;
	@FindBy(xpath="//input[@id='cand_edugap']") 				        WebElement EnterCand_Educationgap;
	@FindBy(xpath="//input[@id='dp1522750958113']") 				    WebElement CandEdu_GapFrom;
	@FindBy(xpath="//input[@id='dp1522750958114']") 					WebElement CandEdu_GapTo;
	@FindBy(xpath="//input[@id='cand_edugap_reason']") 					WebElement CandEdu_GapReason;
	@FindBy(xpath="//input[@placeholder='Enter Grade']") 				WebElement CandEduGap_RemoveButton;
	@FindBy(xpath="//button[@onclick='addTrainingRowCand()']") 			WebElement Cand_TrainingAdd_Button;
	@FindBy(xpath="//input[@id='cand_train_institute']") 				WebElement CandEnter_Institute;
	@FindBy(xpath="//input[@id='cand_train_course']") 					WebElement CandEnter_Course;
	@FindBy(xpath="//input[@id='cand_train_rank']") 					WebElement CandEnter_Rank;
	@FindBy(xpath="//input[@placeholder='Enter Grade']") 				WebElement CandEnterYear_of_Completion;
	@FindBy(xpath="//input[@id='cand_yearofcomp']") 					WebElement CandTraining_Remove_Button;
	
	@FindBy(xpath=".//*[@id='123456']/tr[3]/td[13]/button") 			WebElement Cand_edu1_upload;
	@FindBy(xpath="//input[@id='uploadfileName']") 						WebElement Cand_edu1_browse;
	@FindBy(xpath="//textarea[@id='upload_comment']") 					WebElement Cand_edu1_comments;
	@FindBy(xpath="//button[@id='candidate_uploadEduDoc']") 			WebElement Cand_edu1_uploadingbutton;
	
	@FindBy(xpath=".//*[@id='upload_comment']") 						WebElement RMGEdc_docdownloadlink;
	@FindBy(xpath=".//*[@id='74542']/tr[4]/td[5]/button") 				WebElement RMGEdc_docrejectbutton;
	@FindBy(xpath=".//*[@id='candAadharRejCom']") 						WebElement RMGedc_Rejectdoc_Comments;
	@FindBy(xpath=".//*[@id='candEduReject']") 							WebElement RMGedcdocs_Rejecting_Button;
	
	
	//Candidate PUC objects
	
	@FindBy(xpath="//*[@id='emp_it_view']") 				              WebElement view_adf;
	@FindBy(xpath="//*[@id='candItSendMail']") 				            WebElement senmail;
	@FindBy(xpath=".//*[@id='64478']/tr[1]/td[13]/input") 				WebElement Cand_PUC_YearofPassing;
	@FindBy(xpath=".//*[@id='64478']/tr[2]/td[4]/input")				WebElement Cand_PUC_StudentID;
	@FindBy(xpath=".//*[@id='64478']/tr[2]/td[9]/textarea") 			WebElement Cand_PUC_CollegeName;
	@FindBy(xpath=".//*[@id='educationGraduationDate64478']") 			WebElement Cand_PUC_Graduationdatepicker;
	@FindBy(xpath=".//*[@id='cand_educationStartDate64478']")			WebElement Cand_PUC_Startdate;
	@FindBy(xpath=".//*[@id='64478']/tr[3]/td[9]/input") 				WebElement Cand_PUC_Grade;
	@FindBy(xpath=".//*[@id='64478']/tr[3]/td[13]/button")				WebElement Upload_PUC_Education_Documents_Button;
	
	//Candidate 10th objects
	
	@FindBy(xpath=".//*[@id='85823']/tr[1]/td[4]/select") 				WebElement Cand_10_DegreeName;
	@FindBy(xpath=".//*[@id='85823']/tr[1]/td[9]/input") 				WebElement Cand_10_SubjectMajor;
	@FindBy(xpath=".//*[@id='85823']/tr[1]/td[13]/input") 				WebElement Cand_10_YearofPassing;
	@FindBy(xpath=".//*[@id='85823']/tr[2]/td[4]/input")				WebElement Cand_10_StudentID;
	@FindBy(xpath=".//*[@id='85823']/tr[2]/td[9]/textarea") 			WebElement Cand_10_CollegeName;
	@FindBy(xpath=".//*[@id='educationGraduationDate85823']") 			WebElement Cand_10_Graduationdatepicker;
	@FindBy(xpath=".//*[@id='cand_educationStartDate85823']")			WebElement Cand_10_Startdate;
	@FindBy(xpath="..//*[@id='85823']/tr[3]/td[9]/input") 				WebElement Cand_10_Grade;
	@FindBy(xpath=".//*[@id='85823']/tr[3]/td[13]/button")				WebElement Upload10_Education_Documents_Button;
	
	//Candidate Experience Info details
	
	@FindBy(xpath="//a[@href='#new_candexp']")  								WebElement Experienceinfo_Tab;
	@FindBy(xpath="//select[@id='cand_expType']") 								WebElement Experience_SelectTypeDD;	
	@FindBy(xpath="//button[@onclick='addExperienceInfoCand()']") 				WebElement AddExperience_Button;	
	@FindBy(xpath="//input[@placeholder='Enter Company']")			            WebElement Cand_PrevCompanyName;
	@FindBy(xpath="//input[@placeholder='Enter Designation on Joining']") 	WebElement Cand_Designationonjoining;
	@FindBy(xpath="//input[@placeholder='Enter Designation on Leaving']") 	WebElement Cand_DesignationonLeaving;
	@FindBy(xpath="//input[@class='employeeExpInfoDesEmpCode']") 				WebElement Cand_EmpID;
	@FindBy(xpath="//input[@class='employeeExpInfoDesRmName onlyAlphabet']") 	WebElement Cand_ReportedTo;
	@FindBy(xpath="//input[@class='employeeExpInfoDesResFrLeave onlyAlphabet']")WebElement Cand_ReasonforLeaving;
	@FindBy(xpath=".//*[@id='32104']/tr[3]/td[3]/select")						WebElement Cand_Employmenttype;
	@FindBy(xpath="//input[@class='employeeExpInfoHrName onlyAlphabet']") 		WebElement Cand_HRName;
	@FindBy(xpath="//input[@class='employeeExpInfoDOJ hasDatepicker']") 		WebElement Cand_DOJ;
	@FindBy(xpath="//input[@class='employeeExpInfoDOR hasDatepicker']") 		WebElement Cand_DOR;
	
	@FindBy(xpath="//table[@id='cand_experience_info']/tbody/tr[3]/td[9]/button") 			WebElement Cand_exp_upload;
	@FindBy(xpath="//input[@id='uploadfileName']") 					WebElement Cand_exp_browse;
	@FindBy(xpath="//textarea[@id='upload_comment']") 				WebElement Cand_exp_comments;
	@FindBy(xpath="//button[@id='candidate_uploadExpDoc']") 		WebElement Cand_exp_uploadingbutton;
	
	@FindBy(xpath="//button[@onclick='addEmpGapRowCand()']") 		WebElement EmploymentGap_Addduration_Button;
	@FindBy(xpath="//input[@placeholder='Enter From Date']") 		WebElement EmpGap_Fromdate;
	@FindBy(xpath="//input[@placeholder='Enter To Date']") 			WebElement EmpGap_Todate;
	@FindBy(xpath="//input[@id='cand_empgap_reason']") 				WebElement EmpGap_Reason;
	@FindBy(xpath=".//*[@id='upload_comment']") 						WebElement RMGExp_docdownloadlink;
	@FindBy(xpath="//button[@class='btn btn-primary expRejectClass']") 	WebElement RMGExp_docrejectbutton;
	@FindBy(xpath=".//*[@id='candAadharRejCom']") 						WebElement RMGExp_Rejectdoc_Comments;
	@FindBy(xpath=".//*[@id='candExpReject']") 							WebElement RMGExpdocs_Rejecting_Button;
	//
	
	@FindBy(xpath="//*[@id='markAsEmployeeEmailId']")					 WebElement LynxUsername;
	@FindBy(xpath="//*[@id='candidate_home_filter']/label/input")		 WebElement searchField;
	@FindBy(xpath="//*[@id='candidate_home']/tbody/tr[1]")				 WebElement selectEmp;
	@FindBy(xpath="//*[@id='main_Content']/div/div[2]/div/div[2]")		 WebElement scrollright;
	@FindBy(xpath="//*[@id='emp_offerLetter']")		 					 WebElement offerletterTab;
	@FindBy(xpath="//*[@id='emp_offer_Accept']")		 				 WebElement acceptOfl;
	@FindBy(xpath="//*[@id='emp_offer_Reject']")		 				 WebElement rejectOfl;
	@FindBy(xpath="//*[@id='rejectComment']")		 					 WebElement RejectOflcommts;
	@FindBy(xpath="//*[@id='empOffRejectCase']")		 				 WebElement rejectButton;
	@FindBy(xpath="//*[@id='main_Content']/div/div[1]/div[2]/button")	 WebElement backbutton;
	@FindBy(xpath="//*[@id='offerLinkId']")		 						 WebElement clickOrientation;
	@FindBy(xpath="//*[@id='orientationTestResultFailId']")		 		 WebElement closeOrietan;
	@FindBy(xpath="//*[@id='cand_OfferLetter']/a")		 				 WebElement oflTab;
	@FindBy(xpath="//*[@id='uploadOffLtr']")							 WebElement uploadOfl;
	@FindBy(xpath="//*[@id='uploadfileName']")		 					 WebElement choosefile;
	@FindBy(xpath="//*[@id='uploadOfferLetter']")		 				 WebElement uplodButtn;
	@FindBy(xpath="//*[@id='offerLetterUploadConfirmationId']")			 WebElement clospopup;
	
	@FindBy(xpath = "//*[@id='offerLinkId']") 				         	 WebElement offerlink;
//newwly added

	@FindBy(xpath = " //div[contains(.,'XOffer Letter is Rejected Successfully')]") WebElement REJECT_OFFERLETTER;


	
	     // For Second Company 
	/*@FindBy(xpath="//a[@sectionid='mylynx3']") 							WebElement ADDNextCompyBtn;    
	@FindBy(xpath="//a[@sectionid='mylynx3']")							WebElement SecondCompany_Name;
	@FindBy(xpath="//a[@sectionid='mylynx3']")							WebElement Compy_2ndEmployee_Id;
	@FindBy(xpath="//a[@sectionid='mylynx3']") 							WebElement SecondEmployement_Type_Dropdwon;
	@FindBy(xpath="//a[@sectionid='mylynx3']") 							WebElement Dateof_Joining2ndCmpny_Datepicker;
	@FindBy(xpath="//a[@sectionid='mylynx3']") 							WebElement Designationon_Joining_2ndCopmny;
	@FindBy(xpath="//a[@sectionid='mylynx3']") 							WebElement ReportedToNameofPostion2ndCmpy;
	@FindBy(xpath="//a[@sectionid='mylynx3']") 							WebElement SecondCompyNameof_HR_Manager;
	@FindBy(xpath="//a[@sectionid='mylynx3']") 							WebElement Dateof_Releaving_2ndCompny;
	@FindBy(xpath="//a[@sectionid='mylynx3']") 							WebElement Designationon_Leaving2ndCompny;
	@FindBy(xpath="//a[@sectionid='mylynx3']") 							WebElement ReasonforLeaving2ndCompany;
	@FindBy(xpath="//a[@sectionid='mylynx3']")							WebElement UploadRelatedDocmnet2ndCompny;	
	@FindBy(xpath="//a[@sectionid='mylynx3']") 						    WebElement Cand_BGCdoc;
	@FindBy(xpath="//a[@sectionid='mylynx3']") 					 		WebElement Cand_upload_BGCdoc;*/
	
	// Candidate Skills information
	
	@FindBy(xpath="//a[@href='#new_candskillstab']") 				WebElement SkillsInfo_Tab;
	@FindBy(xpath="//input[@id='checkThisSkill_1']") 				WebElement skills_selecticon;
	@FindBy(xpath="//button[@id='candProfileUpload']") 				WebElement Cand_profile_upload;
	@FindBy(xpath="//input[@id='uploadfileName']") 					WebElement Cand_profile_browse;
	@FindBy(xpath="//textarea[@id='upload_comment']") 				WebElement Cand_profile_comments;
	@FindBy(xpath="//button[@id='cand_AadharUpload']") 				WebElement Cand_profile_uploadingbutton;
	@FindBy(xpath="//a[@id='candProfileDownload']") 				WebElement Candprofile_downloadlink;
	
	
		
	//Candidate Background verification 
	@FindBy(xpath="//a[@href='#new_candBgVerificationDoc']") 			WebElement BGVinfo_Tab;
	@FindBy(xpath="//button[@onclick='addUploadBVRowCand()']") 			WebElement AddBGCdocument_Button;	
	@FindBy(xpath=".//*[@id='cand_backroundVerifyDocs']/tbody/tr/td[2]/button") WebElement uploadBGCdoc_button;
	@FindBy(xpath="//input[@id='uploadfileName']") 						WebElement DocBrowse_Button;
	@FindBy(xpath="//textarea[@id='upload_comment']") 						WebElement UploadBGC_Comments;
	@FindBy(xpath="//button[@id='candidate_uploadBGC']") 					WebElement uploadBGC_Popupbutton;
	@FindBy(xpath="//div[@class='toast-message hide show']") 			WebElement BGCfileuploaded_status;
	
		

	
	   
	    //orientation tab
	  
		@FindBy(xpath="//button[@id='offerLinkId']")                                WebElement orientation_link;
		@FindBy(xpath="//button[@onclick='uploadOfferLetter()']")                   WebElement uploaded_offerletter;
		@FindBy(xpath="//video[@id='videoTagId']")                                  WebElement orientation_video;
		@FindBy(xpath="//button[@onclick='uploadOfferLetter()']")                   WebElement upload_browse;
		@FindBy(xpath="//button[@id='offerLetterUploadConfirmationId']")            WebElement upload_close;
		@FindBy(xpath="//div[contains(.,'XFile uploaded successfully')]")           WebElement upload_status;
		//questionnarie form
		
		@FindBy(xpath="//a[@href='#new_cand_orientationppt']")                      WebElement orientation_tab;
		@FindBy(xpath="//input[@value='Download PPT']")                             WebElement orientation_ppt;
		@FindBy(xpath="//button[@id='orientationTestResultFailId']")                WebElement Guide_Lines;
		@FindBy(xpath="//p[@id='question1']")                                       WebElement questionnarie1;
		@FindBy(xpath="//p[@id='question2']")                                       WebElement questionnarie2;
		@FindBy(xpath="//p[@id='question3']")                                       WebElement questionnarie3;
		@FindBy(xpath="//p[@id='question4']")                                       WebElement questionnarie4;
		@FindBy(xpath="//p[@id='question5']")                                       WebElement questionnarie5;
		@FindBy(xpath="//p[@id='question6']")                                       WebElement questionnarie6;
		@FindBy(xpath="//p[@id='question7']")                                       WebElement questionnarie7;
		@FindBy(xpath="//p[@id='question8']")                                       WebElement questionnarie8;
		@FindBy(xpath="//p[@id='question9']")                                       WebElement questionnarie9;
		@FindBy(xpath="//p[@id='question10']")                                      WebElement questionnarie10;
		//answers
		
		@FindBy(xpath="//input[@id='optionB0']")                                    WebElement answer1;
		@FindBy(xpath="//input[@id='optionA1']")                                    WebElement answer2;
		@FindBy(xpath="//input[@id='optionC2']")                                    WebElement answer3;
		@FindBy(xpath="//input[@id='optionD3']")                                    WebElement answer4;
		@FindBy(xpath="//input[@id='optionA4']")                                    WebElement answer5;
		@FindBy(xpath="//input[@id='optionB5']")                                    WebElement answer6;
		@FindBy(xpath="//input[@id='optionA6']")                                    WebElement answer7;
		@FindBy(xpath="//input[@id='optionB7']")                                    WebElement answer8;
		@FindBy(xpath="//input[@id='optionB8']")                                    WebElement answer9;
		@FindBy(xpath="//input[@id='optionB9']")                                    WebElement answer10;
		//next buttons
		
		@FindBy(xpath=".//*[@id='fieldset1']/input")                                WebElement next_question1;
		@FindBy(xpath=".//*[@id='msform']/fieldset[2]/input[2]")                    WebElement next_question2;
        @FindBy(xpath=".//*[@id='msform']/fieldset[3]/input[2]")                    WebElement next_question3;
        @FindBy(xpath=".//*[@id='msform']/fieldset[4]/input[2]")                    WebElement next_question4;
		@FindBy(xpath=".//*[@id='msform']/fieldset[5]/input[2]")                    WebElement next_question5;
		@FindBy(xpath=".//*[@id='msform']/fieldset[6]/input[2]")                    WebElement next_question6;
		@FindBy(xpath=".//*[@id='msform']/fieldset[7]/input[2]")                    WebElement next_question7;
		@FindBy(xpath=".//*[@id='msform']/fieldset[8]/input[2]")                    WebElement next_question8;
		@FindBy(xpath=".//*[@id='msform']/fieldset[9]/input[2]")                    WebElement next_question9;
		//missing questions text
		
		@FindBy(xpath="//li[@id='1']")                                              WebElement missing_question1;
		@FindBy(xpath="//li[@id='2']")                                              WebElement missing_question2;
		@FindBy(xpath="//li[@id='3']")                                              WebElement missing_question3;
		@FindBy(xpath="//li[@id='4']")                                              WebElement missing_question4;
		@FindBy(xpath="//li[@id='5']")                                              WebElement missing_question5;
		@FindBy(xpath="//li[@id='6']")                                              WebElement missing_question6;
		@FindBy(xpath="//li[@id='7']")                                              WebElement missing_question7;
		@FindBy(xpath="//li[@id='8']")                                              WebElement missing_question8;
		@FindBy(xpath="//li[@id='9']")                                              WebElement missing_question9;
		@FindBy(xpath="//li[@id='10']")                                             WebElement missing_question10;
		//wrong answeres
		
		@FindBy(xpath="//input[@id='optionB1']")                                    WebElement wrong_answer2;
		@FindBy(xpath="//input[@id='optionA2']")                                    WebElement wrong_answer3;
		@FindBy(xpath="//input[@id='optionB3']")                                    WebElement wrong_answer4;
		@FindBy(xpath="//input[@id='optionB4']")                                    WebElement wrong_answer5;
		@FindBy(xpath="//input[@name='submit']")                                    WebElement submit;
        @FindBy(xpath="//input[@name='previous']")                                  WebElement previous_question;
        @FindBy(xpath=".//*[@id='genericModal-size']/div/div[1]/button")            WebElement close_failre;
		@FindBy(xpath=".//*[@id='genericModal-body']/br[1]")                        WebElement pass;
        @FindBy(xpath="//div[@id='genericModal-body']")                             WebElement result;
    	@FindBy(xpath="//input[@type='search']")                                    WebElement search_text;
    @FindBy(xpath="//span[contains(.,'Please select an answer for question 1 .')]") WebElement popup_text;
	@FindBy(xpath = "//*[@id='newEmployeeOfferId']") 			                    WebElement CloseOrintaion;
       @FindBy(xpath="//a[@sectionid='mylynx")                                      WebElement orientation_Status_pending;
	   @FindBy(xpath="//td[contains(.,'Orientation Completed')]")                   WebElement orientation_completed;
	   @FindBy(xpath="//a[@sectionid='mylynx3']")                                   WebElement orientation_inprogress;
	   @FindBy(xpath="//a[@sectionid='mylynx3']")                                   WebElement orientation_Status;
	   @FindBy(xpath="//button[@id='orientationTest_History']")                     WebElement orientatioan_history;
	   @FindBy(xpath="//button[@id='orientationTestHistoryId']")                    WebElement close_orientation_history;
	   //progress_bar
		
		@FindBy(xpath="//div[@id='myBar']")                                         WebElement profile_status;
		@FindBy(xpath="//div[@id='myBar']")                                         WebElement percentage_gen;
		@FindBy(xpath="//div[@id='myBar']")                                         WebElement percentage_per;
		@FindBy(xpath="//div[@id='myBar']")                                         WebElement percentage_nominee;
		@FindBy(xpath="//div[@id='myBar']")                                         WebElement percentage_financial;
		@FindBy(xpath="//div[@id='myBar']")                                         WebElement percentage_passport;
		@FindBy(xpath="//div[@id='myBar']")                                         WebElement percentage_edu;
		@FindBy(xpath="//div[@id='myBar']")                                         WebElement percentage_exp;
		@FindBy(xpath="//div[@id='myBar']")                                         WebElement percentage_skill;
		@FindBy(xpath="//a[contains(.,'My Lynx')]")                                 WebElement left_menue;
		@FindBy(xpath="//a[@sectionid='mylynx3']")                                  WebElement decreased_percentage;
		@FindBy(xpath="//a[@sectionid='mylynx3']")                                  WebElement uploadinfile_comments;
		@FindBy(xpath="//a[@sectionid='mylynx3']")                                  WebElement fileuploaded_status;
		@FindBy(xpath="//a[@sectionid='mylynx3']")                                  WebElement salary_capture;

		//Dinesha  Mark as Employeee User Story(#3033, #3034, #3035, #3036)
	      
       @FindBy(xpath="//*[@id='candidate-menu']")        	                WebElement CandidateSubmodule;
		@FindBy(xpath="//*[@id='mylynx']/a") 								WebElement myLynx;
		@FindBy(xpath="//*[@id='candidate-menu']") 							WebElement CandidateModule;
		@FindBy(xpath="//*[@id='candidate_home_filter']/label/input")		WebElement SearchfieldCandidate;
		@FindBy(xpath="//*[@id='candidate_home']/tbody/tr[1]")		 		WebElement SelectCandidate;
		@FindBy(xpath="//*[@id='candidate_New_Employee']") 			 		WebElement MarkasEmployee;
		@FindBy(xpath="//*[@id='markAsEmployeeId']")				 		WebElement Employee_ID;
		@FindBy(xpath="//*[@id='markAsEmployeeFirstname']")		     		WebElement FirstName;
		@FindBy(xpath="//*[@id='markAsEmployeeLastname']")			 		WebElement LastName;
		@FindBy(xpath="//*[@id='employeeNewPopupId']") 				 		WebElement ConfirmButtonMarkAsEmp;
		@FindBy(xpath="//*[@id='genericModal-buttons']/button[2]")	 		WebElement CloseButton;
		@FindBy(xpath="//*[@id='markAsEmployeeEmailId']") 		     		WebElement Email_ID;
		@FindBy(xpath="//*[@id='genericModal-title']")               		WebElement NewEmpDetails;
		@FindBy(xpath="//div[@id='markAsEmployeeAvaiEmailIds']/div[1]/input")WebElement Emailone;
		@FindBy(xpath="//div[@id='markAsEmployeeAvaiEmailIds']/div[2]/input")WebElement EmailTwo;
		@FindBy(xpath="//div[@id='markAsEmployeeAvaiEmailIds']/div[3]/input")WebElement EmailThree;
		@FindBy(xpath="//div[@id='markAsEmployeeAvaiEmailIds']/div[4]/input")WebElement EmailFour;
		@FindBy(xpath="//div[@id='markAsEmployeeAvaiEmailIds']/div[5]/input")WebElement EmailFive;
		@FindBy(xpath="//*[@id='markAsEmployeePassword']")					 WebElement emailpwd;
		@FindBy(xpath = "//*[@id='candidate_home']/tbody/tr[1]/td[5]")	     WebElement CandidateStatus;
		@FindBy(xpath="//*[@id='candidate_new'][2]") 						 WebElement RefreshButton;
		@FindBy(xpath = "//*[@id='email-list']/li[1]/a")                 	 WebElement selectTopMail;
		@FindBy(xpath = "//*[@id='email-list']/li[1]/div/dl/dd[2]")    		 WebElement mailFrom;
		@FindBy(xpath = "//*[@id='email-list']/li[1]/div/dl/dd[1]")    		 WebElement mailTo;
		@FindBy(xpath = "//table/tbody/tr[1]/td[1]/b")  		          		 WebElement EmployeeName;
		@FindBy(xpath = "//table/tbody/tr[2]/td/b[1]")                	 WebElement employyeIDmail;
		@FindBy(xpath = "//table/tbody/tr[2]/td/b[2]")                	 WebElement officialmaiId;
		@FindBy(xpath = "//table/tbody/tr[2]/td/b[3]")                	     WebElement officialmaiIdpwd;
		@FindBy(xpath = "//table/tbody/tr[2]/td/b[4]")				 WebElement usernameLynx;
		@FindBy(xpath = "//table/tbody/tr[2]/td/b[5]") 				 WebElement paswordLynx;
		@FindBy(xpath="//input[@id='uname']") 								 WebElement Username_InputNeWEMP;
		@FindBy(xpath="//input[@id='pass']")                                 WebElement Password_InputnEWeMP;
		@FindBy(xpath="//button[text()='Sign in']")                          WebElement SignIn_Button;
		@FindBy(xpath = "//*[@id='currentDateTime'] ") 				         WebElement dateTime;
		 
		//New Changes Locators  
		@FindBy(xpath = "//*[@id='rmg-menu']/a")         		 			 WebElement RMGModule;
		@FindBy(xpath = "//*[@id='employee-menu']")	     					 WebElement employeeModule;
		@FindBy(xpath = "//*[@id='employee_home_filter']/label/input")       WebElement searchfieldemp;
		@FindBy(xpath = "//*[@id='employee_home']/tbody/tr[1]") 		 	 WebElement selectemployee;
		@FindBy(xpath = "//*[@id='offerLetterPopupEmpId']") 				 WebElement approveButton;
		@FindBy(xpath = "//*[@id='employee_new'][2]") 				   	 	 WebElement refreshButtonEmp;
		@FindBy(xpath = "//*[@id='candidate_home']/tbody/tr[1]/td[9]")       WebElement preReject;
		@FindBy(xpath = "//*[@id='Lev']/li[1]/a")         		 			 WebElement myEmployees;
		@FindBy(xpath = "//*[@id='employee_home']/tbody/tr[1]/td[1]")	     WebElement generatedempid;
		@FindBy(xpath = "//*[@id='employee_home']/tbody/tr[1]/td[2]")        WebElement employeeName;
		@FindBy(xpath = "//*[@id='employee_home']/tbody/tr[1]/td[3]") 		 WebElement employeemailid;
		@FindBy(xpath = "//*[@id='employee_home']/tbody/tr[1]/td[4]")        WebElement empphNum;
		@FindBy(xpath = "//*[@id='employee_home']/tbody/tr[1]/td[5]")	     WebElement empDept;
		@FindBy(xpath = "//*[@id='employee_home']/tbody/tr[1]/td[6]")        WebElement empDesignation;
		@FindBy(xpath = "//*[@id='employee_home']/tbody/tr[1]/td[7]") 		 WebElement empspocname;
		@FindBy(xpath = "//*[@id='employee_home']/tbody/tr[1]/td[8]") 		 WebElement empcuurentProject;
		@FindBy(xpath = "//*[text()='Pending Procedure Alert..!!']") 		 WebElement ooferlinktextpopup;
		
		
		
		// offer Letter Generation mail        
		@FindBy(xpath = "//*[@id='generate_Offer_Letter']")         		 WebElement GenenerateOfferletter;
		@FindBy(xpath = "//div/h4[text()='New Employee Offer Letter']")	     WebElement newempofferleterpopup;
		@FindBy(xpath = "//*[@id='offerLetterPopupId']")                   	 WebElement submitofferletter;
		@FindBy(xpath = "//*[@id='employee_home']/tbody/tr[1]/td[9]") 		 WebElement statusbeforGOF;
		@FindBy(xpath = "//table/tbody/tr/td/p[2]/b[1]") 				   	 WebElement OFGEmployeename;
		@FindBy(xpath = "//table/tbody/tr/td/p[2]/b[2]") 				   	 WebElement OFGByName;
		@FindBy(xpath = "//*[@id='employee_home']/tbody/tr[1]/td[9]/div")    WebElement statusafterGOF;
		
		
		//RMG Manager Level Approve Reject Offer Letter Functionality
		@FindBy(xpath = "//*[@id='candToApprove']") 					    WebElement ActionTab;
		@FindBy(xpath = "//*[@id='toApproveManager_filter']/label/input")   WebElement SearchFieldRMGTab;
		@FindBy(xpath = "//*[@id='toApproveManager']/tbody/tr[1]/td[7]")    WebElement StatusinRMG;
		@FindBy(xpath = "//*[@id='toApproveManager']/tbody/tr[1]") 			WebElement selectCandidateActionTab ;
		@FindBy(xpath = "//*[@id='toapprove_Offer_Letter']") 				WebElement ApprovebyRMGmgr;
		@FindBy(xpath = "//*[@id='toreject_Offer_Letter']") 				WebElement RejectbyRMGmgr; 
		@FindBy(xpath = "//*[@id='upload_comment']")						WebElement reasonbyRMGmgr;
		@FindBy(xpath = "//*[@id='rejectOfferLetterPopupId']") 				WebElement submitReasonbutton;
		@FindBy(xpath = "//*[@id='toapprove_Offer_Letter'][2]") 			WebElement refreshbuttonRMGMgr;
		@FindBy(xpath = "//*[@id='upload_Offer_Letter']") 					WebElement UploadofferLetterMGR;
		@FindBy(xpath = "//h4[text()='Upload Offer Letter']") 				WebElement uploadPopUp;
		@FindBy(xpath = "//*[@id='uploadfileName']") 						WebElement selectFileUpload;
		@FindBy(xpath = "//*[@id='offer_Letter_upload_Mng']") 				WebElement UploadButton;
		
		//Employee Level   
		@FindBy(xpath = "//ul/li[@id='cand_OfferLetter']/a") 					   WebElement offerLetterGTab;
		@FindBy(xpath = "//*[@id='new_cand_OfferLetter']/div[2]/div[1]/button[1]") WebElement AcceptButton; 
		@FindBy(xpath = "//button[@id='salAction']") 						       WebElement downloadofferleter; 
		@FindBy(xpath = "//*[@id='new_cand_OfferLetter']/div[2]/div[1]/button[3]") WebElement uploadofferletterIcon;
		@FindBy(xpath = "//*[@id='uploadfileName']") 							   WebElement ChooseOfferletter;
		@FindBy(xpath = "//*[@id='uploadOfferLetter']") 						   WebElement UploadOfferletter;
		@FindBy(xpath = "//*[@id='new_cand_OfferLetter']/div[2]/div[1]/button[2]") WebElement rejectofferletterIcon;
		@FindBy(xpath = "//*[@id='rejectCommentsCand1']") 						   WebElement Reasonone;
		@FindBy(xpath = "//*[@id='rejectCommentsCand2']") 						   WebElement Reasontwo;
		@FindBy(xpath = "//*[@id='rejectCommentsCand3']") 						   WebElement Reasonthree;
		@FindBy(xpath = "//*[@id='rejectCommentsCand4']") 						   WebElement Reasonothers;
		@FindBy(xpath = "//*[@id='myCheck1']") 									   WebElement Checkboxone;
		@FindBy(xpath = "//*[@id='myCheck2']") 									   WebElement Checkboxtwo;
		@FindBy(xpath = "//*[@id='myCheck3']") 									   WebElement Checkboxthree;
		@FindBy(xpath = "//*[@id='myCheck4']") 									   WebElement Checkboxothers;
		@FindBy(xpath = "//*[@id='rejectOfferLetterCand']") 					   WebElement Rejectwithreason;
		@FindBy(xpath = "//*[@id='offerLinkId']") 				         	       WebElement offerlinkcand;
		@FindBy(xpath = "//*[@id='offerLetterUploadConfirmationId']") 			   WebElement CloseAlert;
		@FindBy(xpath = "//*[@id='newEmployeeOfferId']") 			               WebElement CloseOrintaionpopup;
		//Logout the Lynx
		
		@FindBy(xpath="//span[@id='dynamic_username']")        			    		WebElement Username_Logout;
		@FindBy(xpath="//a[@href='javascript:logout();']")        			    	WebElement Logout;
		

		//Candidate logout
		@FindBy(xpath="//span[@id='dynamic_username']")        						WebElement Dynamic_user;
		@FindBy(xpath="//a[@href='javascript:logout();']")        					WebElement Dynamic_userlogout;
		int test_count=0;

		/*
		Login method with its required webElement for validating the link shared to the candidate personal mail ID(Akash.Anand)
		*/
		@FindBy(xpath="//input[@id='home-email']")        			    			WebElement Username_Input;
		@FindBy(xpath="//button[@id='copy-button']")        			    		WebElement CopyId_Button;
		@FindBy(xpath="//button[@id='domain-select']")        			    		WebElement Domain_Button;
		@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/li/a") 		WebElement Domain_Dropdown_values;
		@FindBy(xpath="//ul[@id='email-list']/li[1]")        			   			WebElement Topmost_Mail;
		@FindBy(xpath="//ul[@id='email-list']/li[1]/a/div/div[2]/p")  				WebElement Mail_Subject;
	    @FindBy(xpath=".//*[@id='email-list']/li[1]/div/dl/dd[2]")        			WebElement From_MailID;
	    @FindBy(xpath=".//*[@id='email-list']/li[1]/div/dl/dd[3]")        			WebElement WelcomeMail_Subject;
		@FindBy(xpath="//table[@cellspacing='6']/tbody/tr/td/div/p[1]")        		WebElement Candidate_FirstName;
		@FindBy(xpath="//a[@target='_blank']")        			   					WebElement Lynx_Link;
		
		/*
		Some General locators
		*/
		@FindBy(xpath="//span[@id='dynamic_username']") 							WebElement Account_HolderName;
		@FindBy(xpath="//div[@id='candidate_home_filter']/label/input") 			WebElement Search_Table_InputBox;
		@FindBy(xpath="//div[@id='toaster']/span[2]")        			    		WebElement GenericToastMsg;
		@FindBy(xpath="//div[@id='cand_toHandle_table_filter']/label/input") 		WebElement ToHandleTableSearch_InputBox;
		@FindBy(xpath="//a[text()='My Candidates']")        						WebElement My_CandidateTab;
		@FindBy(xpath="//a[@id='candToHandle']")        							WebElement To_HandleTab;
		@FindBy(xpath="//div[@id='employee_home_filter']/label/input")        		WebElement Employees_SearchInput;
		@FindBy(xpath="//div[@class='scroller scroller-left']")        				WebElement Emp_ScrollLeft;
		@FindBy(xpath="//div[@class='scroller scroller-right']")        			WebElement Emp_ScrollRight;
		@FindBy(xpath="//a[@href='#new_empgen']")        			    			WebElement EmpGeneralInfo_Tab;
		
		/*
		RM Reporting details and IT requirements details WebElements
		*/
		
		@FindBy(xpath="//a[@href='#cand_new_empgen']")        			    		WebElement GeneralInfo_Tab;
		@FindBy(xpath="//span[@id='viewHeadingCand']")        			    		WebElement View_Details_Name;
		@FindBy(xpath="//td[@id='cand_gen_firstname']")        			    		WebElement View_CandFirstname;
		@FindBy(xpath="//td[@id='cand_gen_lastname']")        			    		WebElement View_CandLastname;
		@FindBy(xpath="//td[@id='cand_gen_doj']") 									WebElement View_DateOfJoining;
		@FindBy(xpath="//td[@id='cand_gen_location']") 								WebElement View_Joining_Location;
		@FindBy(xpath="//td[@id='cand_gen_rm']")        			   				WebElement View_RM_Name;
		@FindBy(xpath="//td[@id='gen_projects']")        			   				WebElement View_Project_Name;
		@FindBy(xpath="//td[@id='gen_empid']")        			   					WebElement View_EMPID;
		@FindBy(xpath="//td[@id='gen_firstname']")        			    			WebElement View_EMPFirstname;
		@FindBy(xpath="//td[@id='gen_lastname']")        			    			WebElement View_EMPLastname;
		@FindBy(xpath="//a[text()='Reporting Details']")  						    WebElement Reporting_Details_Tab;
		@FindBy(xpath="//input[@id='cand_Reporting_radio']") 						WebElement ReportingDetails_RadioButton;
	    @FindBy(xpath="//span[@id='cand_rep_name']")        						WebElement Reporting_Cand_Fullname;
		@FindBy(xpath="//span[@id='cand_rep_date']")        						WebElement Reporting_Cand_DOJ;
		@FindBy(xpath="//input[@id='cand_rep_time']")        						WebElement Reporting_Time;
		@FindBy(xpath="//span[@id='cand_rep_location']")        					WebElement Reporting_Location;
		@FindBy(xpath="//span[@id='cand_rep_contactPerson']")        			   	WebElement Reporting_Contact_PersonName;
		@FindBy(xpath="//span[@id='cand_rep_contactno']")        			    	WebElement Reporting_RMG_ContactNO;
		@FindBy(xpath="//button[@id='rm_submitRep']")        			    		WebElement Reporting_Details_RMSubmitButton;
	    @FindBy(xpath="//button[@id='rmg_submit']")        							WebElement Reporting_RMGSubmit_Button;
		@FindBy(xpath="//button[@id='candClientSave']")        			    	    WebElement Client_RMSaveButton;
	    @FindBy(xpath="//button[@id='candClientSubmitRM']")        					WebElement Client_RMSubmit_Button;
	    @FindBy(xpath="//button[@id='candClientSave']")        			    	    WebElement Client_RMGSaveButton;
	    @FindBy(xpath="//button[@id='candClientSubmitRMG']")        				WebElement Client_RMGSubmit_Button;
	    @FindBy(xpath="//input[@id='cand_client_radio']") 							WebElement ClientReporting_RadioButton;
	    @FindBy(xpath="//select[@id='candClientCompany']")        					WebElement Client_Companyname;
	    @FindBy(xpath="//select[@id='candClientRegion']")        					WebElement Client_Region;
	    @FindBy(xpath="//select[@id='candClientDept']")        						WebElement Client_Department;
	    @FindBy(xpath="//select[@id='candClientProjects']")        					WebElement Client_Project;
	    @FindBy(xpath="//input[@id='cand_client_date']")        					WebElement DOJ_Calendar;
	    @FindBy(xpath="//select[@class='ui-datepicker-month']")        				WebElement Client_Month_DD;
	    @FindBy(xpath="//select[@class='ui-datepicker-year']")        				WebElement Client_Year_DD;
	    @FindBy(xpath="//input[@id='cand_client_time']")        					WebElement Client_Time;
	    @FindBy(xpath="//input[@id='cand_client_venue']")        					WebElement Client_Venue;
	    @FindBy(xpath="//input[@id='cand_client_repManager']")        				WebElement Client_RM;
	    @FindBy(xpath="//input[@id='cand_client_contactPerson']")        			WebElement ClientContact_Person;
	    @FindBy(xpath="//input[@id='cand_client_contactno']")        				WebElement ClientContact_Number;
	    @FindBy(xpath="//button[@id='candClientSave']")        						WebElement Client_Save_Button;
		@FindBy(xpath="//a[text()='IT Requirement']")        			    		WebElement IT_Requirement_Tab;
		@FindBy(xpath="//input[@id='cand_it_req_yes']") 							WebElement IT_Requirement_RadioButtonYES;
		@FindBy(xpath="//input[@id='cand_it_req_no']") 								WebElement IT_Requirement_RadioButtonNo;
		@FindBy(xpath="//input[@id='emp_it_req_yes']")								WebElement IT_ReqEMPRadioYES;
		@FindBy(xpath="//select[@id='cand_it_hardware']")        			   		WebElement Hardware_Support_DD;
		@FindBy(xpath="//select[@id='cand_it_software']")  							WebElement Software_Support_DD;
	    @FindBy(xpath="//input[@id='cand_it_typeofOS']")        					WebElement OS_Type;
	    @FindBy(xpath="//input[@id='cand_it_peripherals']")        					WebElement IT_Peripherals_Input;
		@FindBy(xpath="//textarea[@id='cand_it_comments']")        					WebElement IT_Comments_Input;
		@FindBy(xpath="//button[@id='cand_it_save']")        			   			WebElement IT_Save_Button;
		@FindBy(xpath="//button[@id='cand_it_submit']")        						WebElement IT_Submit_Button;
		@FindBy(xpath="//button[@id='back_out']")        							WebElement Cand_Backout;
		@FindBy(xpath="//button[@id='employee_abscond']")        					WebElement Emp_Abscond;
		
		/*	
		Some mandatory fields locators path for validation
		*/
	   
		//Client Reporting Details
		@FindBy(xpath="//div[@id='showCandClientDetailsUI']/div[1]/div[1]/span")    WebElement CompanyField;
		@FindBy(xpath="//div[@id='showCandClientDetailsUI']/div[2]/div[1]/span")    WebElement RegionFields;
		@FindBy(xpath="//div[@id='showCandClientDetailsUI']/div[3]/div[1]/span")    WebElement DepartmentFields;
		@FindBy(xpath="//div[@id='showCandClientDetailsUI']/div[4]/div[1]/span")    WebElement ProjectFields;
		@FindBy(xpath="//div[@id='showCandClientDetailsUI']/div[5]/div[1]/span")    WebElement DateFields;
		@FindBy(xpath="//div[@id='showCandClientDetailsUI']/div[6]/div[1]")   	    WebElement TimeFields;
		@FindBy(xpath="//div[@id='showCandClientDetailsUI']/div[7]/div[1]/span")    WebElement VenueFields;
		@FindBy(xpath="//div[@id='showCandClientDetailsUI']/div[8]/div[1]/span")    WebElement RMFields;
		@FindBy(xpath="//div[@id='showCandClientDetailsUI']/div[9]/div[1]")   	    WebElement ContactPersonFields;
		@FindBy(xpath="//div[@id='showCandClientDetailsUI']/div[10]/div[1]/span")   WebElement ContactFields;
		@FindBy(xpath="//div[@id='candItReqNoHide']/div[1]/div[1]/span")  		    WebElement IT_hardwareFields;
		
		/*
		ADF elements path for Admin
		*/
		@FindBy(xpath="//button[@id='cand_it_accept']") 							WebElement ADF_Accept;
		@FindBy(xpath="//button[@id='cand_it_reject']") 							WebElement ADF_Reject;
		@FindBy(xpath="//*[@id='remark']") 											WebElement ADF_RejectComment_Box;
		@FindBy(xpath="//button[@id='onCandIt_Reject']") 							WebElement ADF_RejectSubmit_Button;
		@FindBy(xpath="//div[@id='genericModal-buttons']/button[2]") 				WebElement ADF_RejectClose_Button;
		@FindBy(xpath="//button[@id='cand_it_Adf']") 								WebElement ADF_Button;
		@FindBy(xpath="//button[@id='cand_it_view']") 								WebElement ADF_ViewButton;
		@FindBy(xpath="//button[@id='emp_it_view']") 								WebElement ADF_ViewButtonEMP;
		@FindBy(xpath="//div[@id='genericModal-body']/div/div[1]/button")           WebElement ADF_AddButton;
		@FindBy(xpath="//button[@id='candItAcceptFillLater']")        				WebElement ADF_FillLater_Button;
		@FindBy(xpath="//button[@id='candItAcceptSubmit']")        					WebElement ADF_Submit_Button;
		@FindBy(xpath="//div[@id='genericModal-buttons']/button[3]")        		WebElement ADF_Close_Button;
		@FindBy(xpath="//span[@id='emp_name']")        								WebElement ViewADF_EmpName;
		@FindBy(xpath="//span[@id='emp_Id']")        								WebElement ViewADF_EmpID;
		@FindBy(xpath="//span[@id='proj_name']")        							WebElement ViewADF_ProjName;
		@FindBy(xpath="//input[@id='candAssetViewDateofIssue']")        			WebElement ViewADF_IssueDate;
		@FindBy(xpath="//button[@id='print_adf_form']")        						WebElement ViewADF_PrintButton;
		@FindBy(xpath="//button[@id='candItSendMail']")        						WebElement ViewADF_SendMailButton;
		@FindBy(xpath="//input[@id='candAssetViewDateofIssue']")        			WebElement DOI_Calendar;

		/*
		Candidate ADF view locators in Update Profile window
		*/
		
		@FindBy(xpath="//a[@href='#new_empgen']")        							WebElement Cand_GeneralInfo;
		@FindBy(xpath="//a[@href='#new_cand_ItReqCandidate']")        				WebElement Cand_ITRequirement;
		@FindBy(xpath="//button[@id='candAssetUploadCandidate']")        			WebElement CandADF_Upload;
		@FindBy(xpath="TO-DO")        												WebElement CandADF_View;
		@FindBy(xpath="//a[@id='rightdropdownu']")        							WebElement Cand_UpdateProfile;
		@FindBy(xpath="//a[@id='username']")        								WebElement Account_Info;
		
		/*
		Employee module locators
	   */
		
		@FindBy(xpath="//input[@id='emp_Reporting_radio']") 						WebElement EMPReporting_RadioButton;
		@FindBy(xpath="//input[@id='emp_client_radio']") 						    WebElement EMPClientReporting_RadioButton;
		@FindBy(xpath="//button[@id='empClientSave']")        			    	    WebElement EMPClient_RMGSaveButton;
	    @FindBy(xpath="//button[@id='empClientSubmitRMG']")        					WebElement EMPClient_RMGSubmit_Button;
		

		//Method to redirect to the Fake Inbox for validating the link shared to the candidate mail ID
		public String welcome_mail_validation(String username, String Emp_Firstname, String domain_name)
		{
			driver.get("http://www.fakemailgenerator.com/");
			Waitfor(3);
			Username_Input.sendKeys(Keys.chord(Keys.CONTROL, "a"), username);
			Waitfor(1);
			CopyId_Button.click();
			Waitfor(2);
			Domain_Button.click();

			List<WebElement> rowVals = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li/a"));
			
			for (WebElement webElement : rowVals) {
				
				String domain= webElement.getText();
			
				
				if(domain.equalsIgnoreCase(domain_name))
				{
					webElement.click();
					
					break;
				}
			}
			
			Waitfor(3);
			Topmost_Mail.click();
			Waitfor(2);
			//Validating the mail Subject content
			String subject= Mail_Subject.getText();
			if(subject.contains("Welcome to Diksha"))
			{
				logger.info("Candidate has received the Diksha Welcome Mail");
			}
			else
			{
				logger.info("Candidate has not received the Diksha Welcome Mail");
			}
			Waitfor(1);
			//Validating the mail From ID
			String from_Id= From_MailID.getText();
			if(from_Id.contains("admin.portal@dikshatech.com"))
			{
				logger.info("Diksha Welcome Mail has been sent by RMG department-(admin.portal@dikshatech.com)");
			}		
			else
			{
				logger.info("Diksha Welcome Mail has not been sent by RMG department-(admin.portal@dikshatech.com)");
			}
			
			//Validating the Candidate first name
//			String cand_firstname= driver.findElement(By.xpath("//table[@cellspacing='6']/tbody/tr/td/div/p[1]")).getText();
//			Waitfor(1);
//			if(cand_firstname.contains(Emp_Firstname))
//			{
//				logger.info("Candidate first name is matching in the Diksha Welcome Mail");
//			}
//			else
//			{
//				logger.info("Candidate first name is not matching in the Diksha Welcome Mail");
//			}
			
	        Waitfor(2);
	        WebElement frame=driver.findElement(By.xpath("//iframe[@id='emailFrame']"));
			driver.switchTo().frame(frame);
			Waitfor(2);
	        String candidate_link= driver.findElement(By.xpath("//a[@target='_blank']")).getAttribute("href");
	        Waitfor(2);
	        return candidate_link;
		}
		
		//To check the Candidate employment status from the Candidate Landing page for all the roles/level(Akash.Anand)
		public String getcandidate_ID(String candname, String status)
		{
			MYLynx_Module.click();
			Waitfor(1);
			Candidate_Submodule.click();
			
				Waitfor(3);
				Search_Table_InputBox.sendKeys(Keys.chord(Keys.CONTROL, "a"),candname);
				Waitfor(1);
			
				Actions action = new Actions(driver);
				int count = 0;
				String candidateID= "";
				String col_text = "Name";
				List<WebElement> page = driver.findElements(By.xpath("//div[@id='candidate_home_paginate']/span/a"));
				if (page.size() > 0) {
				for (int i = 1; i <=page.size(); i++) 
				{
					if(i>1)
					{	
					driver.findElement(By.xpath("//div[@id='candidate_home_paginate']/span/a[" + (i) + "]")).click();
					Waitfor(1);
					}
				WebElement table = driver.findElement(By.xpath("//table[@id='candidate_home']/thead/tr"));
				List<WebElement> heading = table.findElements(By.tagName("th"));
				for (int h = 0; h < heading.size(); h++) {
					String text = heading.get(h).getText();
					if (col_text.equalsIgnoreCase(text)) {
						int col = h;
						WebElement row_table = driver.findElement(By.xpath("//table[@id='candidate_home']/tbody"));
						List<WebElement> rows = row_table.findElements(By.tagName("tr"));
						logger.info(rows.size());
						for (int c = 1; c <= rows.size(); c++) {
							
							String cell_Value = driver
									.findElement(By.xpath("//table[@id='candidate_home']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
									.getText();
							Waitfor(2);
							String array[] = { "Candidate Created", "Approved", "Rejected", "Completed", "Submitted" };
							
							if (cell_Value.equalsIgnoreCase(candname)) {
								
								WebElement report= driver.findElement(By.xpath("//table[@id='candidate_home']/tbody/tr[" + c + "]/td[1]"));
								action.click(report).build().perform();
								Waitfor(2);
								candidateID= driver.findElement(By.xpath("//table[@id='candidate_home']/tbody/tr[" + c + "]/td[1]")).getText();
								logger.info("The newly created Candidate ID is: "+candidateID);
								count++;
				
								break;
							}
							else 
							{
							logger.info("No candidate record found with "+candname+ "name" );
							}
						}
						if(count>0)
						{
						break;
						}
					}
					else 
						{
						logger.info("There is no record matched with the passed Status & Emp-ID found in Candidate table..!!");	
						}
				    }		
					if(count>0)
					{
					break;
					}
					}
						
				}
				return candidateID;
			}


		
		//To check the Candidate employment status from the Candidate Landing page for all the roles/level(Akash.Anand)
		public String candidate_employment_statuscheck(String emp_ID, String status)
		{
			MYLynx_Module.click();
			Waitfor(1);
			Candidate_Submodule.click();
			
				Waitfor(3);
				Search_Table_InputBox.sendKeys(Keys.chord(Keys.CONTROL, "a"),emp_ID);
				Waitfor(1);
			
				Actions action = new Actions(driver);
				int count = 0;
				String fail= "";
				String col_text = "Candidate ID";
				List<WebElement> page = driver.findElements(By.xpath("//div[@id='candidate_home_paginate']/span/a"));
				if (page.size() > 0) {
				for (int i = 1; i <=page.size(); i++) 
				{
					if(i>1)
					{	
					driver.findElement(By.xpath("//div[@id='candidate_home_paginate']/span/a[" + (i) + "]")).click();
					Waitfor(1);
					}
				WebElement table = driver.findElement(By.xpath("//table[@id='candidate_home']/thead/tr"));
				List<WebElement> heading = table.findElements(By.tagName("th"));
				for (int h = 0; h < heading.size(); h++) {
					String text = heading.get(h).getText();
					if (col_text.equalsIgnoreCase(text)) {
						int col = h;
						WebElement row_table = driver.findElement(By.xpath("//table[@id='candidate_home']/tbody"));
						List<WebElement> rows = row_table.findElements(By.tagName("tr"));
						logger.info(rows.size());
						for (int c = 1; c <= rows.size(); c++) {
							
							String cell_Value = driver
									.findElement(By.xpath("//table[@id='candidate_home']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
									.getText();
							Waitfor(2);
							String array[] = { "Candidate Created", "Approved", "Rejected", "Completed", "Submitted" };
							
							if (cell_Value.equalsIgnoreCase(emp_ID)) {
								
								WebElement report= driver.findElement(By.xpath("//table[@id='candidate_home']/tbody/tr[" + c + "]/td[1]"));
								action.click(report).build().perform();
								Waitfor(2);
								String  s= driver.findElement(By.xpath("//table[@id='candidate_home']/tbody/tr[" + c + "]/td[5]")).getText();
								if(s.equalsIgnoreCase(status))
								{
								logger.info("Status is matching with the passed status & Status is "+s);
								action.doubleClick(report).build().perform();
								Waitfor(2);
								
								// Edit button validation
								boolean generalinfo_Tab_status = GeneralInfo_Tab.isDisplayed();
									if (generalinfo_Tab_status == true) {
										logger.info("General Info Tab is displayed in candidate page and status is :" + generalinfo_Tab_status);
										Waitfor(2);
										
									}
									else
									{
										logger.info("General Info Tab is not present in candidate page and status is :" + generalinfo_Tab_status);
									}
							
									logger.info("The Passed Candidate ID is "+cell_Value);
									count++;
				
									break;
								}
								
								else 
								{
									logger.info("Candidate ID passed is not matching & the current Candidate ID is : "+s);	
								}

							}
							else
							{	
							logger.info("There is no record matched with the passed Status & Cand-ID found in Candidate table..!!");
							
							fail = "No Match found";
							}
						}
						if(count>0)
						{
						break;
						}
					}
					else 
					{
						logger.info("The Column Text is not matching with the passed Column in a table");	
					}
				}
				if(count>0)
				{
				break;
				}
			 }
			}
				return fail;
		}

		//To get the candidate name, joining date & RM Name from the candidate view page general info tab.
		public String get_cand_firstname(String emp_ID, String status)
		{
			candidate_employment_statuscheck(emp_ID, status);
			Waitfor(1);
			String firstname= View_CandFirstname.getText();
			return firstname;
		}
		
		public String get_cand_lastname()
		{
			String lastname= View_CandLastname.getText();
			return lastname;
		}
		public String get_name_joiningdate()
		{
			String doj= View_DateOfJoining.getText();
			return doj;
		}
		public String get_joining_loc()
		{
			String join_loc= View_Joining_Location.getText();
			return join_loc;
		}
		public String get_RMname()
		{
			String rmname= View_RM_Name.getText();
			return rmname;
		}
		public String get_acc_Hldr_Name()
		{
			String name= Account_HolderName.getAttribute("innerText");
			logger.info("Account Holder name on Account_Info Section "+name);
			return name;	
		}
		//To review the candidate reporting details which are backend captured data.
		
		public void rm_reporting_details(String emp_ID, String status, String contact_personname, String rep_time)
		{
			Waitfor(1);
			 ObjectInitClass.HP.Log_Out();
			driver.get("http://172.16.1.32");
			Waitfor(1);
			// Read Excel object creation to pass the sheet parameter.
		  	String RMG_username= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
		  	Waitfor(1);
		  	String RMG_password= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
		  	Waitfor(1);
		  				
		  	 ObjectInitClass.LP.signIn(RMG_username, RMG_password);
			
			String cand_firstname= get_cand_firstname(emp_ID, status);
			String cand_lastname= get_cand_lastname();
			String dateof_joining= get_name_joiningdate();
			String candidate_location= get_joining_loc();			
			String cand_fullname= cand_firstname+" "+cand_lastname; 
			
			String getRM_Name= get_RMname();
			String[] split_space= getRM_Name.split("\\s+");
			String respectiveRM_Name= split_space[0];
			
			 ObjectInitClass.HP.Log_Out();
			Waitfor(1);
			int count = 0;
			// Read Excel object creation to pass the sheet parameter.
			for(int row=1; row<=50; row++)
			{	
			String RM_username= excelreaddata().getData("Login_Credentials", row, 0 ); //Reading Username from excel
			  	if(RM_username.contains(respectiveRM_Name))
			  	{		
				  	String RM_password= excelreaddata().getData("Login_Credentials",row, 1 ); //Reading Password from excel
				  	Waitfor(1);
				  				
				  	 ObjectInitClass.LP.signIn(RM_username, RM_password);
				  	
				  	count++;
			
					Waitfor(2);
					String match_status= candidate_employment_statuscheck(emp_ID, status);
				if(!match_status.contains("No Match found"))
				{
					Waitfor(2);
					reportingdetails_tab();
					String account_holdername= get_acc_Hldr_Name();
					
					if(getRM_Name.equalsIgnoreCase(account_holdername))
					{
						logger.info("The Candidate record lies in the respective RM table.");
						
						boolean report_radio_button= ReportingDetails_RadioButton.isSelected();
						if(report_radio_button==false)
						{	
							Waitfor(1);
							ReportingDetails_RadioButton.click();
							Waitfor(1);
							logger.info("The Reporting details wasn't selected by default");
							Waitfor(1);
						}	
						String candidate_fullname= Reporting_Cand_Fullname.getText();
						if(cand_fullname.equalsIgnoreCase(candidate_fullname))
						{
							logger.info("The Candidate name in Reporting details is matching with the created profile candidate name");
						}
						else
						{
							logger.info("The Candidate name in Reporting details is not matching with the created profile candidate name");
						}	
						String cand_doj= Reporting_Cand_DOJ.getText();
						if(dateof_joining.equalsIgnoreCase(cand_doj))
						{
							logger.info("The Candidate DOJ in Reporting details is matching with the created profile candidate DOJ");
						}
						else
						{
							logger.info("The Candidate DOJ in Reporting details is not matching with the created profile candidate DOJ");
						}
						boolean report_time= Reporting_Time.isEnabled();
						if(report_time==false)
						{
							logger.info("The Reporting Time field is not enable and workinig as expected");
							String reportingtime= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_rep_time').value");
							if(reportingtime.equalsIgnoreCase("09:30"))
							{
								logger.info("The Reporting Time in Reporting details is matching with the default Diksha reporting time.");
							}
							else
							{
							logger.info("The Reporting Time in Reporting details is not matching with the default Diksha reporting time.");
							}
						}
						else
						{
							logger.info("The Reporting Time field shouldn't be editable for RM");
							Reporting_Time.sendKeys(Keys.chord(Keys.CONTROL, "a"),rep_time);
							Waitfor(1);
							Reporting_Contact_PersonName.click();
							Waitfor(1);
						}
						String cand_joining_location= Reporting_Location.getText();
						if(candidate_location.equalsIgnoreCase(cand_joining_location))
						{
							logger.info("The Candidate Joining location in Reporting details is matching with the created profile candidate location");
						}
						else
						{
							logger.info("The Candidate DOJ in Reporting details is not matching with the created profile candidate DOJ");
						}
						
						String contact_person= Reporting_Contact_PersonName.getText();
						if(contact_personname.equalsIgnoreCase(contact_person))
						{
							logger.info("The Conatct Person name in Reporting details is matching with the person name who has created the candidate profile.");
						}
						else
						{
						logger.info("The Conatct Person name in Reporting details is not matching with the person name who has created the candidate profile.");
						}
						String act_rmg_contactnumber= excelreaddata().getData("Login_Credentials", 3, 2 ); //Reading respective RMG Personal Contact Number from excel
					  	Waitfor(1);
					  	String exp_rmg_contactno= Reporting_RMG_ContactNO.getText();
					  	if(act_rmg_contactnumber.equalsIgnoreCase(exp_rmg_contactno) || exp_rmg_contactno.equalsIgnoreCase("9800000000"))
						{
							logger.info("The Conatct Number name in Reporting details is matching with the personal contact number of who has created the candidate profile.");
						}
						else
						{
						logger.info("The Conatct Number name in Reporting details is not matching with the personal contact number of who has created the candidate profile.");
						}
					  	count++;
					}
					else
					{
						logger.info("The Candidate record doesn't lie in the respective/authorized RM table it is present in different/unauthorized account table.");
					}	
				}
				else 
				{
					logger.info("There is no record matched with the passed Status & Emp-ID found in Candidate table..!!");
				}
				if(count>0)
			  	{
			  	break;
			  	} 	
			}
	  	if(count>0)
	  	{
	  	break;
	  	} 	
	  }
			
	}
			
		
		
		public void rm_reportingdetails_submit_validation()
		{
			try
			{
				boolean submit_button= Reporting_Details_RMSubmitButton.isDisplayed();
				if(submit_button==true)	
				{
					Reporting_Details_RMSubmitButton.click();
					String rmsubmittoast= GenericToastMsg.getText();
					Waitfor(3);
						try
						{
						boolean submitted_buttonststatus= Reporting_Details_RMSubmitButton.isDisplayed();
						if(rmsubmittoast.equalsIgnoreCase("Reporting Details Submitted Successfully") && submitted_buttonststatus==false)
						{
							logger.info("On Submit of Reporting details, it has displayed the proper toast message & Submit button is hidden now");
							
						}
						else 
						{
							logger.info("On Submit of Reporting details, either it has not displayed the proper toast message or Submit button is still displaying");

						}
						}
						catch (Exception e)
						{
							logger.info("On Submit of Reporting details, either it has not displayed the proper toast message or Submit button is still displaying");

							logger.info(e);
						}
				}
				else
				{
					logger.info("The Reporting details Submit button is not present for submitting the Reporting details");
				}
			}
			catch (Exception e)
			{
				logger.info("The Reporting details Submit button is not present for submitting the Reporting details");
				
				logger.info(e);
			}
		}
		
		public void reportingdetails_tab()
		{
			Reporting_Details_Tab.click();
			Waitfor(1);
		}
		
		public void reportingdetails_radiobutton()
		{
			ReportingDetails_RadioButton.click();
		}
		
		public void rmg_reporting_details(String emp_ID, String status, String contact_personname, String rep_time)
		{
			
			 ObjectInitClass.HP.Log_Out();
			Waitfor(1);
			// Read Excel object creation to pass the sheet parameter.
		  	String RMG_username= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
		  	Waitfor(1);
		  	String RMG_password= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
		  	Waitfor(1);
		  				
		  	 ObjectInitClass.LP.signIn(RMG_username, RMG_password);
			
			String cand_firstname= get_cand_firstname(emp_ID, status);
			String cand_lastname= get_cand_lastname();
			String dateof_joining= get_name_joiningdate();
			String candidate_location= get_joining_loc();
			String respectiveRM_Name= get_RMname();
			String account_holdername= get_acc_Hldr_Name();			
			String cand_fullname= cand_firstname+" "+cand_lastname; 
		
			Waitfor(1);
			Emp_ScrollRight.click();
			Waitfor(1);
			Reporting_Details_Tab.click();
				
				if(contact_personname.equalsIgnoreCase(account_holdername))
				{
					logger.info("The Candidate record lies in the respective RMG table.");
					
					
					boolean report_radio_button= ReportingDetails_RadioButton.isSelected();
					if(report_radio_button==false)
					{	
						ReportingDetails_RadioButton.click();
						Waitfor(1);
						logger.info("The Reporting details wasn't selected by default");
					}	
					String candidate_fullname= Reporting_Cand_Fullname.getText();
					if(cand_fullname.equalsIgnoreCase(candidate_fullname))
					{
						logger.info("The Candidate name in Reporting details is matching with the created profile candidate name");
					}
					else
					{
						logger.info("The Candidate name in Reporting details is not matching with the created profile candidate name");
					}	
					String cand_doj= Reporting_Cand_DOJ.getText();
					if(dateof_joining.equalsIgnoreCase(cand_doj))
					{
						logger.info("The Candidate DOJ in Reporting details is matching with the created profile candidate DOJ");
					}
					else
					{
						logger.info("The Candidate DOJ in Reporting details is not matching with the created profile candidate DOJ");
					}	
					
					try
					{
						boolean submit_button= Reporting_RMGSubmit_Button.isDisplayed();
						if(submit_button==true)	
						{ 
							boolean report_time= Reporting_Time.isEnabled();
							if(report_time==true)
							{

								String reportingtime= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_rep_time').value");
								if(reportingtime.equalsIgnoreCase("09:30"))
								{
									logger.info("The Reporting Time in Reporting details is matching with the default Diksha reporting time.");
								}
								else
								{
								logger.info("The Reporting Time in Reporting details is not matching with the default Diksha reporting time.");
								}
								Waitfor(1);
								Reporting_Time.sendKeys(Keys.chord(Keys.CONTROL, "a"),rep_time);
								Waitfor(1);
								Reporting_Contact_PersonName.click();
								Waitfor(1);
								String rmg_reportingtime= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_rep_time').value");
								if(rmg_reportingtime.equalsIgnoreCase(rep_time))
								{
									logger.info("RMG passed Reporting time is matching");
								}
								else
								{
									logger.info("RMG passed Reporting time is not matching");
								}
								Waitfor(1);
							}
							else
							{
								logger.info("Reporting Time field shouldn't be readonly for RMG before submission");
							}
						}
						else
						{
							logger.info("The Reporting details has already been submitted for which Time field is non-editable");
						}
					}
					catch (Exception e)
					{
						logger.info("The Reporting details has already been submitted for which Time field is non-editable");
						
						logger.info(e);
					}
					String cand_joining_location= Reporting_Location.getText();
					if(candidate_location.equalsIgnoreCase(cand_joining_location))
					{
						logger.info("The Candidate Joining location in Reporting details is matching with the created profile candidate location");
					}
					else
					{
						logger.info("The Candidate DOJ in Reporting details is not matching with the created profile candidate DOJ");
					}
					String contact_person= Reporting_Contact_PersonName.getText();
					if(contact_personname.equalsIgnoreCase(contact_person))
					{
						logger.info("The Conatct Person name in Reporting details is matching with the person name who has created the candidate profile.");
					}
					else
					{
					logger.info("The Conatct Person name in Reporting details is not matching with the person name who has created the candidate profile.");
					}
					String act_rmg_contactnumber= excelreaddata().getData("Login_Credentials", 3, 2 ); //Reading respective RMG Personal Contact Number from excel
				  	Waitfor(1);
				  	String exp_rmg_contactno= Reporting_RMG_ContactNO.getText();
				  	if(act_rmg_contactnumber.equalsIgnoreCase(exp_rmg_contactno) || exp_rmg_contactno.equalsIgnoreCase("9800000000"))
					{
						logger.info("The Conatct Number name in Reporting details is matching with the personal contact number of who has created the candidate profile.");
					}
					else
					{
					logger.info("The Conatct Number name in Reporting details is not matching with the personal contact number of who has created the candidate profile.");
					}
				  	
				}
				else
				{
					logger.info("The Candidate record doesn't lie in the respective/authorized RM table it is present in different/unauthorized account table.");
				}	
	
			
		}
		
		public void rmg_reportingdetails_submit_validation()
		{

			try
			{
				boolean submit_button= Reporting_RMGSubmit_Button.isDisplayed();
				if(submit_button==true)	
				{
					Reporting_RMGSubmit_Button.click();
					String rmsubmittoast= GenericToastMsg.getText();
					Waitfor(3);
						try
						{
						boolean submitted_buttonststatus= Reporting_RMGSubmit_Button.isDisplayed();
						if(rmsubmittoast.equalsIgnoreCase("Reporting Details Submitted Successfully") && submitted_buttonststatus==false)
						{
							logger.info("On Submit of Reporting details, it has displayed the proper toast message & Submit button is hidden now");
							
						}
						else 
						{
							logger.info("On Submit of Reporting details, either it has not displayed the proper toast message or Submit button is still displaying");

						}
						}
						catch (Exception e)
						{
							logger.info("On Submit of Reporting details, either it has not displayed the proper toast message or Submit button is still displaying");

							logger.info(e);
						}
				}
				else
				{
					logger.info("The Reporting details Submit button is not present for submitting the Reporting details");
				}
			}
			catch (Exception e)
			{
				logger.info("The Reporting details Submit button is not present for submitting the Reporting details");
				
				logger.info(e);
			}
		}
		
		public void rmg_reportingdetails_time(String submittedrep_time)
		{
			boolean report_time= Reporting_Time.isEnabled();
			if(report_time==true)
			{
				logger.info("The Reporting Time field is editable for RMG");
				
				String rmg_reportingtime= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_rep_time').value");
				if(rmg_reportingtime.equalsIgnoreCase(submittedrep_time))
				{
					logger.info("The Reporting Time in Reporting details is matching with the Submitted Reproting timing.");
				}
				else
				{
				logger.info("The Reporting Time in Reporting details is not matching with the Submitted Reproting timing.");
				}
				Waitfor(2);
				Reporting_Time.sendKeys(Keys.chord(Keys.CONTROL, "a"),"02:30");
				Reporting_Contact_PersonName.click();
			}
			else
			{
				logger.info("The Reporting Time field is not editable for RMG");
			}
			Waitfor(1);
		}
		
		public void rm_client_reportingdetails(String emp_ID, String status, int row_num)
		{
			
			 ObjectInitClass.HP.Log_Out();
			Waitfor(1);
			String RMG_username= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
		  	Waitfor(1);
		  	String RMG_password= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
		  	Waitfor(1);
		  				
		  	 ObjectInitClass.LP.signIn(RMG_username, RMG_password);
		  	Waitfor(1);
		  	candidate_employment_statuscheck(emp_ID, status);
			String getRM_Name= get_RMname();
			String[] split_space= getRM_Name.split("\\s+");
			String respectiveRM_Name= split_space[0];
			
			int count = 0;
			 ObjectInitClass.HP.Log_Out();
			Waitfor(1);
			// Read Excel object creation to pass the sheet parameter.
			for(int row=1; row<=50; row++)
			{	
				String RM_username= excelreaddata().getData("Login_Credentials", row, 0 ); //Reading Username from excel
			  	if(RM_username.contains(respectiveRM_Name))
			  	{		
					  	String RM_password= excelreaddata().getData("Login_Credentials",row, 1 ); //Reading Password from excel
					  	Waitfor(1);
					  				
					  	 ObjectInitClass.LP.signIn(RM_username, RM_password);
					  	
					  	count++;
					  	
						String match_status= candidate_employment_statuscheck(emp_ID, status);
						if(!match_status.contains("No Match found"))
						{
							Waitfor(2);
							Reporting_Details_Tab.click();
							String account_holdername= get_acc_Hldr_Name();
							if(getRM_Name.equalsIgnoreCase(account_holdername))
							{
								logger.info("The Candidate record lies in the respective RM table.");
								boolean report_radio_button= ClientReporting_RadioButton.isSelected();
								if(report_radio_button==false)
								{
									Waitfor(2);
									ClientReporting_RadioButton.click();
									Waitfor(2);
							}	
							Waitfor(1);
							((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)", "");
								Waitfor(1);
								clientcompanyfield_validation(row_num);
								Waitfor(1);
								clientregionfield_validation(row_num);
								Waitfor(1);
								clientdepartmentfield_validation(row_num);
								Waitfor(1);
								clientprojectfield_validation(row_num);
								Waitfor(1);
//								//Selecting the date of joining from the date picker.
//								
								clientdatefield_validation();
								Waitfor(1);
								client_time(row_num);
								Waitfor(1);
								clientvenuefield_validation(row_num);
								Waitfor(1);
								clientrmfield_validation(row_num);
								Waitfor(1);
								client_contactperson(row_num);
								clientcontactnumber_field_validation(row_num);
								Waitfor(1);
								count++;
						}
						else
						{
							logger.info("The Candidate record doesn't lie in the respective/authorized RM table it is present in different/unauthorized account table.");
						}
					}		
					else 
					{
						logger.info("There is no record matched with the passed Status & Emp-ID found in Candidate table..!!");
					}
				if(count>0)
			  	{
			  	break;
			  	} 	
			}
	  	if(count>0)
	  	{
	  	break;
	  	} 	
	  }
			
	}
		
	public void rmg_client_reportingvalidationcandmodule(String emp_ID, String status,String rmlogin)
	{
			
		 ObjectInitClass.HP.Log_Out();
		Waitfor(1);
		String getRM_Name= rmlogin;
		String[] split_space= getRM_Name.split("\\s+");
		String respectiveRM_Name= split_space[0];
		int count = 0;
		
		// Read Excel to match the RM credentials with the RM who submitted the client details
		for(int row=1; row<=50; row++)
		{	
			String RM_username= excelreaddata().getData("Login_Credentials", row, 0 ); //Reading Username from excel
		  	if(RM_username.contains(respectiveRM_Name))
		  	{	
		  		count++;
			  	String RM_password= excelreaddata().getData("Login_Credentials",row, 1 ); //Reading Password from excel
			  	Waitfor(1);
			  				
			  	 ObjectInitClass.LP.signIn(RM_username, RM_password);
			  	
			  	String rmmatch_status=candidate_employment_statuscheck(emp_ID, status);
			  	if(!rmmatch_status.contains("No Match found"))
				{
					Waitfor(2);
					Reporting_Details_Tab.click();
					boolean rmreport_radio_button= ClientReporting_RadioButton.isSelected();
					if(rmreport_radio_button==false)
					{
						Waitfor(2);
						ClientReporting_RadioButton.click();
					}	
				Waitfor(2);
				rmclientcompanyname=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('candClientCompany').options[document.getElementById('candClientCompany').selectedIndex].text");
			  	rmclientregion=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('candClientRegion').options[document.getElementById('candClientRegion').selectedIndex].text");
			  	rmclientdepartment=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('candClientDept').options[document.getElementById('candClientDept').selectedIndex].text");
			    rmclientproject=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('candClientProjects').options[document.getElementById('candClientProjects').selectedIndex].text");
			    rmclientrepo_Date=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_date').value");
			    rmclienttiming=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_time').value");
			    rmvenue_address= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_venue').value");
			    rmrm_name=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_repManager').value");
			    rmcontact_person=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_contactPerson').value");
			    rmcontact_number=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_contactno').value");


			  	 ObjectInitClass.HP.Log_Out();
			
			  	Waitfor(1);
				String RMG_username= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
			  	Waitfor(1);
			  	String RMG_password= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
			  	Waitfor(1);
			  				
			  	 ObjectInitClass.LP.signIn(RMG_username, RMG_password);
			  	
				Waitfor(1);
				String match_status= candidate_employment_statuscheck(emp_ID, status);
				if(!match_status.contains("No Match found"))
				{
					Waitfor(1);
					Emp_ScrollRight.click();
					Waitfor(1);
					Reporting_Details_Tab.click();
				}	
						Waitfor(1);
						boolean report_radio_button= ClientReporting_RadioButton.isSelected();
						if(report_radio_button==false)
						{
							Waitfor(2);
							ClientReporting_RadioButton.click();
							Waitfor(2);
						}	
						Waitfor(1);
						((JavascriptExecutor)driver).executeScript("scroll(0,250)");
						
						String clientcompanyname=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('candClientCompany').options[document.getElementById('candClientCompany').selectedIndex].text");
					  	String clientregion=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('candClientRegion').options[document.getElementById('candClientRegion').selectedIndex].text");
					  	String clientdepartment=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('candClientDept').options[document.getElementById('candClientDept').selectedIndex].text");
					  	String clientproject=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('candClientProjects').options[document.getElementById('candClientProjects').selectedIndex].text");
					  	String clientrepo_Date=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_date').value");
					  	String clienttiming=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_time').value");
					  	String venue_address= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_venue').value");
					  	String rm_name=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_repManager').value");
					  	String contact_person=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_contactPerson').value");
					  	String contact_number=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_contactno').value");

						if(clientcompanyname.equalsIgnoreCase(rmclientcompanyname))
						{
							logger.info("The Client Company name is matching with the RM submitted data ");
						}
						else
						{
							logger.info("The Client Company name is not matching with the RM submitted data ");
						}
						if(clientregion.equalsIgnoreCase(rmclientregion))
						{
							logger.info("The Client Region is matching with the RM submitted data");
						}
						else
						{
							logger.info("The Client Region is not matching with the RM submitted data ");
						}
						if(clientdepartment.equalsIgnoreCase(rmclientdepartment))
						{
							logger.info("The Client Department is matching with the RM submitted data ");
						}
						else
						{
							logger.info("The Client Department is not matching with the RM submitted data ");
						}
						if(clientproject.equalsIgnoreCase(rmclientproject))
						{
							logger.info("The Client Project name is matching with the RM submitted data ");
						}
						else
						{
							logger.info("The Client Project name is not matching with the RM submitted data ");
						}
						if(clientrepo_Date.equalsIgnoreCase(rmclientrepo_Date))
						{
							logger.info("The Client DOJ is matching with the RM submitted data ");
						}
						else
						{
							logger.info("The Client DOJ is not matching with the RM submitted data ");
						}
						if(clienttiming.equalsIgnoreCase(rmclienttiming))
						{
							logger.info("The Client Reporting time is matching with the RM submitted data ");
						}
						else
						{
							logger.info("The Client Reporting time is not matching with the RM submitted data");
						}
						if(venue_address.equalsIgnoreCase(rmvenue_address))
						{
							logger.info("The Client Venue is matching with the RM submitted data");
						}
						else
						{
							logger.info("The Client Venue is not matching with the RM submitted data");
						}
						if(rm_name.equalsIgnoreCase(rmrm_name))
						{
							logger.info("The Client Reporting Manager name is matching with the RM submitted data");
						}
						else
						{
							logger.info("The Client Reporting Manager name is not matching with the RM submitted data");
						}
						if(contact_person.equalsIgnoreCase(rmcontact_person))
						{
							logger.info("The Client Contact Person name is matching with the RM submitted data");
						}
						else
						{
							logger.info("The Client Contact Person name is matching with the RM submitted data");
						}
						if(contact_number.equalsIgnoreCase(rmcontact_number))
						{
							logger.info("The Client Contact Number is matching with the RM submitted data");
						}
						else
						{
							logger.info("The Client Contact Number is not matching with the RM submitted data");
						}
						
						count++;
					}
					else
					{
						logger.info("The Candidate record doesn't lie in the respective/authorized RM table it is present in different/unauthorized account table.");
					}
				}		
		  	if(count>0)
		  	{
		  	break;
		  	}
			
		  	} 	
		  }
		
		
		public void rmg_client_reportingvalidationempmodule(String candid, String status)
		{
			
			 ObjectInitClass.HP.Log_Out();
			Waitfor(1);
			
			
		 // Read Excel object creation to pass the sheet parameter.
		  	String RMG_username= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
		  	Waitfor(1);
		  	String RMG_password= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
		  	Waitfor(1);
		  				
		  	 ObjectInitClass.LP.signIn(RMG_username, RMG_password);
		  	
			Waitfor(8);
			RMGModule.click();
			Waitfor(1);
			employeeModule.click();
			
				Waitfor(5);
				Employees_SearchInput.sendKeys(Keys.chord(Keys.CONTROL, "a"),EMPID);
				Waitfor(1);
				Actions action = new Actions(driver);
				Waitfor(1);
				
				 String sta= driver.findElement(By.xpath(".//*[@id='employee_home']/tbody/tr/td[9]")).getText();
				 Waitfor(2);
				 WebElement report = driver.findElement(By.xpath(".//*[@id='employee_home']/tbody/tr/td[1]"));
				 Waitfor(1);
				 logger.info(sta);
				 action.doubleClick(report).build().perform();
					Waitfor(5);
			//String match_status= rmg_employeeTablestatuscheck(EMPID, status);
		//	if(!match_status.contains("No Match found"))
				// Edit button validation
					boolean empgeneralinfo_Tab_status = EmpGeneralInfo_Tab.isDisplayed();
					if(empgeneralinfo_Tab_status==true)
			{
				Waitfor(2);
				Emp_ScrollRight.click();
				Waitfor(1);
				Reporting_Details_Tab.click();
					
						Waitfor(2);
						boolean report_radio_button= EMPClientReporting_RadioButton.isSelected();
						if(report_radio_button==false)
						{
							Waitfor(3);
							EMPClientReporting_RadioButton.click();
							Waitfor(2);
						}	
						Waitfor(2);
						((JavascriptExecutor)driver).executeScript("scroll(0,250)");
					
						String clientcompanyname=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('empClientCompany').options[document.getElementById('empClientCompany').selectedIndex].text");
					  	String clientregion=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('empClientRegion').options[document.getElementById('empClientRegion').selectedIndex].text");
					  	String clientdepartment=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('empClientDept').options[document.getElementById('empClientDept').selectedIndex].text");
					  	String clientproject=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('empClientProjects').options[document.getElementById('empClientProjects').selectedIndex].text");
					  	String clientrepo_Date=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('emp_client_date').value");
					  	String clienttiming=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('emp_client_time').value");
					  	String venue_address= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('emp_client_venue').value");
					  	String rm_name=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('emp_client_repManager').value");
					  	String contact_person=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('emp_client_contactPerson').value");
					  	String contact_number=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('emp_client_contactno').value");

						if(clientcompanyname.equalsIgnoreCase(rmclientcompanyname))
						{
							logger.info("The Client Company name is matching with the RM submitted data ");
						}
						else
						{
							logger.info("The Client Company name is not matching with the RM submitted data ");
						}
						if(clientregion.equalsIgnoreCase(rmclientregion))
						{
							logger.info("The Client Region is matching with the RM submitted data");
						}
						else
						{
							logger.info("The Client Region is not matching with the RM submitted data ");
						}
						if(clientdepartment.equalsIgnoreCase(rmclientdepartment))
						{
							logger.info("The Client Department is matching with the RM submitted data ");
						}
						else
						{
							logger.info("The Client Department is not matching with the RM submitted data ");
						}
						if(clientproject.equalsIgnoreCase(rmclientproject))
						{
							logger.info("The Client Project name is matching with the RM submitted data ");
						}
						else
						{
							logger.info("The Client Project name is not matching with the RM submitted data ");
						}
						if(clientrepo_Date.equalsIgnoreCase(rmclientrepo_Date))
						{
							logger.info("The Client DOJ is matching with the RM submitted data ");
						}
						else
						{
							logger.info("The Client DOJ is not matching with the RM submitted data ");
						}
						if(clienttiming.equalsIgnoreCase(rmclienttiming))
						{
							logger.info("The Client Reporting time is matching with the RM submitted data ");
						}
						else
						{
							logger.info("The Client Reporting time is not matching with the RM submitted data");
						}
						if(venue_address.equalsIgnoreCase(rmvenue_address))
						{
							logger.info("The Client Venue is matching with the RM submitted data");
						}
						else
						{
							logger.info("The Client Venue is not matching with the RM submitted data");
						}
						if(rm_name.equalsIgnoreCase(rmrm_name))
						{
							logger.info("The Client Reporting Manager name is matching with the RM submitted data");
						}
						else
						{
							logger.info("The Client Reporting Manager name is not matching with the RM submitted data");
						}
						if(contact_person.equalsIgnoreCase(rmcontact_person))
						{
							logger.info("The Client Contact Person name is matching with the RM submitted data");
						}
						else
						{
							logger.info("The Client Contact Person name is matching with the RM submitted data");
						}
						if(contact_number.equalsIgnoreCase(rmcontact_number))
						{
							logger.info("The Client Contact Number is matching with the RM submitted data");
						}
						else
						{
							logger.info("The Client Contact Number is not matching with the RM submitted data");
						}
					
			}
			else
			{
				logger.info("The Candidate record doesn't lie in the respective/authorized RMG employee table");
			}
			
		}		
		  	

		public void clientreportingdetails_radiobutton()
		{
			ClientReporting_RadioButton.click();
		}
		
		public void clientcompanyname(int row)
		{
			String clientcompanyname=  excelreaddata().getData("RmRmgAdmin_data", row, 0 ); //Reading clienttiming from excel
			Select clientcompanyDD = new Select(Client_Companyname);
			clientcompanyDD.selectByVisibleText(clientcompanyname);
			Waitfor(1);
			String sel_clientcompanyname=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('candClientCompany').options[document.getElementById('candClientCompany').selectedIndex].text");
			if(sel_clientcompanyname.equalsIgnoreCase(clientcompanyname))
			{
				logger.info("The Client company name is selected and matching with the passed data");
			}
			else
			{
				logger.info("The Client company name is not selected or matching with the passed data");
			}
		}
		
		public void clientregion(int row)
		{
			String clientregion=  excelreaddata().getData("RmRmgAdmin_data", row, 1 ); //Reading clienttiming from excel
			Select clientregionDD = new Select(Client_Region);
			clientregionDD.selectByVisibleText(clientregion);
			Waitfor(1);
			String selrmclientregion=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('candClientRegion').options[document.getElementById('candClientCompany').selectedIndex].text");
			if(selrmclientregion.equalsIgnoreCase(clientregion))
			{
				logger.info("The Client Region is selected and matching with the passed data");
			}
			else
			{
				logger.info("The Client Region is not selected or matching with the passed data");
			}
		}
		
		public void clientdepartment(int row)
		{
			String clientdepartment= excelreaddata().getData("RmRmgAdmin_data", row, 2 ); //Reading clienttiming from excel
			Select clientdepartmentDD = new Select(Client_Department);
			clientdepartmentDD.selectByVisibleText(clientdepartment);
			Waitfor(1);
		  	String sel_rmclientdepartment=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('candClientDept').options[document.getElementById('candClientCompany').selectedIndex].text");
			if(sel_rmclientdepartment.equalsIgnoreCase(clientdepartment))
			{
				logger.info("The Client Department is selected and matching with the passed data");
			}
			else
			{
				logger.info("The Client Department is not selected or matching with the passed data");
			}
		}
		
		public void clientproject(int row)
		{
			String clientproject=  excelreaddata().getData("RmRmgAdmin_data", row, 3 ); //Reading clienttiming from excel
			Select clientprojectDD = new Select(Client_Project);
			clientprojectDD.selectByVisibleText(clientproject);
			Waitfor(1);
		  	String sel_rmclientproject=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('candClientProjects').options[document.getElementById('candClientCompany').selectedIndex].text");
			if(sel_rmclientproject.equalsIgnoreCase(clientproject))
			{
				logger.info("The Client Project is selected and matching with the passed data");
			}
			else
			{
				logger.info("The Client Project is not selected or matching with the passed data");
			}
		}

		public String client_doj()
		{
			//Selecting the date of joining from the date picker.
			
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-YYYY");
			String subdate[]=dateFormat.format(date).split("-");

			String client_dateofjoining="";
			char[] date_char= subdate[0].toCharArray();
			String firstdatechar = String.valueOf(subdate[0].charAt(0));
			if(firstdatechar.equals("0"))
			{
				char c = subdate[0].charAt(1);
				client_dateofjoining= Character.toString(c);
			}
			else
			{
				client_dateofjoining= subdate[0];
			}
			String month= subdate[1];
			String year= subdate[2];
			
			DOJ_Calendar.click();	
			
			List<WebElement> doj_dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
			for (int i = 0; i < doj_dates.size(); i++) {
				String doj_date = doj_dates.get(i).getText();

				if (doj_date.equals(client_dateofjoining) && !(doj_date=="")) {
					
					Select month_dd= new Select(Client_Month_DD);
					month_dd.selectByVisibleText(month);
					

					Select year_dd= new Select(Client_Year_DD);
					year_dd.selectByVisibleText(year);
					
					doj_dates.get(i).click();
					logger.info("Selected date is: " + client_dateofjoining+"-"+month+"-"+year);
					selected_reportingdate= client_dateofjoining+"-"+month+"-"+year;
				  	String sel_rmclientrepo_Date=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_date').value");
					if(sel_rmclientrepo_Date.equalsIgnoreCase(selected_reportingdate))
					{
						logger.info("The Client Reporting date is selected and matching with the passed data");
					}
					else
					{
						logger.info("The Client Reporting date is not selected or matching with the passed data");
					}
					break;

				}
			}
		  return selected_reportingdate;
		}	
	  	
		public void client_time(int row)
		{
			String clienttiming= excelreaddata().getData("RmRmgAdmin_data", row, 4 ); //Reading clienttiming from excel
			Client_Time.sendKeys(Keys.chord(Keys.CONTROL, "a"),"123 Testing the Time field with Alphnumeric");
			Waitfor(1);
			String false_rmclienttiming=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_time').value");
			if(false_rmclienttiming.equalsIgnoreCase("123 Testing the Time field with Alphnumeric"))
			{
				logger.info("The Client Reporting Time field shouldn't accept the alphnumeric character");
			}
			else
			{
				logger.info("The Client Reporting Time field accepting only numeric value");
			}
		  	Client_Time.sendKeys(Keys.chord(Keys.CONTROL, "a"),clienttiming);
		  	Client_Venue.click();
		  	Waitfor(1);
		  	String sel_rmclienttiming=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_time').value");
			if(sel_rmclienttiming.equalsIgnoreCase(clienttiming))
			{
				logger.info("The Client Reporting Time is selected and matching with the passed data");
			}
			else
			{
				logger.info("The Client Reporting date is not selected or matching with the passed data");
			}
		}
		
		public void client_venue(int row)
		{
			String venue_address= excelreaddata().getData("RmRmgAdmin_data",row, 5 ); //Reading venue_address from excel
			Client_Venue.sendKeys(Keys.chord(Keys.CONTROL, "a"),"123 Testing the Venue maximum charcaters with Alphnumeric");
			Waitfor(1);
		  	String false_rmvenue_address= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_venue').value");
			if(false_rmvenue_address.equalsIgnoreCase("123 Testing the Venue maximum charcaters with Alphnumeric"))
			{
				logger.info("The Client Venue field is accepting the alphnumeric character with max length");
			}
			else
			{
				logger.info("The Client Venue field is not accepting the alphnumeric character with max length");
			}
		  	Client_Venue.sendKeys(Keys.chord(Keys.CONTROL, "a"),venue_address);
		  	Waitfor(1);
		  	String sel_rmvenue_address= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_venue').value");
			if(sel_rmvenue_address.equalsIgnoreCase(venue_address))
			{
				logger.info("The Client Venue is selected and matching with the passed data");
			}
			else
			{
				logger.info("The Client Venue is not selected or matching with the passed data");
			}
		}
		
		public void client_rmname(int row)
		{
			String rm_name= excelreaddata().getData("RmRmgAdmin_data",row, 6 ); //Reading rm_name from excel
			Client_Venue.sendKeys(Keys.chord(Keys.CONTROL, "a"),"123 Testing the RMname maximum charcaters with Alphnumeric");
			Waitfor(1);
		  	String falserm_name=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_repManager').value");
			if(falserm_name.equalsIgnoreCase("123 Testing the RMname maximum charcaters with Alphnumeric"))
			{
				logger.info("The Client RM field is accepting the alphnumeric character with max length");
			}
			else
			{
				logger.info("The Client RM field is not accepting the alphnumeric character with max length");
			}
		  	Client_RM.sendKeys(Keys.chord(Keys.CONTROL, "a"),rm_name);
		  	Waitfor(1);
		  	String sel_rm_name=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_repManager').value");
			if(sel_rm_name.equalsIgnoreCase(rm_name))
			{
				logger.info("The Client RM is selected and matching with the passed data");
			}
			else
			{
				logger.info("The Client RM is not selected or matching with the passed data");
			}
		}
		
		public void client_contactperson(int row)
		{
			String contact_person= excelreaddata().getData("RmRmgAdmin_data",row, 7 ); //Reading contact_person from excel
			Client_Venue.sendKeys(Keys.chord(Keys.CONTROL, "a"),"123 Testing the Client Name maximum charcaters with Alphnumeric");
			Waitfor(1);
		  	String falsermcontact_person=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_contactPerson').value");
			if(falsermcontact_person.equalsIgnoreCase("123 Testing the Client Name maximum charcaters with Alphnumeric"))
			{
				logger.info("The Client Contact Person field is accepting the alphnumeric character with max length");
			}
			else
			{
				logger.info("The Client Contact Person field is not accepting the alphnumeric character with max length");
			}
		  	ClientContact_Person.sendKeys(Keys.chord(Keys.CONTROL, "a"),contact_person);
		  	Waitfor(1);
		  	String sel_rmcontact_person=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_contactPerson').value");
			if(sel_rmcontact_person.equalsIgnoreCase(contact_person))
			{
				logger.info("The Client Contact person name is matching with the passed data");
			}
			else
			{
				logger.info("The Client Contact person name is not matching with the passed data");
			}
		}
		
		public void client_contactnumber(int row)
		{
			String contact_number= excelreaddata().getData("RmRmgAdmin_data",row, 8 ); //Reading contact_number from excel
			ClientContact_Number.sendKeys(Keys.chord(Keys.CONTROL, "a"),"123 Testing the Conatct No. with Alphnumeric");
			Waitfor(1);
		  	String falsecontact_number=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_contactno').value");
			if(falsecontact_number.equalsIgnoreCase("123 Testing the Conatct No. with Alphnumeric"))
			{
				logger.info("The Client Contact Number field shouldn't accept the alphnumeric character");
			}
			else
			{
				logger.info("The Client Contact Number field accepting only numeric value");
			}
			Waitfor(1);
			ClientContact_Number.clear();
			ClientContact_Number.sendKeys(Keys.chord(Keys.CONTROL, "a"),"089009302438");
			Waitfor(1);
		  	String max_contact_number=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_contactno').value");
			if(max_contact_number.equalsIgnoreCase("089009302438"))
			{
				logger.info("The Client Contact Number field shouldn't accept more/less than 11 digits");
			}
			else if(max_contact_number.equalsIgnoreCase("08900930243"))
			{
				logger.info("The Client Contact Number field is accepting only 11 digits");
			}
			else
			{
				logger.info("The Client contact number is accepting less than 10/11 digits");
			}	
			Waitfor(1);
		  	ClientContact_Number.sendKeys(Keys.chord(Keys.CONTROL, "a"),contact_number);
		  	Waitfor(1);
		  	Waitfor(1);
		  	String rmcontact_number=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_contactno').value");
			if(rmcontact_number.equalsIgnoreCase(contact_number))
			{
				logger.info("The Client Contact is matching with the passed data");
			}
			else
			{
				logger.info("The Client Contact number is not matching with the passed data");
			}
		}
		
		public String client_RMsave()
		{
			Client_RMSaveButton.click();
			String savetoastmsg= GenericToastMsg.getText();
			return savetoastmsg;
		}
		
		public String client_RMsubmit()
		{
			Client_RMSubmit_Button.click();
			String submittoastmsg= GenericToastMsg.getText();
			return submittoastmsg;
		}
		
		public String client_RMGsave()
		{
			Client_RMGSaveButton.click();
			String savetoastmsg= GenericToastMsg.getText();
			return savetoastmsg;
		}
		
		public String client_RMGsubmit()
		{
			Client_RMGSubmit_Button.click();
			String submittoastmsg= GenericToastMsg.getText();
			return submittoastmsg;
		}
	
		public void rm_ClientFinalsubmit()
		{
			try
			{
				boolean submit_button= Client_RMSubmit_Button.isDisplayed();
				if(submit_button==true)	
				{
					Client_RMSubmit_Button.click();
					String rmsubmittoast= GenericToastMsg.getText();
					Waitfor(3);
						try
						{
						boolean submitted_buttonststatus= Client_RMSubmit_Button.isDisplayed();
						if(rmsubmittoast.equalsIgnoreCase("Client Details Submitted Successfully") && submitted_buttonststatus==false)
						{
							logger.info("On Submit of Client reporting, it has displayed the proper toast message & Submit button is hidden now");
							
						}
						else 
						{
							logger.info("On Submit of Client reporting, either it has not displayed the proper toast message or Submit button is still displaying");

						}
						}
						catch (Exception e)
						{
							logger.info("On Submit of Client reporting, either it has not displayed the proper toast message or Submit button is still displaying");

							logger.info(e);
						}
				}
				else
				{
					logger.info("The Client reporting Submit button is not present for submitting the Reporting details");
				}
			}
			catch (Exception e)
			{
				logger.info("The Client reporting Submit button is not present for submitting the Reporting details");
				
				logger.info(e);
			}
		}
		
		public void rm_client_Saved_reportingdetails(String emp_ID, String status, int row, String rmlogin)
		{
			 ObjectInitClass.HP.Log_Out();
			Waitfor(1);
			String RM_Name= rmlogin;
			String[] split_space= RM_Name.split("\\s+");
			String respectiveRM_Name= split_space[0];
			
			int count = 0;
			// Read Excel object creation to pass the sheet parameter.
			for(int row_num=1; row_num<=50; row_num++)
			{	
				String RM_username= excelreaddata().getData("Login_Credentials", row_num, 0 ); //Reading Username from excel
			  	if(RM_username.contains(respectiveRM_Name))
			  	{		
					  	String RM_password= excelreaddata().getData("Login_Credentials",row_num, 1 ); //Reading Password from excel
					  	Waitfor(1);
					  				
					  	 ObjectInitClass.LP.signIn(RM_username, RM_password);
					  	
					  	count++;
					  		
				  	String rmmatch_status=candidate_employment_statuscheck(emp_ID, status);
				  	if(!rmmatch_status.contains("No Match found"))
					{
						Waitfor(2);
						Reporting_Details_Tab.click();
						Waitfor(1);
						boolean rmreport_radio_button= ClientReporting_RadioButton.isSelected();
						if(rmreport_radio_button==false)
						{
							Waitfor(2);
							ClientReporting_RadioButton.click();
						}	
						Waitfor(2);	
						String rmclientcompanyname=  excelreaddata().getData("RmRmgAdmin_data", row, 0 ); //Reading clienttiming from excel
						String rmclientregion=  excelreaddata().getData("RmRmgAdmin_data", row, 1 ); //Reading clienttiming from excel
						String rmclientdepartment= excelreaddata().getData("RmRmgAdmin_data", row, 2 ); //Reading clienttiming from excel
						String rmclientproject=  excelreaddata().getData("RmRmgAdmin_data", row, 3 ); //Reading clienttiming from excel
						String rmclienttiming= excelreaddata().getData("RmRmgAdmin_data", row, 4 ); //Reading clienttiming from excel
						String rmvenue_address= excelreaddata().getData("RmRmgAdmin_data",row, 5 ); //Reading venue_address from excel
						String rmrm_name= excelreaddata().getData("RmRmgAdmin_data",row, 6 ); //Reading rm_name from excel
						String rmcontact_person= excelreaddata().getData("RmRmgAdmin_data",row, 7 ); //Reading contact_person from excel
						String rmcontact_number= excelreaddata().getData("RmRmgAdmin_data",row, 8 ); //Reading contact_number from excel

						Waitfor(1);
						((JavascriptExecutor)driver).executeScript("scroll(0,250)");
						
						String clientcompanyname=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('candClientCompany').options[document.getElementById('candClientCompany').selectedIndex].text");
					  	String clientregion=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('candClientRegion').options[document.getElementById('candClientRegion').selectedIndex].text");
					  	String clientdepartment=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('candClientDept').options[document.getElementById('candClientDept').selectedIndex].text");
					  	String clientproject=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('candClientProjects').options[document.getElementById('candClientProjects').selectedIndex].text");
					  	String clientrepo_Date=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_date').value");
					  	String clienttiming=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_time').value");
					  	String venue_address= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_venue').value");
					  	String rm_name=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_repManager').value");
					  	String contact_person=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_contactPerson').value");
					  	String contact_number=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_client_contactno').value");

						if(clientcompanyname.equalsIgnoreCase(rmclientcompanyname))
						{
							logger.info("The Client Company name is matching with the RM submitted data ");
						}
						else
						{
							logger.info("The Client Company name is not matching with the RM submitted data ");
						}
						if(clientregion.equalsIgnoreCase(rmclientregion))
						{
							logger.info("The Client Region is matching with the RM submitted data");
						}
						else
						{
							logger.info("The Client Region is not matching with the RM submitted data ");
						}
						if(clientdepartment.equalsIgnoreCase(rmclientdepartment))
						{
							logger.info("The Client Department is matching with the RM submitted data ");
						}
						else
						{
							logger.info("The Client Department is not matching with the RM submitted data ");
						}
						if(clientproject.equalsIgnoreCase(rmclientproject))
						{
							logger.info("The Client Project name is matching with the RM submitted data ");
						}
						else
						{
							logger.info("The Client Project name is not matching with the RM submitted data ");
						}
						if(clientrepo_Date.equalsIgnoreCase(selected_reportingdate))
						{
							logger.info("The Client DOJ is matching with the RM submitted data ");
						}
						else
						{
							logger.info("The Client DOJ is not matching with the RM submitted data ");
						}
						if(clienttiming.equalsIgnoreCase(rmclienttiming))
						{
							logger.info("The Client Reporting time is matching with the RM submitted data ");
						}
						else
						{
							logger.info("The Client Reporting time is not matching with the RM submitted data");
						}
						if(venue_address.equalsIgnoreCase(rmvenue_address))
						{
							logger.info("The Client Venue is matching with the RM submitted data");
						}
						else
						{
							logger.info("The Client Venue is not matching with the RM submitted data");
						}
						if(rm_name.equalsIgnoreCase(rmrm_name))
						{
							logger.info("The Client Reporting Manager name is matching with the RM submitted data");
						}
						else
						{
							logger.info("The Client Reporting Manager name is not matching with the RM submitted data");
						}
						if(contact_person.equalsIgnoreCase(rmcontact_person))
						{
							logger.info("The Client Contact Person name is matching with the RM submitted data");
						}
						else
						{
							logger.info("The Client Contact Person name is matching with the RM submitted data");
						}
						if(contact_number.equalsIgnoreCase(rmcontact_number))
						{
							logger.info("The Client Contact Number is matching with the RM submitted data");
						}
						else
						{
							logger.info("The Client Contact Number is not matching with the RM submitted data");
						}
					}		
					else 
					{
						logger.info("There is no record matched with the passed Status & Emp-ID found in Candidate table..!!");
					}
			  	if(count>0)
			  	{
			  	break;
			  	} 	
				}
		  	if(count>0)
		  	{
		  	break;
		  	} 	
		  }
				
		}	


		public void clientcompanyfield_validation(int row_num)
		{
		
			String datetoastmsg= client_RMsave();
			String comp_mand= CompanyField.getText();
			
			if(datetoastmsg.equalsIgnoreCase("Company is required!!!!") && comp_mand.equalsIgnoreCase(star))
			{
				logger.info("The Company field is perfectly validated");
				clientcompanyname(row_num);
			}
			else
			{
				logger.info("The Company field validation has not been done");
			}
		}
		
		public void clientregionfield_validation(int row_num)
		{
		
			String datetoastmsg= client_RMsave();
			String region_mand= RegionFields.getText();
			
			if(datetoastmsg.equalsIgnoreCase("Region is required!!!!") && region_mand.equalsIgnoreCase(star))
			{
				logger.info("The Client Region field is perfectly validated");
				clientregion(row_num);
			}
			else
			{
				logger.info("The Client Region field validation has not been done");
			}
		}
		
		public void clientdepartmentfield_validation(int row_num)
		{
		
			String datetoastmsg= client_RMsave();
			String depart_mand= DepartmentFields.getText();
			
			if(datetoastmsg.equalsIgnoreCase("Department is required!!!!") && depart_mand.equalsIgnoreCase(star))
			{
				logger.info("The Client Department date field is perfectly validated");
				clientdepartment(row_num);
			}
			else
			{
				logger.info("The client date field validation has not been done");
			}
		}
		
		public void clientprojectfield_validation(int row_num)
		{
		
			String datetoastmsg= client_RMsave();
			String project_mand= ProjectFields.getText();
			
			if(datetoastmsg.equalsIgnoreCase("Project is required!!!!") && project_mand.equalsIgnoreCase(star))
			{
				logger.info("The Client Project field is perfectly validated");
				clientproject(row_num);
			}
			else
			{
				logger.info("The Client Project field validation has not been done");
			}
		}
		
		public void clientdatefield_validation()
		{
		
			String datetoastmsg= client_RMsave();
			String date_mand= DateFields.getText();
			
			if(datetoastmsg.equalsIgnoreCase("Date is required!!!!") && date_mand.equalsIgnoreCase(star))
			{
				logger.info("The Client date field is perfectly validated");
				client_doj();
			}
			else
			{
				logger.info("The Client date field validation has not been done");
			}
		}
		
		public void clientvenuefield_validation(int row_num)
		{
		
			String venuetoastmsg= client_RMsave();
			String venue_mand= VenueFields.getText();
			
			if(venuetoastmsg.equalsIgnoreCase("Venue is required!!!!") && venue_mand.equalsIgnoreCase(star))
			{
				logger.info("The Client Venue field is perfectly validated");
				client_venue(row_num);
			}
			else
			{
				logger.info("The Client Venue field validation has not been done");
			}
		}
		
		public void clientrmfield_validation(int row_num)
		{
		
			String rmtoastmsg= client_RMsave();
			String rm_mand= RMFields.getText();
			
			if(rmtoastmsg.equalsIgnoreCase("Reporting Manager is required!!!!") && rm_mand.equalsIgnoreCase(star))
			{
				logger.info("The Client RM field is perfectly validating");
				client_rmname(row_num);
			}
			else
			{
				logger.info("The Client RM field validation has not been done");
			}
		}

		public void clientcontactnumber_field_validation(int row_num)
		{
		
			String cont_no_toastmsg= client_RMsave();
			String cont_no__mand= RMFields.getText();
			
			if(cont_no_toastmsg.equalsIgnoreCase("Contact Number is required!!!!") && cont_no__mand.equalsIgnoreCase(star))
			{
				logger.info("The Client Contact Number field is perfectly validating");
				client_contactnumber(row_num);
			}
			else
			{
				logger.info("The Client Contact Number field validation has not been done");
			}
		}
		
		public void rmg_ClientFinalsubmit()
		{
			try
			{
				boolean submit_button= EMPClient_RMGSubmit_Button.isDisplayed();
				if(submit_button==true)	
				{
					EMPClient_RMGSubmit_Button.click();
					String rmsubmittoast= GenericToastMsg.getText();
					Waitfor(2);
						try
						{
						boolean submitted_buttonststatus= EMPClient_RMGSubmit_Button.isDisplayed();
						if(rmsubmittoast.equalsIgnoreCase("Client Details Submitted Successfully") && submitted_buttonststatus==false)
						{
							logger.info("On Submit of Client reporting By RMG, it has displayed the proper toast message & Submit button is hidden now");
							
						}
						else 
						{
							logger.info("On Submit of Client reporting By RMG, either it has not displayed the proper toast message or Submit button is still displaying");

						}
						}
						catch (Exception e)
						{
							logger.info("On Submit of Client reporting By RMG, either it has not displayed the proper toast message or Submit button is still displaying");

							logger.info(e);
						}
				}
				else
				{
					logger.info("The Client reporting Submit button is not present for submitting the Reporting details for RMG");
				}
			}
			catch (Exception e)
			{
				logger.info("The Client reporting Submit button is not present for submitting the Reporting details for RMG");
				
				logger.info(e);
			}
			Waitfor(2);
			it_requirementtab();
			Waitfor(2);
			view_adf.click();
			
		
		}

		//RM/RMG/ADMIN
		public void rm_it_requirements(String emp_ID, String status, int row_num)
		{
			Waitfor(2);
			it_requirementtab();
			
			boolean itrequirement_radio_btnyes= IT_Requirement_RadioButtonYES.isSelected();
			if(itrequirement_radio_btnyes==false)
			{
				Waitfor(1);
				logger.info("The IT Requirement Yes radio button wasn't selected by default");
				IT_Requirement_RadioButtonYES.click();
				Waitfor(1);
			}	
			itHardwarefield_savevalidation(row_num);
			Waitfor(1);
			it_software_support();
			Waitfor(1);
			it_osType(row_num);
			it_peripherals(row_num);
			it_comments(row_num);			
		}
		
		public void it_requirementtab()
		{
			IT_Requirement_Tab.click();
			Waitfor(1);
		}
		
		public void itrequirementradio_yes()
		{
			boolean itrequirement_radio_btnyes= IT_Requirement_RadioButtonYES.isSelected();
			if(itrequirement_radio_btnyes==false)
			{
				Waitfor(2);
				logger.info("Radio Yes wasn't selected by Default");
				IT_Requirement_RadioButtonYES.click();
				Waitfor(1);
			}	
		}
		
		public void itrequirementradio_no()
		{
			boolean itrequirement_radio_btnno= IT_Requirement_RadioButtonNo.isSelected();
			if(itrequirement_radio_btnno==false)
			{
				Waitfor(2);
				IT_Requirement_RadioButtonNo.click();
				Waitfor(1);
			}	
		}
		
		public void it_hardware_support(int row)
		{
			boolean hardwaresupp_field= Hardware_Support_DD.isEnabled();
			if(hardwaresupp_field==true)
			{
			String hard_supp= excelreaddata().getData("RmRmgAdmin_data", row, 0 );
			Select hardware_supp = new Select(Hardware_Support_DD);
			hardware_supp.selectByVisibleText(hard_supp);
			}
			else
			{
				logger.info("The Hardware Support field is disable");
			}
		}	
		
		public void it_software_support()
		{
				WebElement row_table = driver.findElement(By.xpath("//table[@id='candItSoftware_Table']/tbody"));
				List<WebElement> rows =  row_table.findElements(By.tagName("tr"));
				logger.info(rows.size());
				LinkedHashSet<WebElement> sorted = new LinkedHashSet<WebElement>(rows);
				logger.info(sorted.size());
					for (int c = 1; c <= sorted.size(); c++) 
					{	
						String cell_Value = driver
								.findElement(By.xpath("//table[@id='candItSoftware_Table']/tbody/tr[" + c + "]/td[2]/span"))
								.getText();
						Waitfor(2);
						String array[] = { "Office 365", "LibreOffice", "Thunderbird", "MS Project", "Visio", "Eclipse", "Android SDK", "Postman", "DBeaver", "MySQL Workbench" };
						
						if (cell_Value.equalsIgnoreCase(array[0])) 
						{
							driver.findElement(By.xpath("//table[@id='candItSoftware_Table']/tbody/tr[" + c + "]/td[1]/input")).click();
							Waitfor(1);	
							driver.findElement(By.xpath("//table[@id='candItSoftware_Table']/tbody/tr[" + (c+1) + "]/td[1]/input")).click();
							Waitfor(1);
							driver.findElement(By.xpath("//table[@id='candItSoftware_Table']/tbody/tr[" + (c+2) + "]/td[1]/input")).click();
							Waitfor(1);
						}
						else if(cell_Value.equalsIgnoreCase(array[1])) 
						{
							driver.findElement(By.xpath("//table[@id='candItSoftware_Table']/tbody/tr[" + c + "]/td[1]/input")).click();
							Waitfor(1);	
							driver.findElement(By.xpath("//table[@id='candItSoftware_Table']/tbody/tr[" + (c+1) + "]/td[1]/input")).click();
							Waitfor(1);
							driver.findElement(By.xpath("//table[@id='candItSoftware_Table']/tbody/tr[" + (c+2) + "]/td[1]/input")).click();
							Waitfor(1);
						}
						else if(cell_Value.equalsIgnoreCase(array[2])) 
						{
							driver.findElement(By.xpath("//table[@id='candItSoftware_Table']/tbody/tr[" + c + "]/td[1]/input")).click();
							Waitfor(1);	
							driver.findElement(By.xpath("//table[@id='candItSoftware_Table']/tbody/tr[" + (c+1) + "]/td[1]/input")).click();
							Waitfor(1);
							driver.findElement(By.xpath("//table[@id='candItSoftware_Table']/tbody/tr[" + (c+2) + "]/td[1]/input")).click();
							Waitfor(1);
						}
						else if(cell_Value.equalsIgnoreCase(array[3])) 
						{
							driver.findElement(By.xpath("//table[@id='candItSoftware_Table']/tbody/tr[" + c + "]/td[1]/input")).click();
							Waitfor(1);	
						}
						else if(cell_Value.equalsIgnoreCase(array[4])) 
						{
							driver.findElement(By.xpath("//table[@id='candItSoftware_Table']/tbody/tr[" + c + "]/td[1]/input")).click();
							Waitfor(1);	
						}
						else if(cell_Value.equalsIgnoreCase(array[5])) 
						{
							driver.findElement(By.xpath("//table[@id='candItSoftware_Table']/tbody/tr[" + c + "]/td[1]/input")).click();
							Waitfor(1);	
						}
						else if(cell_Value.equalsIgnoreCase(array[6])) 
						{
							driver.findElement(By.xpath("//table[@id='candItSoftware_Table']/tbody/tr[" + c + "]/td[1]/input")).click();
							Waitfor(1);	
						}
						else if(cell_Value.equalsIgnoreCase(array[7])) 
						{
							driver.findElement(By.xpath("//table[@id='candItSoftware_Table']/tbody/tr[" + c + "]/td[1]/input")).click();
							Waitfor(1);	
						}
						else if(cell_Value.equalsIgnoreCase(array[8])) 
						{
							driver.findElement(By.xpath("//table[@id='candItSoftware_Table']/tbody/tr[" + c + "]/td[1]/input")).click();
							Waitfor(1);	
						}
						else if(cell_Value.equalsIgnoreCase(array[9])) 
						{
							driver.findElement(By.xpath("//table[@id='candItSoftware_Table']/tbody/tr[" + c + "]/td[1]/input")).click();
							Waitfor(1);	
						}
						
					}
		}
		
		public void it_osType(int row)
		{
			boolean osType_field= OS_Type.isEnabled();
			if(osType_field==true)
			{
			String os_type= excelreaddata().getData("RmRmgAdmin_data", row, 1 ); 
			OS_Type.sendKeys(Keys.chord(Keys.CONTROL, "a"),os_type);
			Waitfor(1);
			}
			else 
			{
				logger.info("The OS type field is disable");
			}
		}
		public void it_peripherals(int row)
		{
			boolean peripherals_field= IT_Peripherals_Input.isEnabled();
			if(peripherals_field==true)
			{
			String peripherals= excelreaddata().getData("RmRmgAdmin_data", row, 2 ); 
			IT_Peripherals_Input.sendKeys(Keys.chord(Keys.CONTROL, "a"),peripherals);
			Waitfor(1);
			}
			else
			{
				logger.info("The IT peripherals field is disable");
			}
		}
		public void it_comments(int row)
		{
			boolean itComment_field= IT_Comments_Input.isEnabled();
			if(itComment_field==true)
			{
			String comments= excelreaddata().getData("RmRmgAdmin_data", row, 3 );
			IT_Comments_Input.sendKeys(Keys.chord(Keys.CONTROL, "a"),comments);
			Waitfor(1);
			}
			else
			{	
				logger.info("The IT comment field is disable");
			}	
		}
		
		public void itHardwarefield_savevalidation(int row_num)
		{
		
			String datetoastmsg= rm_IT_savegeneric();
			String comp_mand= IT_hardwareFields.getText();
			
			if(datetoastmsg.equalsIgnoreCase("Hardware Support is required!!!!") && comp_mand.equalsIgnoreCase(star))
			{
				logger.info("The IT Hardware field is perfectly validated");
				it_hardware_support(row_num);
			}
			else
			{
				logger.info("The IT Hardware field validation has not been done");
			}
		}
		
		public void itHardwarefield_submitvalidation(int row_num)
		{
		
			String datetoastmsg= rm_IT_Submitgeneric();
			String comp_mand= IT_hardwareFields.getText();
			
			if(datetoastmsg.equalsIgnoreCase("Hardware Support is required!!!!") && comp_mand.equalsIgnoreCase(star))
			{
				logger.info("The IT Hardware field is perfectly validated");
				it_hardware_support(row_num);
			}
			else
			{
				logger.info("The IT Hardware field validation has not been done");
			}
		}

		public void rm_IT_finalSave()
		{
			try
			{
				boolean save_button= IT_Save_Button.isDisplayed();
				if(save_button==true)	
				{
					IT_Save_Button.click();
					String rmsavetoast= GenericToastMsg.getText();
					Waitfor(3);
						try
						{
						boolean saved_buttonststatus= IT_Save_Button.isDisplayed();
						if(rmsavetoast.equalsIgnoreCase("IT Details Saved/Updated Successfully") && saved_buttonststatus==true)
						{
							logger.info("On Saving the IT requirement, it has displayed the proper toast message & Save button is displaying");
							
						}
						else 
						{
							logger.info("On Saving the IT requirement, either it has not displayed the proper toast message & Save button is displaying");

						}
						}
						catch (Exception e)
						{
							logger.info("On Saving the IT requirement, either it has not displayed the proper toast message & Save button is displaying");

							logger.info(e);
						}
				}
				else
				{
					logger.info("The It Requirement Save button is not present for Saving the IT Requirement");
				}
			}
			catch (Exception e)
			{
				logger.info("The It Requirement Save button is not present for Saving the IT Requirement");
				
				logger.info(e);
			}
		
		}
		
		public String rm_IT_savegeneric()
		{
			IT_Save_Button.click();
			String submittoastmsg= GenericToastMsg.getText();
			return submittoastmsg;
		}
		public String rm_IT_Submitgeneric()
		{
			IT_Submit_Button.click();
			String submittoastmsg= GenericToastMsg.getText();
			return submittoastmsg;
		}
		public void rm_ITsubmit()
		{
			try
			{
				boolean submit_button= IT_Submit_Button.isDisplayed();
				if(submit_button==true)	
				{
					IT_Submit_Button.click();
					String rmsubmittoast= GenericToastMsg.getText();
					Waitfor(3);
						try
						{
						boolean submitted_buttonststatus= IT_Submit_Button.isDisplayed();
						if(rmsubmittoast.equalsIgnoreCase("IT Details Submitted Successfully") && submitted_buttonststatus==false)
						{
							logger.info("On Submit of IT details, it has displayed the proper toast message & Submit button is hidden now");
							boolean yes_radiobutton = IT_Requirement_RadioButtonYES.isDisplayed();
							boolean no_radiobutton = IT_Requirement_RadioButtonNo.isDisplayed();
							if(yes_radiobutton==false && no_radiobutton== false)
							{
								logger.info("On Submit of IT details by RM, the radio buttons should not display");
							}
							else
								logger.info("On Submit of IT details by RM, the radio buttons are not displaying");
						}
						else 
						{
							logger.info("On Submit of IT details, either it has not displayed the proper toast message or Submit button is still displaying");

						}
						}
						catch (Exception e)
						{
							logger.info("On Submit of IT details, either it has not displayed the proper toast message or Submit button is still displaying");

							logger.info(e);
						}
				}
				else
				{
					logger.info("The IT details Submit button is not present for submitting the Reporting details");
				}
			}
			catch (Exception e)
			{
				logger.info("The IT details Submit button is not present for submitting the Reporting details");
				
				logger.info(e);
			}
		}
		public void it_saveddata_validation(int row)
		{
			reportingdetails_tab();
			it_requirementtab();
			itrequirementradio_yes();
			
			String hard_supp= excelreaddata().getData("RmRmgAdmin_data", row, 0);
			String os_type= excelreaddata().getData("RmRmgAdmin_data", row, 1);
			String peripherals= excelreaddata().getData("RmRmgAdmin_data", row, 2); 
			String comments= excelreaddata().getData("RmRmgAdmin_data", row, 3);
		  	
			((JavascriptExecutor)driver).executeScript("scroll(0,300)");
			
			String saved_hard_supp=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_it_hardware').options[document.getElementById('cand_it_hardware').selectedIndex].text");
		  	String saved_osType=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_it_typeofOS').value");
		  	String saved_peripherals=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_it_peripherals').value");
		  	String saved_ITcomments= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_it_comments').value");
		  	
			if(hard_supp.equalsIgnoreCase(saved_hard_supp))
			{
				logger.info("The Hardware Support value is matching with the RM saved data");
			}
			else
			{
				logger.info("The Hardware Support value is not saved or matching with the RM saved data");
			}
			if(os_type.equalsIgnoreCase(saved_osType))
			{
				logger.info("The OS type is matching with the RM saved data");
			}
			else
			{
				logger.info("The OS type is not saved or matching with the RM saved data");
			}
			if(peripherals.equalsIgnoreCase(saved_peripherals))
			{
				logger.info("The Peripherals is matching with the RM saved data");
			}
			else
			{
				logger.info("The Peripherals is not saved or matching with the RM saved data");
			}
			if(comments.equalsIgnoreCase(saved_ITcomments))
			{
				logger.info("The IT comments is matching with the RM saved data");
			}
			else
			{
				logger.info("The IT comments is not saved or matching with the RM saved data");
			}
			

		}
		
		public void it_submitdataValidation(int row)
		{
			reportingdetails_tab();
			it_requirementtab();
			boolean itrequirement_radio_btnyes= IT_Requirement_RadioButtonYES.isEnabled();
			boolean itrequirement_radio_btnno= IT_Requirement_RadioButtonNo.isEnabled();
			if(itrequirement_radio_btnyes==true && itrequirement_radio_btnno==true)
			{
				logger.info("Radio Yes/No button shouldn't be enabled once submitted.");
				
			}	
			String hard_supp= excelreaddata().getData("RmRmgAdmin_data", row, 0);
			String os_type= excelreaddata().getData("RmRmgAdmin_data", row, 1);
			String peripherals= excelreaddata().getData("RmRmgAdmin_data", row, 2); 
			String comments= excelreaddata().getData("RmRmgAdmin_data", row, 3);
			
			String submit_hard_supp=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_it_hardware').options[document.getElementById('cand_it_hardware').selectedIndex].text");
		  	String submit_osType=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_it_typeofOS').value");
		  	String submit_peripherals=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_it_peripherals').value");
		  	String submit_ITcomments= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_it_comments').value");
		  	
			  	boolean hardwaresupp_field= Hardware_Support_DD.isEnabled();
				if(hardwaresupp_field==false)
				{
					if(hard_supp.equalsIgnoreCase(submit_hard_supp))
					{
						logger.info("The Hardware Support value is matching with the RM saved data");
					}
					else
					{
						logger.info("The Hardware Support value is not saved or matching with the RM saved data");
					}
				}
				boolean osType_field= OS_Type.isEnabled();
				if(osType_field==false)
				{
					if(os_type.equalsIgnoreCase(submit_osType))
					{
						logger.info("The OS type is matching with the RM saved data");
					}
					else
					{
						logger.info("The OS type is not saved or matching with the RM saved data");
					}
				}
				boolean peripherals_field= IT_Peripherals_Input.isEnabled();
				if(peripherals_field==false)
				{
					if(peripherals.equalsIgnoreCase(submit_peripherals))
					{
						logger.info("The Peripherals is matching with the RM saved data");
					}
					else
					{
						logger.info("The Peripherals is not saved or matching with the RM saved data");
					}
				}
				boolean itComment_field= IT_Comments_Input.isEnabled();
				if(itComment_field==false)
				{
					if(comments.equalsIgnoreCase(submit_ITcomments))
					{
						logger.info("The IT comments is matching with the RM saved data");
					}
					else
					{
						logger.info("The IT comments is not saved or matching with the RM saved data");
					}
				}
		}
		
		/*
		ADF validation for RMG/ADMIN
		*/
		public void adf_formaccept(String emp_ID, String admin_status, int row)
		{
			 ObjectInitClass.HP.Log_Out();
			Waitfor(1);
			// Read Excel object creation to pass the sheet parameter.
		  	String RMG_username= excelreaddata().getData("Login_Credentials", 2, 0 ); //Reading Username from excel
		  	Waitfor(1);
		  	String RMG_password= excelreaddata().getData("Login_Credentials", 2, 1 ); //Reading Password from excel
		  	Waitfor(1);
		  				
		  	 ObjectInitClass.LP.signIn(RMG_username, RMG_password);
		  	Waitfor(1);
			
		  	String match_status= to_HandleStatuscheck(emp_ID, admin_status);
			if(!match_status.contains("No Match found"))
			{
				
				Waitfor(2);
				it_requirementtab();
				boolean radiobutton_status= IT_Requirement_RadioButtonYES.isDisplayed();
				if(radiobutton_status==true)
				{
					logger.info("For Admin Radio buttons shouldn't display as it is a view page.");
				}
					admin_ITsubmitdataValidation(row);
					Waitfor(1);
					admin_accept();
					//ADF_Button.click();
					Waitfor(2);
					boolean addbutton= ADF_AddButton.isDisplayed();
					if(addbutton==true)
					{
						ADF_Submit_Button.click();
						Waitfor(1);
						String adfsubmit_toastmsg= GenericToastMsg.getText();
						if(adfsubmit_toastmsg=="Please Fill All the Fields")
						{
							logger.info("The ADF submit button has not been validated properly");
						}
						else
						{
							logger.info("The ADF submit button has not been validated properly");
						}
						adf_FillLater();
						boolean acceptbutton_status= ADF_Accept.isDisplayed();
						boolean rejectbutton_status= ADF_Reject.isDisplayed();
						boolean adfbuttonstatus= ADF_Button.isEnabled();
						if(acceptbutton_status==true && rejectbutton_status==true && adfbuttonstatus==false)
						{
							logger.info("On IT Accept and clicking on Fill Later, the Accept & Reject button shouldn't be displayed again");
						}	
						else
						{
							logger.info("On IT Accept and clicking on Fill Later, the Accept & Reject button is not displaying again");

						}
					ADF_Button.click();	
					Waitfor(1);
				    ADF_AddButton.click();
				    ADF_AddButton.click();
					
					int loopcount=0;
					String[] adfvalues= {"Laptop","45367UF920", "Lenovo", "Ubuntu 17.0, i7 processor with 8GB Ram", "3245", "Working Condition Tested" };
					WebElement row_table = driver.findElement(By.xpath("//table[@id='candItAssetDetailsTable']/tbody"));
					List<WebElement> rows = row_table.findElements(By.tagName("tr"));
					logger.info(rows.size());
					rowloop:
					for (int r = 1; r <= rows.size(); r++) 
					{
						WebElement col_table = driver.findElement(By.xpath("//table[@id='candItAssetDetailsTable']/tbody/tr"));
						List<WebElement> column = col_table.findElements(By.tagName("td"));
						logger.info(column.size());
						int count= 1;
							columnloop:
							for (int c = 1; c <= 6; c++) 
							{
							
							WebElement adf_value = driver.findElement(By.xpath("//table[@id='candItAssetDetailsTable']/tbody/tr[" + r + "]/td[" + (count) + "]/input"));
			
							String placeholdertext = adf_value.getAttribute("placeholder");
							Waitfor(1);
							if(placeholdertext.equalsIgnoreCase("Enter Asset Type"))
							{
								adf_value.sendKeys(Keys.chord(Keys.CONTROL, "a"), adfvalues[0]);
								Waitfor(1);
							}
							else if(placeholdertext.equalsIgnoreCase("Enter Asset Number"))
							{
								adf_value.sendKeys(Keys.chord(Keys.CONTROL, "a"), adfvalues[1]);
								Waitfor(1);
							}	
							else if(placeholdertext.equalsIgnoreCase("Enter Asset Brand Name"))
							{
								adf_value.sendKeys(Keys.chord(Keys.CONTROL, "a"), adfvalues[2]);
								Waitfor(1);
							}	
							else if(placeholdertext.equalsIgnoreCase("Enter Asset Description"))
							{
								adf_value.sendKeys(Keys.chord(Keys.CONTROL, "a"), adfvalues[3]);
								Waitfor(1);
							}	
							else if(placeholdertext.equalsIgnoreCase("Enter Serial Number"))
							{
								adf_value.sendKeys(Keys.chord(Keys.CONTROL, "a"), adfvalues[4]);
								Waitfor(1);
							}	
							else if(placeholdertext.equalsIgnoreCase("Enter Remarks"))
							{
								adf_value.sendKeys(Keys.chord(Keys.CONTROL, "a"), adfvalues[5]);
								Waitfor(1);
							}	
							count++;
							if(r==3)
							{
								if(count==12)
								{
									WebElement removebutton = driver.findElement(By.xpath("//table[@id='candItAssetDetailsTable']/tbody/tr[" + r + "]/td[" + (count) + "]/div/button"));
									Waitfor(1);
									removebutton.click();
								}
							}
							count++;
							
							}
						

				if(loopcount>=rows.size())
				{
				break;
				}
			  loopcount++;
			}
		   }
		   else
		   {
			   logger.info("On click of accept, ADF window hasn't popped up");
		   }		
		  }	
		  else
		  {
			  logger.info("There is no record matched with the passed Status & Emp-ID found in Candidate table..!!");
		  }
		}
		
		public void admin_ITsubmitdataValidation(int row)
		{
			
				String hard_supp= excelreaddata().getData("RmRmgAdmin_data", row, 0);
				String os_type= excelreaddata().getData("RmRmgAdmin_data", row, 1);
				String peripherals= excelreaddata().getData("RmRmgAdmin_data", row, 2); 
				String comments= excelreaddata().getData("RmRmgAdmin_data", row, 3);
				
				String submit_hard_supp=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_it_hardware').options[document.getElementById('cand_it_hardware').selectedIndex].text");
			  	String submit_osType=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_it_typeofOS').value");
			  	String submit_peripherals=  (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_it_peripherals').value");
			  	String submit_ITcomments= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('cand_it_comments').value");
			  	
			  	boolean hardwaresupp_field= Hardware_Support_DD.isEnabled();
				if(hardwaresupp_field==false)
				{
					if(hard_supp.equalsIgnoreCase(submit_hard_supp))
					{
						logger.info("The Hardware Support value is matching with the RM saved data");
					}
					else
					{
						logger.info("The Hardware Support value is not saved or matching with the RM saved data");
					}
				}
				boolean osType_field= OS_Type.isEnabled();
				if(osType_field==false)
				{
					if(os_type.equalsIgnoreCase(submit_osType))
					{
						logger.info("The OS type is matching with the RM saved data");
					}
					else
					{
						logger.info("The OS type is not saved or matching with the RM saved data");
					}
				}
				boolean peripherals_field= IT_Peripherals_Input.isEnabled();
				if(peripherals_field==false)
				{
					if(peripherals.equalsIgnoreCase(submit_peripherals))
					{
						logger.info("The Peripherals is matching with the RM saved data");
					}
					else
					{
						logger.info("The Peripherals is not saved or matching with the RM saved data");
					}
				}
				boolean itComment_field= IT_Comments_Input.isEnabled();
				if(itComment_field==false)
				{
					if(comments.equalsIgnoreCase(submit_ITcomments))
					{
						logger.info("The IT comments is matching with the RM saved data");
					}
					else
					{
						logger.info("The IT comments is not saved or matching with the RM saved data");
					}
				}
		}
		public void adf_ADD()
		{
			ADF_AddButton.click();
			Waitfor(1);
		}
		public void adf_FillLater()
		{
			ADF_FillLater_Button.click();
			Waitfor(2);
		}
		public void adf_Close()
		{
			ADF_Close_Button.click();
		}
		public void adfsubmit_validation()
		{
			ADF_Submit_Button.click();
			Waitfor(1);
			String adfsubmit_toastmsg= GenericToastMsg.getText();
			if(adfsubmit_toastmsg=="Asset Details Submitted Successfully")
			{
				logger.info("The ADF submit button has been validated properly");
			}
			else
			{
				logger.info("The ADF submit button has not been validated properly");
			}
			
		}
		
		//To get the candidate name, joining date & RM Name from the candidate view page general info tab.
		public String get_emp_firstname()
		{
			String firstname= View_EMPFirstname.getText();
			return firstname;
		}
		
		public String get_emp_lastname()
		{
			String lastname= View_EMPLastname.getText();
			return lastname;
		}
		public String get_projectname()
		{
			String doj= View_Project_Name.getText();
			return doj;
		}
		public String get_empID()
		{
			String join_loc= View_EMPID.getText();
			return join_loc;
		}
		
		public void adf_viewvalidation(String emp_ID, String status)
		{
			
			 ObjectInitClass.HP.Log_Out();
			Waitfor(1);
			// Read Excel object creation to pass the sheet parameter.
		  	String RMG_username= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
		  	Waitfor(1);
		  	String RMG_password= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
		  	Waitfor(1);
		  				
		  	 ObjectInitClass.LP.signIn(RMG_username, RMG_password);
		  	
		  	Waitfor(2);
			String match_status= rmg_employeeTablestatuscheck(emp_ID, status);
			if(!match_status.contains("No Match found"))
			{
				Waitfor(1);	
				String emp_firstname= get_emp_firstname();
				String emp_lastname= get_emp_lastname();
				String emp_project= get_projectname();
				String employee_ID= get_empID();			
				String emp_fullname= emp_firstname+" "+emp_lastname; 
					
				Waitfor(1);
				scroll_right();
				Waitfor(1);
				it_requirementtab();
				Waitfor(2);
				boolean radiobutton_status= IT_ReqEMPRadioYES.isDisplayed();
				if(radiobutton_status==true)
				{
					logger.info("For Admin Radio buttons shouldn't display as it is a view page.");
				}
				ADF_ViewButtonEMP.click();
				Waitfor(2);
				String adfemployee_fullname= ViewADF_EmpName.getText();
				if(emp_fullname.equalsIgnoreCase(adfemployee_fullname))
				{
					logger.info("The Employee name in ADF details is matching with the created profile candidate name");
				}
				else
				{
					logger.info("The Employee name in ADF details is not matching with the created profile candidate name");
				}	
				String adfemp_ID= ViewADF_EmpID.getText();
				if(employee_ID.equalsIgnoreCase(adfemp_ID))
				{
					logger.info("The Employee ID in ADF details is matching with the created profile candidate name");
				}
				else
				{
					logger.info("The Employee ID in ADF details is not matching with the created profile candidate name");
				}
				String adfprojectname= ViewADF_ProjName.getText();
				if(emp_project.equalsIgnoreCase(adfprojectname))
				{
					logger.info("The Project name in ADF details is matching with the created profile candidate name");
				}
				else
				{
					logger.info("The Project name in ADF details is not matching with the created profile candidate name");
				}
				Waitfor(1);
				adf_datepicker();	
				Waitfor(1);	
			String[] adfvalues= {"Laptop","45367UF920", "Lenovo", "Ubuntu 17.0, i7 processor with 8GB Ram", "3245", "Working Condition Tested" };
			WebElement row_table = driver.findElement(By.xpath("//table[@id='candItAssetTableView']/tbody"));
			List<WebElement> rows = row_table.findElements(By.tagName("tr"));
			logger.info(rows.size());
			for (int r = 1; r <= rows.size(); r++) 
			{
				WebElement col_table = driver.findElement(By.xpath("//table[@id='candItAssetTableView']/tbody/tr"));
				List<WebElement> column = col_table.findElements(By.tagName("td"));
				logger.info(column.size());
				int count= 1;
	
					for (int c = 1; c <= 6; c++) 
					{
					
					WebElement adf_value = driver.findElement(By.xpath("//table[@id='candItAssetTableView']/tbody/tr[" + r + "]/td[" + (count) + "]"));
					String placeholdertext = adf_value.getText();
					Waitfor(1);
					if(placeholdertext.equalsIgnoreCase(adfvalues[0]))
					{
						logger.info("");
					}
					else if(placeholdertext.equalsIgnoreCase(adfvalues[1]))
					{
						logger.info("");
					}	
					else if(placeholdertext.equalsIgnoreCase(adfvalues[2]))
					{
						logger.info("");
					}	
					else if(placeholdertext.equalsIgnoreCase(adfvalues[3]))
					{
						logger.info("");
					}	
					else if(placeholdertext.equalsIgnoreCase(adfvalues[4]))
					{
						logger.info("");
					}	
					else if(placeholdertext.equalsIgnoreCase(adfvalues[5]))
					{
						logger.info("");
					}	
					count++;
					}	
				}		
		    }
			else 
			{
				logger.info("There is no record matched with the passed Status & Emp-ID found in Candidate table..!!");
			}
		}
		
		public void admin_accept()
		{
			boolean adf_acceptststatus= ADF_Accept.isDisplayed();
			if(adf_acceptststatus==true)
			{
				boolean acceptbutton_status = ADF_Accept.isEnabled();
				if(acceptbutton_status==true)
				{
					ADF_Accept.click();
					Waitfor(1);
				}
				else
					logger.info("The Accept button is not enable in ADF for Admin");
				
			}
			else
			{
				logger.info("There is no Accept button displayed for accepting the Requirement");
			}
		}
		
		public void admin_reject()
		{
			boolean adf_rejectststatus= ADF_Reject.isDisplayed();
			if(adf_rejectststatus==true)
			{
				boolean rejectbutton_status = ADF_Reject.isEnabled();
				if(rejectbutton_status==true)
				{
					ADF_Reject.click();
					Waitfor(1);
				}
				else
					logger.info("The Reject button is not enable in ADF for Admin");
			
			}
			else
			{
				logger.info("There is no Reject button displayed for Rejecting the Requirement");
			}
		}
		
		public void adf_formreject(String emp_ID, String admin_status)
		{
			 ObjectInitClass.HP.Log_Out();
			Waitfor(1);
			// Read Excel object creation to pass the sheet parameter.
		  	String RMG_username= excelreaddata().getData("Login_Credentials", 2, 0 ); //Reading Username from excel
		  	Waitfor(1);
		  	String RMG_password= excelreaddata().getData("Login_Credentials", 2, 1 ); //Reading Password from excel
		  	Waitfor(1);
		  				
		  	 ObjectInitClass.LP.signIn(RMG_username, RMG_password);
		  	Waitfor(1);
			
		  	String match_status= to_HandleStatuscheck(emp_ID, admin_status);
			if(!match_status.contains("No Match found"))
			{
				
				Waitfor(2);
				it_requirementtab();
				boolean radiobutton_status= IT_Requirement_RadioButtonYES.isDisplayed();
				if(radiobutton_status==true)
				{
					logger.info("For Admin Radio buttons shouldn't display as it is a view page.");
				}
					admin_reject();
					boolean reject_submitbuttonstatus= ADF_RejectSubmit_Button.isDisplayed();
					if(reject_submitbuttonstatus==true)
					{
						ADF_RejectSubmit_Button.click();
						String comment_toastmsg= GenericToastMsg.getText();
						boolean reject_submitstatus= ADF_RejectSubmit_Button.isDisplayed();
						if(comment_toastmsg.equalsIgnoreCase("Comment is required!!!!") && reject_submitstatus==true)
						{	
						ADF_RejectComment_Box.sendKeys(Keys.chord(Keys.CONTROL, "a"), "Out Of Stock..!!");
						Waitfor(1);
						ADF_RejectSubmit_Button.click();
						Waitfor(1);
						String rejectsubmit_toastmsg= GenericToastMsg.getText();
							if(rejectsubmit_toastmsg.equalsIgnoreCase("IT Details Rejected Successfully"))
							{	
								logger.info("IT req has been succesfully rejected with proper validation");
							}
							else
								logger.info("On rejection of IT Req, proper toast msg wasn't popped up");
						}	
						else
						{
							logger.info("No Proper validation has been done for Reject Submit functionality as without passing any comment it submitted");
						}
					}
					else
						logger.info("Reject comment window hasn't popped up on click of Reject Button");
						
			}
		}
			
		public void rm_itrejectedrequirements(String emp_ID, String status)
		{
				
			 ObjectInitClass.HP.Log_Out();
			Waitfor(1);
			String RMG_username= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
		  	Waitfor(1);
		  	String RMG_password= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
		  	Waitfor(1);
		  				
		  	 ObjectInitClass.LP.signIn(RMG_username, RMG_password);
		  	Waitfor(1);
		  	candidate_employment_statuscheck(emp_ID, status);
			String getRM_Name= get_RMname();
			String[] split_space= getRM_Name.split("\\s+");
			String respectiveRM_Name= split_space[0];
			
			 ObjectInitClass.HP.Log_Out();
			Waitfor(1);
			int count = 0;
			// Read Excel object creation to pass the sheet parameter.
			for(int row=1; row<=50; row++)
			{	
			String RM_username= excelreaddata().getData("Login_Credentials", row, 0 ); //Reading Username from excel
			  	if(RM_username.contains(respectiveRM_Name))
			  	{		
				  	String RM_password= excelreaddata().getData("Login_Credentials",row, 1 ); //Reading Password from excel
				  	Waitfor(1);
				  				
				  	 ObjectInitClass.LP.signIn(RM_username, RM_password);
				  	
				  	count++;
			
					Waitfor(2);
					String match_status= candidate_employment_statuscheck(emp_ID, status);
					if(!match_status.contains("No Match found"))
					{
						Waitfor(2);
						it_requirementtab();
						String account_holdername= get_acc_Hldr_Name();
						
						if(getRM_Name.equalsIgnoreCase(account_holdername))
						{
							logger.info("The Candidate record lies in the respective RM table.");
							
							boolean itrequirement_radio_btnyes= IT_Requirement_RadioButtonYES.isSelected();
							if(itrequirement_radio_btnyes==false)
							{
								Waitfor(1);
								logger.info("The IT Requirement Yes radio button wasn't selected by default");
								IT_Requirement_RadioButtonYES.click();
								Waitfor(1);
							}
							boolean save_status= IT_Save_Button.isDisplayed();
							boolean submit_status= IT_Submit_Button.isDisplayed();
							if(save_status==true && submit_status==true )
							{	
							  count++;
							  IT_Comments_Input.sendKeys(Keys.chord(Keys.CONTROL, "a"), excelreaddata().getData("RmRmgAdmin_data", row, 3 ));
							  Waitfor(2);
							  IT_Submit_Button.click();
							}
						}
						else
						{
							logger.info("The Candidate record doesn't lie in the respective/authorized RM table it is present in different/unauthorized account table.");
						}	
					}
					else 
					{
						logger.info("There is no record matched with the passed Status & Emp-ID found in Candidate table..!!");
					}
					if(count>0)
				  	{
				  	break;
				  	} 	
				}
		  	if(count>0)
		  	{
		  	break;
		  	} 	
		  }
		}
		
		public void backbutton()
		{
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-350)", "");
			Cand_Backbutton.click();
			Waitfor(2);
		}
		
		public void adf_print()
		{
			boolean print_status= ViewADF_PrintButton.isDisplayed();
			if(print_status==true)
			{
				boolean printbutton_status = ViewADF_PrintButton.isEnabled();
				if(printbutton_status==true)
				{
					ViewADF_PrintButton.click();
					Waitfor(2);
				}
				else
					logger.info("The Print button is not enable in ADF view page");
			}
			else
			 logger.info("The Print button is not displaying in ADF view page");
		}
		
		public void scroll_left()
		{
			Emp_ScrollLeft.click();
			Waitfor(1);
		}
		public void scroll_right()
		{
			Emp_ScrollRight.click();
			Waitfor(1);
		}
		
		public void adf_sendmail()
		{
			boolean sendmail_status= ViewADF_SendMailButton.isDisplayed();
			if(sendmail_status==true)
			{
				boolean sendmailbutton_status = ViewADF_SendMailButton.isEnabled();
				if(sendmailbutton_status==true)
				{
					ViewADF_SendMailButton.click();
					Waitfor(2);
				}
				else
					logger.info("The Send-Mail button is not enable in ADF view page");
			}
			else
			 logger.info("The Send-Mail button is not displaying in ADF view page");
		}
		
		public String to_HandleStatuscheck(String candId, String admin_status)
		{
			Waitfor(1);
			MYLynx_Module.click();
			Waitfor(2);
			Candidate_Submodule.click();
			Waitfor(5);
			To_HandleTab.click();
			
				Waitfor(3);
				ToHandleTableSearch_InputBox.sendKeys(Keys.chord(Keys.CONTROL, "a"),candId);
				Waitfor(1);
			
				Actions action = new Actions(driver);
				int count = 0;
				String candidateID= "";
				String col_text = "Employee Id";
				List<WebElement> page = driver.findElements(By.xpath("//div[@id='cand_toHandle_table_paginate']/span/a"));
				if (page.size() > 0) {
				for (int i = 1; i <=page.size(); i++) 
				{
					if(i>1)
					{	
					driver.findElement(By.xpath("//div[@id='cand_toHandle_table_paginate']/span/a[" + (i) + "]")).click();
					Waitfor(1);
					}
				WebElement table = driver.findElement(By.xpath("//table[@id='cand_toHandle_table']/thead"));
				List<WebElement> heading = table.findElements(By.tagName("th"));
				for (int h = 0; h < heading.size(); h++) {
					String text = heading.get(h).getText();
					if (col_text.equalsIgnoreCase(text)){ 
						int col = h;
						WebElement row_table = driver.findElement(By.xpath("//table[@id='cand_toHandle_table']/tbody"));
						List<WebElement> rows = row_table.findElements(By.tagName("tr"));
						logger.info(rows.size());
						for (int c = 1; c <= rows.size(); c++) {
							
							String cell_Value = driver
									.findElement(By.xpath("//table[@id='cand_toHandle_table']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
									.getText();
							Waitfor(2);
							String array[] = { "Candidate Created", "Approved", "Rejected", "Completed", "Submitted" };
							
							if (cell_Value.equalsIgnoreCase(candId)) {
								
								WebElement report= driver.findElement(By.xpath("//table[@id='cand_toHandle_table']/tbody/tr[" + c + "]/td[1]"));
								action.click(report).build().perform();
								Waitfor(2);

								String  s= driver.findElement(By.xpath("//table[@id='cand_toHandle_table']/tbody/tr[" + c + "]/td[7]")).getText();
								if(s.equalsIgnoreCase(admin_status))
								{
									logger.info("Status is matching with the passed status & Status is "+s);
									action.doubleClick(report).build().perform();
									Waitfor(2);	
								}
								else
									logger.info("Status is not matching with the passed status & Status is "+s);
								
								logger.info("The newly created Candidate ID is: "+cell_Value);
								count++;
				
								break;
							}
							else 
							{
							logger.info("No candidate record found with "+candId+ "" );
							}
						}
						if(count>0)
						{
						break;
						}
					}
					
			}	
			if(count>0)
			{
			break;
			}
		  }
		}
		return candidateID;
	}

		public String adf_datepicker()
		{
			//Selecting the date of joining from the date picker.
			
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-YYYY");
			String subdate[]=dateFormat.format(date).split("-");

			String adf_dateofissue="";
			char[] date_char= subdate[0].toCharArray();
			String firstdatechar = String.valueOf(subdate[0].charAt(0));
			if(firstdatechar.equals("0"))
			{
				char c = subdate[0].charAt(1);
				adf_dateofissue= Character.toString(c);
			}
			else
			{
				adf_dateofissue= subdate[0];
			}
			String month= subdate[1];
			String year= subdate[2];
			
			DOI_Calendar.click();	
			Waitfor(1);
			List<WebElement> doj_dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
			for (int i = 0; i < doj_dates.size(); i++) {
				String doj_date = doj_dates.get(i).getText();

				if (doj_date.equals(adf_dateofissue) && !(doj_date=="")) {
					
					Select month_dd= new Select(Client_Month_DD);
					month_dd.selectByVisibleText(month);
					

					Select year_dd= new Select(Client_Year_DD);
					year_dd.selectByVisibleText(year);
					
					doj_dates.get(i).click();
					logger.info("Selected date is: " + adf_dateofissue+"-"+month+"-"+year);
					selected_dateofissue= month+"/"+adf_dateofissue+"/"+year;
				  	String sel_rmclientrepo_Date=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('candAssetViewDateofIssue').value");
					if(sel_rmclientrepo_Date.equalsIgnoreCase(selected_dateofissue))
					{
						logger.info("The ADF Date of Issue is selected and matching with the passed data");
					}
					else
					{
						logger.info("The ADF Date of Issue is not selected or matching with the passed data");
					}
					break;

				}
			}
		  return selected_dateofissue;
		}	
		
		public String rmg_employeeTablestatuscheck(String emp_ID, String status)
		{
			Rmg_Module.click();
			Waitfor(1);
			Employees_Submodule.click();
			
				Waitfor(2);
				String EMPID=  driver.findElement(By.xpath("//table[@id='employee_home']/tbody/tr[2]/td[1]")).getText();
				Employees_SearchInput.sendKeys(Keys.chord(Keys.CONTROL, "a"),EMPID);
				Waitfor(1);
				
				Actions action = new Actions(driver);
				int count = 0;
				String fail= "";
				String col_text = "Emp ID";
				List<WebElement> page = driver.findElements(By.xpath("//div[@id='employee_home_paginate']/span/a"));
				if (page.size() > 0) {
				for (int i = 1; i <=page.size(); i++) 
				{
					if(i>1)
					{	
					driver.findElement(By.xpath("//div[@id='employee_home_paginate']/span/a[" + (i) + "]")).click();
					Waitfor(1);
					}
				WebElement table = driver.findElement(By.xpath("//table[@id='employee_home']/thead/tr"));
				List<WebElement> heading = table.findElements(By.tagName("th"));
				for (int h = 0; h < heading.size(); h++) {
					String text = heading.get(h).getText();
					if (col_text.equalsIgnoreCase(text)) {
						int col = h;
						WebElement row_table = driver.findElement(By.xpath("//table[@id='employee_home']/tbody"));
						List<WebElement> rows = row_table.findElements(By.tagName("tr"));
						logger.info(rows.size());
						for (int c = 1; c <= rows.size(); c++) {
							
							String cell_Value = driver
									.findElement(By.xpath("//table[@id='employee_home']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
									.getText();
							Waitfor(2);
						
							if (cell_Value.equalsIgnoreCase(EMPID)) {
								
								WebElement report= driver.findElement(By.xpath("//table[@id='employee_home']/tbody/tr[" + c + "]/td[1]"));
								action.click(report).build().perform();
								Waitfor(2);
								String  s= driver.findElement(By.xpath("//table[@id='employee_home']/tbody/tr[" + c + "]/td[9]")).getText();
								if(s.equalsIgnoreCase(status))
								{
								logger.info("Status is matching with the passed status & Status is "+s);
								action.doubleClick(report).build().perform();
								Waitfor(2);
								
								// Edit button validation
								boolean empgeneralinfo_Tab_status = EmpGeneralInfo_Tab.isDisplayed();
									if (empgeneralinfo_Tab_status == true) {
										logger.info("Employee General Info Tab is displayed in Employee page and status is :" + empgeneralinfo_Tab_status);
										Waitfor(2);
										
									}
									else
									{
										logger.info("General Info Tab is not present in Employee page and status is :" + empgeneralinfo_Tab_status);
									}
							
									logger.info("The Passed Employee ID is "+cell_Value);
									count++;
				
									break;
									}
								
									else 
									{
									logger.info("Employee Status passed is not matching & the current Employee status is : "+s);	
									}

							}
							else
							{	
							logger.info("There is no record matched with the passed Status & EMP-ID found in Employee table..!!");
							
							fail = "No Match found";
							}
						}
					if(count>0)
					{
					break;
					}
				  }
				}
				if(count>0)
				{
				break;
				}
			 }
			}
		   return fail;
		}
		
		public String cand_backout(String emp_ID, String status)
		{
			 Waitfor(3);
				MYLynx_Module.click();
				Waitfor(1);
				Candidate_Submodule.click();
				
					Waitfor(2);
					Search_Table_InputBox.sendKeys(Keys.chord(Keys.CONTROL, "a"),emp_ID);
					Waitfor(1);
				
					Actions action = new Actions(driver);
					int count = 0;
					String fail= "";
					String col_text = "Candidate ID";
					List<WebElement> page = driver.findElements(By.xpath("//div[@id='candidate_home_paginate']/span/a"));
					if (page.size() > 0) {
					for (int i = 1; i <=page.size(); i++) 
					{
						if(i>1)
						{	
						driver.findElement(By.xpath("//div[@id='candidate_home_paginate']/span/a[" + (i) + "]")).click();
						Waitfor(1);
						}
					WebElement table = driver.findElement(By.xpath("//table[@id='candidate_home']/thead/tr"));
					List<WebElement> heading = table.findElements(By.tagName("th"));
					for (int h = 0; h < heading.size(); h++) {
						String text = heading.get(h).getText();
						if (col_text.equalsIgnoreCase(text)) {
							int col = h;
							WebElement row_table = driver.findElement(By.xpath("//table[@id='candidate_home']/tbody"));
							List<WebElement> rows = row_table.findElements(By.tagName("tr"));
							logger.info(rows.size());
							for (int c = 1; c <= rows.size(); c++) {
								
								String cell_Value = driver
										.findElement(By.xpath("//table[@id='candidate_home']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
										.getText();
								Waitfor(2);
								String array[] = { "Candidate Created", "Approved", "Rejected", "Completed", "Submitted" };
								
								if (cell_Value.equalsIgnoreCase(emp_ID)) {
									
									WebElement report= driver.findElement(By.xpath("//table[@id='candidate_home']/tbody/tr[" + c + "]/td[1]"));
									action.click(report).build().perform();
									Waitfor(2);
									String  s= driver.findElement(By.xpath("//table[@id='candidate_home']/tbody/tr[" + c + "]/td[5]")).getText();
										if(!s.equalsIgnoreCase(status))
										{
										logger.info("Status is not Back Out & the current Status is "+s);
										Cand_Backout.click();
										count++;
										}
										else 	
										{
										logger.info("Status passed is matching whcih is back out & the current Status is : "+s);	
										}

								}
								else
								{	
								logger.info("There is no record matched with the passed Status & Cand-ID found in Candidate table..!!");
								
								fail = "No Match found";
								}
						}
						if(count>0)
						{
						break;
						}
					  }	
					  else 
					  {
						logger.info("The Column passed is not matching with the Column in the Table");
					  }
					}
					if(count>0)
					{
					break;
					}
				 }
				}
				return fail;
			}
			
		
		public void cand_adfview()
		{
			 ObjectInitClass.HP.Log_Out();
			Waitfor(1);
			// Read Excel object creation to pass the sheet parameter.
		  	String cand_masterpwd= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
		  	Waitfor(1);
		  				
		  	 ObjectInitClass.LP.signIn(usnLynx, cand_masterpwd);
		  	Waitfor(2);
		  	Account_Info.click();
		  	Waitfor(1);
		  	Cand_UpdateProfile.click();
		  	Waitfor(1);
		  	boolean generalnfo_status= Cand_GeneralInfo.isDisplayed();
		  	if(generalnfo_status==true)
		  	{
		  		boolean itreq_status= Cand_ITRequirement.isDisplayed();
		  		if(itreq_status==true)
		  		{	
		  		Cand_ITRequirement.click();
		  		Waitfor(1);
		  		CandADF_Upload.click();
		  		}
		  		else
		  			logger.info("IT Req tab is not present in the candidate Update Profile Window");
		  	}
		}
         /*
           End (Akash.Anand)
          */
		


		
		// User story #3033, #3034, #3035, #3036


			public void MyLynxTab()
			{
			    myLynx.click();
			    Waitfor(2);
			}

			public void CandidateModule()
			{
				Waitfor(2);
				CandidateSubmodule.click();
				Waitfor(6);
			}
			
			public void selectEmployee(String searchEmployeeName)
			{
				Waitfor(1);
				searchField.sendKeys(searchEmployeeName);
				Waitfor(1);
				selectEmp.click();
				
			}
			public void rmgmodule()
			{
				Waitfor(2);
				RMGModule.click();
				Waitfor(2);
				employeeModule.click();
				Waitfor(3);
			}
			
		   public void markAsEmployee_button()
				{
					boolean res=MarkasEmployee.isEnabled();
					if(res==true)
					{
						
						MarkasEmployee.click();
						logger.info("The mark as Employee Button is enabled and clicked successfully...!!");
						Waitfor(2);
					}
					else
					{
						
								logger.info("Mark  as Employee button is Not Enabled..!!");
										
					}
							
				}
			
						 
			 public void selectmailandConfirm()
			   {
				boolean status=NewEmpDetails.isDisplayed();
				if(status==true)
				{
					logger.info("Navigated to New Employee Details Pop Up");
					EMPID=Employee_ID.getText();
					logger.info("The generated Employee id is :"+EMPID);
					Waitfor(1);
					String FN=FirstName.getText();
					logger.info("The Employee First Name is : "+FN);
					Waitfor(1);
					String LN=LastName.getText();
					logger.info("The Employee Last Name is :"+LN);
					Waitfor(3);
					ConfirmButtonMarkAsEmp.click();
					Waitfor(4);
					logger.info("Should not allow to Click on Confirm button for the candidate without selecting Email id..!!");
					Waitfor(4);
					Email_ID.sendKeys("125485");
					Waitfor(2);
					ConfirmButtonMarkAsEmp.click();
					logger.info("Its not allowed due to invalid email id");
					Waitfor(4);
					Email_ID.clear();
					
					List<WebElement> olist=driver.findElements(By.xpath("//div[@id='markAsEmployeeAvaiEmailIds']/div/input"));
					int emailsize=olist.size();
					logger.info("The Count of Available email ids is:"+emailsize);
					Waitfor(2);
					
					Emailone.click();
					logger.info("Email One is Clicked Successfull");
					Waitfor(2);
					EmailTwo.click();
					logger.info("Email Two is Clicked Successfull");
					Waitfor(2);
					EmailThree.click();
					logger.info("Email Three is Clicked Successfull");
					Waitfor(2);
					EmailFour.click();
					logger.info("Email Four is Clicked Successfull");
					Waitfor(2);
					EmailFive.click();
					logger.info("Email Five is Clicked Successfull");
					Waitfor(2);
					boolean emailone=Emailone.isDisplayed();
					if(emailone==true)
					{
					
					Emailone.click();	
					Waitfor(2);
					String stremail=Email_ID.getAttribute("value");
					logger.info("The Selected Official Email Id is :"+stremail+"@dikshatech.com");
					}else 
					{
						
						logger.info("Email is Not displayed.");
					}
					ConfirmButtonMarkAsEmp.click();	
					Waitfor(3);
					emailpwd.sendKeys("Diksha@12345");
					String mailpwd=emailpwd.getAttribute("value");
					logger.info("The Entered Mail passowrd is :"+mailpwd);
					Waitfor(2);
					usnLynx=LynxUsername.getAttribute("value");
					Waitfor(2);
					logger.info("The Lynx User for Employee is : "+usnLynx);
					ConfirmButtonMarkAsEmp.click();	
					logger.info("The Confirm Button is Clicked Suceefully");
					Waitfor(2);
					}
				else 
					{
						logger.info("The New Employee details is not displayed...!!!");
										
					}
						    	 
			   }

			 public String LynxUserName()
			 {
				 return usnLynx;
			 }
			 public void mailstatusforCandidate(String fakemailName)				
			 {
				    //Waitfor(3);
				    driver.get("http://www.fakemailgenerator.com/");
					Waitfor(2);	
					Username_Input.clear();
					Waitfor(2);
					WebElement Username_Input=driver.findElement(By.xpath("//input[@id='home-email']"));
					Username_Input.sendKeys(fakemailName);
					Waitfor(2);
					//CopyId_Button.click();
					Waitfor(2);
					
					WebElement Domain_Button=driver.findElement(By.xpath("//*[@id='domain-select']"));	
					Domain_Button.click();

					Waitfor(2);
					
					List<WebElement> rowVals = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li/a"));
					
					for (WebElement webElement : rowVals) {
						
						String domain= webElement.getText();
						
						if(domain.equalsIgnoreCase("@jourrapide.com"))
						{
							webElement.click();
							
							break;
						}
					}
					
					Waitfor(2);
					selectTopMail.click();
					Waitfor(3);
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("window.scrollBy(0,750)", "");
					WebElement framee=driver.findElement(By.xpath("//iframe[@id='emailFrame']"));
					driver.switchTo().frame(framee);
					Waitfor(2);
					boolean nameStatus=EmployeeName.isDisplayed();
					if(nameStatus==true)
					{
					String empName=EmployeeName.getText();
					logger.info("The Employee Name in the RMG Mail is :"+empName);
					}else
					{
						
						logger.info("The Employee is Not getting any mail from RMG Specilist.");
						
					}
					
					String strempID=employyeIDmail.getText();
					logger.info("The employee ID is in RMG mail is :"+strempID);
				   	
					String Emailid=officialmaiId.getText();
					logger.info("The official Email ID for the Employee is :"+Emailid);
					
					
					String Emailpwd=officialmaiIdpwd.getText();
					logger.info("The official Email Password for the Employee is :"+Emailpwd);
					
					Waitfor(1);
					LynxUserName();
					Waitfor(1);	
					LynxPassword();
					logger.info("The User Name for the Employee is :"+usnLynx);
					
			 }
						   	
					     
					     
		    
		 public String LynxPassword()
		 {

			 String pwd=paswordLynx.getText();
			 pwdLynx =pwd;
			 logger.info("The Lynx Password for the Employee is :"+pwdLynx);
			 return pwdLynx;
		 }
		  
		public void generateofferletter(String SearchwithEmpName)
			{
				
				Waitfor(3);
				Employees_SearchInput.sendKeys(SearchwithEmpName);
				Waitfor(3);
				String statusbefore=statusbeforGOF.getText();
				logger.info("The Status Before Generating the Offer Letter is :"+statusbefore);
			    Waitfor(2);
			    selectemployee.click();
			    Waitfor(2);
				boolean strsts=GenenerateOfferletter.isEnabled();
				
				if(strsts==true)
				{
					Waitfor(3);
					GenenerateOfferletter.click();
					Waitfor(3);
					logger.info("Generate Offer Letter Button is Clicked Successfully");
					
				}else
				{
					logger.info("Generate offer Letter Button is NOT Enabled");
					
				}
				
			boolean empoffpopup=newempofferleterpopup.isDisplayed();
			if(empoffpopup==true)
			   {
			
				Waitfor(3);
				//JavascriptExecutor jsea = (JavascriptExecutor)driver;
				//jsea.executeScript("window.scrollBy(0,550)", "");
				Waitfor(5);
				logger.info("New Employee Offer Letter PopUp is Displayed");
				Waitfor(4);
				submitofferletter.click();
				logger.info("The New Employee Offer Letter is Generated and Submitted by RMG Specilist.");
				Waitfor(4);
				
				}else
				{
					logger.info("New Employee Offer Letter PopUp is NOT Displayed");
					
				}
				
				Waitfor(2);
				Employees_SearchInput.clear();
				Waitfor(3);	
				Employees_SearchInput.sendKeys(SearchwithEmpName);
				Waitfor(4);
				String statusafter=statusbeforGOF.getText();
				logger.info("The Status After Generating the Offer Letter is :"+statusafter);
			    Waitfor(4);
			    Employees_SearchInput.clear();
				Waitfor(3);
				
				
			}
				
		   public void acceptOfferLetter()
		       {
			     
			      boolean popup=ooferlinktextpopup.isDisplayed();
			      if(popup==true)
			      {
			    	  logger.info("The Alert PopUp for Offer letter is appeared when New employee Login");
			    	  offerlink.click();
				      Waitfor(3);
				      offerLetterGTab.click();
				      logger.info("The Offer Letter Tab is Clicked Successfully");
					  Waitfor(2);
					Scroll_down();
					  Waitfor(3);
					  boolean acceptsts=AcceptButton.isEnabled();
					  Waitfor(2);
					  Boolean rejectsts=rejectofferletterIcon.isEnabled();
					  Waitfor(2);
					  boolean uploadstss=uploadofferletterIcon.isEnabled();
					  Waitfor(2);
					  if(acceptsts==true)
					  {
						  logger.info("Initially the Accept button is Enable Mode ");
					  }else
					  {
						  logger.info("Initially the Accept button is disable Mode ");
					  }
					  if(rejectsts==true)
					  {
						  logger.info("Initially the Reject button is Enable Mode ");
					  }else
					  {
						  logger.info("Initially the Reject button is disa	testing.candidateble Mode ");
					  }
					  if(uploadstss==false)
					  {
						  logger.info("Initially the Upload button is Disable Mode ");
					  }else
					  {
						  logger.info("Initially the Upload button is Enable Mode ");
					  }
					  
					  if(acceptsts==true)
					  {
						 AcceptButton.click();
						 Waitfor(3);
						 logger.info("The Candidate is Accepted The Offer Letter with Downloading ");
						 Waitfor(2);
						 boolean accept=AcceptButton.isEnabled();
						 Waitfor(2);
						 if(accept==false)
						 {
							 logger.info("The Accept button is Disable Mode once after Accept the Offer Letter");
						 }else
						 {
							 logger.info("The Accept button is enable Mode once after Accept the Offer Letter");
						 }
						 
						 boolean reject=rejectofferletterIcon.isEnabled();
						 Waitfor(1);
						 if(reject==false)
						 {	
							 logger.info("The Reject button is Disable Mode once after Accept the Offer Letter");
						 }else
						 {
							 logger.info("The Reject button is enable Mode once after Accept the Offer Letter");
						 }
						 Waitfor(2);
					     boolean uploadsts=uploadofferletterIcon.isEnabled();
					     if(uploadsts==true)
					     {
					    	 logger.info("The Upload Button is Enabled Once Offer letter Accepted");
					    	 Waitfor(2);
					    	 uploadofferletterIcon.click();
					    	 logger.info("The Upload Button is clicked Suceefully");
					    	 Waitfor(2);
					    	 UploadOfferletter.click();
					    	 Waitfor(2);
					    	 ChooseOfferletter.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadPDF")).getAbsolutePath());
					    	 logger.info("The Offer Letter is Selected to Upload.");
					    	 Waitfor(2);
					    	 UploadOfferletter.click();
					    	 logger.info("The Offer Letter is Successfully Uploaded.");
					    	 Waitfor(2);
					    	 CloseAlert.click();
					    	 Waitfor(3);
					    	 CloseOrintaion.click();
					    	 Waitfor(5);
					     }else
					     {
					    	 logger.info("Upload Button is Not Enabled.");
						    	 
						  }
						    
					  }else
					  {
						  logger.info("The Accept button is not enabled");
					  }
					  
			      
			      }else
			      {
			    	  logger.info("Pop Up Alert message is not appeared for new employee Login");
				    	  
				      }
				      	        
			     }	       
				       
		  public void rejectUploadedOfl(String CandidateName )
		  {
			  
			  	 Waitfor(3);
				 SearchFieldRMGTab.sendKeys(CandidateName);
				 Waitfor(3);
				 String beforests=StatusinRMG.getText();
				 logger.info("Status Before Reject The Uploaded Offer letter :"+beforests);
				 Waitfor(3);
				 selectCandidateActionTab.click();
				 Waitfor(3);
				 Actions oac=new Actions(driver);
				 oac.doubleClick(selectCandidateActionTab).build().perform();
				 Waitfor(3);
				 scrollright.click();
				 Waitfor(2);
				 offerletterTab.click();
				 Waitfor(3);
				 JavascriptExecutor js = (JavascriptExecutor) driver;
				 js.executeScript("window.scrollBy(0,750)");
				 Waitfor(2);
				    
				 boolean bln=acceptOfl.isEnabled();
				 if (bln==true) 
				 {
					logger.info("Accept Button is Enabled...!!");
				 }else
				 {
					 logger.info("Accept Button is disabled Successfully..!!!");
				 }
				 
				 boolean blnr=rejectOfl.isEnabled();
				 if (blnr==true) 
				 {
					logger.info("Reject Button is Enabled Successfully...!!");
					rejectOfl.click();
					Waitfor(2);
					rejectButton.click();
					Waitfor(2);
					RejectOflcommts.sendKeys("Offer is Rejected Due to Signature is not done By Employee..!!");
					Waitfor(2);
					rejectButton.click();
					logger.info("Uploaded Offer Letter is Rejected Due to signature issue..!!");
					Waitfor(2);
				 }else
				 {
					 logger.info("Reject Button is disabled Successfully..!!!");
				 }
				 
				 JavascriptExecutor js1 = (JavascriptExecutor) driver;
				 js1.executeScript("window.scrollBy(0,-500)");
				 Waitfor(3);
				 backbutton.click();
				 Waitfor(2);
				 SearchFieldRMGTab.sendKeys(CandidateName);
				 Waitfor(3);
				 String aftersts=StatusinRMG.getText();
				 logger.info("Status After Rejected The Uploded Offer Letter is :"+aftersts);
				 Waitfor(3);
				 
		  }

		  public void acceptUplodedOfl(String CandidateName )
		  {

			  
			  	 Waitfor(3);
				 SearchFieldRMGTab.sendKeys(CandidateName);
				 Waitfor(3);
				 String beforests=StatusinRMG.getText();
				 logger.info("Status Before Accept The Uploaded offer letter is :"+beforests);
				 Waitfor(3);
				 selectCandidateActionTab.click();
				 Waitfor(3);
				 Actions oac=new Actions(driver);
				 oac.doubleClick(selectCandidateActionTab).build().perform();
				 Waitfor(3);
				 scrollright.click();
				 Waitfor(2);
				 offerletterTab.click();
				 Waitfor(3);
				 JavascriptExecutor js = (JavascriptExecutor) driver;
				 js.executeScript("window.scrollBy(0,750)");
				 Waitfor(2);
				      
			  	
				 
				 boolean blnr=rejectOfl.isEnabled();
				 if (blnr==true) 
				 {
					logger.info("Reject Button is Enabled Successfully...!!");
					
				 }else
				 {
					 logger.info("Reject Button is disabled Successfully..!!!");
				 }
				 

				 boolean bln=acceptOfl.isEnabled();
				 if (bln==true) 
				 {
					logger.info("Accept Button is Enabled...!!");
					Waitfor(2);
					acceptOfl.click();
					logger.info("The Uploded Offer letter is Accepted By RMG Manager...!!");
					Waitfor(2);
				 }else
				 {
					 logger.info("Accept Button is disabled Successfully..!!!");
				 }
				 
				 Waitfor(2);
				 backbutton.click();
				 Waitfor(3);
				 SearchFieldRMGTab.sendKeys(CandidateName);
				 Waitfor(3);
				 String aftersts=StatusinRMG.getText();
				 logger.info("Status After Accept The Uploded Offer Letter is :"+aftersts);
				 Waitfor(3);
				 
		  }
		  
		  
		  public void uploadOflEmp( )
		  {
			
			  Waitfor(1);
			  clickOrientation.click();
			  Waitfor(2);
			  closeOrietan.click(); 
			  Waitfor(2);
			  oflTab.click();
			  Waitfor(2);
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  js.executeScript("window.scrollBy(0,750)");
			  Waitfor(2);
			  boolean uploadsts=uploadOfl.isEnabled();
			     if(uploadsts==true)
			     {
			    	 logger.info("The Upload Button is Enabled Once Offer letter Accepted");
			    	 Waitfor(2);
			    	 uploadOfl.click();
			    	 logger.info("The Upload Button is clicked Suceefully");
			    	 Waitfor(2);
			    	 uplodButtn.click();
			    	 Waitfor(2);
			    	 choosefile.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadPDF")).getAbsolutePath());
			    	 logger.info("The Offer Letter is Selected to Upload.");
			    	 Waitfor(2);
			    	 uplodButtn.click();
			    	 logger.info("The Offer Letter is Successfully Uploaded.");
			    	 Waitfor(2);
			    	 clospopup.click();
			    	 Waitfor(3);
			    	
			     }else
			     {
			    	 logger.info("Upload Button is Not Enabled.");
				    	 
				  }
			  	  
		  }
		  
		  
		   public void rejectofferLetter()
		    {
			   
			   boolean popup=ooferlinktextpopup.isDisplayed();
			   if(popup==true)
			    {
			      logger.info("The Alert PopUp for Offer letter is appeared when New employee Login");
			      offerlink.click();
			      Waitfor(3);
			      offerLetterGTab.click();
			      logger.info("The Offer Letter Tab is Clicked Successfully");
			      Waitfor(2);	
			      boolean acceptsts=AcceptButton.isEnabled();
				  Waitfor(2);
				  Boolean rejectsts=rejectofferletterIcon.isEnabled();
				  Waitfor(2);
				  boolean uploadstss=uploadofferletterIcon.isEnabled();
				  Waitfor(2);
				  if(acceptsts==true)
				  {
					  logger.info("Initially the Accept button is Enable Mode ");
				  }else
				  {
					  logger.info("Initially the Accept button is disable Mode ");
				  }
				  if(rejectsts==true)
				  {
					  logger.info("Initially the Reject button is Enable Mode ");
				  }else
				  {
					  logger.info("Initially the Reject button is disable Mode ");
				  }
				  if(uploadstss==false)
				  {
					  logger.info("Initially the Upload button is Disable Mode ");
				  }else
				  {
					  logger.info("Initially the Upload button is Enable Mode ");
				  }
				   
			       if(rejectsts==true)
			       {
			    	   rejectofferletterIcon.click();
				       Waitfor(2);
				       Rejectwithreason.click();
				       logger.info("Reject is Not allowled due to without Reason");
				       Checkboxtwo.click();
				       Waitfor(1);
				       Checkboxthree.click();
				       Waitfor(1);
				       Checkboxone.click();
				       Waitfor(2);
				       Reasonone.sendKeys("This is due to Issue of Incorrect Personal Details.");
				       Waitfor(1);
				       Checkboxthree.click();
				       Checkboxtwo.click();
				       Waitfor(1);
				       Checkboxothers.click();
				       Waitfor(1);
				       Reasonothers.sendKeys("This is The Reason due to Others Reason Offer Letter is Not Accepted.");
				       Rejectwithreason.click();
				       Waitfor(2);
				       logger.info("Reject Button Is Clicked Suceefully..");
					  Waitfor(2);
					  boolean acceptstatus=AcceptButton.isEnabled();
					  Waitfor(2);
					  Boolean rejectStatus=rejectofferletterIcon.isEnabled();
					  Waitfor(2);
					  boolean uploadstatus=uploadofferletterIcon.isEnabled();
					  Waitfor(2);
					  
					  if(acceptstatus==false)
					  {
						  logger.info("Accept button is Disable Mode once after Rejected By Employee.");
					  }else
					  {
						  logger.info("Accept button is Enable Mode once after Rejected By Employee.");
					  }
					  if(rejectStatus==false)
					  {
						  logger.info("Reject button is Disable Mode once after Rejected By Employee.");
					  }else
					  {
						  logger.info("Reject button is Enable Mode once after Rejected By Employee.");
					  }
					  if(uploadstatus==false)
					  {
						  logger.info("Upload button is Disable Mode once after Rejected By Employee.");
					  }else
					  {
						  logger.info("Upload button is Enable Mode once after Rejected By Employee.");
					  }
				       
			       }else
			       {
			    	   logger.info("The Reject Button is disabled");
			       }
			      
			    }else
			    {
			    	  logger.info("Pop Up Alert message is not appeared for new employee Login");
			    	  
			    }

			   
		       
		   }
			      	

							
			

						
			public void approveTabMGR()
			  {
					Waitfor(3);
					ActionTab.click();
					Waitfor(2);
							
			  }
						
			public void approveRMGManagerLevel(String CandidateName)
				{
					 
				     Waitfor(3);
					 SearchFieldRMGTab.sendKeys(CandidateName);
					 Waitfor(3);
					 String beforests=StatusinRMG.getText();
					 logger.info("Status Before Approve by Manager :"+beforests);
					 Waitfor(3);
					 selectCandidateActionTab.click();
					 Waitfor(3);
					 
					boolean apr=ApprovebyRMGmgr.isEnabled();
				    if(apr==true)
					{
				    	Waitfor(2);
						ApprovebyRMGmgr.click();
					    Waitfor(5);
					    approveButton.click();
					    logger.info("Approved with Preview By RMG Manager for the generated Offer letter.");
					    Waitfor(3);
						SearchFieldRMGTab.sendKeys(CandidateName);
						Waitfor(3);
					    String statusafter=statusafterGOF.getText();
						logger.info("The Status After Approve the Offer Letter is :"+statusafter);
					    Waitfor(4);
					    SearchFieldRMGTab.clear();
						Waitfor(3);
					    
					    
					}else
					{
						
						logger.info("The Approve Button is not enabled.");
						
					}
				
					

			}

			public void OFGMailEmployee(String fakemailName)
			{

					driver.get("http://www.fakemailgenerator.com/");
					Waitfor(2);
							
					WebElement Username_Input=driver.findElement(By.xpath("//input[@id='home-email']"));
					Username_Input.sendKeys(Keys.chord(Keys.CONTROL, "a"),fakemailName);
					Waitfor(2);
					//CopyId_Button.click();
					Waitfor(2);
					
					WebElement Domain_Button=driver.findElement(By.xpath("//*[@id='domain-select']"));
							
					Domain_Button.click();
				
					List<WebElement> rowVals = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li/a"));
					
					for (WebElement webElement : rowVals) {
						
						String domain= webElement.getText();
						
						if(domain.equalsIgnoreCase("@jourrapide.com"))
						{
							webElement.click();
							
							break;
						}
					}
			
					WebElement framee=driver.findElement(By.xpath("//iframe[@id='emailFrame']"));
					driver.switchTo().frame(framee);
					Waitfor(2);
					WebElement RMGMailsub=driver.findElement(By.xpath("//*[@id='email-list']/li[1]/div/dl/dd[3]"));
					boolean status=RMGMailsub.isDisplayed();
			       if(status==true)
			       {
			    	 
			    	   String OFGName=OFGEmployeename.getText();
			    	   logger.info("The offer letter Generated notisfication mail for Employee : "+OFGName);
			    	   Waitfor(2);
			    	  // String ClientName=.getText();
				       logger.info("The Offer Letter Generated Mail Details : "+OFGName);
			    	   
			    	   
			       }
				       
			}


			public void rejectRMGManagerLevel(String searchEmployeeName )
				{
				     Waitfor(3);
					 SearchFieldRMGTab.sendKeys(searchEmployeeName);
					 Waitfor(3);
					 String beforests=StatusinRMG.getText();
					 logger.info("Status Before Reject by Manager :"+beforests);
					 Waitfor(3);
					 selectCandidateActionTab.click();
					 Waitfor(2);
					 boolean rejectsts=RejectbyRMGmgr.isEnabled();
					
					 if(rejectsts==true)
					 {
						 RejectbyRMGmgr.click();
						 logger.info("Reject icon is Clicked Successfully");
					 }else
					 {
						 logger.info("Reject Icon is not enabled");
						 
					 }
					 Waitfor(2);
					 submitReasonbutton.click();
			         Waitfor(3);
			         reasonbyRMGmgr.sendKeys("Rejected due to some issue in the Offer letter");
			         Waitfor(2);
			         submitReasonbutton.click();
			         logger.info("The Reject Button is Clicked Succesfully");
			         Waitfor(2);
			         myEmployees.click();
					Waitfor(2);
					String statusafter=StatusinRMG.getText();
					logger.info("The Status After Generating the Offer Letter is :"+statusafter);
					Waitfor(1);
				}
			 
			
			
			

			//End User stories   #3033 #3034 #3035 #33036
		
		//	orientation tab//

	public void orientation_tab_verify()
	{
		
	acceptOfferLetter();
		 
Boolean orientationlink= orientation_link.isDisplayed();


if(orientationlink== true)
{
	
	logger.info("orientation tab is displayed");
}
else
	{
	logger.info("orientation tab should not displayed");
	}

 
	}
	
	
	public void salary_capture_employee()
	{
		
		Financialinfo_Tab.click();
	     Waitfor(3);
	 
			String sal = Current_CTC.getText();
			double expctc = Double.parseDouble(sal);
			
			logger.info("the current ctc is"+ sal);
			
		if(expctc<=200000.00)
		{
			orientation_video.isDisplayed();
			logger.info("Orientation tab is should  displayed ");
	}
		else
		{
			logger.info("oreientation tab should not dispaly");
		}
	}
	
	public void orientationppt_view()
	{
		
		
		Waitfor(2);
		Guide_Lines.click();
		Waitfor(2);
		boolean orientationtab =orientation_tab.isDisplayed();			
		if(orientationtab== true)
		{
		logger.info("orientation tab  is displayed");
//		orientation_ppt.click();
//		Waitfor(2);	
//		logger.info("orientation ppt is displayed");
		}
		boolean orientationvideo =orientation_video.isDisplayed();
		if(orientationvideo==true)	
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('videoTagId').play()");
	       logger.info("orientation video is displayed");
	      Waitfor(3);
	}
	}
	public void answer_questionnarie()
	{
		
	String question1= questionnarie1.getText();
	logger.info(question1);
	//answer1.click();
	//Waitfor(2);	
	Boolean	Correct_answer1= answer1.isSelected();
	if( Correct_answer1==true)
	{
		 String ans1=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('optionB0').value");
		 logger.info("selected answer is" + ans1 );
	}
	else
	{
		
		logger.info("Selected option is wrong");
	}
	 next_question1.click();
	//next_button();
	
	Waitfor(2);	
	String question2=questionnarie2.getText(); 
	logger.info(question2);
	//answer2.click();
	wrong_answer2.click();
	Waitfor(2);	
		Boolean	 Correct_answer2= answer2.isSelected();
		if( Correct_answer2==true)
		{
			String ans2= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('optionA1').value");
			logger.info("selected answer is" + ans2 );
			
			
		}
		else
		{
			logger.info("Selected option is wrong");
		}
		
		Waitfor(2);	
		next_question2.click();
		Waitfor(2);	
		String question3 =  questionnarie3.getText();
      	logger.info(question3);
  
      	//answer3.click();
      	
      	wrong_answer3.click();
    	Waitfor(2);	
		
		Boolean	 Correct_answer3= answer3.isSelected();
		if( Correct_answer3==true)
		{
			String ans3= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('optionC2').value");
			logger.info("selected answer is" + ans3 );
			
		}
		else
		{
			logger.info("Selected option is wrong");
		}
		next_question3.click();
		
		Waitfor(2);	
		String question4  = questionnarie4.getText();
	 	logger.info(question4);
		//answer4.click();
		Waitfor(2);	
		wrong_answer4.click();
        Boolean	 Correct_answer4= answer4.isSelected();
		if( Correct_answer4==true)
		{
			String ans4= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('optionD3').value");
			 logger.info("selected answer is" + ans4 );
			
		}
		else
		{
			logger.info("Selected option is wrong");
		}
	
		next_question4.click();
		Waitfor(2);	
		
		String question5  = questionnarie5.getText();
		logger.info(question5);
		
		//answer5.click();
		wrong_answer5.click();
		Waitfor(2);	
		
      Boolean Correct_answer5= answer5.isSelected();
		
		if( Correct_answer5==true)
		{
			String ans5= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('optionA4').value");
			logger.info("selected answer is" + ans5 );
			 
		}
		else
		{
			logger.info("Selected option is wrong");
		}

		next_question5.click();
		Waitfor(2);	
		String question6 = questionnarie6.getText();
		logger.info(question6);
		answer6.click();
		Waitfor(2);	
        Boolean	Correct_answer6= answer6.isSelected();
		
		if( Correct_answer6==true)
		{
			String ans6=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('optionB5').value");
			 logger.info("selected answer is " +  ans6 );
		
		}
		else
		{
			logger.info("Selected option is wrong");
		}

		next_question6.click();
		Waitfor(2);		
		String question7 = questionnarie7.getText();
		logger.info(question7);
		answer7.click();
		Waitfor(2);
		
         Boolean Correct_answer7= answer7.isSelected();
		
		if( Correct_answer7==true)
		{
			String ans7= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('optionA6').value");
			logger.info("selected answer is " + ans7 );
			
		}
		else
		{
			logger.info("Selected option is wrong");
		}
		next_question7.click();
		Waitfor(2);	
		String question8 = questionnarie8.getText();
		logger.info(question8);
		answer8.click();
		Waitfor(2);	
       Boolean Correct_answer8= answer8.isSelected();
		
		if( Correct_answer8==true)
		{

			String ans8= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('optionB7').value");
			 logger.info("selected answer is " + ans8 );
			
		}
		else
		{
			logger.info("Selected option is wrong");
		}
		next_question8.click();
		Waitfor(2);	
		String question9 =   questionnarie9.getText();
		logger.info(question9);
		answer9.click();
		Waitfor(2);	
       Boolean Correct_answer9=answer9.isSelected();
		
		if( Correct_answer9==true)
		{
			String ans9= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('optionB8').value");
			 logger.info("selected answer is " + ans9);
			
		}
		else
		{
			logger.info("Selected option is wrong");
		}
		next_question9.click();
		Waitfor(2);	 
		String question10= questionnarie10.getText();
		logger.info(question10);
		answer10.click();
		Waitfor(2);	
        Boolean Correct_answer10=  answer10.isSelected();
		if( Correct_answer10==true)
		{
			String ans10= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('optionB9').value");
			logger.info("selected answer is " + ans10);
			
		}
		else
		{
			logger.info("Selected option is wrong");
		}
		
		Waitfor(2);	
		
	    submit.click();
	        
		
	}
	    public void video_disable_capture()
	    
	    {
	    	

		answer1.click();
		
		 boolean video= orientation_video.isDisplayed();
	    	{
			 if(video==true)
			 {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.getElementById('videoTagId').play()");
	    	}
			 else
	    	{
	    		logger.info("the video is disabled");
	    	}
	    } 
	    }
	    public void clickon_missing_question_question() 
	    {
           submit.click();
        	
           String popup1="Please select an answer for question 1 .";
	    	 String str = popup_text.getText();
	    	 logger.info("the result is  "  +str);
	    	
	    		boolean missing =popup_text.isDisplayed();
	    	if(str.equalsIgnoreCase(popup1))	        
	  {
	    	        	missing_question1.click();
	    	        	Waitfor(1);
	    	        	answer1.click();
	    	        	Waitfor(1);
	    	        	missing_question10.click();
	    	        	Waitfor(1);
	    	        	submit.click();
	  }
	    	   else if(str.equalsIgnoreCase("Please select an answer for question 2 ."))
	    				{

   	        	missing_question2.click();
   	        	Waitfor(1);
   	        	answer2.click();
   	            missing_question10.click();
   	        	Waitfor(1);
   	        	submit.click();
	    	   
	    }
	    	   else if(str.equalsIgnoreCase("Please select an answer for question 3 ."))
				{

      	missing_question3.click();
      	Waitfor(1);
      	answer3.click();
        missing_question10.click();
      	Waitfor(1);
      	submit.click();
	   
}   
	  else if(str.equalsIgnoreCase("Please select an answer for question 4 ."))
				{

     	missing_question4.click();
     	Waitfor(1);
     	answer4.click();
        missing_question10.click();
     	Waitfor(1);
     	submit.click();
	   	
	    }
	    	   else if(str.equalsIgnoreCase("Please select an answer for question 5 ."))
				{

     	missing_question5.click();
     	Waitfor(1);
     	answer5.click();
     missing_question10.click();
     	Waitfor(1);
     	submit.click();
	   
	    } 
	    	   else if(str.equalsIgnoreCase("Please select an answer for question 6 ."))
				{

     	missing_question6.click();
     	Waitfor(1);
     	answer6.click();
     	missing_question10.click();
     	Waitfor(1);
     	submit.click();
	   
				}
	    	   else if(str.equalsIgnoreCase("Please select an answer for question 7 ."))
				{

    	missing_question7.click();
    	Waitfor(1);
    	answer7.click();
    missing_question10.click();
    	Waitfor(1);
    	submit.click();
	   
				}
	    	   else if(str.equalsIgnoreCase("Please select an answer for question 8 ."))
				{

    	missing_question8.click();
    	Waitfor(1);
    	answer8.click();
        missing_question10.click();
    	Waitfor(1);
    	submit.click();
	   
				}
	    	   else if(str.equalsIgnoreCase("Please select an answer for question 9 ."))
				{

   	missing_question9.click();
   	Waitfor(1);
   	answer9.click();
    missing_question10.click();
   	Waitfor(1);
   	submit.click();
	   
				}
	    	   else if(str.equalsIgnoreCase("Please select an answer for question 10 ."))
				{

   	missing_question10.click();
   	Waitfor(1);
   	answer10.click();
    missing_question10.click();
   	Waitfor(1);
   	submit.click();
	   
				}
	    	   else
	    	   {
	    		   logger.info("pop up is not displayed");
	    	   }
	    	
	    }
	    
	
	public void previous_button()
	{
		previous_question.click();
	}
	
	public void check_result()
	{ 
		
		
        String score="Congratulations,You have successfully Completed orientation. Your score is 8.Enjoy working with Diksha.";
      
        String result_get = driver.findElement(By.xpath("//div[contains(@id,'genericModal-body')]")).getText();	
	   logger.info("the result is  "  + result_get);
	    	
		
		
		
		boolean result_= result.isDisplayed();
		
		
		if(result_get.equalsIgnoreCase(score))
				{
		
			logger.info("status of the test is " + result_get);
			logger.info("candidate sucessfully completed the test");
				}
		else if(result_get.contains("Congratulations,You have successfully Completed orientation. Your score is 9.Enjoy working with Diksha."))
		{
		
			logger.info("status of the test is " + result_get);
			logger.info("candidate sucessfully completed the test");
		}
			else if(result_get.equalsIgnoreCase("Congratulations,You have successfully Completed orientation. Your score is 10.Enjoy working with Diksha."))
			{
				
				logger.info("status of the test is " + result_get);
				logger.info("candidate sucessfully completed the test");
			}
				
  else if(result_get.contains("Unfortunately, You couldn't pass this test as minimum score to pass the test is 8/10 .Your score is 7/10.Please take orientation again."))
 						
 					{
                    	
 						logger.info("employee not passed the test");
 					
 							
				}
	}
public int fail_test()
	{
					
		         boolean score =result.isDisplayed();
		 
		     String score_candidate=result.getText();
					//String score_status = driver.findElement(By.xpath("//div[contains(@id,'genericModal-body')]")).getText();	
					//String scorte_test[]=score_status.split(".");
					//String score_candidate=scorte_test[1];
					logger.info("The  :"+score_candidate);
					if(score_candidate.contains("Your score is 1/10."))
						
					{
						close_failre.click();
						 answer_questionnarie_second_attempt();
						 Waitfor(2);
						clickon_missing_question_question();
						check_result();
						test_count++;
					
					}
					else if(score_candidate.contains("Your score is 2/10."))
						
					{
						close_failre.click();
						 answer_questionnarie_second_attempt();
						 Waitfor(2);
						clickon_missing_question_question();
						check_result();
						test_count++;
					
					}
					else if(score_candidate.contains("Your score is 3/10."))
						
					{
						close_failre.click();
						 answer_questionnarie_second_attempt();
						 Waitfor(2);
						clickon_missing_question_question();
						check_result();
						test_count++;
					
					}
                     else if(score_candidate.contains("Your score is 4/10."))
						
					{
                    	 close_failre.click();
                    	 answer_questionnarie_second_attempt();
    					 Waitfor(2);
						clickon_missing_question_question();
						check_result();
						test_count++;
					
					}
                     else if(score_candidate.contains("Your score is 5/10."))
 						
 					{
                    	 close_failre.click();
                    	 answer_questionnarie_second_attempt();
    					 Waitfor(2);
 						clickon_missing_question_question();
 						check_result();
 						test_count++;
 					
 					}
                     else if(score_candidate.contains("Your score is 6/10."))
 						
 					{
                    	 close_failre.click();
                    	 answer_questionnarie_second_attempt();
    					 Waitfor(2);
 						clickon_missing_question_question();
 						check_result();
 						test_count++;
 					
 					}
                     else if(score_candidate.contains("Your score is 7/10."))
 						
 					{
                    	 close_failre.click();
                    	 answer_questionnarie_second_attempt();
    					 Waitfor(2);
 						clickon_missing_question_question();
 						check_result();
 						test_count++;
 					
 					
 					}
					else
					{
						logger.info("the status of the test is "+ score_candidate);
					}
				return test_count;
	}
				
		public void  enable_left_menu_tabs()
	{
		
		String marks = driver.findElement(By.xpath("//div[contains(@id,'genericModal-body')]")).getText();	
		logger.info(marks);
	
		driver.findElement(By.xpath("//button[@id='orientationTestResultPassId']")).click();
		
		Waitfor(2);
		Boolean tabs_enabled = left_menue.isDisplayed();
			if (tabs_enabled== true)
			{
				logger.info("all tabs are enabled");
			}
			else
			
				
					{
						logger.info("tabs should not enable");
					
				
			}
		}	
	
		public void candidate_orientation_under_RMG(String emp_ID, String status)
		{
			RMGModule.click();
			Waitfor(1);
			employeeModule.click();
			
				Waitfor(5);
				Employees_SearchInput.sendKeys(Keys.chord(Keys.CONTROL, "a"),emp_ID);
				Waitfor(1);
				Actions action = new Actions(driver);
				Waitfor(1);
				
				 String sta= driver.findElement(By.xpath(".//*[@id='employee_home']/tbody/tr/td[9]")).getText();
				 Waitfor(2);
				 driver.findElement(By.xpath(".//*[@id='employee_home']/tbody/tr/td[1]")).click();
				 Waitfor(1);
				 logger.info(sta);
				 
								// Edit button validation
								boolean history_status = orientatioan_history.isDisplayed();
									if (history_status == true) 
									{
										orientatioan_history.click();
										logger.info("orientation history Tab is displayed under RMG page and status is :" + history_status);
										Waitfor(2);
										
									}
		}
									

		
		public void candidate_Attempts()
		{
		
				WebElement table = driver.findElement(By.xpath("//table[@id='orientationTestHistory_table']"));
				List<WebElement> rows = table.findElements(By.xpath("//table[@id='orientationTestHistory_table']/tbody/tr"));
				logger.info("NUMBER OF rows="+rows.size());
						
				int row_num,col_num;
		        row_num=0;
		        for(WebElement trElement : rows)
		        {
		            List<WebElement> coloumn=trElement.findElements(By.xpath("//table[@id='orientationTestHistory_table']/tbody/tr/td[1]"));
		            logger.info("Number of attempts is="+coloumn.size());
		        
		            

		            	logger.info("candidate attempt  count is  " + rows.size());
		            }
		  
		        close_orientation_history.click();
		    }
		
		
	//profile status//					
	       
			
		public void percentage_capture()
		{
		
			  boolean General_info_tab= percentage_gen.isDisplayed(); 
		      if(General_info_tab==true)
		      {
			String exp_generaltab_per = "5%";
			
			String act_generaltab_per= percentage_gen.getText();
		
			if(act_generaltab_per.equalsIgnoreCase(exp_generaltab_per))
			{
			logger.info("general info tab saved Successfully");
			logger.info("The current percentage is " + act_generaltab_per);

		      }
		      else
		      {
		    	  logger.info("percentage is not displayed");
		      }
			
		      }
		}
		public void personal_info_tab_captrue()
		{

			boolean save_personal_tab= Personalinfo_Savebutton.isDisplayed();

			if(save_personal_tab==true)
			{
				Personalinfo_Savebutton.click();
				Waitfor(2);	
				 ObjectInitClass.EOB.Scroll_Up();
			String exp_generaltab_per = "5%";
			
			String exp_personal_per =	exp_generaltab_per + "12%";

			String act_personal_per= percentage_per.getText();
	
			if(act_personal_per.equalsIgnoreCase(exp_personal_per))
			{
			logger.info("personal info tab saved Successfully");
			logger.info("The current percentage is " + act_personal_per);

		}
			 else
		     {
		   	  logger.info("percentage is not incresed");
		     }	
		}
		}

		public void nominee_info_tab_captrue()
		{

			boolean save_nominee_tab= Nomineeinfo_Savebutton.isDisplayed();

			if(save_nominee_tab==true)
			{
			Nomineeinfo_Savebutton.click();
			Waitfor(2);
			 ObjectInitClass.EOB.Scroll_Up();
			String exp_nominee_per = "27%";
		
			
			String act_nominee_per= percentage_nominee.getText();
				
			if(act_nominee_per.equalsIgnoreCase(exp_nominee_per))
			{
			logger.info("nominee info tab saved Successfully");
			logger.info("The current percentage is " + act_nominee_per);

			
		}
			 else
		     {
		   	  logger.info("percentage is not incresed" );
		     }	
		}
		}
		public void  financial_info_tab_captrue()
		{
			boolean save_financila_tab= Financeinfo_Savebutton.isDisplayed();
			
			if(save_financila_tab==true)
			{
				Financeinfo_Savebutton.click();
				Waitfor(2);	
				 ObjectInitClass.EOB.Scroll_Up();
			String exp_financila_per = "44%";
	
			String act_financila_per= percentage_financial.getText();
		
			
			if(act_financila_per.equalsIgnoreCase(exp_financila_per))
			{	
			logger.info("financila info tab saved Successfully");
			logger.info("The current percentage is " + act_financila_per);
				}
			 else
		     {
		   	  logger.info("percentage is not incresed" );
		     }	
		}
		}
		public void  passport_info_tab_captrue()
		{
			boolean save_passport_tab= Passportinfo_Savebutton.isDisplayed();
			
			if(save_passport_tab==true)
			{
				Passportinfo_Savebutton.click();
				Waitfor(2);	
				 ObjectInitClass.EOB.Scroll_Up();
			String exp_passport_per = "55%";
	
			String act_passport_per= percentage_passport.getText();
			
		
			if(act_passport_per.equalsIgnoreCase(exp_passport_per))
			{
			logger.info("passport info tab saved Successfully");
			logger.info("The current percentage is " + act_passport_per);
			
			
		}
			 else
		     {
		   	  logger.info("percentage is not incresed" );
		     }	
		}
		}
		public void  educational_info_tab_captrue()
		{
			boolean save_educational_tab= Educationinfo_Savebutton.isDisplayed();
			
			if(save_educational_tab==true)
			{
				Educationinfo_Savebutton.click();
				Waitfor(2);	
				 ObjectInitClass.EOB.Scroll_Up();
			String exp_educational_per = "71%";
		
			String act_educational_per= percentage_edu.getText();			
			if(act_educational_per.equalsIgnoreCase(exp_educational_per))
			logger.info("Educational info tab saved Successfully");
			logger.info("The current percentage is " + act_educational_per);
			
			
		}
			 else
		     {
		   	  logger.info("percentage is not incresed" );
		     }	
		}
		public void  experience_info_tab_captrue()
		{
			
			boolean save_experience_tab= Experienceinfo_Savebutton.isDisplayed();
			
			if(save_experience_tab==true)
			{
				Experienceinfo_Savebutton.click();
				Waitfor(2);	
			Scroll_Up();
			Waitfor(2);
			Scroll_Up();
			String exp_experience_per = "88%";
				
			logger.info("");
			String act_experience_per= percentage_exp.getAttribute("style");
			
			if(act_experience_per.equalsIgnoreCase(exp_experience_per))
			{
			logger.info("experience info tab saved Successfully");
			logger.info("The current percentage is " + act_experience_per);

			
		}
			 else
		     {
		   	  logger.info("percentage is not incresed" );
		     }	
		}
			
		}
		 
		public void  skill_info_tab_captrue()
		{
		driver.findElement(By.xpath("//button[@id='saveSkillsCandId']")).click();
			Waitfor(2);
			boolean save_skill_tab=driver.findElement(By.xpath("//button[@id='candSubmitCandidate']")).isDisplayed();
			if(save_skill_tab==true)
			{
				driver.findElement(By.xpath("//button[@id='candSubmitCandidate']")).click();
				Waitfor(2);	
				 ObjectInitClass.EOB.Scroll_Up();
			String exp_skill_per = "100%";
		
			logger.info("");
			String act_skill_per= percentage_skill.getText();
			
			if(act_skill_per.equalsIgnoreCase(exp_skill_per))
			{	
			logger.info("skill info tab saved Successfully");
			logger.info("The current percentage is " + act_skill_per);

			
		}
			 else
		     {
		   	  logger.info("percentage is not incresed" );
		     }	
		}
		}
		public void  skill_info_tab_captrue_rmg()
		{
			
			boolean save_skill_tab =Skillsinfo_Savebutton.isDisplayed();
			
			if(save_skill_tab==true)
			{
				Skillsinfo_Savebutton.click();
				 ObjectInitClass.EOB.Scroll_Up();
				Waitfor(2);
				Scroll_Up();
				Waitfor(2);
				Scroll_Up();
			String exp_skill_per = "100%";
		
			logger.info("");
			String act_skill_per= percentage_skill.getText();
			
			if(act_skill_per.equalsIgnoreCase(exp_skill_per))
			{	
			logger.info("skill info tab saved Successfully");
			logger.info("The current percentage is " + act_skill_per);

			
		}
			 else
		     {
		   	  logger.info("percentage is not incresed" );
		     }	
		}
		 
		}
	

		public void decresed_percentage()
		{

			boolean remove_uploads=RejectBankDetails_Button.isDisplayed();
			
			if(remove_uploads== true)
				{
				RejectBankDetails_Button.click();
				Waitfor(2);
				driver.findElement(By.xpath("//textarea[@id='candAadharRejCom']")).sendKeys("rejected");
				Waitfor(2);
				driver.findElement(By.xpath("//button[@id='candEduReject']")).click();
				Waitfor(2);
				Educationinfo_Savebutton.click();
				Waitfor(2);	
		        Scroll_Up();	
			String exp_decreased_per = "97%";
			
			String act_decreased_per = percentage_exp.getText();
			
			if(act_decreased_per.equalsIgnoreCase(exp_decreased_per))
				
			logger.info("documents are rejected  Successfully");
			logger.info("The current percentage is " + act_decreased_per);
						
		}
			else
			{
				logger.info("percentage is not decresed");
			}
		}


	public void Click_MylynxTab()
	{
		MYLynx_Module.click();
		Waitfor(2);
	}
	public void Click_CandidateTab()
	{		
		Candidate_Submodule.click();
		Waitfor(9);
	}
	public void ClickNewCand_Button()
	{
		
		NewCandidate_Button.click();
		Waitfor(3);
	}
//end 
	public void Click_CandidateSubmit_Button()
	{
		/*((JavascriptExecutor) driver).executeScript("scroll(0, -500)", "");		
		Candidate_Generalinfotab.click();
		Waitfor(2);*/
		Candidate_Submit_Button.click();
		Waitfor(2);
	}
	public void click_candGeneralinfo_tab()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("window.scrollBy(0,-600)");
	}
	
		
		public void orientationlink()
		{
		   
		     driver.findElement(By.xpath("//button[@id='offerLinkId']")).click();  
		}
		public void failure_again_test()
		{
		 boolean score =result.isDisplayed();
		 String score_candidate=result.getText();
		if(score_candidate.contains("Your score is 7/10."))
					{
	        	Waitfor(2);
	            driver.findElement(By.xpath(".//*[@id='genericModal-size']/div/div[1]/button")).click();
	            Waitfor(2);
	            answer_questionnarie_second_attempt();
				Waitfor(2);
				clickon_missing_question_question();
				Waitfor(2);
				check_result();
				Waitfor(2);
	    }
		if(score_candidate.contains("Your score is 6/10."))	
			   {
	           Waitfor(2);
	           driver.findElement(By.xpath(".//*[@id='genericModal-size']/div/div[1]/button")).click();
	           Waitfor(2);
	           answer_questionnarie_second_attempt();
			   Waitfor(2);
			   clickon_missing_question_question();
			   Waitfor(2);
			   check_result();
			   Waitfor(2);				
		}
		if(score_candidate.contains("Your score is 5/10."))
				{
	         Waitfor(2);
	        driver.findElement(By.xpath(".//*[@id='genericModal-size']/div/div[1]/button")).click();
	        Waitfor(2);
	        answer_questionnarie_second_attempt();
			Waitfor(2);
			clickon_missing_question_question();
			Waitfor(2);
			check_result();
			Waitfor(2);							
		}
			if(score_candidate.contains("Your score is 4/10."))
				
			{
	    	
	   	     Waitfor(2);
	        driver.findElement(By.xpath(".//*[@id='genericModal-size']/div/div[1]/button")).click();
	        Waitfor(2);
	        answer_questionnarie_second_attempt();
			Waitfor(2);
			clickon_missing_question_question();
			Waitfor(2);
			check_result();
			 Waitfor(2);				
		}
			if(score_candidate.contains("Your score is 3/10."))
				
		{
	    	

	        	 Waitfor(2);
	        	 driver.findElement(By.xpath(".//*[@id='genericModal-size']/div/div[1]/button")).click();
	        	 Waitfor(2);
	        	 answer_questionnarie_second_attempt();
				 Waitfor(2);
				 clickon_missing_question_question();
				 Waitfor(2);
				check_result();
				Waitfor(2);
	}
			if(score_candidate.contains("Your score is 2/10."))		
			{
	        	 Waitfor(2);
	        	 driver.findElement(By.xpath(".//*[@id='genericModal-size']/div/div[1]/button")).click();
	        	 Waitfor(2);
	        	 answer_questionnarie_second_attempt();
				Waitfor(2);
				clickon_missing_question_question();
				Waitfor(2);
				check_result();
				Waitfor(2);					
		}
			
	      if(score_candidate.contains("Your score is 1/10."))
				
	{
	        	 Waitfor(2);
	        	 driver.findElement(By.xpath(".//*[@id='genericModal-size']/div/div[1]/button")).click();
	        	 Waitfor(2);
	        	 answer_questionnarie_second_attempt();
				 Waitfor(2);
				 clickon_missing_question_question();
				 Waitfor(2);
				 check_result();
				 Waitfor(2);				
		}
		}
			
		public void answer_questionnarie_second_attempt()
		{
			
		String question1= questionnarie1.getText();
		logger.info(question1);
		//answer1.click();
		//Waitfor(2);	
		Boolean	Correct_answer1= answer1.isSelected();
		if( Correct_answer1==true)
		{
		String ans1= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('optionB0').value");
	    logger.info("selected answer is" +ans1 );
		logger.info("Answer is correct");
		}
		else
		{
		logger.info("Selected option is wrong");
		}
		next_question1.click();
		Waitfor(2);	
		String question2=questionnarie2.getText(); 
		logger.info(question2);
		answer2.click();
		//wrong_answer2.click();
		Waitfor(2);	
		Boolean	 Correct_answer2= answer2.isSelected();
		if( Correct_answer2==true)
		{
			String ans2= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('optionA1').value");
			logger.info("selected answer is" + ans2 );
			logger.info("Answer is correct");
		}
			else
			{
				logger.info("Selected option is wrong");
			}
			Waitfor(2);	
			next_question2.click();
			Waitfor(2);	
			String question3 =  questionnarie3.getText();
	      	logger.info(question3); 	
	        answer3.click();
	     	//wrong_answer3.click();
	    	Waitfor(2);	
			Boolean	 Correct_answer3= answer3.isSelected();
			if( Correct_answer3==true)
			{
			    String ans3=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('optionC2').value");
				logger.info("selected answer is" + ans3 );
				logger.info("Answer is correct");
			}
			else
			{
				logger.info("Selected option is wrong");
			}
			next_question3.click();
			Waitfor(2);	
			String question4  = questionnarie4.getText();
		 	logger.info(question4);
			answer4.click();
			Waitfor(2);	
	        Boolean	 Correct_answer4= answer4.isSelected();
			if( Correct_answer4==true)
			{
				String ans4=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('optionD3').value");
				logger.info("selected answer is" + ans4 );
				logger.info("Answer is correct");
			}
			else
			{
				logger.info("Selected option is wrong");
			}
			next_question4.click();
			Waitfor(2);	
			String question5  = questionnarie5.getText();
			logger.info(question5);
			answer5.click();
			Waitfor(2);	
			
	       Boolean	Correct_answer5= answer5.isSelected();
			
			if( Correct_answer5==true)
			{
				String ans5= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('optionA4').value");
				logger.info("selected answer is" + ans5 );
				logger.info("Answer is correct");
			}
			else
			{
				logger.info("Selected option is wrong");
			}
			next_question5.click();
			Waitfor(2);	
			String question6 = questionnarie6.getText();
			logger.info(question6);
			answer6.click();
			Waitfor(2);	
	        Boolean	Correct_answer6= answer6.isSelected();
			if( Correct_answer6==true)
			{
				String ans6=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('optionB5').value");
				logger.info("selected answer is" + ans6 );
				logger.info("Answer is correct");
			}
			else
			{
				logger.info("Selected option is wrong");
			}
			next_question6.click();
			Waitfor(2);		
			String question7 = questionnarie7.getText();
			logger.info(question7);
			answer7.click();
			Waitfor(2);
			
	        Boolean Correct_answer7= answer7.isSelected();
			if( Correct_answer7==true)
			{
				String ans7=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('optionA6').value");
				logger.info("selected answer is" + ans7 );
				logger.info("Answer is correct");
			}
			else
			{
				logger.info("Selected option is wrong");
			}
			next_question7.click();
			Waitfor(2);	
			String question8 = questionnarie8.getText();
			logger.info(question8);
			answer8.click();
			Waitfor(2);	
	        Boolean Correct_answer8= answer8.isSelected();
			if( Correct_answer8==true)
			{
				String ans8= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('optionB7').value");
				logger.info("selected answer is" + ans8 );
				logger.info("Answer is correct");
			}
			else
			{
			    logger.info("Selected option is wrong");
			}
			next_question8.click();
			Waitfor(2);
			String question9 =   questionnarie9.getText();
			logger.info(question9);
			answer9.click();
			Waitfor(2);	
	        Boolean Correct_answer9=answer9.isSelected();
			if( Correct_answer9==true)
			{
				String ans9=(String)((JavascriptExecutor) driver).executeScript("return document.getElementById('optionB8').value");
				logger.info("selected answer is" + ans9);
				logger.info("Answer is correct");
			}
			else
			{
				logger.info("Selected option is wrong");
			}
			next_question9.click();
			Waitfor(2);	
			String question10= questionnarie10.getText();
			logger.info(question10);
			answer10.click();
			Waitfor(2);	
	        Boolean Correct_answer10=  answer10.isSelected();
			if( Correct_answer10==true)
			{
				String ans10= (String)((JavascriptExecutor) driver).executeScript("return document.getElementById('optionB9').value");
				logger.info("selected answer is" + ans10);
				logger.info("Answer is correct");
			}
			else
			{
			    logger.info("Selected option is wrong");
			}
			Waitfor(2);	
			submit.click();
	}  

		    public void Add_Financeinfo_tab(String CTC_Current, String Primary_BankName,String Primary_Account, String IFSCCODE)
		    {
				Current_CTC.sendKeys(CTC_Current);
				Waitfor(3);
				driver.findElement(By.xpath("//input[@id='cand_fin_aadhar']")).sendKeys("12345678");;
				Cand_Aadhar_upload.click();
				boolean status= Cand_Aadhar_browse.isDisplayed();
				if(status==false)
				{
					Cand_Aadhar_browse.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
				}
				else
				{
					logger.info("Upload Button is not enabled");
				}
				Cand_Aadhar_comments.sendKeys("Aadhar card uploaded");
			    Waitfor(1);
			    Cand_Aadhar_uploadingbutton.click();
			    Waitfor(1);
			    cand_PAN_upload_document();

				WebElement Retentionbonus_checkboxelement = driver.findElement(By.xpath(".//*[@id='cand_oldStackupFields']/div/div[1]/div[2]/label/span"));
				if (!Retentionbonus_checkboxelement.isSelected())
				{
					Retentionbonus_checkboxelement.click();
				}
				CandPrimary_BankName.sendKeys(Primary_BankName);
				Waitfor(1);
				CandPrimary_Acno.sendKeys(Primary_Account);
				Waitfor(1);
				CandPrimary_IFSCcode.sendKeys(IFSCCODE);
				Waitfor(1);		
				boolean EmpActiveStatus = Employee_Active_radiobutton.isDisplayed();
				if(EmpActiveStatus==true)
				{
				Employee_Active_radiobutton.click();
				}
				else
				{
				logger.info("Employee Active radio button is already selected");
				}
		    }
			 public void orientation_login()
		
			 {	 
				  ObjectInitClass.HP.Log_Out();
				      Waitfor(1);
				 
					// Read Excel object creation to pass the sheet parameter.
					String username= usnLynx; 
					Waitfor(1);
					String password= "Lynx"; 
					Waitfor(1);
					 ObjectInitClass.LP.signIn(username, password);
					Waitfor(4);
					 ObjectInitClass.EOB.get_acc_Hldr_Name();
					
			 }
					public String candidate_statusbar_login(String emp_ID, String status)
					{
						
						MYLynx_Module.click();
						Waitfor(1);
						Candidate_Submodule.click();
						
							Waitfor(3);
							Search_Table_InputBox.sendKeys(Keys.chord(Keys.CONTROL, "a"),emp_ID);
							Waitfor(1);
						
							Actions action = new Actions(driver);
							int count = 0;
							String fail= "";
							String col_text = "Candidate ID";
							List<WebElement> page = driver.findElements(By.xpath("//div[@id='candidate_home_paginate']/span/a"));
							if (page.size() > 0) {
							for (int i = 1; i <=page.size(); i++) 
							{
								if(i>1)
								{	
								driver.findElement(By.xpath("//div[@id='candidate_home_paginate']/span/a[" + (i) + "]")).click();
								Waitfor(1);
								}
							WebElement table = driver.findElement(By.xpath("//table[@id='candidate_home']/thead/tr"));
							List<WebElement> heading = table.findElements(By.tagName("th"));
							for (int h = 0; h < heading.size(); h++) {
								String text = heading.get(h).getText();
								if (col_text.equalsIgnoreCase(text)) {
									int col = h;
									WebElement row_table = driver.findElement(By.xpath("//table[@id='candidate_home']/tbody"));
									List<WebElement> rows = row_table.findElements(By.tagName("tr"));
									logger.info(rows.size());
									for (int c = 1; c <= rows.size(); c++) {
										
										String cell_Value = driver
												.findElement(By.xpath("//table[@id='candidate_home']/tbody/tr[" + c + "]/td[" + (col+1) + "]"))
												.getText();
										Waitfor(2);
										String array[] = { "Candidate Created", "Approved", "Rejected", "Completed", "Submitted" };
										
										if (cell_Value.equalsIgnoreCase(emp_ID)) {
											
											WebElement report= driver.findElement(By.xpath("//table[@id='candidate_home']/tbody/tr[" + c + "]/td[1]"));
											action.click(report).build().perform();
											Waitfor(2);
											String  s= driver.findElement(By.xpath("//table[@id='candidate_home']/tbody/tr[" + c + "]/td[5]")).getText();
											if(s.equalsIgnoreCase(status))
											{
											logger.info("Status is matching with the passed status & Status is "+s);
											action.click(report).build().perform();
											Waitfor(2);
								// Edit button validation
								boolean editbutton= EditCandidate_Button.isDisplayed();
								if (editbutton == true) 
								{
							
								logger.info(" edit button is displayed under RMG page and status is :" + editbutton);
								Waitfor(2);						
								}
								else
								{
								logger.info("edit button is not present in candidate page and status is :" + editbutton);
								}
								logger.info("The Candidate status is "+status);
								count++;
								break;
								}
								else 
								{
								logger.info("Status passed is not matching & the status is : "+s);
								}
								}
								else 
								{
								logger.info("There is no record matched with the passed Status & Emp-ID found in Candidate table..!!");
							   fail = "No Match found";	
								}

								}
							    }
								if(count>0)
								{
							    break;
								}
								}
								if(count>0)
								{
								 break;
								}
								}
								}
								return fail;
								}
					
					
				public void candidate_submit_button()	
				{
					photo_uplaod.click();
					Waitfor(2);	
					Cand_Aadhar_browse.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
					Waitfor(2);	
					driver.findElement(By.xpath("//button[@id='picuploadonboard']")).click();
					Waitfor(2);	
					 Scroll_down();
					driver.findElement(By.xpath("//button[@name='candNextName']")).click();
					Waitfor(2);	
				}
					
					
				
//end orientation//
				
	public void clickandsubmit_candgeneralinfotab()
	{
		((JavascriptExecutor) driver).executeScript("scroll(0, -500)", "");		
		Candidate_Generalinfotab.click();
		Waitfor(2);
	}
	
	public void EnterCand_Details (String Company_Name, String Region_Name,String Location_Name, String Department_Name,String Category_Name, String Level_Name, 
			 String Reporting_ManagerName,String SPOCNAME,String Project_Name, String Emp_Firstname,
			String Emp_Lastname, int DOB_Date, String PersonalMailID, int DOJ_Date,String NoticePeriod, String Role) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		
		
	//Candidate Department Details
		
		
	    //verifying user navigated to the New candidate page
		String NewCandidatePageTitle = NewCandidatepage_Title.getText();
		Assert.assertEquals("New Candidate", NewCandidatePageTitle);
		logger.info("Landing Page Title is"+ NewCandidatePageTitle);
				
		//Verifying Department Details section
				
		/*String  DepartmentDetailsSection = DepartmentDetails_Sectiontext.getText();
		Assert.assertEquals("Department Details", DepartmentDetailsSection);
		logger.info("NEw candidate page First section is"+DepartmentDetailsSection);
				*/
		//Verifying the Company drop down is mandatory field
				
		/*String Mand_Company = Company_Mandatory.getText();
		Assert.assertEquals("Company:∗", Mand_Company);
		logger.info(Mand_Company+ "is a Mandatory Field");
				*/
		// verifying Company drop down with default text and options
				
		/*Assert.assertEquals("Select Company", Company_Dropdown.getText());
		Select select = new Select(driver.findElement(By.xpath("//select[@id='ddladult1']")));
		//List Company_li = Company_Dropdown.
*/				
		Select CompanyDD = new Select(Company_Dropdown);		
		Waitfor(1);	
		CompanyDD.selectByVisibleText(Company_Name);		
		logger.info("The Selected Company is" +Company_Name);
		
		//Verifying the Region drop down is mandatory field
		String Mand_Region = Region_Mandatory.getText();
		Assert.assertEquals("Region:∗", Mand_Region);
		logger.info( Mand_Region + "is a Mandatory Field");
		
		Select RegionDD = new Select(Region_Dropdown);		
		Waitfor(1);	
		RegionDD.selectByVisibleText(Region_Name);
		logger.info("The Selected Region is "+Region_Name);
		
		//Verifying the Location drop down is mandatory field
		String Mand_Location = Location_Mandatory.getText();
		//Assert.assertEquals("Location:∗", Mand_Location);
		logger.info( Mand_Location + "is a Mandatory Field");
		
		Select LocationDD = new Select(Location_Dropdown);
		Waitfor(1);	
		LocationDD.selectByVisibleText(Location_Name);
		logger.info("The Selected Location Name is "+Location_Name);
		
		//Verifying the Department drop down is mandatory field
		String Mand_Department = Department_Mandatory.getText();
		Assert.assertEquals("Department:∗", Mand_Department);
		logger.info(Mand_Department + "is a Mandatory Field");
				
		Select DepartmentDD = new Select(Department_Dropdown);
		Waitfor(1);	
		DepartmentDD.selectByVisibleText(Department_Name);
		logger.info("The Selected Department Name is "+Location_Name);
		
		//Verifying the Category drop down is mandatory field
		String Mand_Category = Category_Mandatory.getText();
		Assert.assertEquals("Category:∗", Mand_Category);
		logger.info(Mand_Category + "is a Mandatory Field");
				
		Select CategoryDD = new Select(Category_Dropdwon);
		Waitfor(1);	
		CategoryDD.selectByVisibleText(Category_Name);
		logger.info("The Selected Category is "+Category_Name);
		
		//Verifying the Level drop down is mandatory field
		String Mand_Level = Level_Mandatory.getText();
		Assert.assertEquals("Level:∗", Mand_Level);
		logger.info(Mand_Level + "is a Mandatory Field");
				
		Select LevelDD = new Select(Level_Dropdown);
		Waitfor(1);	
		LevelDD.selectByVisibleText(Level_Name);
		logger.info("The Selected Level is "+Level_Name);
		
		//Verifying the Designation drop down is mandatory field
		String Mand_Designation = Designation_Mandatory.getText();
		Assert.assertEquals("Designation:∗", Mand_Designation);
		logger.info(Mand_Designation + "is a Mandatory Field");
				
		/*Select DesignationDD = new Select(Designation_Dropdown);
		Waitfor(1);	
		DesignationDD.selectByVisibleText(Designation);
		logger.info("The Selected Designation is "+Designation);*/
		
		//Verifying the Reporting Manager drop down is mandatory field
		String Mand_ReportingManager = ReportingManager_Mandatory.getText();
		Assert.assertEquals("Reporting Manager:∗", Mand_ReportingManager);
		logger.info(Mand_ReportingManager + "is a Mandatory Field");
		
		Select ReporetingManagerDD = new Select(Reportingmanager_Dropdown);
		Waitfor(1);	
		ReporetingManagerDD.selectByVisibleText("Vinod K P (200)");
		logger.info("The Selected Reporting Manager is "+Reporting_ManagerName);
		
		Select SPOCDD = new Select(SPOC_Dropdown);
		Waitfor(1);	
		SPOCDD.selectByVisibleText(SPOCNAME);
		logger.info("The Selected SPOC is "+SPOCNAME);
		
		
		/*//Verifying the Project drop down is mandatory field
		String Mand_Project = Project_Mandatory.getText();
		Assert.assertEquals("Project:∗", Mand_Project);
		logger.info(Mand_Project + "is a Mandatory Field");*/
		
		boolean ProjectSelected = Project_Dropdown.isDisplayed();
				
		if (ProjectSelected==false)
		{
			String projectname = Project_Dropdown.getText();
			logger.info("Selected Project Name is "+projectname);
		}
		else
		{
		Select ProjectDD = new Select(Project_Dropdown);
		Waitfor(1);	
		ProjectDD.selectByVisibleText(Project_Name);
		logger.info("The Selected Project Name is "+Project_Name);
		}
		//Verifying Candidate FirstName Mandatory field		
		String Mand_FirstName = FirstName_Mandatory.getText();
		Assert.assertEquals("First Name:∗", Mand_FirstName);
		logger.info(Mand_FirstName + "is a Mandatory Field");
		
		Employee_FirstName.sendKeys(Emp_Firstname);
		logger.info("Candidate First Name is "+Emp_Firstname);
		
		//Verifying Candidate LastName Mandatory field		
		String Mand_LastName = LastName_Mandatory.getText();
		Assert.assertEquals("Last Name:∗", Mand_LastName);
		logger.info(Mand_LastName + "is a Mandatory Field");
				
		Employee_LastName.sendKeys(Emp_Lastname);
		logger.info("Candidate Last Name is"+Emp_Lastname);
		Waitfor(2);
		
		//Verifying Candidate Nationality Mandatory field		
		String Mand_Nationality = Nationality_Mandatory.getText();
		Assert.assertEquals("Nationality:∗", Mand_Nationality);
		logger.info(Mand_Nationality + "is a Mandatory Field");
		
		/*Nationality.sendKeys(Keys.chord(Keys.CONTROL, "a"),Nationality_Name);
		System.err.println("The Nationality is : "+Nationality_Name);*/
		
		//Verifying Candidate Gender Mandatory field		
		String Mand_Gender = Gender_Mandatory.getText();
		Assert.assertEquals("Gender:∗", Mand_Gender);
		logger.info(Mand_Gender + "is a Mandatory Field");
				
		//boolean status = Gender_Male_Radio_button.isDisplayed();
		//if(status==false)
		{
			Gender_Male_Radio_button.click();
		}
		//else
		{
			logger.info("Gender male is already selected");
		}
				
		//Verifying Candidate DOB Mandatory field		
		String Mand_DOB = DateofBirth_Mandatory.getText();
		Assert.assertEquals("Date of Birth:∗", Mand_DOB);
		logger.info(Mand_DOB + "is a Mandatory Field");
				
		//Selecting Employee Date of birth(TO-DO)
		
		DateofBirth.click();		
		List<WebElement> DOBdates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

		int total_dobnodes = DOBdates.size();
		logger.info("Calendar Date size is : " + total_dobnodes);
		for (int i = 0; i < total_dobnodes; i++) {
			String dobdate = DOBdates.get(i).getText();
			if (dobdate.equals(Integer.toString(DOB_Date))) {
				DOBdates.get(i).click();
				logger.info("Selected date is: " + dobdate);
				break;

			}
		}
		Waitfor(2);				
		/*//Verifying Candidate Personal Mandatory field		
		String Mand_PerEmailId = CandidateEmailID_Mandatory.getText();
		Assert.assertEquals("Candidate Email ID:∗", Mand_PerEmailId);
		logger.info(Mand_PerEmailId + "is a Mandatory Field");*/
		
		boolean CandmailSelected = CandidatePersonal_Emailid.isDisplayed();
		
		if (CandmailSelected==false)
		{
			String candmailid = CandidatePersonal_Emailid.getText();
			logger.info("Candidate mail already is "+candmailid);
		}
		else
		{
		
		CandidatePersonal_Emailid.sendKeys(PersonalMailID);
		Waitfor(2);
		}
		/*
		//Verifying Candidate DOJ Mandatory field		
		String Mand_DOJ = DateOfJoining_Mandatory.getText();
		Assert.assertEquals("Date Of Joining:∗", Mand_DOJ);
		logger.info(Mand_DOJ + "is a Mandatory Field");
				*/
		//Selecting Employee Date of Joining(TO-DO)
		
		Dateof_Joining.click();		
		List<WebElement> DOJdates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

		int total_dojnodes = DOJdates.size();
		logger.info("Calendar Date size is : " + total_dojnodes);
		for (int i = 0; i < total_dojnodes; i++) {
			String dojdate = DOJdates.get(i).getText();
			if (dojdate.equals(Integer.toString(DOJ_Date))) {
				DOJdates.get(i).click();
				logger.info("Selected date is: " + dojdate);
				break;

			}
		}

		Waitfor(2);	

		/*//Verifying Candidate Notice Period Mandatory field		
		String Mand_Noticeperiod = Noticeperiod_Mandatory.getText();
		Assert.assertEquals("Notice period:∗", Mand_Noticeperiod);
		logger.info(Mand_Noticeperiod + "is a Mandatory Field");
*/
		Notice_Period.sendKeys(NoticePeriod);
		logger.info("Candidate Notice Period is "+NoticePeriod);
		
		/*//Verifying Candidate Candidate type Mandatory field		
		String Mand_Candtype = EmployeeType_Mandatory.getText();
		Assert.assertEquals("Employment Type:∗", Mand_Candtype);
		logger.info(Mand_Candtype + "is a Mandatory Field");*/
		
		/*Select EmptypeDD = new Select(Employmenttype_Dropdown);		
		Waitfor(1);	
		EmptypeDD.selectByVisibleText(Employment_Type);
		logger.info("The Selected Employee Type is "+Employment_Type);
		*/
/*
		//Verifying Candidate Role Mandatory field		
		String Mand_Role = Role_Mandatory.getText();
		Assert.assertEquals("Role:∗", Mand_Role);
		logger.info(Mand_Role + "is a Mandatory Field");*/
			
		Select RoleDD = new Select(Role_Dropdown);			
		Waitfor(1);	
		RoleDD.selectByVisibleText(Role);
		logger.info("The Selected Role is "+Role);
	}
	
	public void submit_Candidate()
	{
		Save_Candidate.click();
		Waitfor(9);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -350)", "");
		Waitfor(3);
		/*Cand_Backbutton.click();
		Waitfor(3);*/
		/*String  exp_msg = "General Info Saved/Updated Successfully";
		String act_msg = Candsave_Confirmationmsg.getText();
		logger.info("Confirmation message is: "+act_msg);
		
	if(exp_msg == act_msg)
	{
		logger.info("Candidate saved successfully ");
    }
	else
	{
		logger.info("Candidate is not saved successfully");
	}*/
		/*((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -250)", "");
		Waitfor(3);
		Cand_Backbutton.click();
		Waitfor(3);*/
		
		
	}
	public void Submit_Candidate()
	{
		Submit_Candidate.click();
		Waitfor(2);
	}
	public void Edit_Candidate()
	
	{
		boolean status=EditCandidate_Button.isEnabled();
		if(status==true)
		{		
			EditCandidate_Button.click();
			Waitfor(5);
		}else
		{
			logger.info("Edit button is not enabled ");
		}
		
	}
	
	public void UpdateCand_Prof()
	{
		CandUpdatebutton.click();
		Waitfor(2);
	}
	public void click_Candfinanceinfotab()
	{
		Financialinfo_Tab.click();
		Waitfor(3);
		
	}


	public void Add_Financeinfo(String CTC_Current,String QPLB_Amount, String Per_qplb, String Per_aplb, String Primary_BankName,String Primary_Account, String IFSCCODE)
	{
		
		
		//Candidate Financial Information
		
		
		/*
		boolean Saloldstatus = Salary_Old_Radio_button.isEnabled();
		if(Saloldstatus==false)
		{
			Salary_Old_Radio_button.click();
		}
		else
		{
			logger.info("Salary Old Stackup is already selected");
		}
		boolean Salnewstatus = Salary_New_Radio_button.isEnabled();
		if(Salnewstatus==false)
		{
			Salary_New_Radio_button.click();
		}
		else
		{
			logger.info("Salary New stackup is already selected");
		}*/
		Current_CTC.sendKeys(CTC_Current);
		Waitfor(3);
		Candidate_QPLB.sendKeys(QPLB_Amount);
		Waitfor(1);
		//date
		//QPLB_EffDate
		/*QPLB_Perc.sendKeys(Per_qplb);
		Waitfor(1);
		APLB_Perc.sendKeys(Per_aplb);
		Waitfor(1);*/
		WebElement Retentionbonus_checkboxelement = driver.findElement(By.xpath(".//*[@id='cand_oldStackupFields']/div/div[1]/div[2]/label/span"));
		if (!Retentionbonus_checkboxelement.isSelected())
		{
			Retentionbonus_checkboxelement.click();
		}
		CandPrimary_BankName.sendKeys(Primary_BankName);
		Waitfor(1);
		CandPrimary_Acno.sendKeys(Primary_Account);
		Waitfor(1);
		CandPrimary_IFSCcode.sendKeys(IFSCCODE);
		Waitfor(1);		
		
		boolean EmpActiveStatus = Employee_Active_radiobutton.isEnabled();
		if(EmpActiveStatus==false)
		{
			Employee_Active_radiobutton.click();
		}
		else
		{
			logger.info("Employee Active radio button is already selected");
		}
			
		
	}
	public void RMG_fillFinance_data(String CTC_Current,String QPLB_Amount)
	{
		Current_CTC.sendKeys(Keys.chord(Keys.CONTROL, "a"),CTC_Current);
		Waitfor(2);
		Candidate_QPLB.sendKeys(QPLB_Amount);
		Waitfor(1);
		WebElement Retentionbonus_checkboxelement = driver.findElement(By.xpath(".//*[@id='cand_oldStackupFields']/div/div[1]/div[2]/label/span"));
		if (!Retentionbonus_checkboxelement.isSelected())
		{
			Retentionbonus_checkboxelement.click();
		}
		Scroll_down();
		Waitfor(2);
		boolean EmpActiveStatus = Employee_Active_radiobutton.isDisplayed();
		if(EmpActiveStatus==true)
		{
			Employee_Active_radiobutton.click();
		}
		else
		{
			logger.info("Employee Active radio button is not displaying");
		}
			
		
	}
	public void ClickFinanceSave_Button()
	{
		Candidate_Finan_Save.click();
		Waitfor(10);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -1000)", "");
		Waitfor(3);
		/*Cand_Backbutton.click();
		Waitfor(3);*/
		
	}
	
	public void cand_Aadhar_upload_document(String Aadharfile_description)
	{
		
		Cand_Aadhar_upload.click();
		boolean status= Cand_Aadhar_browse.isDisplayed();
		
		if(status==false)
		{
			Cand_Aadhar_browse.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
		}
		else
		{
			logger.info("Upload Button is not enabled");
		}
		

	    
		logger.info("Upload file sucessfully");
	
		//To check whether File Upload input field 
		
	     
		//Passport_Uploaddescription.sendKeys(Keys.chord(Keys.CONTROL, "a"), Aadharfile_description);
		Cand_Aadhar_comments.sendKeys("Aadhar card uploaded");
	    Waitfor(1);
	    Cand_Aadhar_uploadingbutton.click();
	    Waitfor(1);
	    
	    /*String upload_sucessfull_msg= fileuploaded_status.getAttribute("inner html");
	    
		logger.info("Upload file status is - "+fileuploaded_status);*/
	}
	
	public void cand_PAN_upload_document()
	{
		driver.findElement(By.xpath("//input[@id='cand_fin_pan']")).sendKeys("1234567");
		
		Cand_PAN_upload.click();
		boolean status= Cand_PAN_browse.isDisplayed();
	    Waitfor(1);
		if(status==false)
		{
			Cand_PAN_browse.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
		}
		else
		{
			logger.info("Upload Button is not enabled");
		}
		

	    
		logger.info("Upload file sucessfully");
	
		//To check whether File Upload input field 
		
	     
		//Passport_Uploaddescription.sendKeys(Keys.chord(Keys.CONTROL, "a"), Aadharfile_description);
		Cand_PAN_comments.sendKeys("PAN card uploaded");
	    Waitfor(1);
	    Cand_PAN_uploadingbutton.click();
	    Waitfor(1);
	    
	    /*String upload_sucessfull_msg= fileuploaded_status.getAttribute("inner html");
	    
		logger.info("Upload file status is - "+fileuploaded_status);*/
	}

	public void cand_UAN_upload_document(String Aadharfile_description)
	{
		Cand_UAN_upload.click();
		boolean status= Cand_UAN_browse.isDisplayed();
		
		if(status==false)
		{
			Cand_UAN_browse.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
		}
		else
		{
			logger.info("Upload Button is not enabled");
		}
		

	    
		logger.info("Upload file sucessfully");
	
		//To check whether File Upload input field 
		
	     
		//Passport_Uploaddescription.sendKeys(Keys.chord(Keys.CONTROL, "a"), Aadharfile_description);
		Cand_UAN_comments.sendKeys("UAN card uploaded");
	    Waitfor(1);
	    Cand_UAN_uploadingbutton.click();
	    Waitfor(1);
	    
	    /*String upload_sucessfull_msg= fileuploaded_status.getAttribute("inner html");
	    
		logger.info("Upload file status is - "+fileuploaded_status);*/
	}
	
	public void candfill_financeinfo(String PF,String Aadhar,String PAN,String UAN,String PBankName, String Primary_acno, String Primay_IFSC) throws Exception
	{
		
		Cand_Aadhar.clear();
		Cand_Aadhar.sendKeys(Aadhar);
		Waitfor(1);
		cand_Aadhar_upload_document("Aadhardocs");
		//Cand_Aadhar_upload.click();
		Thread.sleep(6000);	
		Cand_PAN.clear();
		Cand_PAN.sendKeys(PAN);
		Waitfor(1);
		cand_PAN_upload_document();
		Thread.sleep(6000);	
		Cand_UAN.clear();
		Cand_UAN.sendKeys(UAN);
		Waitfor(1);
		cand_UAN_upload_document("UAN cadr docs");
		Thread.sleep(6000);	
		CandPrimary_BankName.clear();
		CandPrimary_BankName.sendKeys(PBankName);
		Waitfor(1);
		CandPrimary_Acno.clear();
		CandPrimary_Acno.sendKeys(Primary_acno);
		Waitfor(1);
		CandPrimary_IFSCcode.clear();
		CandPrimary_IFSCcode.sendKeys(Primay_IFSC);
		Waitfor(1);
	}
	
	//Check on mail and click on that link
	//naviagted Url
		
	public void Cand_Genralinfo(String PerCon_Name, String Percon_Rel, String Per_PhNo,String Per_emailid, String Prof_Contname, String Prof_Desig, String Prof_Phnum, String Prof_mailid)
	{
		Per_ContactName.clear();
		Per_ContactName.sendKeys(PerCon_Name);
		Waitfor(1);
		Per_Relationship.clear();
		Per_Relationship.sendKeys(Percon_Rel);
		Waitfor(1);
		Per_Phonenumber.clear();
		Per_Phonenumber.sendKeys(Per_PhNo);
		Waitfor(1);
		Per_EmailId.clear();
		Per_EmailId.sendKeys(Per_emailid);
		Waitfor(1);
		Prof_ContactName.clear();
		Prof_ContactName.sendKeys(Prof_Contname);
		Waitfor(1);
		Prof_Designation.clear();
		Prof_Designation.sendKeys(Prof_Desig);
		Waitfor(1);
		Prof_Phonenumber.clear();
		Prof_Phonenumber.sendKeys(Prof_Phnum);
		Waitfor(1);
		Prof_EmailId.clear();
		Prof_EmailId.sendKeys(Prof_mailid);
		Waitfor(1);	
		
	}
	public void Save_Cand_Generalinfo()
	{
		Generalinfo_Savebutton.click();
		Waitfor(2);		
	}
	public void click_Candpersonalinfotab()
	{
		Personalinfo_Tab.click();
		Waitfor(2);			
	}
	//Methods for Candidate Personal Information
	public void Cand_PermanantAddress(String Cand_PerAddress, String Cand_PerCity, String Cand_PerPincode, String Cand_Perstate, String Cand_PermanaentCountry)
	{	
		Permanant_Address.clear();
		Permanant_Address.sendKeys(Cand_PerAddress);
		Waitfor(2);
		Permanant_City.clear();
		Permanant_City.sendKeys(Cand_PerCity);
		Waitfor(2);
		Permanant_Pincode.clear();
		Permanant_Pincode.sendKeys(Cand_PerPincode);
		Waitfor(2);
//		Permanant_State.clear();
//		Permanant_State.sendKeys(Cand_Perstate);
//		Waitfor(2);	
		Select Permanent_Country = new Select(Permanant_Country_Dropdown);
		logger.info("The Selected Country Name is "+Cand_PermanaentCountry);
		Waitfor(1);	
		Permanent_Country.selectByVisibleText(Cand_PermanaentCountry);
		Waitfor(2);	
		Select Permanent_state = new Select(Permanant_State);
		logger.info("The Selected Country Name is "+Cand_Perstate);
		Waitfor(1);	
		Permanent_state.selectByVisibleText(Cand_Perstate);
		
	}
	public void Cand_ContactNumbers(String Cand_PrimaryPhNo, String Cand_SeconPhNo,String Cand_Mailid, String Cand_AltMailId, String Cand_Emrgcontactname, String Cand_EmRelation, String Cand_EmrgPhonenum,String Bloodgroup)
	
	{
		Primary_Contactnumber.clear();
		Primary_Contactnumber.sendKeys(Cand_PrimaryPhNo);
		Waitfor(2);	
		Secondary_Contactnumber.clear();
		Secondary_Contactnumber.sendKeys(Cand_SeconPhNo);
		Waitfor(2);	
		Personal_EmailID.clear();
		Personal_EmailID.sendKeys(Cand_Mailid);
		Waitfor(2);	
		Alternative_EmailId.clear();
		Alternative_EmailId.sendKeys(Cand_AltMailId);
		Waitfor(2);	
		Emerg_ContanctName.clear();
		Emerg_ContanctName.sendKeys(Cand_Emrgcontactname);
		Waitfor(2);
		Emerg_Relationship.clear();
		Emerg_Relationship.sendKeys(Cand_EmRelation);
		Waitfor(2);
		Emerg_Phonenumber.clear();
		Emerg_Phonenumber.sendKeys(Cand_EmrgPhonenum);
		Waitfor(2);
		Cand_BloodGroup.clear();
		Cand_BloodGroup.sendKeys(Bloodgroup);
		Waitfor(2);
		
		
	}
	public void Cand_CurrentAddress(String Cand_CurAddress, String Cand_CurCity, String Cand_CurPincode, String Cand_Curstate, String Cand_CurrentCountry, String Cand_Mothername,int DOB_M, String Cand_Fathername,int DOB_F)
	
	{
		Current_Address.clear();
		Current_Address.sendKeys(Cand_CurAddress);
		Waitfor(2);
		Current_City.clear();
		Current_City.sendKeys(Cand_CurCity);
		Waitfor(2);
		Current_Pincode.clear();
		Current_Pincode.sendKeys(Cand_CurPincode);
		Waitfor(2);
		
//		Select Curent_Country = new Select(Current_Country_Dropdown);
//		logger.info("The Selected Country Name is "+Cand_CurrentCountry);
//		Waitfor(2);	
//		Curent_Country.selectByVisibleText(Cand_CurrentCountry);
//		Waitfor(2);	
//		Select cuurent_state = new Select(Current_State);
//		logger.info("The Selected Country Name is "+cuurent_state);
//		Waitfor(2);	
//		cuurent_state.selectByVisibleText(Cand_Curstate);
		Waitfor(2);	
        MothersName.sendKeys(Cand_Mothername);
        Waitfor(1);
        Mothers_DOB.click();
        List<WebElement> DOBmother = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

		int total_dobm = DOBmother.size();
		logger.info("Calendar Date size is : " + total_dobm);
		for (int i = 0; i < total_dobm; i++) {
			String dobm = DOBmother.get(i).getText();
			if (dobm.equals(Integer.toString(DOB_M))) {
				DOBmother.get(i).click();
				logger.info("Selected date is: " + dobm);
				break;

			}
		}
		FathersName.clear();
		FathersName.sendKeys(Cand_Fathername);
		Waitfor(1);	
		Fathers_DOB.click();
		List<WebElement> DOBFather = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

		int total_dobf = DOBFather.size();
		logger.info("Calendar Date size is : " + total_dobf);
		for (int i = 0; i < total_dobf; i++) {
			String dobf = DOBFather.get(i).getText();
			if (dobf.equals(Integer.toString(DOB_F))) {
				DOBFather.get(i).click();
				logger.info("Selected date is: " + dobf);
				break;

			}
		}
		
		boolean status = Martial_Status_Single_Radiobutton.isSelected();
		if(status==false)
		{
			Martial_Status_Single_Radiobutton.click();
		}
		else
		{
			logger.info("Martial_Status_Radiobutton Radio button is already selected");
		}		
		
	}

	public void Save_Cand_Personalinfo()
	{
		Personalinfo_Savebutton.click();
		Waitfor(9);	
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -450)", "");
		Waitfor(3);
		
		
	}
	
	public void Click_candNomineeinfotab()
	{
		Cand_Nominee_InfoTab.click();
		Waitfor(2);		
	}
	public void cand_Form2_upload_document(String Aadharfile_description)
	{
		Cand_Form2_upload.click();
		boolean status= Cand_Form2_browse.isDisplayed();
		
		if(status==false)
		{
			Cand_Form2_browse.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
		}
		else
		{
			logger.info("Upload Button is not enabled");
		}
		

	    
		logger.info("Upload file sucessfully");
	
		//To check whether File Upload input field 
		
	     
		//Passport_Uploaddescription.sendKeys(Keys.chord(Keys.CONTROL, "a"), Aadharfile_description);
		Cand_Form2_comments.sendKeys("Form2 doc uploaded");
	    Waitfor(1);
	    Cand_Form2_uploadingbutton.click();
	    Waitfor(1);
	    
	    /*String upload_sucessfull_msg= fileuploaded_status.getAttribute("inner html");
	    
		logger.info("Upload file status is - "+fileuploaded_status);*/
	}
	public void cand_Form11_upload_document(String Aadharfile_description)
	{
		Cand_Form11_upload.click();
		boolean status= Cand_Form11_browse.isDisplayed();
		
		if(status==false)
		{
			Cand_Form11_browse.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
		}
		else
		{
			logger.info("Upload Button is not enabled");
		}
		

	    
		logger.info("Upload file sucessfully");
	
		//To check whether File Upload input field 
		
	     
		//Passport_Uploaddescription.sendKeys(Keys.chord(Keys.CONTROL, "a"), Aadharfile_description);
		Cand_Form11_comments.sendKeys("Form11 doc uploaded");
	    Waitfor(1);
	    Cand_PAN_uploadingbutton.click();
	    Waitfor(1);
	    
	    /*String upload_sucessfull_msg= fileuploaded_status.getAttribute("inner html");
	    
		logger.info("Upload file status is - "+fileuploaded_status);*/
	}
	public void cand_UANForm_upload_document(String Aadharfile_description)
	{
		Cand_UAN_Form_upload.click();
		boolean status= Cand_UAN_Form_browse.isDisplayed();
		
		if(status==false)
		{
			Cand_UAN_Form_browse.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
		}
		else
		{
			logger.info("Upload Button is not enabled");
		}
		

	    
		logger.info("Upload file sucessfully");
	
		//To check whether File Upload input field 
		
	     
		//Passport_Uploaddescription.sendKeys(Keys.chord(Keys.CONTROL, "a"), Aadharfile_description);
		Cand_UAN_Form_comments.sendKeys("UAN doc uploaded");
	    Waitfor(1);
	    Cand_UAN_Form_uploadingbutton.click();
	    Waitfor(1);
	    
	    /*String upload_sucessfull_msg= fileuploaded_status.getAttribute("inner html");
	    
		logger.info("Upload file status is - "+fileuploaded_status);*/
	}
	
	public void Cand_NomineeInfoDetails(String Nom_Name, String Nom_Relation, String Nom_Contactno, String NomDepadantname, String NomDepRelation) throws Exception
	{		
		Cand_Nominee_Name.clear();
		Cand_Nominee_Name.sendKeys(Nom_Name);
		Waitfor(2);
		Cand_Nominee_Relationship.clear();
		Cand_Nominee_Relationship.sendKeys(Nom_Relation);
		Waitfor(2);
		Cand_Nominee_Contactno.clear();
		Cand_Nominee_Contactno.sendKeys(Nom_Contactno);
		Waitfor(2);
		//Add_Dependants_button.click();
		//Waitfor(2);
		Cand_Dependent_Name.clear();
		Cand_Dependent_Name.sendKeys(NomDepadantname);
		Waitfor(2);
		Cand_Dependent_Relationship.clear();
		Cand_Dependent_Relationship.sendKeys(NomDepRelation);
		Waitfor(2);
		//cand_declaration_Form2_dwd.click();
		Waitfor(4);
		cand_Form2_upload_document("Form2 docs");
		Thread.sleep(6000);
		//cand_declaration_Form11_dwd.click();
		Waitfor(4);
		cand_Form11_upload_document("Form2docs");
		Thread.sleep(6000);
		//cand_UANForm_dwd.click();
		Waitfor(4);
		cand_UANForm_upload_document("UANDocuments");
		Thread.sleep(6000);
			
		
	}
	
	public void Save_Cand_Nomineeinfo()
	{
		Nomineeinfo_Savebutton.click();
		Waitfor(6);	
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -450)", "");
		Waitfor(6);
		
	}
	public void cand_Passport_upload_document(String Aadharfile_description)
	{
		Cand_passport_upload.click();
		boolean status= Cand_passport_browse.isDisplayed();
		
		if(status==false)
		{
			Cand_passport_browse.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
		}
		else
		{
			logger.info("Upload Button is not enabled");
		}
		

	    
		logger.info("Upload file sucessfully");
	
		//To check whether File Upload input field 
		
	     
		//Passport_Uploaddescription.sendKeys(Keys.chord(Keys.CONTROL, "a"), Aadharfile_description);
		Cand_passport_comments.sendKeys("Passport doc uploaded");
	    Waitfor(1);
	    Cand_passport_uploadingbutton.click();
	    Waitfor(1);
	    
	    /*String upload_sucessfull_msg= fileuploaded_status.getAttribute("inner html");
	    
		logger.info("Upload file status is - "+fileuploaded_status);*/
	}
	public void click_candpassportinfotab()
	{
		PassportInfo_Tab.click();
		Waitfor(2);
	}
	public void Cand_PassportDetails(String GivenName, String Surname, String PassportNo,int PassDOI,int PassDOE, String Placeofissue, String Placeofbirth, String Visatype, int visadatestart, int visadateend, String VisaCountry ) throws Exception
	{
		Emp_Given_Name.clear();
		Emp_Given_Name.sendKeys(GivenName);
		Waitfor(2);
		Emp_Surname.clear();
		Emp_Surname.sendKeys(Surname);
		Waitfor(2);
		Emp_Passport_Number.clear();
		Emp_Passport_Number.sendKeys(PassportNo);
		Waitfor(2);
		Passport_DateofIssue_Datepicker.click();
		List<WebElement> PassportDOI = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

		int total_doinodes = PassportDOI.size();
		logger.info("Calendar Date size is : " + total_doinodes);
		for (int i = 0; i < total_doinodes; i++) {
			String doidate = PassportDOI.get(i).getText();
			if (doidate.equals(Integer.toString(PassDOI))) {
				PassportDOI.get(i).click();
				logger.info("Selected date is: " + doidate);
				break;

			}
		}
		Waitfor(2);
		Passport_DateofExpiry_Datepicker.click();
		List<WebElement> PassportDOE = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

		int total_doenodes = PassportDOE.size();
		logger.info("Calendar Date size is : " + total_doenodes);
		for (int i = 0; i < total_doenodes; i++) {
			String doedate = PassportDOE.get(i).getText();
			if (doedate.equals(Integer.toString(PassDOE))) {
				PassportDOE.get(i).click();
				logger.info("Selected date is: " + doedate);
				break;

			}
		}
		Waitfor(2);
		Passport_PlaceofIssue.clear();
		Passport_PlaceofIssue.sendKeys(Placeofissue);
		Waitfor(2);
		Emp_Placeofbirth.clear();
		Emp_Placeofbirth.sendKeys(Placeofbirth);
		Waitfor(2);
		cand_Passport_upload_document("Passport docs");
		Thread.sleep(6000);
		Emp_Visa_Type.sendKeys(Visatype);
		Waitfor(2);
		Emp_Visa_StartDate.click();
		List<WebElement> visastratdate = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

		int total_visastnodes = visastratdate.size();
		logger.info("Calendar Date size is : " + total_visastnodes);
		for (int i = 0; i < total_visastnodes; i++) {
			String visastdate = visastratdate.get(i).getText();
			if (visastdate.equals(Integer.toString(visadatestart))) {
				visastratdate.get(i).click();
				logger.info("Selected date is: " + visastdate);
				break;

			}
		}
		Emp_Visa_EndDate.click();
		List<WebElement> visadate_END = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

		int total_visaendnodes = visadate_END.size();
		logger.info("Calendar Date size is : " + total_visaendnodes);
		for (int i = 0; i < total_visaendnodes; i++) {
			String visadatend = visadate_END.get(i).getText();
			if (visadatend.equals(Integer.toString(visadateend))) {
				visadate_END.get(i).click();
				logger.info("Selected date is: " + visadatend);
				break;

			}
		}
		
		Emp_Visa_Country.sendKeys(VisaCountry);
		Waitfor(2);
		
	}
	public void Save_Cand_PassportInfo()
	{
		Passportinfo_Savebutton.click();
		Waitfor(2);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -450)", "");
		Waitfor(3);
	}
	public void click_candeducationalinfotab()
	{
		EducationInfo_Tab.click();
		Waitfor(2);
	}
	public void cand_education1_upload_document(String Aadharfile_description)
	{
		Waitfor(2);
		boolean status= Cand_edu1_browse.isDisplayed();
		
		if(status==true)
		{
			Cand_edu1_browse.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
		}
		else
		{
			logger.info("Upload Button is not enabled");
		}
	
		logger.info("Upload file sucessfully");
	
		//To check whether File Upload input field 
		Waitfor(2);
		Cand_edu1_comments.sendKeys(Aadharfile_description);
	    Waitfor(1);
	    Cand_edu1_uploadingbutton.click();
	    Waitfor(1);
	    
	}
	public void Cand_Educationalinfo(String Degreename, String Majorsubject,String PassingYear, String StudentId, String CollegeName,int candgrdate, int candstdate,String gradePercentage,String Degreetype,String Edu_Gap,int Gapfromdate,int GapTodate,String GapReason,String Training_instname, String coursename, String Rank, String TrainingYear) throws Exception
	{		
				
		Select Cand_DegreeNameDD = new Select(Cand_DegreeName);			
		Waitfor(1);	
		Cand_DegreeNameDD.selectByVisibleText(Degreename);
		logger.info("The Selected DegreeName is " + Degreename);
		Waitfor(1);
		Cand_SubjectMajor.sendKeys(Majorsubject);
		Waitfor(2);
		Cand_YearofPassing.sendKeys(PassingYear);
		Waitfor(2);
		Cand_StudentID.sendKeys(StudentId);
		Waitfor(2);		
		Cand_CollegeName.sendKeys(CollegeName);
		Waitfor(2);	
		//Graduation date
		Cand_Graduationdatepicker.click();
		List<WebElement> graddate = driver.findElements(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[2]/a"));

		int total_grddates= graddate.size();
		logger.info("Calendar Date size is : " + total_grddates);
		for (int i = 0; i < total_grddates; i++) {
			String candgraddate = graddate.get(i).getText();
			if (candgraddate.equals(Integer.toString(candgrdate))) {
				graddate.get(i).click();
				logger.info("Selected date is: " + candgraddate);
				break;

			}
		}
		//Start Date
		Cand_Startdate.click();
		List<WebElement> gradstdate = driver.findElements(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[3]/a"));

		int total_grdstdate= gradstdate.size();
		logger.info("Calendar Date size is : " + total_grdstdate);
		for (int i = 0; i < total_grdstdate; i++) {
			String candgradstdate = gradstdate.get(i).getText();
			if (candgradstdate.equals(Integer.toString(candstdate))) {
				gradstdate.get(i).click();
				logger.info("Selected date is: " + candgradstdate);
				break;

			}
		}
		Cand_Grade.sendKeys(gradePercentage);
		Waitfor(1);
		cand_education1_upload_document("educationdocs");
		Thread.sleep(6000);
		/*
		//Upload_Education_Documents_Button.click();
		//Degreetype dropdown	
		/*Select DegreetypeDD = new Select(Cand_DegreetypeDD);			
		Waitfor(1);	
		DegreetypeDD.selectByVisibleText(Degreetype);
		logger.info("The Selected Role is " + Degreetype);*/
		//Gap Duration if any
		//EnterCand_Educationgap.sendKeys(Edu_Gap);
		Waitfor(1);
		/*CandEdu_GapFrom.click();
		List<WebElement> edugap = driver.findElements(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[4]/a"));

		int total_gapdates= edugap.size();
		logger.info("Calendar Date size is : " + total_gapdates);
		for (int i = 0; i < total_gapdates; i++) {
			String gapfrom = edugap.get(i).getText();
			if (gapfrom.equals(Integer.toString(Gapfromdate))) {
				edugap.get(i).click();
				logger.info("Selected date is: " + gapfrom);
				break;

			}
		}
		CandEdu_GapTo.click();
		
		List<WebElement> edugapTo = driver.findElements(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[5]/a"));

		int total_gapdatesTo= edugapTo.size();
		logger.info("Calendar Date size is : " + total_gapdatesTo);
		for (int i = 0; i < total_gapdatesTo; i++) {
			String gapTO = edugapTo.get(i).getText();
			if (gapTO.equals(Integer.toString(GapTodate))) {
				edugapTo.get(i).click();
				logger.info("Selected date is: " + gapTO);
				break;

			}
		}*/
		/*CandEdu_GapReason.sendKeys(GapReason);
		Waitfor(2);
		CandEnter_Institute.sendKeys(Training_instname);
		Waitfor(2);
		CandEnter_Course.sendKeys(coursename);
		Waitfor(2);
		CandEnter_Rank.sendKeys(Rank);
		Waitfor(2);
		CandEnterYear_of_Completion.sendKeys(TrainingYear);
		Waitfor(2);*/		
	}
		
	public void Cand_Educationalinfo_Tab(String Degreename, String Majorsubject,String PassingYear, String StudentId, String CollegeName,int candgrdate, int candstdate,String gradePercentage)
	{
	
	Educationinfo_Add_Button.click();
	Educationinfo_Add_Button.click();
	Waitfor(1);
	WebElement tbody_table = driver.findElement(By.xpath("//table[@id='cand_education_info']"));
	List<WebElement> tbody = tbody_table.findElements(By.tagName("tbody"));
	logger.info(tbody.size());
	int deg= 0;
	for (int t = 1; t <= tbody.size(); t++) 
	{
			
			WebElement row_table = driver.findElement(By.xpath("//table[@id='cand_education_info']/tbody"));
			List<WebElement> row = row_table.findElements(By.tagName("tr"));
			logger.info(row.size());
				int rowcount= 1;
				for (int r = 1; r<=row.size(); r++) 
				{		
						String dd_values[]= {"Degree or Equivalent", "PUC or Equivalent","10th or Equivalent"};
						WebElement col_table = driver.findElement(By.xpath("//table[@id='cand_education_info']/tbody/tr"));
						List<WebElement> column = col_table.findElements(By.tagName("td"));
						logger.info(column.size());
						
						for (int c = 1; c <=1 ; c++) 
						{	
							int count = 4;
							WebElement element = driver.findElement(By.xpath("//table[@id='cand_education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]"));
							if(count==4 && rowcount ==1)
							{
								
								Select ele1 = new Select(driver.findElement(By.xpath("//table[@id='cand_education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/select")));
								ele1.selectByVisibleText(dd_values[deg]);
								Waitfor(2);
								count=count+5;
								
							}
							
							if(count==9 && rowcount ==1)
							{
								WebElement ele2	 = driver.findElement(By.xpath("//table[@id='cand_education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/input"));
								ele2.sendKeys(Keys.chord(Keys.CONTROL, "a"),Majorsubject);
								Waitfor(2);
								count=count+4;
							}
							
							if(count==13 && rowcount ==1)
							{
								WebElement ele3	 = driver.findElement(By.xpath("//table[@id='cand_education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/input"));
								ele3.sendKeys(Keys.chord(Keys.CONTROL, "a"),PassingYear);
							}
							if(count==4 && rowcount ==2)
							{
								WebElement ele4	 = driver.findElement(By.xpath("//table[@id='cand_education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/input"));
								ele4.sendKeys(Keys.chord(Keys.CONTROL, "a"),StudentId);
								Waitfor(2);	
								count=count+5;
				
							}
							if(count==9 && rowcount ==2)
							{
								WebElement ele5	 = driver.findElement(By.xpath("//table[@id='cand_education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/textarea"));
								ele5.sendKeys(Keys.chord(Keys.CONTROL, "a"),CollegeName);
								Waitfor(2);	
								count=count+4;
							}
							//Graduation date
							if(count==13 && rowcount ==2)
							{
								WebElement ele6	 = driver.findElement(By.xpath("//table[@id='cand_education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/input"));
								ele6.click();
								Waitfor(1);
								List<WebElement> graddate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
						
								int total_grddates= graddate.size();
								logger.info("Calendar Date size is : " + total_grddates);
								for (int s = 0; s < total_grddates; s++) 
								{
									String candgraddate = graddate.get(s).getText();
									if (candgraddate.equals(Integer.toString(candgrdate)))
									{
										graddate.get(s).click();
										logger.info("Selected date is: " + candgraddate);
										break;
						
									}
								}
							}

							if(count==4 && rowcount ==3)
							{
								WebElement ele7	 = driver.findElement(By.xpath("//table[@id='cand_education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/input"));
								ele7.click();
								Waitfor(1);
								List<WebElement> gradstdate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
						
								int total_grdstdate= gradstdate.size();
								logger.info("Calendar Date size is : " + total_grdstdate);
								for (int i = 0; i < total_grdstdate; i++)
								{
									String candgradstdate = gradstdate.get(i).getText();
									if (candgradstdate.equals(Integer.toString(candstdate)))
									{
										gradstdate.get(i).click();
										logger.info("Selected date is: " + candgradstdate);
										count=count+5;
										break;
						
									}
								}
							}
							if(count==9 && rowcount ==3)
							{
								WebElement ele8	 = driver.findElement(By.xpath("//table[@id='cand_education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/input"));
								ele8.sendKeys(Keys.chord(Keys.CONTROL, "a"),gradePercentage);
								Waitfor(2);	
								count=count+4;

							}
						if(count==13 && rowcount ==3)
						{
						
						WebElement ele5	 = driver.findElement(By.xpath("//table[@id='cand_education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/button"));
						ele5.click();
						Waitfor(2);	
						cand_education1_upload_document("Comments for Upload");	
						Waitfor(2);
						}
							
	
						}
						rowcount++;
					}
				  deg++;
				}			
		}
	
	public void Cand_Experienceinfo_tab(String Company, String Exp_Designation, String DOL, String EMPID, String Reportedto, String Leavingreason,String HRname,int DOJ, int DOR) 
	{
		Educationinfo_Add_Button.click();
		Educationinfo_Add_Button.click();
		Waitfor(1);
		WebElement tbody_table = driver.findElement(By.xpath("//table[@id='cand_experience_info']"));
		List<WebElement> tbody = tbody_table.findElements(By.tagName("tbody"));
		logger.info(tbody.size());
		int type= 0;
		for (int t = 1; t <= tbody.size(); t++) 
		{
				
				WebElement row_table = driver.findElement(By.xpath("//table[@id='cand_experience_info']/tbody"));
				List<WebElement> row = row_table.findElements(By.tagName("tr"));
				logger.info(row.size());
					int rowcount= 1;
					for (int r = 1; r<=row.size(); r++) 
					{		
							String dd_values[]= {"Permanent", "Temporary"};
							WebElement col_table = driver.findElement(By.xpath("//table[@id='cand_experience_info']/tbody/tr"));
							List<WebElement> column = col_table.findElements(By.tagName("td"));
							logger.info(column.size());
							
							for (int c = 1; c <=1 ; c++) 
							{	
								int count = 4;
								WebElement element = driver.findElement(By.xpath("//table[@id='cand_experience_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]"));
								if(count==3 && rowcount ==3)
								{
									
									Select ele1 = new Select(driver.findElement(By.xpath("//table[@id='cand_experience_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/input")));
									ele1.selectByVisibleText(dd_values[type]);
									Waitfor(2);
									count=count+5;
									
								}
								
								if(count==3 && rowcount ==1)
								{
									WebElement ele2	 = driver.findElement(By.xpath("//table[@id='experience_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/input"));
									ele2.sendKeys(Keys.chord(Keys.CONTROL, "a"),Company);
									Waitfor(2);
									count=count+5;
								}
								
								if(count==6 && rowcount ==1)
								{
									WebElement ele3	 = driver.findElement(By.xpath("//table[@id='cand_experience_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/input"));
									ele3.sendKeys(Keys.chord(Keys.CONTROL, "a"),Exp_Designation);
									Waitfor(2);
									count=count+5;
									
								}
								if(count==9 && rowcount ==1)
								{
									WebElement ele4	 = driver.findElement(By.xpath("//table[@id='cand_experience_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/input"));
									ele4.sendKeys(Keys.chord(Keys.CONTROL, "a"),DOL);
									Waitfor(2);	
									count=count+5;
					
								}
								if(count==3 &&rowcount ==2)
								{
									WebElement ele5	 = driver.findElement(By.xpath("//table[@id='cand_education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/input"));
									ele5.sendKeys(Keys.chord(Keys.CONTROL, "a"),EMPID);
									Waitfor(2);	
									count=count+5;
								}
								if(count==6 && rowcount ==2)
								{
									WebElement ele5	 = driver.findElement(By.xpath("//table[@id='cand_education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/input"));
									ele5.sendKeys(Keys.chord(Keys.CONTROL, "a"),Reportedto);
									Waitfor(2);	
									count=count+5;
								}
								if(count==9 && rowcount ==2)
								{
									WebElement ele5	 = driver.findElement(By.xpath("//table[@id='cand_education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/input"));
									ele5.sendKeys(Keys.chord(Keys.CONTROL, "a"),Leavingreason);
									Waitfor(2);	
									count=count+4;
								}
								//Graduation date
								if(count==13 && rowcount ==2)
								{
									WebElement ele6	 = driver.findElement(By.xpath("//table[@id='experience_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/input"));
									ele6.click();
									Waitfor(1);
									List<WebElement> graddate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
							
									int total_grddates= graddate.size();
									logger.info("Calendar Date size is : " + total_grddates);
									for (int s = 0; s < total_grddates; s++) 
									{
										String candgraddate = graddate.get(s).getText();
										if (candgraddate.equals(Integer.toString(DOJ)))
										{
											graddate.get(s).click();
											logger.info("Selected date is: " + candgraddate);
											break;
							
										}
									}
								}

								if(count==4 && rowcount ==3)
								{
									WebElement ele7	 = driver.findElement(By.xpath("//table[@id='cand_education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/input"));
									ele7.click();
									Waitfor(1);
									List<WebElement> gradstdate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
							
									int total_grdstdate= gradstdate.size();
									logger.info("Calendar Date size is : " + total_grdstdate);
									for (int i = 0; i < total_grdstdate; i++)
									{
										String candgradstdate = gradstdate.get(i).getText();
										if (candgradstdate.equals(Integer.toString(DOR)))
										{
											gradstdate.get(i).click();
											logger.info("Selected date is: " + candgradstdate);
											count=count+5;
											break;
							
										}
									}
								}
								if(count==6 && rowcount ==3)
								{
									WebElement ele8	 = driver.findElement(By.xpath("//table[@id='cand_education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/input"));
									ele8.sendKeys(Keys.chord(Keys.CONTROL, "a"),HRname);
									Waitfor(2);	
									count=count+5;

								}
								if(count==13 && rowcount ==3)
								{
							
								WebElement ele5	 = driver.findElement(By.xpath("//table[@id='cand_education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/button"));
								ele5.click();
								Waitfor(2);	
								cand_education1_upload_document("educationdocs");
								Waitfor(3);
								count=count=count+4;
							}
								
		
							}
							rowcount++;
						}
					type++;
					}			
			}
		
	
	
	public void Save_Cand_Educationalinfo()
	{
		Educationinfo_Savebutton.click();
		Waitfor(2);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -450)", "");
		Waitfor(3);
	}
	public void RMG_Reject_Eduinfo()
	{
		Cand_eduReject_button.click();
		Waitfor(2);
	}
	public void cand_exp_upload_document(String Aadharfile_description)
	{
		Cand_exp_upload.click();
		boolean status= Cand_exp_browse.isDisplayed();
		
		if(status==false)
		{
			Cand_exp_browse.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
		}
		else
		{
			logger.info("Upload Button is not enabled");
		}
		

	    
		logger.info("Upload file sucessfully");
	
		//To check whether File Upload input field 
		
	     
		//Passport_Uploaddescription.sendKeys(Keys.chord(Keys.CONTROL, "a"), Aadharfile_description);
		Cand_exp_comments.sendKeys("Candidate exp docs uploaded");
	    Waitfor(1);
	    Cand_exp_uploadingbutton.click();
	    Waitfor(1);
	    
	    /*String upload_sucessfull_msg= fileuploaded_status.getAttribute("inner html");
	    
		logger.info("Upload file status is - "+fileuploaded_status);*/
	}
	
	public void click_candexperienceinfotab()
	{
		Experienceinfo_Tab.click();
		Waitfor(2);
	}
	
	public void Cand_Experienceinfo(String Company, String Exp_Designation, String DOL, String EMPID, String Reportedto, String Leavingreason,String HRname,int DOJ, int DOR,int Gapempfrom,int Gapempto,String Gapreason) throws Exception
	{
		driver.findElement(By.xpath("//button[@id='candExpAddBtn']")).click();
		Waitfor(2);
		Cand_PrevCompanyName.sendKeys(Company);
		Waitfor(2);
		Cand_Designationonjoining.sendKeys(Exp_Designation);
		Waitfor(2);
		Cand_DesignationonLeaving.sendKeys(DOL);
		Waitfor(2);
		Cand_EmpID.sendKeys(EMPID);
		Waitfor(2);
		Cand_ReportedTo.sendKeys(Reportedto);
		Waitfor(2);
		Cand_ReasonforLeaving.sendKeys(Leavingreason);
		Waitfor(2);
		Cand_HRName.sendKeys(HRname);
		Waitfor(2);		
		cand_exp_upload_document("experiencedocs");
		
		Cand_DOJ.click();
		List<WebElement> canddoj = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

		int DOJCAND= canddoj.size();
		logger.info("Calendar Date size is : " + DOJCAND);
		for (int i = 0; i < DOJCAND; i++) {
			String Canddateofjoining = canddoj.get(i).getText();
			if (Canddateofjoining.equals(Integer.toString(DOJ))) {
				canddoj.get(i).click();
				logger.info("Selected date is: " + Canddateofjoining);
				break;

			}
		}
		Waitfor(2);
		Cand_DOR.click();
		List<WebElement> canddor = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

		int DORCAND= canddor.size();
		logger.info("Calendar Date size is : " + DORCAND);
		for (int i = 0; i < DORCAND; i++) {
			String Canddateofreleave = canddor.get(i).getText();
			if (Canddateofreleave.equals(Integer.toString(DOR))) {
				canddor.get(i).click();
				logger.info("Selected date is: " + Canddateofreleave);
				break;

			}
		}
		Waitfor(2);
				
//		//Gap duration employment
//		driver.findElement(By.xpath("//button[@onclick='addEmpGapRowCand()']")).click();
//		Waitfor(2);
//		EmpGap_Fromdate.click();
//		Waitfor(2);
//		List<WebElement> EmpgapFrom = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));
//
//		int Emp_Gapfrom= EmpgapFrom.size();
//		logger.info("Calendar Date size is : " + Emp_Gapfrom);
//		for (int i = 0; i < Emp_Gapfrom; i++) {
//			String empgapfrom = EmpgapFrom.get(i).getText();
//			if (empgapfrom.equals(Integer.toString(Gapempfrom))) {
//				EmpgapFrom.get(i).click();
//				logger.info("Selected date is: " + empgapfrom);
//				break;
//
//			}
//		}
//		EmpGap_Todate.click();
//		Waitfor(2);
//		List<WebElement> EmpgapTo= driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));
//		Waitfor(2);
//		int Emp_Gapto= EmpgapTo.size();
//		logger.info("Calendar Date size is : " + Emp_Gapto);
//		for (int i = 0; i < Emp_Gapto; i++) {
//			String empgapto = EmpgapTo.get(i).getText();
//			if (empgapto.equals(Integer.toString(Gapempto))) {
//				EmpgapTo.get(i).click();
//				logger.info("Selected date is: " + empgapto);
//				break;
//
//			}
//		}
//		EmpGap_Reason.sendKeys(Gapreason);
//		Waitfor(2);
	}	
	public void Save_Cand_Experienceinfo()
	{
		Experienceinfo_Savebutton.click();
		Waitfor(2);	
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -450)", "");
		Waitfor(3);
	}
	
	public void Click_candskillinfotab()
	{
		SkillsInfo_Tab.click();
		Waitfor(2);
	}
	public void cand_profile_upload_document(String Aadharfile_description)
	{
		Cand_profile_upload.click();
		boolean status= Cand_profile_browse.isDisplayed();
		
		if(status==false)
		{
			Cand_profile_browse.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
		}
		else
		{
			logger.info("Upload Button is not enabled");
		}
		

	    
		logger.info("Upload file sucessfully");
	
		//To check whether File Upload input field 
		
	     
		//Passport_Uploaddescription.sendKeys(Keys.chord(Keys.CONTROL, "a"), Aadharfile_description);
		Cand_profile_comments.sendKeys("Candidate profile uploaded");
	    Waitfor(1);
	    Cand_profile_uploadingbutton.click();
	    Waitfor(1);
	    
	    /*String upload_sucessfull_msg= fileuploaded_status.getAttribute("inner html");
	    
		logger.info("Upload file status is - "+fileuploaded_status);*/
	}
	public void Cand_Skillsinfo() throws Exception
	{		
		cand_profile_upload_document("Cand profile");
		Thread.sleep(6000);
		/*Candprofile_downloadlink.click();
		Waitfor(1);*/
		skills_selecticon.click();
		Waitfor(2);	
		Scroll_down();
		driver.findElement(By.xpath("//input[@id='cand_otherSkills']")).sendKeys("suma");;
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500)", "");
		Waitfor(3);			
	}
	public void Save_Cand_Skillsinfo()
	{
		Skillsinfo_Savebutton.click();
		Waitfor(8);
		((JavascriptExecutor) driver).executeScript("scroll(0, -500)", "");
		Waitfor(3);
	}
	public void click_backgroundverificationinfotab()
	{
		BGVinfo_Tab.click();
		Waitfor(2);
	}
	public void Cand_BGVinfo()
	{
		uploadBGCdoc_button.click();
		Waitfor(2);
		boolean status= DocBrowse_Button.isDisplayed();
		Waitfor(2);
		if(status==true)
			
		{
			DocBrowse_Button.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
		}
		else
		{
			logger.info("Upload Button is not enabled");
		}			    
		logger.info("Upload file sucessfully");
	    //To check whether File Upload input field 
		UploadBGC_Comments.sendKeys(Keys.chord(Keys.CONTROL, "a"), "BGB Uploading");
	    Waitfor(1);
	    uploadBGC_Popupbutton.click();
	    Waitfor(1);
	    driver.findElement(By.xpath("//button[@id='cand_saveBackVerification']")).click();
	    
	  /*  String upload_sucessfull_msg= BGCfileuploaded_status.getAttribute("inner html");
	    
		logger.info("Upload file status is - "+fileuploaded_status);*/
	}
			
	public void RMGSubmit_Candidate_Profile()
	{
		RMGCandidate_submitbutton.click();
		Waitfor(2);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -350)", "");
		Waitfor(3);
		Cand_Backbutton.click();
		Waitfor(15);
		
	}
	
	public void logout()
	{
		Username_Logout.click();
		Waitfor(3);
		Logout.click();
		Waitfor(1);
		driver.quit();
	}
	
	public  void Scroll_Up()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("window.scrollBy(0,-600)");
	}
	
		public void editbutton()
		{
		
			driver.findElement(By.xpath(".//*[@id='candidate_edit']")).click();
			Waitfor(3);
		}
		public  void Scroll_down()
		{
			JavascriptExecutor js = (JavascriptExecutor)driver; 
			js.executeScript("scroll(0,900)");
		}
		
		public  void pagination()
		{
			search_text.sendKeys(Keys.chord(Keys.CONTROL, "a"),"1617");
Waitfor(2);
driver.findElement(By.xpath("//td[contains(.,'sinfd l')]")).click();
		}
		public void save_all_the_tabs()
		{
			Save_Cand_Generalinfo();
			logger.info("the percentage incresed is 15%");
			Waitfor(2);	
			
			click_Candpersonalinfotab();
			Waitfor(2);
			Save_Cand_Personalinfo();
			String personal_msg="Personal Info Saved/Updated Successfully";
			WebElement per_save=driver.findElement(By.xpath("//div[contains(.,'XPersonal Info Saved/Updated Successfully')]"));
			if(per_save.equals(per_save))
			{
			logger.info("the percentage incresed is 10%");
			Waitfor(2);
			}
			
			String nominee_save="Declaration Saved/Updated Successfully";
			WebElement nominee_save1=driver.findElement(By.xpath("//div[contains(.,'XDeclaration Saved/Updated Successfully')]"));
			
			Click_candNomineeinfotab();
			Waitfor(2);
			if(nominee_save1.equals(nominee_save1))
			{
			Save_Cand_Nomineeinfo();
			
			logger.info("the percentage incresed is 10%");
			Waitfor(2);
			}
			 ObjectInitClass.EOB.click_Candfinanceinfotab();
			Waitfor(2);
			ClickFinanceSave_Button();
			driver.findElement(By.xpath("//span[contains(.,'Finance Info Saved/updated Successfully')]"));
			logger.info("the percentage incresed is 15%");
			  ObjectInitClass.EOB.click_candpassportinfotab();
			 Waitfor(2);
			Save_Cand_PassportInfo();
			Waitfor(2);	
			driver.findElement(By.xpath("//div[contains(.,'XPassport Info Saved/Updated Successfully')]"));
			passport_info_tab_captrue();
			logger.info("the percentage incresed is 10%");
			Waitfor(2);	
			click_candeducationalinfotab();
			 Waitfor(2);
			Save_Cand_Educationalinfo();
			driver.findElement(By.xpath("//span[contains(.,'Education Info Saved/Updated Successfully')]"));
			logger.info("the percentage incresed is 15%");
			click_candexperienceinfotab();
			Waitfor(2);
			Save_Cand_Experienceinfo();
			driver.findElement(By.xpath("//div[contains(.,'XExperience Info Saved/updated Successfully')]"));
			Waitfor(2);	
				
			logger.info("the percentage incresed is 15%");
			Click_candskillinfotab();
			Waitfor(2);
			Save_Cand_Skillsinfo();
			driver.findElement(By.xpath("//div[contains(.,'XSkills Info is saved successfully')]"));
			Waitfor(2);	
			 ObjectInitClass.EOB. skill_info_tab_captrue();
			Waitfor(2);	
			logger.info("the percentage incresed is 10%");
			
	}
		public void My_Lynx()
	    {
	    	WebElement lynx= driver.findElement(By.xpath("//a[contains(.,'My Lynx')]"));
	    	lynx.click();
	    	Waitfor(2);
	    }	
	public void RMGvalidate_FinanceDocs()
	{
		Aadhar_Downloadlink.click();
		Waitfor(2);
		Aadhar_Rejectbutton.click();
		Waitfor(2);
		Aadhar_Rejectcomments.sendKeys("Rejecting comments");
		Waitfor(1);
		Aadhar_Rejecting_Button.click();
		Waitfor(1);
		PAN_Downloadlink.click();
		Waitfor(2);
		PAN_Rejectbutton.click();
		Waitfor(2);
		PAN_Rejectcomments.sendKeys("Rejecting comments");
		Waitfor(1);
		PAN_Rejecting_Button.click();
		Waitfor(1);
		UAN_Downloadlink.click();
		Waitfor(2);
		UAN_Rejectbutton.click();
		Waitfor(2);
		UAN_Rejectcomments.sendKeys("Rejecting comments");
		Waitfor(1);
		UAN_Rejecting_Button.click();
		Waitfor(1);
		
		
	}
	public void RMGvalidate_eduinfodocs()
	{
		RMGEdc_docdownloadlink.click();
		Waitfor(2);
		RMGEdc_docrejectbutton.click();
		Waitfor(2);
		RMGedc_Rejectdoc_Comments.sendKeys("Education docs are rejected");
		Waitfor(2);
		RMGedcdocs_Rejecting_Button.click();
		Waitfor(1);
	}
	public void RMGvalidate_expinfodocs()
	{
		RMGExp_docdownloadlink.click();
		Waitfor(2);
		RMGExp_docrejectbutton.click();
		Waitfor(2);
		RMGExp_Rejectdoc_Comments.sendKeys("Education docs are rejected");
		Waitfor(2);
		RMGExpdocs_Rejecting_Button.click();
		Waitfor(1);
	}
	public void RMGaccept_alldocs()
	{
		RMGAccept_Button.click();
		Waitfor(2);
		
	}
	public void candidate_logout()
	{
		Dynamic_user.click();
		Waitfor(1);
		Dynamic_userlogout.click();
		Waitfor(2);
	}
	
	public void rmg_login()
	{
	// Read Excel object creation to pass the sheet parameter.
		
		String username= excelreaddata().getData("Login_Credentials", 3, 0 ); //Reading Username from excel
		Waitfor(1);
		String password= excelreaddata().getData("Login_Credentials", 3, 1 ); //Reading Password from excel
		Waitfor(1);
	
		 ObjectInitClass.LP.signIn(username, password);
		Waitfor(3);

	}
	
	public String getemp_ID()
	{
		return EMPID;
	}

	

}

