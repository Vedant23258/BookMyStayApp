import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class UseCase11ConcurrentBookingSimulation {
    public static void main(String[] args) {
        System.out.println("Concurrent Booking Simulation");

        BlockingQueue<Reservation> bookingQueue = new LinkedBlockingQueue<>();

        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();

        bookingQueue.add(new Reservation("Guest1", "Single"));
        bookingQueue.add(new Reservation("Guest2", "Double"));
        bookingQueue.add(new Reservation("Guest3", "Suite"));
        bookingQueue.add(new Reservation("Guest4", "Single"));
        bookingQueue.add(new Reservation("Guest5", "Double"));

        Thread t1 = new Thread(
                new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService),
                "Thread-1"
        );

        Thread t2 = new Thread(
                new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService),
                "Thread-2"
        );

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.err.println("Thread execution interrupted.");
        }

        System.out.println("Simulation complete. Inventory state: " + inventory.getRoomAvailability());
    }
}