package com.grandmasters.rookvbishop;

public class Rook extends Piece {

    public Rook(boolean white) {
        super(white);
    }

    @Override
    public String getName() {
        return "Rook";
    }

    public GameStatus move(Board board, Game.Coin coin, int dice) {
        Square square = this.getCurrentSquare();

        if (coin == Game.Coin.Heads) {
            // move the rook up the y axis number on the dice
            int newY = (square.getY() + dice) % 8;
            this.currentSquare = board.getSquare(square.getX(), newY);
            if (bishopIsCaptured(board, this.currentSquare)) {
                System.out.println("Rook has captured the Bishop!");
                return GameStatus.BLACK_ROOK_WINS;
            } else if (rookInBishopSquare(board, this.currentSquare)) {
                board.getSquare(square.getX(), newY).setPiece(this);
                board.getSquare(square.getX(), square.getY()).setPiece(null);
                System.out.println("Bishop has captured the Rook!");
                return GameStatus.WHITE_BISHOP_WINS;
            } else {
                board.getSquare(square.getX(), newY).setPiece(this);
                board.getSquare(square.getX(), square.getY()).setPiece(null);
            }
        } else {
            // move the rook to the right number on the dice
            int newX = (square.getX() + dice) % 8;
            this.currentSquare = board.getSquare(newX, square.getY());
            if (bishopIsCaptured(board, this.currentSquare)) {
                System.out.println("Rook has captured the Bishop!");
                return GameStatus.BLACK_ROOK_WINS;
            } else if (rookInBishopSquare(board, this.currentSquare)) {
                board.getSquare(newX, square.getY()).setPiece(this);
                board.getSquare(square.getX(), square.getY()).setPiece(null);
                System.out.println("Bishop has captured the Rook!");
                return GameStatus.WHITE_BISHOP_WINS;
            } else {
                board.getSquare(newX, square.getY()).setPiece(this);
                board.getSquare(square.getX(), square.getY()).setPiece(null);
            }
        }

        board.rook.currentSquare = this.currentSquare;
        return GameStatus.ACTIVE;
    }

    private boolean rookInBishopSquare(Board board, Square square) {
        return board.bishopSquares.get(square) != null;
    }

    public boolean bishopIsCaptured(Board board, Square square) {
        return square == board.getSquare(2, 2);
    }

}
