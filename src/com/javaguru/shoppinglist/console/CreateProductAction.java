package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Category;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;

import java.math.BigDecimal;
import java.util.Scanner;

public class CreateProductAction implements Action{

    private static final String ACTION_NAME = "Create Product";
    private final ProductService productService;

    public CreateProductAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        Product product = new Product();

        System.out.println("Enter product name: ");
        String name = scanner.nextLine().toLowerCase();
        System.out.println("Please enter one of category: ");
        for (Category category : Category.values()) {
            System.out.println(category);
        }
        String category = scanner.nextLine().toUpperCase();
        System.out.println("Enter product description: ");
        String description = scanner.nextLine();
        System.out.println("Enter product price: ");
        String price = scanner.nextLine();
        System.out.println("Enter discount in %: ");
        String discount = scanner.nextLine();

        product.setName(name);
        product.setCategory(Category.valueOf(category));
        product.setDescription(description);
        product.setPrice(new BigDecimal(price));
        product.setDiscount(new BigDecimal(discount));

        try{
            Long response = productService.createProduct(product);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}


