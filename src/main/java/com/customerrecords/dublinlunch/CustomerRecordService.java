package com.customerrecords.dublinlunch;

import com.customerrecords.dublinlunch.beans.CustomerRecord;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.customerrecords.dublinlunch.ServiceConstants.CUSTOMER_RECORD_RAW_URL;

public class CustomerRecordService {

    CustomerRecordService() throws IOException {
        retrieveCustomerRecords();
    }

    private List<CustomerRecord> customerRecords;

    private void retrieveCustomerRecords() throws IOException {
        URL customerRecordFile = new URL(CUSTOMER_RECORD_RAW_URL);
        BufferedReader recordLine = new BufferedReader(new InputStreamReader(customerRecordFile.openStream()));

        customerRecords = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        String inputLine;

        while ((inputLine = recordLine.readLine()) != null) {
            CustomerRecord customerRecord = objectMapper.readValue(inputLine, CustomerRecord.class);
            customerRecords.add(customerRecord);
        }

        recordLine.close();
    }

    public List<CustomerRecord> getCustomerRecords() {
        return customerRecords;
    }

    private void setCustomerRecords(List<CustomerRecord> customerRecords) {
        this.customerRecords = customerRecords;
    }
}
