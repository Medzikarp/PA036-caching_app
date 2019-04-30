package cz.fi.muni.pa036.cachingapp.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
@MappedSuperclass
public abstract class PersistentObject {

    @Id
    @GeneratedValue
    protected Long id;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toString() {
        return this.getClass().getSimpleName() + "-" + getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersistentObject that = (PersistentObject) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
