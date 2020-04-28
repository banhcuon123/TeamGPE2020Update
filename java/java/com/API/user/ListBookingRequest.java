package com.API.user;


import lombok.Value;

@Value
public class ListBookingRequest {
    String city_id;
    String center_id;
    String court_id;
    String valid_from;
    String valid_to;
}
