import java.util.*;

public class BlackJack {

   public static void main(String[] args) {

      Hand game = new Hand();
      ArrayList<String> stack = new ArrayList<String>();
      Random ran = new Random();
      int count = 1;
      int min = 16, max = 21;
      int dealer = ran.nextInt(max + 1 - min) + min;
      // generates 52 cards
      stack = game.createShuffle();
      String card = null;
      System.out.println("_____________________________________________________________________________________\n");
      System.out.println("The score of the dealer is: " + dealer + "\n");
      int playerdraw = 0;
      String totalHand = "";
      int aceCount = 0;
      int val = 0;
      String[] s = null;
      // draw cards
      // takes from the array and draws a card at random
      card = game.selectCard(stack);
      // updates card value
      playerdraw += game.cardVal(card);
      System.out.println("\t[ You draw " + card + " ]");
      // adds the card using a string
      totalHand += game.totalHand(card);
      // removes the card so that the same card is not called again
      stack.remove(card);
      // repeat
      card = game.selectCard(stack);
      // updates card value
      playerdraw += game.cardVal(card);
      System.out.println("\t[ You draw " + card + " ]" + "\n");
      // adds card using string
      totalHand += game.totalHand(card);
      // removes card from stack
      stack.remove(card);

      System.out.println("Your score is: " + playerdraw +"\n");
      s = card.split(" ");
      val = Integer.parseInt(s[0]);
      if (playerdraw > 21 && val == 11 && aceCount == 0) {
         playerdraw = playerdraw - 10;
         aceCount++;
         val = 0;
      }
      while (playerdraw <= dealer) {

         if (playerdraw == 21 && count == 1) {
            System.out.println("Your hand is: | " + totalHand);
            System.out.println("BlackJack!");
            break;
         }
         count++;
         card = game.selectCard(stack);
         // first update of the card
         playerdraw += game.cardVal(card);
         System.out.println("\t[ You draw " + card + " ]" +"\n");
         // adds the card using a string
         totalHand += game.totalHand(card);
         // removes the card so that the same card is not called again
         stack.remove(card);
         // works only for the first ace
         s = card.split(" ");
         val = Integer.parseInt(s[0]);
         if (playerdraw > 21 && val == 11 && aceCount == 0) {
            playerdraw = playerdraw - 10;
            aceCount++;
            val = 0;
         } else if (playerdraw < 21 && val == 11 && aceCount == 0) {
            aceCount++;

         }

         if (val == 11) {
            playerdraw = playerdraw - 10;
         }
         System.out.println("Your score is: " + playerdraw);
         System.out.println("Your hand is: | " + totalHand + "\n");
      }
      if (playerdraw <= 21 && playerdraw > dealer)
         System.out.println("You win! :D Your score was " + playerdraw + " and the dealers score was " + dealer);

      else if (playerdraw <= 21 && playerdraw == dealer && count == 1)
         System.out.println("Its a tie! :P  (y) Both your scores are " + playerdraw);

      else
         System.out.println("You lose! :( Your score was " + playerdraw + " and the dealers score was " + dealer);

      System.out.println("_____________________________________________________________________________________\n");

   }
}
