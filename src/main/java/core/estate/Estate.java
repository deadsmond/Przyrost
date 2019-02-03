package core.estate;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity // This tells Hibernate to make a table out of this class
public class Estate {

    @Id
    @Column(nullable = false, unique = true, length = 11)
    private String PESEL;

    @Column(nullable = false, unique = true)
    private Integer addid;

    public Integer getAddid() { return addid; }
    public void setAddid(Integer addid) { this.addid = addid; }

    public String getPESEL() { return PESEL; }
    public void setPESEL(String city) { this.PESEL = PESEL; }

    public Estate(String PESEL, Integer addid) {
        this.PESEL = PESEL;
        this.addid = addid;
    }
}