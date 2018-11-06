package com.dikshatech.tst.objectrepository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.dikshatech.tst.pageFatory.TestBase;

public class SalesDriveObjects extends TestBase {
	public static final String CLASS_STATUS = "activable active";
	public static final String SHEETNAME = "Pipedrive";
	public static final String ATTR_NAME= "class";
	public static final String ALPHACHAR= "123 @& Alphnumeric";
	String wonfinalamount="";
	String lostfinalamount="";
	String wonremark= "";
	String lostremark= "";
	String passedexpclose = "";
	String dealOwner = "";
	String dealtitle="";
	boolean bTrue = true;
	boolean bFalse = false;
	public static Pojo pojo=new Pojo();


	@Test
	public SalesDriveObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//span[text()='Sales']") 								WebElement sales;
	@FindBy(xpath = "//span[text()='Sales Drive']") 						WebElement salesDriveModule;
	@FindBy(xpath = "//div[@id='pipeLineHeaderActions']/div[1]/button") 	WebElement dealsButton;
	@FindBy(xpath = "//div[@id='pipeLineHeaderActions']/div[2]/div/button") WebElement statisticsButtton;
	@FindBy(xpath= "//div[@id='toaster']/span[2]")  						WebElement genericToastMsg;
	@FindBy(xpath="//span[@id='dynamic_username']") 						WebElement accountHolderName;
	
	/*
	3-Different Pipedrive section xpath.
	*/
	@FindBy(xpath = "//button[@title='Pipeline']") 							WebElement pipeLine;
	@FindBy(xpath = "//button[@title='List']") 								WebElement list;
	@FindBy(xpath = "//button[@title='ForeCast']") 							WebElement forecast;
	
	/*
	Add Deal window fields xpath along with the 5 Stages.
	*/ 
	@FindBy(xpath = "//button[text()='Add Deal']") 							WebElement addDealButton;
	@FindBy(xpath = "//h4[text()='Add Deal']") 							    WebElement addDealPopup;
	@FindBy(xpath = "//select[@id='customer_Name_drop']") 					WebElement customerNameDD;
	@FindBy(xpath = "//input[@id='addExtraInfo']") 							WebElement customerExtrainfoCheckbox;
	@FindBy(xpath = "//input[@id='customerNameInCheckBox']") 				WebElement customerName;
	@FindBy(xpath = "//input[@id='custPhoneNumInCheck']") 					WebElement custContactno;
	@FindBy(xpath = "//input[@id='custEmailInCheck']") 						WebElement custMailID;
	@FindBy(xpath = "//input[@id='customerNameInCheckBox']") 				WebElement custCountryname;
	@FindBy(xpath = "//input[@id='customerNameInCheckBox']") 				WebElement custStatename;
	@FindBy(xpath = "//input[@id='customerNameInCheckBox']") 				WebElement custAddress;
	@FindBy(xpath = "//input[@id='customerNameInCheckBox']") 				WebElement addIndustrycheckbox;
	@FindBy(xpath = "//input[@id='customerNameInCheckBox']") 				WebElement addindustrynameDD;
	@FindBy(xpath = "//input[@id='customerNameInCheckBox']") 				WebElement industryname;
	@FindBy(xpath = "//select[@id='contactPersonName']") 					WebElement contPersonNameDD;
	@FindBy(xpath = "//input[@id='addExtraContactInfo']") 					WebElement continfoCheckbox;
	@FindBy(xpath = "//input[@id='ContactNameInCheckBox']") 				WebElement contFirstpersonname;
	@FindBy(xpath = "//input[@id='ContactNameInCheckBox']") 				WebElement contLastpersonname;
	@FindBy(xpath = "//input[@id='ContactPhoneNumInCheck']") 				WebElement contContactno;
	@FindBy(xpath = "//input[@id='ContactEmailInCheck']") 					WebElement contMailID;
	@FindBy(xpath = "//input[@id='customerNameInCheckBox']") 				WebElement contCountryname;
	@FindBy(xpath = "//input[@id='customerNameInCheckBox']") 				WebElement contStatename;
	@FindBy(xpath = "//input[@id='customerNameInCheckBox']") 				WebElement contAddress;
	@FindBy(xpath = "//input[@id='customerNameInCheckBox']") 				WebElement contDesignation;
	@FindBy(xpath = "//input[@id='dealTitle']") 							WebElement dealTitle;
	@FindBy(xpath = "//select[@id='rec_currency_type1']") 					WebElement dealCurrencytype;
	@FindBy(xpath = "//input[@id='dealValue']") 							WebElement dealValue;
	@FindBy(xpath = "//select[@id='dealOwnerNameListInPopup']") 			WebElement ownerNameDD;
    @FindBy(xpath = "//input[@id='expect_deal_date']")     				    WebElement expectedCloseDate;
	@FindBy(xpath="//select[@class='ui-datepicker-month']")        			WebElement expMonthDD;
	@FindBy(xpath="//select[@class='ui-datepicker-year']")        			WebElement expYearDD;
	@FindBy(xpath = "//input[@id='productRadio']") 							WebElement productType;
	@FindBy(xpath = "//input[@id='projectRadio']") 							WebElement projectType;
	@FindBy(xpath = "//button[@id='salesAddDealPopupId']") 					WebElement saveDeal;
	@FindBy(xpath = "//a[@id='rad1']") 										WebElement addLead;
    @FindBy(xpath = "//a[@id='rad2']") 										WebElement addQualifiedLead;
	@FindBy(xpath = "//a[@id='rad3']") 										WebElement addCustomerMeeting;
	@FindBy(xpath = "//a[@id='rad4']") 										WebElement addProposalSubmission;
	@FindBy(xpath = "//a[@id='rad5']") 										WebElement addNegotiationStage;
	
	/*
	Landing page Webelements with 5 stages
	*/
	@FindBy(xpath = "//span[text()='Lead']") 								WebElement pipeLead;
	@FindBy(xpath = "//span[text()='Qualified Lead']") 						WebElement qualifiedLead;
	@FindBy(xpath = "//span[text()='Customer Meeting']") 					WebElement customerMeeting;
	@FindBy(xpath = "//span[text()='Proposal Submission']") 				WebElement proposalSubmission;
	@FindBy(xpath = "//span[text()='Negotiation Stage']") 					WebElement negotiationStage;
	@FindBy(xpath = "//button[text()='Lost']") 								WebElement pipeLostbutton;
	@FindBy(xpath = "//button[text()='Won']") 								WebElement pipeWonbutton;
	@FindBy(xpath = "//select[@id='ownerSelectDropDown']") 					WebElement dragdropownerDD;
	@FindBy(xpath = "//textarea[@id='review_Owner_change']") 				WebElement dragdropStageremark;
	@FindBy(xpath = "//textarea[@id='remark_Owner_change']") 				WebElement dragdropOwnerremark;
	@FindBy(xpath = "//button[@id='salesDragDropDealPopupId']") 			WebElement dragdropSatgeupdateSave;
	@FindBy(xpath = "//button[@id='dealWonBtn']") 							WebElement landingWonButton;
	@FindBy(xpath = "//button[@id='dealLostBtn']") 							WebElement landingLostButton;
	@FindBy(xpath = "//h4[text()='Update Deal']") 							WebElement updateDealWindow;
	@FindBy(xpath = "//h4[text()='Mark As Won']") 							WebElement wonDealWindow;
	@FindBy(xpath = "//input[@id='deal_won_Amount']") 						WebElement wonFinaldealAmount;
	@FindBy(xpath = "//input[@id='deal_won_Date']") 						WebElement wonDealWindate;
	@FindBy(xpath = "//textarea[@id='landing_Won_Details']") 				WebElement wonReason;
	@FindBy(xpath = "//button[@id='landingPageWonDealPopupId']") 			WebElement markasWonbutton;
	@FindBy(xpath = "//h4[text()='Mark As Lost']") 							WebElement lostDealWindow;
	@FindBy(xpath = "//input[@id='deal_lost_Amount']") 						WebElement lostFinaldealAmount;
	@FindBy(xpath = "//input[@id='deal_lostTo_text']") 						WebElement lostTofield;
	@FindBy(xpath = "//input[@id='deal_lost_Date']") 						WebElement lostDealLosedate;
	@FindBy(xpath = "//textarea[@id='landing_Won_Details']") 				WebElement lostReason;
	@FindBy(xpath = "//button[@id='salesLostDealPopupId']") 				WebElement markasLostbutton;

	/*
	List page WebElements with deal calculation
	*/
	@FindBy(xpath = "//*[@id='itrequest_home_filter']/label/t") 			WebElement totalDealAmount;
	@FindBy(xpath = "//*[@id='itrequest_home_filter']/lainput") 			WebElement totalWonOpenAmount;
	@FindBy(xpath = "//select[@id='ownerSelectDropDownInListEditable_']") 	WebElement listownerNameDD;
	@FindBy(xpath = "//textarea[@id='update_Owner_Change_Name']") 			WebElement listOwnerRemark;
    @FindBy(xpath = "//button[@id='salesOwnersDragDropDealPopupId']") 		WebElement listOwnerSaveButton;
	@FindBy(xpath = "//div[@id='genericModal-buttons']/button[2]") 			WebElement listCloseButton;	

	/*
	Deals detail page Webelements with Changelogs
	*/
	@FindBy(xpath = "//span[@id='dealPrsDealTitle']") 						WebElement editDealtitle;
	@FindBy(xpath = "//div[@id='popover198016']/div[2]/span") 				WebElement editDealtitlelabel;
	@FindBy(xpath = "//div[@class='popover-content']/input[@id='renameDealTtl']") WebElement editTitlefield;
	@FindBy(xpath = "//div[@class='popover-content']/button[@id='saveDealBtn']")  WebElement editTitleSave;
	@FindBy(xpath = "//div[@class='popover-content']/button[@id='cancDealBtn']")  WebElement editTitleCancel;
	@FindBy(xpath = "//span[@id='dealPrsDealAmount']") 						WebElement editDealamount;
	@FindBy(xpath = "//span[@id='typeOfCurr']") 							WebElement editamountcurrType;
	@FindBy(xpath = "//div[@class='popover-content']/input[@id='renameDealCurrency']") 	WebElement editDealamountfield;
	@FindBy(xpath = "//div[@class='popover-content']/button[@id='saveDealCurrencyBtn']") WebElement editamountSave;
	@FindBy(xpath = "//div[@class='popover-content']/button[@id='cancDealCurrencyBtn']") 	WebElement editamountCancel;
	@FindBy(xpath = "//div[@class='popover-content']/select[@id='ownerSelectDropDownInDetailPage']") 	WebElement editCurrencyType;
	@FindBy(xpath = "//span[@id='dealPersonalCntFirstNme']") 				WebElement editContactFirstName;
	@FindBy(xpath = "//span[@id='dealPersonalCntLastNme']") 				WebElement editContactLastName;
	@FindBy(xpath = "//span[@id='dealPersonalOrgNme']") 					WebElement editCustomerName;
	@FindBy(xpath = "//span[@id='saveOrgName']") 							WebElement editCardCustomerName;
	@FindBy(xpath = "//button[@id='detailsEditId']") 						WebElement editiconCustName;
	@FindBy(xpath = "//div[@class='popover-content']/div/div/input[@id='editOrganizationName']") WebElement editcustomerNamefield;
	@FindBy(xpath = "//div[@class='popover-content']/div/div[2]/button[@id='saveBtn']") 	WebElement editcustomerNameSave;
	@FindBy(xpath = "//div[@class='popover-content']/div/div[2]/button[@id='cancleBtn']")  WebElement editcustomerNameCancel;
	@FindBy(xpath = "//button[@id='detailsEditPersonId']") 					WebElement editIconcontper;
	@FindBy(xpath = "//span[@id='contactPersonNameInList']") 				WebElement editCardcontperName;
	@FindBy(xpath = "//div[@class='popover-content']/div/div/input[@id='editPersonNameFN']") WebElement editcontFirstname;
	@FindBy(xpath = "//div[@class='popover-content']/div/div/input[@id='editPersonNameLN']") WebElement editcontLastname;
	@FindBy(xpath = "//div[@class='popover-content']/div/div[2]/button[@id='saveBtnPer']") 	 WebElement editcontSave;
	@FindBy(xpath = "//div[@class='popover-content']/div/div[2]/button[@id='cancelBtnPer']") WebElement editcontCancel;
	@FindBy(xpath = ".//*[@id='main_Content']/div/div[3]/div[3]/div/div[2]/div[2]/span[1]/svg") WebElement editClosuredate;
	@FindBy(xpath = "//div[@class='popover-content']/input[@id='expClsDateDeals']") WebElement editClosuredatefield;
	@FindBy(xpath = "//div[@class='popover-content']/button[@id='saveListbtn1']") WebElement editClosuredateSave;
	@FindBy(xpath = "//div[@class='popover-content']/span/button[@id='cnclListbtn1']") WebElement editClosuredateCancel;
	@FindBy(xpath = "//a[@onclick='takeNotesFunc()']") 						WebElement addNotes;
	@FindBy(xpath = "//textarea[@id='saveTextNote']") 						WebElement noteBox;
	@FindBy(xpath = "//button[@id='saveTakeNote']") 						WebElement noteSavebutton;
	@FindBy(xpath = "//button[@id='cleTakeNote']") 							WebElement noteCancel;
	@FindBy(xpath = "//span[@id='dealAgeDisplay']") 						WebElement dealAge;
	@FindBy(xpath = "//span[@id='createdDate']") 							WebElement dealCreatedDate;
	@FindBy(xpath = "//*[@id='attachment']") 								WebElement editDealAll;
	@FindBy(xpath = "//*[@id='attachment']") 								WebElement editDealNotes;
	@FindBy(xpath = "//*[@id='attachment']") 								WebElement editDealChangelog;
	@FindBy(xpath = "//span[text()='Lead']") 								WebElement editpipeLead;
	@FindBy(xpath = "//span[text()='Qualified Lead']") 						WebElement editqualifiedLead;
	@FindBy(xpath = "//span[text()='Customer Meeting']") 					WebElement editcustomerMeeting;
	@FindBy(xpath = "//span[text()='Proposal Submission']") 				WebElement editproposalSubmission;
	@FindBy(xpath = "//span[text()='Negotiation Stage']") 					WebElement editnegotiationStage;
	@FindBy(xpath = "//button[@id='lostindividualDeal']") 					WebElement editLostbutton;
	@FindBy(xpath = "//button[@id='wonindividualDeal']") 					WebElement editWonbutton;
	
	/*
	Forecast page Webelements with Lost & Won functionality.
	*/
	@FindBy(xpath = "//*[@id='view_attachment']") 							WebElement todayButton;
	@FindBy(xpath = "//button[@id='CloseItrequest']") 						WebElement monthNavigation;
	@FindBy(xpath = "//*[@id='ReopenItrequest1']") 							WebElement fourMonthnavigation;
	@FindBy(xpath = "//button[text()='Lost']") 								WebElement forecastLostbutton;
	@FindBy(xpath = "//button[text()='Won']") 								WebElement forecastWonbutton;
	
	/*
	Statistics page Webelements with Open/Won/Lost stats along with deal progress bar
	*/
	@FindBy(xpath = "//span[@id='dealStatDtlDeals1']") 						WebElement statsOpenDealcount;
	@FindBy(xpath = "//span[@id='dealStatDtlDeals2']") 						WebElement statsWonDealcount;
	@FindBy(xpath = "//span[@id='dealStatDtlDeals3']") 						WebElement statsLostDealcount;
	@FindBy(xpath = "//span[@id='dealStatDtlDeals4']") 						WebElement mostDealsstartedBY;
	@FindBy(xpath = "//span[@id='dealStatDtlDeals5']") 						WebElement mostdealsWonBy;
	@FindBy(xpath = "//h4[@id='genericModal-title']") 						WebElement genericModaltitle;
	@FindBy(xpath = "//div[@id='genericModal-buttons']/button") 			WebElement genericModalClose;
	@FindBy(xpath = "//span[text()='Deals Progress By Count']") 			WebElement dealCountProgress;
	@FindBy(xpath = "//b[text()='Deals Progress By Value']") 				WebElement dealValueProgress;
	@FindBy(xpath = "//span[@id='leadInCounts']") 							WebElement statspipeLead;
	@FindBy(xpath = "//span[@id='ContactMadeCounts']") 						WebElement statsqualifiedLead;
	@FindBy(xpath = "//span[@id='DemoScheduledCounts']") 					WebElement statscustomerMeeting;
	@FindBy(xpath = "//span[@id='ProposalMadeCounts']") 					WebElement statsproposalSubmission;
	@FindBy(xpath = "//span[@id='NegotiationStartedCounts']") 				WebElement statsnegotiationStage;
	
	/*
	Deal Report page Webelements with Won/Lost/Open vertical bar
	*/
	@FindBy(xpath = "//div[@id='main_Content']/div/div[3]/button[1]") 		WebElement previousYear;
	@FindBy(xpath = "//div[@id='main_Content']/div/div[3]/button[2]") 		WebElement nextYear;
	
	public void salesDrive() {
		sales.click();
		Waitfor(1);
		salesDriveModule.click();
		Waitfor(2);
	}

	public void saveValidation() {
		boolean saveSts = saveDeal.isDisplayed();
		if (saveSts == bTrue) {
			boolean saveButton = saveDeal.isEnabled();
			if (saveButton == bTrue) {
				saveDeal.click();
				Waitfor(1);
				Date date = new Date();
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				String createdDate= dateFormat.format(date);
			} else {
				logger.info("The Deal Save button is not enabled");
			}
		} else {
			logger.info("The Deal Save button is not displayed");
		}
	}

	public String dealSave() {
		saveDeal.click();
		Waitfor(1);
		return genericToastMsg.getText();
	}

	public void addDealValidation(int rownum) {
		Waitfor(2);
		boolean addsts = addDealButton.isDisplayed();
		if (addsts == bTrue) {
			boolean addDealsts = addDealButton.isEnabled();
			if (addDealsts == bTrue) {
				addDealButton.click();
				Waitfor(2);
				String addDealWin = addDealPopup.getText();
				if (addDealWin.equalsIgnoreCase("Add Deal")) {
					logger.info("The Add Deal Button is enabled and Clicked Successfully");
					Waitfor(2);
					saveValidation();
					custCheckbox();
					contactCheckbox();
					addCustomerNamevalidation(rownum);
					contfirstNamevalidation(rownum);
					customerNamevalidation(rownum);
					contactPerValidation(rownum);
					dealtitleValidation(rownum);
					dealValueValidation(rownum);
					ownerNameDD(rownum);
					expectedClosedate("No");
					dealType();
					productType();
					projectType();
				} else {
					logger.info("The Deal popup has not appeared");
				}
			} else {
				logger.info("Add Deal Button is not enabled");
			}
		} else {
			logger.info("Add Deal Button is not Displayed");
		}
	}

	public void customerNamevalidation(int rownum) {

		String custtoastmsg = dealSave();
		if (custtoastmsg.equalsIgnoreCase("Customer name is required")) {
			logger.info("The Customer Dropdown is perfectly validated");
			customerName(rownum);
		} else {
			logger.info("The Company Dropdown validation has not been done");
		}

	}

	public void customerName(int row) {
		String customername = "Infosys";// excelreaddata().getData(Pipedrive, row, 0); // Reading Customer name from
										// excel
		Select custDD = new Select(customerNameDD);
		custDD.selectByVisibleText(customername);
		Waitfor(1);
		String selcustomername = (String) ((JavascriptExecutor) driver).executeScript(
				"return document.getElementById('customer_Name_drop').options[document.getElementById('customer_Name_drop').selectedIndex].text");
		if (selcustomername.equalsIgnoreCase(customername)) {
			logger.info("The Customer name is selected and matching with the passed data");
		} else {
			logger.info("The Customer name is not selected or matching with the passed data");
		}
	}

	public void contactPerValidation(int rownum) {
		String conttoastmsg = dealSave();
		if (conttoastmsg.equalsIgnoreCase("Contact Person Name is Mandatory")) {
			logger.info("The Contact Person Dropdown is perfectly validated");
			contPerName(rownum);
		} else {
			logger.info("The Contact Person Dropdown validation has not been done");
		}
	}

	public void contPerName(int row) {
		String contPername = "Akash";// excelreaddata().getData(SHEETNAME, row, 0); // Reading Contact Person name from excel
		Select custDD = new Select(contPersonNameDD);
		custDD.selectByVisibleText(contPername);
		Waitfor(1);
		String selconPername = (String) ((JavascriptExecutor) driver).executeScript(
				"return document.getElementById('contactPersonName').options[document.getElementById('contactPersonName').selectedIndex].text");
		if (selconPername.equalsIgnoreCase(contPername)) {
			logger.info("The Contact Person name is selected and matching with the passed data");
		} else {
			logger.info("The Contact Person name is not selected or matching with the passed data");
		}
	}

	public void dealTitle(int row) {
		String dealtitle = "Samsung";// excelreaddata().getData(SHEETNAME, row, 0); // Reading Contact Person name from excel
		dealTitle.sendKeys(Keys.chord(Keys.CONTROL, "a"), dealtitle);
		Waitfor(1);
		String seldealTitle = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.getElementById('dealTitle').value");
		if (seldealTitle.equalsIgnoreCase(dealtitle)) {
			logger.info("Deal Title is matching with the passed data");
		} else {
			logger.error("Deal Title is matching with the passed data");
		}
	}

	public void dealtitleValidation(int rownum) {
		String dealtitletoast = dealSave();
		if (dealtitletoast.equalsIgnoreCase("Deal Title is Mandatory")) {
			logger.info("The Deal Title is perfectly validated");
			dealTitle(rownum);
		} else {
			logger.error("The Deal Title validation has not been done");
		}
	}

	public void dealValueValidation(int rownum) {
		String valuetoastmsg = dealSave();
		if (valuetoastmsg.equalsIgnoreCase("")) {
			logger.info("The Deal value is perfectly validated");
			dealValue(rownum);
		} else {
			logger.info("The Deal value validation has not been done");
		}
	}

	public void dealValue(int row) {
		String dealAmount = "85500";// excelreaddata().getData(SHEETNAME, row, 0); // Reading Contact Person name from excel
		dealValue.sendKeys(Keys.chord(Keys.CONTROL, "a"), "Qwerty@!");
		Waitfor(1);
		String dealalphaValue = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.getElementById('dealValue').value");
		if (dealalphaValue.equalsIgnoreCase("Qwerty@!")) {
			logger.info("Deal value field shouldn't accept the Alphanumeric");
		} else {
			logger.info("The Deal value is accepting only numeric value");
		}
		dealValue.sendKeys(Keys.chord(Keys.CONTROL, "a"), dealAmount);
		Waitfor(1);
		String seldealamnt = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.getElementById('dealValue').value");
		if (seldealamnt.equalsIgnoreCase(dealAmount)) {
			logger.info("The Deal Value matching with the passed data");
		} else {
			logger.info("The Deal Value not matching with the passed data");
		}
	}

	public String expectedClosedate(String listStatus) {

		// Selecting the Expected Close Date from the date picker.
		Random random = new Random();
		int minDay = (int) LocalDate.of(2018, 6, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(2018, 12, 1).toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);

		LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
		int ranDate = randomBirthDate.getDayOfMonth();
		String expDate = String.valueOf(ranDate);
		int monthDigit = randomBirthDate.getMonthValue();
		String month = String.valueOf(monthDigit);
		int ranYear = randomBirthDate.getYear();
		String expYear = String.valueOf(ranYear);
		Month ranMonth = randomBirthDate.getMonth();
		String expMonth = String.valueOf(ranMonth);
		String selMonth = expMonth.substring(0, 1) + expMonth.substring(1, 3).toLowerCase();
		if (ranDate < 10) {
			expDate = "0" + expDate;
		}
		if (monthDigit < 10) {
			month = "0" + month;
		}

		if (!listStatus.equalsIgnoreCase("Yes")) {
			expectedCloseDate.click();
		}

		Waitfor(1);
		Select monthdd = new Select(expMonthDD);
		monthdd.selectByVisibleText(selMonth);

		Select yeardd = new Select(expYearDD);
		yeardd.selectByVisibleText(expYear);

		List<WebElement> dojdates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
		for (int i = 0; i < dojdates.size(); i++) {
			String dojdate = dojdates.get(i).getText();

			if (dojdate.equals(String.valueOf(ranDate)) && (dojdate != "")) {

				dojdates.get(i).click();

				logger.info("Selected date is: " + expDate + "-" + expMonth + "-" + expYear);
				passedexpclose = expDate + "-" + month + "-" + expYear;
				if (!listStatus.equalsIgnoreCase("Yes")) {
					String selExpClose = (String) ((JavascriptExecutor) driver)
							.executeScript("return document.getElementById('expect_deal_date').value");
					if (selExpClose.equalsIgnoreCase(passedexpclose)) {
						logger.info("The Expected Close date is selected and matching with the passed data");
					} else {
						logger.info("The Expected Close date is not selected or matching with the passed data");
					}
				}
				break;
			}
		}
		return passedexpclose;
	}

	public void ownerNameDD(int rownum) {
		String salesEMPname = "Ashish Lall";// getaccHldrName();
		String loginownerName = (String) ((JavascriptExecutor) driver).executeScript(
				"return document.getElementById('dealOwnerNameListInPopup').options[document.getElementById('dealOwnerNameListInPopup').selectedIndex].text");
		if (salesEMPname.equalsIgnoreCase(loginownerName)) {
			logger.info("The owner name is set deafult with the Login name");
		} else {
			logger.error("The owner name is not set deafult with the Login name");
		}
		String newOwnername = "Anchal Sethi";// excelreaddata().getData(SHEETNAME, rownum, 0); // Reading Contact Person name from excel
		Select custDD = new Select(ownerNameDD);
		custDD.selectByVisibleText(newOwnername);
		Waitfor(1);
		String selownername = (String) ((JavascriptExecutor) driver).executeScript(
				"return document.getElementById('dealOwnerNameListInPopup').options[document.getElementById('dealOwnerNameListInPopup').selectedIndex].text");
		if (selownername.equalsIgnoreCase(newOwnername)) {
			logger.info("The Owner name is selected and matching with the passed data");
		} else {
			logger.error("The Owner name is not selected or matching with the passed data");
		}
	}

	public void dealType() {
		boolean prodSts = productType.isSelected();
		boolean projSts = projectType.isSelected();
		if (prodSts == bTrue || projSts == bTrue) {
			logger.info("The Deal type radio button shouldn't be selected at first");
		} else {
			logger.error("The Deal type radio button is not selected at first");
		}
		String typeToastmsg = dealSave();
		if (typeToastmsg.equalsIgnoreCase("Deal type is required")) {
			logger.info("The Deal type is perfectly validated");
		} else {
			logger.error("The Deal type validation has not been done");
		}
	}

	public void productType() {
		productType.click();
		Waitfor(1);
		boolean prodsts = productType.isSelected();
		if (prodsts == bFalse) {
			logger.error("The Product type radio button is not selected even after click");
		} else {
			logger.info("The Product type is selected");
		}
	}

	public void projectType() {
		projectType.click();
		Waitfor(1);
		boolean prodsts = projectType.isSelected();
		if (prodsts == bFalse) {
			logger.error("The Project type radio button is not selected even after click");
		} else {
			logger.info("The Project type is selected");
		}
	}

	public String addLead() {
		String leadSts = addLead.getAttribute(ATTR_NAME);
		if (leadSts.equalsIgnoreCase(CLASS_STATUS)) {
			logger.info("Lead Stage is active");
		}
		return leadSts;
	}

	public String qualifiedLead() {
		String qualifiedSts = addQualifiedLead.getAttribute(ATTR_NAME);
		if (qualifiedSts.equalsIgnoreCase(CLASS_STATUS)) {
			logger.info("Qualified Stage is active");
		}
		return qualifiedSts;
	}

	public String customerMeeting() {
		String customerSts = addCustomerMeeting.getAttribute(ATTR_NAME);
		if (customerSts.equalsIgnoreCase(CLASS_STATUS)) {
			logger.info("Meeting Stage is active");
		}
		return customerSts;
	}

	public String proposalSubmission() {
		String proposalSts = addProposalSubmission.getAttribute(ATTR_NAME);
		if (proposalSts.equalsIgnoreCase(CLASS_STATUS)) {
			logger.info("Proposal Stage is active");
		}
		return proposalSts;
	}

	public String negotiationStage() {
		String negotiationSts = addNegotiationStage.getAttribute(ATTR_NAME);
		if (negotiationSts.equalsIgnoreCase(CLASS_STATUS)) {
			logger.info("Negotiation Stage is active");
		}
		return negotiationSts;
	}

	public void custCheckbox() {
		Select dropdown = new Select(customerNameDD);
		List<WebElement> length = dropdown.getOptions();
		int size = length.size();
		if (size <= 0) {
			boolean custDDsts = customerNameDD.isEnabled();
			boolean custSts = customerExtrainfoCheckbox.isSelected();
			if (custSts == bTrue && custDDsts == bFalse) {
				logger.info("Customer CheckBox selected by default when No customer name is there");
			} else {
				logger.error("Customer CheckBox  is not selected by default when no customer name found");
			}
		}
		else {
			logger.info("Customer Name DD already has data in it");
		}
	}

	public void addCustomerNamevalidation(int rownum) {
		boolean custSts = customerExtrainfoCheckbox.isSelected();
		if (custSts == bTrue) {
			String extCust = dealSave();
			if (extCust.equalsIgnoreCase("Customer Name is Mandatory")) {
				logger.info("Extra Customer Name field is perfectly validated");
				addcustomerName(rownum);
			} else {
				logger.info("Extra Customer Name field validation is not properly done");
			}
		}
	}

	public void addcustomerName(int row) {
		String extcustomername = "Accenture";// excelreaddata().getData(SHEETNAME, row, 0); // Reading Customer name
												// from excel
		customerName.sendKeys(Keys.chord(Keys.CONTROL, "a"), extcustomername);
		Waitfor(1);
		String selcustomername = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.getElementById('customerNameInCheckBox').value");
		if (selcustomername.equalsIgnoreCase(extcustomername)) {
			logger.info("The Extra Customer name is selected and matching with the passed data");
		} else {
			logger.info("The Extra Customer name is not selected or matching with the passed data");
		}
	}
	public void custCountry() {
		String country = "India";// excelreaddata().getData(SHEETNAME, row, 0); // Reading Country name from
									// excel
		Select dropdown = new Select(custCountryname);
		List<WebElement> length = dropdown.getOptions();
		int size = length.size();
		if (size > 0) {
			dropdown.selectByVisibleText(country);
			Waitfor(1);
			String selcountry = (String) ((JavascriptExecutor) driver).executeScript(
					"return document.getElementById('dealOwnerNameListInPopup').options[document.getElementById('dealOwnerNameListInPopup').selectedIndex].text");
			if (selcountry.equalsIgnoreCase(country)) {
				logger.info("Selected Country Name is matching with the passed data");

			} else {
				logger.error("Selected Country Name is not matching with the passed data");
			}
		} else {
			logger.error("No existing data is populating in Customer Country DD");
		}
	}

	public void custState() {
		String state = "India";// excelreaddata().getData(SHEETNAME, row, 0); // Reading Country name from
								// excel
		Select dropdown = new Select(custCountryname);
		List<WebElement> length = dropdown.getOptions();
		int size = length.size();
		if (size > 0) {
			dropdown.selectByVisibleText(state);
			Waitfor(1);
			String selcountry = (String) ((JavascriptExecutor) driver).executeScript(
					"return document.getElementById('dealOwnerNameListInPopup').options[document.getElementById('dealOwnerNameListInPopup').selectedIndex].text");
			if (selcountry.equalsIgnoreCase(state)) {
				logger.info("Selected Sate is matching with the passed data");

			} else {
				logger.error("Selected State is not matching with the passed data");
			}
		} else {
			logger.error("No existing data is populating in Customer State DD");
		}
	}

	public void custAddress()
	{
		String address= "#352, HM.Geneva House, Cunningham Road-560062";// excelreaddata().getData(SHEETNAME, row, 0); // Reading Country name from excel
		custAddress.sendKeys(Keys.chord(Keys.CONTROL, "a"), address);
		Waitfor(1);
		String seladdress = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.getElementById('customerNameInCheckBox').value");
		if (seladdress.equalsIgnoreCase(address)) {
			logger.info("Customer Address is matching with the passed data");
		} else {
			logger.error("Customer Address is not matching with the passed data");
		}
		
	}
	
	public void industryTypeDD()
	{
		String indusName = "Healthcare";//excelreaddata().getData(SHEETNAME, row, 0); // Reading industry name from excel
		String selIndusname = (String) ((JavascriptExecutor) driver).executeScript(
				"return document.getElementById('dealOwnerNameListInPopup').options[document.getElementById('dealOwnerNameListInPopup').selectedIndex].text");
		if (selIndusname.equalsIgnoreCase(indusName)) {
			logger.info("The Industry name is matching with the passed data");
		} else {
			logger.error("The Industry name is not matching with the passed data");
		}
	}
	
	public void industryName() {
		boolean indCheckbox = addIndustrycheckbox.isSelected();
		if (indCheckbox == bFalse) {
			addIndustrycheckbox.click();
			Waitfor(1);
			boolean industryName = industryname.isDisplayed();
			if (industryName == bTrue) {
				String indusName = "Sales"; // excelreaddata().getData(SHEETNAME, row, 0); // Reading industry name from excel
				Waitfor(1);
				String selIndName = (String) ((JavascriptExecutor) driver)
						.executeScript("return document.getElementById('customerNameInCheckBox').value");
				if (selIndName.equalsIgnoreCase(indusName)) {
					logger.info("Industry name matching with the passed data");
				} else {
					logger.error("Industry name is not matching with the passed data");
				}
			} else {
				logger.error("Industry name field is not present on checkbox click");
			}
		} else {
			logger.error("The Industry Check Box should not be selected by default");
		}
	}
	
	public void custcontactNo(int row) {
		String extcontactno = "854892067";// excelreaddata().getData(SHEETNAME, row, 0); // Reading Customer name from
											// excel
		contContactno.sendKeys(Keys.chord(Keys.CONTROL, "a"), ALPHACHAR);
		Waitfor(1);
		String contactperson = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.getElementById('custPhoneNumInCheck').value");
		if (contactperson.equalsIgnoreCase(ALPHACHAR)) {
			logger.info("The Contact No field shouldn't accept the alphnumeric character");
		} else {
			logger.error("The Contact No field is not accepting alphnumeric character");
		}
		contContactno.clear();
		contContactno.sendKeys(extcontactno);
		Waitfor(1);
		String selcontactperson = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.getElementById('custPhoneNumInCheck').value");
		if (selcontactperson.equalsIgnoreCase(extcontactno)) {
			logger.info("The Contact No field is accepting only numeric character");
		} else {
			logger.error("The Contact No field is not accepting even numeric character");
		}
	}
	
	public void custMailID(int row) {
		String custMail = "qwerty@gmail.com";// excelreaddata().getData(SHEETNAME, row, 0); // Reading Customer name
												// from excel
		custMailID.sendKeys(Keys.chord(Keys.CONTROL, "a"), "qwerty1234");
		Waitfor(1);
		String mailToast = dealSave();
		if (mailToast.equalsIgnoreCase("Enter Valid Mail-ID")) {
			logger.info("Customer Mail Id field is perfectly validated");
		} else {
			logger.error("Customer Mail Id field is not validated properly");
		}
		custMailID.sendKeys(Keys.chord(Keys.CONTROL, "a"), custMail);
		String mailIDToast = dealSave();
		if (mailIDToast.equalsIgnoreCase("Deal Value is mandatory")
				|| mailIDToast.equalsIgnoreCase("Product Type is mandatory")) {
			logger.info("Customer Mail ID with domain is perfectly validated");
		} else {
			logger.error("Customer Mail ID with domain is not properly validated");
		}

	}

	/*
	Contact Person different field validation
    */	
	public void contactCheckbox() {
		Select dropdown = new Select(contPersonNameDD);
		List<WebElement> length = dropdown.getOptions();
		int size = length.size();
		if (size <= 0) {
			boolean contDDsts = contPersonNameDD.isEnabled();
			boolean contSts = customerExtrainfoCheckbox.isSelected();
			if (contSts == bTrue && contDDsts == bFalse) {
				logger.info("Contact CheckBox selected by default when No customer name is there");
			} else {
				logger.error("Contact CheckBox is not selected by default when no customer name found");
			}
		}else {
			logger.info("The Contact Person DD already has data in it");
		}
	}

	public void contfirstNamevalidation(int rownum) {
		boolean contSts = continfoCheckbox.isSelected();
		if (contSts == bTrue) {
			String extCont = dealSave();
			if (extCont.equalsIgnoreCase("Contact Person Name is Mandatory")) {
				logger.info("Contact Person First name field is perfectly validated");
				contfirstName(rownum);
			} else {
				logger.error("Contact Person First name field validation is not properly done");
			}
		}
	}

	public void contfirstName(int row) {
		String confirstname = "Vikash";// excelreaddata().getData(SHEETNAME, row, 0); // Reading Customer name from
											// excel
		contFirstpersonname.sendKeys(Keys.chord(Keys.CONTROL, "a"), confirstname);
		Waitfor(1);
		String selcontname = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.getElementById('ContactNameInCheckBox').value");
		if (selcontname.equalsIgnoreCase(confirstname)) {
			logger.info("Contact Person first name is selected and matching with the passed data");
		} else {
			logger.error("Contact Person first name is not selected/matching with the passed data");
		}
	}
	
	public void contlastNamevalidation(int rownum) {
		boolean contSts = continfoCheckbox.isSelected();
		if (contSts == bTrue) {
			String extCont = dealSave();
			if (extCont.equalsIgnoreCase("Contact Person Name is Mandatory")) {
				logger.info("Contact Person Last name field is perfectly validated");
				contlastName(rownum);
			} else {
				logger.info("Contact Person Last name field validation is not properly done");
			}
		}
	}

	public void contlastName(int row) {
		String extcontactname = "Vikash";// excelreaddata().getData(SHEETNAME, row, 0); // Reading Customer name from
											// excel
		contLastpersonname.sendKeys(Keys.chord(Keys.CONTROL, "a"), extcontactname);
		Waitfor(1);
		String selcontactname = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.getElementById('ContactNameInCheckBox').value");
		if (selcontactname.equalsIgnoreCase(extcontactname)) {
			logger.info("Contact person last name is selected and matching with the passed data");
		} else {
			logger.info("Contact person last name is not selected/matching with the passed data");
		}
	}

	public void contCountry() {
		String country = "India";// excelreaddata().getData(SHEETNAME, row, 0); // Reading Country name from
									// excel
		Select dropdown = new Select(custCountryname);
		List<WebElement> length = dropdown.getOptions();
		int size = length.size();
		if (size > 0) {
			dropdown.selectByVisibleText(country);
			Waitfor(1);
			String selcountry = (String) ((JavascriptExecutor) driver).executeScript(
					"return document.getElementById('dealOwnerNameListInPopup').options[document.getElementById('dealOwnerNameListInPopup').selectedIndex].text");
			if (selcountry.equalsIgnoreCase(country)) {
				logger.info("Selected Country Name is matching with the passed data");

			} else {
				logger.error("Selected Country Name is not matching with the passed data");
			}
		} else {
			logger.error("No existing data is populating in Customer Country DD");
		}
	}

	public void contState() {
		String state = "India";// excelreaddata().getData(SHEETNAME, row, 0); // Reading Country name from
								// excel
		Select dropdown = new Select(custCountryname);
		List<WebElement> length = dropdown.getOptions();
		int size = length.size();
		if (size > 0) {
			dropdown.selectByVisibleText(state);
			Waitfor(1);
			String selcountry = (String) ((JavascriptExecutor) driver).executeScript(
					"return document.getElementById('dealOwnerNameListInPopup').options[document.getElementById('dealOwnerNameListInPopup').selectedIndex].text");
			if (selcountry.equalsIgnoreCase(state)) {
				logger.info("Selected State is matching with the passed data");

			} else {
				logger.error("Selected State is not matching with the passed data");
			}
		} else {
			logger.error("No existing data is populating in Customer State DD");
		}
	}

	public void contAddress()
	{
		String address= "#352, HM.Geneva House, Cunningham Road-560062";// excelreaddata().getData(SHEETNAME, row, 0); // Reading Country name from excel
		contAddress.sendKeys(Keys.chord(Keys.CONTROL, "a"), address);
		Waitfor(1);
		String seladdress = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.getElementById('customerNameInCheckBox').value");
		if (seladdress.equalsIgnoreCase(address)) {
			logger.info("Address is matching with the passed data");
		} else {
			logger.error("Address is not matching with the passed data");
		}
		
	}
	
	public void conPercontactNo(int row) {
		String extcontactno = "8568754563";// excelreaddata().getData(SHEETNAME, row, 0); // Reading Customer name from
											// excel
		contContactno.sendKeys(Keys.chord(Keys.CONTROL, "a"), ALPHACHAR);
		Waitfor(1);
		String contactpersonno = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.getElementById('ContactPhoneNumInCheck').value");
		if (contactpersonno.equalsIgnoreCase(ALPHACHAR)) {
			logger.info("The Contact No field shouldn't accept the alphnumeric character");
		} else {
			logger.info("The Contact No field is not accepting alphnumeric character");
		}
		contContactno.clear();
		contContactno.sendKeys(extcontactno);
		Waitfor(1);
		String selcontactperson = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.getElementById('ContactPhoneNumInCheck').value");
		if (selcontactperson.equalsIgnoreCase(extcontactno)) {
			logger.info("The Contact No field is accepting only numeric character");
		} else {
			logger.info("The Contact No field is not accepting even numeric character");
		}
	}

	public void contMailID(int row) {
		String contMail = "conatct@rediff.com";// excelreaddata().getData(SHEETNAME, row, 0); // Reading Customer name from excel
		contMailID.sendKeys(Keys.chord(Keys.CONTROL, "a"), "qwerty1234");
		Waitfor(1);
		String mailToast = dealSave();
		if (mailToast.equalsIgnoreCase("Enter Valid Mail-ID")) {
			logger.info("Contact Mail Id field is perfectly validated");
		} else {
			logger.info("Contact Mail Id field is not validated properly");
		}
		contMailID.sendKeys(Keys.chord(Keys.CONTROL, "a"), contMail);
		String mailIDToast = dealSave();
		if (mailIDToast.equalsIgnoreCase("Deal Value is mandatory")
				|| mailIDToast.equalsIgnoreCase("Product Type is mandatory")) {
			logger.info("Contact Mail ID with domain is perfectly validated");
		} else {
			logger.info("Contact Mail ID with domain is perfectly validated");
		}
	}

	public void custCheckboxfieldsValidation(int rownum) {
		Select dropdown = new Select(customerNameDD);
		List<WebElement> length = dropdown.getOptions();
		int size = length.size();
		if (size > 0) {
			boolean custSts = customerExtrainfoCheckbox.isSelected();
			if (custSts == bFalse) {
				customerExtrainfoCheckbox.click();
				Waitfor(1);
				boolean custDDsts = customerNameDD.isEnabled();
				if (custDDsts == bFalse) {
					logger.info("On select of customer checkBox, it is disabling the Customer Dropdown");
					customerNamevalidation(rownum);
					custcontactNo(rownum);
					custMailID(rownum);
				}
			} else {
				logger.info("On select of customer checkBox, it is not disabling the Customer Dropdown");
			}
		}
	}

	public void contCheckboxfieldsValidation(int rownum) {
		Select dropdown = new Select(contPersonNameDD);
		List<WebElement> length = dropdown.getOptions();
		int size = length.size();
		if (size > 0) {
			boolean contSts = continfoCheckbox.isSelected();
			if (contSts == bFalse) {
				continfoCheckbox.click();
				Waitfor(1);
				boolean contDDsts = contPersonNameDD.isEnabled();
				if (contDDsts == bFalse) {
					logger.info("On select of Contact checkBox, it is disabling the Conatct Dropdown");
					contfirstNamevalidation(rownum);
					conPercontactNo(rownum);
					contMailID(rownum);
				}
			} else {
				logger.info("On select of Contact checkBox, it is not disabling the Contact Dropdown");
			}
		}
	}

	/*
	 * Drag & Drop deals on different Stages.
	 */
	public String dealDragNDrop(String dealName, String dealStage) {
		Actions action = new Actions(driver);
		String dealXpath = "//span[text()=" + "'" + dealName + "'" + "]";
		WebElement src = driver.findElement(By.xpath(dealXpath));
		List<WebElement> stages = driver
				.findElements(By.xpath("//table[@id='leadDblClick']/tbody/tr[1]/td/div/ul/li/span[1]"));
		for (int i = 0; i < stages.size(); i++) {
			String stageName = stages.get(i).getText();
			if (stageName.equalsIgnoreCase(dealStage)) {
				dealOwner = driver
						.findElement(
								By.xpath(dealXpath + "/parent::strong/parent::div/parent::li/div[1]/div/small/span[3]"))
						.getText();
				WebElement dest = driver.findElement(
						By.xpath("//table[@id='leadDblClick']/tbody/tr[2]/td/div[1]/div/div[" + (i + 1) + "]"));
				action.dragAndDrop(src, dest).build().perform();
				Waitfor(2);
				String updateDealwin = updateDealWindow.getText();
				if (updateDealwin.equalsIgnoreCase("Update Deal")) {
					logger.info("On drag & drop, Update stage window has popped up");
				} else {
					logger.error("On drag & drop, Update stage window has not popped up");
				}
			}
		}
		return dealOwner;
	}
	
	/*
	Owner change functionality validation
	*/
	public void ownerChangepopup(String ownerName) {
		Select dropdown = new Select(dragdropownerDD);
		dropdown.selectByVisibleText(ownerName);
		Waitfor(1);
	}

	public void onwerDDValidation() {
		String ownerName = (String) ((JavascriptExecutor) driver).executeScript(
				"return document.getElementById('ownerSelectDropDown').options[document.getElementById('ownerSelectDropDown').selectedIndex].text");
		if (ownerName.equalsIgnoreCase(dealOwner)) {
			logger.info("The active owner is defaultly set in the Owner Name DD");
		} else {
			logger.error("The active owner is not defaultly set in the Owner Name DD");
		}
	}
	
	public void ownerupdateRemark(String remark) {
		boolean ownremark = dragdropOwnerremark.isDisplayed();
		if (ownremark == bTrue) {
			String remarkToast = stageSaveValidation();
			if (remarkToast.equalsIgnoreCase("Owner remark is Mandatory")) {
				dragdropOwnerremark.sendKeys(Keys.chord(Keys.CONTROL, "a"), remark);
			} else {
				logger.error("Owner update save button has not validate the empty remark field");
			}
		}else {
			logger.error("Owner Remark field is not displayed");
		}
	}

	public void updatedOwnerValid(String updOwner, String dealName) {
		String dealXpath = "//span[text()=" + "'" + dealName + "'" + "]";
		dealOwner = driver
				.findElement(By.xpath(dealXpath + "/parent::strong/parent::div/parent::li/div[1]/div/small/span[3]"))
				.getText();
		if (updOwner.equalsIgnoreCase(dealOwner)) {
			logger.info("The respective deal card has Updated owner name");
		} else {
			logger.info("The respective deal card doesn't have Updated owner name");
		}
	}
	
	/*
	Stage Update functionality validation
	*/
	public void stageupdateRemark(String remark) {
		String remarkToast = stageSaveValidation();
		if (remarkToast.equalsIgnoreCase("Stage remark is Mandatory")) {
			dragdropStageremark.sendKeys(Keys.chord(Keys.CONTROL, "a"), remark);
		} else {
			logger.info("Stage update save button has not validate the empty remark field");
		}
	}

	public void stageSave() {
		boolean saveSts = dragdropSatgeupdateSave.isDisplayed();
		if (saveSts == bTrue) {
			boolean saveButton = dragdropSatgeupdateSave.isEnabled();
			if (saveButton == bTrue) {
				dragdropSatgeupdateSave.click();
				Waitfor(1);
			} else {
				logger.info("The Stage update Save button is not enabled");
			}
		} else {
			logger.info("The Stage Update Save button is not displayed");
		}
	}
	
	public String stageSaveValidation() {
		dragdropSatgeupdateSave.click();
		Waitfor(1);
		return genericToastMsg.getText();
	}

	/*
	Won/Lost change functionality validation
	*/
	public void wonDeallanding() {
		String dealwon = wonDealWindow.getText();
		if (dealwon.equalsIgnoreCase("Mark As Won")) {
			logger.info("On drag & drop, Won deal window has popped up");
		} else {
			logger.info("On drag & drop, Won deal window has not popped up");
		}
	}

	public void wondealpopup() {
		boolean wonSts = markasWonbutton.isDisplayed();
		if (wonSts == bTrue) {
			boolean markWonbutton = markasWonbutton.isEnabled();
			if (markWonbutton == bTrue) {
				markasWonbutton.click();
				Waitfor(1);
			} else {
				logger.info("The Mark as Won button is not enabled");
			}
		} else {
			logger.info("The Mark as Won button is not displayed");
		}
	}

	public void wonfinalamount(int row) {
		wonfinalamount = "45000";// excelreaddata().getData(SHEETNAME, row, 0); // Reading WonFinal Amount from  excel
		wonFinaldealAmount.sendKeys(Keys.chord(Keys.CONTROL, "a"), wonfinalamount);
	}
	
	public void winDate() {
		wonDealWindate.click();
		wonDealWindate.sendKeys(Keys.chord(Keys.CONTROL, "a"), "04-07-2018");
	}

	public void wonRemarkvalidation() {
		String remarkToast = markWonbuttonvalidation();
		if (remarkToast.equalsIgnoreCase("Won Reason is Mandatory")) {
			wonremark= "45000";// excelreaddata().getData(SHEETNAME, row, 0); // Reading Won Remark from  excel
			wonReason.sendKeys(Keys.chord(Keys.CONTROL, "a"), wonremark);
		} else {
			logger.info("Mark as Won button has not validate the empty remark field");
		}
	}

	public String markWonbuttonvalidation() {
		markasWonbutton.click();
		Waitfor(1);
		return genericToastMsg.getText();
	}

	public void lostDeallanding() {
		String deallost = lostDealWindow.getText();
		if (deallost.equalsIgnoreCase("Mark As Lost")) {
			logger.info("On drag & drop, Lost deal window has popped up");
		} else {
			logger.info("On drag & drop, Lost deal window has not popped up");
		}
	}

	public void lostdealpopup() {
		boolean lostSts = markasLostbutton.isDisplayed();
		if (lostSts == bTrue) {
			boolean markWonbutton = markasLostbutton.isEnabled();
			if (markWonbutton == bTrue) {
				markasLostbutton.click();
				Waitfor(1);
			} else {
				logger.info("The Mark as Won button is not enabled");
			}
		} else {
			logger.info("The Mark as Won button is not displayed");
		}
	}

	public void lostfinalamount(int row) {
		lostfinalamount = "45000";// excelreaddata().getData(SHEETNAME, row, 0); // Reading WonFinal Amount from  excel
		lostFinaldealAmount.sendKeys(Keys.chord(Keys.CONTROL, "a"), lostfinalamount);
	}
	
	public void loseDate() {
		lostDealLosedate.click();
		lostDealLosedate.sendKeys(Keys.chord(Keys.CONTROL, "a"), "01-07-2018");
	}
	
	public void lostRemarkvalidation() {
		String remarkToast = markLostbuttonvalidation();
		if (remarkToast.equalsIgnoreCase("Lost Reason is Mandatory")) {
			lostremark= "45000";// excelreaddata().getData(SHEETNAME, row, 0); // Reading Lost Remark from  excel
			lostReason.sendKeys(Keys.chord(Keys.CONTROL, "a"), lostremark);
		} else {
			logger.info("Mark as Lost button has not validate the empty remark field");
		}
	}

	public String markLostbuttonvalidation() {
		markasLostbutton.click();
		Waitfor(1);
		return genericToastMsg.getText();
	}

	public void dealWOnlost(String dealName, String dealStatus) {
		Actions action = new Actions(driver);
		String dealXpath = "//span[text()=" + "'" + dealName + "'" + "]";
		WebElement src = driver.findElement(By.xpath(dealXpath));
		if (dealStatus.equalsIgnoreCase("Won")) {
			boolean wonSts = landingWonButton.isDisplayed();
			if (wonSts == bTrue) {
				boolean wonbuttonSts = landingWonButton.isEnabled();
				if (wonbuttonSts == bFalse) {
					action.click(src).build().perform();
					boolean wonbutton = landingWonButton.isEnabled();
					if (wonbutton == bTrue) {
						landingWonButton.click();
						Waitfor(1);
						wonDeallanding();
						wonRemarkvalidation();
						wondealpopup();
					}
				}
			}
		} else if (dealStatus.equalsIgnoreCase("Lost")) {
			boolean lostSts = landingLostButton.isDisplayed();
			if (lostSts == bTrue) {
				boolean lostbuttonSts = landingLostButton.isEnabled();
				if (lostbuttonSts == bFalse) {
					action.click(src).build().perform();
					boolean lostbutton = landingLostButton.isEnabled();
					if (lostbutton == bTrue) {
						landingLostButton.click();
						Waitfor(1);
						lostDeallanding();
						lostRemarkvalidation();
						lostdealpopup();
					}
				}
			}
		}
	}

	/*
	 * List page validation function
	 */

	public void getlistItem(String dealName, String fieldName) {
		Actions action = new Actions(driver);
		int count = 0;
		String coltext = "Title";
		WebElement table = driver.findElement(By.xpath("//table[@id='tableForList']/thead/tr"));
		List<WebElement> heading = table.findElements(By.tagName("th"));
		for (int h = 0; h < heading.size(); h++) {
			String text = heading.get(h).getText();
			if (coltext.equalsIgnoreCase(text)) {
				int col = h;
				WebElement rowtable = driver.findElement(By.xpath("//table[@id='tableForList']/tbody"));
				List<WebElement> rows = rowtable.findElements(By.tagName("tr"));
				logger.info(rows.size());
				for (int r = 1; r <= rows.size(); r++) {
					String cellValue = driver
							.findElement(By.xpath(
									"//table[@id='tableForList']/tbody/tr[" + r + "]/td[" + (col + 1) + "]/span[1]"))
							.getText();
					Waitfor(1);
					if (cellValue.equalsIgnoreCase(dealName)) {
						WebElement coltable = driver.findElement(By.xpath("//table[@id='tableForList']/tbody/tr"));
						List<WebElement> columns = coltable.findElements(By.tagName("td"));
						logger.info(columns.size());
						for (int c = 1; c <= columns.size(); c++) {
							if (fieldName.equalsIgnoreCase("Title")) {
								WebElement onHover = driver.findElement(
										By.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td[" + (c) + "]"));
								WebElement cursor = driver.findElement(By
										.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td[" + c + "]/button"));
								Action edit = action.moveToElement(onHover).click(cursor).build();
								edit.perform();
								Waitfor(1);
								driver.findElement(By.xpath(
										"//table[@id='tableForList']/tbody/tr[" + r + "]/td[" + c + "]/div/div/input"))
										.clear();
								driver.findElement(By.xpath(
										"//table[@id='tableForList']/tbody/tr[" + r + "]/td[" + c + "]/div/div/button"))
										.click();
								String titleToast = genericToastMsg.getText();
								if (titleToast.equalsIgnoreCase("Please Fill Deal Title")) {
									logger.info("Title field is properly validated");
									driver.findElement(By.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td["
											+ c + "]/div/div/input")).sendKeys("Tech Mahindra");
									driver.findElement(By.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td["
											+ c + "]/div/div/button")).click();
									Waitfor(2);
									count++;
								}
							} else if (fieldName.equalsIgnoreCase("Value")) {
								WebElement onHover = driver.findElement(By
										.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td[" + (c + 1) + "]"));
								WebElement cursor = driver.findElement(By.xpath(
										"//table[@id='tableForList']/tbody/tr[" + r + "]/td[" + (c + 1) + "]/button"));
								Action edit = action.moveToElement(onHover).click(cursor).build();
								edit.perform();
								Waitfor(1);
								driver.findElement(By.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td["
										+ (c + 1) + "]/div/div/input")).clear();
								driver.findElement(By.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td["
										+ (c + 1) + "]/div/div/button")).click();
								String titleToast = genericToastMsg.getText();
								if (titleToast.equalsIgnoreCase("Please Enter Deal Amount")) {
									logger.info("Value field is properly validated");
									String selectID = driver
											.findElement(By.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td["
													+ (c + 1) + "]/div/div/select"))
											.getAttribute("id");
									String currtype = (String) ((JavascriptExecutor) driver)
											.executeScript("return document.getElementById(" + "'" + selectID + "'"
													+ ").options[document.getElementById(" + "'" + selectID + "'"
													+ ").selectedIndex].text");
									WebElement currencyType = driver
											.findElement(By.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td["
													+ (c + 1) + "]/div/div/select"));
									Select dropdown = new Select(currencyType);
									if (currtype.equalsIgnoreCase("₹")) {

										dropdown.selectByVisibleText("$");
									} else if (currtype.equalsIgnoreCase("$")) {

										dropdown.selectByVisibleText("₹");
									}
									Waitfor(1);
									driver.findElement(By.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td["
											+ (c + 1) + "]/div/div/input")).sendKeys("75000");
									driver.findElement(By.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td["
											+ (c + 1) + "]/div/div/button")).click();
									Waitfor(2);
									count++;
								}

							} else if (fieldName.equalsIgnoreCase("Customer Name")) {
								WebElement onHover = driver.findElement(By
										.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td[" + (c + 2) + "]"));
								WebElement cursor = driver.findElement(By.xpath(
										"//table[@id='tableForList']/tbody/tr[" + r + "]/td[" + (c + 2) + "]/button"));
								Action edit = action.moveToElement(onHover).click(cursor).build();
								edit.perform();
								Waitfor(1);
								driver.findElement(By.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td["
										+ (c + 2) + "]/div/div/input")).clear();
								driver.findElement(By.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td["
										+ (c + 2) + "]/div/div/button")).click();
								String titleToast = genericToastMsg.getText();
								if (titleToast.equalsIgnoreCase("Please Fill Deal Organization")) {
									logger.info("Customer name field is properly validated");
									driver.findElement(By.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td["
											+ (c + 2) + "]/div/div/input")).sendKeys("Mahindra");
									driver.findElement(By.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td["
											+ (c + 2) + "]/div/div/button")).click();
									Waitfor(2);
									count++;
								}
							} else if (fieldName.equalsIgnoreCase("Contact Person")) {
								WebElement onHover = driver.findElement(By
										.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td[" + (c + 3) + "]"));
								WebElement cursor = driver.findElement(By.xpath(
										"//table[@id='tableForList']/tbody/tr[" + r + "]/td[" + (c + 3) + "]/button"));
								Action edit = action.moveToElement(onHover).click(cursor).build();
								edit.perform();
								Waitfor(1);
								driver.findElement(By.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td["
										+ (c + 3) + "]/div/div/input")).clear();
								driver.findElement(By.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td["
										+ (c + 3) + "]/div/div/button")).click();
								String titleToast = genericToastMsg.getText();
								if (titleToast.equalsIgnoreCase("Please Fill Deal Contact Person Name")) {
									logger.info("Contact Person Name field is properly validated");
									driver.findElement(By.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td["
											+ (c + 3) + "]/div/div/input")).sendKeys("Ashutosh Bansal");
									driver.findElement(By.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td["
											+ (c + 3) + "]/div/div/button")).click();
									Waitfor(2);
									count++;
								}
							} else if (fieldName.equalsIgnoreCase("Closure Date")) {
								WebElement onHover = driver.findElement(By
										.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td[" + (c + 4) + "]"));
								WebElement cursor = driver.findElement(By.xpath(
										"//table[@id='tableForList']/tbody/tr[" + r + "]/td[" + (c + 4) + "]/button"));
								Action edit = action.moveToElement(onHover).click(cursor).build();
								edit.perform();
								Waitfor(1);
								String closureID = driver.findElement(By.xpath("//table[@id='tableForList']/tbody/tr["
										+ r + "]/td[" + (c + 4) + "]/div/div/input")).getAttribute("id");
								String selExpClose = (String) ((JavascriptExecutor) driver).executeScript(
										"return document.getElementById(" + "'" + closureID + "'" + ").value");
								if (selExpClose.equalsIgnoreCase("")) {
									driver.findElement(By.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td["
											+ (c + 4) + "]/div/div/button")).click();
									String dateToast = genericToastMsg.getText();
									if (dateToast.equalsIgnoreCase("Please Fill Deal Expected Date")) {
										logger.info("Closure Date is properly validated");
									}
								}
								driver.findElement(By.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td["
										+ (c + 4) + "]/div/div/input")).click();
								expectedClosedate("Yes");
								Waitfor(2);
								count++;
							} else if (fieldName.equalsIgnoreCase("Owner Name")) {
								String owner = driver.findElement(By.xpath(
										"//table[@id='tableForList']/tbody/tr[" + r + "]/td[" + (col + 1) + "]/span"))
										.getText();
								WebElement onHover = driver.findElement(By
										.xpath("//table[@id='tableForList']/tbody/tr[" + r + "]/td[" + (c + 5) + "]"));
								WebElement cursor = driver.findElement(By.xpath(
										"//table[@id='tableForList']/tbody/tr[" + r + "]/td[" + (c + 5) + "]/button"));
								Action edit = action.moveToElement(onHover).click(cursor).build();
								edit.perform();
								Waitfor(1);
								String ownernameDD = (String) ((JavascriptExecutor) driver).executeScript(
										"return document.getElementById('ownerSelectDropDownInListEditable_').options[document.getElementById('ownerSelectDropDownInListEditable_').selectedIndex].text");
								if (owner.equalsIgnoreCase(ownernameDD)) {
									Select dropdown = new Select(listownerNameDD);
									dropdown.selectByVisibleText("Ankita Raghav");
									listOwnerSaveButton.click();
									String ownerRemToast = genericToastMsg.getText();
									if (ownerRemToast.equalsIgnoreCase("Remark is Mandatory")) {
										listOwnerRemark.sendKeys(Keys.chord(Keys.CONTROL, "a"),
												"Owner validation Done");
										Waitfor(1);
										listOwnerSaveButton.click();
										Waitfor(2);
										count++;
									}
								}
							}
							if (count > 0) {
								break;
							}
						}
					} else {
						logger.info("No Deal record found in the list page with passed Deal name");
					}
					if (count > 0) {
						break;
					}
				}
			} else {
				logger.info("No Table heading matched with the passed data");
			}
			if (count > 0) {
				break;
			}
		}
	}

	/*
	 * Deal Detail page functionality validation
	 */

	public void doubletapDeal(String dealName) {
		Actions action = new Actions(driver);
		String dealXpath = "//span[text()=" + "'" + dealName + "'" + "]";
		WebElement src = driver.findElement(By.xpath(dealXpath));
		action.doubleClick(src).build().perform();
		Waitfor(2);
		boolean closuredateSts = editClosuredate.isDisplayed();
		if (closuredateSts == bTrue) {
			logger.info("Double tap on deal card has redirected to detail page");
		} else {
			logger.info("Double tap on deal card hasn't redirected to detail page");
		}
	}

	public String editdealTitle() {
		String dealtitle = "Tech Mahindra";// excelreaddata().getData(SHEETNAME, row, 0); // Reading WonFinal Amount from excel
		String dealname = editDealtitle.getText();
		editDealtitle.click();
		String titlelabel = editDealtitlelabel.getText();
		if (titlelabel.equalsIgnoreCase("Rename this deal:")) {
			String dealTitle = (String) ((JavascriptExecutor) driver)
					.executeScript("return document.getElementById('renameDealTtl').value");
			if (dealname.equals(dealTitle)) {
				logger.info("The deal Title data is matching with the popup deal title field data");
			} else {
				logger.info("The deal Title data is not matching with the popup deal title field data");
			}
			editTitlefield.clear();
			editTitleSave.click();
			Waitfor(1);
			String titleToast = genericToastMsg.getText();
			if (titleToast.equalsIgnoreCase("Deal Name is Needed")) {
				logger.info("The Deal title field is properly validated");
				editTitlefield.sendKeys(Keys.chord(Keys.CONTROL, "a"), dealtitle);
				editTitleSave.click();
				String updatedTitle = editDealtitle.getText();
				if (updatedTitle.equals(dealtitle)) {
					logger.info("The Deal Title is successfully updated");
				} else {
					logger.info("The Deal Title is not matchin with the updated data");
				}
			} else {
				logger.info("The Deal title field is not validated properly");
			}
		}
		return dealtitle;
	}

	public void editdealAmount() {
		String dealamount = "850050";// excelreaddata().getData(SHEETNAME, row, 0); // Reading WonFinal Amount from excel
		editDealamount.click();
		String editCurrType = editCurrencyType.getText();
		String currType = (String) ((JavascriptExecutor) driver).executeScript(
				"return document.getElementById('').options[document.getElementById('').selectedIndex].text");
		Select dropdown = new Select(editCurrencyType);
		if (currType.equalsIgnoreCase(editCurrType)) {
			logger.info("Currency type is matching with the saved currency type");
			if (currType.equalsIgnoreCase("₹")) {
				dropdown.selectByVisibleText("$");
			} else if (currType.equalsIgnoreCase("$")) {
				dropdown.selectByVisibleText("₹");
			}
		} else {
			logger.info("Currency type is not matching with the saved currency type");
		}
		String dealamnt = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.getElementById('renameDealTtl').value");
		if (dealamount.equals(dealamnt)) {
			logger.info("The deal amount is matching with the popup deal amount field data");
		} else {
			logger.info("The deal amount is not matching with the popup deal amount field data");
		}
		editDealamountfield.clear();
		editamountSave.click();
		Waitfor(1);
		String amountToast = genericToastMsg.getText();
		if (amountToast.equalsIgnoreCase("Deal amount is Needed")) {
			logger.info("The Deal amount field is properly validated");
		}
		String currencyType= editCurrencyType.getText();
		pojo.setCurrencyType(currencyType);
		pojo.setDealamount(dealamount);
	}

	public void editCustomerName() {
		String dealCustName = "850050";// excelreaddata().getData(SHEETNAME, row, 0); // Reading Customer Name from excel
		String custnameCard = editCardCustomerName.getText();
		String custName = editCustomerName.getText();
		if (custnameCard.equals(custName)) {
			logger.info("The ");
			editiconCustName.click();
			String popCustname = (String) ((JavascriptExecutor) driver)
					.executeScript("return document.getElementById('editOrganizationName').value");
			if (popCustname.equals(custName)) {
				editcustomerNamefield.clear();
				editcustomerNameSave.click();
				Waitfor(1);
				String custToast = genericToastMsg.getText();
				if (custToast.equalsIgnoreCase("Customer Name is Needed")) {
					editcustomerNamefield.sendKeys(Keys.chord(Keys.CONTROL, "a"), dealCustName);
					editcustomerNameSave.click();
					Waitfor(1);
					String updatedCustName = editCustomerName.getText();
					String updcardCustname = editCustomerName.getText();
					if (updatedCustName.equals(dealCustName) && updcardCustname.equals(dealCustName)) {
						logger.info("The customer name has successfully updated in the deal detail page");
						pojo.setUpdatedCustomerName(dealCustName);
					} else {
						logger.info("The customer name is not updated properly in the deal detail page");
					}
				}
			}
		}
	}
	
	public void editContactPerson() {
		String dealContFirstName = "Sriyaa";// excelreaddata().getData(SHEETNAME, row, 0); // Reading Customer Name from excel
		String dealContLastName = "Nalla";// excelreaddata().getData(SHEETNAME, row, 0); // Reading Customer Name from excel
		String contpernameCard = editCardcontperName.getText();
		String firstName = editContactFirstName.getText();
		String lastName = editContactLastName.getText();
		String fullContName = firstName + " " + lastName;
		if (fullContName.equals(contpernameCard)) {
			logger.info("The Contact Person name is matching with the Contact person name in the card ");
			editIconcontper.click();
			String popFirstname = (String) ((JavascriptExecutor) driver)
					.executeScript("return document.getElementById('editPersonNameFN').value");
			String popLastname = (String) ((JavascriptExecutor) driver)
					.executeScript("return document.getElementById('editPersonNameFN').value");
			if (popFirstname.equals(firstName) && popLastname.equals(lastName)) {
				editcontFirstname.clear();
				editcontSave.click();
				Waitfor(1);
				String firstToast = genericToastMsg.getText();
				if (firstToast.equalsIgnoreCase("First Name is Needed")) {
					editcontFirstname.sendKeys(Keys.chord(Keys.CONTROL, "a"), dealContFirstName);
					editcontLastname.clear();
					editcontSave.click();
					Waitfor(1);
					String lastToast = genericToastMsg.getText();
					if (lastToast.equalsIgnoreCase("First Name is Needed")
							|| lastToast.equalsIgnoreCase("Last Name is Needed")) {
						editcontFirstname.sendKeys(Keys.chord(Keys.CONTROL, "a"), dealContLastName);
						editcontSave.click();
						Waitfor(1);
						String updfirstName = editContactFirstName.getText();
						String updlastName = editContactLastName.getText();
						String updcardContPer = editCardcontperName.getText();
						String updatedContName = firstName + " " + lastName;
						if (updfirstName.equals(dealContFirstName) && updlastName.equals(dealContLastName)
								&& updatedContName.equals(updcardContPer)) {
							logger.info(
									"The Updated Contact Person name is matching with the passed data in edit popup field");
						} else {
							logger.info(
									"The Updated Contact Person name is not matching with the passed data in edit popup field");
						}
					} else {
						logger.error("The edit Contact person name field is not properly validated");
					}
				}
			}
		}
	}

	public void dealage() {
		String dAge = dealAge.getText();
		String[] dealage=dAge.split(" ");
		String dealcreatedate = dealCreatedDate.getText();
		Date now = new Date();
		Date incDate;
		try {
			incDate = new SimpleDateFormat("dd-MM-yyyy").parse(dealcreatedate);
			int diffInDays = (int) ((now.getTime() - incDate.getTime()) / (1000 * 60 * 60 * 24));
			String daysDiff= String.valueOf(diffInDays);
			if(dealage[0].equals(daysDiff)) {
				logger.info("The Deal age data is correct");
			}else {
				logger.info("The Deal age data is not correct");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void editactiveSatge() {
		int stageCount=0;
		StringBuilder sb=new StringBuilder();
		String[] stageArr= {"Lead", "Qualified Lead", "Customer Meeting", "Proposal Submission", "Negotiation Stage"};
		WebElement abc = driver.findElement(By.xpath("//div[@class='pipelineStages open']/ul"));
		List<WebElement> stages = abc.findElements(By.tagName("li"));
		for (int s = 1; s <= stages.size(); s++) {
			String stageSts= driver.findElement(By.xpath("//div[@class='pipelineStages open']/ul/li["+(s)+"]")).getAttribute("class");
			if(stageSts.equals("stagename1 active")) {
				stageCount++;
				String activeStage= stageArr[stageCount-1];
				sb= sb.append(activeStage+", ");
				pojo.setEditactiveStage(activeStage);
			}else if(stageSts.equals("stagename1")){
				String activeStage= stageArr[stageCount-1];
				logger.info("The active stage name in deal detail page is : "+stageArr[stageCount-1]);
				pojo.setEditactiveStage(activeStage);
				break;
			}
		}
		logger.info("The active stages name in deal detail page is : "+sb);
	}
	
	public void addNotes() {
		String notes = "Notes Should Save";// excelreaddata().getData(SHEETNAME, row, 0); // Reading Notes from excel
		boolean noteSts = addNotes.isDisplayed();
		if (noteSts == bTrue) {
			addNotes.click();
			boolean noteSave = noteSavebutton.isDisplayed();
			if (noteSave == bTrue) {
				logger.info("Add Notes button is clickable");
				String notedata = (String) ((JavascriptExecutor) driver)
						.executeScript("return document.getElementById('editOrganizationName').value");
				if (notedata.equals("")) {
					noteSavebutton.click();
					String notetoast = genericToastMsg.getText();
					if (notetoast.equalsIgnoreCase("Please Enter Notes")) {
						logger.info("The Notes Save is perfectly validated");
						noteBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), notes);
					}else {
						logger.error("The Notes Save is not properly validated");
					}
				} else {
					logger.error("The Notes should not have any existing/old data in it");
				}
			}
		}
	}

	public void editClosureDate() {
		boolean closureSts = editClosuredate.isDisplayed();
		if (closureSts == bTrue) {
			editClosuredate.click();
			boolean dateSavests = editClosuredateSave.isDisplayed();
			if (dateSavests == bTrue) {
				String date = (String) ((JavascriptExecutor) driver)
						.executeScript("return document.getElementById('expClsDateDeals').value");
				if (date.equals("")) {
					editClosuredateSave.click();
					String dateToast= genericToastMsg.getText();
					if(dateToast.equalsIgnoreCase("Expected Date is Mandatory")) {
						
					}
				} else {
					editClosuredatefield.click();
				}
			}
		}

	}
	public String getaccHldrName() {
		String name = accountHolderName.getAttribute("innerText");
		logger.info("Account Holder name on Account_Info Section " + name);
		return name;
	}
}