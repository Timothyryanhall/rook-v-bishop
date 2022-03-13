package com.grandmasters.rookvbishop;

import java.util.Random;

public class Game {
    public GameStatus gameStatus = GameStatus.ACTIVE;
    public Random randomNum = new Random();
    int turn = 1;

    public enum Coin {Heads, Tails}

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

            if (rookLandsOnBishopSquare(board, newRookSquare)) {
                finishGame(board, GameStatus.BLACK_ROOK_WINS, Rook.ROOK, Bishop.BISHOP);
                break;
            }
            if (bishopCapturesRook(board, newRookSquare)) {
                finishGame(board, GameStatus.WHITE_BISHOP_WINS, Bishop.BISHOP, Rook.ROOK);
                break;
            }

            board.printPieceLocations();
            turn++;
        }

        if (this.gameStatus == GameStatus.ACTIVE) {
            System.out.println("The game is over!!! " + GameStatus.BLACK_ROOK_WINS.toString());
        }
    }

    private void finishGame(Board board, GameStatus gameStatus, String winner, String loser) {
        this.gameStatus = gameStatus;
        board.printPieceLocations();
        System.out.println("The " + winner + " has captured the " + loser + "! The Game is Over! " + "\n" + this.gameStatus);
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

    private boolean bishopCapturesRook(Board board, Square square) {
        return board.bishopSquares.contains(square);
    }

    public boolean rookLandsOnBishopSquare(Board board, Square square) {
        return square == board.getSquare(2, 2);
    }
}

