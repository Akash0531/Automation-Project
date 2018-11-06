package com.dikshatech.tst.utilitylibrary;

import java.io.Serializable;
import java.util.Date;

public class Dao implements Serializable{
	
	private int			version;
	protected String	year;
	protected Date		appraiseeDueDate;
	protected Date		appraiserDueDate;
	protected Date		startDate;

	
	
	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}
	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * @return the appraiseeDueDate
	 */
	public Date getAppraiseeDueDate() {
		return appraiseeDueDate;
	}
	/**
	 * @param appraiseeDueDate the appraiseeDueDate to set
	 */
	public void setAppraiseeDueDate(Date appraiseeDueDate) {
		this.appraiseeDueDate = appraiseeDueDate;
	}
	/**
	 * @return the appraiserDueDate
	 */
	public Date getAppraiserDueDate() {
		return appraiserDueDate;
	}
	/**
	 * @param appraiserDueDate the appraiserDueDate to set
	 */
	public void setAppraiserDueDate(Date appraiserDueDate) {
		this.appraiserDueDate = appraiserDueDate;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
}
