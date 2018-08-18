package com.vuclip.np.activation.entities;

import java.sql.Date;

public class ParsedData {
	
	
	
	private int customerId;
	
	private int providerId;
	
	private String msisdn;
	
	private int itemId;
	
	private int itemTypeId;
	
	private int subscriptionBillingCode;
	
	//private Date subscriptionDate;
	
	private String subscriptionDate;

	public String getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(String subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemTypeId() {
		return itemTypeId;
	}

	public void setItemTypeId(int itemTypeId) {
		this.itemTypeId = itemTypeId;
	}

	public int getSubscriptionBillingCode() {
		return subscriptionBillingCode;
	}

	public void setSubscriptionBillingCode(int subscriptionBillingCode) {
		this.subscriptionBillingCode = subscriptionBillingCode;
	}

/*	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}
*/
	@Override
	public String toString() {
		return "ParsedData [customerId=" + customerId + ", providerId=" + providerId + ", msisdn=" + msisdn
				+ ", itemId=" + itemId + ", itemTypeId=" + itemTypeId + ", subscriptionBillingCode="
				+ subscriptionBillingCode + ", subscriptionDate=" + subscriptionDate + "]";
	}




}
