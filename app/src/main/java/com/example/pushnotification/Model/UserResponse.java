package com.example.pushnotification.Model;

import com.google.gson.annotations.SerializedName;

public class UserResponse {

    @SerializedName("Result")
    private String result ;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
