package org.ratcm;

public class Inventory {
    
    private int coffee;
    private int milk;
    private int sugar;
    private int chocolate;
    
    /**
     * Creates a coffee maker inventory object and
     * fills each item in the inventory with 15 units.
     */
    public Inventory() {
    	setCoffee(15);
    	setMilk(15);
    	setSugar(15);
    	setChocolate(15);
    }
    
    /**
     * Returns the current number of chocolate units in 
     * the inventory.
     * @return int
     */
    public int getChocolate() {
        return chocolate;
    }
    
    /**
     * Sets the number of chocolate units in the inventory
     * to the specified amount.
     * @param chocolate
     */
    public void setChocolate(int chocolate) {
    	if(chocolate >= 0) {
    		this.chocolate = chocolate;
    	}
        
    }
    
     /**
     * Returns the current number of coffee units in
     * the inventory.
     * @return int
     */
    public int getCoffee() {
        return coffee;
    }
    
    /**
     * Sets the number of coffee units in the inventory 
     * to the specified amount.
     * @param coffee
     */
    public void setCoffee(int coffee) {
    	if(coffee >= 0) {
    		this.coffee = coffee;
    	}
    }
    
    
    /**
     * Returns the current number of milk units in
     * the inventory.
     * @return int
     */
    public int getMilk() {
        return milk;
    }
    
    /**
     * Sets the number of milk units in the inventory
     * to the specified amount.
     * @param milk
     */
    public void setMilk(int milk) {
    	if(milk >= 0) {
    		this.milk = milk;
    	}
    }
    
     /**
     * Returns the current number of sugar units in 
     * the inventory.
     * @return int
     */
    public int getSugar() {
        return sugar;
    }

    /**
     * Sets the number of sugar units in the inventory
     * to the specified amount.
     * @param sugar
     */
    public void setSugar(int sugar) {
    	if(sugar >= 0) {
    		this.sugar = sugar;
    	}
    }
    
     /**
     * Returns true if there are enough ingredients to make
     * the beverage.
     * @param r
     * @return boolean
     */
    public boolean enoughIngredients(Recipe r) {
        boolean isEnough = true;
        if(coffee < r.getAmtCoffee()) {
            isEnough = false;
        }
        if(milk < r.getAmtMilk()) {
            isEnough = false;
        }
        if(sugar < r.getAmtSugar()) {
            isEnough = false;
        }
        if(chocolate < r.getAmtChocolate()) {
            isEnough = false;
        }
        return isEnough;
    }
    
    /**
     * Removes the ingredients used to make the specified 
     * recipe.  Assumes that the user has checked that there
     * are enough ingredients to make 
     * @param r
     */
    public boolean useIngredients(Recipe r) {
    	if (enoughIngredients(r)) {
	    	coffee -= r.getAmtCoffee();
	    	milk -= r.getAmtMilk();
	    	sugar -= r.getAmtSugar();
	    	chocolate -= r.getAmtChocolate();
	    	return true;
    	} else {
    		return false;
    	}
    }
    
    /**
     * Returns a string describing the current contents 
     * of the inventory.
     * @return String
     */
    public String toString() {
    	StringBuffer buf = new StringBuffer();
    	buf.append("Coffee: ");
    	buf.append(getCoffee());
    	buf.append("\n");
    	buf.append("Milk: ");
    	buf.append(getMilk());
    	buf.append("\n");
    	buf.append("Sugar: ");
    	buf.append(getSugar());
    	buf.append("\n");
    	buf.append("Chocolate: ");
    	buf.append(getChocolate());
    	buf.append("\n");
    	return buf.toString();
    }
}
