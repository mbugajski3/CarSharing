import java.util.ArrayList;

public class Rental {

    private int id;
    private Customer customer;
    private Vehicle vehicle;
    private int plannedRentDays;
    private int actualRentDays;
    private String rentStatus;
    private double totalPrice;
    private boolean paid;

    public Rental(int id, Customer customer, Vehicle vehicle, int plannedRentDays) {
        if (id < 0) {
            this.id = 1;
        } else {
            this.id = id;
        }

        this.customer = customer;

        this.vehicle = vehicle;

        if (plannedRentDays < 0) {
            this.plannedRentDays = 0;
        } else {
            this.plannedRentDays = plannedRentDays;
        }

        this.actualRentDays = 0;

        this.rentStatus = "UNACTIVE";

        this.totalPrice = 0;

        this.paid = false;

    }

    public int getId() {
        return this.id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public int getPlannedRentDays() {
        return this.plannedRentDays;
    }

    public int getActualRentDays() {
        return this.actualRentDays;
    }

    public String getRentStatus() {
        return this.rentStatus;
    }

    public void setRentStatus(String rentStatus) {
        this.rentStatus = rentStatus;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public boolean isPaid() {
        return this.paid;
    }

    public void setTotalPrice(double amount) {
        if (amount >= 0) {
            this.totalPrice = amount;
        }
    }

    public void paid() {
        this.paid = true;
    }

    public void makePayment(double amount) {
        if (amount > 0) {
            if (amount > this.totalPrice) {
                this.totalPrice = 0;
            } else if (amount < this.totalPrice) {
                this.totalPrice -= amount;
            }
        }
    }

    public boolean canRent() {
        return this.customer != null &&
                this.customer.isActive() &&
                this.customer.getDebt() <= 500 &&
                this.vehicle != null &&
                this.vehicle.isActiveInSystem() &&
                this.vehicle.isAvailable() &&
                this.plannedRentDays > 0;
    }

    public void rent() {
        if (canRent()) {
            this.rentStatus = "ACTIVE";
            this.vehicle.makeUnavailable();
        }
    }

    public void rentReturn() {
        this.rentStatus = "RETURNED";
        this.vehicle.makeAvailable();
    }

    public void addReturnPrice(double amount) {
        this.totalPrice += amount;
    }

    public void setActualRentDays(int actualRentDays) {
        this.actualRentDays = actualRentDays;
    }

    public void daysOver(int amount) {
        this.actualRentDays += amount;
    }

    @Override
    public String toString() {
        return "ID: " +
                this.id +
                ", customer: " +
                this.customer.getName() +
                ", vehicle: " +
                this.vehicle.getBrand() +
                ", planned rent days: " +
                this.plannedRentDays +
                ", actual rent days: " +
                this.actualRentDays +
                ", rent status: " +
                this.rentStatus +
                ", total price: " +
                this.totalPrice +
                ", paid: " +
                this.paid;
    }
}
