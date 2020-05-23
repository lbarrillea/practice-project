package BasicPlayerFight;

import BubbaGumpShrimp.*;

public class BaseGame {

	public static void main(String[] args) {
		Dice newDice = new Dice(20);
		System.out.println(newDice.Roll());
		System.out.println(newDice.Roll());
		System.out.println(newDice.Roll());
		System.out.println(newDice.Roll());
		int d4 = newDice.Roll();
		
		/*
		 * Hey Louis, it's always good to have an example to go off of. Use the example that I have 
		 * posted throughout these files as much as you wish! I have made three new classes, and used your existing
		 * "main" method to run a demo.
		 */
		/// 
		{
			System.out.println("We'll start by hiring two new Chefs, Liz and Forrest.");
			Chef Liz = new Chef("Liz");
			Chef Forrest = new Chef("Forrest");
			
			System.out.println("");
			
			System.out.println("Liz is going to start off by cooking 5 shrimp, but will accidentally cook the 3rd shrimp too long.");
			for(int i = 1; i <= 5; i++)
			{
				Shrimp newShrimp = Liz.getAShrimpOutOfTheTank();
				Liz.CookAShrimp(newShrimp);
				
				if(i == 3)
				{
					Liz.CookAShrimp(newShrimp);
				}
			}
			
			System.out.println("");
			
			
			System.out.println("Forrest is going to learn trial-by-fire style, and immediately learn the recipe for Etouffe and cook it.");
			Forrest.learnFirstRecipe("Shrimp Etouffe", 32);
			Forrest.CookRecipe("Shrimp Etouffe");
			
			System.out.println("");
			
			System.out.println("Liz is going to learn how to cook Stew.");
			Liz.learnFirstRecipe("Shrimp Stew", 24);
			System.out.println("Then a customer will order some Fried Shrimp from Liz");
			Liz.CookRecipe("Fried Shrimp");
			System.out.println("Since Liz doesn't know how to cook Fried Shrimp, she will have to learn it and cook it.");
			Liz.learnSecondRecipe("Fried Shrimp", 17);
			Liz.CookRecipe("Fried Shrimp");
			
			System.out.println("");
			
			System.out.println("Forrest just got an order for 3 plates of Shrimp Etoufee");
			for(int i = 1; i <= 3; i++)
			{
				System.out.println("He makes plate #" + i);
				Forrest.CookRecipe("Shrimp Etouffe");
			}
			System.out.println("When he is done, he overcooks a shrimp well past 'burnt'");
			Shrimp forrestsShrimp = Forrest.getAShrimpOutOfTheTank();
			Forrest.CookAShrimp(forrestsShrimp);
			Forrest.CookAShrimp(forrestsShrimp);
			Forrest.CookAShrimp(forrestsShrimp);
			
		}
		///

	}

}
