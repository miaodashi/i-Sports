package com.example.isports.entity;

public class LoginResponse {
    private String msg;
    private int code;
    private int expire;
    private String token;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public int getExpire() {
        return expire;
    }

    public String getToken() {
        return token;
    }

    public LoginResponse(String msg, int code, int expire, String token) {
        this.msg = msg;
        this.code = code;
        this.expire = expire;
        this.token = token;
    }
}
