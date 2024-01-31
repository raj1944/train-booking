package services;

import models.Passenger;
import models.Receipt;
import models.Section;
import models.Train;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BookingService {

    private Train train;

    private Map<String, Receipt> passengerReceipt;

    public BookingService(Train train) {
        this.train = train;
        this.passengerReceipt = new HashMap<>();
    }

    public Receipt bookSeat(Passenger passenger, String from, String to) {
        List<Section> sections = train.getSections();
        Receipt receipt = null;
        for(Section section : sections) {
            int seatNumber = section.getAvailableSeat();
            if(seatNumber != -1) {
                section.updateSeatDetails(passenger, seatNumber);
                receipt = new Receipt(from, to, 20.0, section.getName(), seatNumber + 1, passenger);
                break;
            }
        }
        if(receipt == null) {
            throw new RuntimeException("Seat is not available");
        }
        this.passengerReceipt.put(passenger.getEmailId(), receipt);
        return receipt;
    }

    public void printAllPassengerDetail() {
        for(Map.Entry<String, Receipt> entry : this.passengerReceipt.entrySet()) {
            printReceipt(entry.getValue());
        }
    }

    public void removeUser(Passenger passenger) {
        Receipt receipt = this.passengerReceipt.getOrDefault(passenger.getEmailId(), null);

        if(receipt == null) {
            throw new RuntimeException("Booking Details not found");
        }
        this.passengerReceipt.remove(passenger.getEmailId());

        List<Section> sections = train.getSections();
        for(Section section : sections) {
            if(Objects.equals(section.getName(), receipt.getSectionName())) {
                section.updateSeatDetails(null, receipt.getSeatNumber() - 1);
                break;
            }
        }
    }

    public Receipt modifySeat(Passenger passenger, String sectionName, int seatNumber) {
        Receipt receipt = this.passengerReceipt.getOrDefault(passenger.getEmailId(), null);

        if(receipt == null) {
            throw new RuntimeException("Booking Details not found");
        }

        Receipt newReceipt = null;
        List<Section> sections = train.getSections();
        for(Section section : sections) {
            if(Objects.equals(section.getName(), sectionName) && section.checkSeatAvailable(seatNumber - 1)) {
                section.updateSeatDetails(passenger, seatNumber - 1);
                newReceipt = new Receipt(receipt.getFrom(), receipt.getTo(), 20.0, section.getName(), seatNumber, passenger);
                break;
            }
        }

        if(newReceipt == null) {
            throw new RuntimeException("Seat is not available");
        }
        this.passengerReceipt.remove(receipt.getPassenger().getEmailId());
        this.passengerReceipt.put(passenger.getEmailId(), newReceipt);
        return newReceipt;
    }

    public void printReceipt(Receipt receipt) {
        System.out.println("***************************************");
        System.out.println("Name: " + receipt.getPassenger().getFirstName() + " " + receipt.getPassenger().getLastName());
        System.out.println("EmailId: " + receipt.getPassenger().getEmailId());
        System.out.println("From: " + receipt.getFrom());
        System.out.println("To: " + receipt.getTo());
        System.out.println("Section: " + receipt.getSectionName());
        System.out.println("Seat Number: " + receipt.getSeatNumber());
        System.out.println("Price: " + String.valueOf(receipt.getPrice()));
        System.out.println("***************************************");
    }

}
