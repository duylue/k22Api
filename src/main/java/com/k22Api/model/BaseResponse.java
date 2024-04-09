package com.k22Api.model;

import org.springframework.http.ResponseEntity;

public class BaseResponse {
    protected ResponseEntity<?> getResponseEntity(Object data){
        return ResponseEntity.ok().body(getMyResponse(data));
    }
    private MyResponse getMyResponse(Object data){
        MyResponse myResponse =  new MyResponse();
        myResponse.data = data;
        myResponse.message = "success";
        myResponse.status = 200;
        return myResponse;
    }
}
