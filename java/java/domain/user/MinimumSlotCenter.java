package domain.user;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class MinimumSlotCenter {
    String cityId;
    String centerId;
}
