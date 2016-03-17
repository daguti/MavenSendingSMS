/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.sendingsms;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author ESa10969
 */
public class SMSender {
    public static final String TEST_ACCOUNT_SID = "AC2cde3fea25fb3b27e3bcf521ba55a170";
    public static final String TEST_AUTH_TOKEN  = "26f225f7fc93c70fb2885307ba81b08e";
    public static final String ACCOUNT_SID      = "ACe75436c0bb2640a4e79036a93835c73b";
    public static final String AUTH_TOKEN       = "effcf3536775051bfa45ee2abce2f762";
    public static final String PHONE_NUMBER     = "+441202629556";
    
    public static void main(String[] args) {
        //Variable definition
        TwilioRestClient client = new TwilioRestClient(TEST_ACCOUNT_SID, TEST_AUTH_TOKEN);
        List<NameValuePair> params;
        MessageFactory messageFactory;
        Message message;
        
        try {
            // Build a filter for the MessageList
            params = new ArrayList<>();
            params.add(new BasicNameValuePair("Body", "Gloria please?! I love you <3"));
            params.add(new BasicNameValuePair("To", "+34669232933"));
            params.add(new BasicNameValuePair("From", PHONE_NUMBER));
            System.out.println(client.getEndpoint());
            //Send SMS
            messageFactory = client.getAccount().getMessageFactory();
            message        = messageFactory.create(params);
            System.out.println(message.getSid());
        } catch(TwilioRestException ex) {
            System.out.println(ex.getErrorMessage());
        }
    }
}
  