package com.dikshatech.tst.objectrepository;

import java.io.Serializable;

import org.openqa.selenium.WebElement;

public class GetterSetter implements Serializable{

	public String projectName;

	public String chargecode;

	public String Leavetype;
	
	public String fromdate;
	
	public String todate;
	
	public String Totaldays;
	
	public String Reason;
	
	public String contactno;
	
	public String filedescription;
	
	public String abc1;
	
	public String abc2;
	
	public String abc3;
	
	public String emp_name;
	
	public String salary_value;
	
	public String pay_days;

	public String lwp;
	
	/**
	 * @return the emp_name
	 */
	public String getEmp_name() {
		return emp_name;
	}

	/**
	 * @return the salary_value
	 */
	public String getSalary_value() {
		return salary_value;
	}

	/**
	 * @return the pay_days
	 */
	public String getPay_days() {
		return pay_days;
	}

	/**
	 * @return the lwp
	 */
	public String getLwp() {
		return lwp;
	}

	/**
	 * @param emp_name the emp_name to set
	 */
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	/**
	 * @param salary_value the salary_value to set
	 */
	public void setSalary_value(String salary_value) {
		this.salary_value = salary_value;
	}

	/**
	 * @param pay_days the pay_days to set
	 */
	public void setPay_days(String pay_days) {
		this.pay_days = pay_days;
	}

	/**
	 * @param lwp the lwp to set
	 */
	public void setLwp(String lwp) {
		this.lwp = lwp;
	}

	public String getProjectName() 
	{
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getChargecode() {
		return chargecode;
	}

	public void setChargecode(String chargecode) {
		this.chargecode = chargecode;
	}

	public String getLeavetype() {
		return Leavetype;
	}

	public void setLeavetype(String leavetype) {
		Leavetype = leavetype;
	}

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public String getTotaldays() {
		return Totaldays;
	}

	public void setTotaldays(String totaldays) {
		Totaldays = totaldays;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getFiledescription() {
		return filedescription;
	}

	public void setFiledescription(String filedescription) {
		this.filedescription = filedescription;
	}



	@Override
	public String toString() {
		return "Getter_Setter [projectName=" + projectName + ", chargecode=" + chargecode + ", Leavetype=" + Leavetype
				+ ", fromdate=" + fromdate + ", todate=" + todate + ", Totaldays=" + Totaldays + ", Reason=" + Reason
				+ ", contactno=" + contactno + ", filedescription=" + filedescription + "]";
	}

	public String get_salarydata()
	{
		return "Getter_Setter [emp_name=" + emp_name +", salary_value="+salary_value+",pay_days="+pay_days+", lwp="+lwp+" ]";
				
	}
	
	
}
