package com.bxs.retrofitsample.models;

import java.io.Serializable;

/**
 * Created by bhupinder on 2/6/15.
 */
public class Status implements Serializable {

    private String code;
    private String reason;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
