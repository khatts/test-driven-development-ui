package com.sape.order.vo;

/**
 * Role represents a role in the system.
 * 
 * @author Nilaksh Bajpai
 */
public class Role {

	private RoleType type;
	
	public Role(RoleType type){
		this.type = type;
	}
	public void setType(RoleType type) {
		this.type = type;
	}

	public RoleType getType() {
		return type;
	}
}
