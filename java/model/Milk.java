
import java.sql.Date;


public class Milk {
    private String quantity;
    private String quality;
    private Date date;

    public Milk(String quantity, String quality, Date date) {
        super();
        this.quantity = quantity;
        this.quality = quality;
        this.date = date;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
