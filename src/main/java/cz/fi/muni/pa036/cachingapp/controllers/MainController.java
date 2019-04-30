package cz.fi.muni.pa036.cachingapp.controllers;

import cz.fi.muni.pa036.cachingapp.dto.BranchDTO;
import cz.fi.muni.pa036.cachingapp.entity.InventoryItem;
import cz.fi.muni.pa036.cachingapp.entity.InventoryRevision;
import cz.fi.muni.pa036.cachingapp.service.BranchService;
import cz.fi.muni.pa036.cachingapp.service.InventoryService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
@RestController
public class MainController {

    private final BranchService branchService;
    private final InventoryService inventoryService;

    public MainController(BranchService branchService,
        InventoryService inventoryService) {
        this.branchService = branchService;
        this.inventoryService = inventoryService;
    }

    /**
     * Using like http://localhost:8090/revisions/problematic
     */
    @GetMapping("/revisions/problematic")
    public List<InventoryRevision> listProblematicRevisions() {
        List<InventoryRevision> revisions = inventoryService.listProblematicRevisions(4);
        return revisions;
    }


    /**
     * Using like http://localhost:8090/items/between?from=2015-08-24@to=2016-07-14
     */
    @GetMapping("/items/between")
    public List<InventoryItem> listInventoryItemsBetween(
            @RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate dateFrom,
            @RequestParam("to") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate dateTo) {
        List<InventoryItem> items = inventoryService.listInventoryItemsBetween(dateFrom, dateTo);
        return items;
    }

    /**
     * Using like http://localhost:8090/branches/city?search=bra
     */
    @GetMapping("/branches/city")
    public List<BranchDTO> listBranchesByCitiesLike(
            @RequestParam("search") String search, @RequestParam Integer streetNumber) {
        return branchService.listBranchesByCitiesLike(search, streetNumber);
    }

    @GetMapping("/branches/{id}")
    public ResponseEntity<BranchDTO> byId(@PathVariable Long id) {
        return ResponseEntity.of(branchService.findById(id));
    }
}



