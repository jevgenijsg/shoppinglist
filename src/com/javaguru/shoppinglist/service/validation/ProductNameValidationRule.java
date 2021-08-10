package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;

public class ProductNameValidationRule implements ProductValidationRule {

    ProductInMemoryRepository repository;
    private final int minLength = 3;
    private final int maxLength = 32;

    public ProductNameValidationRule(ProductInMemoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if(product.getName() == null){
            throw new ProductValidationException("Product name cannot be null");
        }
        if((!repository.getProductRepository().isEmpty()) &&
                repository.findProductByName(product.getName()).getName().equalsIgnoreCase(product.getName())){
            throw new ProductValidationException("Product name already exists");
        }
        if(product.getName().length() < minLength || product.getName().length() > maxLength){
            throw new ProductValidationException("Name must be not less than 3 and not more than 32 symbols");
        }
    }
}
