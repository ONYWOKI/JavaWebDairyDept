
public class Products {
    private String name;
    private String milk_used;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMilk_used() {
        return milk_used;
    }

    public void setMilk_used(String milk_used) {
        this.milk_used = milk_used;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Products(String name, String milk_used, String quantity) {
        this.name = name;
        this.milk_used = milk_used;
        this.quantity = quantity;
    }
    private String quantity;
    
}
