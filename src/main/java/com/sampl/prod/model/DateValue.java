package com.sampl.prod.model;

import java.time.LocalDate;

public class DateValue {
	
	private double amount;
	private double percent;
	private LocalDate date;
	private LocalDate toDates;
	
	

	public DateValue(double amount, double percent, LocalDate date, LocalDate toDates) {
		super();
		this.amount = amount;
		this.percent = percent;
		this.date = date;
		this.toDates = toDates;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public double getPercent() {
		return percent;
	}



	public void setPercent(double percent) {
		this.percent = percent;
	}
	

	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}



	public LocalDate getToDates() {
		return toDates;
	}



	public void setToDates(LocalDate toDates) {
		this.toDates = toDates;
	}



	public DateValue() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
