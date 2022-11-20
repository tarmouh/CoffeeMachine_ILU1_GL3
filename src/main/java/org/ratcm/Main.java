package org.ratcm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.ratcm.exceptions.*;

public class Main {
	private static CoffeeMaker coffeeMaker;

	/**
	 * Prints the main menu and handles user input for main menu commands.
	 */
	public static void mainMenu() {
		System.out.println("1. Add a recipe");
		System.out.println("2. Delete a recipe");
		System.out.println("3. Edit a recipe");
		System.out.println("4. Add inventory");
		System.out.println("5. Check inventory");
		System.out.println("6. Make coffee");
		System.out.println("0. Exit\n");

		// Get user input
		try {
			int userInput = Integer.parseInt(inputOutput(
					"Please press the number that corresponds to what you would like the coffee maker to do."));

			if (userInput >= 0 && userInput <= 6) {
				switch (userInput) {
				case 0:
					System.exit(0);
					break;
				case 1:
					addRecipe();
					break;
				case 2:
					deleteRecipe();
					break;
				case 3:
					editRecipe();
					break;
				case 4:
					addInventory();
					break;
				case 5:
					checkInventory();
					break;
				case 6:
					makeCoffee();
					break;
				default:
					break;
				}
			} else {
				System.out.println("Please enter a number from 0 - 6");
			}
		} catch (NumberFormatException e) {
			System.out.println("Please enter a number from 0 - 6");
		} finally {
			mainMenu();
		}
	}

	/**
	 * The add recipe user interface that process user input.
	 */
	public static void addRecipe() {
	    String name = inputOutput("\nPlease enter the recipe name: ");
		Recipe r = createRecipeFromInput();
		r.setName(name);

		boolean recipeAdded = coffeeMaker.addRecipe(r);

		if (recipeAdded) {
			System.out.println(r.getName() + " successfully added.\n");
		} else {
			System.out.println(r.getName() + " could not be added.\n");
		}
		mainMenu();
	}

	/**
	 * Delete recipe user interface that processes input.
	 */
	public static void deleteRecipe() {
		Recipe[] recipes = coffeeMaker.getRecipes();
		for (int i = 0; i < recipes.length; i++) {
			if (recipes[i] != null) {
				System.out.println((i + 1) + ". " + recipes[i].getName());
			}
		}
		int recipeToDelete = recipeListSelection("Please select the number of the recipe to delete.");

		if (recipeToDelete >= 0) {
			String recipeDeleted = coffeeMaker.deleteRecipe(recipeToDelete);

			if (recipeDeleted != null) {
				System.out.println(recipeDeleted + " successfully deleted.\n");
			} else {
				System.out.println("Selected recipe doesn't exist and could not be deleted.\n");
			}
		}
		mainMenu();
	}

	/**
	 * Edit recipe user interface the processes user input.
	 */
	public static void editRecipe() {
		Recipe[] recipes = coffeeMaker.getRecipes();
		for (int i = 0; i < recipes.length; i++) {
			if (recipes[i] != null) {
				System.out.println((i + 1) + ". " + recipes[i].getName());
			}
		}
		int recipeToEdit = recipeListSelection("Please select the number of the recipe to edit.");

		if (recipeToEdit >= 0) {
			Recipe newRecipe = createRecipeFromInput();
			String recipeEdited = coffeeMaker.editRecipe(recipeToEdit, newRecipe);

			if (recipeEdited != null) {
				System.out.println(recipeEdited + " successfully edited.\n");
			} else {
				System.out.println(recipeEdited + "could not be edited.\n");
			}
		}
		mainMenu();
	}

	private static Recipe createRecipeFromInput() {
		// Read in recipe price
		String priceString = inputOutput("\nPlease enter the recipe price: $");
		int priceQty = parseQuantity(priceString);

		// Read in amt coffee
		String coffeeString = inputOutput("\nPlease enter the units of coffee in the recipe: ");
		int coffeeQty = parseQuantity(coffeeString);

		// Read in amt milk
		String milkString = inputOutput("\nPlease enter the units of milk in the recipe: ");
		int milkQty = parseQuantity(milkString);

		// Read in amt sugar
		String sugarString = inputOutput("\nPlease enter the units of sugar in the recipe: ");
		int sugarQty = parseQuantity(sugarString);

		// Read in amt chocolate
		String chocolateString = inputOutput("\nPlease enter the units of chocolate in the recipe: ");
		int chocolateQty = parseQuantity(chocolateString);

		Recipe newRecipe = new Recipe();
		newRecipe.setPrice(priceQty);
		newRecipe.setAmtCoffee(coffeeQty);
		newRecipe.setAmtMilk(milkQty);
		newRecipe.setAmtSugar(sugarQty);
		newRecipe.setAmtChocolate(chocolateQty);
		return newRecipe;
	}

	/**
	 * Add inventory user interface that processes input.
	 */
	public static void addInventory() {
		// Read in amt coffee
		String coffeeString = inputOutput("\nPlease enter the units of coffee to add: ");
		int coffeeQty = parseQuantity(coffeeString);

		// Read in amt milk
		String milkString = inputOutput("\nPlease enter the units of milk to add: ");
		int milkQty = parseQuantity(milkString);

		// Read in amt sugar
		String sugarString = inputOutput("\nPlease enter the units of sugar to add: ");
		int sugarQty = parseQuantity(sugarString);

		// Read in amt chocolate
		String chocolateString = inputOutput("\nPlease enter the units of chocolate to add: ");
		int chocolateQty = parseQuantity(chocolateString);

		try {
			coffeeMaker.addInventory(coffeeQty, milkQty, sugarQty, chocolateQty);
			System.out.println("Inventory successfully added");
		} catch (InventoryException e) {
			System.out.println("Inventory was not added");
		} finally {
			mainMenu();
		}
	}

	private static int parseQuantity(String qtyString) {
		int quantity = 0;
		try {
			quantity = Integer.parseInt(qtyString);
		} catch (NumberFormatException e) {
			return 0;
		}
		if (quantity >= 0) {
			return quantity;
		} else {
			return 0;
		}

	}

	/**
	 * Check inventory user interface that processes input.
	 */
	public static void checkInventory() {
		System.out.println(coffeeMaker.checkInventory());
		mainMenu();
	}

	/**
	 * Make coffee user interface the processes input.
	 */
	public static void makeCoffee() {
		Recipe[] recipes = coffeeMaker.getRecipes();
		for (int i = 0; i < recipes.length; i++) {
			if (recipes[i] != null) {
				System.out.println((i + 1) + ". " + recipes[i].getName());
			}
		}

		int recipeToPurchase = recipeListSelection("Please select the number of the recipe to purchase.");

		String amountPaid = inputOutput("Please enter the amount you wish to pay");
		int amtPaid = 0;
		try {
			amtPaid = Integer.parseInt(amountPaid);

			int change = coffeeMaker.makeCoffee(recipeToPurchase, amtPaid);

			if (change == amtPaid) {
				System.out.println("Insufficient funds to purchase.");
			} else {
				System.out.println("Thank you for purchasing " + coffeeMaker.getRecipes()[recipeToPurchase].getName());
			}
			System.out.println("Your change is: " + change + "\n");
		} catch (NumberFormatException e) {
			System.out.println("Please enter a positive integer");
		} finally {
			mainMenu();
		}
	}

	/**
	 * Passes a prompt to the user and returns the user specified string.
	 * 
	 * @param message
	 * @return String
	 */
	private static String inputOutput(String message) {
		System.out.println(message);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String returnString = "";
		try {
			returnString = br.readLine();
		} catch (IOException e) {
			System.out.println("Error reading in value");
			mainMenu();
		}
		return returnString;
	}

	/**
	 * Passes a prompt to the user that deals with the recipe list and returns the
	 * user selected number.
	 * 
	 * @param message
	 * @return int
	 */
	private static int recipeListSelection(String message) {
		String userSelection = inputOutput(message);
		int recipe = 0;
		try {
			recipe = Integer.parseInt(userSelection) - 1;
			if (recipe >= 0 && recipe <= 2) {
				// do nothing here.
			} else {
				recipe = -1;
			}
		} catch (NumberFormatException e) {
			System.out.println("Please select a number from 1-3.");
			recipe = -1;
		}
		return recipe;
	}

	/**
	 * Starts the coffee maker program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		coffeeMaker = new CoffeeMaker();
		System.out.println("Welcome to the CoffeeMaker!\n");
		mainMenu();
	}
}
