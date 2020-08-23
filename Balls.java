/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playsafe;

/**
 *
 * @author User
 */
public class Balls {
    
    public final static int Black    = 0;
    public final static int Red      = 1;
    public final static int Green    = 2;
    public final static int NumberBet = 3;
    public final static int MinBet   =1;
    public final static int MaxBet = 36;
    
    private final static int MaxPosition     = 36;
    private final static int NumberPayOff  = 35 ;
    private final static int ColorPayout = 2;
    
    private static int BallPosition;
    private static int BallColor;
    
    //welcome message
     public static void welcomeMessage()
    {
        System.out.println("Welcome to roulette game.");
        System.out.println("You can place a bet on black, red or a number.");
        System.out.println("A color bet is paid " + ColorPayout + " the bet amount.");
        System.out.println("A number bet is paid " + NumberPayOff + " the bet amount.");
        System.out.println("Have fun !\n");
    }

    //option to bet
    public static void betOptions()
    {
        System.out.println("Betting Options are: ");
        System.out.println("    1. Bet on black");
        System.out.println("    2. Bet on red");
        System.out.println("    3. Bet on a number between " + MinBet +
                " and " + MaxBet);
        System.out.println();
    }
    
    
    // method for wheel spin
     public int spin()
    {
        BallPosition= (int)(Math.random() * MaxPosition + 1);
        if(BallPosition < 36)
        {
         if(BallPosition % 2 == 0)
         {
             BallColor = Black;
         }
         else
         {
             BallColor = Red;
         }   
               }
                else
               {
                BallColor = Green;
               }
        System.out.print("the Result is: "+ BallPosition
                + " and color is: ");
        if (BallColor == Black)
        {
            System.out.println("BLACK.");
        } 
        else if (BallColor == Red)
        {
            System.out.println("RED.");
        }
        else 
        {
            System.out.println("GREEN.");
        }
        return BallPosition;
    }
     
     
     //calculate payout
     public int payoff( int bet, int betType, int number)
    {
        if (BallColor == Green)
        {
            return 0;
        }
        else if (betType == 1 && BallColor == Black)
        {
            return bet * ColorPayout;
        }
        else if (betType == 2 && BallColor == Red)
        {
            return bet * ColorPayout;
        }
        else if (betType == 3 && number == BallPosition)
        {
            return bet * NumberPayOff;
        } else return 0;

    }
}
