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
public class Player {
    
  private Scanner sc = new Scanner(System.in);
  private int bet, money, betType, number, betNet;
  private String name;
  private static int houseWins;
  
  
  public Player(String playerName, int initialMoney){
    
      name = playerName;
      money = initialMoney;     
  }
  
  //Returns this player's name, money and betNet
  public String getName()
    {
        return name;
    } 
  
  public int getMoney()
    {
        return money;
    } 
    public int getbetNet()
    {
        return betNet;
    } 
  
  public void makeBet(Balls Balls){
    Scanner sc = new Scanner(System.in);
      System.out.println("How much do you want to bet " +name+ "?");
        bet = sc.nextInt();
        
        if(bet>=money)
        
        {
            System.out.println("im going all in!");
            bet= money;
            money = money-bet;
        } 
        else 
        {
            money = money-bet;
        }
        Balls.betOptions();
        
        System.out.println("Choose your bet type: ");
        betType = sc.nextInt();

        if(betType == 3){
         System.out.println("your'e betting on: a number");
             while(true){

               System.out.println("Please enter the number you "
                    + "wish to bet on from 1 to 36: ");
               number = sc.nextInt();
               if(number <1 || number > 36)
               {
                 System.out.println("This Number is not in "
                        + "the desired range.");
                 }
               else
               {
                 break; 
               }
             }            
        }
  }  
    //  Determines if the player wants to play again.
    
    public boolean playAgain(Scanner sc)
    {

          String answer;

          System.out.println (name + " Play again [Y/N]? ");
          answer = sc.nextLine();


          return (answer.equals("y") || answer.equals("Y"));

    }

    // method to playAgain

    public void payment(Balls Ball2)
    {
        int winnings = Ball2.payoff(bet, betType, number);
        money += winnings;
        if(winnings > 0)
        {
            betNet += (winnings-bet);
            Roulette.setHouseWins(-(winnings-bet));
        }
        else
        {
            betNet -= bet;
            Roulette.setHouseWins((bet));
        }

        
        //detemines if player runs out of money.
        
          if(money < 1)
          {

          Scanner scan = new Scanner(System.in);
          System.out.println(name + ", you're out of money. "
                + "Do you want to bet more? [Y/N] ");
          String answer= scan.nextLine();
          if(answer.equals("y") || answer.equals("Y"))
          {
              if (betNet>-200)
              {
                System.out.println("You bought back in for 100");
                money +=100;
              }
              else {
                  System.out.println("Sorry buddy, your cutt off from the credit line.");
                  money = 0;
              }
     }
    }
          //setHouseWins(betNet);
          System.out.println(" Testing to see how much is "
                + "betNet keeping track of: " + betNet);
        
        }
}
