package com.collaborativeClouds.mappers;
// Generated Dec 2, 2014 11:43:13 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * TblInsurance generated by hbm2java
 */
public class TblInsurance  implements java.io.Serializable {


     private Integer id;
     private String registrationNumber;
     private String insuranceImagePath;
     private Date insurancePeriodFrom;
     private Date insurancePeriodTo;

    public TblInsurance() {
    }

    public TblInsurance(String registrationNumber, String insuranceImagePath, Date insurancePeriodFrom, Date insurancePeriodTo) {
       this.registrationNumber = registrationNumber;
       this.insuranceImagePath = insuranceImagePath;
       this.insurancePeriodFrom = insurancePeriodFrom;
       this.insurancePeriodTo = insurancePeriodTo;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getRegistrationNumber() {
        return this.registrationNumber;
    }
    
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public String getInsuranceImagePath() {
        return this.insuranceImagePath;
    }
    
    public void setInsuranceImagePath(String insuranceImagePath) {
        this.insuranceImagePath = insuranceImagePath;
    }
    public Date getInsurancePeriodFrom() {
        return this.insurancePeriodFrom;
    }
    
    public void setInsurancePeriodFrom(Date insurancePeriodFrom) {
        this.insurancePeriodFrom = insurancePeriodFrom;
    }
    public Date getInsurancePeriodTo() {
        return this.insurancePeriodTo;
    }
    
    public void setInsurancePeriodTo(Date insurancePeriodTo) {
        this.insurancePeriodTo = insurancePeriodTo;
    }




}


