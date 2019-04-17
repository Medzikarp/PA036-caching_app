package cz.fi.muni.pa036.cachingapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
@Entity
@Table (name="revision_issue")
public class RevisionIssue extends PersistentObject {

    @Column (name = "issue_description")
    private String issueDescription;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_item")
    private InventoryItem item;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_revision")
    private InventoryRevision revision;


    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }


    public InventoryItem getItem() {
        return item;
    }

    public void setItem(InventoryItem item) {
        this.item = item;
    }


    public InventoryRevision getRevision() {
        return revision;
    }

    public void setRevision(InventoryRevision revision) {
        this.revision = revision;
    }
}
