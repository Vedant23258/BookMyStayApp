public class BookingReportService {

    public void generateReport(BookingHistory history) {

        System.out.println("Booking History and Reporting\n");

        for (Reservation r : history.getConfirmedReservations()) {
            System.out.println("Guest: " + r.getGuestName() +
                    ", Room Type: " + r.getRoomType());
        }
    }
}