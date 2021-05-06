package edu.handong.csee.java.hw2.converters;
import java.math.BigDecimal;

public class AllConverter {
	private double fromValue;
	private String originalMeasure;
	private double convertedNum1, convertedNum2;

	/**
		*setting a value to convert
	*/
	public AllConverter setFromValue(double fromValue){
		this.fromValue = fromValue;
		return this;
	}

	/**
		*setting a measure to convert from
	*/
	public AllConverter setOriginalMeasure(String originalMeasure){
		this.originalMeasure = originalMeasure;
		return this;
	}
	/**
		*converting a value from one measure to two measures
		*if original measure is not ton or km, prints out a message
	*/
	public void convertAndPrintOut(){
		if(originalMeasure.equals("TON")){
			TONToGConverter ton_g = new TONToGConverter();
			ton_g.setFromValue(fromValue);
			ton_g.convert();
			TONToKGConverter ton_kg = new TONToKGConverter();
			ton_kg.setFromValue(fromValue);
			ton_kg.convert();

			System.out.println(fromValue +" " + originalMeasure + " to " + ton_kg.getConvertedValue() + " KG");
			System.out.println(fromValue +" " + originalMeasure + " to " + ton_g.getConvertedValue() + " G");
			//System.out.println();
			/*
			BigDecimal b1 = new BigDecimal(String.valueOf(fromValue));
			BigDecimal b_KG = new BigDecimal("1000");
			BigDecimal b_G = new BigDecimal("1000000");
			convertedNum1 = b_KG.multiply(b1).doubleValue();
			convertedNum2 = b_G.multiply(b1).doubleValue();

			System.out.println(fromValue +" " + originalMeasure + " to " + convertedNum1 + " KG");
			System.out.println(fromValue +" " + originalMeasure + " to " + convertedNum2 + " G");
			System.out.println();
			*/
		}

		else if(originalMeasure.equals("KM")){
			KMToMConverter km_m = new KMToMConverter();
			km_m.setFromValue(fromValue);
			km_m.convert();
			KMToMILEConverter km_mile = new KMToMILEConverter();
			km_mile.setFromValue(fromValue);
			km_mile.convert();

			System.out.println(fromValue +" " + originalMeasure + " to " + km_m.getConvertedValue() + " M");
			System.out.println(fromValue +" " + originalMeasure + " to " + km_mile.getConvertedValue() + " MILE");
			//System.out.println();
			/*
			BigDecimal b1 = new BigDecimal(String.valueOf(fromValue));
			BigDecimal b_M = new BigDecimal("1000");
			BigDecimal b_MILE = new BigDecimal("1.6");
			convertedNum1 = b_M.multiply(b1).doubleValue();
			convertedNum2 = b1.divide(b_MILE).doubleValue();

			System.out.println(fromValue +" " + originalMeasure + " to " + convertedNum1 + " M");
			System.out.println(fromValue +" " + originalMeasure + " to " + convertedNum2 + " MILE");
			System.out.println();
			*/
		}

		else{
			System.out.println("AllConverter cannot support the measure");
			System.out.println();
		}

	}

}
