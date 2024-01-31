import models.Passenger;
import models.Receipt;
import models.Section;
import models.Train;
import services.BookingService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Running.....");

        // Create Section for train
        Section sectionA = new Section("A", 3);
        Section sectionB = new Section("B", 3);

        // Make the list of sections
        List<Section> sections = new ArrayList<>();
        sections.add(sectionA);
        sections.add(sectionB);

        // Create a train
        Train train = new Train("T1", sections);

        // Create the booking service
        BookingService bookingService = new BookingService(train);

        // Create the passenger
        Passenger passenger1 = new Passenger("Test1", "test1", "test1@test.com");
        Passenger passenger2 = new Passenger("Test2", "test2", "test2@test.com");
        Passenger passenger3 = new Passenger("Test3", "test3", "test3@test.com");
        Passenger passenger4 = new Passenger("Test4", "test4", "test4@test.com");
        Passenger passenger5 = new Passenger("Test5", "test5", "test5@test.com");

        System.out.println("Check Seat Booking API");
        Receipt receipt1 = bookingService.bookSeat(passenger1, "London", "France");
        bookingService.printReceipt(receipt1);

        Receipt receipt2 = bookingService.bookSeat(passenger2, "London", "France");
        bookingService.printReceipt(receipt2);

        Receipt receipt3 = bookingService.bookSeat(passenger3, "London", "France");
        bookingService.printReceipt(receipt3);

        try {
            Receipt receipt4 = bookingService.bookSeat(passenger4, "London", "France");
            bookingService.printReceipt(receipt4);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Check Remove User API");
        try {
            bookingService.removeUser(passenger4);
            bookingService.removeUser(passenger4);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        bookingService.removeUser(passenger2);
        Receipt receipt5 = bookingService.bookSeat(passenger5, "London", "France");
        bookingService.printReceipt(receipt5);

        System.out.println("Check Modify User Seat API");
        Receipt newReceipt3 = bookingService.modifySeat(passenger3, "B", 1);
        bookingService.printReceipt(newReceipt3);


        System.out.println("Check All Passenger List API");
        bookingService.printAllPassengerDetail();

    }
}
