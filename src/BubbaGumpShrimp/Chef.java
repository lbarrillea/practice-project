package BubbaGumpShrimp;

public class Chef {
	//Variable (what this class HAS)
	public String name;
	public Recipe[] recipes = new Recipe[2];
	private int amountOfCookedShrimp;
	
	//constructor (how we create an OBJECT of this CLASS)
		/*
		 * When we hire a new chef, he has a name, and starts with no cooked shrimp, and no known recipes.
		 */
	public Chef(String name)
	{
		this.name = name;
		this.amountOfCookedShrimp = 0;
		System.out.println("      Chef " + this.name + " was just hired.");
	}
	
	//method (what this class DOES)
	/*
	 * A chef learns his first recipe. 
	 * Note that a chef can learn 2 recipes. This is stored using an ARRAY, indicated by [brackets]. Read about these online!
	 * Arrays are zero-based, so the first item is the [0] item of the array.
	 * 
	 * This method is public because other classes can use it!
	 * This method returns nothing - AKA, void. Notice that there is not 'return' statement
	 * This method is named learnFirstRecipe
	 * This method needs to know the name of the recipe, and the weight of shrimp that recipe needs.
	 * Thus, our method signature is 'public void learnFirstRecipe(String recipeName, int weightOfShrimpNeeded)'
	 */
	public void learnFirstRecipe(String recipeName, int weightOfShrimpNeeded)
	{
		System.out.println("      Chef " + this.name + " learned how to make " + recipeName + " as his/her first recipe.");
		this.recipes[0] = new Recipe(recipeName, weightOfShrimpNeeded);
	}
	
	/*
	 * A chef learns his second recipe
	 * Note: Arrays are zero-based, so the second item is the [1] item of the array.
	 */
	public void learnSecondRecipe(String recipeName, int weightOfShrimpNeeded)
	{
		System.out.println("      Chef " + this.name + " learned how to make " + recipeName + " as his/her second recipe.");
		this.recipes[1] = new Recipe(recipeName, weightOfShrimpNeeded);
	}
	
	/*
	 * A chef can get a fresh shrimp from the endless tank of infinite shrimp
	 * Notice here how all we are doing is calling the Shrimp Constructor to make a new Shrimp, and returning it.
	 * If you think about it, we could also do this in the BaseGame.java file...
	 * But that wouldn't make much sense, would it?
	 * Shrimp shouldn't just come into the program on their own, they should always be gotten by a Chef!
	 * As such, you will never see the Shrimp Constructor used directly in BaseGame.java (go check!)
	 * This is the beauty of Object Oriented Programming! We can logically express our ideas through the way we code.
	 */
	public Shrimp getAShrimpOutOfTheTank()
	{
		System.out.println("      Chef " + this.name + " got a live shrimp from the tank.");
		Shrimp shrimpy = new Shrimp();
		return shrimpy;
	}
	
	/*
	 * A Chef can cook a shrimp.
	 * It is possible that he burns his Shrimp and loses it weight (check out the various return possibilities in Shrimp.java, CookAndGetOunces method.
	 * Because of this possibility of losing shrimp, we will logically enforce that the chef never has less that 0 ounces of shrimp (see the if statement below)
	 * As in the comment above getAShrimpOutOfTheTank(), notice that the shrimp.java CookAndGetOunces() method is only used here, and not in BaseGame.java
	 */
	public void CookAShrimp(Shrimp shrimpy) {
		System.out.println("      Chef " + this.name + " is cooking a shrimp");
		int weight = shrimpy.CookAndGetOunces();
		this.amountOfCookedShrimp = this.amountOfCookedShrimp + weight;
		
		if(this.amountOfCookedShrimp < 0)
		{
			System.out.println("      Chef " + this.name + " has no cooked shrimp :(");
			this.amountOfCookedShrimp = 0;
		}
		else
		{
			System.out.println("      Chef " + this.name + " has " + this.amountOfCookedShrimp + " ounces of shrimp");
		}
	}
	
	/*
	 * This is the most complicated method in the demo. I'm not going to document it - try to do that yourself!
	 * I would suggest having a strong understanding of the rest of the program, especially ARRAYS, before diving into this.
	 */
	public boolean CookRecipe(String recipeName)
	{
		int recipeIndex = -1;
		for(int i = 0; i < recipes.length; i++)
		{
			if(recipes[i] != null)
			{
				if(recipes[i].name == recipeName)
				{
					recipeIndex = i;
				}
			}
		}
		
		if(recipeIndex != -1)
		{
			while(!recipes[recipeIndex].isCooked)
			{
				Shrimp newShrimp = this.getAShrimpOutOfTheTank();
				this.CookAShrimp(newShrimp);
				int leftoverShrimp = recipes[recipeIndex].CookAndGetLeftoverShrimp(this.amountOfCookedShrimp);
				if(recipes[recipeIndex].isCooked)
				{
					this.amountOfCookedShrimp = this.amountOfCookedShrimp - recipes[recipeIndex].weightOfShrimpNeeded + leftoverShrimp;
				}
			}
			System.out.println("      Chef " + this.name + " has successfully cooked a dish of " + recipeName);
			System.out.println("      Chef " + this.name + " has " + this.amountOfCookedShrimp + " ounces of cooked Shrimp left"); 
			this.recipes[recipeIndex].isCooked = false;
			return true;
		}
		else
		{
			System.out.println("      Chef " + this.name + " does not know how to make " + recipeName);
			return false;
		}
	}
}
