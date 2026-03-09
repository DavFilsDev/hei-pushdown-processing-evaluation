import java.math.BigDecimal;

public class AutoPart {
    private int id;
    private int carModelId;
    private String serialNumber;
    private BigDecimal price;
    
    public AutoPart() {}
    
    public AutoPart(int id, int carModelId, String serialNumber, BigDecimal price) {
        this.id = id;
        this.carModelId = carModelId;
        this.serialNumber = serialNumber;
        this.price = price;
    }
    
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public int getCarModelId() { return carModelId; }
    public void setCarModelId(int carModelId) { this.carModelId = carModelId; }
    
    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
    
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    
    @Override
    public String toString() {
        return "AutoPart{id=" + id + ", carModelId=" + carModelId + 
               ", serialNumber='" + serialNumber + "', price=" + price + "}";
    }
}