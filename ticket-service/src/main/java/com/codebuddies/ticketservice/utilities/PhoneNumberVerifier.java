package com.codebuddies.ticketservice.utilities;
import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.lookups.v1.PhoneNumber;

public class PhoneNumberVerifier {
    private static final String ACCOUNT_SID = "AC57e8706560c646094599256611987111";
    private static final String AUTH_TOKEN = "01d0c8a94be8a68cd379f1b5bb5be9da";


    public static boolean verifyPhoneNumber(String phoneNumber){
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
        try{
            PhoneNumber phoneNumberInfo = PhoneNumber.fetcher(new com.twilio.type.PhoneNumber(phoneNumber)).fetch();
            return phoneNumberInfo.getPhoneNumber() != null;

        }catch (ApiException ex){
            return  false;

        }

    }


}
