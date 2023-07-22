package com.codebuddies.ticketservice.utilities;
import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.lookups.v1.PhoneNumber;

public class PhoneNumberVerifier {
    public static boolean verifyPhoneNumber(String phoneNumber){

        try{
            PhoneNumber phoneNumberInfo = PhoneNumber.fetcher(new com.twilio.type.PhoneNumber(phoneNumber)).fetch();
            return phoneNumberInfo.getPhoneNumber() != null;

        }catch (ApiException ex){
            return  false;

        }

    }


}
