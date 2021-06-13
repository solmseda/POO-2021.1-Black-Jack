package model;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class SaveSystem {
	public List<Gambler> gamblers;
	public Bank bank;
	
	
	public void SaveGame(List<Gambler> jogadores, Bank banco) {
		gamblers = new ArrayList<Gambler>();
		gamblers.addAll(jogadores);
		
		bank = banco;
		
		File save = new File("Save1.txt");
		
		try {
			if(save.createNewFile()) {
				System.out.println("Save created: " + save.getName());
			}
			else {
				System.out.println("Save already exists. ");
			}
		}
		catch(IOException e) {
			System.out.println("An error occourred");
			e.printStackTrace();
		}
		
		try {
			FileWriter myWriter = new FileWriter(save.getName());
			for(int i = 0; i < jogadores.size(); i++) {
				myWriter.write(jogadores.get(i).Name);
				myWriter.write(jogadores.get(i).Quant_100.qtt);
				myWriter.write(jogadores.get(i).Quant_50.qtt);
				myWriter.write(jogadores.get(i).Quant_20.qtt);
				myWriter.write(jogadores.get(i).Quant_10.qtt);
				myWriter.write(jogadores.get(i).Quant_5.qtt);
			}

		}
		catch(IOException e) {
			
		}
		
	}
}
