/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.collaborativeClouds.rest;

import com.collaborativeClouds.workers.LoginLogoutHandler;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;
import org.json.JSONException;

/**
 * REST Web Service
 *
 * @author CollaborativeClouds Software Solutions
 * <www.collaborativeclouds.com>
 * <collaborativeclouds@gmail.com>
 */
@Path("logout")
public class LogoutResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LogoutResource
     */
    public LogoutResource() {
    }

    /**
     * Retrieves representation of an instance of com.collaborativeClouds.rest.LogoutResource
     * @return an instance of java.lang.String
     */
    @POST
    @Produces("application/json")
    public String actionLogout(String userdata,@Context HttpHeaders headers) throws JSONException {

        LoginLogoutHandler mHandler=new LoginLogoutHandler();
        String xsession = headers.getRequestHeader("x-session").get(0);
        String username=headers.getRequestHeader("username").get(0);
        
        System.err.println(xsession+" "+userdata+" "+username);
        return mHandler.Logout(username,xsession)+"";
   
    }

    /**
     * PUT method for updating or creating an instance of LogoutResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
