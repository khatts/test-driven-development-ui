package com.sape.order.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

public class ServiceWrapper {
	
	@ModelAttribute("portfolios")
	public List<String> getPortfoliosForSubAccount(String subAccount,ModelMap model){
		List<String> portfolioForSubAccounts = new ArrayList<String>();
		if (null != subAccount && !subAccount.equalsIgnoreCase("")) {
			portfolioForSubAccounts.add("TEST PORTFOLIO1");
			portfolioForSubAccounts.add("TEST PORTFOLIO2");
		}
		model.put("portfolios", portfolioForSubAccounts);
		return portfolioForSubAccounts;
	}

}
