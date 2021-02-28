public class Regular extends Room { ;
    private double service = 100;
    public Regular(String room_No) {
        super(room_No, 1200);
    }


    public double getService() {
        return service;
    }
}
