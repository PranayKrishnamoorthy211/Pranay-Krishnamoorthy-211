package cards;


public class Card {
   private int suit;
   private int value;


   public String[] Suit = { "♦", "♣", "♥", "♠" };
   public String[] Value = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };


   public Card(int suit, int value) {
       this.suit = suit;
       this.value = value;
   }


   public int getValue() {
       return value;
   }


   public String toString() {
       return "" + Suit[suit] + Value[value];
   }
}
