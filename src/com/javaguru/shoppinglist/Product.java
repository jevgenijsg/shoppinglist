package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal discount;
    private String description;
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if(price.doubleValue() <= 0){
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        if(discount.doubleValue() > 100){
            throw new IllegalArgumentException("Percentage discount cannot be more than 100%");
        }
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description.length() < 3 || description.length() > 32){
            throw new IllegalArgumentException("Description must be more than 3 and less than 32 characters");
        }
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id.equals(product.id) && name.equals(product.name) && price.equals(product.price)
                && discount.equals(product.discount) && description.equals(product.description)
                && category == product.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, discount, description, category);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }
}