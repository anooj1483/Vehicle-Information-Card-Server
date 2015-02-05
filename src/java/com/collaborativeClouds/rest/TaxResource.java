/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.collaborativeClouds.rest;

import com.collaborativeClouds.utils.JSONUtils;
import com.collaborativeClouds.workers.PayTax;
import com.collaborativeClouds.workers.SessionOperator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.HttpHeaders;

/**
 * REST Web Service
 *
 * @author CollaborativeClouds Software Solutions
 * <www.collaborativeclouds.com>
 * <collaborativeclouds@gmail.com>
 */
@Path("tax")
public class TaxResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TaxResource
     */
    public TaxResource() {
    }

    /**
     * Retrieves representation of an instance of
     * com.collaborativeClouds.rest.TaxResource
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
    @Consumes("application/json")
    public String payTax(String taxData, @Context HttpHeaders headers) {
        try {
            String xsession = headers.getRequestHeader("x-session").get(0);
            String username = headers.getRequestHeader("username").get(0);
            SessionOperator mOperator = new SessionOperator();
            int status = mOperator.checkValidSession(username, xsession);
            if (status == 1) {
                JSONUtils mUtils = new JSONUtils();
                boolean isValid = mUtils.isJSONValid(taxData);
                if (isValid == true) {
                    PayTax mPay = new PayTax();
                    String result = mPay.addTaxData(taxData);
                    return result;
                }else{
                    return "Error";
                }
            } else {
                return "Logout";
            }
        } catch (Exception ex) {
            return "Error";
        }
    }

    /**
     * PUT method for updating or creating an instance of TaxResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
