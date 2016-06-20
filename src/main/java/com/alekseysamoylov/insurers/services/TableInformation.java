package com.alekseysamoylov.insurers.services;

import java.util.Date;

/**
 * Created by alekseysamoylov on 6/19/16.
 * For create JSON.
 * It is entry of List.
 * You can use to show tables or graphs.
 */
public class TableInformation {
    private Date date;
    private Double value;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public TableInformation() {
    }

    public TableInformation(Date date, Double value) {
        this.date = date;
        this.value = value;
    }


}
