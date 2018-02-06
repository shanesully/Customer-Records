package com.customerrecords.dublinlunch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class Application {

    @Value("${source-latitude}")
    private static double SOURCE_LATITUDE;

    @Value("${source-longitude}")
    private static double SOURCE_LONGITUDE;

    @Value("${maximum-distance-in-kilometers}")
    private static double MAXIMUM_DISTANCE_IN_KILOMETERS;

    @Autowired
    private static DistanceCalculator distanceCalculator;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);

        List<CustomerRecord> freeLunchList = new ArrayList<>();

        CustomerRecordService customerRecordService = new CustomerRecordService();

        for(CustomerRecord customerRecord : customerRecordService.getParsedCustomerRecords()) {
            if(distanceCalculator.distanceInKm(SOURCE_LATITUDE, SOURCE_LONGITUDE, customerRecord.getLatitude(), customerRecord.getLongitude()) < MAXIMUM_DISTANCE_IN_KILOMETERS) {
                freeLunchList.add(customerRecord);
            }
        }

        Collections.sort(freeLunchList);
	}
}
