package com.marcoscassiani.rockpaperscissorsgame.util;

import com.marcoscassiani.rockpaperscissorsgame.model.HandShape;

import java.util.Random;

/**
 * This class simulates the players behavior
 */
public class PlayerBehaviourUtils {

    /**
     * Player ONE will always choose randomly.
     * @return <code>HandShape</code>
     */
    public static HandShape getPlayerOneShape() {
        return HandShape.values()[new Random().nextInt(3)];
    }

    /**
     * Player TWO will always choose ROCK shape.
     * @return <code>HandShape.ROCK</code>
     */
    public static HandShape getPlayerTwoShape() {
        return HandShape.ROCK;
    }
}