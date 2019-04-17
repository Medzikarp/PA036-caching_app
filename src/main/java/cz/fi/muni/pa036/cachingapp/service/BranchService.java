package cz.fi.muni.pa036.cachingapp.service;

import cz.fi.muni.pa036.cachingapp.entity.Branch;

import java.util.List;

public interface BranchService {

    void createBranch();

    List<Branch> findAll();
    //Branch findRandomBranch();

}
