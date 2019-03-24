package cz.fi.muni.pa036.cachingapp.service;

import cz.fi.muni.pa036.cachingapp.entity.Branch;

import java.util.List;

public interface BranchService {

    void createBranch(Branch branch);

    List<Branch> listAllBranches();

    //Branch findRandomBranch();

}
