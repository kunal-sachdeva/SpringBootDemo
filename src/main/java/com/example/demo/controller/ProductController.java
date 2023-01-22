package com.example.demo.controller;

import com.example.demo.exception.ProductNotfoundException;
import com.example.demo.model.Product;
import com.example.demo.service.ProductStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;

@RestController
public class ProductController {
    @Value("${owner.name}")
    private String ownerName;
    @Autowired
    private ProductStore productStore;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/init")
    public String Hello(){
        productStore.defaultProduct();
        return "initializing product Store. Please Add '/products' in URL to proceed further "+ownerName;
    }

    @RequestMapping(value="/products")
    public ResponseEntity<Object>getProducts(){

        if(null==productStore.getProducts() || productStore.getProducts().isEmpty()) {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.TEXT_PLAIN));
            HttpEntity<String> entity=new HttpEntity<>(headers);
            restTemplate.exchange("http://localhost:9090", HttpMethod.GET, entity, String.class);
        }
        return new ResponseEntity<>(productStore.getProducts(), HttpStatus.OK);
    }

    @RequestMapping(value="/products/{id}")
    public ResponseEntity<Object>getProductById(@PathVariable("id") Integer productId){
        return new ResponseEntity<>(productStore.getProducts(productId), HttpStatus.OK);
    }

    @RequestMapping(value="/products", method = RequestMethod.POST)
    public ResponseEntity<Object>createProduct(@RequestBody Product product){
        productStore.createProduct(product);
        return new ResponseEntity<>("Product is added succesfully", HttpStatus.OK);
    }

    @RequestMapping(value="/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object>removeProduct(@PathVariable("id") Integer productId){
        productStore.removeProduct(productId);
        return new ResponseEntity<>("Product Successfully removed from the list", HttpStatus.OK);
    }

    @RequestMapping(value="/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>updateProduct(@PathVariable("id") Integer productId, @RequestBody Product product){
        productStore.updateProduct(productId,product);
        return new ResponseEntity<>("Product Successfully updated in the list", HttpStatus.OK);
    }
    Product p = new Product();
    @RequestMapping(value="/test/wait", method = RequestMethod.GET)
    public ResponseEntity<Object>waitProduct() throws InterruptedException {
        System.out.println("Acquiring wait");
        synchronized(p) {
            p.wait();
        }
        return new ResponseEntity<>("wait is released", HttpStatus.OK);
    }
    @RequestMapping(value="/test/notify", method = RequestMethod.GET)
    public ResponseEntity<Object>notifyProduct() throws InterruptedException {
        synchronized (p) {
            p.notify();
        }
        return new ResponseEntity<>("notified!!", HttpStatus.OK);
    }
}
