package com.hei.k3;

import java.time.LocalDate;

public class SaleK3 {
    private int id;
    private int partId;
    private int quantity;
    private LocalDate date;
    
    public SaleK3() {}
    
    public SaleK3(int id, int partId, int quantity, LocalDate date) {
        this.id = id;
        this.partId = partId;
        this.quantity = quantity;
        this.date = date;
    }
    
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public int getPartId() { return partId; }
    public void setPartId(int partId) { this.partId = partId; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    
    @Override
    public String toString() {
        return "SaleK3{id=" + id + ", partId=" + partId + 
               ", quantity=" + quantity + ", date=" + date + "}";
    }
}