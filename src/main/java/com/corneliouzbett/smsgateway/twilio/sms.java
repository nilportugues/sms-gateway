package com.corneliouzbett.smsgateway.twilio;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.List;

import static com.corneliouzbett.smsgateway.config.Config.*;

public class sms {

    public String sendMessage(String text, String phone_number) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber(phone_number),
                        new PhoneNumber(OWNER_CONTACT),
                        text)
                .create();
        System.out.print(message.getSid());
        System.out.print(message.getStatus());
        System.out.print(message.getDateSent());
        return  message.getSid();
    }

    public static String sendBiometricsBulksms(List<String> contacts){

        return null;
    }

    public static String sendBulkSms(String text, List<String> contacts){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        contacts.stream()
                .forEach( contact ->{
                    Message message = Message
                            .creator(new PhoneNumber(contact),
                                    new PhoneNumber(OWNER_CONTACT),
                                    text)
                            .create();
                    System.out.println(message.getSid() +" MESSAGE SENT TO : "+ message.getTo());
                });
        return null;
    }
}