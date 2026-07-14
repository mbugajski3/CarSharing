public class Customer {

    private String name;
    private int id;
    private String email;
    private double debt;
    private boolean active;
    private int rentalsEnded;

    public Customer(String name, int id, String email, double debt, int rentalsEnded) {
        if (name == null || name.isBlank()) {
            this.name = "Unknown customer";
        } else {
            this.name = name;
        }

        if (id < 0) {
            this.id = 0;
        } else {
            this.id = id;
        }

        if (email == null || email.isBlank()) {
            this.email = "no-email";
        } else {
            this.email = email;
        }

        if (debt < 0) {
            this.debt = 0;
        } else {
            this.debt = debt;
        }

        this.active = true;

        if (rentalsEnded < 0) {
            this.rentalsEnded = 0;
        } else {
            this.rentalsEnded = rentalsEnded;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public double getDebt() {
        return this.debt;
    }

    public boolean isActive() {
        return this.active;
    }

    public int getRentalsEnded() {
        return this.rentalsEnded;
    }

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }

    public boolean customerCanRent() {
        return this.isActive() && this.debt <= 500;
    }

    public void addDebt(double debt) {
        if (debt > 0) {
            this.debt += debt;
        }
    }

    public void payDebt(double amount) {
        if (amount > 0) {
            this.debt -= amount;
        }
    }

    public void setDebt(double amount) {
        if (amount >= 0) {
            this.debt = amount;
        }
    }

    public void addRentalsEnded() {
        this.rentalsEnded++;
    }

    @Override
    public String toString() {
        return this.name +
                ", id: " +
                this.id +
                ", email: " +
                this.email +
                ", debt: " +
                this.debt +
                ", active: " +
                this.active +
                ", rentals ended: " +
                this.rentalsEnded;
    }
}
