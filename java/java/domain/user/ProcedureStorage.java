//package domain.user;

//import com.API.user.ListBookingRequest;
package domain.user;
import com.API.user.ListBookingRequest;
import com.API.user.request.HolidayRequest;
import com.API.user.request.OpenCloseCenterRequest;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.sql.*;
import java.util.ArrayList;

import java.util.List;
import java.util.TreeMap;

public class ProcedureStorage {
    //private final static int ONE_MILIS = 1000;
    //private final static long ONE_HOUR_IN_MILIS = 60 * 60 * ONE_MILIS;

    public static String createPlayer(String playerId){
        Connection conn = MySQLconnection.getConnection();
        try{
            CallableStatement cstmt = null;
            cstmt = conn.prepareCall("CALL createPlayer( ?, ?)");
            cstmt.setString(1, playerId);
            cstmt.registerOutParameter(2, Types.CHAR);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()){
                return rs.getString("return_message");
            }
        }
        catch (Exception ex){
        }
        return null;
    }

    public static String createCity(String cityId){
        Connection conn = MySQLconnection.getConnection();
        try{
            CallableStatement cstmt = null;
            cstmt = conn.prepareCall("CALL createCity(?, ?)");
            cstmt.setString(1, cityId);
            cstmt.registerOutParameter(2, Types.CHAR);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()){
                return rs.getString("return_message");
            }
        }
        catch (Exception ex){

        }
        return null;
    }

    public static String createCityCenter(String centerId,String cityId){
        Connection conn = MySQLconnection.getConnection();
        try {
            CallableStatement cstmt = null;
            cstmt = conn.prepareCall("CALL createCityCenter(?, ?, ?)");
            cstmt.setString(1, centerId);
            cstmt.setString(2, cityId);
            cstmt.registerOutParameter(3, Types.CHAR);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                return rs.getString("return_message");
            }
        }
        catch (Exception ex){

        }
        return null;
    }

    public static String createStaff(String staffId, String cityId, String centerId){
        Connection conn = MySQLconnection.getConnection();
        try {
            CallableStatement cstmt = null;
            cstmt = conn.prepareCall("CALL createStaff(?, ?, ?, ?)");
            cstmt.setString(1, staffId);
            cstmt.setString(2, cityId);
            cstmt.setString(3, centerId);
            cstmt.registerOutParameter(4, Types.CHAR);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                return rs.getString("return_message");
            }
        }
        catch (Exception ex){

        }
        return null;
    }

    public static String createCityCenterCourt(String courtId, String cityId, String centerId){
        Connection conn = MySQLconnection.getConnection();
        try {
            CallableStatement cstmt = null;
            cstmt = conn.prepareCall("CALL createCityCenterCourt(?, ?, ?, ?)");
            cstmt.setString(1, courtId);
            cstmt.setString(2, cityId);
            cstmt.setString(3, centerId);
            cstmt.registerOutParameter(4, Types.CHAR);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                return rs.getString("return_message");
            }
        }
        catch (Exception ex){

        }
        return null;
    }

    public static String createBooking(String bookingId, String booking_date, String valid_from
            , String valid_to, String court, String city, String center, String customer){
        Connection conn = MySQLconnection.getConnection();
        try {
            CallableStatement cstmt = null;
            cstmt = conn.prepareCall("CALL createBooking(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            cstmt.setString(1, bookingId);
            cstmt.setString(2, booking_date);
            cstmt.setString(3, valid_from);
            cstmt.setString(4, valid_to);
            cstmt.setString(5, court);
            cstmt.setString(6, city);
            cstmt.setString(7, center);
            cstmt.setString(8, customer);
            cstmt.registerOutParameter(9, Types.CHAR);
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()){
                return rs.getString("return_message");
            }
        }
        catch (Exception ex){

        }
        return null;
    }

    public static String cancelBooking(String bookingId, String playerId){
        Connection conn = MySQLconnection.getConnection();
        try {
            CallableStatement cstmt = null;
            cstmt = conn.prepareCall("CALL cacelBooking(?, ?, ?)");
            cstmt.setString(1, bookingId);
            cstmt.setString(2, playerId);
            cstmt.registerOutParameter(3, Types.CHAR);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                return rs.getString("return_message");
            }
        }
        catch (Exception ex){
        }
        return null;
    }

    public static String updateBookingStatus(String status, String bookingId, String cityId, String centerId, String staffId){
        Connection conn = MySQLconnection.getConnection();
        try {
            CallableStatement cstmt = null;
            cstmt = conn.prepareCall("CALL createCityCenterCourt(?, ?, ?, ?, ?)");
            cstmt.setString(1, bookingId);
            cstmt.setString(2, cityId);
            cstmt.setString(3, centerId);
            cstmt.setString(4, staffId);
            cstmt.registerOutParameter(5, Types.CHAR);
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()){
                return rs.getString("return_message");
            }
        }
        catch (Exception ex){
        }
        return null;
    }




    public static TreeMap<Time,Time> getOccupiedTimeSlots(Date date, String courtID) {
        Connection conn = MySQLconnection.getConnection();
        ResultSet rs = null;
        TreeMap<Time,Time> resultMap = new TreeMap<Time, Time>();
        try {
            PreparedStatement pstmt = null;
            pstmt = conn.prepareCall("select * from booking");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                if (rs.getDate("valid_from").equals(date) && rs.getString("court").equals(courtID)) {
                    long milisS = rs.getTime("valid_from").getTime(); //- ONE_HOUR_IN_MILIS;
                    long milisE = rs.getTime("valid_to").getTime(); //- ONE_HOUR_IN_MILIS;
                    Time timeS = new Time(milisS);
                    Time timeE = new Time(milisE);
                    resultMap.put(timeS, timeE);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    public static List<ListBookingRequest> listBooking(String city_id, String center_id, String court_id, String date){
        Connection conn = MySQLconnection.getConnection();
        List<ListBookingRequest> lbR = new ArrayList<>();
        ListBookingRequest list;
        try{
            CallableStatement cstmt = null;
            cstmt = conn.prepareCall("CALL listBooking(?, ?, ?, ?, ?)");
            cstmt.setString(1, city_id);
            cstmt.setString(2, center_id);
            cstmt.setString(3, court_id);
            cstmt.setString(4, date);
            cstmt.registerOutParameter(5, Types.CHAR);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()){
                list = new ListBookingRequest(rs.getString(1), rs.getString(2)
                        , rs.getString(3), rs.getString(4), rs.getString(5));
                lbR.add(list);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return lbR;
    }
    public static HolidayRequest cityHolidays(String city_id){
        Connection conn = MySQLconnection.getConnection();
        List<ListBookingRequest> lbR = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        //HolidayRequest holidayRequest;
        HolidayRequest holidayRequest = new HolidayRequest("","","");
        try{

            CallableStatement cstmt = null;
            cstmt = conn.prepareCall("CALL cityHoliday(?, ?)");
            cstmt.setString(1, city_id);
            cstmt.registerOutParameter(2, Types.CHAR);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()){
                holidayRequest = objectMapper.readValue(rs.getString(1), HolidayRequest.class);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return holidayRequest;
    }

    public static OpenCloseCenterRequest centerOpenClose(String city_id, String center_id){
        Connection conn = MySQLconnection.getConnection();
        OpenCloseCenterRequest occR = new OpenCloseCenterRequest("","","","","","","");
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            CallableStatement cstmt = null;
            cstmt = conn.prepareCall("CALL centerSpecialHour(?, ?, ?)");
            cstmt.setString(1, city_id);
            cstmt.setString(2, center_id);
            cstmt.registerOutParameter(3, Types.CHAR);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()){
                occR = objectMapper.readValue(rs.getString(1),OpenCloseCenterRequest.class);
            }
            return occR;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static String centerMinimumSlot(String city_id, String center_id){
        Connection conn = MySQLconnection.getConnection();
        String result = "";
        try{
            CallableStatement cstmt = null;
            cstmt = conn.prepareCall("CALL listBooking(?, ?, ?)");
            cstmt.setString(1, city_id);
            cstmt.setString(2, center_id);
            cstmt.registerOutParameter(3, Types.CHAR);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()){
                result = rs.getString(1);
            }
            return result;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
