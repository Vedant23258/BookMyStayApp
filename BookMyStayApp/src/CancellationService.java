import java.util.*;

public class CancellationService {

    private Stack<String> releasedRooms;

    private Map<String, String> reservationIDtoRoomType;

    public CancellationService() {
        releasedRooms = new Stack<>();
        reservationIDtoRoomType = new HashMap<>();
    }

    public void registerBooking(String reservationId, String roomType) {
        reservationIDtoRoomType.put(reservationId, roomType);
    }

    public void cancelBooking(String reservationId, RoomInventory inventory) {
        if (!reservationIDtoRoomType.containsKey(reservationId)) {
            System.out.println("Cancellation failed: Reservation ID not found.");
            return;
        }

        String roomType = reservationIDtoRoomType.get(reservationId);

        releasedRooms.push(reservationId);

        inventory.updateAvailability(roomType, inventory.getRoomAvailability().get(roomType) + 1);

        reservationIDtoRoomType.remove(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    public void showRollbackHistory() {
        System.out.println("\nRollback History (Most Recent First):");
        for (String reservationId : releasedRooms) {
            System.out.println("Released Reservation ID: " + reservationId);
        }
    }
}