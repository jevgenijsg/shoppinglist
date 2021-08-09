package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 0L;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        System.out.println("Enter product name: ");
                        String name = scanner.nextLine();
                        System.out.println("Please enter one of category: ");
                        for (Category category: Category.values()) {
                            System.out.println(category);
                        }
                        String category = scanner.nextLine().toUpperCase();
                        System.out.println("Enter product description: ");
                        String description = scanner.nextLine();
                        System.out.println("Enter product price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        System.out.println("Enter discount in %: ");
                        BigDecimal discount = new BigDecimal(scanner.nextLine());

                        Product product = new Product();

                        product.setName(name);
                        product.setCategory(Category.valueOf(category));
                        product.setDescription(description);
                        product.setPrice(price);
                        product.setDiscount(discount);
                        product.setId(productIdSequence);
                        productRepository.put(productIdSequence, product);
                        productIdSequence++;
                        System.out.println("Result: " + product.getId());
                        break;
                    case 2:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        Product findProductResult = productRepository.get(id);
                        System.out.println(findProductResult);
                        break;
                    case 3:
                        return ;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
