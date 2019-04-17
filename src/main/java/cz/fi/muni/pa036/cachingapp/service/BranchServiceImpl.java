package cz.fi.muni.pa036.cachingapp.service;

import cz.fi.muni.pa036.cachingapp.entity.Branch;
import cz.fi.muni.pa036.cachingapp.repository.BranchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BranchServiceImpl implements BranchService {

    private static final Logger logger = LoggerFactory.getLogger(BranchServiceImpl.class);

    @Autowired
    BranchRepository branchRepository;


    public List<Branch> listAllBranches () {
        List<Branch> allBranches = branchRepository.findAll();
        return allBranches;
    }

    public List<Branch> listBranchesByCitiesLike (String citySubStr) {
        long startTime = System.currentTimeMillis();
        List<Branch> branches = branchRepository.findByCityContaining(citySubStr);
        long endTime = System.currentTimeMillis();
        logger.info("Total execution time: " + (endTime-startTime) + "ms");
        return branches;
    }

   /* public Branch findRandomBranch(){
        return branchRepository.getRandomBranch();
    }
    */

}
