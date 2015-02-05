/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.collaborativeClouds.workers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONObject;

/**
 *
 * @author CollaborativeClouds Software Solutions
 * <www.collaborativeclouds.com>
 * <collaborativeclouds@gmail.com>
 */
public class PayTax {

    private Session mSession = null;
    private Transaction mTransaction = null;

    public String addTaxData(String taxdata) {
        try {
            SessionFactory sessFact = new Configuration().configure().buildSessionFactory();
            mSession = sessFact.openSession();
            mTransaction = mSession.beginTransaction();
            JSONObject mObject = new JSONObject(taxdata);
            
            return taxdata;
        } catch (Exception ex) {
            return "Error";
        }
    }
}
