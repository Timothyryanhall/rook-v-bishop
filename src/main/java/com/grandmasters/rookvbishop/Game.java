package com.grandmasters.rookvbishop;

import java.util.Random;

public abstract class Game {
    static final String ROOK_VS_BISHOP = "Rook Vs Bishop";
    static final String ROOK_VS_LIBERATED_BISHOP = "Rook Vs Liberated Bishop";
    static final String KNIGHT_VS_BISHOP = "Knight Vs Bishop";
    public GameStatus gameStatus = GameStatus.ACTIVE;
    private final Random randomNum = new Random();
    int turn = 1;

    public enum Coin {Heads, Tails}

    public Game() {
    }

    void finishGame(GameStatus gameStatus, String winner, String loser) {
        this.gameStatus = gameStatus;
        System.out.println("The " + winner + " has captured the " + loser + "! The Game is Over! " + "\n" + this.gameStatus);
    }

    int rollDice() {
        int diceTotal = randomNum.nextInt(6) + randomNum.nextInt(6) + 2;
        System.out.println("Dice total: " + diceTotal);
        return diceTotal;
    }

    Coin flip() {
        int result = randomNum.nextInt(2);
        if (result == 0) {
            System.out.println("Heads");
            return Coin.Heads;
        }
        System.out.println("Tails");
        return Coin.Tails;
    }

    public GameStatus playGame() {
        return this.gameStatus;
    }

}

