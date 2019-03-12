package cz.fi.muni.pa036.cachingapp.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
@Entity
public class InventoryRevision extends PersistentObject {

    private Date revisionDate;

    private String result;

    private Branch branch;

    private User author;

    private List<RevisionIssue> issues;

    @Column
    public Date getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(Date revisionDate) {
        this.revisionDate = revisionDate;
    }

    @Column
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "revision")
    public List<RevisionIssue> getIssues() {
        return issues;
    }

    public void setIssues(List<RevisionIssue> issues) {
        this.issues = issues;
    }
}
