package com.grandmasters.rookvbishop;

import java.util.HashMap;
import java.util.HashSet;

public class Board {
    Square[][] board;
    public Rook rook;
    public Bishop bishop;
    public HashSet<Square> bishopSquares;
    public HashMap<Integer, String> rank;

    public Board() {
        this.board = new Square[8][8];
        this.bishop = new Bishop(true);
        this.rook = new Rook(false);

        this.resetBoard(bishop, rook);
        assignBishopSquares(this);
        rankMap();
    }

    private void rankMap() {
        this.rank = new HashMap<>() {{
            put(0, "a");
            put(1, "b");
            put(2, "c");
            put(3, "d");
            put(4, "e");
            put(5, "f");
            put(6, "g");
            put(7, "h");
        }};
    }

    public Square getSquare(int x, int y) {
        return this.board[x][y];
    }
    public Square getSquare(Square square) {return this.board[square.getX()][square.getY()];}

    private void assignBishopSquares(Board board) {
        this.bishopSquares = new HashSet<>() {{
            add(board.getSquare(0, 0));
            add(board.getSquare(1, 1));
            add(board.getSquare(2, 2));
            add(board.getSquare(3, 3));
            add(board.getSquare(4, 4));
            add(board.getSquare(5, 5));
            add(board.getSquare(6, 6));
            add(board.getSquare(7, 7));

            add(board.getSquare(0, 4));
            add(board.getSquare(1, 3));
            add(board.getSquare(2, 2));
            add(board.getSquare(3, 1));
            add(board.getSquare(4, 0));
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
                                    rank.get(this.board[i][j].getX()) +
                                    (this.board[i][j].getY() + 1) + "\n"
                    );
                }
            }
        }
    }
}
