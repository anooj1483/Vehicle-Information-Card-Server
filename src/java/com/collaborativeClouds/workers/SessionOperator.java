/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.collaborativeClouds.workers;

import com.collaborativeClouds.mappers.TblOnline;
import java.util.List;
import org.hibernate.Query;
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
public class SessionOperator {

    private Session mSession = null;
    private Transaction mTransaction = null;

    public SessionOperator() {
    }

    public String setSession(String username, String session_id) {
        try {
            SessionFactory sessFact = new Configuration().configure().buildSessionFactory();
            mSession = sessFact.openSession();
            mTransaction = mSession.beginTransaction();

            TblOnline mOnline = new TblOnline();
            mOnline.setSessionId(session_id);
            mOnline.setUsername(username);
            mSession.save(mOnline);
            mTransaction.commit();
            return session_id;
        } catch (Exception exception) {
            return "Failed";
        }
    }

    public int checkValidSession(String username, String sessionid) {
        try {
            SessionFactory sessFact = new Configuration().configure().buildSessionFactory();
            mSession = sessFact.openSession();
            mTransaction = mSession.beginTransaction();

            List<TblOnline> mOnline = null;
            Query checkOnline = mSession.createQuery("from TblOnline where username='" + username + "' and session_id='" + sessionid + "'");
            mOnline = (List<TblOnline>) checkOnline.list();

            if (mOnline.size() > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            return 0;
        }
    }

    public int removeSession(String userdata, String session_id ) {
        try {
            SessionFactory sessFact = new Configuration().configure().buildSessionFactory();
            mSession=null;
            mSession = sessFact.openSession();
            mTransaction = mSession.beginTransaction();
            JSONObject mObject = new JSONObject(userdata);
            String username = mObject.getString("username");
            System.err.println("USER: "+username);
            Query deleteOnline = mSession.createQuery("delete from TblOnline where username='" + username + "' and sessionId='" + session_id + "'");
            int status = deleteOnline.executeUpdate();
            mTransaction.commit();
            if (status == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            return 0;
        }
    }
}
