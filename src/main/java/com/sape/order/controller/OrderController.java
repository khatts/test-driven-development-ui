package com.sape.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sape.order.util.ServiceWrapper;
import com.sape.order.validators.MarketOrderValidator;
import com.sape.order.validators.QuantityValidator;
import com.sape.order.validators.SubAccountValidator;
import com.sape.order.vo.AccountType;
import com.sape.order.vo.EquityOrder;
import com.sape.order.vo.OrderQualifier;
import com.sape.order.vo.OrderType;
import com.sape.order.vo.Side;
import com.sape.order.vo.SubAccount;

@Controller
@RequestMapping("/order/create")
public class OrderController {
	@Autowired
	private org.springframework.validation.Validator validator;
	
	@RequestMapping(method=RequestMethod.GET)
	public String createOrder(ModelMap model){
		EquityOrder equityOrder = createEquityOrder();
		model.put("equityOrder", equityOrder);
		return "createOrder";
	}
	private EquityOrder createEquityOrder() {
		EquityOrder equityOrder = new EquityOrder();
		equityOrder.setOrderType(OrderType.Market);
		equityOrder.setSide(Side.Buy);
		equityOrder.setOrderQualifier(OrderQualifier.DayOrder);
		equityOrder.setAccountType(AccountType.Cash);
		createSubAccounts();
		return equityOrder;
	}
	@ModelAttribute("subAccounts")
	private Map<String,String> createSubAccounts() {
		Map<String,String> subAccounts = new HashMap<String, String>();
		SubAccount subAccount = new SubAccount();
		subAccount.setName("TEST SUBACCOUNT1");
		subAccount.setId(11L);
		subAccounts.put(subAccount.getId().toString(),subAccount.getName());
		SubAccount subAccount2 = new SubAccount();
		subAccount2.setName("TEST SUBACCOUNT2");
		subAccount2.setId(12L);
		subAccounts.put(subAccount2.getId().toString(),subAccount2.getName());
		return subAccounts;
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView createOrder( @Valid @ModelAttribute("equityOrder")EquityOrder equityOrder,
			BindingResult result,ModelMap model,HttpServletRequest request,HttpServletResponse response){
		validator.validate(equityOrder, result);
	    new MarketOrderValidator().validate(equityOrder, result);
	    new QuantityValidator().validate(equityOrder, result);
		System.out.println("Inside createOrder111"+equityOrder.getStopPrice());
		ServiceWrapper serviceWrapper = new ServiceWrapper();
		List<String> portfoliosForSubAccount = serviceWrapper.getPortfoliosForSubAccount(equityOrder.getSubAccount().getName(),model);
		if(null!=equityOrder.getPortfolio()){
			portfoliosForSubAccount.add(equityOrder.getPortfolio().getName());
		}
		if(result.hasErrors()){
			return new ModelAndView("createOrder","equityOrder",equityOrder);
		}
		return new ModelAndView("success","equityOrder",equityOrder);
		
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		  binder.setValidator(new MarketOrderValidator());
		  binder.setValidator(new QuantityValidator());
		  binder.setValidator(new SubAccountValidator());
		}
}
