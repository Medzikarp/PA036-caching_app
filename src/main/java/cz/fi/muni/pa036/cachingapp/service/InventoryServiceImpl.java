package cz.fi.muni.pa036.cachingapp.service;

import cz.fi.muni.pa036.cachingapp.entity.InventoryItem;
import cz.fi.muni.pa036.cachingapp.entity.InventoryRevision;
import cz.fi.muni.pa036.cachingapp.repository.ItemRepository;
import cz.fi.muni.pa036.cachingapp.repository.RevisionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

    private static final Logger logger = LoggerFactory.getLogger(InventoryServiceImpl.class);


    @Autowired
    ItemRepository itemRepository;

    @Autowired
    RevisionRepository revisionRepository;


    @Override
    public List<InventoryItem> listInventoryItemsBetween(LocalDate dateFrom, LocalDate dateTo) {
        logger.info(".... Fetching inventory items for interval: " + dateFrom.toString() + " - " + dateTo.toString());
        long startTime = System.currentTimeMillis();
        List<InventoryItem> items = itemRepository.findAllWithIntervalBetween(dateFrom, dateTo);
        long endTime = System.currentTimeMillis();
        logger.info("Total execution time: " + (endTime-startTime) + "ms");
        return items;
    }

    @Override
    public List<InventoryRevision> listProblematicRevisions(Integer minimumIssues) {
        logger.info(".... Fetching problematic revisions with at least " + minimumIssues + " issues.");
        long startTime = System.currentTimeMillis();
        List<InventoryRevision> revisions =  revisionRepository.findAllWithNumberOfIssues(minimumIssues);
        long endTime = System.currentTimeMillis();
        logger.info("Total execution time: " + (endTime-startTime) + "ms");
        return revisions;
    }
}
