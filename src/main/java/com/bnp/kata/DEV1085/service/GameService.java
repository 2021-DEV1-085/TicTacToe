package com.bnp.kata.DEV1085.service;

import com.bnp.kata.DEV1085.object.Cell;

public class GameService {

    /**
     * Has player won
     *
     * @param cells  the cells
     * @param player player to check
     * @return true if player in parameter won
     */
    public static boolean hasPlayerWon(Cell[][] cells, char player) {
        PlayerWin playerWin = (cells1, player1) -> {
            if (cells1[0][0].getCharacter() == player && cells1[0][1].getCharacter() == player && cells1[0][2].getCharacter() == player)
                return true;
            else if (cells1[1][0].getCharacter() == player && cells1[1][1].getCharacter() == player && cells1[1][2].getCharacter() == player)
                return true;
            else if (cells1[2][0].getCharacter() == player && cells1[2][1].getCharacter() == player && cells1[2][2].getCharacter() == player)
                return true;
            else if (cells1[0][0].getCharacter() == player && cells1[1][0].getCharacter() == player && cells1[2][0].getCharacter() == player)
                return true;
            else if (cells1[0][1].getCharacter() == player && cells1[1][1].getCharacter() == player && cells1[2][1].getCharacter() == player)
                return true;
            else if (cells1[0][2].getCharacter() == player && cells1[1][2].getCharacter() == player && cells1[2][2].getCharacter() == player)
                return true;
            else if (cells1[0][0].getCharacter() == player && cells1[1][1].getCharacter() == player && cells1[2][2].getCharacter() == player)
                return true;
            else
                return cells1[0][2].getCharacter() == player && cells1[1][1].getCharacter() == player && cells1[2][0].getCharacter() == player;
        };
        return playerWin.hasPlayerWon(cells, player);
    }

    /**
     * is grid full
     *
     * @param cells the cells
     * @return true if the grid is full
     */
    public static boolean isGridFull(Cell[][] cells) {
        GridFull gridFull = cells1 -> cells1[0][0].getCharacter() != ' ' && cells1[0][1].getCharacter() != ' ' && cells1[0][2].getCharacter() != ' ' &&
                cells1[1][0].getCharacter() != ' ' && cells1[1][1].getCharacter() != ' ' && cells1[1][2].getCharacter() != ' ' &&
                cells1[2][0].getCharacter() != ' ' && cells1[2][1].getCharacter() != ' ' && cells1[2][2].getCharacter() != ' ';
        return gridFull.isGridFull(cells);
    }
}
