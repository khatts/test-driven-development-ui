package com.sape.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sape.order.util.ServiceWrapper;

@Controller
public class EquityOrderController {

	@RequestMapping("/order")
	public String retrieveOrder(Map<String, Object> model) {
		System.out.println("Inside retrieveOrder");
		return "equityOrder";
	}

	@RequestMapping(value = "/order/subAccount/portfolio", method = RequestMethod.GET)
	@ModelAttribute("portfolios")
	public @ResponseBody
	String retrievePortfoliosForSubAccount(@RequestParam("subAccount") String subAccount,ModelMap model) {
		System.out.println("Inside retrievePortfoliosForSubAccount "
				+ subAccount);
		ServiceWrapper serviceWrapper = new ServiceWrapper();
		Map<String, List<String>> portfolios = new HashMap<String, List<String>>();
		List<String> portfolioForSubAccounts = serviceWrapper.getPortfoliosForSubAccount(subAccount,model);
		portfolios.put("portfolios", portfolioForSubAccounts);
		JSONArray jsonArray = JSONArray.fromObject(portfolios);
		System.out.println("JSON Array : " + jsonArray);
		return jsonArray.toString();
	}
	

}
