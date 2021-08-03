package com.example.retrofitand3.data.model;

import com.google.gson.annotations.SerializedName;

public class ActivityesModel {
    @SerializedName("activity")
    private String activityes;
    @SerializedName("price")
    private double price ;
    @SerializedName("type")
    private String type;

    public String getActivityes() {
        return activityes;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ActivityesModel{" +
                "Activityes='" + activityes + '\'' +
                ", Price=" + price +
                ", Type='" + type + '\'' +
                '}';
    }
}
