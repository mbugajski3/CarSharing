import java.util.ArrayList;

public class RentHistory {

    private ArrayList<Rental> rents;

    public RentHistory() {
        this.rents = new ArrayList<>();
    }

    public ArrayList<Rental> getRents() {
        return this.rents;
    }
}
