package com.bnp.kata.DEV1085.controller;

import com.bnp.kata.DEV1085.object.Cell;
import com.bnp.kata.DEV1085.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.logging.Logger;

@Controller
public class GameController {

    enum ROUND {
        PLAYER_ONE,
        PLAYER_TWO
    };

    private Cell[][] cells;
    //private Grid grid = new Grid();
    private static ROUND round = ROUND.PLAYER_ONE;
    private static Logger logger = Logger.getLogger("GameController");

    GameController() {
        this.initCells();
    }


    void initCells() {
        this.cells = GameService.createEmptyCells();
    }

    @RequestMapping(value = "/play")
    public String play(@ModelAttribute("selectedCell") Cell selectedCell, Model model) {
        System.out.println("Salut");
        if (selectedCell != null) {
            System.out.println("Value : " + selectedCell.getX() + selectedCell.getY());
//            this.cells = selectedCell;
            if (round == ROUND.PLAYER_ONE) {
                selectedCell.setCharacter('x');
                round = ROUND.PLAYER_TWO;
            }
            else {
                selectedCell.setCharacter('o');
                round = ROUND.PLAYER_ONE;
            }
        }
        //model.addAttribute("cells", this.cells);
        //this.displayCells();
        return "play";
    }

    private void displayCells() {
        Arrays.stream(this.cells[0]).forEach(cell -> logger.info(String.valueOf(cell.getCharacter())));
        Arrays.stream(this.cells[1]).forEach(cell -> logger.info(String.valueOf(cell.getCharacter())));
        Arrays.stream(this.cells[2]).forEach(cell -> logger.info(String.valueOf(cell.getCharacter())));
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
