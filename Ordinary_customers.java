public class Ordinary_customers extends Customer {
    private int Star_count =0;

//    public Ordinary_customers(String tel, String name, String address, String email, Reservation reservation) {
//        super(tel, name, address, email, reservation);
//    }


    public Ordinary_customers(String tel, String name, String addr, String email,int Star) {
        super(tel,name,addr,email);
        this.Star_count=Star;
    }

    public Ordinary_customers(String tel, String name, String address, String email) {
        super(tel,name,address,email);
    }

    public  int getStar_count() {
        return Star_count;
    }

    public void increaseStarCount() {
        ++Star_count;
    }

}
