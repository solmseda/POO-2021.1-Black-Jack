package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class SaveSystem {
	
	public void SaveGame(List<Gambler> jogadores, Dealer dealer, int turn) {
		File save = new File("Save.txt");
		
		try {
			if(save.createNewFile()) {
				System.out.println("Save created: " + save.getName());
			}
			else {
				System.out.println("Save already exists. ");
			}
		} catch(IOException e) {
			System.out.println("An error occourred");
			e.printStackTrace();
		}
		
		try {
			BufferedWriter myWriter = new BufferedWriter(new FileWriter(new File(save.getName())));
			myWriter.write(String.valueOf(jogadores.size()));
			myWriter.write(System.getProperty("line.separator"));
			
			myWriter.write(String.valueOf(turn));
			myWriter.write(System.getProperty("line.separator"));
			
			for(int i = 0; i < jogadores.size(); i++) {
				myWriter.write(jogadores.get(i).Name);
				
				myWriter.write(String.valueOf(jogadores.get(i).allCoins.get(0).qtt));
				myWriter.write(System.getProperty("line.separator"));
				myWriter.write(String.valueOf(jogadores.get(i).allCoins.get(1).qtt));
				myWriter.write(System.getProperty("line.separator"));
				myWriter.write(String.valueOf(jogadores.get(i).allCoins.get(2).qtt));
				myWriter.write(System.getProperty("line.separator"));
				myWriter.write(String.valueOf(jogadores.get(i).allCoins.get(3).qtt));
				myWriter.write(System.getProperty("line.separator"));
				myWriter.write(String.valueOf(jogadores.get(i).allCoins.get(4).qtt));
				myWriter.write(System.getProperty("line.separator"));
				myWriter.write(String.valueOf(jogadores.get(i).allCoins.get(5).qtt));
				myWriter.write(System.getProperty("line.separator"));
				
				for(int j = 0 ; j < jogadores.get(i).hand.size(); j ++) {
					myWriter.write(jogadores.get(i).hand.get(j).naipe);
					myWriter.write(System.getProperty("line.separator"));
					myWriter.write(jogadores.get(i).hand.get(j).Name);
					myWriter.write(System.getProperty("line.separator"));
					myWriter.write(String.valueOf(jogadores.get(i).hand.get(j).valor));
					myWriter.write(System.getProperty("line.separator"));
				}
			}
			
			myWriter.write(dealer.hand.get(0).naipe);
			myWriter.write(System.getProperty("line.separator"));
			myWriter.write(dealer.hand.get(0).Name);
			myWriter.write(System.getProperty("line.separator"));
			myWriter.write(String.valueOf(dealer.hand.get(0).valor));
			myWriter.write(System.getProperty("line.separator"));
			
			myWriter.write(dealer.hand.get(1).naipe);
			myWriter.write(System.getProperty("line.separator"));
			myWriter.write(dealer.hand.get(1).Name);
			myWriter.write(System.getProperty("line.separator"));
			myWriter.write(String.valueOf(dealer.hand.get(1).valor));
			myWriter.write(System.getProperty("line.separator"));
			
			myWriter.close();

		} catch(IOException e) {
			System.out.println("An error occourred");
			e.printStackTrace();
		}
	}
	
	public void RetrieveGame (List<Gambler> gamblers, Dealer dealer, int turn){
		//List<Gambler> gamblers = new ArrayList<Gambler>();
		
		
		File save = new File("Save1.txt");
		try {
			Scanner myReader = new Scanner(save);
			while(myReader.hasNextLine()) {
					String data = myReader.nextLine();
					int size = Integer.parseInt(data);
					
					data = myReader.nextLine();
					turn = Integer.parseInt(data);
					
					for (int i = 0; i < size; i++) {
						Gambler player = new Gambler(data);
						
						data = myReader.nextLine();
						player.Quant_100.qtt = Integer.parseInt(data);
						
						data = myReader.nextLine();
						player.Quant_50.qtt = Integer.parseInt(data);
						
						data = myReader.nextLine();
						player.Quant_20.qtt = Integer.parseInt(data);
						
						data = myReader.nextLine();
						player.Quant_10.qtt = Integer.parseInt(data);
						
						data = myReader.nextLine();
						player.Quant_5.qtt = Integer.parseInt(data);
						
						data = myReader.nextLine();
						player.Quant_1.qtt = Integer.parseInt(data);
						
						data = myReader.nextLine();
						player.hand.get(0).naipe = data;
						
						data = myReader.nextLine();
						player.hand.get(0).Name = data;
						
						data = myReader.nextLine();
						player.hand.get(0).valor = Integer.parseInt(data);
						
						gamblers.add(player);
					}
					
					data = myReader.nextLine();
					dealer.hand.get(0).naipe = data;
					
					data = myReader.nextLine();
					dealer.hand.get(0).Name = data;
					
					data = myReader.nextLine();
					dealer.hand.get(0).valor = Integer.parseInt(data);
					
					data = myReader.nextLine();
					dealer.hand.get(1).naipe = data;
					
					data = myReader.nextLine();
					dealer.hand.get(1).Name = data;
					
					data = myReader.nextLine();
					dealer.hand.get(1).valor = Integer.parseInt(data);
					
			}
			myReader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("An error occourred");
			e.printStackTrace();
		}
	}
}
