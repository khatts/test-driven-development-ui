package com.sape.order.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.sape.order.vo.Role;
import com.sape.order.vo.RoleType;
import com.sape.order.vo.User;

@Controller
@SessionAttributes("user")
public class UserController {
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	@ModelAttribute("user")
	public ModelAndView userBeAbleToAccessEquityOrder(@RequestParam String userId,@RequestParam String roleName,@RequestParam String userName,ModelMap model){
		System.out.println("User "+ userId + "Role Name "+ roleName + "userName: "+ userName);
		Role role = new Role(RoleType.PortfolioManageAccess);
		if(RoleType.trader.toString().equalsIgnoreCase(roleName)){
			role.setType(RoleType.trader);
		}
		User user = new User();
		user.setName(userName);
		user.setUserId(userId);
		user.setRole(role);
		model.addAttribute("user", user);
		model.put("user",user);
		return new ModelAndView("equityOrder");
	}
	@RequestMapping(value="/privilege",method=RequestMethod.GET)
	public @ResponseBody String isUSerAbleToAccessOrders(HttpSession session,SessionStatus status){
		User user = (User)session.getAttribute("user");
		System.out.println("User in session : "+ user.getUserId());
		Map<String,String> privileges = new HashMap<String, String>();
		privileges.put("name",user.getRole().getType().toString());
		JSONArray jsonArray = JSONArray.fromObject( privileges);
		System.out.println("JSON Array : " +jsonArray);
		return jsonArray.toString();

	}

}
