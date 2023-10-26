/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  private String name = ""; 
  private double points;
  /* your code here - attributes */

  /* your code here - constructor(s) */ 
  public Player() {
    points = 0;
    System.out.print("Enter Player Name: ");
    Scanner sc = new Scanner(System.in);
    String newName = sc.nextLine();
    
    name = newName;
    System.out.println("Welcome to the game " + name);
  }
  
  public Player(String inputName) {
    points = 0;
    name = inputName;
  }
  /* your code here - accessor(s) */ 
  public double getPoints()
  {
    return points;
  }
  public String getName()
  {
    return name;
  }
  /* your code here - mutator(s) */ 
  public void setName(String x)
  {
    name = x;
  }

}