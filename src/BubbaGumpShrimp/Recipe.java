package BubbaGumpShrimp;

public class Recipe {
	//Variable (what this class HAS)
	public String name;
	public int weightOfShrimpNeeded;
	public boolean isCooked;
	
	//constructor (how we create an OBJECT of this CLASS)
	/*
	 * When we create a recipe, it has a name, and a weight in Shrimp needed to cook it
	 */
	public Recipe(String name, int weightOfShrimpNeeded)
	{
		this.name = name;
		this.weightOfShrimpNeeded = weightOfShrimpNeeded;
		this.isCooked = false;
		System.out.println("          The recipe for " + this.name + " was learned.");
	}
	
	
	//method (what this class DOES)
	/*
	 * When we cook this recipe, we use the shrimp we have cooked. If we have enough shrimp, we succeed.
	 * Otherwise, we fail to cook it and retain our cooked shrimp.
	 * 
	 * This method is public because other classes can use it!
	 * This method returns an integer - the amount of leftover shrimp! if it was not cooked because we didn't have enough, we get all the shrimp back.
	 * This method is named CookAndGetLeftoverShrimp
	 * This method needs to know how much cooked shrimp we have, or the weightOfCookedShrimp
	 * Thus, the method signature is 'public int CookAndGetLeftoverShrimp(int weightOfCookedShrimp)'
	 */
	public int CookAndGetLeftoverShrimp(int weightOfCookedShrimp) 
	{
		int leftoverShrimpInOunces = weightOfCookedShrimp;
		if(weightOfCookedShrimp >= this.weightOfShrimpNeeded) 
		{
			leftoverShrimpInOunces = weightOfCookedShrimp - this.weightOfShrimpNeeded;
			this.isCooked = true;
			System.out.println("          One dish of " + this.name + " has been cooked!");
			
		}
		else
		{
			System.out.println("          There are not enough cooked shrimp to cook a dish of " + this.name);
			System.out.println("          " + this.weightOfShrimpNeeded + " ounces of shrimp are needed, but the chef only has " + weightOfCookedShrimp + " ounces.");
		}
		return leftoverShrimpInOunces;
	}

}
