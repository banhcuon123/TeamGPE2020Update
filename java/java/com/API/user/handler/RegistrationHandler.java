package com.API.user.handler;


import com.API.Constants;
import com.API.Handler;
import com.API.ResponseEntity;
import com.API.StatusCode;
import com.API.user.*;
import com.error.ApplicationExceptions;
import com.error.GlobalExceptionHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import domain.user.UserService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class RegistrationHandler extends Handler {

    private final UserService userService;

    public RegistrationHandler(UserService userService, ObjectMapper objectMapper,
                               GlobalExceptionHandler exceptionHandler) {
        super(objectMapper, exceptionHandler);
        this.userService = userService;
    }

    @Override
    protected void execute(HttpExchange exchange) throws IOException {
        byte[] response;
        if ("POST".equals(exchange.getRequestMethod())) {
            ResponseEntity e = doPostBooking(exchange.getRequestBody());
            exchange.getResponseHeaders().putAll(e.getHeaders());
            exchange.sendResponseHeaders(e.getStatusCode().getCode(), 0);
            response = super.writeResponse(e.getBody());
        } else {
            throw ApplicationExceptions.methodNotAllowed(
                    "Method " + exchange.getRequestMethod() + " is not allowed for " + exchange.getRequestURI()).get();
        }

        OutputStream os = exchange.getResponseBody();
        os.write(response);
        os.close();
    }

    private ResponseEntity<RegistrationResponse> doPostBooking(InputStream is) {
        CreateBookingRequest registerRequest = super.readRequest(is, CreateBookingRequest.class);


        String result = userService.createBooking(registerRequest);

        RegistrationResponse response = new RegistrationResponse(result);

        return new ResponseEntity<>(response,
                getHeaders(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON), StatusCode.OK);
    }


    private ResponseEntity<RegistrationResponse> doPostPlayer(InputStream is){
        CreatePlayerRequest createPlayerRequest = super.readRequest(is, CreatePlayerRequest.class);


        String result = userService.createPlayer(createPlayerRequest);

        RegistrationResponse response = new RegistrationResponse(result);
        return new ResponseEntity<>(response
        , getHeaders(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON), StatusCode.OK);
    }

    private ResponseEntity<RegistrationResponse> doPostCity(InputStream is){
        CreateCityRequest createCityRequest = super.readRequest(is, CreateCityRequest.class);

        String result = userService.createCity(createCityRequest);

        RegistrationResponse response = new RegistrationResponse(result);
        return new ResponseEntity<>(response
        , getHeaders(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON), StatusCode.OK);
    }

    private ResponseEntity<RegistrationResponse> doPostCenter(InputStream is){
        CreateCenterRequest createCenterRequest = super.readRequest(is, CreateCenterRequest.class);


        String result = userService.createCityCenter(createCenterRequest);

        RegistrationResponse response = new RegistrationResponse(result);
        return new ResponseEntity<>(response
        , getHeaders(Constants.CONTENT_TYPE,Constants.APPLICATION_JSON), StatusCode.OK);
    }

    private ResponseEntity<RegistrationResponse> doPostCourt(InputStream is){
        CreateCourtRequest createCourtRequest = super.readRequest(is, CreateCourtRequest.class);


        String result = userService.createCityCenterCourt(createCourtRequest);

        RegistrationResponse response = new RegistrationResponse(result);
        return new ResponseEntity<>(response
                , getHeaders(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON), StatusCode.OK);
    }

    private ResponseEntity<RegistrationResponse> doPostStaff(InputStream is){
        CreateStaffRequest createStaffRequest = super.readRequest(is, CreateStaffRequest.class);

        String result = userService.createStaff(createStaffRequest);

        RegistrationResponse response = new RegistrationResponse(result);
        return new ResponseEntity<>(response
                , getHeaders(Constants.CONTENT_TYPE,Constants.APPLICATION_JSON), StatusCode.OK);

    }


}
