package com.k22Api.model;

import lombok.Data;
import lombok.Getter;

@Data
public class MyResponse {
    public int status;
    public String message;
    public Object data;
}
