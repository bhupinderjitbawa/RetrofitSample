package com.bxs.retrofitsample.models;

import java.io.Serializable;

/**
 * Created by bhupinder on 2/6/15.
 */
public class EmployeeWebserviceModel implements Serializable {

    private Status Status;
    private Employee Data;

    public com.bxs.retrofitsample.models.Status getStatus() {
        return Status;
    }

    public void setStatus(com.bxs.retrofitsample.models.Status status) {
        Status = status;
    }

    public Employee getData() {
        return Data;
    }

    public void setData(Employee data) {
        Data = data;
    }
}
