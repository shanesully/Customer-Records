package com.customerrecords.dublinlunch;

import com.customerrecords.dublinlunch.beans.CustomerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.customerrecords.dublinlunch.ServiceConstants.MAXIMUM_DISTANCE_IN_KM;
import static com.customerrecords.dublinlunch.ServiceConstants.SOURCE_LATITUDE;
import static com.customerrecords.dublinlunch.ServiceConstants.SOURCE_LONGITUDE;

@SpringBootApplication
public class Application {

    @Autowired
    DistanceCalculator distanceCalculator;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);

        List<CustomerRecord> freeLunchList = new ArrayList<>();

        CustomerRecordService customerRecordService = new CustomerRecordService();

        for(CustomerRecord customerRecord : customerRecordService.getCustomerRecords()) {
            if(DistanceCalculator.distanceInKm(SOURCE_LATITUDE, SOURCE_LONGITUDE, customerRecord.getLatitude(), customerRecord.getLongitude()) < MAXIMUM_DISTANCE_IN_KM) {
                freeLunchList.add(customerRecord);
            }
        }

        Collections.sort(freeLunchList);
	}
}
