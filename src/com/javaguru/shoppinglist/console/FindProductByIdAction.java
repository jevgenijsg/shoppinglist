package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;

import java.util.Scanner;

public class FindProductByIdAction implements Action{

    private final static String ACTION_NAME = "Find by ID";

    private final ProductService productService;

    public FindProductByIdAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        long id = scanner.nextLong();
        Product findProductResult = productService.findById(id);
        System.out.println(findProductResult);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
