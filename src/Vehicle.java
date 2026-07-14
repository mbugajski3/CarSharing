public abstract class Vehicle {

    private int id;
    private String brand;
    private double pricePerDay;
    private boolean available;
    private int kilometersDriven;
    private boolean activeInSystem;

    public Vehicle(int id, String brand, double pricePerDay, int kilometersDriven) {
        if (id < 0) {
            this.id = 0;
        } else {
            this.id = id;
        }

        if (brand == null || brand.isBlank() ) {
            this.brand = "Unknown brand";
        } else {
            this.brand = brand;
        }

        if (pricePerDay < 0) {
            this.pricePerDay = 0;
        } else {
            this.pricePerDay = pricePerDay;
        }

        this.available = true;

        if (kilometersDriven < 0) {
            this.kilometersDriven = 0;
        } else {
            this.kilometersDriven = kilometersDriven;
        }

        this.activeInSystem = true;
    }

    public int getId() {
        return this.id;
    }

    public String getBrand() {
        return this.brand;
    }

    public double getPricePerDay() {
        return this.pricePerDay;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public double getKilometersDriven() {
        return this.kilometersDriven;
    }

    public boolean isActiveInSystem() {
        return this.activeInSystem;
    }

    public boolean addKilometers(int kilometers) {
        if (kilometers >= 0) {
            this.kilometersDriven += kilometers;
            return true;
        }
        return false;
    }

    public void activate() {
        this.activeInSystem = true;
    }

    public void deactivate() {
        this.activeInSystem = false;
    }

    public void makeAvailable() {
        this.available = true;
    }

    public void makeUnavailable() {
        this.available = false;
    }

    @Override
    public String toString() {
        return "id: " +
                this.id +
                ", brand: " +
                this.brand +
                ", vehicle type: " +
                this.getVehicleType() +
                ", price per day: " +
                this.pricePerDay +
                ", available: " +
                this.available +
                ", kilometers driven: " +
                this.kilometersDriven +
                ", active: " +
                this.activeInSystem;
    }

    public abstract String getVehicleType();

    public abstract double calculateTotalPrice(int days);
}
