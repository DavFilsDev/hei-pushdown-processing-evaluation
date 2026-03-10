import java.math.BigDecimal;

public class RepairStatistics {
    // For query 1a
    private String brand;
    private String model;
    private int repairCount;
    
    // For query 1b
    private double rangerPercentage;
    private double everestPercentage;
    private double yukonPercentage;
    private double ramPercentage;
    
    // For query 1c
    private String mechanicName;
    private BigDecimal totalCost;
    
    // For query 1d
    private String lowestRevenueMechanic;
    private BigDecimal lowestRevenue;
    
    // Constructors
    public RepairStatistics() {}
    
    // Getters and Setters for 1a
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    
    public int getRepairCount() { return repairCount; }
    public void setRepairCount(int repairCount) { this.repairCount = repairCount; }
    
    // Getters and Setters for 1b
    public double getRangerPercentage() { return rangerPercentage; }
    public void setRangerPercentage(double rangerPercentage) { this.rangerPercentage = rangerPercentage; }
    
    public double getEverestPercentage() { return everestPercentage; }
    public void setEverestPercentage(double everestPercentage) { this.everestPercentage = everestPercentage; }
    
    public double getYukonPercentage() { return yukonPercentage; }
    public void setYukonPercentage(double yukonPercentage) { this.yukonPercentage = yukonPercentage; }
    
    public double getRamPercentage() { return ramPercentage; }
    public void setRamPercentage(double ramPercentage) { this.ramPercentage = ramPercentage; }
    
    // Getters and Setters for 1d
    public String getLowestRevenueMechanic() { return lowestRevenueMechanic; }
    public void setLowestRevenueMechanic(String lowestRevenueMechanic) { this.lowestRevenueMechanic = lowestRevenueMechanic; }
    
    public BigDecimal getLowestRevenue() { return lowestRevenue; }
    public void setLowestRevenue(BigDecimal lowestRevenue) { this.lowestRevenue = lowestRevenue; }
}