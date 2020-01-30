
import java.sql.Date;


public class Sales {
    private String quantity;
    private Date date;
    private String profit;

    public Sales(String quantity, Date date, String profit) {
        this.quantity = quantity;
        this.date = date;
        this.profit = profit;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }
    
    
}
