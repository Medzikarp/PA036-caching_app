package cz.fi.muni.pa036.cachingapp.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
@MappedSuperclass
public class PersistentObject {

    protected Long id;

    @Id
    @GeneratedValue
    public Long getId()
    {
        return id;
    }

}
