public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();

        history.addReservation(new Reservation("Abhi", "Single"));
        history.addReservation(new Reservation("Subha", "Double"));
        history.addReservation(new Reservation("Vannathi", "Suite"));

        BookingReportService reportService = new BookingReportService();
        reportService.generateReport(history);
    }
}