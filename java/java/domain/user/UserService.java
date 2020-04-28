package domain.user;

import com.API.user.*;
import com.API.user.request.HolidayRequest;
import com.API.user.request.OpenCloseCenterRequest;
import domain.user.ProcedureStorage;

import java.util.List;

public class UserService implements UserRepository{

    public static UserService getUserService(){
        return new UserService();
    }

    public String createBooking(CreateBookingRequest booking) {
        String rm = ProcedureStorage.createBooking(
                booking.getBooking_id(), booking.getBooking_date(), booking.getValid_from()
                , booking.getValid_to(), booking.getCourt(), booking.getCity_id()
                , booking.getCentre_id(), booking.getCustomer());
        return rm;
    }

    public String createPlayer(CreatePlayerRequest player){
        String rm = ProcedureStorage.createPlayer(
                player.getCustomer_id());
        return rm;
    }

    @Override
    public String createCity(CreateCityRequest city) {
        String rm = ProcedureStorage.createCity(
                city.getCity_id());
        return rm;
    }

    @Override
    public String createCityCenter(CreateCenterRequest center) {
        String rm = ProcedureStorage.createCityCenter(
                center.getCentre_id()
                , center.getCity_id());
        return rm;
    }

    @Override
    public String createCityCenterCourt(CreateCourtRequest court) {
        String rm = ProcedureStorage.createCityCenterCourt(
                court.getCourt_id()
                , court.getCentre_id()
                , court.getCity_id());
        return rm;
    }

    @Override
    public String createStaff(CreateStaffRequest staff) {
        String rm = ProcedureStorage.createStaff(
                staff.getStaff_id()
                , staff.getCity_id()
                , staff.getCentre_id());
        return rm;
    }

    @Override
    public String cancelBooking(CancelBookingRequest cancelBooking){
        String rm = ProcedureStorage.cancelBooking(
                cancelBooking.getBooking_id()
                , cancelBooking.getPlayer_id());
        return rm;
    }

    @Override
    public List<ListBookingRequest> listBooking(ListBooking listBooking){
        List<ListBookingRequest> rl = ProcedureStorage.listBooking(
                listBooking.getCity_id()
                , listBooking.getCenter_id()
                , listBooking.getCourt_id()
                , listBooking.getDate());
        return rl;

    }
    @Override
    public String minimumSlotCenter(MinimumSlotCenter msC){
        String minimumSlot = ProcedureStorage.centerMinimumSlot(msC.getCityId(), msC.getCenterId());
        return minimumSlot;
    }
    @Override
    public OpenCloseCenterRequest openCloseCenter(OpenCloseCenter ocC){
        OpenCloseCenterRequest openCloseCenter = ProcedureStorage.centerOpenClose(ocC.getCityId(), ocC.getCenterId());
        return openCloseCenter;
    }

    @Override
    public HolidayRequest holidayRequest(CityHoliday cityHoliday){
        HolidayRequest holidayRequest = ProcedureStorage.cityHolidays(cityHoliday.getCityId());
        return holidayRequest;
    }



}




