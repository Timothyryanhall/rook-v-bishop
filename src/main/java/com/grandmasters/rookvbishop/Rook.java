package com.grandmasters.rookvbishop;

public class Rook extends Piece {
    public static final String ROOK = "Rook";

    public Rook(boolean white) {
        super(white, ROOK);
    }

    public Square move(Board board, Game.Coin coin, int dice) {
        Square square = this.getCurrentSquare();

        if (coin == Game.Coin.Heads) {
            // move the rook up
            int newY = (square.getY() + dice) % 8;
            this.currentSquare = board.getSquare(square.getX(), newY);
            board.getSquare(square.getX(), newY).setPiece(this);
            board.getSquare(square.getX(), square.getY()).setPiece(null);
        } else {
            // move the rook to the right
            int newX = (square.getX() + dice) % 8;
            this.currentSquare = board.getSquare(newX, square.getY());
            board.getSquare(newX, square.getY()).setPiece(this);
            board.getSquare(square.getX(), square.getY()).setPiece(null);
        }

        board.rook.currentSquare = this.currentSquare;
        return this.currentSquare;
    }
}
