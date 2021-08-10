package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;

import java.math.BigDecimal;

public class ProductService {

    private ProductInMemoryRepository repository = new ProductInMemoryRepository();
    private ProductValidationService validationService = new ProductValidationService(repository);

    public Long createProduct(Product product) {
        calculateDiscountedPrice(product);
        validationService.validate(product);
        Product createdProduct = repository.insertProduct(product);
        return createdProduct.getId();
    }

    public Product findById(Long id){
        validationService.validateId(id);
        return repository.findProductById(id);
    }

    public Product findByName(String name){
        return  repository.findProductByName(name);
    }

    public void calculateDiscountedPrice(Product product){
        BigDecimal discountValue  = product.getPrice().multiply(product.getDiscount().divide(BigDecimal.valueOf(100.0)));
        BigDecimal discountedPrice = product.getPrice().subtract(discountValue);
        product.setDiscountedPrice(discountedPrice);
    }
}
