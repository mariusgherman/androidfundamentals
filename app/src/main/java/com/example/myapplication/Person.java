package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class Person {

    @SerializedName("name")
    private String name;
    @SerializedName("surname")
    private String surname;
    @SerializedName("address")
    private String homeAddress;

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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                '}';
    }


}
