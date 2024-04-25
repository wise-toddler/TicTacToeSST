package Tictactoe;

import Tictactoe.controller.GameController;
import Tictactoe.exception.InvalidMoveException;
import Tictactoe.models.game.Game;
import Tictactoe.models.game.GameState;
import Tictactoe.models.player.*;

import java.util.List;

public class Main 
{
    private static final int GAME_DIMENSION = 3;
    private static final GameController gameControllerInstance = new GameController();

    public static void main(String[] args) 
    {
        Game currentGame = startGame();

        try {
            playGame(currentGame);
        }
        catch (InvalidMoveException e) {
            System.out.println(e.getMessage());
        }

        endGame(currentGame);
    }

    private static Game startGame() {
        Player humanPlayer = new Player("Shivansh",new Symbol('X'),PlayerType.HUMAN);
        Player botPlayer = new Bot("Bot",new Symbol('O'),PlayerType.BOT,BotDificultyLevel.EASY);
        List<Player> gamePlayers = List.of(humanPlayer, botPlayer);

        return gameControllerInstance.startGame(GAME_DIMENSION, gamePlayers);
    }

    private static void playGame(Game currentGame) throws InvalidMoveException {
        while (GameState.IN_PROGRESS.equals(currentGame.getState())) {
            gameControllerInstance.printBoard(currentGame);
            gameControllerInstance.makeMove(currentGame);
        }
    }

    private static void endGame(Game currentGame) {
        if (!GameState.ENDED.equals(gameControllerInstance.checkState(currentGame))) {
            currentGame.setState(GameState.DRAW);
            System.out.println("Game DRAW");
        } else {
            gameControllerInstance.printBoard(currentGame);
            System.out.println("Player " + gameControllerInstance.getWinner(currentGame).getName() + " is the winner");
        }
    }
}