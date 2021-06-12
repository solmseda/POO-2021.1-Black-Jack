package model;
import java.util.*;
    class Bank{
	public coins Quant_100;
	public coins Quant_50;
	public coins Quant_20;
	public coins Quant_10;
	public coins Quant_5;
	
	//Vai entregar uma quantidade de dinheiro baseada em uma quantidade especifica de cada tipo de moeda
	
	public void add_bet_money(List<coins> bet,List<coins> currentmoney){
		for(int i=0;i<currentmoney.size();i++) {
			currentmoney.get(i).qtt+=bet.get(i).qtt;
		}
   }
	public List<coins> give_money(int Quant_100,int Quant_50, int Quant_20, int Quant_10,int Quant_5,int Quant_1) {
		List<coins> allcoins= new ArrayList<coins>();

		allcoins.add(new coins(Quant_100,100));
		allcoins.add(new coins(Quant_50,50));
		allcoins.add(new coins(Quant_20,20));
		allcoins.add(new coins(Quant_10,10));
		allcoins.add(new coins(Quant_5,5));
		allcoins.add(new coins(Quant_1,1));
		return allcoins;
		}
	
	//De acordo com as regras, sao 2 moedas de 100 e de 50, 5 de 20 e de 10, 8 de 5 e 10 de 1
	public List<coins> GiveInitialMoney() {
		List<coins> initialMoney= give_money(2,2,5,5,8,10);
		return initialMoney;
		}
	}
