import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;


public class Reservation {
    private int rev_id;
    private LocalDate DateNow = LocalDate.now();
    private LocalDate in,out;
    private ArrayList<Room> room;
    private double total_price;
    private double rev_price;
    private Customer cus;
    int pernight;
    public Reservation(LocalDate dateNow, LocalDate in, LocalDate out, ArrayList<Room> room,int roomNo,int pernight) {

        DateNow = dateNow;
        this.in = in;
        this.out = out;
        this.room = room;
      this.pernight =pernight;
    }

    public Customer getCus() {
        return cus;
    }

    public void setCus(Customer cus) {
        this.cus = cus;
    }

    public int getRev_id() {
        return rev_id;
    }

    public void setRev_id(int rev_id) {
        this.rev_id = rev_id;
    }

    public Reservation() {
    }




    public LocalDate getDateNow() {
        return DateNow;
    }

    public void setDateNow(LocalDate dateNow) {
        DateNow = dateNow;
    }

    public LocalDate getIn() {
        return in;
    }

    public void setIn(LocalDate in) {
        this.in = in;
    }

    public LocalDate getOut() {
        return out;
    }

    public void setOut(LocalDate out) {
        this.out = out;
    }


    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price += total_price;
    }

    public double getRev_price() {
        return rev_price;
    }

    public void setRev_price(double rev_price) {
        this.rev_price = rev_price;
    }

    @Override
    public String toString() {
        //"\n Room : " + room.get(CheckroomNo)
        return "----------Reservation----------" +
                "\nReservation ID :" + rev_id +
                "\n"+getCus()+
                "\n DateNow : " + DateNow +
                "\n Check in : " + in +
                "\n Checkout : " + out +
                "\n Night :"+pernight+
                "\n Room :"+room+
                "\n total_price : " + total_price

                ;
    }
}
