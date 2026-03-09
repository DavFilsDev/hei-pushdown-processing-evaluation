public class Mechanic {
    private int id;
    private String name;
    private String brand;
    
    public Mechanic() {}
    
    public Mechanic(int id, String name, String brand) {
        this.id = id;
        this.name = name;
        this.brand = brand;
    }
    
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    
    @Override
    public String toString() {
        return "Mechanic{id=" + id + ", name='" + name + "', brand='" + brand + "'}";
    }
}