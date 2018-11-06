package com.dikshatech.tst.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.dikshatech.tst.pageFatory.TestBase;
import com.dikshatech.tst.utilitylibrary.ObjectInitClass;

public class UpdateProfileObjects extends TestBase 
{
		@Test
		public UpdateProfileObjects (WebDriver driver)
		{
			this.driver = driver;		
			
		}
		
		
		// EMployee Financial Info Objects Repository
		
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement FinancialInfo_Tab;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement PF_Number;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement Addahar_Number;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement PAN_Number;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement UAN_Number;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement Upload_Related_Documents;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement PrimaryBank_Name;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement PrimaryBank_AccountNumber;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement SecondaryBank_Name;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement SecondaryBank_AccountNumber;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement Primary_IFSC_Code;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement Secondary_IFSC_Code;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement SalaryinAdvance_TotalAmount;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement SalaryinAdvance_Monthly_Deduction;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement SalaryAdvanceDeductionfrom_Salry;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement SalaryAdvanceDeductionfrom_Perdiem;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement PerdiemAdvance_TotalAmount;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement Perdiem_Terms_Dropdown;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement Amount_Term_Deduction;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement SalaryCycle_Dropdown;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement Employee_Active_Radiobutton;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement Employee_Inactive_Radiobutton;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement Salarystackup_Old_Radiobutton;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement Salarystackup_New_Radiobutton;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement Current_CTC;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement Total_Linked_perfomamance_Bonus;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement FixedPerdiem_Checkbox;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement FixedPerdiem_Amount;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement FixedPerdiem_From;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement FixedPerdiem_To;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement VarPerdiem_Checkbox;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement VarPerdiem_Amount;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement VarPerdiem_CurrencyType;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement VarPerdiem_From;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement VarPerdiem_To;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement Esic_Radiobutton_Yes;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement Esic_Radiobutton_No;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement QPLB;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement APLB;	
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement RetentionBonus_Checkbox;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement Retention_bonus;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement RetentionBonus_installments_Dropdown;
		@FindBy(xpath="//a[@sectionid='mylynx3']") WebElement EffectFrom_Datepicker;
}
