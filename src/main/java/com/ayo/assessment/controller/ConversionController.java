package com.ayo.assessment.controller;

import java.util.Map;
import java.util.TreeMap;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ayo.assessment.service.ConverterServiceImpl;

@RestController
public class ConversionController {
	
	TreeMap <String ,Double> map= new TreeMap<String ,Double>(); 
	@Autowired
	ConverterServiceImpl converterServiceImpl;
	
	/**
	 * API to cater for Metric to imperial conversions based on a given Unit Value
	 * @param unitValue
	 * @return
	 */
	@GetMapping({"/conversion","/conversion/{unitValue}"})
	public TreeMap<String ,Double> convertMetrictoImperial(@PathVariable (required=false)@Min(0)  double unitValue ) {
		return converterServiceImpl.getConversions(unitValue);
	}
}
