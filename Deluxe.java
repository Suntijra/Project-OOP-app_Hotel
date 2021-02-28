public class Deluxe extends Room {

    private double FreeService;
    public Deluxe(String room_No) {
        super(room_No, 2000);
    }


    public double getService() {
        FreeService = 400;
        return FreeService;
    }
}
