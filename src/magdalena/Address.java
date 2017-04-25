package magdalena;

import java.io.Serializable;

/**
 * Created by Magdalena on 2017-04-07.
 */
public class Address implements Serializable{

    private String city;
    private String street;
    private String postCode;

    public Address(String city, String street, String postCode) {
        this.city = city;
        this.street = street;
        this.postCode = postCode;
    }


    @Override
    public String toString() {
        return city + ", ulica " + street + ", kod pocztowy " + postCode;
    }
}
