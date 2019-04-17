package cz.fi.muni.pa036.cachingapp.service;

import cz.fi.muni.pa036.cachingapp.entity.Branch;
import cz.fi.muni.pa036.cachingapp.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BranchServiceImpl implements BranchService {

    @Autowired
    BranchRepository branchRepository;


    public void createBranch(Branch branch) {

        for (int i = 0; i  < 50; i++){
            branchRepository.save(branchRepository.saveAndFlush(branch));

        }
    }

    public List<Branch> listAllBranches () {
        List<Branch> allBranches = branchRepository.findAll();
        return allBranches;
    }

   /* public Branch findRandomBranch(){
        return branchRepository.getRandomBranch();
    }
    */

}
