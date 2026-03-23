
public class UseCase6RoomAllocation {

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing");

        BookingRequestQueue queue = new BookingRequestQueue();

        RoomInventory inventory = new RoomInventory();

        RoomAllocationService allocationService = new RoomAllocationService();

        queue.addRequest(new Reservation("Abhi", "Single"));
        queue.addRequest(new Reservation("Subha", "Single"));
        queue.addRequest(new Reservation("Vanmathi", "Suite"));

        while (queue.hasPendingRequests()) {
            Reservation r = queue.getNextRequest();
            allocationService.allocateRoom(r, inventory);
        }
    }
}