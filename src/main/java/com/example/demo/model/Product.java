package com.example.demo.model;

import java.util.Objects;

public class Product {
    int id;
    String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Product(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId() == product.getId() &&
                getName().equals(product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId());
    }
}
