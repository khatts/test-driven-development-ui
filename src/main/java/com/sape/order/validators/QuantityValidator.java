package com.sape.order.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sape.order.vo.EquityOrder;

public class QuantityValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return EquityOrder.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		EquityOrder equityOrder = (EquityOrder)target;
		Long qty = equityOrder.getQty();
		boolean isValid = null!=qty?isQuantityValid(qty):false;
		if(!isValid){
			errors.rejectValue("qty", "invalidquantity");
		}
		
	}

	private boolean isQuantityValid(Long qty) {
		String validQuantity="^[1-9]*+";
		Pattern pattern = Pattern.compile(validQuantity);
		Matcher matcher = pattern.matcher(qty.toString());
		return matcher.matches()?true:false;
	}

}
