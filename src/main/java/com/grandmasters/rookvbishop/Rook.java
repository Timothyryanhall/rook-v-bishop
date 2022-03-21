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
            for (int i = 1; i <= dice; i++) {
                Square newSquare = board.getSquare(
                        square.getX(),
                        (square.getY() + i) % 8
                );
                if (newSquare.getPiece() != null && newSquare.getPiece() != board.rook) {
                    placeRookOnNewSquare(
                            board,
                            square,
                            newSquare
                    );
                    break;
                }
            }
            if (board.rook.currentSquare == square) {
                placeRookOnNewSquare(
                        board,
                        square,
                        board.getSquare(square.getX(), (square.getY() + dice) % 8)
                );
            }
        } else {
            // move the rook to the right
            for (int i = 1; i <= dice; i++) {
                if (board.getSquare((square.getX() + i) % 8, square.getY()).getPiece() != null &&
                        board.getSquare(square.getX(), (square.getY() + i) % 8).getPiece() != board.rook) {
                    placeRookOnNewSquare(
                            board,
                            square,
                            board.getSquare((square.getX() + i) % 8, square.getY())
                    );
                    break;
                }
            }
            if (board.rook.currentSquare == square) {
                int newX = (square.getX() + dice) % 8;
                placeRookOnNewSquare(board, square, board.getSquare(newX, square.getY()));
            }
        }

        board.rook.currentSquare = this.currentSquare;
        return this.currentSquare;
    }

    private void placeRookOnNewSquare(Board board, Square oldSquare, Square newSquare) {
        this.currentSquare = newSquare;
        board.getSquare(newSquare).setPiece(this);
        board.getSquare(oldSquare).setPiece(null);
        System.out.println("Rook moves to square " + board.rank.get(newSquare.getX()) + (newSquare.getY() + 1));
    }
}
