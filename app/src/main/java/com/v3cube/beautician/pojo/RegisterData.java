package com.v3cube.beautician.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterData {

@SerializedName("message")
@Expose
private RegisterData message;
@SerializedName("date_serve")
@Expose
private String dateServe;
@SerializedName("status")
@Expose
private Integer status;

public RegisterData getMessage() {
return message;
}

public void setMessage(RegisterData message) {
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