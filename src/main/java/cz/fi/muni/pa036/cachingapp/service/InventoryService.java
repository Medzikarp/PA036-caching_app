package cz.fi.muni.pa036.cachingapp.service;

import cz.fi.muni.pa036.cachingapp.entity.InventoryItem;
import cz.fi.muni.pa036.cachingapp.entity.InventoryRevision;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
public interface InventoryService {

    List<InventoryItem> listInventoryItemsBetween(LocalDate dateFrom, LocalDate dateTo);

    List<InventoryRevision> listProblematicRevisions(Integer minimumIssues);
}
