package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class Person {

    @SerializedName("name")
    String name;
    @SerializedName("surname")
    String surname;
    @SerializedName("address")
    String homeAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
}
