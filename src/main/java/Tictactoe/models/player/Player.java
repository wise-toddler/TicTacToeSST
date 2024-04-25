package Tictactoe.models.player;

import Tictactoe.models.cell.Cell;
import Tictactoe.models.game.Board;
import Tictactoe.models.move.Move;

import java.util.Scanner;

public sealed class Player permits Bot {
    Scanner scanner;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    String ROWINPUT = "Please enter row numbwr where you want to make the move: ";
    String COLINPUT = "Please enter the column number where you want to make the move: ";

    public Player(String name, Symbol symbol, PlayerType playerType) 
    {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
        scanner = new Scanner(System.in);
    }

    public Move makeMove(Board board) 
    {
        System.out.println(ROWINPUT);
        int row = scanner.nextInt();
        System.out.println(COLINPUT);
        int col = scanner.nextInt();
        return new Move(new Cell(row, col), this);
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

}
