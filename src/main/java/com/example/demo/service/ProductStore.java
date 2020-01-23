package com.example.demo.service;

import com.example.demo.exception.ProductNotfoundException;
import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductStore implements ProductService{
    private static Map<Integer, Product> productMap = new HashMap<>();
    static {
        Product honey = new Product(1,"Honey");
        Product almond = new Product(2,"Almond");
        productMap.put(honey.getId(),honey);
        productMap.put(almond.getId(),almond);
    }

    @Override
    public void createProduct(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public void removeProduct(Integer id) {
        productMap.remove(id);
    }

    @Override
    public void updateProduct(Integer id, Product product)  {
        if(!productMap.containsKey(id))
            throw new ProductNotfoundException();

        productMap.remove(id);
        productMap.put(id,product);
    }

    @Override
    public Collection<Product> getProducts() {
        return productMap.values();
    }

    @Override
    public Product getProducts(Integer id) {
        return productMap.get(id);
    }
}
