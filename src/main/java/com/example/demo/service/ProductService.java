package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.Collection;

public interface ProductService {
    public void createProduct(Product product);
    public void removeProduct(Integer id);
    public void updateProduct(Integer id, Product product);
    public Collection<Product> getProducts();
    public Product getProducts(Integer id);
}
