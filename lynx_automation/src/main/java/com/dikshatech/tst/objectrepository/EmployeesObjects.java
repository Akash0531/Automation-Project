package com.dikshatech.tst.objectrepository;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;

public class EmployeesObjects extends TestBase 
{
	@Test
	public EmployeesObjects (WebDriver driver)
	{
		this.driver = driver;		
		
	}

	@FindBy(xpath="//a[contains(.,'RMG')]")        			    WebElement RMG_Menu;
	//General Info Details
	@FindBy(xpath="//li[@id='employee-menu']")        			WebElement Employees_Submenu;
	@FindBy(xpath="//button[@data-original-title='New']") 		WebElement Newemployee_Button;
	@FindBy(xpath="//button[@onclick='empPhotoUpload()']") 		WebElement picture_upload_Button;
	@FindBy(xpath="//input[@id='uploadfileName']") 		        WebElement picture_browse_Button;
	@FindBy(xpath="//button[@id='picuploadonboardEmp']") 		WebElement upload_picture_Button;
	@FindBy(xpath="//select[@id='gen_company']") 		        WebElement Company_Dropdown;
	@FindBy(xpath="//select[@id='gen_region']")    			    WebElement Region_Dropdown;
	@FindBy(xpath="//select[@id='gen_location']") 				WebElement Location_Dropdown;
	@FindBy(xpath="//select[@id='gen_dept']") 					WebElement Department_Dropdown;
	@FindBy(xpath="//select[@id='gen_division']")	 			WebElement Division_Dropdwon;
	@FindBy(xpath="//select[@id='gen_category']") 				WebElement Category_Dropdwon;
	@FindBy(xpath="//select[@id='gen_level']") 					WebElement Level_Dropdown;
	@FindBy(xpath="//select[@id='gen_designation']") 			WebElement Designation_Dropdown;
	@FindBy(xpath="//select[@id='gen_rm']") 					WebElement Reportingmanager_Dropdown;
	@FindBy(xpath="//select[@id='gen_spoc']") 					WebElement Spoc_Dropdwon;
	@FindBy(xpath="//select[@id='gen_projects']") 				WebElement Project_Dropdown;
	@FindBy(xpath="//button[@onclick='empPhotoUpload()']") 		WebElement Employee_Image_upload;	
	@FindBy(xpath="//input[@id='gen_empid']") 					WebElement Employee_ID;
	@FindBy(xpath="//input[@id='gen_firstname']") 				WebElement Employee_FirstName;
	@FindBy(xpath="//input[@id='gen_middlename']") 				WebElement Employee_MiddileName;
	@FindBy(xpath="//input[@id='gen_lastname']") 				WebElement Employee_LastName;
	@FindBy(xpath="//input[@id='gen_maidenname']") 				WebElement Employee_MaidenName; 
	@FindBy(xpath="//input[@id='gen_nationality']") 			WebElement Nationality;
	@FindBy(xpath="//input[@id='gen_gender_male']") 			WebElement Gender_Male_Radio_button;
	@FindBy(xpath="//input[@id='gen_gender_female']") 			WebElement Gender_FeMale_Radio_button;
	@FindBy(xpath="//input[@id='gen_dob']") 					WebElement DateofBirth;
	@FindBy(xpath="//input[@id='gen_officialemail']") 			WebElement Official_Emailid;
	@FindBy(xpath="//input[@id='gen_doj']") 					WebElement Dateof_Joining;
	@FindBy(xpath="//input[@id='gen_notice']") 					WebElement Notice_Period;
	@FindBy(xpath="//select[@id='gen_emptype']") 				WebElement Employeetype_Dropdown;
	@FindBy(xpath="//select[@id='gen_employmenttype']") 		WebElement Employmenttype_Dropdown;
	@FindBy(xpath="//input[@id='gen_chkBox']") 					WebElement ExtendProbation_Checkbox;
	@FindBy(xpath="//input[@id='gen_personalcontact']") 		WebElement PersionalContactName;
	@FindBy(xpath="//input[@id='gen_professionalcontact']") 	WebElement ProffestoinalConatcName;
	@FindBy(xpath="//select[@id='gen_role']") 					WebElement Role_Dropdown;
	@FindBy(xpath="//button[@id='gen_save']") 					WebElement Save_Button;
	
	//Employee Personal Info Objects Repository
	@FindBy(xpath="//a[@href='#new_empper']") 					WebElement Personalinfo_Tab;
	@FindBy(xpath="//textarea[@id='per_permanentaddr']") 		WebElement Permanant_Address;
	@FindBy(xpath="//input[@id='per_percity']") 				WebElement Permanant_City;
	@FindBy(xpath="//input[@id='per_perpincode']") 				WebElement Permanant_Pincode;
	@FindBy(xpath="//*[@id='per_perstate']") 				WebElement Permanant_State;
	@FindBy(xpath="//select[@id='per_percountry']") 			WebElement Country_Dropdown;
	//current adress
	@FindBy(xpath=".//*[@id='new_empper']/div[1]/div/div[2]/div[1]/div[2]/label/span") 						WebElement Sameaspermanantaddress_checkbox;
	@FindBy(xpath="//textarea[@id='per_currentaddr']") 			WebElement Current_Address;
	@FindBy(xpath="//input[@id='per_curcity']") 				WebElement Current_City;
	@FindBy(xpath="//input[@id='per_curpincode']") 				WebElement Current_Pincode;
	@FindBy(xpath="//input[@id='per_curstate']") 				WebElement Current_State;
	@FindBy(xpath="//select[@id='per_curcountry']") 			WebElement Current_Country_Dropdown;
	
	//contact numbers
	@FindBy(xpath="//input[@id='per_priphonenum']") 			WebElement Primary_Phonenumber;
	@FindBy(xpath="//input[@id='per_secphonenum']") 			WebElement Secondary_Phonenumber;
	@FindBy(xpath="//input[@id='per_personalemail']") 			WebElement Personal_EmailID;
	@FindBy(xpath="//input[@id='per_alternateemail']") 			WebElement Alternative_EmailId;
	@FindBy(xpath="//input[@id='per_personalcontact']") 		WebElement Emrg_Contanct_Name;
	@FindBy(xpath="//input[@id='per_personalrel']") 			WebElement Emrg_Relationship;
	@FindBy(xpath="//input[@id='per_personalphonenum']") 		WebElement Emrg_Phonenumber;
	//references
	@FindBy(xpath="//input[@id='gen_personalcontact']") 		WebElement Personal_ContactName;	
	@FindBy(xpath="//input[@id='gen_personalrel']") 			WebElement Personal_Relatetionship;	
	@FindBy(xpath="//input[@id='gen_personalphonenum']") 		WebElement Persional_Phonenumber;
	@FindBy(xpath="//input[@id='gen_personalemailId']") 		WebElement Persional_EmailID;
	@FindBy(xpath="//input[@id='gen_professionalcontact']") 	WebElement Professional_ContactName;
	@FindBy(xpath="//input[@id='gen_professionalDesignation']") WebElement Professional_Designation;
	@FindBy(xpath="//input[@id='gen_professionalphonenum']") 	WebElement Professional_PhoneNumber;	
	@FindBy(xpath="//input[@id='gen_professionalEmailId']") 	WebElement Professional_EmailID;
	//family
	@FindBy(xpath="//input[@id='per_mothername']") 				WebElement Mothers_Name;
	@FindBy(xpath="//input[@id='emp_per_motherDOB']") 			WebElement Mothers_DOB;
	@FindBy(xpath="//input[@id='per_fathername']") 				WebElement Fathers_Name;
	@FindBy(xpath="//input[@id='emp_per_fatherDOB']") 			WebElement Fathers_DOB;
	@FindBy(xpath=".//*[@id='new_empper']/div[1]/div/div[2]/div[12]/div[2]/label[1]/span")	WebElement Martial_Status_Single_Radiobutton;
	@FindBy(xpath=".//*[@id='new_empper']/div[1]/div/div[2]/div[12]/div[2]/label[2]/span") 	WebElement Martial_Status_Married_Radiobutton;
	@FindBy(xpath="//input[@id='per_spousename']") 				WebElement Spouse_Name;
	@FindBy(xpath="//input[@id='per_spouseDOB']") 				WebElement SpouseDOB;
	@FindBy(xpath="//button[@onclick='addChildrenRowEmp()']") 	WebElement Add_Chaild_button;
	@FindBy(xpath=".//*[@id='emp_child_add_data']/td[1]/select")WebElement MaleorFemale_DD;
	@FindBy(xpath="//input[@id='emp_child_name']") 				WebElement Chaild_Name;
	@FindBy(xpath="//input[@id='dp1526294414638']") 			WebElement Chaild_DOB;
	@FindBy(xpath="//button[@id='per_save']") 			        WebElement save_personaltab;
	
	// EMployee Nominee Info Objects Repository
	
	@FindBy(xpath="//a[@href='#new_empnom']") 					    WebElement Nominee_Info_Tab;
	@FindBy(xpath="//input[@id='nomineename']") 					WebElement Nominee_Name;
	@FindBy(xpath="//input[@id='nomineerelationship']") 			WebElement Nominee_Relationship;
	@FindBy(xpath="//input[@id='nomineecontact']") 					WebElement Nominee_Contactno;
	@FindBy(xpath="//input[@id='nom_depname']") 					WebElement Dependent_Name;
	@FindBy(xpath="//input[@id='nom_deprelation']") 				WebElement Dependent_Relationship;
	@FindBy(xpath="//button[@onclick='addDependentsRow()']") 	    WebElement Add_DependantsIcon;
	@FindBy(xpath="//a[@sectionid='mylynx3']") 						WebElement Remove_DependantsIcon;
	@FindBy(xpath="//button[@id='savenomineeinfo']") 				WebElement Save_Nominee;
	@FindBy(xpath="//button[@id='empDeclarationForm2']") 			WebElement Emp_declaration_Form2_upd;
	@FindBy(xpath="//button[@id='empDeclarationForm11']") 			WebElement Emp_declaration_Form11_upd;
	@FindBy(xpath="//button[@id='empDeclarationUAN']") 				WebElement Emp_UANForm_upd;
	@FindBy(xpath="//button[@title='Download Form 2']") 			WebElement Emp_Form2_dwnload;
	@FindBy(xpath="//button[@id='empDeclarationFormPreview']") 		WebElement Emp_Form2_Preview;
	@FindBy(xpath="//input[@id='uploadfileName']") 					WebElement Emp_Form2_browse;
	@FindBy(xpath="//textarea[@id='upload_comment']") 				WebElement Emp_Form2_comments;
	@FindBy(xpath="//button[@id='emp_AadharUpload']") 				WebElement Emp_Form2_uploadingbutton;
	@FindBy(xpath="//button[@title='Download Form 11']") 			WebElement Emp_Form11_dwnld;
	@FindBy(xpath=".//*[@id='new_empnom']/div[1]/div[8]/button[2]") WebElement Emp_Form11_Preview;
	@FindBy(xpath="//button[@title='Download UAN']") 				WebElement Emp_UAN_Form_download;
	@FindBy(xpath=".//*[@id='new_empnom']/div[1]/div[9]/button[2]") WebElement Emp_UAN_Form_Preview;
	@FindBy(xpath="//input[@id='uploadfileName']") 					WebElement Emp_UAN_Form_browse;
	@FindBy(xpath="//textarea[@id='upload_comment']") 				WebElement Emp_UAN_Form_comments;
	@FindBy(xpath="//button[@id='emp_AadharUpload']") 				WebElement Emp_UAN_Form_uploadingbutton;
	
	// EMployee Financial Info Objects Repository
	
	@FindBy(xpath="//a[@href='#new_empfin']") 						WebElement FinancialInfo_Tab;
	@FindBy(xpath="//input[@id='fin_pf']") 	 						WebElement PF_Number;
	@FindBy(xpath="//input[@id='fin_aadhar']") 						WebElement Addahar_Number;
	@FindBy(xpath="//button[@id='empAadhaarUpload']") 				WebElement Emp_Aadhar_upload;
	@FindBy(xpath="//input[@id='uploadfileName']") 					WebElement Emp_Aadhar_browse;
	@FindBy(xpath="//textarea[@id='upload_comment']") 				WebElement Emp_Aadhar_comments;
	@FindBy(xpath=".//*[@id='emp_AadharUpload']") 					WebElement Emp_Aadhar_uploadingbutton;	
  //Pan uploading
	@FindBy(xpath="//input[@id='fin_pan']") 						WebElement PAN_Number;
	@FindBy(xpath="//button[@id='empPanUpload']") 					WebElement Emp_PAN_upload;
	@FindBy(xpath="//input[@id='uploadfileName']") 					WebElement Emp_PAN_browse;
	@FindBy(xpath="//textarea[@id='upload_comment']") 				WebElement Emp_PAN_comments;
	@FindBy(xpath="//button[@id='emp_AadharUpload']") 				WebElement Emp_PAN_uploadingbutton;
	//UAN DETAILS
	@FindBy(xpath="//input[@id='fin_uan']") 						WebElement UAN_Number;
	@FindBy(xpath="//button[@id='empUanUpload']") 					WebElement Emp_UAN_upload;
	@FindBy(xpath="//input[@id='uploadfileName']") 					WebElement Emp_UAN_browse;
	@FindBy(xpath="//textarea[@id='upload_comment']") 				WebElement Emp_UAN_comments;
	@FindBy(xpath="//button[@id='emp_AadharUpload']") 				WebElement Emp_UAN_uploadingbutton;
	//PREVIEW
	@FindBy(xpath=".//*[@id='new_empfin']/div[1]/div[1]/div[1]/div[3]/button[3]") WebElement Emp_Aadhar_Preview;
	@FindBy(xpath=".//*[@id='new_empfin']/div[1]/div[1]/div[1]/div[5]/button[3]") WebElement Emp_PAN_Preview;
	@FindBy(xpath=".//*[@id='new_empfin']/div[1]/div[1]/div[1]/div[7]/button[3]") WebElement Emp_UAN_Preview;
	
	//salary details
	@FindBy(xpath="//select[contains(@id,'compare')]")              WebElement salary_compare;
	@FindBy(xpath="//input[@id='fin_primaryBank']") 				WebElement PrimaryBank_Name;
	@FindBy(xpath="//input[@id='fin_primaryAccNo']") 				WebElement PrimaryBank_AccountNumber;
	@FindBy(xpath="//input[@id='fin_secBank']") 					WebElement SecondaryBank_Name;
	@FindBy(xpath="//input[@id='fin_secAccNo']") 					WebElement SecondaryBank_AccountNumber;
	@FindBy(xpath="//input[@id='fin_primaryIfsc']") 				WebElement Primary_IFSC_Code;
	@FindBy(xpath="//input[@id='fin_secIfsc']") 					WebElement Secondary_IFSC_Code;
	
	//salary advance
	@FindBy(xpath="//input[@id='fin_salAdvanceTotal']") 			WebElement SalaryinAdvance_TotalAmount;
	@FindBy(xpath="//input[@id='fin_salMonDed']") 					WebElement SalaryinAdvance_Monthly_Deduction;
	@FindBy(xpath="//span[@id='fin_salbanlaceMonths']") 			WebElement salbanlaceMonths;
	@FindBy(xpath="//span[@id='fin_salbanlaceAmt']") 				WebElement salbanlace_amount;
	@FindBy(xpath="//input[@id='fin_salDedInSal']") 				WebElement advance_deduct_sal;
	@FindBy(xpath="//input[@id='fin_salDedInPer']") 				WebElement advance_deduct_per;
	
	
	@FindBy(xpath="//input[@id='fin_travAdvTotal']") 				WebElement TravelTotalAmount;
	@FindBy(xpath="//input[@id='fin_travMonDed']") 					WebElement TravelMonthlyDeduction;
	@FindBy(xpath="//span[@id='fin_travbanlaceAmt']") 			    WebElement travel_balance_amount;
	@FindBy(xpath="//span[@id='fin_travbalanceMonths']") 			WebElement travel_balance_month;
	
	@FindBy(xpath="//input[@id='fin_perAdvTotal']") 				WebElement PerdiemAdvance_TotalAmount;
	@FindBy(xpath="//select[@id='fin_perTerm']") 					WebElement Perdiem_Terms_Dropdown;
	@FindBy(xpath="//input[@id='fin_perMonDed']") 					WebElement Amount_Term_Deduction;
	@FindBy(xpath="//select[@id='fin_SalaryCycle']") 				WebElement SalaryCycle_Dropdown;
	@FindBy(xpath=".//*[@id='new_empfin']/div[1]/div/div[1]/div[40]/div[2]/label[1]") 					WebElement Employee_Active_Radiobutton;
	@FindBy(xpath="//textarea[@id='clause_name']")                  WebElement Employee_clause;
	
	@FindBy(xpath="//input[@id='fin_oldSU']") 						WebElement Salarystackup_Old_Radiobutton;
	@FindBy(xpath="//input[@id='fin_newSU']") 						WebElement Salarystackup_New_Radiobutton;
	@FindBy(xpath="//input[@id='fin_ctcAmount']") 					WebElement Current_CTC;
	@FindBy(xpath="//input[@id='fin_effectiveFrom']") 				WebElement CTCEffectedDate;
	@FindBy(xpath="//input[@id='fin_plb']") 						WebElement Total_Linked_perfomamance_Bonus;
	@FindBy(xpath="//input[@id='fin_fixedPerdiemCheck']") 			WebElement FixedPerdiem_Checkbox;
	@FindBy(xpath="//input[@id='fin_fixedPerdiemAmt']") 			WebElement FixedPerdiem_Amount;
	@FindBy(xpath="//input[@id='fin_fixedPerdiemFrom']")            WebElement FixedPerdiem_From;
	@FindBy(xpath="//input[@id='fin_fixedPerdiemTo']")              WebElement FixedPerdiem_To;
	
	@FindBy(xpath="//input[@id='fin_perDiemPerDayCheck']") 			WebElement VarPerdiem_Checkbox;
	@FindBy(xpath="//input[@id='fin_perDiemPerDay']") 				WebElement VarPerdiem_Amount;
	@FindBy(xpath="//*[@id='fin_perDiemPerDayFields']/div[2]/div[2]/select") WebElement VarPerdiem_CurrencyType;
	@FindBy(xpath="//input[@id='fin_perDiemPerDayFromDate']") 		WebElement VarPerdiem_From;
	@FindBy(xpath="//input[@id='fin_perDiemPerDayToDate']") 		WebElement VarPerdiem_To;
	@FindBy(xpath="//input[@id='fin_perDiemPerDayToDate']") 		WebElement Esic_Radiobutton_Yes;
	@FindBy(xpath="//input[@id='esic_no']") 						WebElement Esic_Radiobutton_No;
	@FindBy(xpath="//input[@id='fin_qplbper']")						WebElement QPLB;
	@FindBy(xpath="//input[@id='fin_aplbper']")						WebElement APLB;	
	@FindBy(xpath="//*[@id='oldStackupFields']/div[1]/div[1]/div[2]/label[1]/span[1]") 	WebElement RetentionBonus_Checkbox;
	@FindBy(xpath="//input[@id='fin_retensionBonus']") 				WebElement Retention_bonus;
	@FindBy(xpath="//select[@id='fin_retensionBonusInstallments']") WebElement RetentionBonus_installments_Dropdown;
	@FindBy(xpath="//input[@id='fin_effectiveFromDate']") 			WebElement EffectFrom_Datepicker;
	
	@FindBy(xpath=".//*[@id='new_empfin']/div[1]/div[1]/div[2]/div[13]/div[2]/label/span") 	WebElement JoiningBonus_Checkbox;
	@FindBy(xpath="//input[@id='emp_fin_joiningBonusAmt']") 				WebElement Joining_bonus;
	@FindBy(xpath="//select[@id='emp_fin_joiningBonusInstallments']") 		WebElement JoiningBonus_installments_Dropdown;	
	@FindBy(xpath=".//*[@id='new_empfin']/div[1]/div[1]/div[2]/div[15]/div[2]/label/span") 	WebElement RelocationBonus_Checkbox;
	@FindBy(xpath="//input[@id='emp_fin_relocationBonusAmt']") 				WebElement Relocation_bonus;
	@FindBy(xpath="//select[@id='emp_fin_relocationBonusInstallments']") 	WebElement RelocationBonus_installments_Dropdown;
	@FindBy(xpath="//button[@id='save_finance_info']") 						WebElement SaveFinanceInfo;
	
	// EMployee Passport Info Objects Repository
	
	@FindBy(xpath="//a[@href='#new_emppas']")						 WebElement PassportInfo_Tab;
	@FindBy(xpath="//input[@id='passport_pasname']")				 WebElement Given_Name;
	@FindBy(xpath="//input[@id='passport_surname']") 				 WebElement Surname1;
	@FindBy(xpath="//input[@id='passport_pasnum']") 	  			 WebElement Passport_Number;
	@FindBy(xpath="//input[@id='passport_doi']") 					 WebElement Dateof_Issue_Datepicker;
	@FindBy(xpath="//input[@id='passport_doe']") 					 WebElement Dateof_Expiry_Datepicker;
	@FindBy(xpath="//input[@id='passport_poi']") 					 WebElement Placeof_Issue;
	@FindBy(xpath="//input[@id='passport_pob']") 					 WebElement Placeof_birth;
	@FindBy(xpath="//button[@onclick='uploadPassportDocument()']") 	 WebElement Passport_Upload_Button;
	@FindBy(xpath="//input[@id='uploadfileName']") 					 WebElement Passport_Browse_Button;
	@FindBy(xpath="//textarea[@id='upload_comment']") 				 WebElement Passport_Comments;
	@FindBy(xpath="//button[@id='employee_uploadPassportDoc']") 	 WebElement Passport_Uploading_Button;
	
	//visa details
	
	@FindBy(xpath="//button[@onclick='addVisaDetailsRow()']") 		WebElement Visa_Addrows_Button;
	@FindBy(xpath="//input[@id='passport_visaType']") 				WebElement Visa_Type;
	@FindBy(xpath="//input[@id='passport_visaCountry']") 			WebElement Visa_Country;
	@FindBy(xpath=".//*[@id='passport_add_visaDetails']/tbody/tr/td[7]") WebElement Visa_Start_Date;
	@FindBy(xpath=".//*[@id='passport_add_visaDetails']/tbody/tr/td[11]")WebElement Visa_End_Date;
	@FindBy(xpath="//button[@id='save_passport_info']") 			WebElement SavePassortDeatils;
	
	// EMployee Educational Info Objects Repository
	
	@FindBy(xpath="//a[@href='#new_empedu']") 			                WebElement EducationInfo_Tab;
	@FindBy(xpath="//button[@onclick='addEmployeeEducationInfo()']")    WebElement Educationinfo_Add_Button;
	@FindBy(xpath=".//*[@id='123456']/tr[1]/td[4]/select") 	            WebElement Emp_DegreeName;
	@FindBy(xpath="//input[@placeholder='Enter Subject']") 				WebElement Emp_SubjectMajor;
	@FindBy(xpath="//input[@placeholder='Enter Year of Passing']") 		WebElement Emp_YearofPassing;
	@FindBy(xpath="//input[@placeholder='Enter Student ID']")			WebElement Emp_StudentID;
	@FindBy(xpath="//textarea[@placeholder='Enter College Name']") 		WebElement Emp_CollegeName;
	@FindBy(xpath="//input[@id='educationGraduationDate']") 			WebElement Emp_Graduationdatepicker;
	@FindBy(xpath="//input[@id='educationStartDate']")					WebElement Emp_Startdate;
	@FindBy(xpath="//input[@placeholder='Enter Grade']") 				WebElement Emp_Grade;
	@FindBy(xpath=".//*[@id='123456']/tr[3]/td[13]/button")				WebElement Upload_Education_Documents_Button;
	@FindBy(xpath="//button[@title='Reject Document']]") 				WebElement Emp_eduReject_button;
	@FindBy(xpath="//button[@onclick='addEduGapRowemp()']") 			WebElement Emp_AddEduGap_Button;
	@FindBy(xpath="//input[@id='emp_edugap']") 				            WebElement EnterEmp_Educationgap;
	@FindBy(xpath=".//*[@id='94781']/tr/td[3]") 				        WebElement EmpEdu_GapFrom;
	@FindBy(xpath=".//*[@id='94781']/tr/td[5]") 					    WebElement EmpEdu_GapTo;
	@FindBy(xpath="//input[@id='emp_edugap_reason']") 					WebElement EmpEdu_GapReason;
	@FindBy(xpath=".//*[@id='94781']/tr/td[8]") 				        WebElement EmpEduGap_RemoveButton;
	@FindBy(xpath="//button[@onclick='addTrainingRowemp()']") 			WebElement Emp_TrainingAdd_Button;
	@FindBy(xpath="//input[@id='emp_train_institute']") 				WebElement EmpEnter_Institute;
	@FindBy(xpath="//input[@id='emp_train_course']") 					WebElement EmpEnter_Course;
	@FindBy(xpath="//input[@id='emp_train_rank']") 						WebElement EmpEnter_Rank;
	@FindBy(xpath="//input[@placeholder='Enter Grade']") 				WebElement EmpEnterYear_of_Completion;
	@FindBy(xpath="//input[@id='emp_yearofcomp']") 						WebElement EmpTraining_Remove_Button;
	@FindBy(xpath=".//*[@id='123456']/tr[3]/td[13]/button") 			WebElement Emp_edu1_upload;
	@FindBy(xpath="//input[@id='uploadfileName']") 						WebElement Emp_edu1_browse;
	@FindBy(xpath="//textarea[@id='upload_comment']") 					WebElement Emp_edu1_comments;
	@FindBy(xpath="//button[@id='emp_uploadEduDoc']") 		  			WebElement Emp_edu1_uploadingbutton;
	@FindBy(xpath="//textarea[@id='empAadharRejCom']") 					WebElement RMGedc_Rejectdoc_Comments;
	@FindBy(xpath="//button[@id='empEduReject']") 						WebElement RMGedcdocs_Rejecting_Button;
	@FindBy(xpath="//button[@id='save_eduinfo']") 						WebElement Edu_SaveButtn;
	
	// EMployee Experience Info Objects Repository
	 
	@FindBy(xpath="//a[@href='#new_empexp']") 				            WebElement Experienceinfo_Tab;
	@FindBy(xpath="//select[@id='expType']") 							WebElement Experience_SelectType_Dropdown;
	
	     // For First Company 
	@FindBy(xpath="//button[@onclick='addExperienceInfo()']") 		    WebElement ADDNextCompyBtn;
	@FindBy(xpath="//input[@placeholder='Enter Company']") 	            WebElement Company_Name;
	@FindBy(xpath="//input[@class='employeeExpInfoDesEmpCode']") 	    WebElement Employee_Id;
	@FindBy(xpath=".//*[@id='76111']/tr[3]/td[3]/select") 				WebElement Employement_Type_Dropdwon;
	@FindBy(xpath="//input[@placeholder='Enter Date of Joining']") 	    WebElement Dateof_Joining_Datepicker;
	@FindBy(xpath="//input[@placeholder='Enter Designation on Joining']")WebElement Designationon_Joining_Datepicker;
	@FindBy(xpath="//input[@placeholder='Enter Reported To']")          WebElement Reported_ToNameofPostion;
	@FindBy(xpath="//input[@placeholder='Enter Name of HR Manager']")	WebElement Nameof_HR_Manager;
	@FindBy(xpath="//input[@placeholder='Enter Date of Relieving']") 	WebElement Dateof_Releaving_Datepicker;
	@FindBy(xpath="//input[@placeholder='Enter Designation on Leaving']")WebElement Designationon_Leaving;
	@FindBy(xpath="//input[@placeholder='Enter Reason for Leaving']") WebElement Reasonfor_Leaving;
	@FindBy(xpath="//table[@id='experience_info']/tbody/tr[3]/td[9]/button") WebElement UploadRelatedDocmnet;
	 
	//EMployee Gap duration objects
	
	@FindBy(xpath="//button[@onclick='addEmpGapRowEmp()']") 		WebElement Emp_Gap_AddButton;
	@FindBy(xpath="//input[@id='empGapFromDateEmp']")				WebElement Emp_Gap_Fromdate;
	@FindBy(xpath="//input[@id='empGapToDateEmp']")					WebElement Emp_Gap_Todate;
	@FindBy(xpath="//input[@id='eduEmpGapReasonEmp']") 				WebElement Empedu_GapReason;
	@FindBy(xpath="//button[@id='saveExperienceInfo']") 			WebElement Experience_SaveButtn;
	
	// EMployee Skill Info Objects Repository
	
	@FindBy(xpath="//a[@href='#new_empskillstab']")			 		WebElement Skillsinfo_Tab;
	@FindBy(xpath="//button[@id='empProfileUpload']") 				WebElement Emp_Profile_uploadbutton;	
	@FindBy(xpath=".//*[@id='new_empskillstab']/div[1]/div[1]/button[2]") WebElement Emp_Profile_Preview;
	
	@FindBy(xpath="//input[@id='otherSkills']") 					WebElement Other_Skills;
	@FindBy(xpath="//button[@onclick='saveSkills()']") 				WebElement saveskills;
	
	@FindBy(xpath="//input[@id='checkThisSkill_3']") 				WebElement PeopleSoftCRMchckbOX;
	@FindBy(xpath="//input[@id='checkThisSkill_49']") 				WebElement CustmerCaseCheckBox;
	@FindBy(xpath="//a[@sectionid='mylynx3']") 						WebElement NeyworkCheckBox;
	@FindBy(xpath="//a[@sectionid='mylynx3']") 						WebElement ITInfrProfessional_EmailIDaCheckBox;
	
	@FindBy(xpath="//a[@href='#new_empBgVerificationDoc']")			WebElement AddBGC_Document_tab;
	@FindBy(xpath="//button[@onclick='addUploadBVRow()']")			WebElement AddBGC_Document_button;
	//edit employee
	@FindBy(xpath="//button[@id='employee_edit']") 					WebElement Employee_Edit_Button;
	@FindBy(xpath="//button[@onclick='generateEmpId()']") 			WebElement Generate_EmployeeId_Button;
	@FindBy(xpath="//button[@id='employee_separate']") 				WebElement Employee_Seperate_Button;
	@FindBy(xpath="//button[@id='employee_abscond']") 				WebElement Employee_Abscond_Button;
	
	@FindBy(xpath="//textarea[@id='upload_comment']") 				WebElement Seperate_Confirmation_comments;
	@FindBy(xpath="//input[@name='empDateOfSeperation']") 			WebElement Seperate_date;
	@FindBy(xpath="//button[@id='employee_seperateSubmit']") 		WebElement Seperation_Submit_Button;;
	@FindBy(xpath=".//*[@id='genericModal-buttons']/button[2]") 	WebElement Seperation_Close_Button;

	@FindBy(xpath="//input[@name='empDateOfSeperation']") 			WebElement Abscond_Dateofseperation_Datepicker;
	@FindBy(xpath="//button[contains(@id,'abscondSubmit')]") 		WebElement Abscond_Submit_Button;
	@FindBy(xpath=".//*[@id='genericModal-buttons']/button[2]") 	WebElement Abscond_Cancel_Button;
	
	//Editing the employee information

	@FindBy(xpath="//button[@id='employee_exportleaves']") 			WebElement Export_Leaves;
	@FindBy(xpath="//button[@id='employee_importleaves']") 			WebElement Import_Leaves;
	@FindBy(xpath="//textarea[@id='upload_comment']") 				WebElement Import_LeavesCommts;
	@FindBy(xpath="//button[@id='employee_uploadLeaves']") 			WebElement UploadBttn_LeavesCommts;
	
	@FindBy(xpath="//button[@id='employee_uploadFBP']") 			WebElement Upload_FBP;
	@FindBy(xpath="//textarea[@id='upload_comment']") 				WebElement Upload_FBP_Commts;
	@FindBy(xpath=".//*[@id='employee_uploadFBP']")                 WebElement Upload_FBPSubmitBttn;
	
	@FindBy(xpath="//button[@id='employee_uploadTBD']") 			WebElement Upload_TaxBenfit_Declaration;
	@FindBy(xpath="//textarea[@id='upload_comment']") 				WebElement Upload_TBD_Comments;
	@FindBy(xpath="//button[@id='employee_uploadTBD']") 			WebElement Upload_TBD_Uploadbttn;
	
	//Chnaging Employee Reporting Manager
	
	@FindBy(xpath="//button[@id='employee_changeRM']") 				WebElement ChnageReporting_Manager;
	@FindBy(xpath="//select[@id='rm']") 							WebElement Select_RM_DD;
	@FindBy(xpath="//select[@id='newrm']") 				            WebElement Select_NewRM_DD;
	@FindBy(xpath="//input[@id='select_all']")                      WebElement SelectEmpID_chkbox;
	@FindBy(xpath="//button[@id='updateChangeRM']")                 WebElement RMupdate_Button;
	
	//Changing Employee SPOC
	
	@FindBy(xpath="//button[@id='employee_changeSPOC']")		 	WebElement Change_SPOC;
	@FindBy(xpath="//select[@id='spoc']") 							WebElement Select_SPOC_DD;
	@FindBy(xpath="//select[@id='newspoc']") 						WebElement Select_NewSPOC_DD;
	
//	@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement SelectEmpID_chkboxTo_SPOC;
//	@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement RMupdate_ButtonTo_SPOC;
	//textarea[@id='upload_comment']
	@FindBy(xpath="//button[@id='employee_exportDelayed']") 		WebElement Export_Delayed_Button;
	@FindBy(xpath="//button[@id='employee_markascomplete']") 		WebElement Markas_completeButton;
	@FindBy(xpath="//button[@id='employee_markasincomplete']") 		WebElement Markas_In_completeButton;
	@FindBy(xpath="//button[@id='employee_internal']") 				WebElement Download_Report;
	@FindBy(xpath="//input[@type='search']")                        WebElement Employees_SearchInput;
	@FindBy(xpath="//div[@id='myBarEmployee']")                     WebElement progresssbar;   
	
	
	public void Click_EmployeesMenu()
	{
		RMG_Menu.click();
		Waitfor(2);
		Employees_Submenu.click();
		Waitfor(20);
	}
	public void Click_New_employee()
	{
		Newemployee_Button.click();
		Waitfor(4);	
	}		
	public void Create_New_Employee (String Company_Name, String Region_Name,String Location_Name, String Department_Name,String Category_Name, String Level_Name, 
		String Designation,String Reporting_ManagerName,String SPOCNAME,String Project_Name, String Emp_Firstname,
			String Emp_Lastname, int DOB_Date, String OfficialMailID, int DOJ_Date,String NoticePeriod, String Role) 
	{
		
		Click_EmployeesMenu();
		Waitfor(2);	
		 Click_New_employee();
		 Waitfor(4);
		picture_upload_Button.click();
		Waitfor(2);
		picture_browse_Button.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
		Waitfor(2);
		upload_picture_Button.click();
		Waitfor(2);
		
		Select CompanyDD = new Select(Company_Dropdown);		
		Waitfor(1);	
		CompanyDD.selectByVisibleText(Company_Name);
		logger.info("The Selected Company Name is "+Company_Name);
		Waitfor(2);
		Select RegionDD = new Select(Region_Dropdown);
		Waitfor(1);	
		RegionDD.selectByVisibleText(Region_Name);
		logger.info("The Selected Region is "+Region_Name);
		Waitfor(2);
		Select LocationDD = new Select(Location_Dropdown);
		Waitfor(1);	
		LocationDD.selectByVisibleText(Location_Name);
		logger.info("The Selected Location Name is "+Location_Name);
		Waitfor(2);
		Select DepartmentDD = new Select(Department_Dropdown);
		Waitfor(1);	
		DepartmentDD.selectByVisibleText(Department_Name);
		logger.info("The Selected Department Name is "+Location_Name);
		Waitfor(2);
		Select CategoryDD = new Select(Category_Dropdwon);
		Waitfor(1);	
		CategoryDD.selectByVisibleText(Category_Name);
		logger.info("The Selected Category is "+Category_Name);
		Waitfor(2);
		Select LevelDD = new Select(Level_Dropdown);
		Waitfor(1);	
		LevelDD.selectByVisibleText(Level_Name);
		logger.info("The Selected Level is "+Level_Name);
		Waitfor(2);
		Select DesignationDD = new Select(Designation_Dropdown);
		Waitfor(1);	
		DesignationDD.selectByVisibleText(Designation);
		logger.info("The Selected Designation is "+Designation);
		Waitfor(2);
		Select ReporetingManagerDD = new Select(Reportingmanager_Dropdown);
		Waitfor(2);	
		ReporetingManagerDD.selectByVisibleText(Reporting_ManagerName);
		logger.info("The Selected Reporting Manager is "+Reporting_ManagerName);
		Waitfor(2);
		Select SPOCDD = new Select(Spoc_Dropdwon);
		Waitfor(2);	
		SPOCDD.selectByVisibleText(SPOCNAME);
		logger.info("The Selected SPOC Name is "+SPOCNAME);
		Waitfor(2);
		Select ProjectDD = new Select(Project_Dropdown);
		Waitfor(1);	
		ProjectDD.selectByVisibleText(Project_Name);
		logger.info("The Selected Project Name is "+Project_Name);
		Waitfor(2);
		Employee_FirstName.sendKeys(Keys.chord(Keys.CONTROL, "a"),Emp_Firstname);
		logger.info("Employee First Name is "+Emp_Firstname);
		Employee_LastName.sendKeys(Keys.chord(Keys.CONTROL, "a"),Emp_Lastname);
		logger.info("Employee Last Name is"+Emp_Lastname);
		Waitfor(2);
		String Mand_Nationality = Nationality.getText();
		logger.info(Mand_Nationality + "is a Mandatory Field");
		
		boolean status = Gender_Male_Radio_button.isEnabled();
		if(status==false)
		{
			Gender_FeMale_Radio_button.click();
		}
		else
		{
			logger.info("Gender male is already selected");
		}
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
		Official_Emailid.sendKeys(Keys.chord(Keys.CONTROL, "a"),OfficialMailID);
		logger.info("Employee Official emial id is"+OfficialMailID);
		
		Dateof_Joining.click();		
		List<WebElement> DOjdates = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

		int total_dojnodes = DOjdates.size();
		logger.info("Calendar Date size is : " + total_dojnodes);
		for (int i = 0; i < total_dobnodes; i++) {
		String dojdate = DOjdates.get(i).getText();
		if (dojdate.equals(Integer.toString(DOJ_Date))) {
		DOjdates.get(i).click();
		logger.info("Selected date is: " + dojdate);
		break;
			}
		}
		Waitfor(2);	
	Notice_Period.sendKeys(Keys.chord(Keys.CONTROL, "a"),NoticePeriod);
	logger.info("Employee Official email id is"+NoticePeriod);
				
	/*Select EmPloyeeTypeDD = new Select(Employeetype_Dropdown);
	logger.info("The Selected Employee Type is "+Employee_Type);
	Waitfor(1);	
	EmPloyeeTypeDD.selectByVisibleText(Employee_Type);
	
	Select EmployementTypeDD = new Select(Employement_Type_Dropdwon);
	logger.info("The Selected Employement Type is "+Employment_Type);
	Waitfor(1);	
	EmployementTypeDD.selectByVisibleText(Employment_Type);*/

	Select RoleDD = new Select(Role_Dropdown);
	logger.info("The Selected Role is "+Role);
	Waitfor(2);	
	RoleDD.selectByVisibleText(Role);
	Waitfor(2);	
	Generalinfo_Savebutton();
	Waitfor(5);	
	}
	public void EMP_PermanantAddress(String Cand_PerAddress, String Cand_PerCity, String Cand_PerPincode, String Cand_Perstate, String Cand_PermanaentCountry)
	{	
		Personalinfo_Tab.click();
		Waitfor(2);	
		Permanant_Address.sendKeys(Keys.chord(Keys.CONTROL, "a"),Cand_PerAddress);
		Waitfor(2);	
		Permanant_City.sendKeys(Keys.chord(Keys.CONTROL, "a"),Cand_PerCity);
		Waitfor(2);
		Permanant_Pincode.sendKeys(Keys.chord(Keys.CONTROL, "a"),Cand_PerPincode);
		Waitfor(2);
		Select Permanent_Country = new Select(Country_Dropdown);
		logger.info("The Selected Country Name is "+Cand_PermanaentCountry);
		Waitfor(2);	
		Permanent_Country.selectByVisibleText(Cand_PermanaentCountry);
		Waitfor(2);		
		Select Permanent_state = new Select(Permanant_State);
		logger.info("The Selected Country Name is "+Cand_Perstate);
		Waitfor(1);	
		Permanent_state.selectByVisibleText(Cand_Perstate);
		Waitfor(2);	
		Sameaspermanantaddress_checkbox.click();
		Waitfor(2);
	}
public void Employee_ContactNumbers(String Cand_PrimaryPhNo, String Cand_SeconPhNo,String Cand_Mailid, String Cand_AltMailId, String Cand_Emrgcontactname, String Cand_EmRelation, String Cand_EmrgPhonenum,String Bloodgroup)
	
	{
	    Primary_Phonenumber.sendKeys(Keys.chord(Keys.CONTROL, "a"),Cand_PrimaryPhNo);
		Waitfor(2);	
		Secondary_Phonenumber.sendKeys(Keys.chord(Keys.CONTROL, "a"),Cand_SeconPhNo);
		Waitfor(2);	
		Personal_EmailID.sendKeys(Keys.chord(Keys.CONTROL, "a"),Cand_Mailid);
		Waitfor(2);	
		Alternative_EmailId.sendKeys(Keys.chord(Keys.CONTROL, "a"),Cand_AltMailId);
		Waitfor(2);	
	
		Emrg_Contanct_Name.sendKeys(Keys.chord(Keys.CONTROL, "a"),Cand_Emrgcontactname);
		Waitfor(2);
		
		Emrg_Relationship.sendKeys(Keys.chord(Keys.CONTROL, "a"),Cand_EmRelation);
		Waitfor(2);
		
		Emrg_Phonenumber.sendKeys(Keys.chord(Keys.CONTROL, "a"),Cand_EmrgPhonenum);
		Waitfor(2);
			
	}
public void Emp_references(String PerCon_Name, String Percon_Rel, String Per_PhNo,String Per_emailid, String Prof_Contname, String Prof_Desig, String Prof_Phnum, String Prof_mailid)
{
	Waitfor(2);
	Personal_ContactName.sendKeys(Keys.chord(Keys.CONTROL, "a"),PerCon_Name);
	Waitfor(2);
	Personal_Relatetionship.sendKeys(Keys.chord(Keys.CONTROL, "a"),Percon_Rel);
	Waitfor(2);
	Persional_Phonenumber.sendKeys(Keys.chord(Keys.CONTROL, "a"),Per_PhNo);
	Waitfor(2);
	Persional_EmailID.sendKeys(Keys.chord(Keys.CONTROL, "a"),Per_emailid);
	Waitfor(2);
	Professional_ContactName.sendKeys(Keys.chord(Keys.CONTROL, "a"),Prof_Contname);
	Waitfor(2);
	Professional_Designation.sendKeys(Keys.chord(Keys.CONTROL, "a"),Prof_Desig);
	Waitfor(2);
	Professional_PhoneNumber.sendKeys(Keys.chord(Keys.CONTROL, "a"),Prof_Phnum);
	Waitfor(2);
	Professional_EmailID.sendKeys(Keys.chord(Keys.CONTROL, "a"),Prof_mailid);
	Waitfor(2);
	
}
public void EMP_CurrentAddress(String Cand_CurAddress, String Cand_CurCity, String Cand_CurPincode, String Cand_Curstate, String Cand_CurrentCountry, String Cand_Mothername,int DOB_M, String Cand_Fathername,int DOB_F)

{
//	
//	Current_Address.sendKeys(Keys.chord(Keys.CONTROL, "a"),Cand_CurAddress);
//	Waitfor(2);
//	Current_City.sendKeys(Keys.chord(Keys.CONTROL, "a"),Cand_CurCity);
//	Waitfor(2);
//	Current_Pincode.sendKeys(Keys.chord(Keys.CONTROL, "a"),Cand_CurPincode);
//	Waitfor(2);
//	Current_State.sendKeys(Keys.chord(Keys.CONTROL, "a"),Cand_CurAddress);
//	Waitfor(2);	
//	Select Curent_Country = new Select(Current_Country_Dropdown);
//	logger.info("The Selected Country Name is "+Cand_CurrentCountry);
//	Waitfor(1);	
//	Curent_Country.selectByVisibleText(Cand_CurrentCountry);
//	Waitfor(1);	
	Mothers_Name.sendKeys(Keys.chord(Keys.CONTROL, "a"),Cand_Mothername);
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
	Fathers_Name.sendKeys(Cand_Fathername);
	Waitfor(2);	
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

	Waitfor(2);	
	boolean status = Martial_Status_Single_Radiobutton.isEnabled();
	if(status==false)
	{
		logger.info("Martial_Status_Radiobutton Radio button is already selected");
		
	}
	else
	{
		Waitfor(2);	
		Martial_Status_Single_Radiobutton.click();
	}		

	Waitfor(2);	
}
public void Emp_Nomineetab(String Nom_Name, String Nom_Relation, String Nom_Contactno, String NomDepadantname, String NomDepRelation) throws Exception
{
	
	Nominee_Info_Tab.click();
	Waitfor(2);
	Nominee_Name.sendKeys(Keys.chord(Keys.CONTROL, "a"),Nom_Name);
	Waitfor(2);
	Nominee_Relationship.sendKeys(Keys.chord(Keys.CONTROL, "a"),Nom_Relation);
	Waitfor(2);
	Nominee_Contactno.sendKeys(Keys.chord(Keys.CONTROL, "a"),Nom_Contactno);
	Waitfor(2);
	Dependent_Name.sendKeys(Keys.chord(Keys.CONTROL, "a"),NomDepadantname);
	Waitfor(2);
	Dependent_Relationship.sendKeys(Keys.chord(Keys.CONTROL, "a"),NomDepRelation);
	Waitfor(2);
		
	Emp_declaration_Form2_upd.click();
	Waitfor(2);
	boolean status= Emp_Form2_browse.isDisplayed();
	if(status==true)
	{
		Waitfor(2);
		Emp_Form2_browse.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
	}
	else
	{
		logger.info("Upload Button is not enabled");
	}
	Emp_Form2_comments.sendKeys(Keys.chord(Keys.CONTROL, "a"),"Form2 doc uploaded");
    Waitfor(1);
    Emp_Form2_uploadingbutton.click();
    Waitfor(1);
	logger.info("Upload file sucessfully");
	 Waitfor(2);
	 //form11
	Emp_declaration_Form11_upd.click();
	Waitfor(2);
	boolean status2= Emp_Form2_browse.isDisplayed();
	if(status2==true)
	{
		Waitfor(2);
		Emp_Form2_browse.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
	}
	else
	{
		logger.info("Upload Button is not enabled");
	}
	Emp_Form2_comments.sendKeys(Keys.chord(Keys.CONTROL, "a"),"Form2 doc uploaded");
    Waitfor(1);
    Emp_Form2_uploadingbutton.click();
    Waitfor(1);
	logger.info("Upload file sucessfully");
	 Waitfor(2);
//UAN
	 Emp_UANForm_upd.click();
		Waitfor(2);
		boolean uan= Emp_UAN_Form_browse.isDisplayed();
		if(uan==true)
		{
			Waitfor(2);
			Emp_UAN_Form_browse.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
		}
		else
		{
			logger.info("Upload Button is not enabled");
		}
	
		Emp_UAN_Form_comments.sendKeys(Keys.chord(Keys.CONTROL, "a"),"UAN doc uploaded");
	    Waitfor(1);
	    Emp_UAN_Form_uploadingbutton.click();
	    Waitfor(1);
		logger.info("Upload file sucessfully");
	 
}

	public void Employee_Financial_Info(String CTC_Current, String Primary_BankName,String Primary_Account, String IFSCCODE)
    {
	
		FinancialInfo_Tab.click();
		Waitfor(2);
		Current_CTC.sendKeys(Keys.chord(Keys.CONTROL, "a"),CTC_Current);
		Waitfor(3);
		Addahar_Number.sendKeys(Keys.chord(Keys.CONTROL, "a"),"123456780911");
		Waitfor(2);
		Emp_Aadhar_upload.click();
		Waitfor(2);
		boolean status= Emp_Aadhar_browse.isDisplayed();
		if(status==true)
		{
			Emp_Aadhar_browse.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
		}
		else
		{
			logger.info("Upload Button is not enabled");
		}
		Emp_Aadhar_comments.sendKeys(Keys.chord(Keys.CONTROL, "a"),"Aadhar card uploaded");
	    Waitfor(1);
	    Emp_Aadhar_uploadingbutton.click();
	    Waitfor(1);
	    //PAN
	    PAN_Number.sendKeys(Keys.chord(Keys.CONTROL, "a"),"ftapd9088s");;
	    Emp_PAN_upload.click();
	    Waitfor(2);
		boolean status1= Emp_PAN_browse.isDisplayed();
		if(status1==true)
		{
			Emp_PAN_browse.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
		}
		else
		{
			logger.info("Upload Button is not enabled");
		}
		Emp_PAN_comments.sendKeys(Keys.chord(Keys.CONTROL, "a"),"pan card uploaded");
	    Waitfor(1);
	    Emp_PAN_uploadingbutton.click();
	    Waitfor(1);
// UAN
	    UAN_Number.sendKeys(Keys.chord(Keys.CONTROL, "a"),"123456789101");;
	    Emp_UAN_upload.click();
	    Waitfor(2);
		boolean status2= Emp_UAN_browse.isDisplayed();
		if(status2==true)
		{
			Emp_UAN_browse.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
		}
		else
		{
			logger.info("Upload Button is not enabled");
		}
		Emp_UAN_comments.sendKeys(Keys.chord(Keys.CONTROL, "a"),"UAN uploaded");
	    Waitfor(1);
	    Emp_UAN_uploadingbutton.click();
	    Waitfor(1);
		Boolean  Retentionbonus_checkboxelement = RetentionBonus_Checkbox.isDisplayed();
		if (Retentionbonus_checkboxelement==true)
		{
			RetentionBonus_Checkbox.click();
		}
		PrimaryBank_Name.sendKeys(Keys.chord(Keys.CONTROL, "a"),Primary_BankName);
		Waitfor(2);
		PrimaryBank_AccountNumber.sendKeys(Keys.chord(Keys.CONTROL, "a"),Primary_Account);
		Waitfor(2);
		Primary_IFSC_Code.sendKeys(Keys.chord(Keys.CONTROL, "a"),IFSCCODE);
		Waitfor(1);		
		boolean EmpActiveStatus = Employee_Active_Radiobutton.isDisplayed();
		if(EmpActiveStatus==true)
		{
			Employee_Active_Radiobutton.click();
		}
		else
		{
		logger.info("Employee Active radio button is already selected");
		}
    }
	
			

public void Emp_PassportDetails(String GivenName, String Surname, String PassportNo,int PassDOI,int PassDOE, String Placeofissue, String Placeofbirth, String Visatype, int visadatestart, int visadateend, String VisaCountry)

		{
	  PassportInfo_Tab.click();
	  Waitfor(2);
	  Given_Name.sendKeys(Keys.chord(Keys.CONTROL, "a"),GivenName);
      Waitfor(2);
      Surname1.sendKeys(Keys.chord(Keys.CONTROL, "a"),Surname);
      Waitfor(2);
      Passport_Number.sendKeys(Keys.chord(Keys.CONTROL, "a"),PassportNo);
      Waitfor(2);
      Dateof_Issue_Datepicker.click();
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
  Dateof_Expiry_Datepicker.click();
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
Placeof_Issue.sendKeys(Keys.chord(Keys.CONTROL, "a"),Placeofissue);
Waitfor(2);

Placeof_birth.sendKeys(Keys.chord(Keys.CONTROL, "a"),Placeofbirth);
Waitfor(2);
Passport_Upload_Button.click();
Passport_Browse_Button.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
Passport_Comments.sendKeys(Keys.chord(Keys.CONTROL, "a")," passport uploaded");
Waitfor(1);
Passport_Uploading_Button.click();
Visa_Type.sendKeys(Keys.chord(Keys.CONTROL, "a"),Visatype);
Waitfor(2);
Visa_Start_Date.click();
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
Visa_End_Date.click();
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
Visa_Country.sendKeys(Keys.chord(Keys.CONTROL, "a"),VisaCountry);
Waitfor(2);

}	
	
	public void SelectEmp_Type(String SelectEmp_Type)
	{
		Select ExpDetails = new Select(Experience_SelectType_Dropdown);
		logger.info("The Selected Employee Type is "+SelectEmp_Type);
		Waitfor(1);	
		ExpDetails.selectByVisibleText(SelectEmp_Type);
		Waitfor(1);
		
	}
	
	public void Emp_Educationalinfo_Tab(String Degreename, String Majorsubject,String PassingYear, String StudentId, String CollegeName,int candgrdate, int candstdate,String gradePercentage)
	{
	EducationInfo_Tab.click();
	Waitfor(2);
	Educationinfo_Add_Button.click();
	Waitfor(2);
	Educationinfo_Add_Button.click();
	Waitfor(1);
	WebElement tbody_table = driver.findElement(By.xpath("//table[@id='education_info']"));
	List<WebElement> tbody = tbody_table.findElements(By.tagName("tbody"));
	logger.info(tbody.size());
	int deg= 0;
	for (int t = 1; t <= tbody.size(); t++) 
	{
			
			WebElement row_table = driver.findElement(By.xpath("//table[@id='education_info']/tbody"));
			List<WebElement> row = row_table.findElements(By.tagName("tr"));
			logger.info(row.size());
				int rowcount= 1;
				for (int r = 1; r<=row.size(); r++) 
				{		
						String dd_values[]= {"Degree or Equivalent", "PUC or Equivalent","10th or Equivalent"};
						WebElement col_table = driver.findElement(By.xpath("//table[@id='education_info']/tbody/tr"));
						List<WebElement> column = col_table.findElements(By.tagName("td"));
						logger.info(column.size());
						
						for (int c = 1; c <=1 ; c++) 
						{	
							int count = 4;
							WebElement element = driver.findElement(By.xpath("//table[@id='education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]"));
							if(count==4 && rowcount ==1)
							{
								
								Select ele1 = new Select(driver.findElement(By.xpath("//table[@id='education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/select")));
								ele1.selectByVisibleText(dd_values[deg]);
								Waitfor(2);
								count=count+5;
								
							}
							
							if(count==9 && rowcount ==1)
							{
								WebElement ele2	 = driver.findElement(By.xpath("//table[@id='education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/input"));
								ele2.sendKeys(Keys.chord(Keys.CONTROL, "a"),Majorsubject);
								Waitfor(2);
								count=count+4;
							}
							
							if(count==13 && rowcount ==1)
							{
								WebElement ele3	 = driver.findElement(By.xpath("//table[@id='education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/input"));
								ele3.sendKeys(Keys.chord(Keys.CONTROL, "a"),PassingYear);
							}
							if(count==4 && rowcount ==2)
							{
								WebElement ele4	 = driver.findElement(By.xpath("//table[@id='education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/input"));
								ele4.sendKeys(Keys.chord(Keys.CONTROL, "a"),StudentId);
								Waitfor(2);	
								count=count+5;
				
							}
							if(count==9 && rowcount ==2)
							{
								WebElement ele5	 = driver.findElement(By.xpath("//table[@id='education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/textarea"));
								ele5.sendKeys(Keys.chord(Keys.CONTROL, "a"),CollegeName);
								Waitfor(2);	
								count=count+4;
							}
							//Graduation date
							if(count==13 && rowcount ==2)
							{
								WebElement ele6	 = driver.findElement(By.xpath("//table[@id='education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/input"));
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
								WebElement ele7	 = driver.findElement(By.xpath("//table[@id='education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/input"));
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
								WebElement ele8	 = driver.findElement(By.xpath("//table[@id='education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/input"));
								ele8.sendKeys(Keys.chord(Keys.CONTROL, "a"),gradePercentage);
								Waitfor(2);	
								count=count+4;

							}
						if(count==13 && rowcount ==3)
						{
						
						WebElement ele5	 = driver.findElement(By.xpath("//table[@id='education_info']/tbody["+t+"]/tr["+r+"]/td["+count+"]/button"));
						ele5.click();
						Waitfor(2);	
					
						WebElement status= driver.findElement(By.xpath("//input[@id='uploadfileName']"));
						boolean status2=status.isDisplayed();
						if(status2==true)
						{
							status.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
						}
						else
						{
							logger.info("Upload Button is not enabled");
						}
					
						logger.info("Upload file sucessfully");
					
					
						Waitfor(2);
						driver.findElement(By.xpath("//textarea[@id='upload_comment']")).sendKeys("Aadharfile_description");
					    Waitfor(2);
					    driver.findElement(By.xpath("//button[@id='employee_uploadEduDoc']")).click();
					   
						Waitfor(2);
						}
						}
						rowcount++;
					}
				  deg++;
				}			
		}
	
	public void Emp_Experienceinfo(String Company, String Exp_Designation, String DOL, String EMPID, String Reportedto, String Leavingreason,String HRname,int DOJ, int DOR,int Gapempfrom,int Gapempto,String Gapreason) throws Exception
	{
		Experienceinfo_Tab.click();
		Waitfor(2);
		ADDNextCompyBtn.click();
		Waitfor(2);
		Company_Name.sendKeys(Keys.chord(Keys.CONTROL, "a"),Company);
		Waitfor(2);
		Designationon_Joining_Datepicker.sendKeys(Keys.chord(Keys.CONTROL, "a"),Exp_Designation);
		Waitfor(2);
		Designationon_Leaving.sendKeys(Keys.chord(Keys.CONTROL, "a"),DOL);
		Waitfor(2);
		Employee_Id.sendKeys(Keys.chord(Keys.CONTROL, "a"),EMPID);
		Waitfor(2);
		Reported_ToNameofPostion.sendKeys(Keys.chord(Keys.CONTROL, "a"),Reportedto);
		Waitfor(2);
		Reasonfor_Leaving.sendKeys(Keys.chord(Keys.CONTROL, "a"),Leavingreason);
		Waitfor(2);
		Nameof_HR_Manager.sendKeys(Keys.chord(Keys.CONTROL, "a"),HRname);
		Waitfor(2);		
		/*cand_exp_upload_document("experiencedocs");
		Thread.sleep(6000);*/
		Dateof_Joining_Datepicker.click();
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
		Dateof_Releaving_Datepicker.click();
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
		UploadRelatedDocmnet.click();
		Waitfor(2);	
		WebElement status= driver.findElement(By.xpath("//input[@id='uploadfileName']"));
		boolean status2=status.isDisplayed();
		if(status2==true)
		{
			status.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
		}
		else
		{
			logger.info("Upload Button is not enabled");
		}
	
		logger.info("Upload file sucessfully");

		Waitfor(2);
		driver.findElement(By.xpath("//textarea[@id='upload_comment']")).sendKeys("Aadharfile_description");
	    Waitfor(1);
		driver.findElement(By.xpath("//button[@id='employee_uploadExpDoc']")).click();
		Waitfor(2);	
				
		//Gap duration employment
		Emp_Gap_Fromdate.click();
		List<WebElement> EmpgapFrom = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

		int Emp_Gapfrom= EmpgapFrom.size();
		logger.info("Calendar Date size is : " + Emp_Gapfrom);
		for (int i = 0; i < Emp_Gapfrom; i++) {
			String empgapfrom = EmpgapFrom.get(i).getText();
			if (empgapfrom.equals(Integer.toString(Gapempfrom))) {
				EmpgapFrom.get(i).click();
				logger.info("Selected date is: " + empgapfrom);
				break;
			}
		}
		Emp_Gap_Todate.click();
		List<WebElement> EmpgapTo= driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td"));

		int Emp_Gapto= EmpgapTo.size();
		logger.info("Calendar Date size is : " + Emp_Gapto);
		for (int i = 0; i < Emp_Gapto; i++) {
			String empgapto = EmpgapTo.get(i).getText();
			if (empgapto.equals(Integer.toString(Gapempto))) {
				EmpgapTo.get(i).click();
				logger.info("Selected date is: " + empgapto);
				break;

			}
		}
		
		Empedu_GapReason.sendKeys(Keys.chord(Keys.CONTROL, "a"),Gapreason);
		Waitfor(2);
	}	
	
	// Employee Skills Iformations 
	
		
		public void Emp_Skillsinfo() 
		{	
			Skillsinfo_Tab.click();
			Waitfor(2);	
			Emp_Profile_uploadbutton.click();
			Waitfor(2);
			driver.findElement(By.xpath("//input[@id='uploadfileName']")).sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
			Waitfor(2);
			driver.findElement(By.xpath("//textarea[@id='upload_comment']")).sendKeys("resume uploaded");
			Waitfor(2);
			driver.findElement(By.xpath("//button[@id='emp_AadharUpload']")).click();
			Waitfor(2);
			PeopleSoftCRMchckbOX.click();
			Waitfor(2);
			Scroll_down();
			driver.findElement(By.xpath("//input[@id='otherSkills']")).sendKeys("suma");
			Waitfor(2);				
		}
		public String Employee_editing_data(String emp_name, String email)
		{ 
			    Click_EmployeesMenu();
				Waitfor(3);
				Employees_SearchInput.sendKeys(Keys.chord(Keys.CONTROL, "a"),emp_name);
				Waitfor(2);
			
				Actions action = new Actions(driver);
				int count = 0;
				String fail= "";
				String col_text = "Name";
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
							String array[] = { "Candidate Created", "Approved", "Rejected", "Completed", "Submitted" };
							
							if (cell_Value.equalsIgnoreCase(emp_name)) {
								
								WebElement report= driver.findElement(By.xpath("//table[@id='employee_home']/tbody/tr[" + c + "]/td[2]"));
								action.click(report).build().perform();
								Waitfor(2);
								String  s= driver.findElement(By.xpath("//table[@id='employee_home']/tbody/tr[" + c + "]/td[3]")).getText();
								if(s.equalsIgnoreCase(email))
								{
								logger.info("Status is matching with the passed status & Status is "+s);
								action.click(report).build().perform();
								Waitfor(2);
					// Edit button validation
					boolean editbutton= Employee_Edit_Button.isDisplayed();
					if (editbutton == true) 
					{
				
					logger.info(" edit button is displayed under RMG page and status is :" + editbutton);
					Waitfor(2);						
					}
					else
					{
					logger.info("edit button is not present in candidate page and status is :" + editbutton);
					}
					
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
		

	
	
	public void Generateemployeeid(String emp_ID )
	{
		   Click_EmployeesMenu();
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
		    Employee_Edit_Button.click();
		    Waitfor(20);
		    Generate_EmployeeId_Button.click();
		    Waitfor(2);
	        String id= Employee_ID.getText();
		    Waitfor(2);
		    logger.info("employee id is " +id);
		    Waitfor(2);
		    picture_upload_Button.click();
		    Waitfor(2);
		    picture_browse_Button.sendKeys(new File(ConfigDataProvider.getProp().getProperty("uploadImage")).getAbsolutePath());
		    Waitfor(2);
		    upload_picture_Button.click();
		    Waitfor(2);
		    Generalinfo_Savebutton();
		    Waitfor(5);	
		
	  
	}
	public void EmployeeSeperation()
	{
		Employee_Seperate_Button.click();
		
		Waitfor(2);
		Seperate_date.click();
		Waitfor(2);
		Seperation_Submit_Button.click();
		Waitfor(2);
		
	}
	
	public void EmployeeAbscond()
	{
		Employee_Abscond_Button.click();
		Waitfor(2);
		
		Waitfor(1);
		Abscond_Dateofseperation_Datepicker.click();
		Waitfor(1);
		Abscond_Submit_Button.click();
		Waitfor(1);
	
	}
	
	public void ExportEmployee_Leaves()
	{
		
		Export_Leaves.click();
	}
	public void ImportEmployee_Leaves()
	{
		Import_Leaves.click();
	}
	public void uploading_EmployeeFBP()
	{
		Upload_FBP.click();
	}
	public void uploading_TaxBenfitDeclaration()
	{
		Upload_FBP.click();
	}
	public void Change_ReportingManager()
	{
		Upload_FBP.click();
	}
	public void Changing_SPOC()
	{
		Upload_FBP.click();
	}
	public  void Scroll_down()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("scroll(0,900)");
	}
	public void Generalinfo_Savebutton()
	{
		Scroll_down();
	    Waitfor(2);	
		Save_Button.click();
		Waitfor(3);
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("scroll(0,-900)");
	}
	public void Personalinfo_Savebutton()
    {    Scroll_down();
		 Waitfor(2);

			boolean save_personal_tab= save_personaltab.isDisplayed();

			if(save_personal_tab==true)
			{
				save_personaltab.click();
				Waitfor(2);	
				Scroll_Up();
			
			String exp_personal_per ="17%";
			Waitfor(3);
			JavascriptExecutor js = (JavascriptExecutor)driver; 
			js.executeScript("scroll(0,-900)");
			String act_personal_per= progresssbar.getText();
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
		
		
	
	public void Nomineeinfo_Savebutton()
    {
		Scroll_down();
	    Waitfor(2);	
	    Scroll_down();
	    Waitfor(2);	
	    boolean save_nominee_tab= Save_Nominee.isDisplayed();

		if(save_nominee_tab==true)
		{	
			Save_Nominee.click();
		Waitfor(2);
		Scroll_Up();
		String exp_nominee_per = "27%";
		Waitfor(3);
		String act_nominee_per= progresssbar.getText();	
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
	public void Financeinfo_Savebutton()

	{	
		Scroll_down();
	    Waitfor(2);
		boolean save_financila_tab= SaveFinanceInfo.isDisplayed();
		if(save_financila_tab==true)
		{
			SaveFinanceInfo.click();
		    Waitfor(3);	
			Scroll_Up();
			Waitfor(2);
			Scroll_Up();
			Waitfor(2);
			Scroll_Up();
			Waitfor(2);
		String exp_financila_per = "44%";
		String act_financila_per= progresssbar.getText();
		Scroll_Up();
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
	
	public void Passportinfo_Savebutton()
    {
		Scroll_down();
	    Waitfor(2);	
		
		boolean save_passport_tab= SavePassortDeatils.isDisplayed();
		
		if(save_passport_tab==true)
		{
			SavePassortDeatils.click();
			Waitfor(3);
			Scroll_Up();
		String exp_passport_per = "55%";
		String act_passport_per= progresssbar.getText();
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
	
	public void Educationinfo_Savebutton()
    {
		Scroll_down();
	    Waitfor(2);
		boolean save_educational_tab= Edu_SaveButtn.isDisplayed();
		if(save_educational_tab==true)
		{
			Edu_SaveButtn.click();
			Waitfor(2);	
			Scroll_Up();
		String exp_educational_per = "71%";
		String act_educational_per= progresssbar.getText();		
		if(act_educational_per.equalsIgnoreCase(exp_educational_per))
		{
		logger.info("Educational info tab saved Successfully");
		logger.info("The current percentage is " + act_educational_per);	
	}
		 else
	     {
	   	  logger.info("percentage is not incresed" );
	     }	
	}
    }
	public void Skillsinfo_Savebutton()
{

		Scroll_down();
	    Waitfor(2);	
		boolean save_skill_tab=saveskills.isDisplayed();
		if(save_skill_tab==true)
		{
		saveskills.click();
		Waitfor(3);	
		Scroll_Up();
		Scroll_Up();
		String exp_skill_per = "100%";
		logger.info("");
		String act_skill_per= progresssbar.getText();
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

	public void Exp_SaveButtn()
	{
		Scroll_down();
	    Waitfor(2);	
		boolean save_experience_tab= Experience_SaveButtn.isDisplayed();
		if(save_experience_tab==true)
		{
		Experience_SaveButtn.click();
		Waitfor(3);
		Scroll_Up();
		Waitfor(2);
		Scroll_Up();
		String exp_experience_per = "88%";	
		logger.info("");
		String act_experience_per= progresssbar.getText();
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
	public void Passport_Tab()
	{	
    PassportInfo_Tab.click();
	}
	
public void NomineeTab()
{
	Nominee_Info_Tab.click();	
}
public void personalinfo_Tab()
{
	Personalinfo_Tab.click();
}

public void experinfo_Tab()
{
Experienceinfo_Tab.click();
}
public void eduinfo_Tab()
{
EducationInfo_Tab.click();
}
public void skillinfo_Tab()
{
Skillsinfo_Tab.click();
}
public void financetab_Tab()
{
FinancialInfo_Tab.click();
}
public  void Scroll_Up()
{
	JavascriptExecutor js = (JavascriptExecutor)driver; 
	js.executeScript("window.scrollBy(0,-600)");
}

}
				 
				 
		
		
		
		
		


	
	

