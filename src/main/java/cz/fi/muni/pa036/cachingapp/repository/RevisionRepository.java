package cz.fi.muni.pa036.cachingapp.repository;

import cz.fi.muni.pa036.cachingapp.entity.InventoryRevision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
public interface RevisionRepository extends JpaRepository<InventoryRevision, Long> {

    @Query("SELECT DISTINCT r FROM InventoryRevision r " +
            "JOIN FETCH  r.issues issue " +
            "JOIN FETCH issue.item item " +
            "WHERE SIZE(r.issues) >= :minimumIssues")
    List<InventoryRevision> findAllWithNumberOfIssues(Integer minimumIssues);
}
