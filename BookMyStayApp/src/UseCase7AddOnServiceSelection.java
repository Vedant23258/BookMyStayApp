public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        AddOnServiceManager manager = new AddOnServiceManager();

        String reservationId = "Single-1";

        manager.addService(reservationId, new AddOnService("Breakfast", 500.0));
        manager.addService(reservationId, new AddOnService("Spa", 700.0));
        manager.addService(reservationId, new AddOnService("Airport Pickup", 300.0));

        double totalCost = manager.calculateTotalServiceCost(reservationId);

        System.out.println("Add-On Service Selection");
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}