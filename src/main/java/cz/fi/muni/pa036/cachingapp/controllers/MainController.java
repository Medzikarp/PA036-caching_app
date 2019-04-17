package cz.fi.muni.pa036.cachingapp.controllers;

import cz.fi.muni.pa036.cachingapp.entity.Branch;
import cz.fi.muni.pa036.cachingapp.entity.InventoryItem;
import cz.fi.muni.pa036.cachingapp.entity.InventoryRevision;
import cz.fi.muni.pa036.cachingapp.service.BranchService;
import cz.fi.muni.pa036.cachingapp.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
@RestController
public class MainController {

    @Autowired
    BranchService branchService;

    @Autowired
    InventoryService inventoryService;

    /**
     * Using like http://localhost:8090/revisions/problematic
     */
    @RequestMapping(value = "/revisions/problematic", method = RequestMethod.GET)
    public List<InventoryRevision> listProblematicRevisions() {
        List<InventoryRevision> revisions = inventoryService.listProblematicRevisions(4);
        return revisions;
    }


    /**
     * Using like http://localhost:8090/items/between?from=2015-08-24@to=2016-07-14
     */
    @RequestMapping(value = "/items/between", method = RequestMethod.GET)
    public List<InventoryItem> listInventoryItemsBetween(
            @RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate dateFrom,
            @RequestParam("to") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate dateTo) {
        List<InventoryItem> items = inventoryService.listInventoryItemsBetween(dateFrom, dateTo);
        return items;
    }

    /**
     * Using like http://localhost:8090/branches/city?search=bra
     */
    @RequestMapping(value = "/branches/city", method = RequestMethod.GET)
    public List<Branch> listBranchesByCitiesLike(
            @RequestParam("search") String search) {
        List<Branch> branches = branchService.listBranchesByCitiesLike(search);
        return branches;
    }



}



