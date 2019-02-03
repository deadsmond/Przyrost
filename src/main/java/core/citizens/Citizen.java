package core.citizens;

import core.partners.Partners;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Citizen")
public class Citizen {

    @Id
    @NotNull
    @Column(name = "PESEL1", length = 11, nullable = false, unique = true)
    private String PESEL;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "surname", nullable = false)
    private String surname;

    @NotNull
    @Column(name = "birthday", nullable = false)
    private String birthday;

    @NotNull
    @Column(name = "sex", nullable = false)
    private String sex;
/*
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "citizen1")
    private Partners partners;*/

    public String getPESEL() { return PESEL; }
    public void setPESEL (String PESEL) { this.PESEL = PESEL; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() { return sex; }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public Citizen(String PESEL, String name, String surname, String birthday, String sex) {
        this.PESEL = PESEL;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.sex = sex;
    }

}