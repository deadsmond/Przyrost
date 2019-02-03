package core.division;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity // This tells Hibernate to make a table out of this class
public class Division {

    @Id
    @Column(nullable = false)
    private String NIP;

    @Column(nullable = false, unique = true)
    private Integer addid;

    public Integer getAddid() { return addid; }
    public void setAddid(Integer addid) { this.addid = addid; }

    public String getNIP() { return NIP; }
    public void setNIP(String city) { this.NIP = NIP; }

    public Division(String NIP, Integer addid) {
        this.NIP = NIP;
        this.addid = addid;
    }
}