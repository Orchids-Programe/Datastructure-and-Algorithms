package hw2;

import java.util.Random;

public class Shuffle {
	private static int size = 52;
	private static Card[] deCards = new Card[size];
	
	@SuppressWarnings("unused")
	static Card[] getDeCards() {
		int count = 0;
		String[] suits = {"Diamonds","Hearts","Spades","Clubs"};
		String[] ranks = {"Ace","K","Q","J","10","9","8","7","6","5","4","3","2"};
		for(String r : ranks) {
			for(String s : suits) {
				Card card = new Card();
				deCards[count] = card;
				count++;
			}
		}
		return deCards;
	}	
	static Card[] shuffleCards(Card[] deCards) {
		Random rd = new Random();
		int j;
		for(int i = 0; i < size; i++) {
			j = rd.nextInt(size);
			Card temp = deCards[i];
			deCards[i] = deCards[j];
			deCards[j] = temp;
		}
		return deCards;
	}
	static void showCards(Card[] deCards) {
		int count = 0;
		for(Card card : deCards) {
			System.out.println(card.toString()+ " ");
			count++;
			if(count % 4 == 0) {
				System.out.println();
			}
			
		}
	}
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		Shuffle test = new Shuffle();
		Card[] deck = test.getDeCards();
		System.out.println("Bộ bài ban đầu là : ");
		test.showCards(deck);
		System.out.println("Bộ bài sau khi trộn la : ");
		Card[] shuffleCards = test.shuffleCards(deck);
		test.showCards(shuffleCards);
	}
	
}
