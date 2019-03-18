package cz.fi.muni.pa036.cachingapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Branch extends PersistentObject {

    @Column
    private String name;

    @Column
    private String street;

    @Column(name = "street_number")
    private Integer streetNumber;

    @Column
    private String city;

    @Column
    private String state;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "branch")
    private List<User> employees;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "branch")
    private List<InventoryItem> items;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "branch")
    private List<InventoryRevision> revisions;


    public Branch () {}

    public Branch (String name) {
        this.name = name;
    }



    public List<User> getEmployees() {
        return employees;
    }

    public void setEmployees(List<User> employees) {
        this.employees = employees;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<InventoryItem> getItems() {
        return items;
    }

    public void setItems(List<InventoryItem> items) {
        this.items = items;
    }

    public List<InventoryRevision> getRevisions() {
        return revisions;
    }

    public void setRevisions(List<InventoryRevision> revisions) {
        this.revisions = revisions;
    }
}
