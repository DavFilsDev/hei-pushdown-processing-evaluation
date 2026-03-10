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
    
    @Override
    public String toString() {
        return "Mechanic{id=" + id + ", name='" + name + "', brand='" + brand + "'}";
    }
}