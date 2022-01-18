package com.marcoscassiani.rockpaperscissorsgame.util;

import com.marcoscassiani.rockpaperscissorsgame.model.HandShape;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerBehaviourUtilsTest {

    @Test
    void getPlayerOneShape() {
        assertTrue(PlayerBehaviourUtils.getPlayerOneShape() instanceof HandShape);
    }

    @Test
    void getPlayerTwoShape() {
        assertEquals(PlayerBehaviourUtils.getPlayerTwoShape(), HandShape.ROCK);
    }
}