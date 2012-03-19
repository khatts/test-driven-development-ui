package com.sape.order.vo;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

/**
 * EquityOrder represents an equity order.
 * 
 * @author Nilaksh Bajpai
 */
public class EquityOrder {
	private Symbol symbol;

	private String securityName;

	private Side side;
	private OrderType orderType;
	private OrderQualifier orderQualifier;
	private List<SubAccount> subAccounts;
	@NotNull
	private SubAccount subAccount;
	@NotNull
	private Portfolio portfolio;
	private List<Portfolio> portfolios;
	private AccountType accountType;
	
	@NumberFormat(style=Style.NUMBER)
	private long qty;
	private Long stopPrice;
	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	private Long limitPrice;
	 //@NotEmpty(message = "Notes must not be blank.")
     //@Size(min = 1, max = 10, message = "Notes must between 1 to 10 Characters.")
	private String notes;

	private boolean notify;
	
	private String status;
	
	private Long orderId;


	public EquityOrder() {
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public String getSecurityName() {
		return securityName;
	}

	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}

	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public OrderQualifier getOrderQualifier() {
		return orderQualifier;
	}

	public void setOrderQualifier(OrderQualifier orderQualifier) {
		this.orderQualifier = orderQualifier;
	}

	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}

	public List<SubAccount> getSubAccounts() {
		return subAccounts;
	}

	public void setSubAccounts(List<SubAccount> subAccounts) {
		this.subAccounts = subAccounts;
	}

	public List<Portfolio> getPortfolios() {
		return portfolios;
	}

	public void setPortfolios(List<Portfolio> portfolios) {
		this.portfolios = portfolios;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public long getQty() {
		return qty;
	}

	public void setQty(long qty) {
		this.qty = qty;
	}

	public Long getStopPrice() {
		return stopPrice;
	}

	public void setStopPrice(Long stopPrice) {
		this.stopPrice = stopPrice;
	}

	public Long getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(Long limitPrice) {
		this.limitPrice = limitPrice;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean isNotify() {
		return notify;
	}

	public void setNotify(boolean notify) {
		this.notify = notify;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public SubAccount getSubAccount() {
		return subAccount;
	}

	public void setSubAccount(SubAccount subAccount) {
		this.subAccount = subAccount;
	}

}