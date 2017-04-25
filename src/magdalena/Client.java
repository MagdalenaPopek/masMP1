package magdalena;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Client  extends User {


    /**
     * Poziom zaawansowania
     */
    private String level;

    /**
     * Wzrost
     */
    private int height;

    private static ArrayList<Client> clients = new ArrayList<Client>();

    public Client(User user, String level, int height) {
        super(user.getName(), user.getSurname(), user.getBirthDate(), user.getPhoneNumber());
        this.level = level;
        this.height = height;
        clients.add(this);
    }

    public Client(User user, int height) {
        super(user.getName(), user.getSurname(), user.getBirthDate(), user.getPhoneNumber());
        this.height = height;
        clients.add(this);
    }



    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static void showEkstensja(){
        for(Client c : clients){
            System.out.println(c);
        }
    }

    public static void write(ObjectOutputStream out) throws IOException {
        out.writeObject(clients);
    }

    public static void read(ObjectInputStream in) throws IOException, ClassNotFoundException {
        clients = (ArrayList<Client>) in.readObject();
    }
}