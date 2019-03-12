package cz.fi.muni.pa036.cachingapp.entity;

import javax.persistence.*;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
@Entity
public class RevisionIssue extends PersistentObject {

    private String issueDescription;

    private InventoryItem item;

    private InventoryRevision revision;

    @Column
    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_item_id")
    public InventoryItem getItem() {
        return item;
    }

    public void setItem(InventoryItem item) {
        this.item = item;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_revision_id")
    public InventoryRevision getRevision() {
        return revision;
    }

    public void setRevision(InventoryRevision revision) {
        this.revision = revision;
    }
}
