package org.ratcm;

import org.ratcm.exceptions.*;

public class Recipe {
    private String name;
    private int price;
    private int amtCoffee;
    private int amtMilk;
    private int amtSugar;
    private int amtChocolate;
    
    /**
     * Creates a default recipe for the coffee maker.
     */
    public Recipe() {
    	this.name = "";
    	this.price = 0;
    	this.amtCoffee = 0;
    	this.amtMilk = 0;
    	this.amtSugar = 0;
    	this.amtChocolate = 0;
    }
    
    /**
	 * @return   Returns the amtChocolate.
	 */
    public int getAmtChocolate() {
		return amtChocolate;
	}

    /**
	 * @param chocolate   The amount of chocolate to set.
	 */
    public void setAmtChocolate(int chocolate){
		if (chocolate >= 0) {
			this.amtChocolate = chocolate;
		} 
	}

    /**
	 * @return   Returns the amtCoffee.
	 */
    public int getAmtCoffee() {
		return amtCoffee;
	}

    /**
	 * @param coffee   The amount of coffee to set.
	 */
    public void setAmtCoffee(int coffee) {
		if (coffee >= 0) {
			this.amtCoffee = coffee;
		} 
	}

    /**
	 * @return   Returns the amtMilk.
	 */
    public int getAmtMilk() {
		return amtMilk;
	}

	/**
	 * @param milk   The amount of milk to set.
	 */
    public void setAmtMilk(int milk) {
		if (milk >= 0) {
			this.amtMilk = milk;
		}
	}

    /**
	 * @return   Returns the amtSugar.
	 */
    public int getAmtSugar() {
		return amtSugar;
	}

	/**
	 * @param sugar   The amount of sugar to set.
	 */
    public void setAmtSugar(int sugar) {
 		if (sugar >= 0) {
			this.amtSugar = sugar;
		}
	}

    /**
	 * @return   Returns the name.
	 */
    public String getName() {
		return name;
	}

	/**
	 * @param name   The name to set.
	 */
    public void setName(String name) {
    	if(name != null) {
    		this.name = name;
    	}
	}

    /**
	 * @return   Returns the price.
	 */
    public int getPrice() {
		return price;
	}

    /**
	 * @param price   The price to set.
	 */
    public void setPrice(int price) {
 		if (price >= 0) {
			this.price = price;
		}
	} 
    
    /**
     * Returns the name of the recipe.
     * @return String
     */
    public String toString() {
    	return name;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Recipe other = (Recipe) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
