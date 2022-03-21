package com.grandmasters.rookvbishop;

public class RookVsLiberatedBishop extends Game {
    private final Board board;

    public RookVsLiberatedBishop() {
        this.board = new Board();
    }

    @Override
    public GameStatus playGame() {
        for (int i = 0; i < 10; i++) {
            System.out.println("------------- Turn " + turn + " -------------");
            Coin coin = flip();
            int dice = rollDice();

            if (i % 2 == 0) {
                board.rook.move(board, coin, dice);
                if (board.rook.currentSquare == board.bishop.currentSquare) {
                    finishGame(GameStatus.BLACK_ROOK_WINS, Rook.ROOK, Bishop.BISHOP);
                    break;
                }
            } else {
                board.bishop.move(board, coin, dice);
                if (board.rook.currentSquare == board.bishop.currentSquare) {
                    finishGame(GameStatus.WHITE_BISHOP_WINS, Bishop.BISHOP, Rook.ROOK);
                    break;
                }
            }
            turn++;
        }

        if (this.gameStatus == GameStatus.ACTIVE) {
            this.gameStatus = GameStatus.STALEMATE;
            System.out.println("The game is over!!! It is a Stalemate!" + "\n" + GameStatus.STALEMATE);
            return this.gameStatus;
        }
        return this.gameStatus;
    }

}
