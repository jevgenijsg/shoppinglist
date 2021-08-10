package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.service.ProductService;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class ConsoleUI {

    private final List<Action> actions = new ArrayList<>();

    public void start(){
        ProductService productService = new ProductService();
        Action exitAction = new ExitAction();
        Action createProductAction = new CreateProductAction(productService);
        Action findProductByIdAction = new FindProductByIdAction(productService);
        actions.add(createProductAction);
        actions.add(findProductByIdAction);
        actions.add(exitAction);
        readUserInput();
    }

    private void printMenu(){
        for(int i = 0; i < actions.size(); i++){
            System.out.printf(i + ". " + actions.get(i) + "\n");
        }
    }

    private void readUserInput(){
        Scanner scanner = new Scanner(System.in);

        int userResponse = 0;
        if(userResponse < 0 || userResponse > actions.size()){
            throw new IllegalArgumentException("Incorrect input");
        }

        while(userResponse >=0){
            printMenu();
            try {
                userResponse = Integer.parseInt(scanner.nextLine());
                actions.get(userResponse).execute();
            } catch (Exception e){
                System.out.printf(e.getMessage());
            }
        }
    }
}
