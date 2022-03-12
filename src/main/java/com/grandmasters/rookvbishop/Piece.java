package com.grandmasters.rookvbishop;

public abstract class Piece {

    private boolean white = false;
    private String name;
    public Square currentSquare;

    public Piece(boolean white) {
        this.setWhite(white);
    }


    public String getColor() {
        if (this.white) return "White";
        return "Black";
    }
    public void setWhite(boolean white) {
        this.white = white;
    }

    public String getName() {
        return this.name;
    }

    public Square getCurrentSquare() {
        return currentSquare;
    }

}
