package hw2;

public class Card implements Comparable<Card>{
	private int suit;
	private int  rank;
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Card(int suit, int rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}
	
	public int getSuit() {
		return suit;
	}
	public void setSuit(int suit) {
		this.suit = suit;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	/*
	public Card(String suit, String rank) {
		super();
		this.suit = suit;
		this.rank = rank;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}*/
	
	@Override
	public String toString() {
		return "[" + suit + "," + rank + "]";
	}
	
	@Override
	public int compareTo(Card o) {
		if(suit > o.suit) {
			return 1;
		} else if (suit == o.suit)  {
			if(rank > o.rank) {
				return 1;
			}else 
				return -1;
		} else 
			return 0;
	}
	
}
