package com.wareHouse.service.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "datedetails")
public class DateDetails {
	
	@Id
	@Column(name = "date_id")
	private int dateID;
	
	@Column(name = "date_for_id")
	private String dateDim;
	
	@Column(name = "year_number")
	private int yearNumber;
	
	@Column(name = "quarter")
	private String quarter;
	
	@Column(name = "month_number")
	private int monthNumber;
	
	@Column(name = "month_name")
	private String monthName;
	
	@Column(name = "week_number")
	private int weekNumber;
	
	@Column(name = "week_day")
	private String weekDay;
	
	@Column(name = "day_of_month")
	private int dayOfMonth;
	
	public int getDateID() {
		return dateID;
	}
	public void setDateID(int dateID) {
		this.dateID = dateID;
	}
	
	public String getDateDim() {
		return dateDim;
	}
	public void setDateDim(String dateDim) {
		this.dateDim = dateDim;
	}
	public int getYearNumber() {
		return yearNumber;
	}
	public void setYearNumber(int yearNumber) {
		this.yearNumber = yearNumber;
	}
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public int getMonthNumber() {
		return monthNumber;
	}
	public void setMonthNumber(int monthNumber) {
		this.monthNumber = monthNumber;
	}
	public String getMonthName() {
		return monthName;
	}
	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}
	public int getWeekNumber() {
		return weekNumber;
	}
	public void setWeekNumber(int weekNumber) {
		this.weekNumber = weekNumber;
	}
	public String getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}
	public int getDayOfMonth() {
		return dayOfMonth;
	}
	public void setDayOfMonth(int dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}
	@Override
	public String toString() {
		return "DateDetails [dateID=" + dateID + ", dateDim=" + dateDim + ", yearNumber=" + yearNumber + ", quarter="
				+ quarter + ", monthNumber=" + monthNumber + ", monthName=" + monthName + ", weekNumber=" + weekNumber
				+ ", weekDay=" + weekDay + ", dayOfMonth=" + dayOfMonth + "]";
	}
	
	
	
	
}
