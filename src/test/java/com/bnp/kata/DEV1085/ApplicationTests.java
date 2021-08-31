package com.bnp.kata.DEV1085;

import com.bnp.kata.DEV1085.controller.GameController;
import com.bnp.kata.DEV1085.object.Cell;
import com.bnp.kata.DEV1085.service.GameService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
        Assert.notNull(GameController.class, "GameController is not initialized");
        Assert.notNull(Cell.class, "Cell class is not initialized");
    }



    @Test
    void isGameContinuing() {
        Cell[][] cells = GameService.createEmptyCells();

        Assert.isTrue(GameService.isGridFull(cells), "The game should continue");

        cells[0][0].setCharacter('x');
        cells[0][2].setCharacter('o');
        cells[1][1].setCharacter('x');
        cells[2][2].setCharacter('o');
        Assert.isTrue(GameService.isGridFull(cells), "The game should continue");
    }

    @Test
    void isGridFullWithoutWinner() {
        Cell[][] cells = GameService.createEmptyCells();

        cells[0][0].setCharacter('o');
        cells[0][1].setCharacter('x');
        cells[0][2].setCharacter('o');
        cells[1][0].setCharacter('x');
        cells[1][1].setCharacter('x');
        cells[1][2].setCharacter('o');
        cells[2][0].setCharacter('x');
        cells[2][1].setCharacter('o');
        cells[2][2].setCharacter('x');

        Assert.isTrue(GameService.isGridFull(cells) && !GameService.hasPlayerWon(cells, 'x') && !GameService.hasPlayerWon(cells, 'o'), "The game should end without winner");
    }

    @Test
    void hasPlayerOneWon() {
        Cell[][] cells = GameService.createEmptyCells();

        cells[0][0].setCharacter('o');
        cells[0][1].setCharacter('x');
        cells[0][2].setCharacter('o');
        cells[1][0].setCharacter('x');
        cells[1][1].setCharacter('x');
        cells[1][2].setCharacter('x');
        cells[2][0].setCharacter('0');
        cells[2][1].setCharacter('x');
        cells[2][2].setCharacter('0');

        Assert.isTrue(GameService.isGridFull(cells) && GameService.hasPlayerWon(cells, 'x') && !GameService.hasPlayerWon(cells, 'o'), "Player 1 should win");
    }

    @Test
    void hasPlayerTwoWon() {
        Cell[][] cells = GameService.createEmptyCells();

        cells[0][0].setCharacter('x');
        cells[0][1].setCharacter('x');
        cells[0][2].setCharacter('o');
        cells[1][0].setCharacter('x');
        cells[1][1].setCharacter('o');
        cells[1][2].setCharacter('x');
        cells[2][0].setCharacter('o');
        cells[2][1].setCharacter('x');
        cells[2][2].setCharacter('o');

        Assert.isTrue(GameService.isGridFull(cells) && !GameService.hasPlayerWon(cells, 'x') && GameService.hasPlayerWon(cells, 'o'), "Player 2 should win");
    }
}
