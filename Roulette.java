/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playsafe;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class Roulette {
   private static int houseMoney=0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scan = new Scanner(System.in);
        String name1 = "Meg";
        String name2 = "Jess";
        Balls bal1 = new Balls();
        
        System.out.println("please enter a name for player 1: ");
        name1 = scan.nextLine();
        System.out.println("please enter a name for player 2: ");
        name2 = scan.nextLine();
        Player player1 = new Player (name1, 100);   // R100 to start for Jane
        Player player2 = new Player (name2, 100);   // R100 to start for Dave
        boolean bl1 = true;
        boolean bl2 = true;

        Balls.welcomeMessage();
        
                while (bl1 || bl2)
        {
            System.out.println ("Money available for " + player1.getName()
                    + ": " + player1.getMoney());
            if(bl1)player1.makeBet(bal1);

            System.out.println ("Money available for " + player2.getName()
            + ": " + player2.getMoney());
            if(bl2)player2.makeBet(bal1);

            bal1.spin();

             if(bl1 == true)
             {
                    //initiate the payment
             player1.payment(bal1);

             System.out.println ("Money available for " + player1.getName() + ": "
                     + player1.getMoney());

                    // check weather play the game again

                 if(!player1.playAgain(scan))

                 {

                    bl1 = false;

                     System.out.println(player1.getName()+" total wins/losses: " 
                     + player1.getbetNet());

                 }

             }

               // check the boolean value

               if(bl2 == true)

               {

                    //initiate the payment

                    player2.payment(bal1);

                    System.out.println ("Money available for " +
                            player2.getName() + ": " + player2.getMoney());

                    // check weather play the game again

                   if(!player2.playAgain(scan))

                    {

                         bl2 = false;

                         System.out.println(player2.getName()+ " total wins/losses: "
                                 + player2.getbetNet());

                    }
               }    
            } 
                System.out.println();

                 System.out.printf("House %s: R%d", houseMoney > 0 ? "Wins" : "Losses", houseMoney);

                 System.out.println();

                 System.out.println ("Game over! Thanks for playing.");
    }
    
    
    public static void setHouseWins(int Winnings)

    {

        houseMoney += Winnings;

   }
}
