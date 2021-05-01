import java.util.*;
public class Bank {
	public int Quant_100;
	public int Quant_50;
	public int Quant_20;
	public int Quant_10;
	public int Quant_5;
	
	//Vai entregar uma quantidade de dinheiro baseada em uma quantidade especifica de cada tipo de moeda
	
	
	public List<Integer> give_money(int Quant_100,int Quant_50, int Quant_20, int Quant_10,int Quant_5) {
		List<Integer> allcoins= new ArrayList<Integer>();
		allcoins.add(Quant_100);
		allcoins.add(Quant_50);
		allcoins.add(Quant_20);
		allcoins.add(Quant_10);
		allcoins.add(Quant_5);
		return allcoins;
		}
	
	//De acordo com as regras, sao 2 moedas de 100 e de 50, 5 de 20 e de 10 e 8 de 5
	public List<Integer> GiveInitialMoney() {
		List<Integer> initialMoney= give_money(2,2,5,5,8);
		return initialMoney;
		}
	}
