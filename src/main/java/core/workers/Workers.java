package core.workers;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity // This tells Hibernate to make a table out of this class
public class Workers {

    @Id
    @Column(nullable = false, unique = true, length = 11)
    private String PESEL;

    @Column()
    private String NIP;

    public String getPESEL() { return PESEL; }
    public void setPESEL(String PESEL) { this.PESEL = PESEL; }

    public String getNIP() { return NIP; }
    public void setNIP(String NIP) { this.NIP = NIP; }

    public Workers(String PESEL, String NIP) {
        this.PESEL = PESEL;
        this.NIP = NIP;
    }
}