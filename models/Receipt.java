package models;

public class Receipt {

    private String from;

    private String to;

    private double price;

    private String sectionName;

    private int seatNumber;

    private Passenger passenger;

    public Receipt(String from, String to, double price, String sectionName, int seatNumber, Passenger passenger) {
        this.from = from;
        this.to = to;
        this.price = price;
        this.sectionName = sectionName;
        this.seatNumber = seatNumber;
        this.passenger = passenger;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
