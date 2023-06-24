package T01WorkingWithAbstraction.E02CardRank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        CardRanks[] cardSuits = CardRanks.values();

        for (CardRanks c : cardSuits) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", c.ordinal(), c.name());
        }
    }
}
