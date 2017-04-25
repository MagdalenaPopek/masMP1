package magdalena;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse("2007-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        Horse aura = new Horse("Aura", date, "8888888", "klacz");
        Horse luna = new Horse("Luna", date, "2244433", "Klacz");
        Horse uk = new Horse("Uk", date, "3322111", "Ogier");
        ArrayList<Horse> h = new ArrayList<Horse>();
        ArrayList<Horse> ho = new ArrayList<>();
        h.add(aura);
        h.add(luna);
        ho.add(uk);

        Owner ala = new Owner(new User("Ala", "Ox", date, "222222"), 1234, h);
        Owner olga = new Owner(new User("Olga", "Ok", date, "44444"), 3322, ho);



        Address add = new Address("Lublin", "Ciepla 7", "20-333");
        Employee zatrIza = new Employee(new User("Iza", "Xor", date, "111111"), date, 1172, add);
        Employee zatrEwa = new Employee(new User("Ewa", "Rox", date, "000000"), date, 1452, add);

        zatrIza.setBonus(5);
        System.out.println("Iza salary bez bon: " + zatrIza.getSalary());
        System.out.println("Iza salary z bon: " + zatrIza.getSalary(5));
        System.out.println("Iza dochód: " + zatrIza.getDochod());
        Employee.setChristmassBonus();
        System.out.println("Iza christBon: " + zatrIza.getChristmassBonus());
        System.out.println("Iza dochód christ: " + zatrIza.getDochod());
        System.out.println(Employee.getHighestSalary());


        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("ekstensje")));
            Owner.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Trwałość ekstensji
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("ekstensje")));
            Owner.read(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Owner.showEkstensja();


    }
}
