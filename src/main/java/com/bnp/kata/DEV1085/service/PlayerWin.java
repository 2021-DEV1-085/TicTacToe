package com.bnp.kata.DEV1085.service;

import com.bnp.kata.DEV1085.object.Cell;

@FunctionalInterface
interface PlayerWin {
    boolean hasPlayerWon(Cell[][] cells, char player);
}