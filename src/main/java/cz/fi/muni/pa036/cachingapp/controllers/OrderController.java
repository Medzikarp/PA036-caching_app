package cz.fi.muni.pa036.cachingapp.controllers;

import cz.fi.muni.pa036.cachingapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/order/create", method = RequestMethod.GET)
    public void createQuestion() {
        orderService.createOrder();
    }
}
