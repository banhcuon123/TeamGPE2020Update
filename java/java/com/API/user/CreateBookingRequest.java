package com.API.user;


public class CreateBookingRequest {

    private String booking_id;
    private String booking_date;
    private String valid_from;
    private String valid_to;
    private String court;
    private String city_id;
    private String centre_id;
    private String customer;

    public String getBooking_id(){
        return this.booking_id;
    }
    public void setBooking_id(String booking_id){
        this.booking_id = booking_id;
    }

    public String getBooking_date(){ return this.booking_date; }
    public void setBooking_date(String booking_date){ this.booking_date = booking_date; }

    public String getValid_from(){ return this.valid_from; }
    public void setValid_from(String valid_from){ this.valid_from = valid_from; }

    public String getValid_to(){ return this.valid_to; }
    public void setValid_to(String valid_to){ this.valid_to = valid_to; }

    public String getCourt(){ return this.court; }
    public void setCourt(String court){ this.court = court; }

    public String getCity_id(){ return this.city_id; }
    public void setCity_id(String city_id){ this.city_id = city_id; }

    public String getCentre_id(){ return this.centre_id; }
    public void setCentre_id(String centre_id){ this.centre_id = centre_id; }

    public String getCustomer(){ return this.customer; }
    public void setCustomer(String customer){ this.customer = customer; }
}
