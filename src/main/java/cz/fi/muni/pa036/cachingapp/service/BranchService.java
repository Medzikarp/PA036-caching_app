package cz.fi.muni.pa036.cachingapp.service;

import cz.fi.muni.pa036.cachingapp.entity.Branch;

public interface BranchService {

    void createBranch();

    Branch findRandomBranch();

}
