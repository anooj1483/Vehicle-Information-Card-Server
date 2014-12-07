/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.collaborativeClouds.rest;

import com.collaborativeClouds.workers.RegisterVehicle;
import com.collaborativeClouds.workers.SessionOperator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.HttpHeaders;
import org.json.JSONException;

/**
 * REST Web Service
 *
 * @author CollaborativeClouds Software Solutions
 * <www.collaborativeclouds.com>
 * <collaborativeclouds@gmail.com>
 */
@Path("register")
public class RegisterResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RegisterResource
     */
    public RegisterResource() {
    }

    /**
     * Retrieves representation of an instance of
     * com.collaborativeClouds.rest.RegisterResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @POST
    @Produces("application/json")
    public String getRegistrationInfo(String JSONInfo, @Context HttpHeaders headers) {
        try {
            String xsession = headers.getRequestHeader("x-session").get(0);
            String username = headers.getRequestHeader("username").get(0);
            SessionOperator mOperator = new SessionOperator();
            int status = mOperator.checkValidSession(username, xsession);
            if (status == 1) {

                RegisterVehicle mVehicle = new RegisterVehicle();
                String result = mVehicle.Register(JSONInfo);
                return result;

            } else {
                return "Logout";
            }
        } catch (JSONException ex) {
            return "Error";
            //Logger.getLogger(RegisterResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return "";
    }

    /**
     * PUT method for updating or creating an instance of RegisterResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
