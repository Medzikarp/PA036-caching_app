package cz.fi.muni.pa036.cachingapp.repository;

import cz.fi.muni.pa036.cachingapp.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
public interface ItemRepository extends JpaRepository<InventoryItem, Long> {

    @Query("SELECT i FROM InventoryItem i WHERE i.dateFrom >= :dateFrom AND i.dateTo <=:dateTo")
    List<InventoryItem> findAllWithIntervalBetween(
            @Param("dateFrom") LocalDate dateFrom,
            @Param("dateTo") LocalDate dateTo);

}
