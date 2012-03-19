package com.sape.order.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sape.order.vo.EquityOrder;

public class SubAccountValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return EquityOrder.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		System.out.println("Inside the sub account validation");
		EquityOrder equityOrder = (EquityOrder)target;
		System.out.println("Name of SubAccount : "+ equityOrder.getSubAccount().getName());
		if(equityOrder.getSubAccount().getName().equals("")){
			errors.rejectValue("subAccount", "mandatorySubAccount");
		}
	}

}
