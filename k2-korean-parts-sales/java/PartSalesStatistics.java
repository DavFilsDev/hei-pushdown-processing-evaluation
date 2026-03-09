import java.math.BigDecimal;

public class PartSalesStatistics {
    // For query 2a
    private String brand;
    private int partCount;
    
    // For query 2b
    private int getzCount;
    private int prideCount;
    private int lacettiCount;
    
    // For query 2c
    private BigDecimal kiaTotalPrice;
    
    // Constructors
    public PartSalesStatistics() {}
    
    // Getters and Setters for 2a
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    
    public int getPartCount() { return partCount; }
    public void setPartCount(int partCount) { this.partCount = partCount; }
    
    // Getters and Setters for 2b
    public int getGetzCount() { return getzCount; }
    public void setGetzCount(int getzCount) { this.getzCount = getzCount; }
    
    public int getPrideCount() { return prideCount; }
    public void setPrideCount(int prideCount) { this.prideCount = prideCount; }
    
    public int getLacettiCount() { return lacettiCount; }
    public void setLacettiCount(int lacettiCount) { this.lacettiCount = lacettiCount; }
    
    // Getters and Setters for 2c
    public BigDecimal getKiaTotalPrice() { return kiaTotalPrice; }
    public void setKiaTotalPrice(BigDecimal kiaTotalPrice) { this.kiaTotalPrice = kiaTotalPrice; }
}