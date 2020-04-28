package com.API.user.handler;


import com.API.Constants;
import com.API.Handler;
import com.API.ResponseEntity;
import com.API.StatusCode;
import com.API.user.*;
import com.API.user.request.MinimumSlotCenterRequest;
import com.error.ApplicationExceptions;
import com.error.GlobalExceptionHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import domain.user.MinimumSlotCenter;
import domain.user.UserService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MinimumSlotHandler extends Handler {

    private final UserService userService;

    public MinimumSlotHandler(UserService userService, ObjectMapper objectMapper,
                          GlobalExceptionHandler exceptionHandler) {
        super(objectMapper, exceptionHandler);
        this.userService = userService;
    }

    @Override
    protected void execute(HttpExchange exchange) throws IOException {
        byte[] response;
        if ("POST".equals(exchange.getRequestMethod())) {
            ResponseEntity e = doPostMinimumSlot(exchange.getRequestBody());
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

    private ResponseEntity<MinimumSlotCenterRequest> doPostMinimumSlot(InputStream is) {
        MinimumSlotCenter minimumRequest = super.readRequest(is, MinimumSlotCenter.class);


        String result = userService.minimumSlotCenter(minimumRequest);

        //RegistrationResponse response = new RegistrationResponse(result);
        MinimumSlotCenterRequest response = new MinimumSlotCenterRequest(result);
        return new ResponseEntity<>(response,
                getHeaders(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON), StatusCode.OK);
    }




}
