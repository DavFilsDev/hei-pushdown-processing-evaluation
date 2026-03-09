package com.hei.k2;

public class CarModelK2 {
    private int id;
    private String brand;  // KIA, HYUNDAI, DAEWOO
    private String model;  // GETZ, PRIDE, LACETTI
    
    public CarModelK2() {}
    
    public CarModelK2(int id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
    }
    
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    
    @Override
    public String toString() {
        return "CarModelK2{id=" + id + ", brand='" + brand + "', model='" + model + "'}";
    }
}