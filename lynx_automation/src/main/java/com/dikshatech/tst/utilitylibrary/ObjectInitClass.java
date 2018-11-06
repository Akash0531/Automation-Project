package com.dikshatech.tst.utilitylibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.dikshatech.tst.objectrepository.AppraisalObjects;
import com.dikshatech.tst.objectrepository.ClientsObjects;
import com.dikshatech.tst.objectrepository.EmployeeOnboardingObjects;
import com.dikshatech.tst.objectrepository.EmployeesObjects;
import com.dikshatech.tst.objectrepository.FBPObjects;
import com.dikshatech.tst.objectrepository.FestivalWishesObjects;
import com.dikshatech.tst.objectrepository.HomePageObjects;
import com.dikshatech.tst.objectrepository.ITAssetsObjects;
import com.dikshatech.tst.objectrepository.ITSupportObjects;
import com.dikshatech.tst.objectrepository.InsuranceObjects;
import com.dikshatech.tst.objectrepository.LeavesObject;
import com.dikshatech.tst.objectrepository.LoginPageObjects;
import com.dikshatech.tst.objectrepository.ManageAppraisalsObjects;
import com.dikshatech.tst.objectrepository.PayslipsObjects;
import com.dikshatech.tst.objectrepository.PerdiemReconciliationObjects;
import com.dikshatech.tst.objectrepository.QPLBObjects;
import com.dikshatech.tst.objectrepository.QplbHdfcReportsObjects;
import com.dikshatech.tst.objectrepository.ReferAFriendObjects;
import com.dikshatech.tst.objectrepository.ReimbursementSubmoduleObjects;
import com.dikshatech.tst.objectrepository.Rollonpageobjects;
import com.dikshatech.tst.objectrepository.SalaryReconciliationObjects;
import com.dikshatech.tst.objectrepository.SalesDriveObjects;
import com.dikshatech.tst.objectrepository.ServiceRequestObjects;
import com.dikshatech.tst.objectrepository.TimesheetsSubmoduleObjects;
import com.dikshatech.tst.objectrepository.TravelObjects;
import com.dikshatech.tst.objectrepository.UpdateProfileObjects;
import com.dikshatech.tst.objectrepository.VendorManagement;

public class ObjectInitClass {

	public static HomePageObjects HP;
	public static LoginPageObjects LP;
	public static LeavesObject L;
	public static ReimbursementSubmoduleObjects RS;
	public static TimesheetsSubmoduleObjects TS;
	public static PerdiemReconciliationObjects per;
	public static QPLBObjects qplb;
	public static Rollonpageobjects roll_ON;
	public static EmployeesObjects EMP;
	public static UpdateProfileObjects upd_pro;
	public static AppraisalObjects AP;
	public static ManageAppraisalsObjects MA;
	public static ITSupportObjects ITSprt;
	public static ReferAFriendObjects Rf;
	public static ServiceRequestObjects SerRequest;
	public static ClientsObjects Cl;
	public static SalaryReconciliationObjects SAL;
	public static InsuranceObjects Insurance;
	public static FBPObjects FBP;
	public static TravelObjects Travel;
	public static PayslipsObjects payslip;
	public static FestivalWishesObjects F_Wishes;
	public static EmployeeOnboardingObjects EOB;
	public static ITAssetsObjects ITA;
	public static SalesDriveObjects pipeLine;
	public static QplbHdfcReportsObjects QHR;
	public static VendorManagement VM;

	public static void homepage(WebDriver driver) {
		HP = PageFactory.initElements(driver, HomePageObjects.class);
	}

	public static void loginpage(WebDriver driver) {
		LP = PageFactory.initElements(driver, LoginPageObjects.class);
	}

	public static void leaves(WebDriver driver) {
		L = PageFactory.initElements(driver, LeavesObject.class);
	}

	public static void reimbursement(WebDriver driver) {
		RS = PageFactory.initElements(driver, ReimbursementSubmoduleObjects.class);
	}

	public static void timesheet(WebDriver driver) {
		TS = PageFactory.initElements(driver, TimesheetsSubmoduleObjects.class);
	}

	public static void perdiempage(WebDriver driver) {
		per = PageFactory.initElements(driver, PerdiemReconciliationObjects.class);
	}

	public static void QPLB_OBJECT(WebDriver driver) {
		qplb = PageFactory.initElements(driver, QPLBObjects.class);
	}

	public static void roll_On(WebDriver driver) {
		roll_ON = PageFactory.initElements(driver, Rollonpageobjects.class);
	}

	public static void employeepageobject(WebDriver driver) {
		EMP = PageFactory.initElements(driver, EmployeesObjects.class);
	}

	public static void updateProfile(WebDriver driver) {
		upd_pro = PageFactory.initElements(driver, UpdateProfileObjects.class);
	}

	public static void Appraisalpage(WebDriver driver) {
		AP = PageFactory.initElements(driver, AppraisalObjects.class);
	}

	public static void manageappraisal(WebDriver driver) {
		MA = PageFactory.initElements(driver, ManageAppraisalsObjects.class);
	}

	public static void IT_Support(WebDriver driver) {
		ITSprt = PageFactory.initElements(driver, ITSupportObjects.class);
	}

	public static void refferAFriendPage(WebDriver driver) {
		Rf = PageFactory.initElements(driver, ReferAFriendObjects.class);
	}

	public static void Service_Request(WebDriver driver) {
		SerRequest = PageFactory.initElements(driver, ServiceRequestObjects.class);
	}

	public static void salaryRecon(WebDriver driver) {
		SAL = PageFactory.initElements(driver, SalaryReconciliationObjects.class);
	}

	public static void Insurance(WebDriver driver) {
		Insurance = PageFactory.initElements(driver, InsuranceObjects.class);
	}

	public static void FlexiBenefitsPlan(WebDriver driver) {
		FBP = PageFactory.initElements(driver, FBPObjects.class);
	}

	public static void TravelModule(WebDriver driver) {
		Travel = PageFactory.initElements(driver, TravelObjects.class);
	}

	public static void payslipModule(WebDriver driver) {
		payslip = PageFactory.initElements(driver, PayslipsObjects.class);
	}

	public static void festivalModule(WebDriver driver) {
		F_Wishes = PageFactory.initElements(driver, FestivalWishesObjects.class);

	}

	public static void employeeonboardingobjects(WebDriver driver) {
		EOB = PageFactory.initElements(driver, EmployeeOnboardingObjects.class);
	}

	public static void ITAssetsObjects(WebDriver driver) {
		ITA = PageFactory.initElements(driver, ITAssetsObjects.class);
	}

	public static void clientsobjects(WebDriver driver) {
		Cl = PageFactory.initElements(driver, ClientsObjects.class);
	}

	public static void pipelineDrive(WebDriver driver) {
		pipeLine = PageFactory.initElements(driver, SalesDriveObjects.class);
	}

	public static void qplbHDFC(WebDriver driver) {
		QHR = PageFactory.initElements(driver, QplbHdfcReportsObjects.class);
	}
	public static void vendormanagement(WebDriver driver) {
		VM = PageFactory.initElements(driver, VendorManagement.class);
	}

}
