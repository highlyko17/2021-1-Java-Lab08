package edu.handong.csee.java.hw2.converters;
import java.math.BigDecimal;

public class MILEToKMConverter implements Convertible {
	private double num;
	private double convertedNum;

	/**
		*setting a value to convert
	*/
	@Override
	public void setFromValue(double fromValue){
		num = fromValue;
	}

	/**
		*getting a converted value
	*/
	@Override
	public double getConvertedValue(){
		return convertedNum;
	}

	/**
		*converting value from mile to km
	*/
	@Override
	public void convert(){
		BigDecimal b1 = new BigDecimal(String.valueOf(num));
		BigDecimal b2 = new BigDecimal("1.6");
		convertedNum = b1.multiply(b2).doubleValue();
	}
}
