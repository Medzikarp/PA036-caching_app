package cz.fi.muni.pa036.cachingapp.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
@Entity
public class InventoryItem extends PersistentObject {

    private String name;

    private boolean isMaterial;

    private Integer quantity;

    private Date dateFrom;

    private Date dateTo;

    private boolean scrapped;

    private String note;

    private Branch branch;

    private List<RevisionIssue> revisionIssues;

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public boolean isMaterial() {
        return isMaterial;
    }

    public void setMaterial(boolean material) {
        isMaterial = material;
    }

    @Column
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Column
    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    @Column
    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    @Column(nullable = false)
    public boolean isScrapped() {
        return scrapped;
    }

    public void setScrapped(boolean scrapped) {
        this.scrapped = scrapped;
    }

    @Column
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "item")
    public List<RevisionIssue> getRevisionIssues() {
        return revisionIssues;
    }

    public void setRevisionIssues(List<RevisionIssue> revisionIssues) {
        this.revisionIssues = revisionIssues;
    }
}
