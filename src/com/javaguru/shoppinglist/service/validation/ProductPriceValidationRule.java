package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductPriceValidationRule implements ProductValidationRule{

        private final BigDecimal minimumAcceptablePrice = BigDecimal.valueOf(1.0);
    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if(product.getPrice().compareTo(minimumAcceptablePrice) < 0){
            throw new ProductValidationException("Price cannot be (0)zero");
        }
    }
}
