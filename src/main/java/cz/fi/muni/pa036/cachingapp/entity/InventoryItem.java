package cz.fi.muni.pa036.cachingapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table (name="inventory_item")
public class InventoryItem extends PersistentObject {

    @Column
    private String name;

    @Column(nullable = false, name = "is_material")
    private boolean isMaterial;

    @Column
    private Integer quantity;

    @Column(name = "date_from")
    private LocalDate dateFrom;

    @Column(name = "date_to")
    private LocalDate dateTo;

    @Column (nullable = false)
    private boolean scrapped;

    @Column
    private String note;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch")
    private Branch branch;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private List<RevisionIssue> revisionIssues;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMaterial() {
        return isMaterial;
    }

    public void setMaterial(boolean material) {
        isMaterial = material;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public boolean isScrapped() {
        return scrapped;
    }

    public void setScrapped(boolean scrapped) {
        this.scrapped = scrapped;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public List<RevisionIssue> getRevisionIssues() {
        return revisionIssues;
    }

    public void setRevisionIssues(List<RevisionIssue> revisionIssues) {
        this.revisionIssues = revisionIssues;
    }
}
