/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.collaborativeClouds.workers;

import com.collaborativeClouds.mappers.TblAdmin;
import com.collaborativeClouds.mappers.TblOnline;
import com.collaborativeClouds.utils.NewHibernateUtil;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.UUID;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author CollaborativeClouds Software Solutions
 * <www.collaborativeclouds.com>
 * <collaborativeclouds@gmail.com>
 */
public class LoginLogoutHandler {

    private Session mSession = null;
    private Transaction mTransaction = null;

    public LoginLogoutHandler() {

        //SessionFactory mFactory = new Configuration().configure().buildSessionFactory();
    }

    public String verifyLogin(String incoming_info) throws JSONException {

        try {
            SessionFactory sessFact = new Configuration().configure().buildSessionFactory();
            mSession = sessFact.openSession();
            mTransaction = mSession.beginTransaction();
            JSONObject mObject = new JSONObject(incoming_info);
            List<TblAdmin> mAdminList = null;

            String username = mObject.getString("username");
            String password = mObject.getString("password");

            Query checkLogin = mSession.createQuery("from TblAdmin where username='" + username + "' and password='" + password + "'");
            mAdminList = (List<TblAdmin>) checkLogin.list();
            if (mAdminList.size() > 0) {
                UUID sess_id = UUID.randomUUID();
                String sessionid = "" + sess_id;
                SessionOperator mOperator=new SessionOperator();
                sessionid=mOperator.setSession(username, sessionid);
                return sessionid;
            } else {
                return "Failed";
            }

        } catch (Exception ex) {
            return "Failed";
        }
    }

    public int Logout(String userdata,String sessionid) throws JSONException {
        try {
            SessionOperator mSessionOperator=new SessionOperator();
            int status=mSessionOperator.removeSession(userdata,sessionid);
            return status;
        } catch (Exception ex) {
            return 0;
        }
    }
    

}
