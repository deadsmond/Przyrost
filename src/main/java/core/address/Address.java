package core.address;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity // This tells Hibernate to make a table out of this class
public class Address {

    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    private Integer addid;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String number;

    private String apartment;

    public Integer getAddid() { return addid; }
    public void setAddid(Integer addid) { this.addid = addid; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getStreet() {
        return street;
    }
    public void setStreet (String street) { this.street = street; }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public String getApartment() {
        return apartment;
    }
    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public Address(String city, String street, String number, String apartment) {
        this.city = city;
        this.street = street;
        this.number = number;
        this.apartment = apartment;
    }
}