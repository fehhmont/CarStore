package br.com.carstore.model;

public class Car {
    private int ID_CAR;
    private String name;

    // Construtor completo (inclui ID)
    public Car(int ID_CAR, String name) {
        this.ID_CAR = ID_CAR;
        this.name = name;
    }

    // Construtor apenas com nome (para inserção no banco)
    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getID_CAR() {
        return ID_CAR;
    }

    public void setID_CAR(int ID_CAR) {
        this.ID_CAR = ID_CAR;
    }
}
