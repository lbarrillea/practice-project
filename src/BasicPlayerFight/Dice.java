package BasicPlayerFight;
import java.lang.Math; 
public class Dice {
	//Variable (what this class HAS)
	public int maxNumber;
	
	//method (what this class DOES)
	public int Roll() {
		int rand = (int)(Math.random() * maxNumber) + 1; 
		return rand ;
	}
	
	//constructor (how we create an OBJECT of this CLASS)
	public Dice(int max){
		maxNumber = max;
	}

}
