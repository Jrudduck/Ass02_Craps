import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //variables
        String startGame;
        boolean matchPoint = false;
        boolean thePoint ;
        boolean starter = false;
        int dice1;
        int dice2;
        int dice3;
        int dice4;
        int line;
        int line2;
        String endGame;
        boolean ender;


        System.out.println("This is craps, these are the rules.\n" +
                "1. There is an initial roll of 2 dice resulting in a sum of 2 – 12.\n" +
                "2. If the sum is 2, 3, or 12 it is called \"craps\" or \"crapping out\" and the game is over with a loss.\n" +
                "3. If the sum is 7 or 11 it is called a \"natural\" and the game is over with a win.\n" +
                "4. For all other values, the sum becomes \"the point\" and the user makes subsequent rolls until they either roll a 7, in which case they lose, or they roll the point sum in which case they win.\n" +
                "5. After a win or loss, the next player rolls the die for a new game. In this simulation, the program will simply ask the user if they want to continue to play.\n" );
        System.out.println("Would you like to play craps? [y/n]");
        startGame = scan.nextLine();
        do {
            if (startGame.equalsIgnoreCase("y")) {
                starter = true;
            } else if (startGame.equalsIgnoreCase("n")) {
                System.exit(0);
            } else {
                System.out.println("Please enter [y/n] to play craps.");
                startGame = scan.nextLine();
            }
        }while(!starter);

        do {
            thePoint = false;
            dice1 = (int) (Math.random() * (6 - 1) + 1);
            dice2 = (int) (Math.random() * (6 - 1) + 1);
            System.out.println("Roll 1:    " + dice1);
            System.out.println("Roll 2:    " + dice2);
            line = dice1 + dice2;
            System.out.println("Sum:    " + line);
            if (line == 7 || line == 11) {
                System.out.println("You win!");
            } else if (line == 2 || line == 3 || line == 12) {
                System.out.println("You crapped out, you lost.");
            } else {
                System.out.println(line + " Is now the point!");
                while(!thePoint) {
                    dice3 = (int) (Math.random() * (6 - 1) + 1);
                    dice4 = (int) (Math.random() * (6 - 1) + 1);
                    line2 = dice3 + dice4;
                    if (line == line2) {
                        System.out.println("\nRoll 1:    " + dice3);
                        System.out.println("Roll 2:    " + dice4);
                        System.out.println("Sum:    " + line2);
                        System.out.println("You hit the point, you win!");
                        thePoint = true;
                    } else if (line2 == 7) {
                        System.out.println("\nRoll 1:    " + dice3);
                        System.out.println("Roll 2:    " + dice4);
                        System.out.println("Sum:    " + line2);
                        System.out.println("You rolled a 7 and crapped out. You lose.");
                        thePoint = true;
                    } else {
                        System.out.println("\nRoll 1:    " + dice3);
                        System.out.println("Roll 2:    " + dice4);
                        System.out.println("Sum:    " + line2);
                        System.out.println("You rolled a " +line2 + ". Re-roll.");
                    }
                }
            }
            ender = false;
            System.out.println("Play again? [y/n]");
            endGame = scan.nextLine();
            do {
                if (endGame.equalsIgnoreCase("y")) {
                    ender = true;
                } else if (endGame.equalsIgnoreCase("n")) {
                    matchPoint = true;
                    System.exit(0);
                } else {
                    System.out.println("Please enter [y/n] to play again.");
                    endGame = scan.nextLine();
                }
            }while(!ender);

        } while(!matchPoint);



    }
}