/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.collaborativeClouds.workers;

import com.collaborativeClouds.mappers.TblVehicleRegistration;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class RegisterVehicle {

    private Session mSession = null;
    private Transaction mTransaction = null;

    public String Register(String JSONData) throws JSONException {
        try {
            SessionFactory sessFact = new Configuration().configure().buildSessionFactory();
            mSession = sessFact.openSession();
            mTransaction = mSession.beginTransaction();

            JSONObject mObject = new JSONObject(JSONData);

            String registration = mObject.get("registration").toString();
            String description = mObject.get("description").toString();
            String dealer_name = mObject.get("dealer_name").toString();
            String dealer_address = mObject.get("dealer_address").toString();
            String maker_name = mObject.get("maker_name").toString();
            String owner_name = mObject.get("owner_name").toString();
            String owner_guide = mObject.get("owner_guide").toString();
            String owner_relation = mObject.get("owner_relation").toString();
            String owner_perm_address = mObject.get("owner_perm_address").toString();
            String owner_temp_address = mObject.get("owner_temp_address").toString();
            int duration = Integer.parseInt(mObject.get("duration").toString());
            String pan = mObject.get("pan").toString();
            String birth_place = mObject.get("birth_place").toString();
            String migrated_date = mObject.get("migrated_date").toString();
            String exarmy = mObject.get("exarmy").toString();
            String vehicle_class = mObject.get("vehicle_class").toString();
            String vehicle_is = mObject.get("vehicle_is").toString();
            String body_type = mObject.get("body_type").toString();
            String vehicle_type = mObject.get("vehicle_type").toString();
            String manufactured_month = mObject.get("manufactured_month").toString();
            String manufactured_year = mObject.get("manufactured_year").toString();
            int cylinders = Integer.parseInt(mObject.get("cylinders").toString());
            int hp = Integer.parseInt(mObject.get("hp").toString());
            int cubic_capacity = Integer.parseInt((String) mObject.get("cubic_capacity"));
            String classification = mObject.get("classification").toString();
            String chassis = mObject.get("chassis").toString();
            String engine = mObject.get("engine").toString();
            int seating = Integer.parseInt(mObject.get("seating").toString());
            String fuel = mObject.get("fuel").toString();
            int unladen_weight = Integer.parseInt(mObject.get("unladen_weight").toString());
            String prev_registration = mObject.get("prev_registration").toString();
            String color = mObject.get("color").toString();
            String wheel = mObject.get("wheel").toString();

            TblVehicleRegistration mRegister = new TblVehicleRegistration();
            mRegister.setRegistrationNumber(registration);
            mRegister.setBirthPlace(birth_place);
            mRegister.setBodyType(body_type);
            mRegister.setChassisNumber(chassis);
            mRegister.setColor(color);
            mRegister.setCubicCapacity(cubic_capacity);
            mRegister.setCylinders(cylinders);
            mRegister.setDealerAddress(dealer_address);
            mRegister.setDealerName(dealer_name);
            mRegister.setDescription(description);
            mRegister.setDurationOfStay(duration);
            mRegister.setEngineNumber(engine);
            mRegister.setExarmyImportedVehicle(exarmy);
            mRegister.setFuel(fuel);
            mRegister.setHp(hp);
            mRegister.setMakerClassification(classification);
            mRegister.setMakerName(maker_name);
            mRegister.setManufactureMonth(manufactured_month);
            mRegister.setManufactureYear(manufactured_year);
            mRegister.setMigratedDate(migrated_date);
            mRegister.setOwnerGuide(owner_guide);
            mRegister.setOwnerGuideRelation(owner_relation);
            mRegister.setOwnerName(owner_name);
            mRegister.setOwnerPermAddress(owner_perm_address);
            mRegister.setOwnerTempAddress(owner_temp_address);
            mRegister.setPanNumber(pan);
            mRegister.setPrevRegistration(prev_registration);
            mRegister.setSeating(seating);
            mRegister.setUnladenWeight(unladen_weight);
            mRegister.setVehicleClass(vehicle_class);
            mRegister.setVehicleIs(vehicle_is);
            mRegister.setVehicleType(vehicle_type);
            mRegister.setWheelBase(wheel);

            mSession.save(mRegister);
            mTransaction.commit();
            return "Success";
        } catch (Exception e) {
            Logger.getLogger(RegisterVehicle.class.getName()).log(Level.SEVERE, null, e);
            return "Failed";
        }
    }

}
