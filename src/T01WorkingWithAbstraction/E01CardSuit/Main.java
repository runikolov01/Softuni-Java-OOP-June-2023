package T01WorkingWithAbstraction.E01CardSuit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suits:");
        CardSuits[] cardSuit = CardSuits.values();

        for(CardSuits c:cardSuit){
            System.out.printf("Ordinal value: %d; Name value: %s%n", c.ordinal(), c.toString());

        }
    }
}
