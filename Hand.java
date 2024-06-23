import java.util.*;

public class Hand {

    static int max = 52;

    public String selectCard(ArrayList<String> a) {
        max--;
        Random rand = new Random();
        int min = 0;
        int card = rand.nextInt(max + 1 - min) + min;
        String val = a.get(card);
        return val;
    }

    // generate cards
    public static ArrayList<String> createShuffle() {

        ArrayList<String> stack = new ArrayList<String>();
        String a[] = { "of clubs", "of diamonds", "of spades", "of hearts" };
        String b[] = { "Queen ", "King ", "Jester " };
        String c[] = { "Ace " };
        for (int i = 0; i < a.length; i++) {
            for (int j = 2; j <= 10; j++)
                stack.add(j + " " + a[i]);
        }
        for (int i = 0; i < b.length; i++)
            for (int j = 0; j < 4; j++)
                stack.add(10 + " " + b[i] + a[j]);

        for (int i = 0; i < a.length; i++)
            stack.add(11 + " " + c[0] + a[i]);

        // System.out.println(stack);

        return stack;
    }

    public int cardVal(String card) {
        String[] s = card.split(" ");
        int A1 = Integer.parseInt(s[0]);

        return A1;
    }

    public String totalHand(String cardHand) {
        String newCard = "";
        newCard += cardHand + " | ";
        return newCard;
    }

}
