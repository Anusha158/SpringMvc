package org.springcrud.springcrudDemo.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springcrud.springcrudDemo.Model.Phone;
import org.springframework.format.Formatter;

public class PhoneNumberformatter implements Formatter<Phone>{

	@Override
	public String print(Phone object, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Phone parse(String completePhone, Locale locale) throws ParseException {
		System.out.println("phone parse");
		String phoneNumberArray[]=completePhone.split("-");
		Phone phone=new Phone();
		phone.setCountryCode(phoneNumberArray[0]);
		phone.setNumber(phoneNumberArray[1]);
		return phone;
	}

}
