package dev.skyherobrine.sa_lab05.services.impl;

import dev.skyherobrine.sa_lab05.models.Product;
import dev.skyherobrine.sa_lab05.repositories.ProductRepository;
import dev.skyherobrine.sa_lab05.services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IServices<Product, Long> {

    @Autowired
    private ProductRepository pr;

    @Override
    public boolean save(Product entity) {
        try {
            pr.save(entity);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Product entity) {
        try {
            pr.save(entity);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Product product) {
        try {
            pr.delete(product);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Product> findById(Long aLong) {
        return pr.findById(aLong);
    }

    @Override
    public List<Product> findAll() {
        return pr.findAll();
    }
}
