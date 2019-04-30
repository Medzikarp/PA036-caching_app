package cz.fi.muni.pa036.cachingapp.service;

import cz.fi.muni.pa036.cachingapp.dto.BranchDTO;
import cz.fi.muni.pa036.cachingapp.entity.Branch;

import java.util.List;
import java.util.Optional;

public interface BranchService {

    Optional<BranchDTO> findById(Long id);

    List<Branch> listAllBranches();

    List<BranchDTO> listBranchesByCitiesLike(String citySubStr, Integer streetNumber);

}
