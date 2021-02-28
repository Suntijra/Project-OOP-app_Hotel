public class VIP extends Customer {
    private double discount = 0.1;

//    public VIP(String tel, String name, String address, String email, Reservation reservation) {
//        super(tel, name, address, email, reservation);
//    }
    public VIP(String tel, String name, String address, String email) {
        super(tel, name, address, email);
    }

    public double getDiscount() {
        return discount;
    }
}
