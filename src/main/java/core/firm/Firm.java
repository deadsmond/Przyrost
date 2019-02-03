package core.firm;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity // This tells Hibernate to make a table out of this class
public class Firm {

    @Id
    @Column(nullable = false, unique = true, length = 11)
    private String NIP;

    @Column(nullable = false)
    private String name;

    private Integer addid;

    public String getNIP() { return NIP; }
    public void setNIP(String NIP) { this.NIP = NIP; }

    public String getName() { return name; }
    public void setName(String Name) { this.name = Name; }

    public Integer getAddid() { return addid; }
    public void setAddid(Integer addid) { this.addid = addid; }

    public Firm(String NIP, String name, Integer addid) {
        this.NIP = NIP;
        this.name = name;
        this.addid = addid;
    }
}