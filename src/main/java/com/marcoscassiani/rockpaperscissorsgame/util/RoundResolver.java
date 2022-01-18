package com.marcoscassiani.rockpaperscissorsgame.util;

import com.marcoscassiani.rockpaperscissorsgame.model.HandShape;
import com.marcoscassiani.rockpaperscissorsgame.model.Round;
import com.marcoscassiani.rockpaperscissorsgame.model.RoundResult;

/**
 * This class controls the game rules.
 * Contains the logic to determine the winner of a round.
 */
public class RoundResolver {

    /**
     * This matrix contains all the possible results in the game.
     * It's a double dimension array of 3x3 cells with the following rows and columns:
     *
     *  ________| ROCK       | PAPER        | SCISSOR       |
     *  ROCK    | TIE        | PAPER WINS   | ROCK WINS     |
     *  PAPER   | PAPER WINS | TIE          | SCISSOR WINS  |
     *  SCISSOR | ROCK WINS  | SCISSOR WINS | TIE           |
     *
     */
    private final static RoundResult[][] SOLUTION_MATRIX = {
        { RoundResult.DRAW   , RoundResult.P2_WINS, RoundResult.P1_WINS },
        { RoundResult.P1_WINS, RoundResult.DRAW   , RoundResult.P2_WINS },
        { RoundResult.P2_WINS, RoundResult.P1_WINS, RoundResult.DRAW     }
    };

    /**
     * @param optionPlayer1, hand shape selected by the first player.
     * @param optionPlayer2, hand shape selected by the second player.
     * @return a <code>Round<code/> object with the involved shapes and the result of the round.
     */
    public static Round resolve(HandShape optionPlayer1, HandShape optionPlayer2) {
        return new Round(optionPlayer1, optionPlayer2, SOLUTION_MATRIX[optionPlayer1.getCode()][ optionPlayer2.getCode()]);
    }

}