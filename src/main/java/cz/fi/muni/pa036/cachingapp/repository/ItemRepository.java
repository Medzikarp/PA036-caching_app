package cz.fi.muni.pa036.cachingapp.repository;

import cz.fi.muni.pa036.cachingapp.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
public interface ItemRepository extends JpaRepository<InventoryItem, Long> {
}
