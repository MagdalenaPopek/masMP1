package magdalena;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Owner  extends User{

    /**
     * Opłata
     */
    private int charge;

    /**
     * Konie - ATRYBUT POWTARZALNY
     */
    private ArrayList<Horse> horses = new ArrayList<Horse>();

    private static ArrayList<Owner> owners = new ArrayList<Owner>();

    public Owner(User user, int charge) {
        super(user.getName(), user.getSurname(), user.getBirthDate(), user.getPhoneNumber());
        this.charge = charge;
        owners.add(this);
    }

    public void showHorses() {
        for(Horse h : horses){
            System.out.println(h);
        }
    }

    public static void showEkstensja(){
        for(Owner o : owners) {
                System.out.println(o);
        }
    }

    public void setHorses(Horse horse){
        if(!horses.contains(horse)){
            horses.add(horse);
        }
    }

    public static void write(ObjectOutputStream out) throws IOException {
        out.writeObject(owners);
    }

    public static void read(ObjectInputStream in) throws IOException, ClassNotFoundException {
        owners = (ArrayList<Owner>) in.readObject();
    }
}