package com.marcoscassiani.rockpaperscissorsgame.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandShapeTest {

    int ROCK_NUMERIC_IDENTIFIER     = 0;
    int PAPER_NUMERIC_IDENTIFIER    = 1;
    int SCISSOR_NUMERIC_IDENTIFIER  = 2;

    @Test
    void getCode() {
        assertEquals(HandShape.ROCK.getCode()   , ROCK_NUMERIC_IDENTIFIER);
        assertEquals(HandShape.PAPER.getCode()  , PAPER_NUMERIC_IDENTIFIER);
        assertEquals(HandShape.SCISSOR.getCode(), SCISSOR_NUMERIC_IDENTIFIER);
    }

}