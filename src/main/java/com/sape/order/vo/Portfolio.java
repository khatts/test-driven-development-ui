package com.sape.order.vo;


/**
 * Portfolio represents a users portfolio.
 *  
 * @author Nilaksh Bajpai
 */
public class Portfolio {

	private Long id;
	
	private SubAccount subAccount;
	
	private String name;
	/**
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id){
		this.id = id;
	}

	/**
	 * @return the subAccount
	 */
	public SubAccount getSubAccount() {
		return subAccount;
	}

	/**
	 * @param subAccount the subAccount to set
	 */
	public void setSubAccount(SubAccount subAccount) {
		this.subAccount = subAccount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
