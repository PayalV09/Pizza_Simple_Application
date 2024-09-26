package DeluxPizza;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pizzaorderapp {
	
	



	    static class Order {
	        String pizzaType;
	        int quantity;
	        int basePrice;
	        int extraCheesePrice;
	        int extraToppingsPrice;
	        int takeAwayCharge;

	        Order(String pizzaType, int quantity, int basePrice, int extraCheesePrice, int extraToppingsPrice, int takeAwayCharge) {
	            this.pizzaType = pizzaType;
	            this.quantity = quantity;
	            this.basePrice = basePrice;
	            this.extraCheesePrice = extraCheesePrice;
	            this.extraToppingsPrice = extraToppingsPrice;
	            this.takeAwayCharge = takeAwayCharge;
	        }

	        int calculateTotalPrice() {
	            return (basePrice + extraCheesePrice + extraToppingsPrice + takeAwayCharge) * quantity;
	        }

	        @Override
	        public String toString() {
	            return pizzaType + " (Qty: " + quantity + "): Base Price: ₹" + basePrice + ", Extra Cheese: ₹" + extraCheesePrice + ", Extra Toppings: ₹" + extraToppingsPrice + ", Take Away Charge: ₹" + takeAwayCharge + ", Total: ₹" + calculateTotalPrice();
	        }
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        List<Order> orders = new ArrayList<>();

	        // Pizza Prices
	        int vegPizzaPrice = 300;
	        int nonVegPizzaPrice = 400;
	        int deluxVegPizzaPrice = 550;
	        int deluxNonVegPizzaPrice = 650;
	        int extraCheesePrice = 100;
	        int extraToppingsPrice = 150;
	        int takeAwayCharge = 20;
	        int discountThreshold = 1000; // Apply discount if total price exceeds this amount
	        double discountRate = 0.10;   // 10% discount

	        System.out.println("Welcome to the Pizza Ordering System!");

	        boolean ordering = true;
	        while (ordering) {
	            System.out.println("\nPlease select the type of pizza:");
	            System.out.println("1. Veg Pizza - ₹" + vegPizzaPrice);
	            System.out.println("2. Non-Veg Pizza - ₹" + nonVegPizzaPrice);
	            System.out.println("3. Delux Veg Pizza (Loaded with extra cheese & extra toppings) - ₹" + deluxVegPizzaPrice);
	            System.out.println("4. Delux Non-Veg Pizza (Loaded with extra cheese & extra toppings) - ₹" + deluxNonVegPizzaPrice);
	            System.out.println("5. Finish Ordering");

	            int pizzaType = scanner.nextInt();
	            if (pizzaType == 5) {
	                break;
	            }

	            System.out.println("Enter the quantity:");
	            int quantity = scanner.nextInt();
	            int basePrice = 0, extraCheeseCost = 0, extraToppingsCost = 0, takeAwayCost = 0;
	            String pizzaName = "";

	            switch (pizzaType) {
	                case 1: // Veg Pizza
	                    basePrice = vegPizzaPrice;
	                    pizzaName = "Veg Pizza";
	                    System.out.println("Do you want Extra Cheese? (100₹) (yes/no)");
	                    String cheeseChoice = scanner.next();
	                    if (cheeseChoice.equalsIgnoreCase("yes")) {
	                        extraCheeseCost = extraCheesePrice;
	                    }
	                    System.out.println("Do you want Extra Toppings? (150₹) (yes/no)");
	                    String toppingsChoice = scanner.next();
	                    if (toppingsChoice.equalsIgnoreCase("yes")) {
	                        extraToppingsCost = extraToppingsPrice;
	                    }
	                    break;

	                case 2: // Non-Veg Pizza
	                    basePrice = nonVegPizzaPrice;
	                    pizzaName = "Non-Veg Pizza";
	                    System.out.println("Do you want Extra Cheese? (100₹) (yes/no)");
	                    cheeseChoice = scanner.next();
	                    if (cheeseChoice.equalsIgnoreCase("yes")) {
	                        extraCheeseCost = extraCheesePrice;
	                    }
	                    System.out.println("Do you want Extra Toppings? (150₹) (yes/no)");
	                    toppingsChoice = scanner.next();
	                    if (toppingsChoice.equalsIgnoreCase("yes")) {
	                        extraToppingsCost = extraToppingsPrice;
	                    }
	                    break;

	                case 3: // Delux Veg Pizza
	                    basePrice = deluxVegPizzaPrice;
	                    pizzaName = "Delux Veg Pizza";
	                    System.out.println("Delux Veg Pizza already includes extra cheese & toppings.");
	                    break;

	                case 4: // Delux Non-Veg Pizza
	                    basePrice = deluxNonVegPizzaPrice;
	                    pizzaName = "Delux Non-Veg Pizza";
	                    System.out.println("Delux Non-Veg Pizza already includes extra cheese & toppings.");
	                    break;

	                default:
	                    System.out.println("Invalid choice! Please select a valid pizza type.");
	                    continue;
	            }

	            // Ask for take away option
	            System.out.println("Do you want to opt for take away? (20₹) (yes/no)");
	            String takeAwayChoice = scanner.next();
	            if (takeAwayChoice.equalsIgnoreCase("yes")) {
	                takeAwayCost = takeAwayCharge;
	            }

	            // Add order to the list
	            orders.add(new Order(pizzaName, quantity, basePrice, extraCheeseCost, extraToppingsCost, takeAwayCost));

	            System.out.println("Do you want to order another pizza? (yes/no)");
	            String continueOrdering = scanner.next();
	            if (continueOrdering.equalsIgnoreCase("no")) {
	                ordering = false;
	            }
	        }

	        // Generate the bill
	        int totalBill = 0;
	        System.out.println("\nOrder Summary:");
	        for (Order order : orders) {
	            System.out.println(order);
	            totalBill += order.calculateTotalPrice();
	        }

	        // Apply discount if applicable
	        if (totalBill > discountThreshold) {
	            double discount = totalBill * discountRate;
	            totalBill -= discount;
	            System.out.println("\nCongratulations! You've received a discount of 10%: -₹" + discount);
	        }

	        System.out.println("\nYour final bill is: ₹" + totalBill);
	        System.out.println("Thank you for ordering! Enjoy your meal!");

	        scanner.close();
	    }
	}
