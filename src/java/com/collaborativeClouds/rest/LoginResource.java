/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.collaborativeClouds.rest;

import com.collaborativeClouds.workers.LoginLogoutHandler;
import java.util.UUID;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.json.JSONException;

/**
 * REST Web Service
 *
 * @author CollaborativeClouds Software Solutions
 * <www.collaborativeclouds.com>
 * <collaborativeclouds@gmail.com>
 */
@Path("login")
public class LoginResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LoginResource
     */
    public LoginResource() {
    }

    /**
     * Retrieves representation of an instance of
     * com.collaborativeClouds.rest.LoginResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        return "{\"Security Warning\": \"Unauthorized Access\"}";
        //throw new UnsupportedOperationException();
    }

    @POST
    @Consumes("application/json")
    public Response verifyUser(String parameter) throws JSONException {
        LoginLogoutHandler mLoginHandler = new LoginLogoutHandler();
        String response = mLoginHandler.verifyLogin(parameter);
        String status = null;
        if (response.contains("Failed")) {
            status = "Failed";
        } else {
            status = "Success";
        }
        return Response.ok(status).header("status", status).header("x-session", response).build();

    }

    /**
     * PUT method for updating or creating an instance of LoginResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
