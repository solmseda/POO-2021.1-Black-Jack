public class Game extends Bank {
	public static void main(String args[]) {
		Gambler gambler = new Gambler("RAQEL");
		Bank bank = new Bank();
		gambler.allCoins=bank.GiveInitialMoney();
		for (int i=0;i<gambler.allCoins.size();i++) {
			System.out.println(gambler.allCoins.get(i).qtt);
			System.out.println(gambler.allCoins.get(i).value);			 
		}
		System.out.println("APOSTANDO!!!!");
		gambler.Make_Bet(1,0,0,0,5);
		for (int i=0;i<gambler.allCoins.size();i++) {
			 
 			System.out.println(gambler.allCoins.get(i).qtt);
			System.out.println(gambler.allCoins.get(i).value);
		 
		}
	}
}
