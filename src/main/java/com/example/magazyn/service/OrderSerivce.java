package com.example.magazyn.service;

import com.example.magazyn.model.Account;
import com.example.magazyn.model.Order;
import com.example.magazyn.model.Product;
import com.example.magazyn.repository.OrderRepository;
import com.example.magazyn.repository.ProductRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderSerivce {

    private  final OrderRepository orderRepository;

    @Autowired
    public OrderSerivce(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getById(int id) {
        return orderRepository.findById(id);
    }

    public Order newOrder(Account account, Product product){

        Order order = new Order();
        order.setAccount(account);
        order.setProduct(product);

        return orderRepository.save(order);
    }
}
