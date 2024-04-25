package Tictactoe.logic;

import Tictactoe.models.game.Board;
import Tictactoe.models.move.Move;
import Tictactoe.models.player.Symbol;

public class GameLogic 
{
    private int[][] rowSymbolCounts;
    private int[][] columnSymbolCounts;
    private int[] leftDiagonalSymbolCounts;
    private int[] rightDiagonalSymbolCounts;
    private Board gameBoard;

    public GameLogic(Board gameBoard) // GameBoard is not defined in this file
    {
        this.gameBoard = gameBoard; // 
        int size = gameBoard.getSize();
        rowSymbolCounts = new int[size][2];
        columnSymbolCounts = new int[size][2];
        leftDiagonalSymbolCounts = new int[2];
        rightDiagonalSymbolCounts = new int[2];
    }

    public boolean isWinner(Board gameBoard, Move move, Symbol playerSymbol)
    {
        int index = playerSymbol.getSymbol() == 'X' ? 0 : 1;
        int moveRow = move.getCell().getRow();  
        int moveColumn = move.getCell().getCol();
        rowSymbolCounts[moveRow][index]++;
        if (rowSymbolCounts[moveRow][index] == gameBoard.getSize()) {
            return true;
        }

        columnSymbolCounts[moveColumn][index]++;
        if (columnSymbolCounts[moveColumn][index] == gameBoard.getSize()) {
            return true;
        }

        if (moveRow == moveColumn) {
            leftDiagonalSymbolCounts[index]++;
            return leftDiagonalSymbolCounts[index] == gameBoard.getSize();
        }

        if (moveRow + moveColumn == gameBoard.getSize() - 1) {
            rightDiagonalSymbolCounts[index]++;
            return rightDiagonalSymbolCounts[index] == gameBoard.getSize();
        }

        return false;
    }
}