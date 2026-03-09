package com.hei.k2;

public class Sale {
    private int id;
    private int partId;
    private int quantity;
    
    public Sale() {}
    
    public Sale(int id, int partId, int quantity) {
        this.id = id;
        this.partId = partId;
        this.quantity = quantity;
    }
    
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public int getPartId() { return partId; }
    public void setPartId(int partId) { this.partId = partId; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    @Override
    public String toString() {
        return "Sale{id=" + id + ", partId=" + partId + ", quantity=" + quantity + "}";
    }
}