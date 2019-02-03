package core.partners;

import core.citizens.Citizen;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Partners")
public class Partners {

    @Id
    @NotNull
    @Column(name = "PESEL1", length = 11, nullable = false, unique = true)
    private String PESEL1;

    @NotNull
    @Column(name = "PESEL2", length = 11, nullable = false, unique = true)
    private String PESEL2;
/*
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PESEL1", nullable = false)
    private Citizen citizen1;*/

    public String getPESEL1() { return PESEL1; }
    public void setPESEL1(String PESEL) { this.PESEL1 = PESEL; }

    public String getPESEL2() { return PESEL2; }
    public void setPESEL2(String PESEL) { this.PESEL2 = PESEL; }

    public Partners(String PESEL1, String PESEL2) {
        this.PESEL1 = PESEL1;
        this.PESEL2 = PESEL2;
    }
}