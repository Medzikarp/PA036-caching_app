package cz.fi.muni.pa036.cachingapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
@Entity
@Table (name="inventory_revision")
public class InventoryRevision extends PersistentObject {

    @Column (name="revision_date")
    private LocalDate revisionDate;

    @Column
    private String result;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch")
    private Branch branch;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author")
    private User author;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "revision")
    private List<RevisionIssue> issues;


    public LocalDate getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(LocalDate revisionDate) {
        this.revisionDate = revisionDate;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<RevisionIssue> getIssues() {
        return issues;
    }

    public void setIssues(List<RevisionIssue> issues) {
        this.issues = issues;
    }

    @Override
    public String toString() {
        return "InventoryRevision{" +
                "revisionDate=" + revisionDate +
                ", result='" + result + '\'' +
                ", branch=" + branch +
                ", author=" + author +
                ", issues=" + issues +
                '}';
    }
}
