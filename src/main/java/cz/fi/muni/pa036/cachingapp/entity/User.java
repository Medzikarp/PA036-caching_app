package cz.fi.muni.pa036.cachingapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "branch")
    private Branch branch;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "author")
    private List<InventoryRevision> revisions;


    public List<InventoryRevision> getRevisions() {
        return revisions;
    }

    public void setRevisions(List<InventoryRevision> revisions) {
        this.revisions = revisions;
    }

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
