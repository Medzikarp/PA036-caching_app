package cz.fi.muni.pa036.cachingapp.controllers;

import cz.fi.muni.pa036.cachingapp.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
@RestController
public class BranchController {

    @Autowired
    BranchService branchService;

    @RequestMapping(value = "/branch/create", method = RequestMethod.GET)
    public void createBranch() {
        branchService.createBranch();

    }
}
