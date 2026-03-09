public class AutoPartK3 {
    private int id;
    private int carModelId;
    private String serialNumber;
    
    public AutoPartK3() {}
    
    public AutoPartK3(int id, int carModelId, String serialNumber) {
        this.id = id;
        this.carModelId = carModelId;
        this.serialNumber = serialNumber;
    }
    
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public int getCarModelId() { return carModelId; }
    public void setCarModelId(int carModelId) { this.carModelId = carModelId; }
    
    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
    
    @Override
    public String toString() {
        return "AutoPartK3{id=" + id + ", carModelId=" + carModelId + 
               ", serialNumber='" + serialNumber + "'}";
    }
}