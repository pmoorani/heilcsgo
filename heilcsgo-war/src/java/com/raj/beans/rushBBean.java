/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raj.beans;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;


/**
 *
 * @author futuretech
 */
@Stateless
public class rushBBean implements rushBBeanLocal {
    // Destination
    @Resource(mappedName = "employeeQueue")
    private Queue employeeQueue;
    
    @Resource(mappedName = "employeeConnectionFactory")
    private ConnectionFactory employeeConnectionFactory;

    @Override
    public void sendMessage(String message) {
        try {
            Connection conn = employeeConnectionFactory.createConnection();
            Session session = conn.createSession();
            
            TextMessage text = session.createTextMessage();
            text.setText(message);
            
            MessageProducer mp = session.createProducer(employeeQueue);
            mp.send(text);            
        } catch (JMSException ex) {
            ex.printStackTrace();
            
        }
    }

}
