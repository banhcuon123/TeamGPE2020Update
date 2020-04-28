package domain.user;

import com.API.user.*;
import com.API.user.request.HolidayRequest;
import com.API.user.request.OpenCloseCenterRequest;

import java.util.List;

public interface UserRepository {

    String createBooking(CreateBookingRequest booking);
    String createPlayer(CreatePlayerRequest player);
    String createCity(CreateCityRequest city);
    String createCityCenter(CreateCenterRequest center);
    String createCityCenterCourt(CreateCourtRequest court);
    String createStaff(CreateStaffRequest staff);
    String cancelBooking(CancelBookingRequest cancelBooking);
    List<ListBookingRequest> listBooking(ListBooking listBooking);
    String minimumSlotCenter(MinimumSlotCenter msC);
    OpenCloseCenterRequest openCloseCenter(OpenCloseCenter ocC);
    HolidayRequest holidayRequest(CityHoliday cityHoliday);

}

