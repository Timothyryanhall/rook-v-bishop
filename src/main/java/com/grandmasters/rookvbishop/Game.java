package com.grandmasters.rookvbishop;

import java.util.Random;

public class Game {
    public GameStatus gameStatus = GameStatus.ACTIVE;
    public enum Coin {Heads, Tails}
    public Random randomNum = new Random();
    int turn = 1;

    public Game() {
        Board board = new Board();
        playGame(board);
    }

    private void playGame(Board board) {
        // play up to 15 turns
        for (int i = 0; i < 15; i++) {
            System.out.println("------------- Turn " + turn + " -------------");
            Coin coin = flip();
            int dice = rollDice();

            Square newRookSquare = board.rook.move(board, coin, dice);

            if (bishopIsCaptured(board, newRookSquare)) {
                board.printPieceLocations();
                this.gameStatus = GameStatus.BLACK_ROOK_WINS;
                System.out.println("The Rook captured the Bishop! The Game is Over! " + this.gameStatus);
                break;
            }
            if (rookInBishopSquare(board, newRookSquare)) {
                board.printPieceLocations();
                this.gameStatus = GameStatus.WHITE_BISHOP_WINS;
                System.out.println("The Bishop captured the Rook! The Game is Over! " + this.gameStatus);
                break;
            }

            board.printPieceLocations();

            turn++;
        }

        if (this.gameStatus == GameStatus.ACTIVE){
            System.out.println("The game is over!!! " + GameStatus.BLACK_ROOK_WINS.toString());
        }
    }

    public int rollDice() {
        int diceTotal = randomNum.nextInt(6) + randomNum.nextInt(6) + 2;
        System.out.println("Dice total: " + diceTotal);
        return diceTotal;
    }

    public Coin flip() {
        int result = randomNum.nextInt(2);
        if (result == 0) {
            System.out.println("Heads");
            return Coin.Heads;
        }
        System.out.println("Tails");
        return Coin.Tails;
    }

    private boolean rookInBishopSquare(Board board, Square square) {
        return board.bishopSquares.get(square) != null;
    }

    public boolean bishopIsCaptured(Board board, Square square) {
        return square == board.getSquare(2, 2);
    }
}

