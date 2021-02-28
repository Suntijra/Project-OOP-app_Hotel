
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class App_Hotel {
    static ArrayList<Room> regulars = new ArrayList<>();
    static ArrayList<Room> deluxes = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        regulars.add(new Regular("01"));
        regulars.add(new Regular("02"));
        regulars.add(new Regular("03"));

        deluxes.add(new Deluxe("04"));
        deluxes.add(new Deluxe("05"));
        deluxes.add(new Deluxe("06"));

        ArrayList<Ordinary_customers> oc = new ArrayList<Ordinary_customers>();
        oc.add(new Ordinary_customers("081-726-3710", "Lek", "RSU", "lek@rsu.ac.th", 9));
        oc.add(new Ordinary_customers("082-837-4821", "Case", "RSU", "Case@rsu.ac.th", 2));
        oc.add(new Ordinary_customers("09-612-1223", "Mod", "RSU", "Casw@rsu.ac.th", 5));
        ArrayList<VIP> vip = new ArrayList<VIP>();
        vip.add(new VIP("062-111-1212", "Dom", "RSU", "Dom@rsu.ac.th"));
        vip.add(new VIP("062-111-1212", "Sunti", "RSU", "Dom@rsu.ac.th"));
        vip.add(new VIP("081-726-3710", "Lee", "RSU", "lek@rsu.ac.th"));



        while (true) {
            int rev_id = 0;
            String room_select;
            double total = 0;
            int indexRoom_price = 0;
            int setindex = 0;
            int perNight =0;
            Reservation reservation = null;
            ArrayList addroom = new ArrayList<Room>();
            System.out.println("----------Register----------");
            System.out.println("Tel :");
            String tel = "081-726-3710";
            System.out.println("Name :");
            String name = "Lee";
            System.out.println("Adress :");
            String address = "RSU";
            System.out.println("Email");
            String email = "lek@rsu.ac.th";

            Ordinary_customers check_Odinary = new Ordinary_customers(tel, name, address, email);
            VIP check_VIP = new VIP(tel, name, address, email);
            boolean checkoc = false;
            boolean checkVIP = false;
            for (Customer checkname : oc) {
                if (checkname.getName() == name) {
                    checkoc = true;
                    setindex = oc.indexOf(check_Odinary);
                    break;
                }
            }
            for (Customer checknameVIP : vip) {
                if (checknameVIP.getName() == name) {
                    checkVIP = true;
                    setindex = vip.indexOf(check_VIP);
                    break;
                }
            }

            System.out.println(checkoc+"   "+checkVIP);

            if (checkoc == false && checkVIP == false) {
                checkoc = true;
                oc.add(new Ordinary_customers(tel, name, address, email, 0));
                setindex = oc.size()-1;
            }
            int dayin,monthin,yearin,dayout,monthout,yearout;
            LocalDate out;
            LocalDate in;
            LocalDate dateNow;
            System.out.println(setindex);
//                while (true) {
                System.out.println("----------Booking----------");
                System.out.println("Reservation ID :");
                System.out.println("Check in : ");
                System.out.println("Day :");
//                 dayin = sc.nextInt();
                System.out.println("Month :");
                //int monthin = sc.nextInt();
                System.out.println("Year :");
                //int yearin= sc.nextInt();

                     dateNow = LocalDate.now();
                     in = LocalDate.of(2020, 11, 28);
                    System.out.println("Check out : ");
                    System.out.println("Day out :");
//                     dayout = sc.nextInt();
                    System.out.println("Month :");
                    //int monthout = sc.nextInt();
                    System.out.println("Year :");
                    //int yearout= sc.nextInt();
                    out = LocalDate.of(2020, 11, 30);
                    long setnight = ChronoUnit.DAYS.between(in, out);
                    long DatAfter2day = ChronoUnit.DAYS.between(dateNow, in);
                    System.out.println(DatAfter2day);
                    perNight = (int) setnight;
                    System.out.println(perNight);
//                    if(DatAfter2day>2) {
//                        break;
//                    }
//                    System.out.println("จองล่วงหน้า 2 วัน");
//                }

                while (true) {
                    System.out.println("Select Room type");
                    System.out.println("1.Regular");
                    System.out.println("2.Deluxe");

                    byte Select = sc.nextByte();
                    if (Select == 1) {
                        System.out.println(regulars.toString());
                        System.out.println("Select Room No :");
                        room_select = sc.next();
                        if (room_select.equals("01"))
                        {
                            indexRoom_price = 0;
                            addroom.add(new Regular("01"));
                        }
                        else if (room_select.equals("02"))
                        {
                            indexRoom_price = 1;
                            addroom.add(new Regular("02"));
                        }
                        else if (room_select.equals("03"))
                        {
                            indexRoom_price = 2;
                            addroom.add(new Regular("03"));
                        }
                        reservation = new Reservation(dateNow, in, out, addroom, indexRoom_price,perNight);

                        if (checkoc) {
                            total += regulars.get(indexRoom_price).getPrice_rate()+(regulars.get(indexRoom_price).getService());
                            reservation.setTotal_price(total*perNight);
                            reservation.setCus(oc.get(setindex));
                        }
                        else if (checkVIP){
                            total += regulars.get(indexRoom_price).getPrice_rate()+(regulars.get(indexRoom_price).getService());
                            reservation.setTotal_price((total*perNight)-(total*perNight*vip.get(indexRoom_price).getDiscount()));
                            reservation.setCus(vip.get(setindex));

                        }
                        reservation.setRev_price(reservation.getTotal_price() * 0.5);

                    } else if (Select == 2) {
                        System.out.println(deluxes.toString());
                        System.out.println("Select Room No :");
                        room_select = sc.next();
                        if (room_select.equals("04")) {
                            indexRoom_price = 0;
                            addroom.add(new Deluxe("04"));
                        }
                        else if (room_select.equals("05"))
                        {
                            indexRoom_price = 1;
                            addroom.add(new Deluxe("05"));
                        }
                        else if (room_select.equals("06"))
                        {
                            indexRoom_price = 2;
                            addroom.add(new Deluxe("06"));
                        }
                        reservation = new Reservation(dateNow, in, out, addroom, indexRoom_price,perNight);

                        System.out.println(total);
                        if (checkoc) {
                            total += deluxes.get(indexRoom_price).getPrice_rate();
                            reservation.setTotal_price(total*perNight);
                            reservation.setRev_price(reservation.getTotal_price() * 0.5);
                            reservation.setCus(oc.get(setindex));

                        }
                        else if (checkVIP){
                            total += deluxes.get(indexRoom_price).getPrice_rate();
                            reservation.setTotal_price((total*perNight)-(total*perNight*vip.get(indexRoom_price).getDiscount()));
                            reservation.setRev_price(reservation.getTotal_price() * 0.5);
                            reservation.setCus(vip.get(setindex));
                            System.out.println(setindex);
                        }
                    } else {
                        System.out.println("Try Again");
                        break;
                    }

                    System.out.println("Select Room Again ? Y/N");
                    String checkExit = sc.next();
                        if (checkExit.equalsIgnoreCase("N")) {

                            break;
                        }
                }
                //System.out.println(vip.get(2));

                System.out.println(reservation.toString());
                System.out.println("คุุณต้องจ่าย 50% ถึงจะสำเร็จการจอง");
                System.out.println(reservation.getRev_price());
                System.out.println("Pay now ? Y/N");
                String checkpay = sc.next();
                if (checkpay.equalsIgnoreCase("y")) {
                    ++rev_id;
                    oc.get(setindex).increaseStarCount();
                    reservation.setRev_id(rev_id);
                    if (oc.get(setindex).getStar_count()>=10){
                        vip.add(new VIP(oc.get(setindex).getTel(),oc.get(setindex).getName(),oc.get(setindex).getAddress(),oc.get(setindex).getEmail()));
                        oc.remove(setindex);
                        reservation.setTotal_price(-reservation.getTotal_price());
                        System.out.println(reservation.getTotal_price());
                    }
                } else {
                    System.out.println("ยกเลิกการจอง");
                    reservation.setTotal_price(-reservation.getTotal_price());
                }
                System.out.println("Exit Y/N");
                exit();
            }
        }


    public static void exit()
    {
        Scanner sc = new Scanner(System.in);
        String check_exit = sc.next();
        if (check_exit.equalsIgnoreCase("Y"))
            System.exit(0);
    }


}
