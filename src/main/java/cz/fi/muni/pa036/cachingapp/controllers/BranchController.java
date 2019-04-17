package cz.fi.muni.pa036.cachingapp.controllers;

import cz.fi.muni.pa036.cachingapp.entity.Branch;
import cz.fi.muni.pa036.cachingapp.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
@RestController
@RequestMapping(value = "/branches")
public class BranchController {

    @Autowired
    BranchService branchService;


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Branch> listBranches() {
        return branchService.listAllBranches();
    }
}
