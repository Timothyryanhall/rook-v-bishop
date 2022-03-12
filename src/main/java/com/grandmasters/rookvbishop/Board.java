package com.grandmasters.rookvbishop;

import java.util.HashMap;

public class Board {
    Square[][] board;
    public Rook rook;
    public Bishop bishop;
    public HashMap<Square,Integer> bishopSquares;

    public Square getSquare(int x, int y) {
        return this.board[x][y];
    }

    public Board() {
        this.board = new Square[8][8];
        this.bishop = new Bishop(true);
        this.rook = new Rook(false);

        this.resetBoard(bishop, rook);
        assignBishopSquares(this);
    }

    private void assignBishopSquares(Board board) {
        this.bishopSquares = new HashMap<>() {{
            put(board.getSquare(0,0), 1);
            put(board.getSquare(1,1), 1);
            put(board.getSquare(2,2), 1);
            put(board.getSquare(3,3), 1);
            put(board.getSquare(4,4), 1);
            put(board.getSquare(5,5), 1);
            put(board.getSquare(6,6), 1);
            put(board.getSquare(7,7), 1);

            put(board.getSquare(0,4), 1);
            put(board.getSquare(1,3), 1);
            put(board.getSquare(2,2), 1);
            put(board.getSquare(3,1), 1);
            put(board.getSquare(4,0), 1);
        }};
    }

    void resetBoard(Bishop bishop, Rook rook) {
        // initialize empty board
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Square(i, j, null);
            }
        }
        // add bishop and rook to starting positions
        board[2][2].setPiece(bishop);
        board[7][0].setPiece(rook);
    }

    public void printPieceLocations() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.board[i][j].getPiece() != null) {
                    System.out.print(
                            this.board[i][j].getPiece().getColor() + " " +
                                    this.board[i][j].getPiece().getName() + " is on square " +
                                    this.board[i][j].getX() + "," +
                                    this.board[i][j].getY() + "\n"
                    );
                }
            }
        }
    }
}
