package BasicPlayerFight;

public class BaseGame {

	public static void main(String[] args) {
		Dice newDice = new Dice(20);
		System.out.println(newDice.Roll());
		System.out.println(newDice.Roll());
		System.out.println(newDice.Roll());
		System.out.println(newDice.Roll());
		int d4 = newDice.Roll();

	}

}
