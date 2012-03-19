package com.sape.order.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sape.order.vo.EquityOrder;
import com.sape.order.vo.OrderType;

public class MarketOrderValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return EquityOrder.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		EquityOrder equityOrder = (EquityOrder)target;
		if(OrderType.Market.equals(equityOrder.getOrderType())){
			if(equityOrder.getStopPrice()!=null && equityOrder.getLimitPrice()!=null){
				errors.rejectValue("stopPrice", "marketOrder.stopPrice.validate");
				errors.rejectValue("limitPrice", "marketOrder.limitPrice.validate");
			 }else if(equityOrder.getStopPrice()!=null){
				 errors.rejectValue("stopPrice", "marketOrder.stopPrice.validate");
			 }else if(equityOrder.getLimitPrice()!=null){
				 errors.rejectValue("limitPrice", "marketOrder.limitPrice.validate");
			 }
			}
		
		
	}

}
