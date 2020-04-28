package com.API.user;

import lombok.Value;

@Value
public class CancelBookingRequest {
    String booking_id;
    String player_id;
}
