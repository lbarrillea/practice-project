package BubbaGumpShrimp;
import java.lang.Math; 
public class Shrimp {
	//Variable (what this class HAS)
	public boolean isRaw;
	public boolean isBurnt;
	public int weightInOunces;
	
	//constructor (how we create an OBJECT of this CLASS)
	/*
	 * When we construct a new Shrimp, he has a name, is Raw (and thus, not burnt), and has a random weight in ounces.
	 */
	public Shrimp() {
		this.isRaw = true;
		this.isBurnt = false;
		this.weightInOunces = this.calculateRandomWeight();
		System.out.println("              A " + this.weightInOunces + " ounce raw shrimp was picked.");
	}
	
	
	//method (what this class DOES)
	/*
	 * Every Shrimp weighs between 4 and 16 ounces
	 * 
	 * This method is private because it cannot be used in any file except this one!
	 * This method return an integer
	 * This method is called calculateRandomWeight
	 * Thus, the method signature is 'private int calculateRandomWeight'
	 */
	private int calculateRandomWeight() {
		int rand = (int)(Math.random() * 12) + 4; 
		return rand;
	}
	
	/*
	 * When we cook a shrimp, we get its weight in ounces for our recipe!
	 * Unless it is already cooked, then we burn it and lose its weight in ounces for our recipe...
	 * And if it is already burnt, then what difference does it make?
	 * 
	 * This method is public because we can use it outside of this file!
	 * This method returns an integer - the weight in ounces we gain (or lose!) from cooking this shrimp
	 * This method is named CookAndGetPounds
	 * Thus, the method signature is 'public int CookAndGetPounds'
	 */
	public int CookAndGetOunces() {
		
		if(this.isRaw) 
		{
			System.out.println("              The shrimp is now cooked. The chef got " + this.weightInOunces + " ounces of shrimp.");
			this.isRaw = false;
			return this.weightInOunces;
		}
		else if(this.isBurnt == false)
		{
			System.out.println("              The shrimp was already cooked. Now he is burnt. Die! Die! Die! Oh, and the chef lost " + 
					this.weightInOunces + " ounces of shrimp.");
			this.isBurnt = true;
			return this.weightInOunces * -1;
		}
		else
		{
			System.out.println("              The shrimp is 'Blackened'");
			return 0;
		}
	}
}
