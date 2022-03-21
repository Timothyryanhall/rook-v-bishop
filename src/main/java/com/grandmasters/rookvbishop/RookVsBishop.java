package com.grandmasters.rookvbishop;

public class RookVsBishop extends Game {
    private final Board board;

    public RookVsBishop() {
        this.board = new Board();
    }

    @Override
    public GameStatus playGame() {
        for (int i = 0; i < 15; i++) {
            System.out.println("------------- Turn " + turn + " -------------");
            Coin coin = super.flip();
            int dice = super.rollDice();

            Square newRookSquare = board.rook.move(board, coin, dice);

            if (rookLandsOnBishopSquare(board, newRookSquare)) {
                finishGame(GameStatus.BLACK_ROOK_WINS, Rook.ROOK, Bishop.BISHOP);
                break;
            }
            if (bishopCapturesRook(board, newRookSquare)) {
                finishGame(GameStatus.WHITE_BISHOP_WINS, Bishop.BISHOP, Rook.ROOK);
                break;
            }

            turn++;
        }

        if (this.gameStatus == GameStatus.ACTIVE) {
            this.gameStatus = GameStatus.BLACK_ROOK_WINS;
            System.out.println("The game is over!!! The Rook has survived 15 rounds!" + "\n" + GameStatus.BLACK_ROOK_WINS);
        }
        return this.gameStatus;
    }

    private boolean rookLandsOnBishopSquare(Board board, Square square) {
        return square == board.getSquare(2, 2);
    }

    private boolean bishopCapturesRook(Board board, Square square) {
        return board.bishopSquares.contains(square);
    }
}
