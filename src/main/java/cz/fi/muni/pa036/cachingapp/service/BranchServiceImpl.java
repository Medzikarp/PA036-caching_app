package cz.fi.muni.pa036.cachingapp.service;

import cz.fi.muni.pa036.cachingapp.dto.BranchDTO;
import cz.fi.muni.pa036.cachingapp.entity.Branch;
import cz.fi.muni.pa036.cachingapp.repository.BranchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BranchServiceImpl implements BranchService {

    private static final Logger logger = LoggerFactory.getLogger(BranchServiceImpl.class);

    private final BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public Optional<BranchDTO> findById(Long id) {
        return branchRepository.findById(id)
                .map(this::map);
    }

    @Override
    public List<Branch> listAllBranches () {
        return branchRepository.findAll();
    }

    @Override
    public List<BranchDTO> listBranchesByCitiesLike(String citySubStr, Integer streetNumber) {
        long startTime = System.currentTimeMillis();
        List<Branch> branches = branchRepository.findCitiesByParams(streetNumber, citySubStr);
        long endTime = System.currentTimeMillis();
        logger.info("Total execution time: " + (endTime-startTime) + "ms");

        List<BranchDTO> result = new ArrayList<>(branches.size());
        branches.forEach(b -> {

            result.add(map(b));
        });


        return result;
    }

    private BranchDTO map(Branch b) {
        BranchDTO dto = new BranchDTO();
        dto.setCity(b.getCity());
        dto.setId(b.getId());
        dto.setName(b.getName());
        dto.setStreet(b.getStreet());
        dto.setState(b.getState());
        dto.setStreetNumber(b.getStreetNumber());

        return dto;
    }
   /* public Branch findRandomBranch(){
        return branchRepository.getRandomBranch();
    }
    */

}
