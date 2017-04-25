package magdalena;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Magdalena on 2017-04-24.
 */
public class User implements Serializable {

    private static int counter;

    /**
     * Numer (id) użytkownika
     */
    private int userId;

    /**
     * Imie
     */
    private String name;

    /**
     * Nazwisko
     */
    private String surname;

    /**
     * Data urodzenia - ATRYBUT ZL
     */
    private Date birthDate;

    /**
     * Numer telefonu
     */
    private String phoneNumber;


    public User(String name, String surname, Date birthDate, String phoneNumber){
        this.userId = counter++;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }



    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Użtkownik o numerze " + userId +
                ", imię: " + name +
                ", nazwisko: " + surname;
    }


}
