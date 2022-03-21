package com.grandmasters.rookvbishop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RookvbishopApplicationTests {

	@Test
	void moveRookRightTwelveTimes() {
		Board board = new Board();
		int counter = 0;

		for (int i = 0; i < 12; i++) {
			board.rook.move(board, Game.Coin.Heads, i);
			counter++;
		}

		assertThat(board.rook.currentSquare).isEqualTo(board.getSquare(7,2));
		assertThat(counter).isEqualTo(12);
	}

	@Test
	void moveRookUpTwelveTimes() {
		Board board = new Board();
		int counter = 0;

		for (int i = 0; i < 12; i++) {
			board.rook.move(board, Game.Coin.Heads, i);
			counter++;
		}

		assertThat(board.rook.currentSquare).isEqualTo(board.getSquare(7,2));
		assertThat(counter).isEqualTo(12);
	}

	@Test
	void play1000RookVsBishopGames() {
		int bishopWin = 0;
		int rookWin = 0;
		int stalemate = 0;
		for (int i = 0; i < 1000; i++) {
			RookVsBishop game = new RookVsBishop();
			game.playGame();
			switch (game.gameStatus) {
				case WHITE_BISHOP_WINS:
					bishopWin++;
					break;
				case BLACK_ROOK_WINS:
					rookWin++;
					break;
				case STALEMATE:
					stalemate++;
					break;
			}
		}
		System.out.println("bishop wins: " + bishopWin + ", rook wins: "+ rookWin + ", stalemates: " + stalemate);
	}

	@Test
	void play1000RookVsLiberatedBishopGames() {
		int bishopWin = 0;
		int rookWin = 0;
		int stalemate = 0;
		for (int i = 0; i < 1000; i++) {
			RookVsLiberatedBishop rvlb = new RookVsLiberatedBishop();
			GameStatus outcome = rvlb.playGame();
			switch (outcome) {
				case WHITE_BISHOP_WINS:
					bishopWin++;
					break;
				case BLACK_ROOK_WINS:
					rookWin++;
					break;
				case STALEMATE:
					stalemate++;
					break;
			}
		}
		System.out.println("bishop wins: " + bishopWin + ", rook wins: "+ rookWin + ", stalemates: " + stalemate);
	}
}
