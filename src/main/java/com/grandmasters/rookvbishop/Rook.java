package com.grandmasters.rookvbishop;

public class Rook extends Piece {

    public Rook(boolean white) {
        super(white);
    }

    @Override
    public String getName() {
        return "Rook";
    }

    public Square move(Board board, Game.Coin coin, int dice) {
        Square square = this.getCurrentSquare();

        if (coin == Game.Coin.Heads) {
            // move the rook up the y axis number on the dice
            int newY = (square.getY() + dice) % 8;
            this.currentSquare = board.getSquare(square.getX(), newY);
            board.getSquare(square.getX(), newY).setPiece(this);
            board.getSquare(square.getX(), square.getY()).setPiece(null);
        } else {
            // move the rook to the right number on the dice
            int newX = (square.getX() + dice) % 8;
            this.currentSquare = board.getSquare(newX, square.getY());
            board.getSquare(newX, square.getY()).setPiece(this);
            board.getSquare(square.getX(), square.getY()).setPiece(null);
        }

        board.rook.currentSquare = this.currentSquare;
        return this.currentSquare;
    }
}
