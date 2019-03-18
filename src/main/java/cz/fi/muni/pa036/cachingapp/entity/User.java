package cz.fi.muni.pa036.cachingapp.entity;

import javax.persistence.*;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
@Entity
@Table (name="users")
public class User extends PersistentObject {

    @Column
    private String name;

    @Column
    private String surname;

    @Column (name = "birth_number")
    private String birthNumber;

    @Column(nullable = false)
    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch")
    private Branch branch;


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


    public String getBirthNumber() {
        return birthNumber;
    }

    public void setBirthNumber(String birthNumber) {
        this.birthNumber = birthNumber;
    }


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
