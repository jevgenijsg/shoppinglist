package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;

import java.util.Scanner;

public class FindProductByNameAction implements Action {

    private final static String ACTION_NAME = "Find by name";
    private final ProductService productService;

    public FindProductByNameAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = scanner.nextLine().toLowerCase();
        Product findProductResult = productService.findByName(name);
        System.out.println(findProductResult);
    }


    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
