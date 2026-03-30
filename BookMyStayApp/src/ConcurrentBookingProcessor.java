import java.util.concurrent.BlockingQueue;

public class ConcurrentBookingProcessor implements Runnable {
    private BlockingQueue<Reservation> bookingQueue;
    private RoomInventory inventory;
    private RoomAllocationService allocationService;

    public ConcurrentBookingProcessor(
            BlockingQueue<Reservation> bookingQueue,
            RoomInventory inventory,
            RoomAllocationService allocationService
    ) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    @Override
    public void run() {
        while (true) {
            Reservation reservation;
            try {
                reservation = bookingQueue.take();
            } catch (InterruptedException e) {
                break;
            }

            synchronized (inventory) {
                allocationService.allocateRoom(reservation, inventory);
            }
        }
    }
}