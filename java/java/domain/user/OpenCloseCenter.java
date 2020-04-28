package domain.user;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class OpenCloseCenter {
    String cityId;
    String centerId;
}
