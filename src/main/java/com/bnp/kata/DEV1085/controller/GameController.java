package com.bnp.kata.DEV1085.controller;

import com.bnp.kata.DEV1085.object.Cell;
import com.bnp.kata.DEV1085.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {

    enum ROUND {
        PLAYER_ONE,
        PLAYER_TWO
    }

    private Cell[][] cells;
    private static ROUND round = ROUND.PLAYER_ONE;
    private String message;

    GameController() {
        this.initCells();
    }

    void initCells() {
        this.cells = GameService.createEmptyCells();
    }

    @RequestMapping(value = "/inGame")
    public String play(@ModelAttribute("selectedCell") Cell selectedCell) {
        this.message = null;
        if (selectedCell != null) {
            Integer x = selectedCell.getX();
            Integer y = selectedCell.getY();
            if (round == ROUND.PLAYER_ONE) {
                this.cells[x][y].setCharacter('x');
                if (GameService.hasPlayerWon(cells, 'x'))
                    this.message = "Player 1 won";
                round = ROUND.PLAYER_TWO;
            } else {
                selectedCell.setCharacter('o');
                this.cells[x][y].setCharacter('o');
                if (GameService.hasPlayerWon(cells, 'o'))
                    this.message = "Player 2 won";
                round = ROUND.PLAYER_ONE;
            }
        }
        return "redirect:/play";
    }

    @GetMapping(value = "/play")
    public String beginGame(Model model) {
        if (this.message == null && GameService.isGridFull(this.cells))
            this.message = "No winner is this game";
        model.addAttribute("message", this.message);
        return "play";
    }

    @GetMapping(value = "/reset")
    public String reset() {
        this.initCells();
        this.message = null;
        return "redirect:/play";
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
