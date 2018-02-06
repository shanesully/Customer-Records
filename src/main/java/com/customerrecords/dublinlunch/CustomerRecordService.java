package com.customerrecords.dublinlunch;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CustomerRecordService {

    @Value("${raw-customer-records-url}")
    private String RAW_CUSTOMER_RECORDS_URL;

    CustomerRecordService() throws IOException {
        retrieveCustomerRecords();
    }

    private List<CustomerRecord> parsedCustomerRecords;

    private void retrieveCustomerRecords() {
        URL rawCustomerRecords = null;

        try {
            rawCustomerRecords = new URL(RAW_CUSTOMER_RECORDS_URL);
        } catch (MalformedURLException e) {
            System.out.println("Unable to parse raw URL");
        }

        try {
            BufferedReader recordLine = new BufferedReader(new InputStreamReader(rawCustomerRecords.openStream()));

            parsedCustomerRecords = new ArrayList<>();
            ObjectMapper objectMapper = new ObjectMapper();

            String inputLine;

            while ((inputLine = recordLine.readLine()) != null) {
                CustomerRecord customerRecord = objectMapper.readValue(inputLine, CustomerRecord.class);
                parsedCustomerRecords.add(customerRecord);
            }

            recordLine.close();
        } catch (IOException e) {
            System.out.println("Unable to parse customer records from source");
        }
    }

    public List<CustomerRecord> getParsedCustomerRecords() {
        return parsedCustomerRecords;
    }

    private void setParsedCustomerRecords(List<CustomerRecord> parsedCustomerRecords) {
        this.parsedCustomerRecords = parsedCustomerRecords;
    }
}
