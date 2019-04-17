package cz.fi.muni.pa036.cachingapp.service;

import cz.fi.muni.pa036.cachingapp.entity.Branch;
import cz.fi.muni.pa036.cachingapp.repository.BranchRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    BranchRepository branchRepository;

    private static List<Branch> branches = new ArrayList<>();

    static {

        for (int i = 0; i  < 50; i++){
            Branch x = new Branch("abcdsa");
            branches.add(x);
        }

    }

    public void createBranch() {

        for (int i = 0; i  < 50; i++){
            branchRepository.save(branches.get(i));

        }
    }

    public List<Branch> findAll() {
        return branchRepository.findAll();
    }

   /* public Branch findRandomBranch(){
        return branchRepository.getRandomBranch();
    }
    */

}
