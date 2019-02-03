package core.location;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity // This tells Hibernate to make a table out of this class
public class Location {

    @Id
    @Column(nullable = false, unique = true, length = 11)
    private String PESEL;

    @Column(nullable = false, unique = true)
    private Integer addid;

    public Integer getAddid() { return addid; }
    public void setAddid(Integer addid) { this.addid = addid; }

    public String getPESEL() { return PESEL; }
    public void setPESEL(String city) { this.PESEL = PESEL; }

    public Location(String PESEL, Integer addid) {
        this.PESEL = PESEL;
        this.addid = addid;
    }
}