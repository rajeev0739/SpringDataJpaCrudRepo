package com.vuclip.np.activation.repository;
import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vuclip.np.activation.entities.UserSubscription;


@Repository
public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Long>{
	
	@Query("FROM UserSubscription  u where u.providerId = :provider_id and  u.customerId = :customer_id and u.msisdn=:msisdn  and u.itemId=:item_id and u.itemTypeId=:item_type_id  and createDate between '2018-08-03 00:00:00' and '2018-08-07 23:00:00' and subscriptionDate IS NULL and subscriptionBillingCode=0 ")
	List<UserSubscription> findByProviderIdAndCustomerIdAndMsisdnAndItemIdAndItemTypeId(@Param("provider_id") int provider_id,@Param("customer_id") int customer_id,@Param("msisdn") String msisdn,@Param("item_id") int item_id,@Param("item_type_id") int item_type_id);
       
	@Query("FROM UserSubscription  u where u.providerId = :provider_id and  u.customerId = :customer_id and u.msisdn=:msisdn  and u.itemId=:item_id  and createDate between '2018-08-03 00:00:00' and '2018-08-07 23:00:00' and subscriptionDate IS NULL and subscriptionBillingCode=0 ")
	List<UserSubscription> findByProviderIdAndCustomerIdAndMsisdnAndItemId(@Param("provider_id") int provider_id,@Param("customer_id") int customer_id,@Param("msisdn") String msisdn,@Param("item_id") int item_id);
     
	@Query("FROM UserSubscription  u where u.providerId = :provider_id and  u.customerId = :customer_id and u.msisdn=:msisdn  and createDate between '2018-08-03 00:00:00' and '2018-08-07 23:00:00' and subscriptionDate IS NULL and subscriptionBillingCode=0")
	List<UserSubscription> findByProviderIdAndCustomerIdAndMsisdn(@Param("provider_id") int provider_id,@Param("customer_id") int customer_id,@Param("msisdn") String msisdn);
 
	@Query("FROM UserSubscription  u where  u.msisdn=:msisdn  and createDate between '2018-08-03 00:00:00' and '2018-08-07 23:00:00' and subscriptionDate IS NULL and subscriptionBillingCode=0")
	List<UserSubscription> findByMsisdn(@Param("msisdn") String msisdn);
	 
    
	@Modifying(clearAutomatically = true)
    @Transactional
    @Query(value="UPDATE UserSubscription   u SET u.subscriptionBillingCode = :subscription_billing_code ,u.subscriptionDate = :subscription_date where u.subscriptionId = :subscription_id ")
    int updateSubscriptionBillingCodeAndsubscriptionDateBySubscriptionId(@Param("subscription_billing_code") int subscription_billing_code, @Param("subscription_date") Date subscription_date,@Param("subscription_id") long subscription_id);

  
	  @Modifying(clearAutomatically = true)
	  @Transactional
	  @Query(value="UPDATE UserSubscription u SET u.subscriptionBillingCode =:subscription_billing_code,u.subscriptionDate = :subscription_date ,subscriptionStatusId =:subscription_status_id where u.subscriptionId = :subscription_id ")
	  int updateSubscriptionBillingCodeAndsubscriptionDateAndSubscriptionStatusIdBySubscriptionId(@Param("subscription_billing_code") int subscription_billing_code, @Param("subscription_date") Date subscription_date,@Param("subscription_status_id") int subscription_status_id,@Param("subscription_id") long subscription_id);

    
    /* @Modifying(clearAutomatically = true)
    @Query("UPDATE UserSubscription u SET u.subscriptionBillingCode = :subscription_billing_code ,u.subscriptionDate = :subscription_date where u.providerId = :provider_id and  u.customerId = :customer_id and u.msisdn=:msisdn  and u.itemId=:item_id and u.itemTypeId=:item_type_id ")
    int updateSubscriptionBillingCodeAndsubscriptionDateByProviderIdAndCustomerIdAndMsisdnAndItemIdAndItemTypeId(@Param("subscription_billing_code") int subscription_billing_code, @Param("subscription_date") Date subscription_date,@Param("provider_id") int provider_id,@Param("customer_id") int customer_id,@Param("msisdn") String msisdn,@Param("item_id") int item_id,@Param("item_type_id") int item_type_id);
    
    @Modifying(clearAutomatically = true)
    @Query("UPDATE UserSubscription u SET u.subscriptionBillingCode = :subscription_billing_code ,u.subscriptionDate = :subscription_date where u.providerId = :provider_id and  u.customerId = :customer_id and u.msisdn=:msisdn  and u.itemId=:item_id")
    int updateSubscriptionBillingCodeAndsubscriptionDateByProviderIdAndCustomerIdAndMsisdnAndItemId(@Param("subscription_billing_code") int subscription_billing_code, @Param("subscription_date") Date subscription_date,@Param("provider_id") int provider_id,@Param("customer_id") int customer_id,@Param("msisdn") String msisdn,@Param("item_id") int item_id);

   
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value="UPDATE UserSubscription u SET u.subscriptionBillingCode = :subscription_billing_code ,u.subscriptionDate = :subscription_date where u.providerId = :provider_id and  u.customerId = :customer_id and u.msisdn=:msisdn ")
    int updateSubscriptionBillingCodeAndsubscriptionDateByProviderIdAndCustomerIdAndMsisdn(@Param("subscription_billing_code") int subscription_billing_code, @Param("subscription_date") Date subscription_date,@Param("provider_id") int provider_id,@Param("customer_id") int customer_id,@Param("msisdn") String msisdn);

   
    @Query("FROM UserSubscription  u where u.providerId = :provider_id and  u.customerId = :customer_id and u.msisdn=:msisdn  ")
	List<UserSubscription> findByProviderIdAndCustomerIdAndMsisdnTest(@Param("provider_id") int provider_id,@Param("customer_id") int customer_id,@Param("msisdn") String msisdn);
 */
}


