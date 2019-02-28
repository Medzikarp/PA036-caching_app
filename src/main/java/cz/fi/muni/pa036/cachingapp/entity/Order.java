package cz.fi.muni.pa036.cachingapp.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
@Entity
@Table(name = "ordertbl")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Date created;

    private String description;

    //private OrderState state;

    //private User user;

    public Order () {}

    public Order (String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format(
                "Order[id=%d, name='%s', description='%s']",
                id, name, description);
    }
}
