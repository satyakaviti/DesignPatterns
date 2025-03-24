package FactoryMethod.baseExample;

public class PizzaFactory {
    public static Pizza createPizza(String type) {
        switch (type.toLowerCase()) {
            case "cheese":
                return new CheesePizza();
            case "pepperoni":
                return new PepperoniPizza();
            default:
                throw new UnsupportedOperationException("Unsupported pizza type: " + type);
        }
    }
}
