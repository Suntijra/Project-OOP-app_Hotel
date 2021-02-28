public abstract class Room {
    private String room_No;
    private double price_rate;

    public Room(String room_No, double price_rate) {
        this.room_No = room_No;
        this.price_rate = price_rate;
    }

    public abstract double getService() ;

    public String getRoom_No() {
        return room_No;
    }

    public void setRoom_No(String room_No) {
        this.room_No = room_No;
    }

    public double getPrice_rate() {
        return price_rate;
    }

    public void setPrice_rate(double price_rate) {
        this.price_rate = price_rate;
    }

    @Override
    public String toString() {
        return
                "\n Room No : " + room_No +
                "\n Price rate : " + price_rate+""
                ;
    }
}
