package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import java.util.HashSet;
import java.util.Set;

public class ProductValidationService {

    private Set<ProductValidationRule> validationRules = new HashSet<>();
    ProductInMemoryRepository productRepository;

    public ProductValidationService(ProductInMemoryRepository productRepository) {
        this.productRepository = productRepository;
        validationRules.add(new ProductNameValidationRule(productRepository));
        validationRules.add((new ProductPriceValidationRule()));
        validationRules.add(new ProductDiscountValidationRule());
    }

    public void validate(Product product){
        validationRules.forEach(s->s.validate(product));
    }

    public void validateId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID must not be null");
        }
    }
}
