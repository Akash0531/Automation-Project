package com.dikshatech.tst.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dikshatech.tst.dataprovider.ConfigDataProvider;
import com.dikshatech.tst.dataprovider.ExcelWriteData;
import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class EmployeeModule extends TestBase{

	int row=1;
	
	String Company_Name= excelreaddata().getData("EOB", row, 0 );
	String Region_Name= excelreaddata().getData("EOB", row, 1 ); 
	String Location_Name= excelreaddata().getData("EOB", row, 2 ); 
	String Department_Name= excelreaddata().getData("EOB", row, 3 ); 
	String Category_Name= excelreaddata().getData("EOB", row, 4 ); 
	String Level_Name= excelreaddata().getData("EOB", row, 5 ); 
	String Designation= excelreaddata().getData("EOB", row, 6 ); 
	String Reporting_ManagerName= excelreaddata().getData("EOB", row, 7 ); 
	String SPOCNAME= excelreaddata().getData("EOB", row, 8 ); 	
	String Project_Name= excelreaddata().getData("EOB", row, 9 ); 
	String Emp_Firstname= excelreaddata().getData("EOB", row, 10 ); 
	String Emp_Lastname= excelreaddata().getData("EOB", row, 11 ); 
	//String Dateof_Birth= excelreaddata().getData("EOB", row, 12 ); 
	String OfficialMailID= excelreaddata().getData("EOB", row, 15 ); 
	//String Dateof_Joining= excelreaddata().getData("EOB", row, 16 ); 
	String NoticePeriod= excelreaddata().getData("EOB", row, 17 ); 
	//String Employment_Type= excelreaddata().getData("EOB", row, 18 ); 
	//String Role= excelreaddata().getData("EOB", row, 19 ); 
	String Cand_PerAddress= excelreaddata().getData("EOB", row, 30 ); 
	String Cand_PerCity= excelreaddata().getData("EOB", row, 31 ); 
	String Cand_PerPincode= excelreaddata().getData("EOB", row, 32 ); 
	String Cand_Perstate= excelreaddata().getData("EOB", row, 33 ); 
	String Cand_PermanaentCountry= excelreaddata().getData("EOB", row, 34 ); 
	String Cand_CurAddress= excelreaddata().getData("EOB", row, 35 ); 
	String Cand_CurCity= excelreaddata().getData("EOB", row,36 ); 
	String Cand_CurPincode= excelreaddata().getData("EOB", row, 37 ); 
	String Cand_Curstate= excelreaddata().getData("EOB", row, 38 ); 
	String Cand_CurrentCountry= excelreaddata().getData("EOB", row, 39 );
	String Cand_Mothername= excelreaddata().getData("EOB", row, 40 ); 
	String Cand_Fathername= excelreaddata().getData("EOB", row, 41 ); 			
	String Cand_PrimaryPhNo= excelreaddata().getData("EOB", row, 42 ); 
	String Cand_SeconPhNo= excelreaddata().getData("EOB", row, 43 ); 
	String Cand_Mailid= excelreaddata().getData("EOB", row, 44 ); 
	String Cand_AltMailId= excelreaddata().getData("EOB", row, 45 ); 
	String Cand_Emrgcontactname= excelreaddata().getData("EOB", row, 46 ); 
	String Cand_EmRelation= excelreaddata().getData("EOB", row, 47 ); 
	String Cand_EmrgPhonenum= excelreaddata().getData("EOB", row, 48 ); 
	String Cand_blodgroup =excelreaddata().getData("EOB", row, 49 ); 	
	String PerCon_Name= excelreaddata().getData("EOB", row, 50 ); 
	String Percon_Rel= excelreaddata().getData("EOB", row, 51 ); 
	String Per_PhNo= excelreaddata().getData("EOB", row, 52 ); 
	String Per_emailid= excelreaddata().getData("EOB", row, 53 ); 
	String Prof_Contname= excelreaddata().getData("EOB", row, 54 ); 
	String Prof_Desig= excelreaddata().getData("EOB", row, 55 ); 
	String Prof_Phnum= excelreaddata().getData("EOB", row, 56 );
	String Prof_mailid= excelreaddata().getData("EOB", row, 57 );
	String Nom_Name= excelreaddata().getData("EOB", row, 58 ); 
	String Nom_Relation= excelreaddata().getData("EOB", row, 59 ); 
	String Nom_Contactno= excelreaddata().getData("EOB", row, 60 ); 
	String NomDepadantname= excelreaddata().getData("EOB", row, 61 ); 
	String NomDepRelation= excelreaddata().getData("EOB", row, 62 );	
	String Role= excelreaddata().getData("EOB", row, 19 ); 
	String CTC_Current= excelreaddata().getData("EOB", row, 20 ); 
	String QPLB_Amount= excelreaddata().getData("EOB", row, 21 ); 
	String Per_qplb= excelreaddata().getData("EOB", row, 22 ); 
	String Per_aplb= excelreaddata().getData("EOB", row, 23 ); 
	String Primary_BankName= excelreaddata().getData("EOB", row, 24 ); 
	String Primary_Account= excelreaddata().getData("EOB", row, 25 ); 
	String IFSCCODE= excelreaddata().getData("EOB", row, 26 ); 
	String GivenName= excelreaddata().getData("EOB", row, 70 ); 
	String Surname= excelreaddata().getData("EOB", row, 71 ); 
	String PassportNo= excelreaddata().getData("EOB", row, 72 ); 
	String Placeofissue= excelreaddata().getData("EOB", row, 73 ); 
	String Placeofbirth= excelreaddata().getData("EOB", row, 74 ); 
	String Visatype= excelreaddata().getData("EOB", row, 75 ); 
	String VisaCountry= excelreaddata().getData("EOB", row, 76 );
	String Degreename= excelreaddata().getData("EOB", row, 77 ); 
	String Majorsubject= excelreaddata().getData("EOB", row, 78 ); 
	String PassingYear= excelreaddata().getData("EOB", row, 79 ); 
	String StudentId= excelreaddata().getData("EOB", row, 80 ); 
	String CollegeName= excelreaddata().getData("EOB", row, 81 ); 
	String Percentage= excelreaddata().getData("EOB", row, 82 ); 
	String Degreetype= excelreaddata().getData("EOB", row, 83 ); 
	String Edu_Gap= excelreaddata().getData("EOB", row, 84 ); 
	String GapReason= excelreaddata().getData("EOB", row, 85 ); 
	String Training_instname= excelreaddata().getData("EOB", row, 86 ); 
	String coursename= excelreaddata().getData("EOB", row, 87 ); 
	String Rank= excelreaddata().getData("EOB", row, 88 ); 
	String TrainingYear= excelreaddata().getData("EOB", row, 89 );	
	String Company= excelreaddata().getData("EOB", row, 90 ); 
	String Exp_Designation= excelreaddata().getData("EOB", row, 91 ); 
	String DOL= excelreaddata().getData("EOB", row, 92 ); 
	String EMPID= excelreaddata().getData("EOB", row, 93 ); 
	String Reportedto= excelreaddata().getData("EOB", row, 94 ); 
	String Leavingreason= excelreaddata().getData("EOB", row, 95 ); 
	String HRname= excelreaddata().getData("EOB", row, 96 ); 	
	String Gapreason= excelreaddata().getData("EOB", row, 97 ); 
	String Skill= excelreaddata().getData("EOB", row, 98 ); 
	String emp_name= excelreaddata().getData("EOB", row, 10 ); 
	String email= excelreaddata().getData("EOB", row, 15 );
	
	
	@Test(priority=0, enabled=true,description= "*****Validation of all the webelement and functionalities composed in HomePage*****")
	public void VerifyHomePage() throws Exception
	{
		  ObjectInitClass.homepage(driver);
	      ObjectInitClass.loginpage(driver);
		  ObjectInitClass.employeepageobject(driver);
	
				String username= excelreaddata().getData("Login_Credentials", 3, 0 ); //excelreaddata()ing Username from excel
				Waitfor(2);
				String password= excelreaddata().getData("Login_Credentials", 3, 1 ); //excelreaddata()ing Password from excel
				Waitfor(2);
				ObjectInitClass.LP.signIn(username, password);
				Waitfor(4);	
				//Scenario 1 : create a new employee
	  	        ObjectInitClass.EMP.Create_New_Employee(Company_Name,Region_Name,Location_Name,Department_Name, Category_Name, Level_Name, Designation, Reporting_ManagerName, SPOCNAME, Project_Name,  Emp_Firstname,
				Emp_Lastname, 2,  OfficialMailID, 7, NoticePeriod, Role);	
	  	        Waitfor(3);
				ObjectInitClass.EMP.Employee_editing_data(emp_name,email);
	 			Waitfor(2);	
	 			//Scenario 2:Generate employee ID
	            ObjectInitClass.EMP.Generateemployeeid(email);
	 			Waitfor(2);	
	 			//Scenario 3:Personal info tab data
	  	        ObjectInitClass.EMP.EMP_PermanantAddress(Cand_PerAddress, Cand_PerCity, Cand_PerPincode, Cand_Perstate, Cand_PermanaentCountry);
	  	        Waitfor(2);
	  	        ObjectInitClass.EMP.Employee_ContactNumbers(Cand_PrimaryPhNo, Cand_SeconPhNo, Cand_Mailid, Cand_AltMailId,"suma", "suma", Cand_EmrgPhonenum,Cand_blodgroup);
	  	        Waitfor(2);
	  	        ObjectInitClass.EMP.EMP_CurrentAddress(Cand_CurAddress, Cand_CurCity, Cand_CurPincode, Cand_Curstate, Cand_CurrentCountry, Cand_Mothername,1, Cand_Fathername,2);
	  	        Waitfor(2);
	  	        ObjectInitClass.EMP.Emp_references(PerCon_Name, Percon_Rel, Per_PhNo, Per_emailid, Prof_Contname, Prof_Desig, Prof_Phnum, Prof_mailid);
	 	 	    Waitfor(2);
	 		    ObjectInitClass.EMP.Personalinfo_Savebutton();
	 		    Waitfor(2);	
	 			//Scenario 4:Nominee info tab data
	 		    ObjectInitClass.EMP.Emp_Nomineetab(Nom_Name,Nom_Relation, Nom_Contactno, NomDepadantname,NomDepRelation);
	 		    Waitfor(2);	
	 			ObjectInitClass.EMP.Nomineeinfo_Savebutton();
	 			Waitfor(2);
	 			//Scenario 5:financila info tab data
	 			ObjectInitClass.EMP.Employee_Financial_Info(CTC_Current, Primary_BankName, Primary_Account, IFSCCODE);
	 			Waitfor(2);
	 			ObjectInitClass.EMP.Financeinfo_Savebutton();
	 			Waitfor(2);
	 			//Scenario 6:passport info tab data
	 			ObjectInitClass.EMP.Emp_PassportDetails(GivenName, Surname, PassportNo,4,6, Placeofissue, Placeofbirth, "abcd",11,12, VisaCountry);
	 			Waitfor(2);
	 			ObjectInitClass.EMP.Passportinfo_Savebutton();
	 			Waitfor(2);
	 			//Scenario 7:educational  info tab data
	 			ObjectInitClass.EMP.Emp_Educationalinfo_Tab("Degree or Equivalent",  "B.TECH", "2014",  "245622",  "Diksha College", 5,  1, "A");
	 			Waitfor(2);	
 			    ObjectInitClass.EMP.Educationinfo_Savebutton();
	 			Waitfor(2);	
	 			//Scenario 8:experience info tab data
	 			ObjectInitClass.EMP.Emp_Experienceinfo(Company, Exp_Designation, DOL, EMPID, Reportedto, Leavingreason, HRname, 9, 11, 21, 30, Gapreason);
	 			Waitfor(2);	
	 			ObjectInitClass.EMP.Exp_SaveButtn();
	 			Waitfor(2);	
	 			//Scenario 10:skill info tab data
	 			ObjectInitClass.EMP.Emp_Skillsinfo(); 
	 			Waitfor(2);	
	 			ObjectInitClass.EMP.Skillsinfo_Savebutton();
	 			Waitfor(2);		 			
	}
}
	
	
	
			  
		
		
		


