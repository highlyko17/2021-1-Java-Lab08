package edu.handong.csee.java.hw2.converters;

public interface Convertible {
	public void setFromValue(double fromValue);
	/**
		*getting a converted value
	*/
	public double getConvertedValue();
	/**
		*converting value from original measure to another assigned measure
	*/
	public void convert();
}
