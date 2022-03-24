package org.wso2.apim.monetization.impl;

import com.stripe.Stripe;
import org.wso2.carbon.apimgt.api.APIProvider;
import org.wso2.carbon.apimgt.api.MonetizationException;
import org.wso2.carbon.apimgt.api.model.API;
import org.wso2.carbon.apimgt.api.model.MonetizationUsagePublishInfo;
import org.wso2.carbon.apimgt.api.model.policy.SubscriptionPolicy;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Map;

public class StripeMonetizationImplExt extends StripeMonetizationImpl {
    private Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.77.40.37", 3128));

    public void settingProxyConfigs(){
        //Set the proxy configs
        Stripe.setConnectionProxy(proxy);
    }

    @Override
    public boolean createBillingPlan(SubscriptionPolicy subscriptionPolicy) throws MonetizationException {
        settingProxyConfigs();
        return super.createBillingPlan(subscriptionPolicy);
    }

    @Override
    public boolean deleteBillingPlan(SubscriptionPolicy subscriptionPolicy) throws MonetizationException {
        settingProxyConfigs();
        return super.deleteBillingPlan(subscriptionPolicy);
    }

    @Override
    public boolean disableMonetization(String tenantDomain, API api, Map<String, String> monetizationProperties) throws MonetizationException {
        settingProxyConfigs();
        return super.disableMonetization(tenantDomain, api, monetizationProperties);
    }

    @Override
    public boolean enableMonetization(String tenantDomain, API api, Map<String, String> monetizationProperties) throws MonetizationException {
        settingProxyConfigs();
        return super.enableMonetization(tenantDomain, api, monetizationProperties);
    }

    @Override
    public boolean updateBillingPlan(SubscriptionPolicy subscriptionPolicy) throws MonetizationException {
        settingProxyConfigs();
        return super.updateBillingPlan(subscriptionPolicy);
    }

    @Override
    public Map<String, String> getMonetizedPoliciesToPlanMapping(API api) throws MonetizationException {
        settingProxyConfigs();
        return super.getMonetizedPoliciesToPlanMapping(api);
    }

    @Override
    public boolean publishMonetizationUsageRecords(MonetizationUsagePublishInfo lastPublishInfo) throws MonetizationException {
        settingProxyConfigs();
        return super.publishMonetizationUsageRecords(lastPublishInfo);
    }

    @Override
    public Map<String, String> getCurrentUsageForSubscription(String subscriptionUUID, APIProvider apiProvider) throws MonetizationException {
        settingProxyConfigs();
        return super.getCurrentUsageForSubscription(subscriptionUUID, apiProvider);
    }

    @Override
    public Map<String, String> getTotalRevenue(API api, APIProvider apiProvider) throws MonetizationException {
        settingProxyConfigs();
        return super.getTotalRevenue(api, apiProvider);
    }
}
