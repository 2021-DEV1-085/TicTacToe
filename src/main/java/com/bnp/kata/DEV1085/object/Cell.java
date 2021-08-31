package com.bnp.kata.DEV1085.object;

public class Cell {
    private char character;
    private Integer x;
    private Integer y;

    public Cell(char character) {
        this.character = character;
    }

    public Cell(char character, Integer x, Integer y) {
        this.character = character;
        this.x = x;
        this.y = y;
    }

    public Cell() {

    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }
}
