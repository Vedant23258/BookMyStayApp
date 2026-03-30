public class UseCase10BookingCancellation {
    public static void main(String[] args) {
        System.out.println("Booking Cancellation");

        RoomInventory inventory = new RoomInventory();
        CancellationService cancellationService = new CancellationService();

        cancellationService.registerBooking("Single-1", "Single");

        cancellationService.cancelBooking("Single-1", inventory);

        cancellationService.showRollbackHistory();

        System.out.println("\nUpdated Single Room Availability: "
                + inventory.getRoomAvailability().get("Single"));
    }
}