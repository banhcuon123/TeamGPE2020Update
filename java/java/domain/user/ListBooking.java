package domain.user;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ListBooking {
    String city_id;
    String center_id;
    String court_id;
    String date;
}
