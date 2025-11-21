package cards;


public class Hand {
   private Card[] cards;
   private int size;


   public Hand(int maxCards) {
       cards = new Card[maxCards];
       size = 0;
   }


   public void add(Card c) {
       if (size < cards.length) {
           cards[size] = c;
           size++;
       }
   }


   public int length() {
       return size;
   }


   public Card get(int index) {
       if (index < 0 || index >= size) {
           return null;
       }
       return cards[index];
   }


   public Card remove(int index) {
       if (index < 0 || index >= size) {
           return null;
       }
       Card removed = cards[index];


       for (int i = index; i < size - 1; i++) {
           cards[i] = cards[i + 1];
       }
       cards[size - 1] = null;
       size--;


       return removed;
   }


   public String toString() {
       StringBuilder sb = new StringBuilder();


       for (int i = 0; i < size; i++) {
           sb.append(cards[i]);
           if (i < size - 1)
               sb.append(" ");
       }
       return sb.toString();
   }
}
