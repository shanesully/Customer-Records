package com.customerrecords.dublinlunch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class FreeLunchService {

    @Value("${reference-latitude}")
    private double SOURCE_LATITUDE;

    @Value("${reference-longitude}")
    private double SOURCE_LONGITUDE;

    @Value("${maximum-distance-in-kilometers}")
    private double MAXIMUM_DISTANCE_IN_KILOMETERS;

    @Autowired
    private CustomerRecordService customerRecordService;

    @Autowired
    private DistanceCalculator distanceCalculator;

    public List returnListOfCustomers() {
        List<CustomerRecord> freeLunchList = new ArrayList<>();

        customerRecordService.retrieveCustomerRecords();

        for(CustomerRecord customerRecord : customerRecordService.getParsedCustomerRecords()) {
            if(distanceCalculator.distanceInKm(SOURCE_LATITUDE, SOURCE_LONGITUDE, customerRecord.getLatitude(), customerRecord.getLongitude()) < MAXIMUM_DISTANCE_IN_KILOMETERS) {
                freeLunchList.add(customerRecord);
            }
        }

        Collections.sort(freeLunchList);

        return freeLunchList;
    }
}
