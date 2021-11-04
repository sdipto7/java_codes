package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

    static Player player1, player2;
    static Scanner input;
    static Board game;

    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe!");
        input = new Scanner(System.in);

        boolean samePlayer = false;
        do {
            if (!samePlayer) {
                playerInitialization(); //Two players initialized with name and desired symbol
            }else{
                player1.positions.clear();
                player2.positions.clear();
            }
            game = new Board(); //Empty board initialized
            game.showBoard();

            String playAgain = startGame();
            if (playAgain.equals("n")) {
                break;
            } else {
                System.out.println("Do you want to play with the same players ? press y if yes, press n if not");
                String choice = input.next();
                if (choice.equals("y")) {
                    samePlayer = true;
                } else {
                    samePlayer = false;
                }
            }
        } while (true);

        System.out.println("Thank you for playing");
    }

    static String startGame() {

        while (true) {
            System.out.println(player1.name + ", please place your symbol in position 1-9");
            int position1 = input.nextInt();
            // Checking if the position is taken or not
            while (player1.positions.contains(position1) || player2.positions.contains(position1)) {
                System.out.println("This position is already taken! Please choose an empty position!");
                position1 = input.nextInt();
            }
            placeSymbol(position1, player1); //player1 move is placed on the board
            game.showBoard(); //showing the updated board

            String gameResult = winner();
            //Checking if we got a winner
            if (!gameResult.equals("")) {
                System.out.println(gameResult);
                break;
            }

            System.out.println(player2.name + ", please place your symbol in position 1-9");
            int position2 = input.nextInt();
            // Checking if the position is taken or not
            while (player1.positions.contains(position2) || player2.positions.contains(position2)) {
                System.out.println("This position is already taken! Please choose an empty position!");
                position2 = input.nextInt();
            }
            placeSymbol(position2, player2); //player2 move is placed on the board
            game.showBoard(); // showing the updated board

            gameResult = winner();
            //Checking if we got a winner
            if (!gameResult.equals("")) {
                System.out.println(gameResult);
                break;
            }
        }
        System.out.println("Do you want to play another game ? press y if yes, press n if not");
        return input.next();
    }

    static void playerInitialization() {
        System.out.println("Enter player1 nickname");
        String player1Name = input.next();

        System.out.println("Enter player1 choice of symbol CROSS(X) OR CIRCLE(O)");
        char player1Symbol = input.next().charAt(0);

        System.out.println("Enter player2 nickname");
        String player2Name = input.next();

        System.out.println("Enter player2 choice of symbol CROSS(X) OR CIRCLE(O)");
        char player2Symbol = input.next().charAt(0);


        //two players are initialized with desired name and number
        player1 = new Player(player1Name, player1Symbol);
        player2 = new Player(player2Name, player2Symbol);
    }

    static void placeSymbol(int position, Player player) {

        char symbol = ' ';

        if (player.equals(player1)) {
            player1.positions.add(position);
            symbol = player1.symbol;
        } else if (player.equals(player2)) {
            player2.positions.add(position);
            symbol = player2.symbol;
        }

        switch (position) {
            case 1:
                game.board[0][0] = symbol; //row1-column1
                break;
            case 2:
                game.board[0][2] = symbol; //row1-column2
                break;
            case 3:
                game.board[0][4] = symbol; //row1-column3
                break;
            case 4:
                game.board[2][0] = symbol; //row2-column1
                break;
            case 5:
                game.board[2][2] = symbol; //row2-column2
                break;
            case 6:
                game.board[2][4] = symbol; //row2-column3
                break;
            case 7:
                game.board[4][0] = symbol; //row3-column1
                break;
            case 8:
                game.board[4][2] = symbol; //row3-column2
                break;
            case 9:
                game.board[4][4] = symbol; //row3-column3
                break;
            default:
                break;
        }
    }

    static String winner() {
        //Possible row winning combination
        List<Integer> upperRow = Arrays.asList(1, 2, 3);
        List<Integer> middleRow = Arrays.asList(4, 5, 6);
        List<Integer> lowerRow = Arrays.asList(7, 8, 9);
        //Possible column winning combination
        List<Integer> leftColumn = Arrays.asList(1, 4, 7);
        List<Integer> middleColumn = Arrays.asList(2, 5, 8);
        List<Integer> rightColumn = Arrays.asList(3, 6, 9);
        //Possible diagonal winning combination
        List<Integer> diagonal1 = Arrays.asList(1, 5, 9);
        List<Integer> diagonal2 = Arrays.asList(3, 5, 7);

        //List of all the possible winning combination
        ArrayList<List<Integer>> winCombination = new ArrayList<List<Integer>>();
        winCombination.add(upperRow);
        winCombination.add(lowerRow);
        winCombination.add(leftColumn);
        winCombination.add(rightColumn);
        winCombination.add(middleRow);
        winCombination.add(middleColumn);
        winCombination.add(diagonal1);
        winCombination.add(diagonal2);

        for (List winPossibility : winCombination) {

            //Checking if player1 got any winning combination or not
            if (player1.positions.containsAll(winPossibility)) {
                return "Congratulations " + player1.name + "! YOU WON! ";
            }
            //Checking if player2 got any winning combination or not
            else if (player2.positions.containsAll(winPossibility)) {
                return "Congratulations " + player2.name + "! YOU WON! ";
            }
            //Checking if the board is full or not
            else if (player1.positions.size() + player2.positions.size() == 9) {
                return "Match Draw!";
            }
        }
        return "";
    }
}
