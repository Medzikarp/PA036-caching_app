package cz.fi.muni.pa036.cachingapp.repository;

import cz.fi.muni.pa036.cachingapp.entity.Branch;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;


public interface BranchRepository extends JpaRepository<Branch, Long> {

    /*@Query (value = "SELECT column FROM Branch ORDER BY RANDOM() LIMIT 1",nativeQuery = true)
    Branch getRandomBranch(Pageable pageable);
    */

    @QueryHints(@QueryHint(name = "org.hibernate.cacheable", value = "true"))
    @Query("SELECT b FROM Branch b WHERE b.streetNumber = :streetNumber AND b.city = :city")
    @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
    List<Branch> findCitiesByParams(Integer streetNumber, String city);
    

}
