package com.yk.iworkgo.common;

import lombok.Data;

@Data
public class RespVo<T> {

    private int code = 200;
    private String message = "";
    private T data;

    public RespVo() {
    }

    public RespVo(T data) {
        this.data = data;
    }
}
