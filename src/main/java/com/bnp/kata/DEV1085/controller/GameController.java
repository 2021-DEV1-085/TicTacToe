package com.bnp.kata.DEV1085.controller;

import com.bnp.kata.DEV1085.object.Cell;
import com.bnp.kata.DEV1085.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
public class GameController {

    enum ROUND {
        PLAYER_ONE,
        PLAYER_TWO
    }

    private Cell[][] cells;
    private static ROUND round = ROUND.PLAYER_ONE;
    private static Logger logger = Logger.getLogger("GameController");

    GameController() {
        this.initCells();
    }

    void initCells() {
        this.cells = GameService.createEmptyCells();
    }

    @RequestMapping(value = "/inGame")
    public String play(@ModelAttribute("selectedCell") Cell selectedCell) {
        if (selectedCell != null) {
            Integer x = selectedCell.getX();
            Integer y = selectedCell.getY();
            if (round == ROUND.PLAYER_ONE) {
                this.cells[x][y].setCharacter('x');
                if (GameService.hasPlayerWon(cells, 'x'))
                {
                    System.out.println("Player 1 won");
                }
                round = ROUND.PLAYER_TWO;
            } else {
                selectedCell.setCharacter('o');
                this.cells[x][y].setCharacter('o');
                if (GameService.hasPlayerWon(cells, 'o'))
                {
                    System.out.println("Player 2 won");
                }
                round = ROUND.PLAYER_ONE;
            }
        }
        return "redirect:/play";
    }

    @GetMapping(value = "/play")
    public String beginGame() {
        return "play";
    }

    @ModelAttribute("firstLine")
    public Cell[] firstLine() {
        return this.cells[0];
    }

    @ModelAttribute("secondLine")
    public Cell[] secondLine() {
        return this.cells[1];
    }

    @ModelAttribute("thirdLine")
    public Cell[] thirdLine() {
        return this.cells[2];
    }
}
