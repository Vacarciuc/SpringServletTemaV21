package com.example.SpringServletTemaV21.entities;

public class Buyers{
    private int id;
    private String nameClient;
    private String address;

    public Buyers() {
    }

    public Buyers(int id, String nameClient, String address) {
        this.id = id;
        this.nameClient = nameClient;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Buyers{" +
                "id=" + id +
                ", nameClient='" + nameClient + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
