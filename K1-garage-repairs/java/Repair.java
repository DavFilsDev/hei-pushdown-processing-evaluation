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
    
}