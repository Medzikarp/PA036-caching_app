package cz.fi.muni.pa036.cachingapp.repository;

import cz.fi.muni.pa036.cachingapp.entity.Branch;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BranchRepository extends JpaRepository<Branch, Long> {

    /*@Query (value = "SELECT column FROM Branch ORDER BY RANDOM() LIMIT 1",nativeQuery = true)
    Branch getRandomBranch(Pageable pageable);
*/
    

}
