package com.example.SpringServletTemaV21.entities;

public class Sales {
    int id;

    int id_client;
    int id_produs;
    int quantity;

    public Sales() {
    }

    public Sales(int id, int id_client, int id_produs, int quantity) {
        this.id = id;
        this.id_client = id_client;
        this.id_produs = id_produs;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_produs() {
        return id_produs;
    }

    public void setId_produs(int id_produs) {
        this.id_produs = id_produs;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", id_client=" + id_client +
                ", id_produs=" + id_produs +
                ", quantity=" + quantity +
                '}';
    }
}
