package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import java.util.HashMap;
import java.util.Map;

public class ProductInMemoryRepository {

    private Long PRODUCT_ID_SEQUENCE = 0L;
    Map<Long, Product> productRepository = new HashMap<>();

    public Product insertProduct(Product product) {
        product.setId(PRODUCT_ID_SEQUENCE);
        productRepository.put(PRODUCT_ID_SEQUENCE, product);
        PRODUCT_ID_SEQUENCE++;
        System.out.println("Product created, id : " + product.getId());
        return product;
    }

    public Product findProductById(Long id){
      return productRepository.get(id);
    }

    public Product findProductByName(String name){
        Product productFound = new Product();
        for(Map.Entry<Long, Product> lookUp :productRepository.entrySet()){
            if(lookUp.getValue().getName().equalsIgnoreCase(name)){
                productFound = lookUp.getValue();
            }
        }
        return productFound;
    }

    public Map<Long, Product> getProductRepository() {
        return productRepository;
    }
}
