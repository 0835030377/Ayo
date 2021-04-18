package com.ayo.assessment.service;

import java.util.TreeMap;

import org.apache.commons.math3.util.Precision;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class ConverterServiceImpl implements ConverterService {

	final private double GALON_TO_LITRE= 3.785;
	final private double POUND_TO_KG= 0.454;
	final private double INCHES_TO_MM= 25.4;
	final private double FEET_TO_CM= 30.48;
	TreeMap<String,Double> conversionsMap = new TreeMap<String,Double>();
	private Logger logger = LoggerFactory.getLogger(ConverterServiceImpl.class);
	@Override
	public double celsiusToFahrenheit(double unitValue) {
		return Precision.round( ( unitValue * 9/5) + 32,1);
	}

	@Override
	public double fahrenheitToCelsius(double unitValue) {
		return Precision.round((((unitValue - 32) * 5) / 9),1);
	}

	@Override
	public double inchesToMilimeters(double unitValue) {
		return Precision.round( unitValue * (INCHES_TO_MM/1),1);
	}

	@Override
	public double milimetersToInches(double unitValue) {
		return Precision.round( unitValue/INCHES_TO_MM,1);
	}

	@Override
	public double galonsToLitres(double unitValue) {
		return Precision.round( unitValue * GALON_TO_LITRE,1);
	}

	@Override
	public double litresToGalons(double unitValue) {
		return Precision.round( unitValue/GALON_TO_LITRE,1);
	}

	@Override
	public double kilogramsToPounnds(double unitValue) {
		return Precision.round( unitValue *(1/POUND_TO_KG),1);
	}

	@Override
	public double poundsToKilograms(double unitValue) {
		return Precision.round(unitValue * POUND_TO_KG,1);
	}

	@Override
	public double feetToCentimetres(double unitValue) {
		return Precision.round(unitValue * (FEET_TO_CM/1),2);
	}

	@Override
	public double centimetresToFeet(double unitValue) {
		return Precision.round(unitValue/FEET_TO_CM, 2);
	}
	public TreeMap<String,Double> getConversions(double unitValue) {
		try {
			conversionsMap.put("Celsius To Fahrenheit", celsiusToFahrenheit(unitValue));
			conversionsMap.put("Fahrenheit To Celsius", fahrenheitToCelsius(unitValue));
			conversionsMap.put("Inches To Millimeters", inchesToMilimeters(unitValue));
			conversionsMap.put("Millimeters To Inches", milimetersToInches(unitValue));
			conversionsMap.put("Galons To Litres", galonsToLitres(unitValue));
			conversionsMap.put("Litres To Galons", litresToGalons(unitValue));
			conversionsMap.put("Kilograms To Pounds", kilogramsToPounnds(unitValue));
			conversionsMap.put("Pounds To Kilograms", poundsToKilograms(unitValue));
			conversionsMap.put("Feet To Centimetres", feetToCentimetres(unitValue));
			conversionsMap.put("Centimetres To Feet", centimetresToFeet(unitValue));
		}catch (Exception e) {
			logger.error("Exception occured : " + e.getMessage());			
		}
		return conversionsMap;	
	}

}
