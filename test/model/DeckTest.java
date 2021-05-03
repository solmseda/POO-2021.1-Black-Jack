package model;
import static org.junit.Assert.*;

import org.junit.Test;


public class DeckTest {
	

	@Test(timeout = 5000)
	public void testSizeDeck() {
		Deck deck = new Deck();
		assertEquals("O Deck possui 208 cartas",deck.deck.size(), 208);
	}
	
	
	@Test(timeout = 5000)
	public void testSizeDeckError() {
		Deck deck = new Deck();
		Card card = new Card();
		card.Name = "As";
		card.valor = 10;
		card.naipe = "Copas";
		deck.deck.add(card);
		assertNotSame("O Deck não possui 208 cartas",deck.deck.size(), 208);
	}

	
	@Test(timeout = 5000)
	public void testRemoveCard() {
		Deck deck = new Deck();
		int sizeDeck = deck.deck.size();
		deck.RemoveCard();
		assertEquals("Foi removida uma carta do deck",sizeDeck-1, deck.deck.size());
	}
	
	
	@Test(timeout = 5000)
	public void testRemoveCardError() {
		Deck deck = new Deck();
		int sizeDeck = deck.deck.size();
		assertNotSame("Não foi removida uma carta do deck",sizeDeck-1, deck.deck.size());
	}

	@Test(timeout = 5000)
	public void testCountCardsType() {
		Deck deck = new Deck();
		int contNaipeCopas = 0;
		int contNaipeOuros = 0;
		int contNaipeEspadas = 0;
		int contNaipePaus = 0;


		for (int i = 0; i < 208; i++) {
			if (deck.deck.get(i).naipe.equals("Copas")) {
				contNaipeCopas += 1;
			}
			else if (deck.deck.get(i).naipe.equals("Ouros")) {
				contNaipeOuros += 1;
			}
			else if (deck.deck.get(i).naipe.equals("Espadas")) {
				contNaipeEspadas += 1;
			}
			else if (deck.deck.get(i).naipe.equals("Paus")) {
				contNaipePaus += 1;
			}
		}
		assertEquals("Há 52 naipes de Copas",contNaipeCopas, 52);
		assertEquals("Há 52 naipes de Ouros",contNaipeOuros, 52);
		assertEquals("Há 52 naipes de Espadas",contNaipeEspadas, 52);
		assertEquals("Há 52 naipes de Paus",contNaipePaus, 52);
	}
	
	
	@Test(timeout = 5000)
	public void testCountCardsTypeError() {
		Deck deck = new Deck();
		int contNaipeCopas = 0;
		int contNaipeOuros = 0;
		int contNaipeEspadas = 0;
		int contNaipePaus = 0;
		
		Card card = new Card();
		card.Name = "As";
		card.valor = 10;
		card.naipe = "Copas";
		deck.deck.add(card);
		
		
		for (int i = 0; i < 209; i++) {
			if (deck.deck.get(i).naipe.equals("Copas")) {
				contNaipeCopas += 1;
			}
			else if (deck.deck.get(i).naipe.equals("Ouros")) {
				contNaipeOuros += 1;
			}
			else if (deck.deck.get(i).naipe.equals("Espadas")) {
				contNaipeEspadas += 1;
			}
			else if (deck.deck.get(i).naipe.equals("Paus")) {
				contNaipePaus += 1;
			}
		}
		assertNotSame("Não há 52 naipes de Copas",contNaipeCopas, 52);
	}


	
	@Test(timeout = 5000)
	public void testCountCardsNames() {
		Deck deck = new Deck();
		int cont_As = 0;
		int cont_2 = 0;
		int cont_3 = 0;
		int cont_4 = 0;
		int cont_5 = 0;
		int cont_6 = 0;
		int cont_7 = 0;
		int cont_8 = 0;
		int cont_9 = 0;
		int cont_10 = 0;
		int cont_Val = 0;
		int cont_Dam = 0;
		int cont_Rei = 0;
		
		for (int i = 0; i < 208; i++) {
			if (deck.deck.get(i).Name.equals("As")) {
				cont_As += 1;
			}
			else if (deck.deck.get(i).Name.equals("2")) {
				cont_2 += 1;
			}
			else if (deck.deck.get(i).Name.equals("3")) {
				cont_3 += 1;
			}
			else if (deck.deck.get(i).Name.equals("4")) {
				cont_4 += 1;
			}
			else if (deck.deck.get(i).Name.equals("5")) {
				cont_5 += 1;
			}
			else if (deck.deck.get(i).Name.equals("6")) {
				cont_6 += 1;
			}
			else if (deck.deck.get(i).Name.equals("7")) {
				cont_7 += 1;
			}
			else if (deck.deck.get(i).Name.equals("8")) {
				cont_8 += 1;
			}
			else if (deck.deck.get(i).Name.equals("9")) {
				cont_9 += 1;
			}
			else if (deck.deck.get(i).Name.equals("10")) {
				cont_10 += 1;
			}
			else if (deck.deck.get(i).Name.equals("Valete")) {
				cont_Val += 1;
			}
			else if (deck.deck.get(i).Name.equals("Dama")) {
				cont_Dam += 1;
			}
			else if (deck.deck.get(i).Name.equals("Reis")) {
				cont_Rei += 1;
			}
		}
		assertEquals("Há 16 cartas de As",cont_As, 16);
		assertEquals("Há 16 cartas de 2",cont_2, 16);
		assertEquals("Há 16 cartas de 3",cont_3, 16);
		assertEquals("Há 16 cartas de 4",cont_4, 16);
		assertEquals("Há 16 cartas de 5",cont_5, 16);
		assertEquals("Há 16 cartas de 6",cont_6, 16);
		assertEquals("Há 16 cartas de 7",cont_7, 16);
		assertEquals("Há 16 cartas de 8",cont_8, 16);
		assertEquals("Há 16 cartas de 9",cont_9, 16);
		assertEquals("Há 16 cartas de 10",cont_10, 16);
		assertEquals("Há 16 cartas de Valete",cont_Val, 16);
		assertEquals("Há 16 cartas de Dama",cont_Dam, 16);
		assertEquals("Há 16 cartas de Rei",cont_Rei, 16);
		
	}
	
	
	@Test(timeout = 5000)
	public void testCountCardsNamesError() {
		Deck deck = new Deck();
		int cont_As = 0;
		int cont_2 = 0;
		int cont_3 = 0;
		int cont_4 = 0;
		int cont_5 = 0;
		int cont_6 = 0;
		int cont_7 = 0;
		int cont_8 = 0;
		int cont_9 = 0;
		int cont_10 = 0;
		int cont_Val = 0;
		int cont_Dam = 0;
		int cont_Rei = 0;
		
		Card card = new Card();
		card.Name = "7";
		card.valor = 7;
		card.naipe = "Paus";
		deck.deck.add(card);
		
		
		for (int i = 0; i < 209; i++) {
			if (deck.deck.get(i).Name.equals("As")) {
				cont_As += 1;
			}
			else if (deck.deck.get(i).Name.equals("2")) {
				cont_2 += 1;
			}
			else if (deck.deck.get(i).Name.equals("3")) {
				cont_3 += 1;
			}
			else if (deck.deck.get(i).Name.equals("4")) {
				cont_4 += 1;
			}
			else if (deck.deck.get(i).Name.equals("5")) {
				cont_5 += 1;
			}
			else if (deck.deck.get(i).Name.equals("6")) {
				cont_6 += 1;
			}
			else if (deck.deck.get(i).Name.equals("7")) {
				cont_7 += 1;
			}
			else if (deck.deck.get(i).Name.equals("8")) {
				cont_8 += 1;
			}
			else if (deck.deck.get(i).Name.equals("9")) {
				cont_9 += 1;
			}
			else if (deck.deck.get(i).Name.equals("10")) {
				cont_10 += 1;
			}
			else if (deck.deck.get(i).Name.equals("Valete")) {
				cont_Val += 1;
			}
			else if (deck.deck.get(i).Name.equals("Dama")) {
				cont_Dam += 1;
			}
			else if (deck.deck.get(i).Name.equals("Reis")) {
				cont_Rei += 1;
			}
		}
		assertNotSame("Não há 16 cartas de 7",cont_7, 16);
	}
	

}
