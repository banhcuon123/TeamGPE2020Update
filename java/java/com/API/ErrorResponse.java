package com.API;


//@Value
//@Builder
public class ErrorResponse {

    int code;
    String message;
    public ErrorResponse(int code, String message){
        this.code = code;
        this.message = message;
    }
    public int getCode(){
        return this.code;
    }
    public String getMessage(){
        return this.message;
    }
    public static class ErrorResponseBuilder{
         int code;
         String message;


        public ErrorResponseBuilder setCode(int code){
            this.code = code;
            return this;
        }
        public ErrorResponseBuilder setMessage(String message){
            this.message = message;
            return this;
        }
        public ErrorResponse build(){
            return new ErrorResponse(code, message);
        }

    }
}
