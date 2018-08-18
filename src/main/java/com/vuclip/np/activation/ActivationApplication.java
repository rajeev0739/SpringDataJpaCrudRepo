package com.vuclip.np.activation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Query;
import org.springframework.util.StringUtils;

import com.vuclip.np.activation.entities.ParsedData;
import com.vuclip.np.activation.entities.UserSubscription;
import com.vuclip.np.activation.repository.UserSubscriptionRepository;


@SpringBootApplication
public class ActivationApplication implements CommandLineRunner{
	
	@Autowired
	UserSubscriptionRepository repository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	Logger query = LoggerFactory.getLogger("analytics");
	private String fileName = "/home/rajeev/Documents/vuconnect_activation_success_3to6.log";

	public static void main(String[] args) {
		SpringApplication.run(ActivationApplication.class, args);
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		List<UserSubscription> lus;
		 BufferedReader b=null;
         try {

	            File f = new File(fileName);

	             b = new BufferedReader(new FileReader(f));

	            String readLine = "";

	            logger.info("Reading file using Buffered Reader");
	            int count=1;

	            while ((readLine = b.readLine()) != null) {
	            	logger.debug("Starting processing line no :: "+count+" : "+readLine);
	            	
	            	// ParseTheData
	            	 ParsedData pd=parseData(readLine);
	            	 logger.debug("Parsed line no "+count+" :: "+pd.toString());
	                 // find the data from db based on ParseTheData
	            	 lus=fetchUserDataFromDB(pd);
	            	 
	            	 if(null!=lus && lus.size()>0) {
	            		 logger.info("Fetched user data for line no :: "+count+" from db :: "+lus);
	            	 }else {
	            		 logger.info("No data found in db for line no :: "+count);
	            	 }
	            	
	            	 for(UserSubscription us:lus) {
	            			// Update the Data into DB
	            		 updateDataInDB(us,pd);
	            	 }
	            
	            	 logger.debug("completed processing line no "+count+" : ");
	            	 count++;
	            }

	        } catch (IOException e) {
	        	logger.error("Exception while reading file"+e);
	        }finally {
	        	b.close();
	        }
   }

	

	
	
	private ParsedData  parseData(String readLine) throws ParseException {
		
		
		ParsedData pd=new ParsedData();
		
		try {
				int startIndex=readLine.indexOf("PID[");
		    	int endIndex=readLine.indexOf("] CID");
		    			
		    	if(startIndex>0 && endIndex>0) {
		    		String providerId=readLine.substring(startIndex+4,endIndex);
		    		if(null!=providerId && !providerId.equalsIgnoreCase("null") && providerId.length()>0)
		    		pd.setProviderId(Integer.parseInt(providerId));
		    	// logger.info("providerId :"+providerId);
		    	}
		    	
		    	startIndex=readLine.indexOf("CID[");
		    	endIndex=readLine.indexOf("] MSISDN[");
		    	 
		    	if(startIndex>0 && endIndex>0) {
		        	String customerId=readLine.substring(startIndex+4,endIndex);
		        	if(null!=customerId && !customerId.equalsIgnoreCase("null") && customerId.length()>0)
		        	pd.setCustomerId(Integer.parseInt(customerId));
		        	//logger.info("customerId :"+customerId);
		        }
		    	
		    	
		    	startIndex=readLine.indexOf("billingCode=\"");
		    	endIndex=readLine.indexOf("\", itemId=");
		    	 
		    	if(startIndex>0 && endIndex>0) {
		        	String billingCode=readLine.substring(startIndex+13,endIndex);
		        	if(null!=billingCode && !billingCode.equalsIgnoreCase("null") && billingCode.length()>0)
		        	pd.setSubscriptionBillingCode(Integer.parseInt(billingCode));
		        	//logger.info("billingCode : "+billingCode);
		        }
		    	
		    	startIndex=readLine.indexOf("msisdn=\"");
		    	endIndex=readLine.indexOf("\", activityType=\"");
		    	 
		    	if(startIndex>0 && endIndex>0) {
		        	String msisdn=readLine.substring(startIndex+8,endIndex);
		        	if(null!=msisdn && !msisdn.equalsIgnoreCase("null") && msisdn.length()>0)
		        	pd.setMsisdn(msisdn);
		        	//logger.info("msisdn : "+msisdn);
		        }
		    	
		    	
		    	startIndex=readLine.indexOf("itemId=\"");
		    	endIndex=readLine.indexOf("\", activityResult=\"");
		    	 
		    	if(startIndex>0 && endIndex>0) {
		        	String itemId=readLine.substring(startIndex+8,endIndex);
		        	if(null!=itemId && !itemId.equalsIgnoreCase("null") && itemId.length()>0)
		        	pd.setItemId(Integer.parseInt(itemId));
		        	//logger.info("itemId : "+itemId);
		        }
		    	
		    	startIndex=readLine.indexOf("itemTypeId=\"");
		    	endIndex=readLine.indexOf("\", userChargedPrice=\"");
		    	 
		    	if(startIndex>0 && endIndex>0) {
		        	String itemTypeId=readLine.substring(startIndex+12,endIndex);
		        	if(null!=itemTypeId && !itemTypeId.equalsIgnoreCase("null") && itemTypeId.length()>0)
		        	pd.setItemTypeId(Integer.parseInt(itemTypeId));
		        	//logger.info("itemTypeId : "+itemTypeId);
		        }
		    	
		    	startIndex=readLine.indexOf(".bz2:");
		    	endIndex=startIndex;
		    	 
		    	if(startIndex>0 && endIndex>0) {
		        	String subscriptioDate=readLine.substring(startIndex+5,endIndex+24);
		        	if(null!=subscriptioDate && !subscriptioDate.equalsIgnoreCase("null") && subscriptioDate.length()>0)
		        	pd.setSubscriptionDate((subscriptioDate.replace('T', ' ')));
		        	//pd.setSubscriptionDate(convertStringToSqlDate(subscriptioDate));
		        	//logger.info("subscriptioDate : "+subscriptioDate);
		        }
		    	
		    } catch(Exception e) {
    		 logger.error("Exception while parsing line : "+readLine);
    		}
		  return pd ;
    	}
    	
		
	private List<UserSubscription>  fetchUserDataFromDB(ParsedData pd) throws ParseException {
		logger.info("Fetching user data from db");
		List<UserSubscription>  fetchedUsDataFromDBList=null;
		int      provider_id=pd.getProviderId();
		int      customer_id=pd.getCustomerId();
		String   msisdn=pd.getMsisdn();
		int      item_id=pd.getItemId();
		int      item_type_id=pd.getItemTypeId();
		
		try {
		if(pd.getProviderId()>0 && pd.getCustomerId()>0 && StringUtils.hasText(pd.getMsisdn()) && pd.getItemId()>0 && pd.getItemTypeId()>0) {
			logger.info("Data fetching based on provider_id:customer_id:msisdn:item_id:item_type_id >>  "+pd.toString());
			fetchedUsDataFromDBList=repository.findByProviderIdAndCustomerIdAndMsisdnAndItemIdAndItemTypeId(provider_id, customer_id, msisdn, item_id, item_type_id);
		}else if(pd.getProviderId()>0 && pd.getCustomerId()>0 && StringUtils.hasText(pd.getMsisdn()) && pd.getItemId()>0) {
			logger.info("Data fetching based on provider_id:customer_id:msisdn:item_id >> "+pd.toString());
			fetchedUsDataFromDBList=repository.findByProviderIdAndCustomerIdAndMsisdnAndItemId(provider_id, customer_id, msisdn, item_id);
		}else if(pd.getProviderId()>0 && pd.getCustomerId()>0 && StringUtils.hasText(pd.getMsisdn())) {
			logger.info("Data fetching based on provider_id:customer_id:msisdn >> "+pd.toString());
			fetchedUsDataFromDBList=repository.findByProviderIdAndCustomerIdAndMsisdn(provider_id, customer_id, msisdn);
		}else if(provider_id==-1 && customer_id==-1 && StringUtils.hasText(pd.getMsisdn())) {
			// find pid and cid from us based on msisdn 
			logger.info("Data fetching based on msisdn >>  "+pd.toString());
			fetchedUsDataFromDBList=repository.findByMsisdn(msisdn);
			if(fetchedUsDataFromDBList !=null && !fetchedUsDataFromDBList.isEmpty()) {
				pd.setCustomerId(fetchedUsDataFromDBList.get(0).getCustomerId());
				pd.setProviderId(fetchedUsDataFromDBList.get(0).getProviderId());
			}
		}
			
		}catch (Exception e) {
			 logger.error("Exception fetchUserDataFromDB : "+pd.toString());
		}
		
		return fetchedUsDataFromDBList;
	
    }
	
	private boolean  updateDataInDB(UserSubscription us,ParsedData pd) throws ParseException {
		logger.info("starting update us::"+us.toString());
		logger.info("starting update pd::"+pd.toString());
		int sub_status=us.getSubscriptionStatusId();
		int i=0,status=4;
		if(sub_status==1 && sub_status==3 && sub_status==5) {
			updateSubscriptionBillingCodeAndsubscriptionDateAndSubscriptionStatusIdBySubscriptionId(pd.getSubscriptionBillingCode(),pd.getSubscriptionDate(),status,us.getSubscriptionId());
		  //i=repository.updateSubscriptionBillingCodeAndsubscriptionDateAndSubscriptionStatusIdBySubscriptionId(pd.getSubscriptionBillingCode(),pd.getSubscriptionDate(),4,us.getSubscriptionId());
		}else {
			updateSubscriptionBillingCodeAndsubscriptionDateBySubscriptionId(pd.getSubscriptionBillingCode(),pd.getSubscriptionDate(),us.getSubscriptionId());
		  // i=repository.updateSubscriptionBillingCodeAndsubscriptionDateBySubscriptionId(pd.getSubscriptionBillingCode(),pd.getSubscriptionDate(),us.getSubscriptionId());
		}
		logger.info("update completed");
        return true ;
	
    }
	
	
	private void updateSubscriptionBillingCodeAndsubscriptionDateAndSubscriptionStatusIdBySubscriptionId(int subscriptionBillingCode ,String SubscriptionDate,int subscriptionStatusId,long subscriptionId) {
		String Query="UPDATE user_subscription SET subscription_billing_code="+subscriptionBillingCode+",subscription_date="+"\'"+SubscriptionDate+"\'"+",subscription_status_id = "+subscriptionStatusId+" where subscription_id = "+subscriptionId+";";
		query.debug(Query);
	}
    
	
	private void updateSubscriptionBillingCodeAndsubscriptionDateBySubscriptionId(int subscriptionBillingCode ,String SubscriptionDate,long subscriptionId) {
		String Query="UPDATE user_subscription SET subscription_billing_code="+subscriptionBillingCode+",subscription_date="+"\'"+SubscriptionDate+"\'"+" where subscription_id = "+subscriptionId+";";		
		query.debug(Query);
	}
 
	private Date  convertStringToSqlDate(String dateInString) throws ParseException {
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		 Date date =  new java.sql.Date(formatter.parse(dateInString).getTime())  ;
         return date ;
	}
	
}
