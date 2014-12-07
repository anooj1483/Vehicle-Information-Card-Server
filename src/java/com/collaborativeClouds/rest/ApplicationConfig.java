/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.collaborativeClouds.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author CollaborativeClouds Software Solutions
 * <www.collaborativeclouds.com>
 * <collaborativeclouds@gmail.com>
 */
@javax.ws.rs.ApplicationPath("vehicleinfo")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.collaborativeClouds.rest.LoginResource.class);
        resources.add(com.collaborativeClouds.rest.LogoutResource.class);
        resources.add(com.collaborativeClouds.rest.RegisterResource.class);
    }
    
}
