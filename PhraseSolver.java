/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1;
  private Player player2;
  private Board game;
  private boolean solved;
  /* your code here - constructor(s) */ 
  public PhraseSolver() {
    player1 = new Player();
    player2 = new Player();
    game = new Board();
    solved = false;
  }

  /* your code here - accessor(s) */

  public Player getPlayer(int p) {
    if (p == 1) {
      return player1;
    }
    else {
      return player2;
    }
  }

  /* your code here - mutator(s)  */

  public void play()
  {
    boolean solved = false;
    int currentPlayer = 1;
    Player p;
    String guess;
    Scanner input = new Scanner(System.in);

    System.out.println(game.getSolvedPhrase());
    
    while (!solved) 
    {
      p = getPlayer(currentPlayer);
      /* your code here - game logic */
      System.out.print("player " + currentPlayer + " guess: "); 
      guess = input.nextLine();
      if (guess.length() == 1 && game.guessLetter(guess)) {
        p.setPoints(p.getPoints() + 1);
        System.out.println(game.getSolvedPhrase());
      }
      else if (game.isSolved(guess)) {
        p.setPoints(p.getPoints() + 2);
        solved = true;
        System.out.println("Correct, the phrase is: " + game.getPhrase());
      } else {
        System.out.println("incorrect guess, try again");
        System.out.println(game.getSolvedPhrase());
        switch (currentPlayer) {
          case 1:
            currentPlayer = 2;
            break;
          case 2:
            currentPlayer = 1;
            break;
          default:
            currentPlayer = 2;
        }
      }
      if (solved) {
        input.close();
        System.out.println("Player " + currentPlayer + " has solved the phrase!");
        System.out.println();
        System.out.println("final scores are: ");
        System.out.println("Player 1: " + getPlayer(1).getPoints());
        System.out.println("Player 2: " + getPlayer(2).getPoints());
        System.out.println();
        if (getPlayer(1).getPoints() == getPlayer(2).getPoints()) {
          System.out.println("tie! no winner");
          break;
        }
        System.out.println("Player " + ((getPlayer(1).getPoints() > getPlayer(2).getPoints()) ? "1" : "2") + " wins!");
      }
    } 
   
  }
  
}
