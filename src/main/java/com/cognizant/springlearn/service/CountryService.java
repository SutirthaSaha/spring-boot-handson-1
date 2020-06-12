package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	
	private ArrayList<Country> countries;
	
	public CountryService() {
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		countries=(ArrayList)context.getBean("countryList");
	}
	
	public List<Country> getCountries(){
		return countries;
	}
	
	public Country getCountry(String code) throws CountryNotFoundException {
		for(Country country:countries) {
			if(country.getCode().equalsIgnoreCase(code)) {
				return country;
			}
		}
		throw new CountryNotFoundException();
	}
	
	public Country addCountry(Country country) {
		countries.add(country);
		return country;
	}

	public Country deleteCountry(String code) throws CountryNotFoundException {
		for(Country country:countries) {
			if(country.getCode().equalsIgnoreCase(code)) {
				countries.remove(country);
				return country;
			}
		}
		throw new CountryNotFoundException();
	}
}
