package com.bnp.kata.DEV1085.service;

import com.bnp.kata.DEV1085.object.Cell;

@FunctionalInterface
interface GridFull {
    boolean isGridFull(Cell[][] cells);
}