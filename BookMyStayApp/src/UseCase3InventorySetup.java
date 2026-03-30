import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;

class RoomInventory {
    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    public boolean isAvailable(String roomType) {
        Integer available = roomAvailability.get(roomType);
        return available != null && available > 0;
    }

    public void reserveRoom(String roomType) {
        if (isAvailable(roomType)) {
            roomAvailability.put(roomType, roomAvailability.get(roomType) - 1);
        }
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    // ✅ New method to update availability directly
    public void updateAvailability(String roomType, int newCount) {
        if (newCount < 0) {
            throw new IllegalArgumentException("Availability cannot be negative.");
        }
        if (!roomAvailability.containsKey(roomType)) {
            throw new IllegalArgumentException("Invalid room type: " + roomType);
        }
        roomAvailability.put(roomType, newCount);
    }
}


public class UseCase3InventorySetup {

    public static void main(String[] args) {

        Room single = new SingleRoom();
        Room dbl = new DoubleRoom();
        Room suite = new SuiteRoom();

        RoomInventory inventory = new RoomInventory();

        System.out.println("Hotel Room Inventory Status\n");

        System.out.println("Single Room:");
        single.displayRoomDetails();
        System.out.println("Available Rooms: " +
                inventory.getRoomAvailability().get("Single") + "\n");

        System.out.println("Double Room:");
        dbl.displayRoomDetails();
        System.out.println("Available Rooms: " +
                inventory.getRoomAvailability().get("Double") + "\n");

        System.out.println("Suite Room:");
        suite.displayRoomDetails();
        System.out.println("Available Rooms: " +
                inventory.getRoomAvailability().get("Suite"));
    }
}