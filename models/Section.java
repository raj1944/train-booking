package models;

import java.util.ArrayList;
import java.util.List;

public class Section {

    private String name;

    private int numberOfSeat;

    private List<Passenger> seatDetails;

    public Section(String name, int numberOfSeat) {
        this.name = name;
        this.numberOfSeat = numberOfSeat;
        this.seatDetails = new ArrayList<>();
        for(int seatNumber = 0; seatNumber < this.numberOfSeat; seatNumber += 1) {
            this.seatDetails.add(null);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public void updateSeatDetails(Passenger passenger, int seatNumber) {
        this.seatDetails.set(seatNumber, passenger);
    }

    public boolean checkSeatAvailable(int seatNumber) {
        return this.seatDetails.get(seatNumber) == null;
    }

    public int getAvailableSeat() {
        for(int seatNumber = 0; seatNumber < this.numberOfSeat; seatNumber += 1) {
            if(this.seatDetails.get(seatNumber) == null) {
                return seatNumber;
            }
        }
        return -1;
    }
}
