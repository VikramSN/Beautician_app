
package com.v3cube.beautician.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataLogin {

    @SerializedName("message")
    @Expose
    private List<LoginPojo> message = null;
    @SerializedName("date_serve")
    @Expose
    private String dateServe;
    @SerializedName("status")
    @Expose
    private Integer status;

    public List<LoginPojo> getMessage() {
        return message;
    }

    public void setMessage(List<LoginPojo> message) {
        this.message = message;
    }

    public String getDateServe() {
        return dateServe;
    }

    public void setDateServe(String dateServe) {
        this.dateServe = dateServe;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
