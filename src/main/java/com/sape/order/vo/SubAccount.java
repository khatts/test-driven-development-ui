package com.sape.order.vo;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * SubAccount represents a sub account.
 * 
 * @author Nilaksh Bajpai
 */
public class SubAccount {

	private Long id;
	@NotEmpty
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
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
