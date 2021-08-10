package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductDiscountValidationRule implements ProductValidationRule{

    private static  BigDecimal minimumDiscount  = BigDecimal.valueOf(0.0);
    private static  BigDecimal maximumDiscount  = BigDecimal.valueOf(100.0);
    private static  BigDecimal acceptablePriceForDiscount = BigDecimal.valueOf(20.0);


    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if(product.getDiscount().compareTo(minimumDiscount) < 0){
            throw new ProductValidationException("Discount cannot be less than (0)zero");
        }
        if(product.getDiscount().compareTo(maximumDiscount) > 0){
            throw new ProductValidationException("Discount cannot be more than 100");
        }
        if(product.getPrice().compareTo(acceptablePriceForDiscount) < 0){
            product.setDiscountedPrice(product.getPrice());
        }
    }
}
