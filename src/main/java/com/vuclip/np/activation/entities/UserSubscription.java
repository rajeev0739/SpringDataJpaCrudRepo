package com.vuclip.np.activation.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;



/**
 * The persistent class for the user_subscription database table.
 * 
 */
@Entity
@Table(name="user_subscription")
@NamedQuery(name="UserSubscription.findAll", query="SELECT u FROM UserSubscription u")
public class UserSubscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="subscription_id")
	private long subscriptionId;

	@Column(name="customer_id")
	private int customerId;

	@Column(name="provider_id")
	private int providerId;
	
	private String msisdn;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="item_id")
	private int itemId;

	@Column(name="item_type_id")
	private int itemTypeId;
	
	@Column(name="billing_code")
	private int billingCode;

	@Column(name="subscription_billing_code")
	private int subscriptionBillingCode;
	
	@Column(name="current_billing_code")
	private int currentBillingCode;

	@Column(name="subscription_status_id")
	private int subscriptionStatusId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	private Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	private Date endDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="subscription_date")
	private Date subscriptionDate;
		
	@Column(name="is_deactivation_initiated")
	private String isDeactivationInitiated;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_billing_request_date",columnDefinition="DATETIME")
	private Date lastBillingRequestDate;

	@Column(name="last_billing_request_transaction_id")
	private String lastBillingRequestTransactionId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_billing_response_date")
	private Date lastBillingResponseDate;

	@Column(name="last_billing_response_status_id")
	private int lastBillingResponseStatusId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_notification_date")
	private Date lastNotificationDate;

	@Column(name="last_notification_transaction_id")
	private String lastNotificationTransactionId;
	
	@Column(name="last_notification_status_id")
	private int lastNotificationStatusId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="next_billing_date")
	private Date nextBillingDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="optout_sms_date")
	private Date optoutSMSDate;

	@Column(name="billing_retry")
	private int billingRetry;
	
	@Column(name="preferred_language")
	private String preferredLanguage;

	@Column(name="user_source")
	private String userSource;
	
	@Column(name="charging_source")
	private String chargingSource;
	
	@Column(name="customer_transaction_id")
	private String customerTransactionId;
	
	@Column(name="credits")
	private int credits;

	@Column(name="adnetwork_id")
	private int adnetworkId;

	@Column(name="adnetwork_transaction_id")
	private String adnetworkTransactionId;
	
	@Column(name="adnetwork_retry")
	private int adnetworkRetry;

	@Column(name="circle_code")
	private String circleCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date",columnDefinition="DATETIME")
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modify_date")
	private Date modifyDate;
	
	@Column(name="last_fallback_billing_code")
	private int lastFallbackBillingCode;

	@Column(name="current_retry")
	private int currentRetry;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_content_sms_date")
	private Date lastContentSmsDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_deactivation_date")
	private Date lastDeactivationDate;

	@Column(name="user_preferred_language")
	private String userPreferredLanguage;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_pre_renewal_sms_date")
	private Date lastPreRenewalSmsDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_video_watch_date")
	private Date lastVideoWatchDate;

	@Column(name="micro_site_id")
	private String microSiteId;
	
	@Column(name="feature_id")
	private String featureId;
	
	@Column(name="user_communication_language")
	private String userCommunicationlanguage;

	public UserSubscription() {
		super();
		Date currentTime = new Date();
		this.subscriptionId = 0;
		this.customerId = 0;
		this.providerId = 0;
		this.msisdn = "";
		this.userId = "";
		this.itemId = 0;
		this.itemTypeId = 0;
		this.billingCode = 0;
		this.subscriptionBillingCode = 0;
		this.currentBillingCode = 0;
		this.subscriptionStatusId = 0;
		this.startDate = currentTime;
		this.endDate = currentTime;
		this.subscriptionDate  = null;
		this.isDeactivationInitiated = "AUTO";
		this.lastBillingRequestDate  = null;
		this.lastBillingRequestTransactionId = "";
		this.lastBillingResponseDate  = null;
		this.lastBillingResponseStatusId = 0;
		this.lastNotificationDate  = null;
		this.lastNotificationTransactionId = "";
		this.lastNotificationStatusId = 0;
		this.nextBillingDate  = null;
		this.billingRetry = 0;
		this.userSource = "";
		this.chargingSource = "";
		this.customerTransactionId = "";
		this.credits = 0;
		this.adnetworkId = 0;
		this.adnetworkTransactionId = "";
		this.adnetworkRetry = 0;
		this.circleCode = "";
		this.createDate  = currentTime;
		this.modifyDate  = currentTime;
		this.lastFallbackBillingCode = 0;
		this.currentRetry = 0;
		this.lastContentSmsDate  = null;
		this.lastDeactivationDate  = null;
		this.preferredLanguage="";
		this.userPreferredLanguage = "";
		this.lastPreRenewalSmsDate  = null;
		this.lastVideoWatchDate  = null;
		this.microSiteId=null;
		this.featureId=null;
		this.userCommunicationlanguage="";
	}

	public String getUserCommunicationlanguage() {
		return userCommunicationlanguage;
	}

	public void setUserCommunicationlanguage(String userCommunicationlanguage) {
		this.userCommunicationlanguage = userCommunicationlanguage;
	}
	public long getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(long subscriptionId) {
		this.subscriptionId = subscriptionId;
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

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public int getBillingCode() {
		return billingCode;
	}

	public void setBillingCode(int billingCode) {
		this.billingCode = billingCode;
	}

	public int getSubscriptionBillingCode() {
		return subscriptionBillingCode;
	}

	public void setSubscriptionBillingCode(int subscriptionBillingCode) {
		this.subscriptionBillingCode = subscriptionBillingCode;
	}

	public int getCurrentBillingCode() {
		return currentBillingCode;
	}

	public void setCurrentBillingCode(int currentBillingCode) {
		this.currentBillingCode = currentBillingCode;
	}

	public int getSubscriptionStatusId() {
		return subscriptionStatusId;
	}

	public String getPreferredLanguage() {
		return preferredLanguage;
	}



	public void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}



	public void setSubscriptionStatusId(int subscriptionStatusId) {
		this.subscriptionStatusId = subscriptionStatusId;
	}
	
	@XmlElement(name = "timestamp", required = true) 
	@XmlJavaTypeAdapter(com.vuclip.np.activation.repository.DateAdapter.class)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subcriptionDate) {
		this.subscriptionDate = subcriptionDate;
	}

	public String getIsDeactivationInitiated() {
		return isDeactivationInitiated;
	}

	public void setIsDeactivationInitiated(String isDeactivationInitiated) {
		this.isDeactivationInitiated = isDeactivationInitiated;
	}

	public Date getLastBillingRequestDate() {
		return this.lastBillingRequestDate;
	}


	public void setLastBillingRequestDate(Date lastBillingRequestDate) {
			this.lastBillingRequestDate = lastBillingRequestDate;
		
	}

	

	public String getLastBillingRequestTransactionId() {
		return lastBillingRequestTransactionId;
	}



	public void setLastBillingRequestTransactionId(
			String lastBillingRequestTransactionId) {
		this.lastBillingRequestTransactionId = lastBillingRequestTransactionId;
	}



	public Date getLastBillingResponseDate() {
		return lastBillingResponseDate;
	}

	public void setLastBillingResponseDate(Date lastBillingResponseDate) {
		this.lastBillingResponseDate = lastBillingResponseDate;
	}

	public int getLastBillingResponseStatusId() {
		return lastBillingResponseStatusId;
	}

	public void setLastBillingResponseStatusId(int lastBillingResponseStatusId) {
		this.lastBillingResponseStatusId = lastBillingResponseStatusId;
	}

	public Date getLastNotificationDate() {
		return lastNotificationDate;
	}

	public void setLastNotificationDate(Date lastNotificationDate) {
		this.lastNotificationDate = lastNotificationDate;
	}

	

	public String getLastNotificationTransactionId() {
		return lastNotificationTransactionId;
	}



	public void setLastNotificationTransactionId(
			String lastNotificationTransactionId) {
		this.lastNotificationTransactionId = lastNotificationTransactionId;
	}



	public int getLastNotificationStatusId() {
		return lastNotificationStatusId;
	}

	public void setLastNotificationStatusId(int lastNotificationStatusId) {
		this.lastNotificationStatusId = lastNotificationStatusId;
	}

	public Date getNextBillingDate() {
		return nextBillingDate;
	}

	public void setNextBillingDate(Date nextBillingDate) {
		this.nextBillingDate = nextBillingDate;
	}

	public int getBillingRetry() {
		return billingRetry;
	}

	public void setBillingRetry(int billingRetry) {
		this.billingRetry = billingRetry;
	}

	public String getUserSource() {
		return userSource;
	}

	public void setUserSource(String userSource) {
		this.userSource = userSource;
	}

	public String getChargingSource() {
		return chargingSource;
	}

	public void setChargingSource(String chargingSource) {
		this.chargingSource = chargingSource;
	}

	public String getCustomerTransactionId() {
		return customerTransactionId;
	}

	public void setCustomerTransactionId(String customerTransactionId) {
		this.customerTransactionId = customerTransactionId;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getAdnetworkId() {
		return adnetworkId;
	}

	public void setAdnetworkId(int adnetworkId) {
		this.adnetworkId = adnetworkId;
	}

	public String getAdnetworkTransactionId() {
		return adnetworkTransactionId;
	}

	public void setAdnetworkTransactionId(String adnetworkTransactionId) {
		this.adnetworkTransactionId = adnetworkTransactionId;
	}

	public int getAdnetworkRetry() {
		return adnetworkRetry;
	}

	public void setAdnetworkRetry(int adnetworkRetry) {
		this.adnetworkRetry = adnetworkRetry;
	}

	public String getCircleCode() {
		return circleCode;
	}

	public void setCircleCode(String circleCode) {
		this.circleCode = circleCode;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getLastFallbackBillingCode() {
		return lastFallbackBillingCode;
	}

	public void setLastFallbackBillingCode(int lastFallbackBillingCode) {
		this.lastFallbackBillingCode = lastFallbackBillingCode;
	}

	public int getCurrentRetry() {
		return currentRetry;
	}

	public void setCurrentRetry(int currentRetry) {
		this.currentRetry = currentRetry;
	}

	public Date getLastContentSmsDate() {
		return lastContentSmsDate;
	}

	public void setLastContentSmsDate(Date lastContentSmsDate) {
		this.lastContentSmsDate = lastContentSmsDate;
	}

	public Date getLastDeactivationDate() {
		return lastDeactivationDate;
	}

	public void setLastDeactivationDate(Date lastDeactivationDate) {
		this.lastDeactivationDate = lastDeactivationDate;
	}

	public Date getOptoutSMSDate() {
		return optoutSMSDate;
	}



	public void setOptoutSMSDate(Date optoutSMSDate) {
		this.optoutSMSDate = optoutSMSDate;
	}

	
	
	public String getUserPreferredLanguage() {
		return userPreferredLanguage;
	}



	public void setUserPreferredLanguage(String userPreferredLanguage) {
		this.userPreferredLanguage = userPreferredLanguage;
	}

	public Date getLastPreRenewalSmsDate() {
		return lastPreRenewalSmsDate;
	}


	public void setLastPreRenewalSmsDate(Date lastPreRenewalSmsDate) {
		this.lastPreRenewalSmsDate = lastPreRenewalSmsDate;
	}

	public Date getLastVideoWatchDate() {
		return lastVideoWatchDate;
	}

	public void setLastVideoWatchDate(Date lastVideoWatchDate) {
		this.lastVideoWatchDate = lastVideoWatchDate;
	}
		
	public String getMicroSiteId() {
		return microSiteId;
	}

	public void setMicroSiteId(String microSiteId) {
		this.microSiteId = microSiteId;
	}
	
	public String getFeatureId() {
		return featureId;
	}

	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}




	@Override
	public String toString() {
		return "UserSubscription [subscriptionId=" + subscriptionId + ", customerId=" + customerId + ", providerId="
				+ providerId + ", msisdn=" + msisdn + ", userId=" + userId + ", itemId=" + itemId + ", itemTypeId="
				+ itemTypeId + ", billingCode=" + billingCode + ", subscriptionBillingCode=" + subscriptionBillingCode
				+ ", currentBillingCode=" + currentBillingCode + ", subscriptionStatusId=" + subscriptionStatusId
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", subscriptionDate=" + subscriptionDate
				+ ", isDeactivationInitiated=" + isDeactivationInitiated + ", lastBillingRequestDate="
				+ lastBillingRequestDate + ", lastBillingRequestTransactionId=" + lastBillingRequestTransactionId
				+ ", lastBillingResponseDate=" + lastBillingResponseDate + ", lastBillingResponseStatusId="
				+ lastBillingResponseStatusId + ", lastNotificationDate=" + lastNotificationDate
				+ ", lastNotificationTransactionId=" + lastNotificationTransactionId + ", lastNotificationStatusId="
				+ lastNotificationStatusId + ", nextBillingDate=" + nextBillingDate + ", optoutSMSDate=" + optoutSMSDate
				+ ", billingRetry=" + billingRetry + ", preferredLanguage=" + preferredLanguage + ", userSource="
				+ userSource + ", chargingSource=" + chargingSource + ", customerTransactionId=" + customerTransactionId
				+ ", credits=" + credits + ", adnetworkId=" + adnetworkId + ", adnetworkTransactionId="
				+ adnetworkTransactionId + ", adnetworkRetry=" + adnetworkRetry + ", circleCode=" + circleCode
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate + ", lastFallbackBillingCode="
				+ lastFallbackBillingCode + ", currentRetry=" + currentRetry + ", lastContentSmsDate="
				+ lastContentSmsDate + ", lastDeactivationDate=" + lastDeactivationDate + ", userPreferredLanguage="
				+ userPreferredLanguage + ", lastPreRenewalSmsDate=" + lastPreRenewalSmsDate + ", lastVideoWatchDate="
				+ lastVideoWatchDate + ", microSiteId=" + microSiteId + ", featureId=" + featureId
				+ ", userCommunicationlanguage=" + userCommunicationlanguage + "]";
	}

	/**
	 * @return
	 */
	public Object toDebugString() {
		return "UserSubscription [subscriptionId=" + subscriptionId
				+ ", customerId=" + customerId + ", providerId=" + providerId
				+ ", msisdn=" + msisdn + ", userId=" + userId + ", itemId="
				+ itemId + ", itemTypeId=" + itemTypeId + ", billingCode="
				+ billingCode + ", subscriptionBillingCode="
				+ subscriptionBillingCode + ", currentBillingCode="
				+ currentBillingCode + ", subscriptionStatusId="
				+ subscriptionStatusId + ", credits=" + credits
				+ ", adnetworkId=" + adnetworkId + ", adnetworkTransactionId="
				+ adnetworkTransactionId + "]";
	}




}