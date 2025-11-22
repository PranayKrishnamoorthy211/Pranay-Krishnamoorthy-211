package cards;

public class Deck {
    private Card[] cards;
    private int size;

    public Deck() {
        cards = new Card[52];
        size = 0;

        for (int s = 0; s <= 3; s++) {
            for (int v = 0; v<=12; v++) {
                cards[size] = new Card(s, v);
                size++;
            }
        }
    }

    public void shuffle() {
        for (int i = size - 1; i > 0; i--) {
            int j = (int) (Math.random()*(i + 1));

            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    public Card draw() {
        if (size == 0) {
            return null;
        }
        size--;
        Card dealtCard = cards[size];
        cards[size] = null;
        return dealtCard;
    }

    public int size() {
        return size;
    }


}
