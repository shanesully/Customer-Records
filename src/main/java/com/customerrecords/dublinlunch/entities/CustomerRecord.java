package com.customerrecords.dublinlunch.entities;

public class CustomerRecord implements Comparable<CustomerRecord> {
    private Double latitude;
    private Integer user_id;
    private String name;
    private Double longitude;

    @Override
    public int compareTo(CustomerRecord someOtherRecord) {
        return Integer.compare(this.getUser_id(), someOtherRecord.getUser_id());
    }

    public Double getLatitude() {
        return latitude;
    }

    public CustomerRecord setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public CustomerRecord setUser_id(Integer user_id) {
        this.user_id = user_id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CustomerRecord setName(String name) {
        this.name = name;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public CustomerRecord setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }
}
