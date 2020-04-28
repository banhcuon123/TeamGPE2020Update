package com.API.user;

import com.API.Constants;
import com.API.Handler;
import com.API.ResponseEntity;
import com.API.StatusCode;
import com.error.ApplicationExceptions;
import com.error.GlobalExceptionHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import domain.user.ListBooking;
import domain.user.UserService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class OtherHandler extends Handler {

    private final UserService userService;

    public OtherHandler(UserService userService, ObjectMapper objectMapper,
                        GlobalExceptionHandler exceptionHandler){
        super(objectMapper, exceptionHandler);
        this.userService = userService;
    }

    @Override
    protected void execute(HttpExchange exchange) throws IOException {
        byte[] response;
        if ("POST".equals(exchange.getRequestMethod())) {
            List<ResponseEntity<ListBookingRequest>> listR = new ArrayList<>();
            listR = doPostListBooking(exchange.getRequestBody());
            for (ResponseEntity<ListBookingRequest> rlR: listR){
                exchange.getResponseHeaders().putAll(rlR.getHeaders());
                exchange.sendResponseHeaders(rlR.getStatusCode().getCode(), 0);
                response = super.writeResponse(rlR.getBody());
                OutputStream os = exchange.getResponseBody();
                os.write(response);
                os.close();
            }


        } else {
            throw ApplicationExceptions.methodNotAllowed(
                    "Method " + exchange.getRequestMethod() + " is not allowed for " + exchange.getRequestURI()).get();
        }




    }

    private ResponseEntity<RegistrationResponse> doPostCancelBooking(InputStream is){
        CancelBookingRequest cancelBookingRequest = super.readRequest(is, CancelBookingRequest.class);



        String result = userService.cancelBooking(cancelBookingRequest);
        RegistrationResponse response = new RegistrationResponse(result);

        return new ResponseEntity<>(response,
                getHeaders(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON), StatusCode.OK);
    }

    private List<ResponseEntity<ListBookingRequest>> doPostListBooking(InputStream is){
        List<ResponseEntity<ListBookingRequest>> listR = new ArrayList<ResponseEntity<ListBookingRequest>>();
        ListBooking listBooking = super.readRequest(is, ListBooking.class);

        List<ListBookingRequest> list = userService.listBooking(listBooking);
        for (ListBookingRequest lbR: list){
            ListBookingRequest response = lbR;
            listR.add(new ResponseEntity<>(response,
                    getHeaders(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON), StatusCode.OK));
        }

        return listR;
    }


}
