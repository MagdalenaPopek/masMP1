package magdalena;

import java.io.Serializable;
import java.util.Date;

public class Horse implements Serializable{


    /**
     * Imię
     */
    private String name;

    /**
     * Data urodzenia
     */
    private Date birthDate;

    /**
     * Numer paszportu
     */
    private String passportNumber;

    /**
     * Płeć
     */
    private String gender;

    /**
     * Właściciel
     */
    private Owner owner;

    public Horse(String name, Date birthDate, String passportNumber, String gender){
        this.name = name;
        this.birthDate = birthDate;
        this.passportNumber = passportNumber;
        this.gender = gender;
    }

    public void setOwner(Owner owner) throws Exception {
        if(this.owner != null){
            throw new Exception("Ten koń ma już właściciela");
        }
        this.owner = owner;
    }



    @Override
    public String toString() {
        return "Koń: " + name + ", " + birthDate +
                ", " + passportNumber +
                ", " + gender;
    }

}