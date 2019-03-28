package cz.fi.muni.pa036.cachingapp.service;

import cz.fi.muni.pa036.cachingapp.repository.ItemRepository;
import cz.fi.muni.pa036.cachingapp.repository.RevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
@Service
@Transactional
public class InventoryServiceImpl {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    RevisionRepository revisionRepository;
}
