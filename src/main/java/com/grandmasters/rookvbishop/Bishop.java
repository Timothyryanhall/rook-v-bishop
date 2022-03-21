package com.grandmasters.rookvbishop;

public class Bishop extends Piece {
    public static final String BISHOP = "Bishop";

    public Bishop(boolean white) {
        super(white, BISHOP);
    }

    public Square move(Board board, Game.Coin coin, int dice) {
        Square square = this.getCurrentSquare();
        if (coin == Game.Coin.Heads) {
            // move the bishop up and right
            for (int i = 1; i <= dice; i++) {
                Square newSquare = board.getSquare(
                        (square.getX() + i) % 8,
                        (square.getY() + i) % 8
                );
                if (newSquare.getPiece() != null && newSquare.getPiece() != board.bishop) {
                    placeBishopOnNewSquare(
                            board,
                            square,
                            newSquare
                    );
                    break;
                }
            }
            if (board.bishop.currentSquare == square) {
                placeBishopOnNewSquare(
                        board,
                        square,
                        board.getSquare(
                                (square.getX() + dice) % 8,
                                (square.getY() + dice) % 8)
                );
            }

        } else {
            // move the bishop down and right
            for (int i = 1; i <= dice; i++) {
                Square newSquare = board.getSquare(
                        (square.getX() + i) % 8,
                        Math.floorMod(square.getY() - i, 8)
                );
                if (newSquare.getPiece() != null && newSquare.getPiece() != board.bishop) {
                    placeBishopOnNewSquare(
                            board,
                            square,
                            newSquare
                    );
                    break;
                }
            }
            if (board.bishop.currentSquare == square) {
                placeBishopOnNewSquare(
                        board,
                        square,
                        board.getSquare(
                                (square.getX() + dice) % 8,
                                Math.floorMod(square.getY() - dice, 8)
                        )
                );
            }
        }

        board.bishop.currentSquare = this.currentSquare;
        return this.currentSquare;
    }


    private void placeBishopOnNewSquare(Board board, Square oldSquare, Square newSquare) {
        this.currentSquare = newSquare;
        board.getSquare(newSquare).setPiece(this);
        board.getSquare(oldSquare).setPiece(null);
        System.out.println("Bishop moves to square " + board.rank.get(newSquare.getX()) + (newSquare.getY() + 1));
    }
}
