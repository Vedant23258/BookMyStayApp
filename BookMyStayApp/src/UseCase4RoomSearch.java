public class UseCase4RoomSearch {

    public static void main(String[] args) {

        Room single = new SingleRoomImpl();
        Room dbl = new DoubleRoomImpl();
        Room suite = new SuiteRoomImpl();

        RoomInventory inventory = new RoomInventory();

        RoomSearchService searchService = new RoomSearchService();


        searchService.searchAvailableRooms(
                inventory,
                single,
                dbl,
                suite
        );
    }
}