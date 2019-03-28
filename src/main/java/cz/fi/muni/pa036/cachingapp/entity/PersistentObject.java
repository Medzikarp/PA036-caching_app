package cz.fi.muni.pa036.cachingapp.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
@MappedSuperclass
public class PersistentObject {
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
}
