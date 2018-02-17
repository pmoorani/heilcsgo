/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raj.mdb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author futuretech
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "employeeQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class rushBBeanMDB implements MessageListener {
    
    public rushBBeanMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage txt = (TextMessage) message;
            System.out.println(txt.getText());
        } catch (JMSException ex) {
            Logger.getLogger(rushBBeanMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
