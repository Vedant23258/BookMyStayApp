public class UseCase12DataPersistenceRecovery {
    public static void main(String[] args) {
        System.out.println("System Recovery");

        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistenceService = new FilePersistenceService();

        String filePath = "inventory.txt";

        persistenceService.loadInventory(inventory, filePath);

        System.out.println("\nCurrent Inventory:");
        for (var entry : inventory.getRoomAvailability().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        persistenceService.saveInventory(inventory, filePath);
    }
}