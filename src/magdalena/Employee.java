package magdalena;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

public class Employee extends User{

    /**
     * Data zatrudnienia
     */
    private Date hireDate;

    /**
     * Data zwolnienia
     */
    private Date fireDate;

    /**
     * Pensja
     */
    private double salary;

    /**
     * Dochód - POCHODNY
     */

    /**
     * Dodatek - w zależności od ilości zajęć/zabiegów min. 1%, max. 5% pensji
     */
    private int bonus;

    /**
     * Adres miejsca pracy - ATR KLASOWY I ZŁOŻONY
     */
    private Address workplaceAddress;

    /**
     * Premia na święta - ART. POCHODNY
     */
    private double christmassBonus;

    private static ArrayList<Employee> emp = new ArrayList<Employee>();

    public Employee(User user, Date hireDate, double salary, Address workplaceAddress) {
        super(user.getName(), user.getSurname(), user.getBirthDate(), user.getPhoneNumber());
        this.hireDate = hireDate;
        this.salary = salary;
        this.workplaceAddress = workplaceAddress;
        emp.add(this);
    }

    public double getSalary() {
        return salary;
    }

    public double getSalary(int bonus){
        return this.salary + this.salary * this.bonus/100;
    }

    public double getChristmassBonus() {
        return christmassBonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public double getDochod(){
        return this.salary + this.salary * this.bonus/100 + this.christmassBonus;
    }

    public static void setChristmassBonus(){
        for(Employee e : emp){
            if(e.christmassBonus != 0) {
                e.christmassBonus = e.salary / 10 * e.bonus;
            }else{
                e.christmassBonus = e.salary / 10;
            }
        }
    }

    //METODA KLASOWA
    public static double getHighestSalary(){
        double maxSal = 0.0;
        for(Employee e : emp){
            if(e.getSalary() > maxSal){
                maxSal = e.getSalary();
            }
        }
        return maxSal;
    }

    public static void showEkstensja(){
        for(Employee e : emp){
            System.out.println(e);
        }
    }

    public static void write(ObjectOutputStream out) throws IOException {
        out.writeObject(emp);
    }

    public static void read(ObjectInputStream in) throws IOException, ClassNotFoundException {
        emp = (ArrayList<Employee>) in.readObject();
    }

    @Override
    public String toString() {
        return "Pracownik: " + getName() + " "
                + getSurname() + ", "
                + salary + ", "
                + workplaceAddress;
    }
}