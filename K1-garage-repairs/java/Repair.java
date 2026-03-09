import java.math.BigDecimal;

public class Repair {
    private int id;
    private int mechanicId;
    private int carModelId;
    private BigDecimal cost;
    
    public Repair() {}
    
    public Repair(int id, int mechanicId, int carModelId, BigDecimal cost) {
        this.id = id;
        this.mechanicId = mechanicId;
        this.carModelId = carModelId;
        this.cost = cost;
    }
    
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public int getMechanicId() { return mechanicId; }
    public void setMechanicId(int mechanicId) { this.mechanicId = mechanicId; }
    
    public int getCarModelId() { return carModelId; }
    public void setCarModelId(int carModelId) { this.carModelId = carModelId; }
    
    public BigDecimal getCost() { return cost; }
    public void setCost(BigDecimal cost) { this.cost = cost; }
    
    @Override
    public String toString() {
        return "Repair{id=" + id + ", mechanicId=" + mechanicId + 
               ", carModelId=" + carModelId + ", cost=" + cost + "}";
    }
}