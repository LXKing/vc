package com.ccclubs.olap.test;

import com.ccclubs.olap.bean.Pace;
import com.ccclubs.olap.bean.Vehicle_entire;
import com.ccclubs.olap.util.DrivePaceFactory;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class DriveTest {
    static List<Vehicle_entire> vehicleEntireList = null;

    @BeforeClass
    public static void setupBeforeClass(){
        vehicleEntireList = new ArrayList<>();

        Vehicle_entire vehicle_entire1 = new Vehicle_entire();
        vehicle_entire1.setCs_vin("LJ8E3C1M6GB009071");
        vehicle_entire1.setCs_number("T6401959");
        vehicle_entire1.setCs_car_status(1);
        vehicle_entire1.setBatt_status(3);
        vehicle_entire1.setCan_batt_status(0);
        vehicle_entire1.setSaving_status(0);
        vehicle_entire1.setSpeed(1);
        vehicle_entire1.setTotal_miles(0);
        vehicle_entire1.setSoc(0);
        vehicle_entire1.setGear("0001110");
        vehicle_entire1.setTotal_volt(0);
        vehicle_entire1.setTotal_elect(0);
        vehicle_entire1.setAddTime("2017-04-01 09:42:15");


        Vehicle_entire vehicle_entire2 = new Vehicle_entire();
        vehicle_entire2.setCs_vin("LJ8E3C1M6GB009071");
        vehicle_entire2.setCs_number("T6401959");
        vehicle_entire2.setCs_car_status(1);
        vehicle_entire2.setBatt_status(3);
        vehicle_entire2.setCan_batt_status(0);
        vehicle_entire2.setSaving_status(0);
        vehicle_entire2.setSpeed(1);
        vehicle_entire2.setTotal_miles(0);
        vehicle_entire2.setSoc(0);
        vehicle_entire2.setGear("0001110");
        vehicle_entire2.setTotal_volt(0);
        vehicle_entire2.setTotal_elect(0);
        vehicle_entire2.setAddTime("2017-04-01 09:42:30");


        Vehicle_entire vehicle_entire3 = new Vehicle_entire();
        vehicle_entire3.setCs_vin("LJ8E3C1M6GB009071");
        vehicle_entire3.setCs_number("T6401959");
        vehicle_entire3.setCs_car_status(1);
        vehicle_entire3.setBatt_status(3);
        vehicle_entire3.setCan_batt_status(0);
        vehicle_entire3.setSaving_status(0);
        vehicle_entire3.setSpeed(1);
        vehicle_entire3.setTotal_miles(3);
        vehicle_entire3.setSoc(50);
        vehicle_entire3.setGear("0001110");
        vehicle_entire3.setTotal_volt(0);
        vehicle_entire3.setTotal_elect(0);
        vehicle_entire3.setAddTime("2017-04-01 09:42:45");


        Vehicle_entire vehicle_entire4 = new Vehicle_entire();
        vehicle_entire4.setCs_vin("LJ8E3C1M6GB009071");
        vehicle_entire4.setCs_number("T6401959");
        vehicle_entire4.setCs_car_status(1);
        vehicle_entire4.setBatt_status(3);
        vehicle_entire4.setCan_batt_status(0);
        vehicle_entire4.setSaving_status(0);
        vehicle_entire4.setSpeed(1);
        vehicle_entire4.setTotal_miles(3);
        vehicle_entire4.setSoc(50);
        vehicle_entire4.setGear("0001110");
        vehicle_entire4.setTotal_volt(0);
        vehicle_entire4.setTotal_elect(0);
        vehicle_entire4.setAddTime("2017-04-01 09:43:00");


        Vehicle_entire vehicle_entire5 = new Vehicle_entire();
        vehicle_entire5.setCs_vin("LJ8E3C1M6GB009071");
        vehicle_entire5.setCs_number("T6401959");
        vehicle_entire5.setCs_car_status(1);
        vehicle_entire5.setBatt_status(3);
        vehicle_entire5.setCan_batt_status(0);
        vehicle_entire5.setSaving_status(0);
        vehicle_entire5.setSpeed(1);
        vehicle_entire5.setTotal_miles(3);
        vehicle_entire5.setSoc(50);
        vehicle_entire5.setGear("0001110");
        vehicle_entire5.setTotal_volt(0);
        vehicle_entire5.setTotal_elect(0);
        vehicle_entire5.setAddTime("2017-04-05 10:30:30");

        Vehicle_entire vehicle_entire6 = new Vehicle_entire();
        vehicle_entire6.setCs_vin("LJ8E3C1M6GB009071");
        vehicle_entire6.setCs_number("T6401959");
        vehicle_entire6.setCs_car_status(1);
        vehicle_entire6.setBatt_status(3);
        vehicle_entire6.setCan_batt_status(0);
        vehicle_entire6.setSaving_status(0);
        vehicle_entire6.setSpeed(1);
        vehicle_entire6.setTotal_miles(3);
        vehicle_entire6.setSoc(50);
        vehicle_entire6.setGear("0001110");
        vehicle_entire6.setTotal_volt(0);
        vehicle_entire6.setTotal_elect(0);
        vehicle_entire6.setAddTime("2017-04-05 10:30:45");



        Vehicle_entire vehicle_entire_final = new Vehicle_entire();
        vehicle_entire_final.setCs_vin("LJ8E3C1M6GB009071");
        vehicle_entire_final.setCs_number("T6401959");
        vehicle_entire_final.setTerminate_flg(1);

        vehicleEntireList.add(vehicle_entire1);
        vehicleEntireList.add(vehicle_entire2);
        vehicleEntireList.add(vehicle_entire3);
        vehicleEntireList.add(vehicle_entire4);
        vehicleEntireList.add(vehicle_entire5);
        vehicleEntireList.add(vehicle_entire6);
        vehicleEntireList.add(vehicle_entire_final);


    }


    @Test
    public void testDrivePaceCreate(){
        DrivePaceFactory pf = new DrivePaceFactory();

        for(Vehicle_entire vehicle_entire:vehicleEntireList){
            pf.addVehicleEntire(vehicle_entire);
        }
        List<Pace> paceList = pf.getPaceList();
        System.out.println("晕死");
    }

}
