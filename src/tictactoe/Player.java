package tictactoe;

import java.util.ArrayList;

public class Player {

    String name;
    char symbol;
    ArrayList<Integer> positions;

    public Player(String name, char symbol) {
        this.positions = new ArrayList<>();
        this.name = name;
        this.symbol = symbol;
    }
}