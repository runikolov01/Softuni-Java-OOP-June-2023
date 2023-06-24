package E03CardsWithPower;

public class Card {
    private CardSuits cardSuit;
    private CardRanks cardRank;
    private int power;

    public Card(CardSuits cardSuit, CardRanks cardRank) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
    }

    public CardSuits getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(CardSuits cardSuit) {
        this.cardSuit = cardSuit;
    }

    public CardRanks getCardRank() {
        return cardRank;
    }

    public void setCardRank(CardRanks cardRank) {
        this.cardRank = cardRank;
    }

    public int getPower() {
        //suitPower + rankPower;

        return this.cardSuit.getSuitPower() + this.cardRank.getPowerRank();
    }

    public void setPower(int power) {
        this.power = power;
    }
}
