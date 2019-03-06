package cz.fi.muni.pa036.cachingapp.repository;

import cz.fi.muni.pa036.cachingapp.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import static org.hibernate.loader.Loader.SELECT;

public interface BranchRepository extends JpaRepository<Branch, Long> {

    @Query ("SELECT column FROM Branch ORDER BY RANDOM() LIMIT 1")
    Branch getRandomBranch();

    

}
