package cz.fi.muni.pa036.cachingapp.repository;

import cz.fi.muni.pa036.cachingapp.entity.InventoryRevision;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
public interface RevisionRepository extends JpaRepository<InventoryRevision, Long> {
}
