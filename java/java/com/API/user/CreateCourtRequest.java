package com.API.user;

import lombok.Value;

@Value
public class CreateCourtRequest {
    String court_id;
    String centre_id;
    String city_id;
}
