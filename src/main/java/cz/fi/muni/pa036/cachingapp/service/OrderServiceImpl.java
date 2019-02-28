package cz.fi.muni.pa036.cachingapp.service;

import cz.fi.muni.pa036.cachingapp.entity.Order;
import cz.fi.muni.pa036.cachingapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marek Perichta <mperichta@cesnet.cz>
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    private static List<Order> orders = new ArrayList<>();

    static {
        Order order = new Order("abcdsa");
        orders.add(order);
    }

    public void createOrder() {
        orderRepository.save(orders.get(0));
    }
}
