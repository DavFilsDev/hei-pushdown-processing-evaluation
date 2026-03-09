package com.hei.k3;

import java.math.BigDecimal;

public class VehicleTrajet {
    // For query 3a
    private String brand;
    private String model;
    private int partsSold;
    
    // For query 3b
    private int kiaPartsCount;
    private int daewooPartsCount;
    
    // For query 3c
    private String saleBrand;
    private BigDecimal percentage;
    
    public VehicleTrajet() {}
    
    // Getters and Setters for 3a
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    
    public int getPartsSold() { return partsSold; }
    public void setPartsSold(int partsSold) { this.partsSold = partsSold; }
    
    // Getters and Setters for 3b
    public int getKiaPartsCount() { return kiaPartsCount; }
    public void setKiaPartsCount(int kiaPartsCount) { this.kiaPartsCount = kiaPartsCount; }
    
    public int getDaewooPartsCount() { return daewooPartsCount; }
    public void setDaewooPartsCount(int daewooPartsCount) { this.daewooPartsCount = daewooPartsCount; }
    
    // Getters and Setters for 3c
    public String getSaleBrand() { return saleBrand; }
    public void setSaleBrand(String saleBrand) { this.saleBrand = saleBrand; }
    
    public BigDecimal getPercentage() { return percentage; }
    public void setPercentage(BigDecimal percentage) { this.percentage = percentage; }
    
    @Override
    public String toString() {
        return "VehicleTrajet{brand='" + brand + "', model='" + model + 
               "', partsSold=" + partsSold + "}";
    }
}