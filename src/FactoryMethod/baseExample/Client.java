package FactoryMethod.baseExample;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Pizza Factory!");
        System.out.println("Available options: cheese, pepperoni");
        System.out.print("Enter the type of pizza you'd like: ");

        String name = sc.nextLine().trim().toLowerCase(); // Normalize input

        Pizza pizza;

        switch (name) {
            case "cheese":
                pizza = PizzaFactory.createPizza("cheese");
                break;
            case "pepperoni":
                pizza = PizzaFactory.createPizza("pepperoni");
                break;
            default:
                System.out.println("Invalid pizza type. Please try again!");
                return; // Exit the program
        }

        // Process the pizza
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        System.out.println("Your pizza is ready! Enjoy!");
    }
}
