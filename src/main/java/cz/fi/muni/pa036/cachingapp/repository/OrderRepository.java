package cz.fi.muni.pa036.cachingapp.repository;

import cz.fi.muni.pa036.cachingapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
public interface OrderRepository extends JpaRepository<Order, Long>{

}
