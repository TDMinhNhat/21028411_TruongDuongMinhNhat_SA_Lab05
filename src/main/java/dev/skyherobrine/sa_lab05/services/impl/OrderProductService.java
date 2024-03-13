package dev.skyherobrine.sa_lab05.services.impl;

import dev.skyherobrine.sa_lab05.models.OrderProduct;
import dev.skyherobrine.sa_lab05.repositories.OrderProductRepository;
import dev.skyherobrine.sa_lab05.services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderProductService implements IServices<OrderProduct, Long> {

    private OrderProductRepository orderProductRepository;

    @Autowired
    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public boolean save(OrderProduct entity) {
        try {
            orderProductRepository.save(entity);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(OrderProduct entity) {
        try {
            orderProductRepository.save(entity);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(OrderProduct orderProduct) {
        try {
            orderProductRepository.delete(orderProduct);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<OrderProduct> findOne(Long aLong) {
        return orderProductRepository.findById(aLong);
    }

    @Override
    public List<OrderProduct> findAll() {
        return orderProductRepository.findAll();
    }
}
